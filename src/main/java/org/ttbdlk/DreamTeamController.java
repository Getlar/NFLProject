package org.ttbdlk;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DreamTeamController extends DAOImplementation {
    public AnchorPane dreamTeamAP;
    public Button createDreamTeamMenuButton;
    public Button modifyMenuButton;
    public Button mainMenuDreamTeam;

    @FXML
    void createDreamTeam() throws IOException {
        App.setRoot("createDreamTeam");
    }

    @FXML
    void modifyExistingTeam() throws IOException {
        App.setRoot("modifyDreamTeam");
    }

    @FXML
    void buttonToFomenu() throws IOException {
        App.setRoot("primary");
    }
}
