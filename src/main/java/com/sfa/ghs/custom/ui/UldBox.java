package com.sfa.ghs.custom.ui;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.sfa.common.exception.SfaException;
import com.sfa.ghs.custom.data.UIEnum;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class UldBox extends VBox {
	public static final Logger log = Logger.getLogger(UldBox.class);

	@FXML
	private Label uldNo;
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
}
