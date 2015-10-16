package com.sfa.ghs.custom.ui;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public abstract class AbstractBox extends VBox {

	@FXML
	protected Label uldNo;
	@FXML
	protected Label weight;
	@FXML
	protected Label dest;

	protected StringProperty uldNoProperty() {
		return uldNo.textProperty();
	}

	protected StringProperty weightProperty() {
		return weight.textProperty();
	}

	protected StringProperty destProperty() {
		return dest.textProperty();
	}

	public abstract String getUldNo();

	public abstract void setUldNo(String value);

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

	public String getValue() {
		if ("".equals(this.getUldNo())) {
			return "";
		}
		return "uldNo:" + this.getUldNo() + ",weight:" + this.getWeight() + ",dest:" + this.getDest();
	}

	public void setValue(String value) {
		for (String obj : value.split(",")) {
			String key = obj.split(":")[0];
			String v = obj.split(":")[1];

			if (key.equals("uldNo")) {
				this.setUldNo(v);
			} else if (key.equals("weight")) {
				this.setWeight(v);
			} else if (key.equals("dest")) {
				this.setDest(v);
			}
		}
	}

	public void clearValue(String uldNo) {
		this.setUldNo("");
		this.setWeight("");
		this.setDest("");
	}
}
