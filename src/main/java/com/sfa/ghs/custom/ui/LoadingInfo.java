package com.sfa.ghs.custom.ui;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.sfa.common.exception.SfaException;
import com.sfa.ghs.custom.data.UIEnum;
import com.sfa.ghs.custom.vo.SpaceItemVO;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

/**
 * 配载区
 * 
 * @author 431520
 */
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

	/**
	 * 根据飞机舱位数据初始化舱位布局
	 * 
	 * @param vo
	 *            飞机舱位数据
	 */
	public void initBaseInfo(List<SpaceItemVO> vos) {
		for (SpaceItemVO vo : vos) {
			SpaceBox space = new SpaceBox();
			space.setSpace(vo.getSpaceName());
			if (vo.getSpaceType().equals("ULD")) {
				space.setUld();
				mainSpace.getChildren().add(space);
			} else if (vo.getSpaceType().equals("BULK_FWD")) {
				space.setBulk(vo.getLoadAmount());
				fwdSpace.getChildren().add(space);
			} else if (vo.getSpaceType().equals("BULK_AFT")) {
				space.setBulk(vo.getLoadAmount());
				aftSpace.getChildren().add(space);
			} else {
				log.info("舱位类型[" + vo.getSpaceType() + "]错误，初始化时已忽略");
			}
		}
	}
}
