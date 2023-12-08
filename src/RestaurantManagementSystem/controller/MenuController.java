package RestaurantManagementSystem.controller;

import RestaurantManagementSystem.model.Main;
import RestaurantManagementSystem.model.Menu;
import RestaurantManagementSystem.model.MenuDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class MenuController {
    @FXML
    private TableView<Menu> menuTable;
    @FXML
    private TableColumn<Menu, String> menuNo;
    @FXML
    private TableColumn<Menu, String> menuName;
    @FXML
    private TableColumn<Menu, Double> menuPrice;

    @FXML
    private TextField search;

    @FXML
    public void initialize() throws Exception {
        List<Menu> menuList = new ArrayList<>();
        menuList = MenuDAO.readData(menuList);

        menuNo.setCellValueFactory(new PropertyValueFactory<>("menuNo"));
        menuName.setCellValueFactory(new PropertyValueFactory<>("menuName"));
        menuPrice.setCellValueFactory(new PropertyValueFactory<>("menuPrice"));


        menuTable.setItems(FXCollections.observableList(menuList));
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
    public void addMenuAddView() {
        Main.addView("../view/menuAdd.fxml");
    }

    private void addMenuUpdateView() {
        Menu menu = menuTable.getSelectionModel().getSelectedItem();
        //选中行不为空，则跳转
        if (menu != null) {
            MenuUpdateController.setCurrentMenu(menu);
            Main.addView("../view/menuUpdate.fxml");
        }
    }

    @FXML
    public void search() throws Exception {
        List<Menu> menuList = MenuDAO.searchData(search.getText());

        menuNo.setCellValueFactory(new PropertyValueFactory<>("menuNo"));
        menuName.setCellValueFactory(new PropertyValueFactory<>("menuName"));
        menuPrice.setCellValueFactory(new PropertyValueFactory<>("menuPrice"));

        menuTable.setItems(FXCollections.observableList(menuList));
    }


    @FXML
    public void insert() {
        addMenuAddView();
    }

    @FXML
    public void update() {
        addMenuUpdateView();
    }


    @FXML
    public void delete() throws Exception {
        Menu selectedMenu = menuTable.getSelectionModel().getSelectedItem();
        if (selectedMenu != null) {
            MenuDAO.deleteData(selectedMenu.getMenuNo());
        }
    }


    @FXML
    public void refresh() {
        toMenuView();
    }
}

