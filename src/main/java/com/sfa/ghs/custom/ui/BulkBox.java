package com.sfa.ghs.custom.ui;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.sfa.common.exception.SfaException;
import com.sfa.ghs.custom.data.UIEnum;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class BulkBox extends VBox {
	public static final Logger log = Logger.getLogger(BulkBox.class);

	@FXML
	private Label uldNo;
	@FXML
	private Label weight;
	@FXML
	private Label dest;

	public BulkBox() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(UIEnum.WB_BULK_BOX.getFile()));
			fxmlLoader.setRoot(this);
			fxmlLoader.setController(this);
			fxmlLoader.load();
		} catch (IOException e) {
			log.error(e);
			throw new SfaException(e);
		}
	}

	public StringProperty uldNoProperty() {
		return uldNo.textProperty();
	}

	public StringProperty weightProperty() {
		return weight.textProperty();
	}

	public StringProperty destProperty() {
		return dest.textProperty();
	}

	public String getUldNo() {
		return uldNoProperty().get();
	}

	public void setUldNo(String value) {
		uldNoProperty().set(value);
	}

	public String getWeight() {
		return weightProperty().get();
	}

	public void setWeight(String value) {
		weightProperty().set(value);
	}

	public String getDest() {
		return destProperty().get();
	}

	public void setDest(String value) {
		destProperty().set(value);
	}
}
