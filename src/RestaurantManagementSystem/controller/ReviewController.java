package RestaurantManagementSystem.controller;


import RestaurantManagementSystem.model.Main;
import RestaurantManagementSystem.model.Review;
import RestaurantManagementSystem.model.ReviewDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class ReviewController {
    @FXML
    private TableView<Review> reviewTable;
    @FXML
    private TableColumn<Review, String> reviewNo;
    @FXML
    private TableColumn<Review, String> orderNo;
    @FXML
    private TableColumn<Review, String> reviewContent;
    @FXML
    private TableColumn<Review, String> orderDate;
    @FXML
    private TextField search;

    @FXML
    public void initialize() throws Exception {
        List<Review> reviewList = new ArrayList<>();
        reviewList = ReviewDAO.readData(reviewList);

        reviewNo.setCellValueFactory(new PropertyValueFactory<>("reviewNo"));
        orderNo.setCellValueFactory(new PropertyValueFactory<>("orderNo"));
        reviewContent.setCellValueFactory(new PropertyValueFactory<>("reviewContent"));
        orderDate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));

        reviewTable.setItems(FXCollections.observableList(reviewList));
    }


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

    @FXML
    public void addReviewAddView() {
        Main.addView("../view/reviewAdd.fxml");
    }

    private void addReviewUpdateView() {
        Review review = reviewTable.getSelectionModel().getSelectedItem();
        //选中行不为空，则跳转
        if (review != null) {
            ReviewUpdateController.setCurrentReivew(review);
            Main.addView("../view/reviewUpdate.fxml");
        }
    }

    @FXML
    public void search() throws Exception {
        List<Review> reviewList = ReviewDAO.searchData(search.getText());

        reviewNo.setCellValueFactory(new PropertyValueFactory<>("reviewNo"));
        orderNo.setCellValueFactory(new PropertyValueFactory<>("orderNo"));
        reviewContent.setCellValueFactory(new PropertyValueFactory<>("reviewContent"));
        orderDate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));

        reviewTable.setItems(FXCollections.observableList(reviewList));
    }


    @FXML
    public void insert() {
        if (Main.readUser().getUserAuthority()) {
            addReviewAddView();
        } else {
            Main.warningAlert();
        }
    }

    @FXML
    public void update() {
        if (Main.readUser().getUserAuthority()) {
            addReviewUpdateView();
        } else {
            Main.warningAlert();
        }
    }

    @FXML
    public void delete() throws Exception {
        if (Main.readUser().getUserAuthority()) {
            Review selectedReview = reviewTable.getSelectionModel().getSelectedItem();
            if (selectedReview != null) {
                ReviewDAO.deleteData(selectedReview.getReviewNo());
            }
        } else {
            Main.warningAlert();
        }
    }

    @FXML
    public void refresh() {
        toReviewView();
    }

    @FXML
    public void print() {
        Main.successAlert("print");
    }
}