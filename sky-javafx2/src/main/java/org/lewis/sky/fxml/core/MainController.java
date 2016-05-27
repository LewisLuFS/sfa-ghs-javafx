package org.lewis.sky.fxml.core;

import java.net.URL;
import java.util.ResourceBundle;

import org.lewis.sky.fxml.controller.MainScreenController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.fxml.Initializable;

public class MainController implements Initializable {

	private static final Logger logger = LoggerFactory.getLogger(MainScreenController.class);

	private SceneConfig scene;

	public MainController(SceneConfig scene) {
		logger.debug("MainController()");
		this.scene = scene;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		logger.debug("initialize()");
	}

}
