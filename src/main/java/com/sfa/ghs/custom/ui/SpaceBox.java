package com.sfa.ghs.custom.ui;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.sfa.common.exception.SfaException;
import com.sfa.ghs.custom.data.UIEnum;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SpaceBox extends VBox {
	public static final Logger log = Logger.getLogger(SpaceBox.class);

	@FXML
	private Label space;
	@FXML
	private HBox uldBox;

	public SpaceBox() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(UIEnum.WB_SPACE_BOX.getFile()));
			fxmlLoader.setRoot(this);
			fxmlLoader.setController(this);
			fxmlLoader.load();
		} catch (IOException e) {
			log.error(e);
			throw new SfaException(e);
		}
	}

	public StringProperty spaceProperty() {
		return space.textProperty();
	}

	public String getSpace() {
		return spaceProperty().get();
	}

	public void setSpace(String value) {
		spaceProperty().set(value);
	}
	
	public void setHBox(int num) {
		for (int i = 1; i <= num; i++) {
			UldBox uldBox = new UldBox();
			this.uldBox.getChildren().add(uldBox);
		}
	}
}
