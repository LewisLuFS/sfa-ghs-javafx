package org.lewis.sky.main.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.lewis.sky.fxml.FxmlController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

@Component
public class MainController extends FxmlController implements Initializable {

	// @FXML
	// private Pane content;
	@FXML
	private Label version;

	@Value("${app.info.version}")
	private String ver;

	public MainController() {
		super("/fxml/main.fxml");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@Bean
	public String initVersion() {
		this.version.setText(this.ver);
		return "";
	}

}
