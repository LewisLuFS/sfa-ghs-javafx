package com.sfa.ghs.custom.ui;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.sfa.common.exception.SfaException;
import com.sfa.ghs.custom.data.UIEnum;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;

public class UldBox extends AbstractBox {
	public static final Logger log = Logger.getLogger(UldBox.class);

	@FXML
	private Label uldType;
	@FXML
	private Label uldCarrier;

	public UldBox() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(UIEnum.WB_ULD_BOX.getFile()));
			fxmlLoader.setRoot(this);
			fxmlLoader.setController(this);
			fxmlLoader.load();
		} catch (IOException e) {
			log.error(e);
			throw new SfaException(e);
		}
	}

	public StringProperty uldTypeProperty() {
		return uldType.textProperty();
	}

	public StringProperty uldCarrierProperty() {
		return uldCarrier.textProperty();
	}

	public String getUldNo() {
		return uldTypeProperty().get() + uldNoProperty().get() + uldCarrierProperty().get();
	}

	public void setUldNo(String value) {
		uldTypeProperty().set(value.substring(0, 3));
		uldNoProperty().set(value.substring(3, value.length() - 2));
		uldCarrierProperty().set(value.substring(value.length() - 2));
	}
}
