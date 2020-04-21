package org.ttbdlk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;



public class SearchTeamController {

    @FXML
    private TextField searchTeamTextField;

    @FXML
    private ListView<Team> TeamListView;

    boolean firstCall = true;
    @FXML
    void handleButtonSearchPushed(ActionEvent event) {
        DAOImplementation dao = new DAOImplementation();
        dao.DbConnect();
        ArrayList<Team> teams= dao.GetTeamsData();
        TeamListView.getItems().clear();
        for (int i = 0; i < teams.size(); i++) {
            TeamListView.getItems().add(teams.get(i));
        }
        String criteria = searchTeamTextField.getText();
        System.out.println(criteria);
        if(criteria.equals("") && firstCall == false){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("You need to type some criteria to search!");
            alert.show();
        }else {
            TeamListView.getItems().clear();
            for (int i = 0; i < teams.size(); i++) {
                if(teams.get(i).getName().toLowerCase().contains(criteria.toLowerCase())){
                    TeamListView.getItems().add(teams.get(i));
                }
            }
            firstCall = false;
        }
    }

    @FXML
    void handleButtonViewPushed(ActionEvent event) throws IOException {
        Team team = TeamListView.getSelectionModel().getSelectedItem();
        System.out.println(team  );
        TeamDataController tdc = new TeamDataController();
        tdc.passingSelectedTeam(team);
        App.setRoot("teamData");
    }
    @FXML
    void handleButtonBackPushed(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }

}
