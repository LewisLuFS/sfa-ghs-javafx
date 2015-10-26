package com.sfa.ghs.custom.ui;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.sfa.common.exception.SfaException;
import com.sfa.ghs.custom.data.UIEnum;
import com.sfa.ghs.custom.vo.DashboardInfoVO;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * 自定义组件：DASHBOARD
 * 
 * @author 431520
 */
public class DashboardInfo extends VBox {
	public static final Logger log = Logger.getLogger(DashboardInfo.class);

	@FXML
	private Label zfwWeight;
	@FXML
	private Label zfwIndex;
	@FXML
	private Label zfwCg;
	@FXML
	private Label towWeight;
	@FXML
	private Label towIndex;
	@FXML
	private Label towCg;
	@FXML
	private Label ldwWeight;
	@FXML
	private Label ldwIndex;
	@FXML
	private Label ldwCg;

	@FXML
	private Label h5;
	@FXML
	private Label h15;

	@FXML
	private Label weightSurplus;
	@FXML
	private Label weightTotal;
	@FXML
	private Label weightMain;
	@FXML
	private Label weightBelly;
	@FXML
	private Label weightOn;
	@FXML
	private Label weightOff;
	@FXML
	private Label numUldTotal;
	@FXML
	private Label numBulkTotal;
	@FXML
	private Label numUldOn;
	@FXML
	private Label numBulkOn;

	public DashboardInfo() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(UIEnum.WB_DASHBOARD_INFO.getFile()));
			fxmlLoader.setRoot(this);
			fxmlLoader.setController(this);
			fxmlLoader.load();
		} catch (IOException e) {
			log.error(e);
			throw new SfaException(e);
		}
	}

	/**
	 * 初始化航班信息
	 * 
	 * @param vo
	 */
	public void initData(DashboardInfoVO vo) {
		zfwWeight.textProperty().set(String.valueOf(vo.getZfwWeight()));
		zfwIndex.textProperty().set(String.valueOf(vo.getZfwIndex()));
		zfwCg.textProperty().set(String.valueOf(vo.getZfwCg()));
		towWeight.textProperty().set(String.valueOf(vo.getTowWeight()));
		towIndex.textProperty().set(String.valueOf(vo.getTowIndex()));
		towCg.textProperty().set(String.valueOf(vo.getTowCg()));
		ldwWeight.textProperty().set(String.valueOf(vo.getLdwWeight()));
		ldwIndex.textProperty().set(String.valueOf(vo.getLdwIndex()));
		ldwCg.textProperty().set(String.valueOf(vo.getLdwCg()));

		h5.textProperty().set(String.valueOf(vo.getH5()));
		h15.textProperty().set(String.valueOf(vo.getH15()));

		weightSurplus.textProperty().set(String.valueOf(vo.getWeightSurplus()));
		weightTotal.textProperty().set(String.valueOf(vo.getWeightTotal()));
		weightMain.textProperty().set(String.valueOf(vo.getWeightMain()));
		weightBelly.textProperty().set(String.valueOf(vo.getWeightBelly()));
		weightOn.textProperty().set(String.valueOf(vo.getWeightOn()));
		weightOff.textProperty().set(String.valueOf(vo.getWeightOff()));
		numUldTotal.textProperty().set(String.valueOf(vo.getNumUldTotal()));
		numBulkTotal.textProperty().set(String.valueOf(vo.getNumBulkTotal()));
		numUldOn.textProperty().set(String.valueOf(vo.getNumUldOn()));
		numBulkOn.textProperty().set(String.valueOf(vo.getNumBulkOn()));
	}
}
