package RestaurantManagementSystem.controller;

import RestaurantManagementSystem.model.Material;
import RestaurantManagementSystem.model.MaterialDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class MaterialUpdateController {
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

    private static Material currentMaterial;

    public static void setCurrentMaterial(Material currentMaterial) {
        MaterialUpdateController.currentMaterial = currentMaterial;
    }

    @FXML
    public void initialize() {
        materialNo.setText(currentMaterial.getMaterialNo());
        materialName.setText(currentMaterial.getMaterialName());
        materialUnitPrice.setText((Double.toString(currentMaterial.getMaterialUnitPrice())));
        materialNumber.setText((Integer.toString(currentMaterial.getMaterialNumber())));
        materialDate.getEditor().setText(currentMaterial.getMaterialDate().toString());
        materialType.setText(currentMaterial.getMaterialType());
    }

    public void close(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void update() throws Exception {
        if (materialDate.getValue() == null) {
            MaterialDAO.updateData(materialNo.getText(), materialName.getText(), Double.parseDouble(materialUnitPrice.getText()),
                    Integer.parseInt(materialNumber.getText()), materialType.getText());
        } else {
            MaterialDAO.updateData(materialNo.getText(), materialName.getText(), Double.parseDouble(materialUnitPrice.getText()),
                    Integer.parseInt(materialNumber.getText()),java.sql.Date.valueOf(materialDate.getValue()), materialType.getText());
        }
    }
}

