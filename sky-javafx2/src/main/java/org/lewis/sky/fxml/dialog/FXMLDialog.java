package org.lewis.sky.fxml.dialog;

import java.io.IOException;
import java.net.URL;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.lewis.sky.fxml.controller.DialogController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class FXMLDialog extends Stage {

	private static final Logger logger = LoggerFactory.getLogger(FXMLDialog.class);

	public FXMLDialog() {
		super();
	}

	public FXMLDialog(String mainResource, DialogController controller, String name, Window owner) {
		this(mainResource, controller, name, owner, Modality.WINDOW_MODAL, StageStyle.DECORATED, false);
	}

	public FXMLDialog(String mainResource, DialogController controller, String name, Window owner, StageStyle style) {
		this(mainResource, controller, name, owner, Modality.WINDOW_MODAL, style, false);
	}

	public FXMLDialog(String mainResource, DialogController controller, String name, Window owner, Modality modality) {
		this(mainResource, controller, name, owner, modality, StageStyle.DECORATED, true);
	}

	public FXMLDialog(String mainResource, final DialogController controller, String name, Window owner,
			Modality modality, StageStyle style, boolean resizable) {
		super(style);
		logger.debug("FXMLDialog");

		URL fxml = getClass().getResource("/fxml/" + name + ".fxml");
		URL css = getClass().getResource("/css/" + name + ".css");
		logger.debug("FXMLDialog.css = " + css);
		initOwner(owner);
		initModality(modality);
		setResizable(resizable);
		ResourceBundle bundle = null;
		try {
			bundle = ResourceBundle.getBundle(name);
		} catch (MissingResourceException e) {
			logger.info("Resource not found: " + e.getMessage());
			logger.info("Try found global resources: " + mainResource);
			bundle = ResourceBundle.getBundle(mainResource);
		}
		FXMLLoader loader = new FXMLLoader(fxml, bundle);
		try {
			loader.setControllerFactory(aClass -> controller);
			controller.setDialog(this);
			Scene s = new Scene((Parent) loader.load());
			if (css != null) {
				s.getStylesheets().add(css.toExternalForm());
			}
			setScene(s);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
