package hello;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

@Component
public class WebViewController extends FxmlController implements Initializable {

	private static final Logger logger = Logger.getLogger(WebViewController.class);

	@FXML
	private TextField locationField;
//	@FXML
//	private WebView webView;
//
//	private WebEngine webEngine;

	public WebViewController() {
		super("/webview.fxml");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		logger.debug("WebViewController.initialize() ...");

//		webEngine = webView.getEngine();
//		webEngine.locationProperty()
//				.addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
//					locationField.setText(newValue);
//				});
	}

	@FXML
	public void goAction(ActionEvent event) {
//		webEngine.load(locationField.getText().startsWith("http://") ? locationField.getText()
//				: "http://" + locationField.getText());
	}

}
