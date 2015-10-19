package com.sfa.ghs.custom.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sfa.common.exception.SfaException;
import com.sfa.ghs.custom.data.UIEnum;
import com.sfa.ghs.custom.vo.BRItemVO;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

public class LoadingToDoInfo extends HBox {
	public static final Logger log = Logger.getLogger(LoadingToDoInfo.class);

	@FXML
	private FlowPane uldToDo;
	@FXML
	private FlowPane bulkToDo;

	public LoadingToDoInfo() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(UIEnum.WB_LOADING_TODO_INFO.getFile()));
			fxmlLoader.setRoot(this);
			fxmlLoader.setController(this);
			fxmlLoader.load();
		} catch (IOException e) {
			log.error(e);
			throw new SfaException(e);
		}
	}

	public void initData(List<BRItemVO> vos) {
		if (null == vos) {
			return;
		}
		for (BRItemVO vo : vos) {
			this.addBox(vo);
		}
	}

	public List<UldBox> getLoadingToDoBoxs() {
		List<UldBox> result = new ArrayList<UldBox>();

		for (Node node : this.uldToDo.getChildren()) {
			if (node instanceof UldBox) {
				result.add((UldBox) node);
			}
		}

		for (Node node : this.bulkToDo.getChildren()) {
			if (node instanceof UldBox) {
				result.add((UldBox) node);
			}
		}

		return result;
	}

	public UldBox addBox(BRItemVO vo) {
		UldBox box = BoxHelper.newValueBox(vo);
		if (vo.getType().equals("ULD")) {
			uldToDo.getChildren().add(box);
		} else {
			bulkToDo.getChildren().add(box);
		}
		return box;
	}
}
