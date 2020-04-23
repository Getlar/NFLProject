package org.ttbdlk;

import javafx.fxml.FXML;

import java.io.IOException;

public class DreamTeamController {
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
