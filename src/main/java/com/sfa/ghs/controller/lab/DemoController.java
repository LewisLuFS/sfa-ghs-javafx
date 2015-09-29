package com.sfa.ghs.controller.lab;

import java.net.URL;
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
		vo.setAcNo("B2899");
		vo.setFlightNo("O31234");
		vo.setFlihgtDate("2015-01-01");
		vo.setDow("1234");
		vo.setOilBegin("16189");
		vo.setOilValue("9798");
		vo.setMlw("11111");
		vo.setFlightSect("SZX-HGH");
		vo.setCrag("3/0");
		vo.setVer("5");

		this.flightInfo.initData(vo);
	}

}
