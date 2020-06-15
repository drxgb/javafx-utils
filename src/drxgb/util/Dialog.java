package drxgb.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * Classe abstrata utilitária responsável por mostrar caixas de diálogo
 * em um projeto JavaFX de forma mais prática.
 * @author Dr.XGB
 * @version 1.0
 */
public abstract class Dialog {
	
	/*
	 * ===========================================================
	 * 				*** MÉTODOS PÚBLICOS ***
	 * ===========================================================
	 */

	/**
	 * Mostra uma simples caixa de diálogo de informação.
	 * @param stage A janela onde será mostrada a caixa de diálogo.
	 * Caso a janela seja fornecida pelo argumento, a mesma ficará travada
	 * até que a caixa de diálogo seja fechada. Se o valor do argumento for
	 * <code>null</code>, a caixa de diálogo não travará nenhuma janela.
	 * @param title O título da caixa de diálogo.
	 * @param msg O conteúdo da caixa de diálogo.
	 */
	public static void showInfoDialog(Stage stage, String title, String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);
		mountAlert(alert, stage, title, msg);
		alert.show();
	}
	
	/**
	 * Mostra uma simples caixa de diálogo de informação solta, ou seja,
	 * não terá nenhuma janela para ser travada. Em outras palavras, o atributo
	 * <code>owner</code> da classe <code>Alert</code> terá seu valor <code>null</code>.
	 * @param title O título da caixa de diálogo.
	 * @param msg O conteúdo da caixa de diálogo.
	 */
	public static void showInfoDialog(String title, String msg) {
		showInfoDialog(null, title, msg);
	}
	
	/**
	 * Mostra uma simples caixa de diálogo de informação sem travar
	 * nenhuma janela e com um título padrão.
	 * @param msg O conteúdo da caixa de diálogo.
	 */
	public static void showInfoDialog(String msg) {
		showInfoDialog(null, "Info", msg);
	}
	
	/**
	 * Mostra uma simples caixa de diálogo de aviso.
	 * @param stage A janela onde será mostrada a caixa de diálogo.
	 * Caso a janela seja fornecida pelo argumento, a mesma ficará travada
	 * até que a caixa de diálogo seja fechada. Se o valor do argumento for
	 * <code>null</code>, a caixa de diálogo não travará nenhuma janela.
	 * @param stage A janela onde será mostrada a caixa de diálogo.
	 * Caso a janela seja fornecida pelo argumento, a mesma ficará travada
	 * até que a caixa de diálogo seja fechada. Se o valor do argumento for
	 * <code>null</code>, a caixa de diálogo não travará nenhuma janela.
	 * @param title O título da caixa de diálogo.
	 * @param msg O conteúdo da caixa de diálogo.
	 */
	public static void showWarningDialog(Stage stage, String title, String msg) {
		Alert alert = new Alert(AlertType.WARNING);
		mountAlert(alert, stage, title, msg);
		alert.show();
	}
	
	/**
	 * Mostra uma simples caixa de diálogo de aviso solta, ou seja,
	 * não terá nenhuma janela para ser travada. Em outras palavras, o atributo
	 * <code>owner</code> da classe <code>Alert</code> terá seu valor <code>null</code>.
	 * @param title O título da caixa de diálogo.
	 * @param msg O conteúdo da caixa de diálogo.
	 */
	public static void showWarningDialog(String title, String msg) {
		showWarningDialog(null, title, msg);
	}
	
	/**
	 * Mostra uma simples caixa de diálogo de aviso sem travar
	 * nenhuma janela e com um título padrão.
	 * @param msg O conteúdo da caixa de diálogo.
	 */
	public static void showWarningDialog(String msg) {
		showWarningDialog(null, "Warning", msg);
	}
	
	/**
	 * Mostra uma simples caixa de diálogo de erro.
	 * @param stage A janela onde será mostrada a caixa de diálogo.
	 * Caso a janela seja fornecida pelo argumento, a mesma ficará travada
	 * até que a caixa de diálogo seja fechada. Se o valor do argumento for
	 * <code>null</code>, a caixa de diálogo não travará nenhuma janela.
	 * @param title O título da caixa de diálogo.
	 * @param msg O conteúdo da caixa de diálogo.
	 */
	public static void showErrorDialog(Stage stage, String title, String msg) {
		Alert alert = new Alert(AlertType.ERROR);
		mountAlert(alert, stage, title, msg);
		alert.show();
	}
	
	/**
	 * Mostra uma simples caixa de diálogo de erro solta, ou seja,
	 * não terá nenhuma janela para ser travada. Em outras palavras, o atributo
	 * <code>owner</code> da classe <code>Alert</code> terá seu valor <code>null</code>.
	 * @param title O título da caixa de diálogo.
	 * @param msg O conteúdo da caixa de diálogo.
	 */
	public static void showErrorDialog(String title, String msg) {
		showErrorDialog(null, title, msg);
	}
	
	/**
	 * Mostra uma simples caixa de diálogo de erro sem travar
	 * nenhuma janela e com um título padrão.
	 * @param msg O conteúdo da caixa de diálogo.
	 */
	public static void showErrorDialog(String msg) {
		showErrorDialog(null, "Error", msg);
	}
	
	
	
	/*
	 * ===========================================================
	 * 				*** MÉTODOS PRIVADOS ***
	 * ===========================================================
	 */
	
	/**
	 * Monta a caixa de diálogo de acordo com os argumentos dados.
	 * @param alert A instância de <code>Alert</code>.
	 * @param stage A instância de <code>Stage</code> que será a janela travada
	 * pela caixa de diálogo.
	 * @param title O título da caixa de diálogo.
	 * @param msg O conteúdo da caixa de diálogo.
	 */
	private static void mountAlert(Alert alert, Stage stage, String title, String msg) {
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(msg);
		alert.initOwner(stage);
	}
	
}
