package com.sfa.ghs.controller.main;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import com.sfa.common.controller.BaseController;
import com.sfa.common.data.MenuEnum;
import com.sfa.common.data.MenuTypeEnum;
import com.sfa.common.manager.LocalManager;
import com.sfa.common.util.StringUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.input.KeyCombination;

@Component
public class MainController extends BaseController {
	@FXML
	private MenuBar menuBar;
	@FXML
	private TabPane tabPane;
	@FXML
	private Label name;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// 设置用户
		name.setText(LocalManager.getUser().getName());

		// 设置菜单
		this.initMenuBar();
	}

	private void initMenuBar() {
		for (MenuEnum m : MenuEnum.values()) {
			boolean found = false;
			for (Menu menu : this.menuBar.getMenus()) {
				if (menu.getText().contentEquals(m.getParentName())) {
					this.addMenuItem(menu, m);
					found = true;
					break;
				}
			}
			if (!found) {
				Menu menu = new Menu(m.getParentName());
				this.addMenuItem(menu, m);
				this.menuBar.getMenus().add(menu);
			}
		}
	}

	private void addMenuItem(Menu menu, MenuEnum m) {
		if (m.getMenuType().equals(MenuTypeEnum.SEPARATOR)) {
			SeparatorMenuItem menuItem = new SeparatorMenuItem();
			menu.getItems().add(menuItem);
		} else {
			MenuItem menuItem = new MenuItem(m.getName());
			if (StringUtil.isNotEmpty(m.getAccelerator())) {
				menuItem.setAccelerator(KeyCombination.keyCombination(m.getAccelerator()));
			}
			menuItem.setOnAction(event -> {
				if (m.getMenuType().equals(MenuTypeEnum.ALERT)) {
					System.out.println(m.getName() + ", alert");
				} else if (m.getMenuType().equals(MenuTypeEnum.PAGE)) {
					LocalManager.getApp().addTab(tabPane, m.getContent(), m.getName());
				} else if (m.getMenuType().equals(MenuTypeEnum.COMMAND)) {
					if (m.getContent().equals("exit")) {
						System.exit(0);
					}
					System.out.println(m.getName() + ", command");
				}
			});
			menu.getItems().add(menuItem);
		}
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
