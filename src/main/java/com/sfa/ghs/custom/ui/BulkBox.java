package com.sfa.ghs.custom.ui;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.sfa.common.exception.SfaException;
import com.sfa.ghs.custom.data.UIEnum;

import javafx.fxml.FXMLLoader;

public class BulkBox extends AbstractBox {
	public static final Logger log = Logger.getLogger(BulkBox.class);

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

	public String getUldNo() {
		return uldNoProperty().get();
	}

	public void setUldNo(String value) {
		uldNoProperty().set(value);
	}
}
