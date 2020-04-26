package org.ttbdlk;

import javafx.fxml.FXML;

import java.io.IOException;

public class DreamTeamController extends DAOImplementation {

    @FXML
    private void createDreamTeam() throws IOException {
        App.setRoot("createDreamTeam");
    }

    @FXML
    private void modifyExistingTeam() throws IOException {
        App.setRoot("modifyDreamTeam");
    }

    @FXML
    private void buttonToFomenu() throws IOException {
        App.setRoot("primary");
    }
}
