package com.drxgb.util.javafx;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * Classe abstrata utilit�ria respons�vel por mostrar caixas de di�logo
 * em um projeto JavaFX de forma mais pr�tica.
 * @author Dr.XGB
 * @version 1.1
 */
public abstract class Dialog {
	
	/*
	 * ===========================================================
	 * 				*** M�TODOS P�BLICOS ***
	 * ===========================================================
	 */
	
	/**
	 * Mostra um alerta de acordo com as configura��es dadas por argumentos.
	 * @param stage A janela que ser� pai do alerta
	 * @param type Tipo de janela a ser mostrada
	 * @param title T�tulo da janela
	 * @param msg Mensagem no contexto da janela
	 * @param header Cabe�alho da janela
	 * @param buttons Um array de bot�es a serem inseridos no alerta
	 * @return O bot�o selecionado ao fechar o alerta
	 */
	public static Optional<ButtonType> show(
			Stage stage,
			AlertType type,
			String title,
			String msg,
			String header,
			ButtonType... buttons
	) {
		try {
			if (type == null)
				type = AlertType.INFORMATION;
			Alert alert = new Alert(type);
			alert.initOwner(stage);
			alert.setTitle(title);
			alert.setContentText(msg);
			alert.setHeaderText(header);
			if (buttons.length > 0) {
				alert.getButtonTypes().clear();
				for (ButtonType btn : buttons) {
					alert.getButtonTypes().add(btn);
				}
			}
			return alert.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Mostra um alerta de acordo com as configura��es dadas por argumentos
	 * somente com o bot�o {@code OK}.
	 * @param stage A janela que ser� pai do alerta
	 * @param type Tipo de janela a ser mostrada
	 * @param title T�tulo da janela
	 * @param msg Mensagem no contexto da janela
	 * @param header Cabe�alho da janela
	 * @return O bot�o selecionado ao fechar o alerta
	 */
	public static Optional<ButtonType> show(
			Stage stage,
			AlertType type,
			String title,
			String msg,
			String header
	) {
		return show(stage, type, title, msg, header, new ButtonType[0]);
	}
	
	/**
	 * Mostra um alerta de acordo com as configura��es dadas por argumentos
	 * somente com o bot�o {@code OK} e sem cabe�alho.
	 * @param stage A janela que ser� pai do alerta
	 * @param type Tipo de janela a ser mostrada
	 * @param title T�tulo da janela
	 * @param msg Mensagem no contexto da janela
	 * @return O bot�o selecionado ao fechar o alerta
	 */
	public static Optional<ButtonType> show(
			Stage stage,
			AlertType type,
			String title,
			String msg
	) {
		return show(stage, type, title, msg, null);
	}
	
	/**
	 * Mostra um alerta de acordo com as configura��es dadas por argumentos
	 * somente com o bot�o {@code OK}, sem cabe�alho e sem uma janela pai.
	 * @param type Tipo de janela a ser mostrada
	 * @param title T�tulo da janela
	 * @param msg Mensagem no contexto da janela
	 * @return O bot�o selecionado ao fechar o alerta
	 */
	public static Optional<ButtonType> show(
			AlertType type,
			String title,
			String msg
	) {
		return show(null, type, title, msg, null);
	}
	
	/**
	 * <p>Mostra um alerta de acordo com as configura��es dadas por argumentos
	 * somente com o bot�o {@code OK}, sem cabe�alho e com tipo de alerta padr�o.</p>
	 * <p>No caso do alerta padr�o, ser� escolhido o {@code AlertType.INFORMATION}.</p>
	 * @param stage A janela que ser� pai do alerta
	 * @param title T�tulo da janela
	 * @param msg Mensagem no contexto da janela
	 * @return O bot�o selecionado ao fechar o alerta
	 */
	public static Optional<ButtonType> show(
			Stage stage,
			String title,
			String msg
	) {
		return show(stage, null, title, msg, null);
	}
	
	/**
	 * Mostra um alerta de acordo com as configura��es dadas por argumentos
	 * somente com o bot�o {@code OK}, sem cabe�alho, sem uma janela pai 
	 * e com tipo de alerta padr�o.
	 * <p>No caso do alerta padr�o, ser� escolhido o {@code AlertType.INFORMATION}.</p>
	 * @param title T�tulo da janela
	 * @param msg Mensagem no contexto da janela
	 * @return O bot�o selecionado ao fechar o alerta
	 */
	public static Optional<ButtonType> show(
			String title,
			String msg
	) {
		return show((Stage) null, null, title, msg, null);
	}
	
}
