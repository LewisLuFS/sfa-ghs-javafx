package com.sfa.ghs.controller.about;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import com.sfa.common.controller.BaseController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

/**
 * About Controller class
 * 
 * @author 431520
 */
@Component
public class AboutController extends BaseController {
	@FXML
	private Text verNo;
	@FXML
	private Text verDate;
	@FXML
	private Text support;
	@FXML
	private Text copyright;

	/**
	 * Initializes the controller class.
	 * 
	 * @param url
	 * @param rb
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		this.verNo.setText("1.0");
		this.verDate.setText("2015-05-13");
		this.support.setText("GHS项目组");
		this.copyright.setText("顺丰航空有限公司");
	}

	/**
	 * 关闭关于页面
	 * 
	 * @param event
	 */
	public void closeAction(ActionEvent event) {
		BaseController.modelStage.close();
	}
}
