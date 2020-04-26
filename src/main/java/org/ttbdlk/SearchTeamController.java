package org.ttbdlk;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.ArrayList;



public class SearchTeamController extends DAOImplementation{

    @FXML
    private TextField searchTeamTextField;
    @FXML
    private ListView<Team> TeamListView;
    @FXML
    private ComboBox<String> divisionComboBox;

    private ArrayList<Team> teams;
    private String sortingValue;

    private void fillTheTeamList()  throws IOException{
        teams = GetTeamsData();
        if(teams == null){
            App.alertApp(Alert.AlertType.WARNING, "Database error!", "", "Something went wrong with the database!");
        }else{
            TeamListView.getItems().clear();
            for (Team team : teams) {
                TeamListView.getItems().add(team);
            }
        }

    }

    public void initialize() throws IOException{
        DbConnect();
        fillTheTeamList();
        divisionComboBox.getItems().addAll("none","NFC North", "NFC West", "NFC East","NFC South", "AFC South", "AFC West",  "AFC East", "AFC North");
        divisionComboBox.getSelectionModel().select(0);
        sortingValue = "none";
    }

    @FXML
    private void handleSelectionChangedDivisionComboBox() {
        sortingValue = divisionComboBox.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void handleButtonSearchPushed() throws IOException {
        String criteria = searchTeamTextField.getText();
        if(criteria.equals("") && sortingValue.equals("none")){
            App.alertApp(Alert.AlertType.WARNING, "Add searching criteria!", "", "You need to add one or more criterias to search!");
        }else if(sortingValue.equals("none")){
            TeamListView.getItems().clear();
            for (Team team : teams) {
                if (team.getName().toLowerCase().contains(criteria.toLowerCase())) {
                    TeamListView.getItems().add(team);
                }
            }
        }else {
            TeamListView.getItems().clear();
            for (Team team : teams) {
                if (team.getName().toLowerCase().contains(criteria.toLowerCase()) && sortingValue.equals(team.getDivision())) {
                    TeamListView.getItems().add(team);
                }
            }
        }
    }

    @FXML
    private void handleButtonViewPushed() throws IOException {
        Team team = TeamListView.getSelectionModel().getSelectedItem();
        if(team == null){
            App.alertApp(Alert.AlertType.WARNING, "Select player!", "", "You need to select a player from the list to check it out!");
        }else{
            TeamDataController tdc = new TeamDataController();
            tdc.passingSelectedTeam(team);
            App.setRoot("teamData");
        }
    }

    @FXML
    private void handleButtonBackPushed() throws IOException {
        App.setRoot("primary");
    }
    public void onEnter() throws IOException {
        handleButtonSearchPushed();
    }
}
