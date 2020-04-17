package org.ttbdlk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class ModifyDreamTeamController {
    @FXML
    void buttonToFomenu(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }
}
