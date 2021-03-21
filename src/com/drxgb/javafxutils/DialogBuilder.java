package com.drxgb.util.javafx;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * Classe abstrata utilitária responsável por mostrar caixas de diálogo
 * em um projeto JavaFX de forma mais prática.
 * @author Dr.XGB
 * @version 1.1
 */
public abstract class Dialog {
	
	/*
	 * ===========================================================
	 * 				*** MÉTODOS PÚBLICOS ***
	 * ===========================================================
	 */
	
	/**
	 * Mostra um alerta de acordo com as configurações dadas por argumentos.
	 * @param stage A janela que será pai do alerta
	 * @param type Tipo de janela a ser mostrada
	 * @param title Título da janela
	 * @param msg Mensagem no contexto da janela
	 * @param header Cabeçalho da janela
	 * @param buttons Um array de botões a serem inseridos no alerta
	 * @return O botão selecionado ao fechar o alerta
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
	 * Mostra um alerta de acordo com as configurações dadas por argumentos
	 * somente com o botão {@code OK}.
	 * @param stage A janela que será pai do alerta
	 * @param type Tipo de janela a ser mostrada
	 * @param title Título da janela
	 * @param msg Mensagem no contexto da janela
	 * @param header Cabeçalho da janela
	 * @return O botão selecionado ao fechar o alerta
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
	 * Mostra um alerta de acordo com as configurações dadas por argumentos
	 * somente com o botão {@code OK} e sem cabeçalho.
	 * @param stage A janela que será pai do alerta
	 * @param type Tipo de janela a ser mostrada
	 * @param title Título da janela
	 * @param msg Mensagem no contexto da janela
	 * @return O botão selecionado ao fechar o alerta
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
	 * Mostra um alerta de acordo com as configurações dadas por argumentos
	 * somente com o botão {@code OK}, sem cabeçalho e sem uma janela pai.
	 * @param type Tipo de janela a ser mostrada
	 * @param title Título da janela
	 * @param msg Mensagem no contexto da janela
	 * @return O botão selecionado ao fechar o alerta
	 */
	public static Optional<ButtonType> show(
			AlertType type,
			String title,
			String msg
	) {
		return show(null, type, title, msg, null);
	}
	
	/**
	 * <p>Mostra um alerta de acordo com as configurações dadas por argumentos
	 * somente com o botão {@code OK}, sem cabeçalho e com tipo de alerta padrão.</p>
	 * <p>No caso do alerta padrão, será escolhido o {@code AlertType.INFORMATION}.</p>
	 * @param stage A janela que será pai do alerta
	 * @param title Título da janela
	 * @param msg Mensagem no contexto da janela
	 * @return O botão selecionado ao fechar o alerta
	 */
	public static Optional<ButtonType> show(
			Stage stage,
			String title,
			String msg
	) {
		return show(stage, null, title, msg, null);
	}
	
	/**
	 * Mostra um alerta de acordo com as configurações dadas por argumentos
	 * somente com o botão {@code OK}, sem cabeçalho, sem uma janela pai 
	 * e com tipo de alerta padrão.
	 * <p>No caso do alerta padrão, será escolhido o {@code AlertType.INFORMATION}.</p>
	 * @param title Título da janela
	 * @param msg Mensagem no contexto da janela
	 * @return O botão selecionado ao fechar o alerta
	 */
	public static Optional<ButtonType> show(
			String title,
			String msg
	) {
		return show((Stage) null, null, title, msg, null);
	}
	
}
