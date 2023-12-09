package RestaurantManagementSystem.controller;

import RestaurantManagementSystem.model.Review;
import RestaurantManagementSystem.model.ReviewDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ReviewUpdateController {
    @FXML
    private TextField reviewNo;
    @FXML
    private TextField orderNo;
    @FXML
    private TextField reviewContent;
    @FXML
    private DatePicker orderDate;

    private static Review currentReview;

    public static void setCurrentReivew(Review currentReview) {
        ReviewUpdateController.currentReview = currentReview;
    }

    @FXML
    public void initialize() {
        reviewNo.setText(currentReview.getReviewNo());
        orderNo.setText(currentReview.getOrderNo());
        reviewContent.setText(currentReview.getReviewContent());
        orderDate.getEditor().setText(currentReview.getOrderDate().toString());
    }

    public void close(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void update() throws Exception {
        if (orderDate.getValue() == null) {
            ReviewDAO.updateData(reviewNo.getText(), orderNo.getText(), reviewContent.getText());
        } else {
            ReviewDAO.updateData(reviewNo.getText(), orderNo.getText(), reviewContent.getText(), java.sql.Date.valueOf(orderDate.getValue()));
        }
    }
}


