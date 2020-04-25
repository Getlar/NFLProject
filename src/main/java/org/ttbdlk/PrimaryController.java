package org.ttbdlk;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PrimaryController extends DAOImplementation{
    
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
