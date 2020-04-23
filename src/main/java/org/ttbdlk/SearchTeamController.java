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


    private void fillTheTeamList() throws IOException {
        DAOImplementation dao = new DAOImplementation();
        dao.DbConnect();
        teams = dao.GetTeamsData();
        TeamListView.getItems().clear();
        for (int i = 0; i < teams.size(); i++) {
            TeamListView.getItems().add(teams.get(i));
        }
    }

    public void initialize() throws IOException {
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
    void handleButtonSearchPushed(ActionEvent event) {
        //fillTheTeamList();
        String criteria = searchTeamTextField.getText();
        System.out.println(criteria);
        if(criteria.equals("") && sortingValue.equals("none")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("You need to add or type some criteria to search!");
            alert.show();
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
        System.out.println(team);
        TeamDataController tdc = new TeamDataController();
        tdc.passingSelectedTeam(team);
        App.setRoot("teamData");
    }


    @FXML
    void handleButtonBackPushed(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }
    public void onEnter(ActionEvent event) {
        handleButtonSearchPushed(event);
    }

}
