package com.PolicyEditorBackend.PolicyEditor.controllers.ViewsController;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;

public class MenuController {
    @FXML
    private MenuItem newMenuItem;

    @FXML
    private MenuItem saveMenuItem;

    @FXML
    private void handleNewMenuItemAction() {
        // action à effectuer lors du clic sur le MenuItem New
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("New Menu Item");
        alert.setContentText("You clicked the New menu item.");
        alert.showAndWait();
    }

    @FXML
    private void handleSaveMenuItemAction() {
        // action à effectuer lors du clic sur le MenuItem Save
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Save Menu Item");
        alert.setContentText("You clicked the Save menu item.");
        alert.showAndWait();
    }
}
