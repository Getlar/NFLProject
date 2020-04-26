package org.ttbdlk;
import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController extends DAOImplementation{
    
    @FXML
    private void handleButtonSearchForTeamsPushed() throws IOException {
        App.setRoot("searchTeam");
    }

    @FXML
    private void handleButtonSearchForPlayersPushed() throws IOException {
        App.setRoot("searchPlayer");
    }

    @FXML
    private void dreamTeam() throws IOException {
        App.setRoot("dreamTeam");
    }
}
