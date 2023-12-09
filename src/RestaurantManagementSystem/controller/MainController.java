package RestaurantManagementSystem.controller;

import RestaurantManagementSystem.model.Main;
import javafx.fxml.FXML;

public class MainController {
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
}
