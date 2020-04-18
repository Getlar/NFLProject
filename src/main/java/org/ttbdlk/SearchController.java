package org.ttbdlk;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;

public class SearchController {

    @FXML
    private TextField searchField;

    @FXML
    private AnchorPane dataAnchorPane;

    @FXML
    private ListView searchResultsListView;

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
    public void handleSearchButtonClicked(ActionEvent event) {
        ArrayList<Team> teams = new ArrayList<>();
        DbConnect dc = new DbConnect();
        teams = dc.getTeamsData();
        for (int i = 0; i < teams.size(); i++) {
            searchResultsListView.getItems().add(teams.get(i).getName());
        }

    }
}
