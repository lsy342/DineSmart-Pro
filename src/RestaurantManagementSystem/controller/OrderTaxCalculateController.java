package RestaurantManagementSystem.controller;

import RestaurantManagementSystem.model.OrderDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.Date;


public class OrderTaxCalculateController {
    @FXML
    private DatePicker orderDateFrom;
    @FXML
    private DatePicker orderDateTo;
    @FXML
    private Label revenue;
    @FXML
    private Label tax;

    public void close(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void taxCalculate() throws Exception {
        double[] list = OrderDAO.taxCalculate(Date.valueOf(orderDateFrom.getValue()), Date.valueOf(orderDateTo.getValue()));
        revenue.setText(list[0] +"￥");
        tax.setText(list[1] +"￥");
    }
}

