package com.sfa.common.util;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sfa.common.controller.BaseController;
import com.sfa.common.data.FxmlEnum;
import com.sfa.common.exception.SfaException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * Scene工具
 * 
 * @author 431520
 */
public class SceneUtil {
	public static final void initScene(FxmlEnum fxmlEnum) throws SfaException, IOException {
		Parent root = initLoader(fxmlEnum.getFile()).load();
		Scene scene = new Scene(root, fxmlEnum.getWidth(), fxmlEnum.getHeight());
		BaseController.mainStage.setScene(scene);
		BaseController.mainStage.centerOnScreen();
		BaseController.mainStage.sizeToScene();
		BaseController.mainStage.setTitle(fxmlEnum.getTitle());
		BaseController.mainStage.setResizable(fxmlEnum.isResizable());
		BaseController.mainStage.setMaximized(false);
	}

	public static final void openScene(FxmlEnum fxmlEnum) throws SfaException, IOException {
		final Stage stage = new Stage();
		BaseController.modelStage = stage;
		Parent root = initLoader(fxmlEnum.getFile()).load();
		Scene scene = new Scene(root, fxmlEnum.getWidth(), fxmlEnum.getHeight());
		BaseController.modelStage.setScene(scene);
		BaseController.modelStage.initModality(Modality.APPLICATION_MODAL);
		BaseController.modelStage.initOwner(BaseController.mainStage);
		BaseController.modelStage.setTitle(fxmlEnum.getTitle());
		BaseController.modelStage.setResizable(fxmlEnum.isResizable());
		BaseController.modelStage.show();
	}

	/**
	 * 在指定TabPane上加入Tab
	 * 
	 * @param tabPane
	 *            指定TabPane
	 * @param fxml
	 *            Tab的FXML
	 * @param tabName
	 *            Tab Name
	 * @throws SfaException
	 * @throws IOException
	 */
	public static final void addTab(TabPane tabPane, String fxml, String tabName) throws SfaException, IOException {

		int tabIndex = -1;
		for (Tab t : tabPane.getTabs()) {
			if (t.getText().equals(tabName)) {
				tabIndex = tabPane.getTabs().indexOf(t);
				break;
			}
		}

		if (tabIndex == -1) {// 不存在
			Parent root = initLoader(fxml).load();
			Tab tab = new Tab(tabName);
			tab.setContent(root);

			tabPane.getTabs().add(tab);
			tabPane.getSelectionModel().select(tab);
		} else {// 存在
			tabPane.getSelectionModel().select(tabIndex);
		}
	}

	/**
	 * 根据fxml文件路径返回FXMLLoader，绑定Controller
	 * 
	 * @param fxml
	 * @return
	 * @throws SfaException
	 */
	private static final FXMLLoader initLoader(String fxml) throws SfaException {
		FXMLLoader loader = new FXMLLoader(SceneUtil.class.getResource(fxml));

		loader.setControllerFactory(new Callback<Class<?>, Object>() {
			@Override
			public Object call(Class<?> aClass) {
				return SceneUtil.context.getBean(aClass);
			}
		});
		return loader;
	}

	public static final ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
}
