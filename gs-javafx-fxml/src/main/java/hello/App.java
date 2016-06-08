package hello;

import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	public static void main(String[] args) {
		Application.launch(App.class, args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/fxml_example.fxml"),
				ResourceBundle.getBundle("message_cn"));

		Scene scene = new Scene(root, 800, 600);

		primaryStage.setTitle("FXML Welcome");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
