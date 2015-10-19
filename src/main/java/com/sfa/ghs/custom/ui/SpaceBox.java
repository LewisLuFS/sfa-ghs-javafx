package com.sfa.ghs.custom.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sfa.common.exception.SfaException;
import com.sfa.ghs.custom.data.UIEnum;
import com.sfa.ghs.custom.vo.SpaceItemVO;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SpaceBox extends VBox {
	public static final Logger log = Logger.getLogger(SpaceBox.class);

	@FXML
	private Label space;
	@FXML
	private HBox uldBox;

	private SpaceItemVO vo;

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

	private StringProperty spaceProperty() {
		return space.textProperty();
	}

	private void setSpace(String value) {
		spaceProperty().set(value);
	}

	public void initBaseInfo(SpaceItemVO vo) {
		if (null == vo) {
			throw new NullPointerException();
		}

		this.vo = vo;
		this.setSpace(vo.getSpaceName());
		this.uldBox.getChildren().addAll(BoxHelper.newEmptyBoxes(vo.getLoadAmount()));
	}

	public SpaceItemVO getValue() {
		return this.vo;
	}

	public List<UldBox> getBoxs() {
		List<UldBox> result = new ArrayList<UldBox>();

		for (Node node : this.uldBox.getChildren()) {
			if (node instanceof UldBox) {
				result.add((UldBox) node);
			}
		}

		return result;
	}
}
