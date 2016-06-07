package hello;

import org.apache.log4j.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

public class FXMLExampleController {

	private static final Logger logger = Logger.getLogger(FXMLExampleController.class);

	@FXML
	private Label lbl;

	@FXML
	public void menuAction(ActionEvent event) {
		MenuItem item = (MenuItem) event.getSource();
		lbl.setText(item.getText());

		logger.info(item.getText());
	}

}
