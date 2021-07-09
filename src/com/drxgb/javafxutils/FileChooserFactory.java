package com.drxgb.javafxutils;

import java.io.File;
import java.util.List;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Window;

public abstract class FileChooserFactory {

	public static File openSingleFile(Window window, String title, String description, String initialPath, List<String> extensions) {		
		return generateFileChooser(title, description, initialPath, extensions).showOpenDialog(window);
	}
	
	public static File saveFile(Window window, String title, String description, String initialPath, List<String> extensions) {
		return generateFileChooser(title, description, initialPath, extensions).showSaveDialog(window);
	}
	
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
