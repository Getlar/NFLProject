package org.ttbdlk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CreateDreamTeamController {
    @FXML
    private AnchorPane playerAddingAP;

    @FXML
    void createTeamButtonPressed(ActionEvent event) {
        playerAddingAP.setVisible(true);
    }

    public void initialize(){
        playerAddingAP.setVisible(false);
    }
    @FXML
    void buttonToFomenu(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }
}
