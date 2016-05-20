package org.lewis.sky;

import org.lewis.sky.main.controller.MainController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
public class MainApp extends Application {

	private static final Logger logger = LoggerFactory.getLogger(MainApp.class);

	@Value("${app.title.main}")
	private String title;

	@Autowired
	private MainController mainController;

	private static String[] savedArgs;
	private ConfigurableApplicationContext applicationContext;

	public static void main(String[] args) {
		logger.debug("Application is starting now...");
		savedArgs = args;
		Application.launch(MainApp.class, args);
	}

	@Override
	public void init() throws Exception {
		applicationContext = SpringApplication.run(getClass(), savedArgs);
		logger.debug("Spring Context init successful...");
		applicationContext.getAutowireCapableBeanFactory().autowireBean(this);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle(title);
		stage.setScene(new Scene(mainController.getView(), 900, 600));
		stage.show();
		logger.debug("page is showing...");
	}

	@Override
	public void stop() throws Exception {
		applicationContext.close();
	}

}
