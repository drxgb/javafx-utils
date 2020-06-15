package drxgb.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * Classe abstrata utilit�ria respons�vel por mostrar caixas de di�logo
 * em um projeto JavaFX de forma mais pr�tica.
 * @author Dr.XGB
 * @version 1.0
 */
public abstract class Dialog {
	
	/*
	 * ===========================================================
	 * 				*** M�TODOS P�BLICOS ***
	 * ===========================================================
	 */

	/**
	 * Mostra uma simples caixa de di�logo de informa��o.
	 * @param stage A janela onde ser� mostrada a caixa de di�logo.
	 * Caso a janela seja fornecida pelo argumento, a mesma ficar� travada
	 * at� que a caixa de di�logo seja fechada. Se o valor do argumento for
	 * <code>null</code>, a caixa de di�logo n�o travar� nenhuma janela.
	 * @param title O t�tulo da caixa de di�logo.
	 * @param msg O conte�do da caixa de di�logo.
	 */
	public static void showInfoDialog(Stage stage, String title, String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);
		mountAlert(alert, stage, title, msg);
		alert.show();
	}
	
	/**
	 * Mostra uma simples caixa de di�logo de informa��o solta, ou seja,
	 * n�o ter� nenhuma janela para ser travada. Em outras palavras, o atributo
	 * <code>owner</code> da classe <code>Alert</code> ter� seu valor <code>null</code>.
	 * @param title O t�tulo da caixa de di�logo.
	 * @param msg O conte�do da caixa de di�logo.
	 */
	public static void showInfoDialog(String title, String msg) {
		showInfoDialog(null, title, msg);
	}
	
	/**
	 * Mostra uma simples caixa de di�logo de informa��o sem travar
	 * nenhuma janela e com um t�tulo padr�o.
	 * @param msg O conte�do da caixa de di�logo.
	 */
	public static void showInfoDialog(String msg) {
		showInfoDialog(null, "Info", msg);
	}
	
	/**
	 * Mostra uma simples caixa de di�logo de aviso.
	 * @param stage A janela onde ser� mostrada a caixa de di�logo.
	 * Caso a janela seja fornecida pelo argumento, a mesma ficar� travada
	 * at� que a caixa de di�logo seja fechada. Se o valor do argumento for
	 * <code>null</code>, a caixa de di�logo n�o travar� nenhuma janela.
	 * @param stage A janela onde ser� mostrada a caixa de di�logo.
	 * Caso a janela seja fornecida pelo argumento, a mesma ficar� travada
	 * at� que a caixa de di�logo seja fechada. Se o valor do argumento for
	 * <code>null</code>, a caixa de di�logo n�o travar� nenhuma janela.
	 * @param title O t�tulo da caixa de di�logo.
	 * @param msg O conte�do da caixa de di�logo.
	 */
	public static void showWarningDialog(Stage stage, String title, String msg) {
		Alert alert = new Alert(AlertType.WARNING);
		mountAlert(alert, stage, title, msg);
		alert.show();
	}
	
	/**
	 * Mostra uma simples caixa de di�logo de aviso solta, ou seja,
	 * n�o ter� nenhuma janela para ser travada. Em outras palavras, o atributo
	 * <code>owner</code> da classe <code>Alert</code> ter� seu valor <code>null</code>.
	 * @param title O t�tulo da caixa de di�logo.
	 * @param msg O conte�do da caixa de di�logo.
	 */
	public static void showWarningDialog(String title, String msg) {
		showWarningDialog(null, title, msg);
	}
	
	/**
	 * Mostra uma simples caixa de di�logo de aviso sem travar
	 * nenhuma janela e com um t�tulo padr�o.
	 * @param msg O conte�do da caixa de di�logo.
	 */
	public static void showWarningDialog(String msg) {
		showWarningDialog(null, "Warning", msg);
	}
	
	/**
	 * Mostra uma simples caixa de di�logo de erro.
	 * @param stage A janela onde ser� mostrada a caixa de di�logo.
	 * Caso a janela seja fornecida pelo argumento, a mesma ficar� travada
	 * at� que a caixa de di�logo seja fechada. Se o valor do argumento for
	 * <code>null</code>, a caixa de di�logo n�o travar� nenhuma janela.
	 * @param title O t�tulo da caixa de di�logo.
	 * @param msg O conte�do da caixa de di�logo.
	 */
	public static void showErrorDialog(Stage stage, String title, String msg) {
		Alert alert = new Alert(AlertType.ERROR);
		mountAlert(alert, stage, title, msg);
		alert.show();
	}
	
	/**
	 * Mostra uma simples caixa de di�logo de erro solta, ou seja,
	 * n�o ter� nenhuma janela para ser travada. Em outras palavras, o atributo
	 * <code>owner</code> da classe <code>Alert</code> ter� seu valor <code>null</code>.
	 * @param title O t�tulo da caixa de di�logo.
	 * @param msg O conte�do da caixa de di�logo.
	 */
	public static void showErrorDialog(String title, String msg) {
		showErrorDialog(null, title, msg);
	}
	
	/**
	 * Mostra uma simples caixa de di�logo de erro sem travar
	 * nenhuma janela e com um t�tulo padr�o.
	 * @param msg O conte�do da caixa de di�logo.
	 */
	public static void showErrorDialog(String msg) {
		showErrorDialog(null, "Error", msg);
	}
	
	
	
	/*
	 * ===========================================================
	 * 				*** M�TODOS PRIVADOS ***
	 * ===========================================================
	 */
	
	/**
	 * Monta a caixa de di�logo de acordo com os argumentos dados.
	 * @param alert A inst�ncia de <code>Alert</code>.
	 * @param stage A inst�ncia de <code>Stage</code> que ser� a janela travada
	 * pela caixa de di�logo.
	 * @param title O t�tulo da caixa de di�logo.
	 * @param msg O conte�do da caixa de di�logo.
	 */
	private static void mountAlert(Alert alert, Stage stage, String title, String msg) {
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(msg);
		alert.initOwner(stage);
	}
	
}
