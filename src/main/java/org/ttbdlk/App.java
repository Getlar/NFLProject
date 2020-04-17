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
        //connect.createTable();
        /*connect.getData();
        Team csapat = new Team(3, "Vikings", "25");
        connect.pushData(csapat);
        connect.getData();
        connect.deleteData(1);
        connect.getData();*/
        /*
        //csinálok egy Team tömböt, mert ebben a hajnali órában így tűnik a legeffektívebbnek, hogy utána egy for ciklussal feltöltsem a teams táblát
        Team[] pushingTeamsArray=new Team[32];

        //belerakom egyesével ugye mind a 32 csapatot
        pushingTeamsArray[0]=new Team("Arizona Cardinals", "NFC West", "Michael Bidwill");
        pushingTeamsArray[1]=new Team("Atlanta Falcons", "NFC South", "Arthur M. Blank");
        pushingTeamsArray[2]=new Team("Baltimore Ravens", "AFC North", "Steve Bisciotti");
        pushingTeamsArray[3]=new Team("Buffalo Bills", "AFC East", "Terrence Pegula");
        pushingTeamsArray[4]=new Team("Carolina Panthers", "NFC South", "David Tepper");
        pushingTeamsArray[5]=new Team("Chicago Bears", "NFC North", "Michael McCaskey");
        pushingTeamsArray[6]=new Team("Cincinnati Bengals", "AFC North", "Mike Brown");
        pushingTeamsArray[7]=new Team("Cleveland Browns", "AFC North", "Randy Lerner");
        pushingTeamsArray[8]=new Team("Dallas Cowboys", "NFC East", "Jerry Jones");
        pushingTeamsArray[9]=new Team("Denver Broncos", "AFC West", "Pat Bowlen");
        pushingTeamsArray[10]=new Team("Denver Lions", "NFC North", "Martha Firestone Ford Sr.");
        pushingTeamsArray[11]=new Team("Green Byy Packers", "NFC North", "Mark Murphy");
        pushingTeamsArray[12]=new Team("Houston Texans", "AFC South", "Robert C. McNair");
        pushingTeamsArray[13]=new Team("Indianapolis Colts", "AFC South", "Jim Irsay");
        pushingTeamsArray[14]=new Team("Jacksonville Jaguars", "AFC South", "Shahid Khan");
        pushingTeamsArray[15]=new Team("Kansas City Chiefs", "AFC West", "Clark Hunt");
        pushingTeamsArray[16]=new Team("Las Vegas Raiders", "AFC West", "Al Davis");
        pushingTeamsArray[17]=new Team("Los Angeles Chargers", "AFC West", "Dean A. Spanos");
        pushingTeamsArray[18]=new Team("Los Angeles Rams", "NFC West", "Stanley Kroenke");
        pushingTeamsArray[19]=new Team("Miami Dolphins", "AFC East", "Stephen M. Ross");
        pushingTeamsArray[20]=new Team("Minnesota Vikings", "NFC North", "Zygi Wilf");
        pushingTeamsArray[21]=new Team("New England Patriots", "AFC East", "Robert Kraft");
        pushingTeamsArray[22]=new Team("New Orleans Saints", "NFC South", "Tom Benson");
        pushingTeamsArray[23]=new Team("New York Giants", "NFC East", "John Mara");
        pushingTeamsArray[24]=new Team("New York Jets", "AFC East", "Robert Wood Johnson IV.");
        pushingTeamsArray[25]=new Team("Philadelphia Eagles", "NFC East", "Jeffrey Luire");
        pushingTeamsArray[26]=new Team("Pittsburgh Steelers", "AFC North", "Dan Rooney");
        pushingTeamsArray[27]=new Team("San Fransisco 49ers", "NFC West", "Jed York");
        pushingTeamsArray[28]=new Team("Seattle Seahawks", "NFC West", "Paul Allen");
        pushingTeamsArray[29]=new Team("Tampa Bay Buccaneers", "NFC South", "Malcolm Glazer");
        pushingTeamsArray[30]=new Team("Tennessee Titans", "AFC South", "Adam Strunk");
        pushingTeamsArray[31]=new Team("Washington Redskins", "NFC East", "Daniel Snyder");

        //a Teams tábla feltöltése
        for(int i=0; i<32; i++){
            connect.pushDataToTeams(pushingTeamsArray[i]);
        }

        //hibajavítás
        connect.updateData(new Team("Green Bay Packers", "NFC North", "Mark Murphy"));*/

        //Player tömb a feltöltéshez, csak 10 darab, mert elég még
        Player[] pushingPlayersArray=new Player[10];

        //egyesével a 10 játékost belerakom a tömbbe
        pushingPlayersArray[0]=new Player(1, "Joe Burrow", "LSU", "QB", Date.valueOf("1996-12-10"),98, 193, "Cincinnati Bengals");

        //a Players tábla feltöltése
        /*for(int i=0; i<1; i++){
            connect.pushDataToPlayers(pushingPlayersArray[i]);
        }*/
        connect.pushDataToPlayers(pushingPlayersArray[0]);

        launch();
    }

}