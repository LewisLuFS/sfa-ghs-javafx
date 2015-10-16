package com.sfa.ghs.controller.lab;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import com.sfa.common.controller.BaseController;
import com.sfa.ghs.custom.ui.AbstractBox;
import com.sfa.ghs.custom.ui.BulkBox;
import com.sfa.ghs.custom.ui.FlightInfo;
import com.sfa.ghs.custom.ui.LoadingInfo;
import com.sfa.ghs.custom.ui.LoadingToDoInfo;
import com.sfa.ghs.custom.ui.SpaceBox;
import com.sfa.ghs.custom.ui.UldBox;
import com.sfa.ghs.custom.vo.BRItemVO;
import com.sfa.ghs.custom.vo.FlightInfoVO;
import com.sfa.ghs.custom.vo.SpaceItemVO;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

@Component
public class DemoController extends BaseController {
	@FXML
	private FlightInfo flightInfo;
	@FXML
	private LoadingInfo loadingInfo;
	@FXML
	private LoadingToDoInfo loadingToDoInfo;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.flightInfo.initData(this.getFlightVO());
		this.loadingInfo.initBaseInfo(this.getSpaceItemVOs());
		this.loadingToDoInfo.initData(this.getBRItemVOs());

		this.setloadingToDoDragEvent();
		this.setLoadingDragEvent();
	}

	/**
	 * 设置待配载区事件
	 */
	private void setloadingToDoDragEvent() {
		List<AbstractBox> loadingToDoBoxs = this.loadingToDoInfo.getLoadingToDoBoxs();
		for (AbstractBox box : loadingToDoBoxs) {
			this.setDragSourceEvent(box);
		}
	}

	/**
	 * 设置配载区事件
	 */
	private void setLoadingDragEvent() {
		List<AbstractBox> loadingBoxs = this.loadingInfo.getLoadingBoxs();
		for (AbstractBox box : loadingBoxs) {
			this.setDragSourceEvent(box);
		}
	}

	/**
	 * 设置拖拽源（ULD或者BULK）的拖拽事件
	 * <ul>
	 * <li>拖拽源可由待配载区拖拽至配载区舱位，也可以在配载区各舱位之间任意拖拽</li>
	 * <li>拖拽源ULD只能拖拽至配载区主舱舱位， 拖拽源BULK只能拖拽至配载区腹舱（前腹舱和后腹舱）舱位</li>
	 * <li>如果拖拽成功，则拖拽源需要被清除</li>
	 * </ul>
	 * 
	 * @param source
	 *            拖拉拽源
	 */
	private void setDragSourceEvent(Node source) {
		source.setOnDragDetected((MouseEvent me) -> {
			Dragboard db = source.startDragAndDrop(TransferMode.ANY);

			ClipboardContent content = new ClipboardContent();

			if (source instanceof UldBox) {
				content.putString(((UldBox) source).getText());
			} else if (source instanceof BulkBox) {
				content.putString(((BulkBox) source).getText());
			}
			db.setContent(content);

			me.consume();
		});

		source.setOnDragDone((DragEvent de) -> {
			if (de.getTransferMode() == TransferMode.MOVE) {
				Parent parent = source.getParent();

				if (parent instanceof FlowPane) {
					// 来自待配载区
					((FlowPane) parent).getChildren().remove(source);
				} else if (parent instanceof HBox) {
					// 来自配载区舱位
					Parent root =  parent.getParent();
					if (root instanceof SpaceBox) {
						((SpaceBox) root).clearUldOrBulk(());
					}
				}
			}
			de.consume();
		});
	}

	private void targetDrag(Node target) {
		target.setOnDragOver((DragEvent de) -> {
			if ((de.getGestureSource() instanceof UldBox && target instanceof UldBox)
					|| (de.getGestureSource() instanceof BulkBox && target instanceof BulkBox)) {
				de.acceptTransferModes(TransferMode.COPY_OR_MOVE);
			}

			de.consume();
		});

		target.setOnDragEntered((DragEvent de) -> {
			if ((de.getGestureSource() instanceof UldBox && target instanceof UldBox)
					|| (de.getGestureSource() instanceof BulkBox && target instanceof BulkBox)) {
				target.getStyleClass().add("-fx-loading-shape-drag");
			}

			de.consume();
		});

		target.setOnDragExited((DragEvent de) -> {
			if ((de.getGestureSource() instanceof UldBox && target instanceof UldBox)
					|| (de.getGestureSource() instanceof BulkBox && target instanceof BulkBox)) {
				target.getStyleClass().remove("-fx-loading-shape-drag");
			}

			de.consume();
		});

		target.setOnDragDropped((DragEvent de) -> {
			Dragboard db = de.getDragboard();

			boolean success = false;
			if (db.hasString()) {

				if (target instanceof UldBox) {
					String src = ((UldBox) target).getText();
					((UldBox) target).setText(db.getString());
				}
				success = true;
			}

			de.setDropCompleted(success);
			de.consume();
		});
	}

	/**
	 * 模拟从后台获取航班计划基础信息
	 * 
	 * @return
	 */
	private FlightInfoVO getFlightVO() {
		FlightInfoVO vo = new FlightInfoVO();

		vo.setAcRegNo("B2899");
		vo.setFlightNo("O32121");
		vo.setFlihgtDate(new Date());
		vo.setDow(32321);
		vo.setTakeoffFuel(45612);
		vo.setTripFuel(9876);
		vo.setFlightSect("SZX-HGH");
		vo.setCrew("3/0");
		vo.setDoi(8.2);
		vo.setTakeoffFuelIndex(7.3);
		vo.setLoadingFuelIndex(5.3);
		vo.setVer(5);

		return vo;
	}

	/**
	 * 模拟从后台获取飞机舱位集合
	 * 
	 * @return
	 */
	private List<SpaceItemVO> getSpaceItemVOs() {
		List<SpaceItemVO> result = new ArrayList<SpaceItemVO>();

		for (int i = 1; i <= 15; i++) {
			SpaceItemVO itemVO = new SpaceItemVO("ULD", "C" + i, (3000 + i), 1);
			result.add(itemVO);
		}

		for (int i = 1; i <= 3; i++) {
			SpaceItemVO itemVO = new SpaceItemVO("BULK_FWD", "F" + i, (300 + i), 1);
			if (i == 1) {
				itemVO.setSpaceName("HOLD1a");
				itemVO.setLoadAmount(2);
			} else if (i == 2) {
				itemVO.setSpaceName("HOLD1b");
				itemVO.setLoadAmount(2);
			} else {
				itemVO.setSpaceName("HOLD2");
				itemVO.setLoadAmount(3);
			}
			result.add(itemVO);
		}

		for (int i = 1; i <= 2; i++) {
			SpaceItemVO itemVO = new SpaceItemVO("BULK_AFT", "HOLD" + (2 + i), (350 + i), 3);
			result.add(itemVO);
		}

		return result;
	}

	/**
	 * 模拟从后台获取拼装单集合
	 * 
	 * @return
	 */
	private List<BRItemVO> getBRItemVOs() {
		List<BRItemVO> result = new ArrayList<BRItemVO>();

		for (int i = 1; i <= 12; i++) {
			BRItemVO vo = new BRItemVO();
			vo.setUldNo("PAG" + (12300 + i) + "O3");
			vo.setWeight(2000 + i);
			vo.setDest("HGH");
			vo.setType("ULD");
			result.add(vo);
		}

		for (int i = 1; i <= 10; i++) {
			BRItemVO vo = new BRItemVO();
			vo.setUldNo("S" + (100 + i));
			vo.setWeight(200 + i);
			vo.setDest("PEK");
			vo.setType("BULK");
			result.add(vo);
		}

		return result;
	}
}
