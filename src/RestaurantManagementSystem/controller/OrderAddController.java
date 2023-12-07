package RestaurantManagementSystem.controller;

import RestaurantManagementSystem.model.OrderDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class OrderAddController {
    @FXML
    private TextField orderNo;
    @FXML
    private TextField orderContent;
    @FXML
    private TextField orderPrice;
    @FXML
    private DatePicker orderDate;


    public void close(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void insert() throws Exception {
        OrderDAO.addData(orderNo.getText(), orderContent.getText(), Double.parseDouble(orderPrice.getText()), java.sql.Date.valueOf(orderDate.getValue()));
    }
}

