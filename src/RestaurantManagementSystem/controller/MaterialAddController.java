package RestaurantManagementSystem.controller;

import RestaurantManagementSystem.model.MaterialDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class MaterialAddController {
    @FXML
    private TextField materialNo;
    @FXML
    private TextField materialName;
    @FXML
    private TextField materialUnitPrice;
    @FXML
    private TextField materialNumber;
    @FXML
    private TextField materialType;
    @FXML
    private DatePicker materialDate;


    public void close(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void insert() throws Exception {
        MaterialDAO.addData(materialNo.getText(), materialName.getText(), Double.parseDouble(materialUnitPrice.getText()),
                Integer.parseInt(materialNumber.getText()) , java.sql.Date.valueOf(materialDate.getValue()), materialType.getText());
    }
}
