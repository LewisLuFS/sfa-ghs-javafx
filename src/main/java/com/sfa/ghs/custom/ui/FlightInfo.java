package com.sfa.ghs.custom.ui;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.sfa.common.exception.SfaException;
import com.sfa.common.util.DateUtil;
import com.sfa.ghs.custom.data.UIEnum;
import com.sfa.ghs.custom.vo.FlightInfoVO;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * 自定义组件：航班信息
 * 
 * @author 431520
 */
public class FlightInfo extends VBox {
	public static final Logger log = Logger.getLogger(FlightInfo.class);

	@FXML
	private Label acRegNo;
	@FXML
	private Label flightNo;
	@FXML
	private Label flihgtDate;
	@FXML
	private Label dow;
	@FXML
	private Label takeoffFuel;
	@FXML
	private Label tripFuel;
	@FXML
	private TextField mtow;
	@FXML
	private Label flightSect;
	@FXML
	private Label crew;
	@FXML
	private CheckBox lifeRafts;
	@FXML
	private Label doi;
	@FXML
	private Label takeoffFuelIndex;
	@FXML
	private Label loadingFuelIndex;
	@FXML
	private TextField mlw;
	@FXML
	private Label ver;

	public FlightInfo() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(UIEnum.WB_FLIGHT_INFO.getFile()));
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
	public void initData(FlightInfoVO vo) {
		acRegNo.textProperty().set(vo.getAcRegNo());
		flightNo.textProperty().set(vo.getFlightNo());
		flihgtDate.textProperty().set(DateUtil.formatDate(vo.getFlihgtDate().getTime()));
		dow.textProperty().set(String.valueOf(vo.getDow()));
		takeoffFuel.textProperty().set(String.valueOf(vo.getTakeoffFuel()));
		tripFuel.textProperty().set(String.valueOf(vo.getTripFuel()));
		flightSect.textProperty().set(vo.getFlightSect());
		crew.textProperty().set(vo.getCrew());
		doi.textProperty().set(String.valueOf(vo.getDoi()));
		takeoffFuelIndex.textProperty().set(String.valueOf(vo.getTakeoffFuelIndex()));
		loadingFuelIndex.textProperty().set(String.valueOf(vo.getLoadingFuelIndex()));
		ver.textProperty().set(String.valueOf(vo.getVer()));
	}
}
