package org.lewis.sky.fxml.controller;

import org.lewis.sky.fxml.dialog.FXMLDialog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ErrorController implements DialogController {

	private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);

	@Autowired
	private ScreensConfiguration screens;

	private FXMLDialog dialog;

	public void setDialog(FXMLDialog dialog) {
		this.dialog = dialog;
	}

	public ErrorController() {
		logger.debug("ErrorController()");
	}

	@FXML
	private Button btn;

	@FXML
	private TextArea txtText;

	@FXML
	public void cancel() {
		((Stage) btn.getScene().getWindow()).close();
	}

	@FXML
	public void initialize() {
		logger.debug("initialize");
	}

	public void show(String s, String s1) {
		logger.debug("show");
		screens.errorDialog().show();
		screens.errorDialog().setTitle(s1);
		if (txtText != null) {
			txtText.setText(s);
		}
	}

}
