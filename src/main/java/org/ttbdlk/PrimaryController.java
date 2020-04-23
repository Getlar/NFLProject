package org.ttbdlk;

import java.io.IOException;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PrimaryController {


    @FXML
    private ImageView image1;

    @FXML
    private Button createDTButton;


    public void initialize(){


    }
    @FXML
    void handleButtonSearchForTeamsPushed(ActionEvent event) throws IOException {
        App.setRoot("searchTeam");
    }

    @FXML
    void handleButtonSearchForPlayersPushed(ActionEvent event) throws IOException {
        App.setRoot("searchPlayer");
    }


    @FXML
    void dreamTeam(ActionEvent event) throws IOException {
        App.setRoot("dreamTeam");
    }
}
