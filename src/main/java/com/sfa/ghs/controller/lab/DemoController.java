package com.sfa.ghs.controller.lab;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import com.sfa.common.controller.BaseController;
import com.sfa.ghs.custom.ui.FlightInfo;
import com.sfa.ghs.custom.vo.FlightInfoVO;

import javafx.fxml.FXML;

@Component
public class DemoController extends BaseController {
	@FXML
	private FlightInfo flightInfo;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initFlightInfo();
	}

	private void initFlightInfo() {
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

		this.flightInfo.initData(vo);
	}

}
