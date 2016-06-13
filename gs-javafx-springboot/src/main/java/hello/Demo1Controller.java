package hello;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javafx.fxml.Initializable;

@Component
public class Demo1Controller extends FxmlController implements Initializable {

	private static final Logger logger = Logger.getLogger(Demo1Controller.class);

	public Demo1Controller() {
		super("/demo1.fxml");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		logger.debug("Demo1Controller.initialize() ...");
	}

}
