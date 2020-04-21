package org.ttbdlk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;

public class TeamDataController {

    @FXML
    private Text headcoachText;

    @FXML
    private Text ownerText;

    //@FXML
    //private TextField nameText;

    @FXML
    private Text divisionText;
    @FXML
    private Text nameText;

    public static Team team;

    public void passingSelectedTeam(Team _team){
        team = _team;
    }

    public void initialize(){
        nameText.setText(team.getName());
        divisionText.setText(team.getDivision());
        headcoachText.setText(team.getHeadCoach());
        ownerText.setText(team.getOwner());
    }
    @FXML
    void handleButtonBackPushed(ActionEvent event) throws IOException {
        App.setRoot("searchTeam");
    }

}
