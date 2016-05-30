package org.lewis.sky;

import org.lewis.sky.fxml.core.SceneConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.stage.Stage;

@SpringBootApplication
public class MainApp extends Application {

	private static final Logger logger = LoggerFactory.getLogger(MainApp.class);

	private static String[] savedArgs;

	@Autowired
	private SceneConfig sceneConfig;
	private ConfigurableApplicationContext applicationContext;

	public static void main(String[] args) {
		savedArgs = args;
		Application.launch(MainApp.class, args);
	}

	@Override
	public void init() throws Exception {
		applicationContext = SpringApplication.run(getClass(), savedArgs);
		applicationContext.getAutowireCapableBeanFactory().autowireBean(this);
		logger.debug("Spring context load ok...");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		sceneConfig.setPrimaryStage(primaryStage);
		sceneConfig.show(sceneConfig.mainForm(sceneConfig.mainController()));
	}

	@Override
	public void stop() throws Exception {
		applicationContext.close();
	}

}
