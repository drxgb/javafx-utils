package com.drxgb.javafxutils;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public abstract class StageFactory {
	
	public static Stage openWindow(Window owner, URL fxmlPath, String title, boolean modal, boolean resizable) throws IOException
	{
		Scene scene = null;
		if (fxmlPath != null)
		{
			FXMLLoader loader = new FXMLLoader(fxmlPath);
			Parent root = (Parent) loader.load();
			scene = new Scene(root);
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
	
	public static Stage openWindow(Window owner, URL fxmlPath, String title, boolean resizable) throws IOException
	{
		return openWindow(owner, fxmlPath, title, false, resizable);
	}
	
	public static Stage openWindow(Window owner, String title, boolean resizable) throws IOException
	{
		return openWindow(owner, null, title, false, resizable);
	}
	
	public static Stage openWindow(URL fxmlPath, String title, boolean resizable) throws IOException
	{
		return openWindow(null, fxmlPath, title, false, resizable);
	}
	
	public static Stage openWindow(String title, boolean resizable) throws IOException
	{
		return openWindow(null, null, title, false, resizable);
	}
	
	public static Stage openWindow(Window owner, String title, boolean modal, boolean resizable) throws IOException
	{
		return openWindow(owner, null, title, modal, resizable);
	}
	
}
