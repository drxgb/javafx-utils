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
 * Respons�vel por gerar uma janela do JavaFX de uma maneira mais simplificada,
 * poupando algumas linhas de c�digo em seu projeto.
 * @author Dr.XGB
 * @version 1.5
 *
 */
public abstract class StageFactory {
	
	/**
	 * Abre uma janela do JavaFX.
	 * @param <T> Controlador da view a ser carregada.
	 * @param owner Janela pai desta nova janela.
	 * @param fxmlPath Caminho do FXML para carregar a cena da janela.
	 * @param title T�tulo da janela.
	 * @param modal Verificar se janela � uma modal. @code{true} se a janela ser� uma modal ou @code{false} se for uma janela comum.
	 * @param resizable A janela ser� redimensionada se o argumento for @{code}, ou @code{false} para janelas de tamanho fixo.
	 * @param fnInitialize Fun��o que ser� chamada no momento em que a view for carregada.
	 * @return A pr�pria janela do tipo @code{Stage}.
	 * @throws IOException Caso o caminho do FXML for inv�lido, uma exce��o ser� lan�ada.
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
		Scene scene = null;
		if (fxmlPath != null)
		{
			FXMLLoader loader = new FXMLLoader(fxmlPath);
			Parent root = (Parent) loader.load();
			scene = new Scene(root);
			if (fnInitialize != null)
			{
				T controller = loader.getController();
				fnInitialize.accept(controller);
			}
		}
		Stage stage = null;
		if (modal)
		{
			stage = new Stage(StageStyle.UTILITY);
			stage.initModality(Modality.APPLICATION_MODAL);
		}
		else
			stage = new Stage();
		stage.setScene(scene);
		stage.setTitle(title);
		stage.initOwner(owner);
		stage.setResizable(resizable);
		stage.showAndWait();
		return stage;
	}
	
}
