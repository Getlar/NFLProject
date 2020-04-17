package org.ttbdlk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SearchController {

    @FXML
    void buttonToFomenu(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }
    public void initialize(){
        searchField.setPromptText("Search...");
        dataAnchorPane.setVisible(false);
    }
    @FXML
    void searchByTeamButton(ActionEvent event) {
        dataAnchorPane.setVisible(true);
    }

    @FXML
    private TextField searchField;

    @FXML
    private AnchorPane dataAnchorPane;

}
