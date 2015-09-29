package com.sfa.ghs.controller.login;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import com.sfa.common.controller.BaseController;
import com.sfa.common.manager.LocalManager;
import com.sfa.common.util.AlertUtil;
import com.sfa.common.util.SysUser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * Login Controller class
 * 
 * @author 431520
 */
@Component
public class LoginController extends BaseController {

	@FXML
	private TextField loginName;
	@FXML
	private PasswordField password;
	@FXML
	private Button loginBtn;
	@FXML
	private Text errorMessage;
	
	/**
	 * Initializes the controller class.
	 *
	 * @param url
	 * @param rb
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		errorMessage.setText("");
		loginName.setText("admin");
		password.setText("admin");
	}

	/**
	 * 登录
	 * 
	 * @param event
	 */
	@FXML
	public void loginAction(ActionEvent event) {
		try {
			errorMessage.setText("");

			String name = loginName.getText().trim();
			String pwd = password.getText().trim();

			if (name.equals("")) {
				loginName.requestFocus();
				throw new Exception("用户名不能为空");
			}

			if (pwd.equals("")) {
				password.requestFocus();
				throw new Exception("密码不能为空");
			}

			SysUser user = new SysUser();
			user.setName(name);

			LocalManager.setUser(user);
			LocalManager.getApp().gotoMainView();
		} catch (SQLException e) {
			AlertUtil.error(e.getMessage());
		} catch (Exception e) {
			errorMessage.setText(e.getMessage());
		}
	}
}
