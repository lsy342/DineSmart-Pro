package RestaurantManagementSystem.controller;

import RestaurantManagementSystem.model.Main;
import RestaurantManagementSystem.model.Material;
import RestaurantManagementSystem.model.MaterialDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class MaterialController {
    @FXML
    private TableView<Material> materialTable;
    @FXML
    private TableColumn<Material, String> materialNo;
    @FXML
    private TableColumn<Material, String> materialName;
    @FXML
    private TableColumn<Material, Double> materialUnitPrice;
    @FXML
    private TableColumn<Material, Integer> materialNumber;
    @FXML
    private TableColumn<Material, String> materialDate;
    @FXML
    private TableColumn<Material, String> materialType;
    @FXML
    private TextField search;

    @FXML
    public void initialize() throws Exception {
        List<Material> materialList = new ArrayList<>();
        materialList = MaterialDAO.readData(materialList);

        materialNo.setCellValueFactory(new PropertyValueFactory<>("materialNo"));
        materialName.setCellValueFactory(new PropertyValueFactory<>("materialName"));
        materialUnitPrice.setCellValueFactory(new PropertyValueFactory<>("materialUnitPrice"));
        materialNumber.setCellValueFactory(new PropertyValueFactory<>("materialNumber"));
        materialDate.setCellValueFactory(new PropertyValueFactory<>("materialDate"));
        materialType.setCellValueFactory(new PropertyValueFactory<>("materialType"));

        materialTable.setItems(FXCollections.observableList(materialList));
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
    public void addMaterialAddView() {
        Main.addView("../view/materialAdd.fxml");
    }

    private void addMaterialUpdateView() {
        Material material = materialTable.getSelectionModel().getSelectedItem();
        //选中行不为空，则跳转
        if (material != null) {
            MaterialUpdateController.setCurrentMaterial(material);
            Main.addView("../view/materialUpdate.fxml");
        }
    }

    @FXML
    public void insert() {
        if (Main.readUser().getUserAuthority()) {
            addMaterialAddView();
        } else {
            Main.warningAlert();
        }
    }

    @FXML
    public void update() {
        if (Main.readUser().getUserAuthority()) {
            addMaterialUpdateView();
        } else {
            Main.warningAlert();
        }
    }

    @FXML
    public void delete() throws Exception {
        if (Main.readUser().getUserAuthority()) {
            Material selectedMaterial = materialTable.getSelectionModel().getSelectedItem();
            if (selectedMaterial != null) {
                MaterialDAO.deleteData(selectedMaterial.getMaterialNo());
            }
        } else {
            Main.warningAlert();
        }
    }

    @FXML
    public void search() throws Exception {
        List<Material> materialList = MaterialDAO.searchData(search.getText());

        materialNo.setCellValueFactory(new PropertyValueFactory<>("materialNo"));
        materialName.setCellValueFactory(new PropertyValueFactory<>("materialName"));
        materialUnitPrice.setCellValueFactory(new PropertyValueFactory<>("materialUnitPrice"));
        materialNumber.setCellValueFactory(new PropertyValueFactory<>("materialNumber"));
        materialDate.setCellValueFactory(new PropertyValueFactory<>("materialDate"));
        materialType.setCellValueFactory(new PropertyValueFactory<>("materialType"));

        materialTable.setItems(FXCollections.observableList(materialList));
    }

    @FXML
    public void refresh() {
        toMaterialView();
    }

    @FXML
    public void print() {
        Main.successAlert("print");
    }
}