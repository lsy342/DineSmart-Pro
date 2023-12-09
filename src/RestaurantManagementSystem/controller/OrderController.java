package RestaurantManagementSystem.controller;

import RestaurantManagementSystem.model.Main;
import RestaurantManagementSystem.model.Order;
import RestaurantManagementSystem.model.OrderDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class OrderController {
    @FXML
    private TableView<Order> orderTable;
    @FXML
    private TableColumn<Order, String> orderNo;
    @FXML
    private TableColumn<Order, String> orderContent;
    @FXML
    private TableColumn<Order, Double> orderPrice;
    @FXML
    private TableColumn<Order, String> orderDate;
    @FXML
    private TextField search;

    @FXML
    public void initialize() throws Exception {
        List<Order> orderList = new ArrayList<>();
        orderList = OrderDAO.readData(orderList);

        orderNo.setCellValueFactory(new PropertyValueFactory<>("orderNo"));
        orderContent.setCellValueFactory(new PropertyValueFactory<>("orderContent"));
        orderPrice.setCellValueFactory(new PropertyValueFactory<>("orderPrice"));
        orderDate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));

        orderTable.setItems(FXCollections.observableList(orderList));
    }


    @FXML
    public void toMainView() {
        Main.changeView("../view/main.fxml");
    }

    @FXML
    public void toMaterialView() {
        Main.changeView("../view/material.fxml");
    }

    @FXML
    public void toOrderView() {
        Main.changeView("../view/order.fxml");
    }

    @FXML
    public void toMenuView() {
        Main.changeView("../view/menu.fxml");
    }

    @FXML
    public void toReviewView() {
        Main.changeView("../view/review.fxml");
    }

    @FXML
    public void addOrderAddView() {
        Main.addView("../view/orderAdd.fxml");
    }

    private void addOrderUpdateView() {
        Order order = orderTable.getSelectionModel().getSelectedItem();
        //选中行不为空，则跳转
        if (order != null) {
            OrderUpdateController.setCurrentOrder(order);
            Main.addView("../view/orderUpdate.fxml");
        }
    }

    private void addTaxCalculateView(){
        Main.addView("../view/orderTaxCalculate.fxml");
    }

    @FXML
    public void search() throws Exception {
        List<Order> orderList = OrderDAO.searchData(search.getText());

        orderNo.setCellValueFactory(new PropertyValueFactory<>("orderNo"));
        orderContent.setCellValueFactory(new PropertyValueFactory<>("orderContent"));
        orderPrice.setCellValueFactory(new PropertyValueFactory<>("orderPrice"));
        orderDate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));

        orderTable.setItems(FXCollections.observableList(orderList));
    }

    @FXML
    public void insert() {
        addOrderAddView();
    }

    @FXML
    public void update() {
        addOrderUpdateView();
    }

    @FXML
    public void delete() throws Exception {
        Order selectedOrder = orderTable.getSelectionModel().getSelectedItem();
        if (selectedOrder != null) {
            OrderDAO.deleteData(selectedOrder.getOrderNo());
        }
    }

    @FXML
    public void refresh() {
        toOrderView();
    }

    @FXML
    public void print() {
        Main.successAlert("print");
    }

    @FXML
    public void taxCalculate() {
        addTaxCalculateView();
    }
}
