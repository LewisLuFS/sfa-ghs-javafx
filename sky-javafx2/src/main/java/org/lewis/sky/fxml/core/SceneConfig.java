package org.lewis.sky.fxml.core;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@Configuration
public class SceneConfig {

	private static final Logger logger = LoggerFactory.getLogger(SceneConfig.class);

	@Value("${ui.main.title}")
	private String windowTitle;

	@Value("${app.message.name}")
	private String messageResource;

	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@PostConstruct
	public void init() {
		logger.info("SceneConfig.init()");
	}

	public void show(Parent root) {
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle(windowTitle);
		primaryStage.show();
	}

	@Bean
	public Parent mainForm(MainController controller) throws IOException {
		try {
			URL fxmlUrl = getClass().getResource("/fxml/main.fxml");
			FXMLLoader loader = new FXMLLoader(fxmlUrl, ResourceBundle.getBundle(messageResource));
			loader.setControllerFactory(aClass -> controller);
			return loader.load();
		} catch (IOException e) {
			logger.error("Can't load resource", e);
			throw new RuntimeException(e);
		}
	}

	@Bean
	public MainController mainController() {
		return new MainController(this);
	}

}
