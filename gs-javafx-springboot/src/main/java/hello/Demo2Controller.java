package hello;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javafx.fxml.Initializable;

@Component
public class Demo2Controller extends FxmlController implements Initializable {

	private static final Logger logger = Logger.getLogger(Demo2Controller.class);

	public Demo2Controller() {
		super("/demo2.fxml");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		logger.debug("Demo2Controller.initialize() ...");
	}

}
