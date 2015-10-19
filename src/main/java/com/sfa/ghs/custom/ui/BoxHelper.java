package com.sfa.ghs.custom.ui;

import java.util.ArrayList;
import java.util.List;

import com.sfa.common.util.StringUtil;
import com.sfa.ghs.custom.vo.BRItemVO;

import javafx.scene.control.Label;

public class BoxHelper {
	/**
	 * 配载区，初始化空的舱位
	 * 
	 * @param num
	 * @return
	 */
	public static List<UldBox> newEmptyBoxes(int num) {
		List<UldBox> result = new ArrayList<UldBox>();

		for (int i = 0; i < num; i++) {
			UldBox empty = new UldBox();
			empty.getStyleClass().add("-fx-loading-shape");
			result.add(empty);
		}

		return result;
	}

	/**
	 * 待配载区，初始化拼装单的ULD和BULK
	 * 
	 * @param vo
	 * @return
	 */
	public static UldBox newValueBox(BRItemVO vo) {
		if (null == vo) {
			return null;
		}

		if (StringUtil.isEmpty(vo.getUldNo())) {
			return null;
		}

		UldBox box = new UldBox();
		initValue(box, vo);
		box.getStyleClass().add("-fx-loadingToDo-shape");
		return box;
	}

	/**
	 * 初始化集装器信息，以下情况调用：
	 * <ul>
	 * <li>初始化待配载区时</li>
	 * <li>拖拽完成后，拖拽目标舱位初始化时</li>
	 * </ul>
	 * 
	 * @param box
	 * @param vo
	 */
	public static void initValue(UldBox box, BRItemVO vo) {
		box.getChildren().removeAll(box.getChildren());
		box.getStyleClass().remove("-fx-loadingToDo-shape");

		box.setValue(vo);

		String uldNo = vo.getUldNo();
		if (uldNo.length() == 10) {
			initAdvanceBox(box, vo);
		} else {
			initSimpleBox(box, vo);
		}
	}

	/**
	 * 拖拽完成后，清空拖拽源舱位，用于舱位件拖拽
	 * 
	 * @param box
	 */
	public static void clearValue(UldBox box) {
		box.getChildren().removeAll(box.getChildren());
		box.clearValue();
	}

	private static void initSimpleBox(UldBox box, BRItemVO vo) {
		Label uldNo = new Label(vo.getUldNo());
		Label weight = new Label(String.valueOf(vo.getWeight()));
		Label dest = new Label(vo.getDest());

		box.getChildren().addAll(uldNo, weight, dest);
	}

	private static void initAdvanceBox(UldBox box, BRItemVO vo) {
		Label uldType = new Label(vo.getUldNo().substring(0, 3));
		Label uldNo = new Label(vo.getUldNo().substring(3, vo.getUldNo().length() - 2));
		Label uldCarrier = new Label(vo.getUldNo().substring(vo.getUldNo().length() - 2));
		Label weight = new Label(String.valueOf(vo.getWeight()));
		Label dest = new Label(vo.getDest());

		box.getChildren().addAll(uldType, uldNo, uldCarrier, weight, dest);
	}
}
