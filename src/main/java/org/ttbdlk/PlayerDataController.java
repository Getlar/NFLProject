package org.ttbdlk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.io.IOException;
import java.time.LocalDate;

public class PlayerDataController {
    @FXML
    private Text positionText;
    @FXML
    private Text pickText;
    @FXML
    private Text name;
    @FXML
    private Text pick;
    @FXML
    private Text college;
    @FXML
    private Text position;
    @FXML
    private Text dateofbirth;
    @FXML
    private Text weight;
    @FXML
    private Text height;
    @FXML
    private Text draftteam;



    @FXML
    private Text heightText;

    @FXML
    private Text collegeText;

    @FXML
    private Text dateOfBirthText;

    @FXML
    private Text draftTeamText;

    @FXML
    private Text weightText;

    @FXML
    private Text nameText;

    public static Player player;

    public void passingSelectedPlayer(Player _player)
    {
        player = _player;
    }

    public void initialize(){
        System.out.println(player.getName());
        pick.setText("Pick:");
        name.setText("Name:");
        college.setText("College:");
        position.setText("Position");
        dateofbirth.setText("Date of birth:");
        weight.setText("Weight:");
        height.setText("Height:");
        draftteam.setText("Draft team:");
        pickText.setText(Integer.toString(player.getPick()));
        nameText.setText(player.getName());
        collegeText.setText(player.getCollege());
        positionText.setText(player.getPosition());
        dateOfBirthText.setText(player.getDateOfBirth().toString());
        weightText.setText(Integer.toString(player.getWeight()));
        heightText.setText(Integer.toString(player.getHeight()));
        draftTeamText.setText(player.getDraftTeam());
    }

    @FXML
    void handleButtonBackPushed(ActionEvent event) throws IOException {
        App.setRoot("searchTeam");
    }
}
