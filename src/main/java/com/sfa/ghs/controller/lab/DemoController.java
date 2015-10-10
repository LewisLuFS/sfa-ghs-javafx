package com.sfa.ghs.controller.lab;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import com.sfa.common.controller.BaseController;
import com.sfa.ghs.custom.ui.FlightInfo;
import com.sfa.ghs.custom.ui.LoadingInfo;
import com.sfa.ghs.custom.vo.FlightInfoVO;
import com.sfa.ghs.custom.vo.SpaceItemVO;
import com.sfa.ghs.custom.vo.SpaceVO;

import javafx.fxml.FXML;

@Component
public class DemoController extends BaseController {
	@FXML
	private FlightInfo flightInfo;
	@FXML
	private LoadingInfo loadingInfo;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.flightInfo.initData(this.getFlightVO());
		this.loadingInfo.initData(this.getSpaceVO());
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

	private SpaceVO getSpaceVO() {
		SpaceVO vo = new SpaceVO();

		List<SpaceItemVO> mainSpaces = new ArrayList<SpaceItemVO>();
		for (int i = 1; i <= 14; i++) {
			SpaceItemVO itemVO = new SpaceItemVO("C" + i, 1);
			mainSpaces.add(itemVO);
		}
		vo.setMainSpaces(mainSpaces);

		List<SpaceItemVO> fwdSpaces = new ArrayList<SpaceItemVO>();
		for (int i = 1; i <= 3; i++) {
			SpaceItemVO itemVO = new SpaceItemVO("F" + i, 1);
			if (i == 3) {
				itemVO.setNum(2);
			}
			fwdSpaces.add(itemVO);
		}
		vo.setFwdSpaces(fwdSpaces);

		List<SpaceItemVO> aftSpaces = new ArrayList<SpaceItemVO>();
		for (int i = 1; i <= 3; i++) {
			SpaceItemVO itemVO = new SpaceItemVO("A" + i, 1);
			if (i == 1) {
				itemVO.setNum(4);
			}
			aftSpaces.add(itemVO);
		}
		vo.setAftSpaces(aftSpaces);

		return vo;
	}
}
