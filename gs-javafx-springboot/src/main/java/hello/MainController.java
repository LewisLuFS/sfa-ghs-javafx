package hello;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

@Component
public class MainController extends FxmlController implements Initializable {

	private static final Logger logger = Logger.getLogger(MainController.class);

	@FXML
	private Label lbl;

	public MainController() {
		super("/main.fxml", "message_cn");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	public void menuAction(ActionEvent event) {
		MenuItem item = (MenuItem) event.getSource();
		lbl.setText(item.getText());

		logger.info(item.getText());
	}

}
