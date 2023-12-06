package food_system.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {
    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        Main.stage = stage;
        stage.setTitle("Fast Food Billing System");
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

    public static double formatDouble(double d) {
        return (double) Math.round(d * 1000) / 1000;
    }
}