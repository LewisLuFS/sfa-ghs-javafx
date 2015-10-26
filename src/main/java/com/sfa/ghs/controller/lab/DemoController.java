package com.sfa.ghs.controller.lab;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sfa.common.controller.BaseController;
import com.sfa.common.util.JsonUtil;
import com.sfa.ghs.custom.ui.BoxHelper;
import com.sfa.ghs.custom.ui.DashboardInfo;
import com.sfa.ghs.custom.ui.FlightInfo;
import com.sfa.ghs.custom.ui.LoadingInfo;
import com.sfa.ghs.custom.ui.LoadingToDoInfo;
import com.sfa.ghs.custom.ui.SpaceBox;
import com.sfa.ghs.custom.ui.UldBox;
import com.sfa.ghs.custom.vo.BRItemVO;
import com.sfa.ghs.custom.vo.DashboardInfoVO;
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
@Scope("prototype")
public class DemoController extends BaseController {
	public static final Logger log = Logger.getLogger(DemoController.class);

	@FXML
	private FlightInfo flightInfo;
	@FXML
	private LoadingInfo loadingInfo;
	@FXML
	private LoadingToDoInfo loadingToDoInfo;
	@FXML
	private DashboardInfo dashboardInfo;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.flightInfo.initData(this.getFlightVO());
		this.loadingInfo.initBaseInfo(this.getSpaceItemVOs());
		this.loadingToDoInfo.initData(this.getBRItemVOs());
		this.dashboardInfo.initData(this.getDashboardVO());

		this.setloadingToDoDragEvent();
		this.setLoadingDragEvent();
	}

	/**
	 * 设置待配载区事件
	 */
	private void setloadingToDoDragEvent() {
		List<UldBox> loadingToDoBoxs = this.loadingToDoInfo.getLoadingToDoBoxs();
		for (UldBox box : loadingToDoBoxs) {
			this.setDragSourceEvent(box);
		}
	}

	/**
	 * 设置配载区事件
	 */
	private void setLoadingDragEvent() {
		List<UldBox> loadingBoxs = this.loadingInfo.getLoadingBoxs();
		for (UldBox box : loadingBoxs) {
			this.setDragSourceEvent(box);
			this.setDragTargetEvent(box);
		}
	}

	/**
	 * 设置拖拽源的拖拽事件
	 * <ul>
	 * <li>拖拽源可由待配载区拖拽至配载区舱位，也可以在配载区各舱位之间任意拖拽</li>
	 * <li>拖拽源ULD只能拖拽至配载区主舱舱位， 拖拽源BULK只能拖拽至配载区腹舱（前腹舱和后腹舱）舱位</li>
	 * <li>如果拖拽成功，则拖拽源需要被清除</li>
	 * </ul>
	 * 
	 * @param source
	 *            拖拽源
	 */
	private void setDragSourceEvent(Node source) {
		source.setOnDragDetected((MouseEvent me) -> {
			Dragboard db = source.startDragAndDrop(TransferMode.ANY);

			ClipboardContent content = new ClipboardContent();

			if (source instanceof UldBox) {
				content.putString(JsonUtil.toJson(((UldBox) source).getValue()));
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
					BoxHelper.clearValue((UldBox) source);
				}
			}
			de.consume();
		});
	}

	private boolean isSameBox(Object src, Node target) {
		UldBox source = (UldBox) src;
		String sourceType = source.getValue().getType();

		SpaceBox root = (SpaceBox) target.getParent().getParent();
		String targetType = root.getValue().getSpaceType();

		if (target.equals(src)) {
			return false;
		}

		if (sourceType.equals("ULD") && targetType.equals("ULD")) {
			return true;
		}

		if (!sourceType.equals("ULD") && !targetType.equals("ULD")) {
			return true;
		}

		return false;
	}

	/**
	 * 设置拖拽目标的拖拽事件，如果拖拽目标上有ULD或者BULK，则将该ULD或者BULK移动到待配载区。
	 * 
	 * @param target
	 *            拖拽目标
	 */
	private void setDragTargetEvent(Node target) {
		target.setOnDragOver((DragEvent de) -> {
			if (this.isSameBox(de.getGestureSource(), target)) {
				de.acceptTransferModes(TransferMode.COPY_OR_MOVE);
			}

			de.consume();
		});

		target.setOnDragEntered((DragEvent de) -> {
			if (this.isSameBox(de.getGestureSource(), target)) {
				target.getStyleClass().add("-fx-loading-shape-drag");
			}

			de.consume();
		});

		target.setOnDragExited((DragEvent de) -> {
			if (this.isSameBox(de.getGestureSource(), target)) {
				target.getStyleClass().remove("-fx-loading-shape-drag");
			}

			de.consume();
		});

		target.setOnDragDropped((DragEvent de) -> {
			Dragboard db = de.getDragboard();

			boolean success = false;
			if (db.hasString()) {
				if (target instanceof UldBox) {
					BRItemVO tempVO = ((UldBox) target).getValue();
					if (null != tempVO) {
						// 来自配载区舱位
						UldBox box = this.loadingToDoInfo.addBox(tempVO);
						this.setDragSourceEvent(box);
					} else {
						// 来自待配载区
						BoxHelper.initValue((UldBox) target, JsonUtil.fromJson(db.getString(), BRItemVO.class));
					}
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
			if (i == 4) {
				vo.setType("BULK");
			} else {
				vo.setType("ULD");
			}
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

	private DashboardInfoVO getDashboardVO() {
		DashboardInfoVO vo = new DashboardInfoVO();
		vo.setZfwWeight(1234);
		vo.setZfwIndex(12.34);
		vo.setZfwCg(1.234);

		vo.setTowWeight(1212);
		vo.setTowIndex(12.12);
		vo.setTowCg(1.212);

		vo.setLdwWeight(1111);
		vo.setLdwIndex(11.11);
		vo.setLdwCg(1.111);

		vo.setH5(3.3);
		vo.setH15(3.4);
		

		vo.setWeightSurplus(999999);
		vo.setWeightTotal(1234);
		vo.setWeightMain(1234);
		vo.setWeightBelly(1234);
		vo.setWeightOn(1234);
		vo.setWeightOff(1234);
		vo.setNumUldTotal(12);
		vo.setNumBulkTotal(11);
		vo.setNumUldOn(0);
		vo.setNumBulkOn(0);
		return vo;
	}
}
