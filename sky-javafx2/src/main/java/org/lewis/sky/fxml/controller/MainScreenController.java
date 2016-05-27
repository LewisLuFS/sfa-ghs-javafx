package org.lewis.sky.fxml.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.fxml.Initializable;

public class MainScreenController implements Initializable {

	private static final Logger logger = LoggerFactory.getLogger(MainScreenController.class);

	private ScreensConfiguration screens;

	public MainScreenController(ScreensConfiguration screens) {
		logger.debug("MainScreenController()");
		this.screens = screens;
	}

	public void showErrorDialog() {
		logger.debug("showErrorDialog()");
		screens.errorController();
		screens.errorController().show("Error text", "Error title");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		logger.debug("initialize() ");
	}

	public void listContacts() {
		screens.getContactListDialog().show();
	}

	public void addContacts() {
		logger.debug("addContacts() ");
//		screens.getContactController().add();
	}

}
