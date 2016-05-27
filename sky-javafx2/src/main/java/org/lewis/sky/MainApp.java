package org.lewis.sky;

import org.lewis.sky.fxml.core.SceneConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javafx.application.Application;
import javafx.stage.Stage;

@SpringBootApplication
public class MainApp extends Application {

	private static final Logger logger = LoggerFactory.getLogger(MainApp.class);

	private static String[] savedArgs;

	@Autowired
	private SceneConfig sceneConfig;

	public static void main(String[] args) {
		savedArgs = args;
		Application.launch(MainApp.class, args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		SpringApplication.run(MainApp.class, savedArgs);
		logger.debug("Spring context load ok.");

		sceneConfig.setPrimaryStage(primaryStage);
		sceneConfig.show(sceneConfig.mainForm(sceneConfig.mainController()));
	}

}
