package org.lewis.sky.demo.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;

import org.lewis.sky.demo.domain.Customer;
import org.lewis.sky.fxml.FxmlController;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

@Component
public class CustomerListController extends FxmlController implements Initializable {

	private List<Customer> customers;
	private ObservableList<Customer> data;

	@FXML
	private TableView<Customer> tableView;
	@FXML
	private TableColumn<Customer, String> idCol;
	@FXML
	private TableColumn<Customer, String> nameCol;
	@FXML
	private TableColumn<Customer, Date> regDateCol;
	@FXML
	private TableColumn<Customer, String> phoneCol;
	@FXML
	private TableColumn<Customer, String> remarkCol;

	public CustomerListController() {
		super("/fxml/demo/customerList.fxml");
	}

	@PostConstruct
	public void initCustomer() {
		customers = new ArrayList<>();

		for (int i = 1; i <= 30; i++) {
			Customer customer = new Customer(i, "Name " + i, new Date(), (13512345670l + i) + "",
					"aaaaaaaaaaaaaaaaaaaaaaaa" + i);
			customers.add(customer);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		regDateCol.setCellValueFactory(new PropertyValueFactory<>("regDate"));
		phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
		remarkCol.setCellValueFactory(new PropertyValueFactory<>("remark"));
		
		data = FXCollections.observableArrayList(customers);
		tableView.setItems(data);
	}

}
