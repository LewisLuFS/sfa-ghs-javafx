package com.sfa.ghs.custom.ui;

import java.io.IOException;

import com.sfa.common.util.DateUtil;
import com.sfa.ghs.custom.data.UIEnum;
import com.sfa.ghs.custom.vo.FlightInfoVO;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class FlightInfo extends VBox {
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
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(UIEnum.WB_FLIGHT_INFO.getFile()));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
			initialize();
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
	}

	private void initialize() {
		this.setSpacing(5);
		this.setPadding(new Insets(2, 5, 2, 5));
		this.getStyleClass().setAll("vBox");
	}

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
