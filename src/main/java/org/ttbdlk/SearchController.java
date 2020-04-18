package org.ttbdlk;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SearchController {

    @FXML
    private TextField searchField;

    @FXML
    private AnchorPane dataAnchorPane;

    @FXML
    private ListView<String> searchResultsListView;

    @FXML
    private Button searchButton;

    @FXML
    private Text helperTextForSearch;

    @FXML
    void buttonToFomenu(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }

    public void initialize(){
        searchField.setPromptText("Search...");
        dataAnchorPane.setVisible(false);
        helperTextForSearch.setVisible(false);
    }
    @FXML
    void searchByTeamButton(ActionEvent event) {
        if (!dataAnchorPane.isVisible()){
            dataAnchorPane.setVisible(true);
        }
        if (helperTextForSearch.isVisible()){
            helperTextForSearch.setVisible(false);
        }
        searchField.setPromptText("Search for a Team...");
        searchButton.setText("Search Team");
    }
    @FXML
    void searchByPlayerButton(ActionEvent event) {
        if (!dataAnchorPane.isVisible()){
            dataAnchorPane.setVisible(true);
        }
        if (helperTextForSearch.isVisible()){
            helperTextForSearch.setVisible(false);
        }
        searchField.setPromptText("Search for a Player...");
        searchButton.setText("Search Player");
    }
    @FXML
    void sortByDivisionButton(ActionEvent event) {
        if (!dataAnchorPane.isVisible()){
            dataAnchorPane.setVisible(true);
        }
        if (!helperTextForSearch.isVisible()){
            helperTextForSearch.setVisible(true);
            helperTextForSearch.setText("(e.g., NFC North, AFC West etc.)");
        }
        searchField.setPromptText("Enter a Division to sort by...");
        searchButton.setText("Sort Teams By Division");
    }
    @FXML
    void sortByCollegeButton(ActionEvent event) {
        if (!dataAnchorPane.isVisible()){
            dataAnchorPane.setVisible(true);
        }
        if (!helperTextForSearch.isVisible()){
            helperTextForSearch.setVisible(true);
            helperTextForSearch.setText("(e.g., TCU, Florida etc.)");
        }
        searchField.setPromptText("Enter a College to sort by...");
        searchButton.setText("Sort Players By College");
    }
    @FXML
    void sortByPositionButton(ActionEvent event) {
        if (!dataAnchorPane.isVisible()){
            dataAnchorPane.setVisible(true);
        }
        if (!helperTextForSearch.isVisible()){
            helperTextForSearch.setVisible(true);
            helperTextForSearch.setText("(e.g., QB, WR etc.)");
        }
        searchField.setPromptText("Enter a Positioon to sort by...");
        searchButton.setText("Sort Players By Position");
    }
    @FXML
    public void handleSearchButtonClicked(ActionEvent event) {
        DAOImplementation connect = new DAOImplementation();
        connect.DbConnect();
        ArrayList<Team> teams = connect.GetTeamsData();
        for (Team team : teams) {
            System.out.println(team.getName());
            searchResultsListView.getItems().add(team.getName());
        }
        searchResultsListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount()==2){
                    String itemsSelected = searchResultsListView.getSelectionModel().getSelectedItem();
                    System.out.println(itemsSelected);
                }
            }
        });
    }
}
