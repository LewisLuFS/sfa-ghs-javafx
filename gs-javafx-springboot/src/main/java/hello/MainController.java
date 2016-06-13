package hello;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;

@Component
public class MainController extends FxmlController implements Initializable {

	private static final Logger logger = Logger.getLogger(MainController.class);

	@FXML
	private ScrollPane content;
	@FXML
	private Label lbl;

	@Autowired
	private Demo1Controller demo1Controller;

	public MainController() {
		super("/main.fxml");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		logger.debug("MainController.initialize() ...");
	}

	@FXML
	public void menuAction(ActionEvent event) {
		MenuItem item = (MenuItem) event.getSource();
		lbl.setText(item.getText());

		logger.info(item.getText());
	}

	@FXML
	public void openDemo1(ActionEvent event) {
		content.setContent(this.demo1Controller.getView());
	}

	@FXML
	public void openDemo2(ActionEvent event) {
		MenuItem item = (MenuItem) event.getSource();
		logger.info(item.getText());
	}

}
