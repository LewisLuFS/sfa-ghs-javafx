package com.sfa.ghs.custom.data;

public enum UIEnum {
	// 配载
	WB_FLIGHT_INFO("/fxml/custom/flightInfo.fxml");

	private String file;

	private UIEnum(String file) {
		this.file = file;
	}

	public String getFile() {
		return file;
	}

}
