package com.sfa.ghs.custom.ui;

import com.sfa.ghs.custom.vo.BRItemVO;

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

	protected BRItemVO vo;

	protected StringProperty uldNoProperty() {
		return uldNo.textProperty();
	}

	protected StringProperty weightProperty() {
		return weight.textProperty();
	}

	protected StringProperty destProperty() {
		return dest.textProperty();
	}

	protected abstract void setUldNo(String value);

	protected void setWeight(String value) {
		weightProperty().set(value);
	}

	protected void setDest(String value) {
		destProperty().set(value);
	}

	public BRItemVO getValue() {
		return vo;
	}

	public void setValue(BRItemVO vo) {
		if (null == vo) {
			this.clearValue();
		} else {
			this.vo = vo;
			this.setUldNo(vo.getUldNo());
			this.setWeight(String.valueOf(vo.getWeight()));
			this.setDest(vo.getDest());
		}
	}

	public void clearValue() {
		this.vo = null;
		this.setUldNo("");
		this.setWeight("");
		this.setDest("");
	}
}
