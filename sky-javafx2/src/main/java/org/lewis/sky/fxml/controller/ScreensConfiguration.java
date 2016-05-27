package org.lewis.sky.fxml.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;

import org.lewis.sky.fxml.dialog.FXMLDialog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// @Configuration
public class ScreensConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(ScreensConfiguration.class);

	@Value("${ui.main.viewName:main}")
	private String mainView;

	@Value("${ui.main.title}")
	private String windowTitle;

	@Value("${spring.messages.basename}")
	private String mainResource;

	public String nameFxmlConverter(String part) {
		return "/fxml/" + part + ".fxml";
	}

	public String nameCssConverter(String part) {
		return "/css/" + part + ".css";
	}

	@PostConstruct
	public void init() {
		logger.info("ScreensConfiguration init()");
	}

	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public void showScreen(Parent screen) {
		Scene scene = new Scene(screen);
		scene.getStylesheets().add(getClass().getResource(nameCssConverter(mainView)).toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle(windowTitle);
		primaryStage.show();
	}

	@Bean
	public MainScreenController mainScreenController() {
		return new MainScreenController(this);
	}

	@Bean
	public Parent mainForm(MainScreenController controller) throws IOException {
		try {
			URL fxmlUrl = getClass().getResource(nameFxmlConverter(mainView));
			FXMLLoader loader = new FXMLLoader(fxmlUrl, ResourceBundle.getBundle(mainResource));
			loader.setControllerFactory(aClass -> controller);
			Parent view = loader.load();
			return view;
		} catch (IOException e) {
			logger.error("Can't load resource", e);
			throw new RuntimeException(e);
		}
	}

	@Bean
	@Scope("singleton")
	public FXMLDialog errorDialog() {
		return new FXMLDialog(mainResource, errorController(), "error", primaryStage);
	}

	@Bean
	@Scope("singleton")
	public ErrorController errorController() {
		return new ErrorController();
	}

	@Bean
	public FXMLDialog getPersonDialog() {
		return new FXMLDialog(mainResource, getContactController(), "contactform", primaryStage);
	}

	@Bean
	public FXMLDialog getContactListDialog() {
		return new FXMLDialog(mainResource, getContactListController(), "contactlistform", primaryStage);
	}

	@Bean
	public AddContactController getContactController() {
		return new AddContactController();
	}

	@Bean
	public ContactListController getContactListController() {
		return new ContactListController();
	}

}
