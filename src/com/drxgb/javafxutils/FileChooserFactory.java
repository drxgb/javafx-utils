package com.drxgb.javafxutils;

import java.io.File;
import java.util.List;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Window;

/**
 * Classe abstrata responsável por facilitar a chamada do {@code FileChooser}.
 * @author Dr.XGB
 * @version 1.5
 */
public abstract class FileChooserFactory {

	/**
	 * Chama a janela para abrir um único arquivo.
	 * @param window A janela pai onde será carregada esta janela.
	 * @param title Título da janela.
	 * @param description Conteúdo para descrever o tipo de arquivo que será carregado.
	 * @param initialPath Caminho onde será inicializado ao carregar esta janela.
	 * @param extensions Lista de extensões suportadas.
	 * @return O caminho do arquivo a ser carregado.
	 */
	public static File openSingleFile(Window window, String title, String description, String initialPath, List<String> extensions) {		
		return generateFileChooser(title, description, initialPath, extensions).showOpenDialog(window);
	}
	
	
	/**
	 * Chama a janela para salvar um arquivo.
	 * @param window A janela pai onde será carregada esta janela.
	 * @param title Título da janela.
	 * @param description Conteúdo para descrever o tipo de arquivo que será salvo.
	 * @param initialPath Caminho onde será inicializado ao carregar esta janela.
	 * @param extensions Lista de extensões suportadas.
	 * @return O caminho do arquivo a ser salvo.
	 */
	public static File saveFile(Window window, String title, String description, String initialPath, List<String> extensions) {
		return generateFileChooser(title, description, initialPath, extensions).showSaveDialog(window);
	}
	
	
	/**
	 * Método auxiliar para gerar a janela tanto para abrir quanto para salvar arquivos.
	 * @param title Título da janela.
	 * @param description Conteúdo para descrever o tipo de arquivo que será carregado/salvo.
	 * @param initialPath Caminho onde será inicializado ao carregar esta janela.
	 * @param extensions Lista de extensões suportadas.
	 * @return Uma instância de {@code FileChooser} para aparecer na tela do usuário.
	 */
	private static FileChooser generateFileChooser(String title, String description, String initialPath, List<String> extensions) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle(title);
		fileChooser.getExtensionFilters().add(new ExtensionFilter(description, extensions));
		if (initialPath != null) {
			File file = new File(initialPath);
			fileChooser.setInitialDirectory((file.isDirectory() ? file : file.getParentFile()));
		}
		return fileChooser;
	}
	
}
