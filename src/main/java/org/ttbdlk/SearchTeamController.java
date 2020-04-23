package org.ttbdlk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;



public class SearchTeamController {

    @FXML
    private TextField searchTeamTextField;
    @FXML
    private ListView<Team> TeamListView;
    @FXML
    private ComboBox<String> divisionComboBox;

    ArrayList<Team> teams;
    String sortingValue;

    private void fillTheTeamList()  throws IOException{
        DAOImplementation dao = new DAOImplementation();
        dao.DbConnect();
        teams = dao.GetTeamsData();
        if(teams == null){
            App.alertApp(Alert.AlertType.WARNING, "Database error!", "", "Something went wrong with the database!");
        }else{
            TeamListView.getItems().clear();
            for (int i = 0; i < teams.size(); i++) {
                TeamListView.getItems().add(teams.get(i));
            }
        }

    }

    public void initialize() throws IOException{
        fillTheTeamList();
        divisionComboBox.getItems().addAll("none","NFC North", "NFC West", "NFC East","NFC South", "AFC South", "AFC West",  "AFC East", "AFC North");
        divisionComboBox.getSelectionModel().select(0);
        sortingValue = "none";
    }

    @FXML
    void handleSelectionChangedDivisionComboBox(ActionEvent event) {
        sortingValue = divisionComboBox.getSelectionModel().getSelectedItem();
    }

    @FXML
    void handleButtonSearchPushed(ActionEvent event) throws IOException {
        String criteria = searchTeamTextField.getText();
        System.out.println(criteria);
        if(criteria.equals("") && sortingValue.equals("none")){
            App.alertApp(Alert.AlertType.WARNING, "Add searching criteria!", "", "You need to add one or more criterias to search!");
        }else if(sortingValue.equals("none")){
            TeamListView.getItems().clear();
            for (int i = 0; i < teams.size(); i++) {
                if (teams.get(i).getName().toLowerCase().contains(criteria.toLowerCase())) {
                    TeamListView.getItems().add(teams.get(i));
                }
            }
        }else {
            TeamListView.getItems().clear();
            for (int i = 0; i < teams.size(); i++) {
                if (teams.get(i).getName().toLowerCase().contains(criteria.toLowerCase()) && sortingValue.equals(teams.get(i).getDivision())) {
                    TeamListView.getItems().add(teams.get(i));
                }
            }
        }
    }

    @FXML
    void handleButtonViewPushed(ActionEvent event) throws IOException {
        Team team = TeamListView.getSelectionModel().getSelectedItem();
        if(team == null){
            App.alertApp(Alert.AlertType.WARNING, "Select player!", "", "You need to select a player from the list to check it out!");
        }else{
            System.out.println(team);
            TeamDataController tdc = new TeamDataController();
            tdc.passingSelectedTeam(team);
            App.setRoot("teamData");
        }
    }

    @FXML
    void handleButtonBackPushed(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }
    public void onEnter(ActionEvent event) throws IOException {
        handleButtonSearchPushed(event);
    }
}
