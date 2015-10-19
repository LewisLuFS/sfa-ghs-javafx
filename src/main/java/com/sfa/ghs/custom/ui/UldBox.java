package com.sfa.ghs.custom.ui;

import com.sfa.ghs.custom.vo.BRItemVO;

import javafx.scene.layout.VBox;

public class UldBox extends VBox {
	private BRItemVO vo;

	public BRItemVO getValue() {
		return this.vo;
	}

	public void setValue(BRItemVO vo) {
		this.vo = vo;
	}

	public void clearValue() {
		this.vo = null;
	}

	public UldBox() {

	}
}
