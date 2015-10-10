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
import com.sfa.ghs.custom.ui.LoadingToDoInfo;
import com.sfa.ghs.custom.vo.BRItemVO;
import com.sfa.ghs.custom.vo.FlightInfoVO;
import com.sfa.ghs.custom.vo.SpaceItemVO;

import javafx.fxml.FXML;

@Component
public class DemoController extends BaseController {
	@FXML
	private FlightInfo flightInfo;
	@FXML
	private LoadingInfo loadingInfo;
	@FXML
	private LoadingToDoInfo loadingToDoInfo;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.flightInfo.initData(this.getFlightVO());
		this.loadingInfo.initBaseInfo(this.getSpaceItemVOs());
		this.loadingToDoInfo.initData(this.getBRItemVOs());
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

		for (int i = 1; i <= 14; i++) {
			SpaceItemVO itemVO = new SpaceItemVO("ULD", "C" + i, (3000 + i), 1);
			result.add(itemVO);
		}

		for (int i = 1; i <= 3; i++) {
			SpaceItemVO itemVO = new SpaceItemVO("BULK_FWD", "F" + i, (300 + i), 1);
			if (i == 3) {
				itemVO.setLoadAmount(2);
			}
			result.add(itemVO);
		}

		for (int i = 1; i <= 3; i++) {
			SpaceItemVO itemVO = new SpaceItemVO("BULK_AFT", "A" + i, (350 + i), 1);
			if (i == 1) {
				itemVO.setLoadAmount(3);
			}
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
