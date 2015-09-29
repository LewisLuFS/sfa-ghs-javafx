package com.sfa.ghs.custom.ui;

import java.io.IOException;

import com.sfa.ghs.custom.data.UIEnum;
import com.sfa.ghs.custom.vo.FlightInfoVO;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class FlightInfo extends VBox {
	@FXML
	private Label acNo;
	@FXML
	private Label flightNo;
	@FXML
	private Label flihgtDate;
	@FXML
	private Label dow;
	@FXML
	private Label oilBegin;
	@FXML
	private Label oilValue;
	@FXML
	private TextField mlw;
	@FXML
	private Label flightSect;
	@FXML
	private Label crag;
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
		acNo.textProperty().set(vo.getAcNo());
		flightNo.textProperty().set(vo.getFlightNo());
		flihgtDate.textProperty().set(vo.getFlihgtDate());
		dow.textProperty().set(vo.getDow());
		oilBegin.textProperty().set(vo.getOilBegin());
		oilValue.textProperty().set(vo.getOilValue());
		flightSect.textProperty().set(vo.getFlightSect());
		crag.textProperty().set(vo.getCrag());
		ver.textProperty().set(vo.getVer());
	}
}
