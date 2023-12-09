package RestaurantManagementSystem.controller;

import RestaurantManagementSystem.model.ReviewDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ReviewAddController {
    @FXML
    private TextField reviewNo;
    @FXML
    private TextField orderNo;
    @FXML
    private TextField reviewContent;
    @FXML
    private DatePicker orderDate;


    public void close(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void insert() throws Exception {
        ReviewDAO.addData(reviewNo.getText(), orderNo.getText(), reviewContent.getText(), java.sql.Date.valueOf(orderDate.getValue()));
    }
}

