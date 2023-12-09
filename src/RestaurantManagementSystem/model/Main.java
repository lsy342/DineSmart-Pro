package RestaurantManagementSystem.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {
    private static Stage stage;
    private static User currentUser;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Main.stage = stage;
        stage.setTitle("DineSmart Pro");
        try {
            changeView("../view/login.fxml");
            stage.show();
        } catch (Exception e) {
            Throwable rootCause = e.getCause();
            System.err.println("Exception root cause: " + rootCause);
            e.printStackTrace();
        }
    }

    public static void changeView(String fxml) {
        Parent root;
        try {
            URL r = Main.class.getResource(fxml);
            System.out.println(r.toString());

            root = FXMLLoader.load(Main.class.getResource(fxml));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addView(String fxml) {
        Stage stage = new Stage();
        Parent root;
        try {
            URL r = Main.class.getResource(fxml);
            System.out.println(r.toString());

            root = FXMLLoader.load(Main.class.getResource(fxml));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createUser(User user) {
        currentUser = user;
    }

    public static User readUser() {
        return currentUser;
    }

    public static void successAlert(String string) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Data " + string + " successful");
        alert.setContentText("Please refresh the page!");
        alert.showAndWait();
    }

    public static void warningAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Fail");
        alert.setHeaderText("Insufficient privileges");
        alert.setContentText("Please applying for increased permissions");
        alert.showAndWait();
    }

    public static double formatDouble(double d) {
        return (double) Math.round(d * 1000) / 1000;
    }
}