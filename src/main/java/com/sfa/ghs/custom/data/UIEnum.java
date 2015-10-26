package com.sfa.ghs.custom.data;

public enum UIEnum {
	// 配载
	WB_FLIGHT_INFO("/fxml/custom/flightInfo.fxml"),
	WB_LOADING_INFO("/fxml/custom/loadingInfo.fxml"),
	WB_SPACE_BOX("/fxml/custom/spaceBox.fxml"),
	WB_LOADING_TODO_INFO("/fxml/custom/loadingToDoInfo.fxml"),
	WB_DASHBOARD_INFO("/fxml/custom/dashboardInfo.fxml");

	private String file;

	private UIEnum(String file) {
		this.file = file;
	}

	public String getFile() {
		return file;
	}
}
