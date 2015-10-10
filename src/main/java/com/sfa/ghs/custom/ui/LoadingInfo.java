package com.sfa.ghs.custom.ui;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.sfa.common.exception.SfaException;
import com.sfa.ghs.custom.data.UIEnum;
import com.sfa.ghs.custom.vo.SpaceItemVO;
import com.sfa.ghs.custom.vo.SpaceVO;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

public class LoadingInfo extends HBox {
	public static final Logger log = Logger.getLogger(LoadingInfo.class);

	@FXML
	private HBox mainSpace;
	@FXML
	private HBox fwdSpace;
	@FXML
	private HBox aftSpace;

	public LoadingInfo() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(UIEnum.WB_LOADING_INFO.getFile()));
			fxmlLoader.setRoot(this);
			fxmlLoader.setController(this);
			fxmlLoader.load();
		} catch (IOException e) {
			log.error(e);
			throw new SfaException(e);
		}
	}

	public void initData(SpaceVO vo) {
		initSpace(mainSpace, vo.getMainSpaces());
		initSpace(fwdSpace, vo.getFwdSpaces());
		initSpace(aftSpace, vo.getAftSpaces());
	}

	private void initSpace(HBox parent, List<SpaceItemVO> voList) {
		for (SpaceItemVO itemVO : voList) {
			SpaceBox space = new SpaceBox();
			space.setSpace(itemVO.getName());
			space.setHBox(itemVO.getNum());
			parent.getChildren().add(space);
		}
	}
}
