package com.sfa.common.controller;

import org.apache.log4j.Logger;

import javafx.fxml.Initializable;
import javafx.stage.Stage;

public abstract class BaseController implements Initializable {
	public static final Logger logger = Logger.getLogger(BaseController.class);

	// 登录界面和主界面的Stage
	public static Stage mainStage;
	// 模式窗口的Stage
	public static Stage modelStage;

	public Stage curStage;
}
