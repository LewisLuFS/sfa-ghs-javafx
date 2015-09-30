package com.sfa;

import org.apache.log4j.Logger;

import com.sfa.common.controller.BaseController;
import com.sfa.common.data.FxmlEnum;
import com.sfa.common.manager.LocalManager;
import com.sfa.common.util.SceneUtil;

import javafx.application.Application;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	public final static Logger logger = Logger.getLogger(MainApp.class);

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		BaseController.mainStage = stage;
		LocalManager.setApp(this);
		this.gotoLoginView();
		stage.show();
	}

	public void gotoLoginView() {
		try {
			SceneUtil.initScene(FxmlEnum.login);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	public void gotoMainView() {
		try {
			SceneUtil.initScene(FxmlEnum.main);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	public void addTab(TabPane tabPane, String fxml, String tabName) {
		try {
			SceneUtil.addTab(tabPane, fxml, tabName);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
