package food_system.controller;

import food_system.model.Order;
import food_system.model.OrderDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class OrderUpdateController {
    @FXML
    private TextField orderNo;
    @FXML
    private TextField orderContent;
    @FXML
    private TextField orderPrice;
    @FXML
    private DatePicker orderDate;

    private static Order currentOrder;

    public static void setCurrentOrder(Order currentOrder) {
        OrderUpdateController.currentOrder = currentOrder;
    }

    @FXML
    public void initialize() {
        orderNo.setText(currentOrder.getOrderNo());
        orderContent.setText(currentOrder.getOrderContent());
        orderPrice.setText((Double.toString(currentOrder.getOrderPrice())));
        orderDate.getEditor().setText(currentOrder.getOrderDate().toString());
    }

    public void close(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void update() throws Exception {
        if (orderDate.getValue() == null) {
            OrderDAO.updateData(orderNo.getText(), orderContent.getText(), Double.parseDouble(orderPrice.getText()));
        } else {
            OrderDAO.updateData(orderNo.getText(), orderContent.getText(), Double.parseDouble(orderPrice.getText()), java.sql.Date.valueOf(orderDate.getValue()));
        }
    }
}

