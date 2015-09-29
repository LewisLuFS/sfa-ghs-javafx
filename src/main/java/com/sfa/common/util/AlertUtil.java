package com.sfa.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.sfa.common.controller.BaseController;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;

public class AlertUtil {
	public static Alert info(String message) {
		return create(AlertType.INFORMATION, message);
	}

	public static Alert confirm(String message) {
		return create(AlertType.CONFIRMATION, message);
	}

	public static Alert warn(String message) {
		return create(AlertType.WARNING, message);
	}

	public static Alert error(String message) {
		return create(AlertType.ERROR, message);
	}

	public static Dialog<ButtonType> showException(Throwable th) {
		return createExceptionDialog(th);
	}

	public static Dialog<?> inputDialog() {
		return createTextInputDialog();
	}

	protected static Alert create(AlertType type, String message) {
		Alert alert = new Alert(type, "");
		alert.initModality(Modality.APPLICATION_MODAL);
		alert.initOwner(BaseController.mainStage);
		alert.getDialogPane().setContentText(message);
		alert.getDialogPane().setHeaderText(null);
		alert.showAndWait().filter(response -> response == ButtonType.OK)
				.ifPresent(response -> System.out.println("The alert was approved"));
		return alert;
	}

	protected static Dialog<ButtonType> createExceptionDialog(Throwable th) {
		Dialog<ButtonType> dialog = new Dialog<ButtonType>();
		dialog.setTitle("Program exception");
		final DialogPane dialogPane = dialog.getDialogPane();
		dialogPane.setContentText("Details of the problem:");
		dialogPane.getButtonTypes().addAll(ButtonType.OK);
		dialogPane.setContentText(th.getMessage());
		dialog.initModality(Modality.APPLICATION_MODAL);
		Label label = new Label("Exception stacktrace:");
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		th.printStackTrace(pw);
		pw.close();
		TextArea textArea = new TextArea(sw.toString());
		textArea.setEditable(false);
		textArea.setWrapText(true);
		textArea.setMaxWidth(Double.MAX_VALUE);
		textArea.setMaxHeight(Double.MAX_VALUE);
		GridPane.setVgrow(textArea, Priority.ALWAYS);
		GridPane.setHgrow(textArea, Priority.ALWAYS);
		GridPane root = new GridPane();
		root.setVisible(false);
		root.setMaxWidth(Double.MAX_VALUE);
		root.add(label, 0, 0);
		root.add(textArea, 0, 1);
		dialogPane.setExpandableContent(root);
		dialog.showAndWait().filter(response -> response == ButtonType.OK)
				.ifPresent(response -> System.out.println("The exception was approved"));

		return dialog;
	}

	protected static Dialog<?> createTextInputDialog() {
		TextInputDialog textInput = new TextInputDialog("");
		textInput.setTitle("Text Input Dialog");
		textInput.getDialogPane().setContentText("First Name:");
		textInput.showAndWait().ifPresent(response -> {
			if (response.isEmpty()) {
				System.out.println("No name was inserted");
			} else {
				System.out.println("The first name is: " + response);
			}
		});

		return textInput;
	}
}
