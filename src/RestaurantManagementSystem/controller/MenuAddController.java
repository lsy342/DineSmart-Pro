package RestaurantManagementSystem.controller;

import RestaurantManagementSystem.model.MenuDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class MenuAddController {
    @FXML
    private TextField menuNo;
    @FXML
    private TextField menuName;
    @FXML
    private TextField menuPrice;



    public void close(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void insert() throws Exception {
        MenuDAO.addData(menuNo.getText(), menuName.getText(), Double.parseDouble(menuPrice.getText()));
    }
}


