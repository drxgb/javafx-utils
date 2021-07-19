package com.drxgb.javafxutils;

import java.io.File;
import java.util.List;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Window;

/**
 * Classe abstrata respons�vel por facilitar a chamada do {@code FileChooser}.
 * @author Dr.XGB
 * @version 1.5
 */
public abstract class FileChooserFactory {

	/**
	 * Chama a janela para abrir um �nico arquivo.
	 * @param window A janela pai onde ser� carregada esta janela.
	 * @param title T�tulo da janela.
	 * @param description Conte�do para descrever o tipo de arquivo que ser� carregado.
	 * @param initialPath Caminho onde ser� inicializado ao carregar esta janela.
	 * @param extensions Lista de extens�es suportadas.
	 * @return O caminho do arquivo a ser carregado.
	 */
	public static File openSingleFile(Window window, String title, String description, String initialPath, List<String> extensions) {		
		return generateFileChooser(title, description, initialPath, extensions).showOpenDialog(window);
	}
	
	
	/**
	 * Chama a janela para salvar um arquivo.
	 * @param window A janela pai onde ser� carregada esta janela.
	 * @param title T�tulo da janela.
	 * @param description Conte�do para descrever o tipo de arquivo que ser� salvo.
	 * @param initialPath Caminho onde ser� inicializado ao carregar esta janela.
	 * @param extensions Lista de extens�es suportadas.
	 * @return O caminho do arquivo a ser salvo.
	 */
	public static File saveFile(Window window, String title, String description, String initialPath, List<String> extensions) {
		return generateFileChooser(title, description, initialPath, extensions).showSaveDialog(window);
	}
	
	
	/**
	 * M�todo auxiliar para gerar a janela tanto para abrir quanto para salvar arquivos.
	 * @param title T�tulo da janela.
	 * @param description Conte�do para descrever o tipo de arquivo que ser� carregado/salvo.
	 * @param initialPath Caminho onde ser� inicializado ao carregar esta janela.
	 * @param extensions Lista de extens�es suportadas.
	 * @return Uma inst�ncia de {@code FileChooser} para aparecer na tela do usu�rio.
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
