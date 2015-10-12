package com.sfa.ghs.controller.lab;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import com.sfa.common.controller.BaseController;
import com.sfa.ghs.custom.ui.BulkBox;
import com.sfa.ghs.custom.ui.FlightInfo;
import com.sfa.ghs.custom.ui.LoadingInfo;
import com.sfa.ghs.custom.ui.LoadingToDoInfo;
import com.sfa.ghs.custom.ui.UldBox;
import com.sfa.ghs.custom.vo.BRItemVO;
import com.sfa.ghs.custom.vo.FlightInfoVO;
import com.sfa.ghs.custom.vo.SpaceItemVO;

import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

@Component
public class DemoController extends BaseController {
	@FXML
	private FlightInfo flightInfo;
	@FXML
	private LoadingInfo loadingInfo;
	@FXML
	private LoadingToDoInfo loadingToDoInfo;

	private double initX;
	private double initY;
	private Point2D dragAnchor;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.flightInfo.initData(this.getFlightVO());
		this.loadingInfo.initBaseInfo(this.getSpaceItemVOs());
		this.loadingToDoInfo.initData(this.getBRItemVOs());
		this.mouseClick();
	}

	private void mouseClick() {
		List<UldBox> uldToDos = this.loadingToDoInfo.getLoadingToDoUlds();
		for (UldBox uldToDo : uldToDos) {
			this.mouseClick(uldToDo);
		}
		List<BulkBox> bulkToDos = this.loadingToDoInfo.getLoadingToDoBulks();
		for (BulkBox bulkBox : bulkToDos) {
			this.mouseClick(bulkBox);
		}
	}

	/**
	 * 节点鼠标点击事件
	 * 
	 * @param node
	 */
	private void mouseClick(Node node) {
		// 鼠标动作：移入-按下-拖动-弹起-移出
		// 鼠标移入
		node.setOnMouseEntered((MouseEvent me) -> {
			node.getStyleClass().add("-fx-loadingToDo-dropColor");
		});
		// 鼠标按下
		node.setOnMousePressed((MouseEvent me) -> {
			initX = node.getTranslateX();
			initY = node.getTranslateY();
			dragAnchor = new Point2D(me.getSceneX(), me.getSceneY());
		});
		// 鼠标拖动
		node.setOnMouseDragged((MouseEvent me) -> {
			double dragX = me.getSceneX() - dragAnchor.getX();
			double dragY = me.getSceneY() - dragAnchor.getY();
			// calculate new position of the circle
			double newXPosition = initX + dragX;
			double newYPosition = initY + dragY;
			// if new position do not exceeds borders of the rectangle,
			// translate to this position

			node.setTranslateX(newXPosition);
			node.setTranslateY(newYPosition);
		});
		// 鼠标弹起
		node.setOnMouseReleased((MouseEvent me) -> {
			node.setTranslateX(initX);
			node.setTranslateY(initY);
		});
		// 鼠标Click完成
		node.setOnMouseClicked((MouseEvent me) -> {
			me.consume();
		});
		// 鼠标移出
		node.setOnMouseExited((MouseEvent me) -> {
			node.getStyleClass().remove("-fx-loadingToDo-dropColor");
		});
	}

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

		for (int i = 1; i <= 7; i++) {
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
