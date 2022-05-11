package com.drxgb.javafxutils;

import java.io.IOException;
import java.net.URL;
import java.util.function.Consumer;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

/**
 * Responsável por gerar uma janela do JavaFX de uma maneira mais simplificada,
 * poupando algumas linhas de código em seu projeto.
 * @author Dr.XGB
 * @version 1.7.1
 */
public abstract class StageFactory 
{	
	/*
	 * ===========================================================
	 * 			*** MÉTODOS PÚBLICOS ***
	 * ===========================================================
	 */
	
	/**
	 * Abre uma janela do JavaFX.
	 * @param <T> Controlador da view a ser carregada.
	 * @param owner Janela pai desta nova janela.
	 * @param fxmlPath Caminho do FXML para carregar a cena da janela.
	 * @param title Título da janela.
	 * @param modal Verificar se janela é uma modal. @code{true} se a janela será uma modal ou @code{false} se for uma janela comum.
	 * @param resizable A janela será redimensionada se o argumento for @{code}, ou @code{false} para janelas de tamanho fixo.
	 * @param fnInitialize Função que será chamada no momento em que a view for carregada.
	 * @return A própria janela do tipo @code{Stage}.
	 * @throws IOException Caso o caminho do FXML for inválido, uma exceção será lançada.
	 */
	public static <T> Stage openWindow(
			Window owner, 
			URL fxmlPath, 
			String title, 
			boolean modal, 
			boolean resizable,
			Consumer<T> fnInitialize
		) throws IOException
	{
		Scene scene = createScene(fxmlPath, fnInitialize);		
		Stage stage = createStage(modal);		
		if (scene != null)
		{
			if (owner != null && owner.getScene() != null)
				scene.getStylesheets().addAll(owner.getScene().getStylesheets());
			stage.setScene(scene);
		}
		stage.setTitle(title);
		stage.initOwner(owner);
		stage.setResizable(resizable);
		stage.showAndWait();
		return stage;
	}
	
	
	/**
	 * Abre uma janela do JavaFX.
	 * @param <T> Controlador da view a ser carregada.
	 * @param owner Janela pai desta nova janela.
	 * @param fxmlPath Caminho do FXML para carregar a cena da janela.
	 * @param title Título da janela.
	 * @param modal Verificar se janela é uma modal. @code{true} se a janela será uma modal ou @code{false} se for uma janela comum.
	 * @param resizable A janela será redimensionada se o argumento for @{code}, ou @code{false} para janelas de tamanho fixo.
	 * @return A própria janela do tipo @code{Stage}.
	 * @throws IOException Caso o caminho do FXML for inválido, uma exceção será lançada.
	 */
	public static <T> Stage openWindow(
			Window owner, 
			URL fxmlPath, 
			String title, 
			boolean modal, 
			boolean resizable
		) throws IOException
	{
		return openWindow(owner, fxmlPath, title, modal, resizable, null);
	}
	
	
	/**
	 * Abre uma janela do JavaFX.
	 * @param <T> Controlador da view a ser carregada.
	 * @param owner Janela pai desta nova janela.
	 * @param fxmlPath Caminho do FXML para carregar a cena da janela.
	 * @param title Título da janela.
	 * @param modal Verificar se janela é uma modal. @code{true} se a janela será uma modal ou @code{false} se for uma janela comum.
	 * @return A própria janela do tipo @code{Stage}.
	 * @throws IOException Caso o caminho do FXML for inválido, uma exceção será lançada.
	 */
	public static <T> Stage openWindow(
			Window owner, 
			URL fxmlPath, 
			String title, 
			boolean modal
		) throws IOException
	{
		return openWindow(owner, fxmlPath, title, modal, false, null);
	}
	
	
	/**
	 * Abre uma janela do JavaFX.
	 * @param <T> Controlador da view a ser carregada.
	 * @param owner Janela pai desta nova janela.
	 * @param fxmlPath Caminho do FXML para carregar a cena da janela.
	 * @param title Título da janela.
	 * @return A própria janela do tipo @code{Stage}.
	 * @throws IOException Caso o caminho do FXML for inválido, uma exceção será lançada.
	 */
	public static <T> Stage openWindow(
			Window owner, 
			URL fxmlPath, 
			String title
		) throws IOException
	{
		return openWindow(owner, fxmlPath, title, false, false, null);
	}
	
	
	/*
	 * ===========================================================
	 * 			*** MÉTODOS PRIVADOS ***
	 * ===========================================================
	 */
	
	/**
	 * Cria uma nova cena.
	 * @param <T> Tipo de argumento da função no {@code Consumer}
	 * @param fxmlPath Caminho do FXML para carregar a cena da janela.
	 * @param fn Função que será chamada no momento em que a view for carregada.
	 * @return Uma nova cena carregada do FXML. Se o caminho for inválido, 
	 * o sistema retornará {@code null}
	 * @throws IOException Se o caminho do FXML for inválido.
	 */
	private static <T> Scene createScene(URL fxmlPath, Consumer<T> fn) throws IOException
	{
		Scene scene = null;
		if (fxmlPath != null)
		{
			FXMLLoader loader = new FXMLLoader(fxmlPath);
			Parent root = (Parent) loader.load();
			scene = new Scene(root);
			scene.setUserData(loader);
			if (fn != null)
			{
				T controller = loader.getController();
				fn.accept(controller);
			}
		}
		return scene;
	}
	
	
	/**
	 * Cria uma nova janela.
	 * @param modal Tipo da janela. {@code true} para modal e {@code false}
	 * uma janela simples.
	 * @return Uma nova janela.
	 */
	private static Stage createStage(boolean modal)
	{
		Stage stage = null;
		if (modal)
		{
			stage = new Stage(StageStyle.UTILITY);
			stage.initModality(Modality.APPLICATION_MODAL);
		}
		else
			stage = new Stage();
		return stage;
	}
}
