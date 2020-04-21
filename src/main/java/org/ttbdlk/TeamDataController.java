package org.ttbdlk;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class TeamDataController {

    @FXML
    private TextField headcoachTextField;

    @FXML
    private TextField ownerTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField divisionTextField;

    public static Team team;

    public void passingSelectedTeam(Team _team){
        team = _team;
    }

    public void initialize(){
        nameTextField.setText(team.getName());
        divisionTextField.setText(team.getDivision());
        headcoachTextField.setText(team.getHeadCoach());
        ownerTextField.setText(team.getOwner());
    }

}
