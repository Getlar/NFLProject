package org.ttbdlk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    //Branchek létrehozva
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        DbConnect connect = new DbConnect();
        /*
        csinálok egy Team tömböt, mert ebben a hajnali órában így tűnik a legeffektívebbnek, hogy utána egy for ciklussal feltöltsem a teams táblát
        Team[] pushingTeamsArray=new Team[32];

        belerakom egyesével ugye mind a 32 csapatot
        pushingTeamsArray[0]=new Team("Arizona Cardinals", "NFC West", "Kliff Timothy Kingsbury", "Michael Bidwill");

        a Teams tábla feltöltése
        connect.pushDataToTeams(pushingTeamsArray[i]);

        hibajavítás
        connect.updateData(new Team("Green Bay Packers", "NFC North", "Mark Murphy"));*/

        //Player tömb a feltöltéshez, csak 10 darab, mert elég még
        //Player[] pushingPlayersArray=new Player[10];

        //egyesével a 10 játékost belerakom a tömbbe
        //pushingPlayersArray[0]=new Player(31, "Tyler Biadasz", "Wisconsin", "C", Date.valueOf("1997-05-17"),191, 143, "San Fransisco 49ers");

        //a Players tábla feltöltése
        //connect.pushDataToPlayers(pushingPlayersArray[i]);

        launch();
    }
}