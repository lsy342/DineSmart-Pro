package RestaurantManagementSystem.controller;

import RestaurantManagementSystem.model.Menu;
import RestaurantManagementSystem.model.MenuDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class MenuUpdateController {
    @FXML
    private TextField menuNo;
    @FXML
    private TextField menuName;
    @FXML
    private TextField menuPrice;


    private static Menu currentMenu;

    public static void setCurrentMenu(Menu currentMenu) {
        MenuUpdateController.currentMenu = currentMenu;
    }

    @FXML
    public void initialize() {
        menuNo.setText(currentMenu.getMenuNo());
        menuName.setText(currentMenu.getMenuName());
        menuPrice.setText((Double.toString(currentMenu.getMenuPrice())));

    }

    public void close(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void update() throws Exception {

            MenuDAO.updateData(menuNo.getText(), menuName.getText(), Double.parseDouble(menuPrice.getText()));

    }
}


