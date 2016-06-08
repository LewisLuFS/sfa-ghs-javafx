package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Lazy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

@Lazy
@SpringBootApplication
public class App extends Application {

	private static final Logger logger = LoggerFactory.getLogger(App.class);

	@Autowired
	private MainController mainController;

	private static String[] savedArgs;
	private ConfigurableApplicationContext applicationContext;

	public static void main(String[] args) {
		logger.debug("Application is starting now...");
		savedArgs = args;
		Application.launch(App.class, args);
	}

	@Override
	public void init() throws Exception {
		applicationContext = SpringApplication.run(getClass(), savedArgs);
		logger.debug("Spring Context init successful...");
		applicationContext.getAutowireCapableBeanFactory().autowireBean(this);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("FXML demo - by Spring Boot");
		stage.setScene(new Scene(mainController.getView(), 900, 600));
		stage.show();
		logger.debug("page is showing...");
	}

	@Override
	public void stop() throws Exception {
		applicationContext.close();
	}

}
