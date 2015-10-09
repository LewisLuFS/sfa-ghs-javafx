package com.sfa.ghs.controller.main;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import com.sfa.common.controller.BaseController;
import com.sfa.common.data.MenuEnum;
import com.sfa.common.manager.LocalManager;
import com.sfa.common.util.StringUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TabPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.text.Text;

/**
 * Main Controller class
 * 
 * @author 431520
 */
@Component
public class MainController extends BaseController {

	@FXML
	private Hyperlink name;
	@FXML
	private TabPane tabPane;
	@FXML
	private TreeView<String> treeView;

	/**
	 * Initializes the controller class.
	 * 
	 * @param url
	 * @param rb
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// 设置用户
		name.setText(LocalManager.getUser().getName());

		// 设置菜单
		this.initMenu();
	}

	private void initMenu() {
		TreeItem<String> rootNode = new TreeItem<>("所有菜单");

		for (MenuEnum menu : MenuEnum.values()) {
			TreeItem<String> menuLeaf = new TreeItem<String>(menu.getName());
			boolean found = false;
			for (TreeItem<String> menuNode : rootNode.getChildren()) {
				if (menuNode.getValue().contentEquals(menu.getParentName())) {
					menuNode.getChildren().add(menuLeaf);
					found = true;
					break;
				}
			}
			if (!found) {
				TreeItem<String> menuNode = new TreeItem<>(menu.getParentName());
				rootNode.getChildren().add(menuNode);
				menuNode.getChildren().add(menuLeaf);
				menuNode.setExpanded(true);
			}
		}

		treeView.setRoot(rootNode);
		treeView.setShowRoot(false);
		treeView.setOnMouseClicked(event -> {
			if (event.getTarget() instanceof Text) {
				Text menu = (Text) event.getTarget();

				MenuEnum menuEnum = MenuEnum.find(menu.getText(), null);

				if (null != menuEnum && StringUtil.isNotEmpty(menuEnum.getFile())) {
					LocalManager.getApp().addTab(tabPane, menuEnum.getFile(), menuEnum.getName());
				}
			}
		});
	}

	/**
	 * 退出登录
	 * 
	 * @param event
	 */
	@FXML
	public void logoutAction(ActionEvent event) {
		LocalManager.cleanUser();
		LocalManager.getApp().gotoLoginView();
	}
}
