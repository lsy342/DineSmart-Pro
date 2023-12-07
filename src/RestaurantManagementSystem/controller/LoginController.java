package RestaurantManagementSystem.controller;


import RestaurantManagementSystem.model.Main;
import RestaurantManagementSystem.model.UserDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;


public class LoginController {
    @FXML
    private TextField account;
    @FXML
    private PasswordField password;


    @FXML
    public void handleLogin() {
        UserDAO userDAO = new UserDAO();
        try {
            if (userDAO.isValidUser(account.getText(), password.getText())) {
                showWelcomeDialog(account.getText());
                Main.changeView("../view/main.fxml");
            } else {
                showAlert("Invalid login", "Please check your username and password.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void showWelcomeDialog(String username) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Welcome");
        alert.setHeaderText("Login Successful");
        alert.setContentText("Welcome, " + username + "!");
        alert.showAndWait();
    }

    public void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
