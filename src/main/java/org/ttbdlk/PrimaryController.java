package org.ttbdlk;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryController {

    @FXML
    private Button createDTButton;

    @FXML
    void searchEverything(ActionEvent event) throws IOException {
        App.setRoot("search");
    }

    @FXML
    void dreamTeam(ActionEvent event) throws IOException {
        App.setRoot("dreamTeam");
    }
}
