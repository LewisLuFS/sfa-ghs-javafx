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

public class UldBox extends VBox {
	public static final Logger log = Logger.getLogger(UldBox.class);

	@FXML
	private Label uldType;
	@FXML
	private Label uldNo;
	@FXML
	private Label uldCarrier;
	@FXML
	private Label weight;
	@FXML
	private Label dest;

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

	public StringProperty uldNoProperty() {
		return uldNo.textProperty();
	}

	public StringProperty uldCarrierProperty() {
		return uldCarrier.textProperty();
	}

	public StringProperty weightProperty() {
		return weight.textProperty();
	}

	public StringProperty destProperty() {
		return dest.textProperty();
	}

	public String getUldNo() {
		return uldTypeProperty().get() + uldNoProperty().get() + uldCarrierProperty().get();
	}

	public void setUldNo(String value) {
		uldTypeProperty().set(value.substring(0, 3));
		uldNoProperty().set(value.substring(3, value.length() - 2));
		uldCarrierProperty().set(value.substring(value.length() - 2));
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

	public String getText() {
		if ("".equals(this.getUldNo())) {
			return "";
		}
		return "uldNo:" + this.getUldNo() + ",weight:" + this.getWeight() + ",dest:" + this.getDest();
	}

	public void setText(String text) {
		for (String obj : text.split(",")) {
			String key = obj.split(":")[0];
			String value = obj.split(":")[1];

			if (key.equals("uldNo")) {
				this.setUldNo(value);
			} else if (key.equals("weight")) {
				this.setWeight(value);
			} else if (key.equals("dest")) {
				this.setDest(value);
			}
		}
	}
}
