package org.ttbdlk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("The NFL Project");
        scene = new Scene(loadFXML("loadingScreen"), 1920, 1080);
        Color c = Color.rgb(1, 51, 105);
        scene.setFill(c);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.getIcons().add(new Image("logo.png"));
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

    static void alertApp(Alert.AlertType alertType, String title, String header, String content) throws IOException {
        if (alertType == Alert.AlertType.CONFIRMATION){
            Alert alert = new Alert(alertType);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(content);
            Optional <ButtonType> action = alert.showAndWait();
            //noinspection OptionalGetWithoutIsPresent
            if (action.get() == ButtonType.OK){
                DAOImplementation connect = new DAOImplementation();
                connect.DbConnect();
                connect.deleteDreamTeam(header);
                App.setRoot("dreamTeam");
            }
        }else{
            Alert alert = new Alert(alertType);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(content);
            alert.showAndWait();
        }
    }

    public static void main(String[] args) throws IOException {
        DAOImplementation connect = new DAOImplementation();
        connect.DbConnect();
        /*connect.pushDataToPlayers(new Player(107, "Akeem Davis-Gaither", "Appalachian State", "LB", LocalDate.parse("1997-09-21"), connect.weight(215), connect.height(6,2), "Cincinnati Bengals"));
        connect.pushDataToPlayers(new Player(108, "Saahdiq Charles", "LSU", "OT", LocalDate.parse("1999-07-26"), connect.weight(295), connect.height(6,4), "Washington Redskins"));
        connect.pushDataToPlayers(new Player(109, "John Simpson", "Clemson", "G", LocalDate.parse("1997-08-19"), connect.weight(330), connect.height(6,4), "Las Vegas Raiders"));
        connect.pushDataToPlayers(new Player(110, "Darnay Holmes", "UCLA", "CB", LocalDate.parse("1998-06-23"), connect.weight(198), connect.height(5,10), "New York Giants"));
        connect.pushDataToPlayers(new Player(111, "Solomon Kindley", "Georgia", "G", LocalDate.parse("1997-07-31"), connect.weight(335), connect.height(6,4), "Miami Dolphins"));
        connect.pushDataToPlayers(new Player(112, "Joshua Kelley", "UCLA", "RB", LocalDate.parse("1997-11-20"), connect.weight(219), connect.height(5,11), "Los Angeles Chargers"));
        connect.pushDataToPlayers(new Player(113, "Troy Pride", "Notre Dame", "CB", LocalDate.parse("1998-01-19"), connect.weight(194), connect.height(5,11), "Carolina Panthers"));
        connect.pushDataToPlayers(new Player(114, "Leki Fotu", "Utah", "DT", LocalDate.parse("1998-08-23"), connect.weight(335), connect.height(6,5), "Arizona Cardinals"));
        connect.pushDataToPlayers(new Player(115, "Harrison Bryant", "Florida Atlantic", "TE", LocalDate.parse("1998-04-23"), connect.weight(240), connect.height(6,5), "Cleveland Browns"));
        connect.pushDataToPlayers(new Player(116, "Ben Bartch", "St. John''s (Minn.)", "OT", LocalDate.parse("1998-07-22"), connect.weight(305), connect.height(6,6), "Jacksonville Jaguars"));
        connect.pushDataToPlayers(new Player(117, "D.J. Wonnum", "South Carolina", "LB", LocalDate.parse("1997-10-31"), connect.weight(260), connect.height(6,5), "Minnesota Vikings"));
        connect.pushDataToPlayers(new Player(118, "Albert Okwuegbunam", "Missouri", "TE", LocalDate.parse("1998-04-25"), connect.weight(255), connect.height(6,5), "Denver Broncos"));
        connect.pushDataToPlayers(new Player(119, "Mykal Walker", "Fresno State", "LB", LocalDate.parse("1997-08-28"), connect.weight(230), connect.height(6,3), "Atlanta Falcons"));
        connect.pushDataToPlayers(new Player(120, "La''Mical Perine", "Floria", "RB", LocalDate.parse("1998-01-30"), connect.weight(218), connect.height(5,11), "New York Jets"));
        connect.pushDataToPlayers(new Player(121, "Logan Stenberg", "Kentucky", "G", LocalDate.parse("1997-03-18"), connect.weight(322), connect.height(6,6), "Detroit Lions"));
        connect.pushDataToPlayers(new Player(122, "Jacob Eason", "Washington", "QB", LocalDate.parse("1997-11-17"), connect.weight(227), connect.height(6,6), "Indianapolis Colts"));
        connect.pushDataToPlayers(new Player(123, "Reggie Robinson II", "Tulsa", "CB", LocalDate.parse("1997-04-14"), connect.weight(197), connect.height(6,1), "Dallas Cowboys"));
        connect.pushDataToPlayers(new Player(124, "Anthony McFarland", "Maryland", "RB", LocalDate.parse("1999-03-04"), connect.weight(198), connect.height(5,9), "Pittsburgh Steelers"));
        */connect.pushDataToPlayers(new Player(125, "James Morgan", "Florida International", "QB", LocalDate.parse("1997-02-28"), connect.weight(213), connect.height(6,4), "New York Jets"));
        connect.pushDataToPlayers(new Player(126, "Charlie Heck", "North Carolina", "OT", LocalDate.parse("1996-11-20"), connect.weight(315), connect.height(6,8), "Houston Texans"));
        connect.pushDataToPlayers(new Player(127, "K''Von Wallace", "Clemson", "S", LocalDate.parse("1997-07-25"), connect.weight(199), connect.height(5,11), "Philadelphia Eagles"));
        connect.pushDataToPlayers(new Player(128, "Gabriel Davis", "UCF", "WR", LocalDate.parse("1999-04-01"), connect.weight(212), connect.height(6,3), "Buffalo Bills"));
        connect.pushDataToPlayers(new Player(129, "Cameron Clark", "Charlotte", "G", LocalDate.parse("1997-11-16"), connect.weight(294), connect.height(6,5), "New York Jets"));
        connect.pushDataToPlayers(new Player(130, "James Lynch", "Baylor", "DE", LocalDate.parse("1999-01-20"), connect.weight(295), connect.height(6,4), "Minnesota Vikings"));
        connect.pushDataToPlayers(new Player(131, "Rashard Lawrence", "LSU", "DT", LocalDate.parse("1998-09-27"), connect.weight(308), connect.height(6,2), "Arizona Cardinals"));
        connect.pushDataToPlayers(new Player(132, "Troy Dye", "Oregon", "LB", LocalDate.parse("1996-09-18"), connect.weight(226), connect.height(6,4), "Minnesota Vikings"));
        connect.pushDataToPlayers(new Player(133, "Colby Parkinson", "Stanford", "TE", LocalDate.parse("1999-01-08"), connect.weight(251), connect.height(6,7), "Seattle Seahawks"));
        connect.pushDataToPlayers(new Player(134, "Jaylinn Hawkins", "California", "S", LocalDate.parse("1997-08-25"), connect.weight(210), connect.height(6,2), "Atlanta Falcons"));
        connect.pushDataToPlayers(new Player(135, "Kevin Dotson", "Louisiana-Lafayette", "G", LocalDate.parse("1996-09-18"), connect.weight(310), connect.height(6,4), "Pittsburgh Steelers"));
        connect.pushDataToPlayers(new Player(136, "Brycen Hopkins", "Purdue", "TE", LocalDate.parse("1997-03-27"), connect.weight(245), connect.height(6,5), "Los Angeles Rams"));
        connect.pushDataToPlayers(new Player(137, "Josiah Scott", "Michigan State", "CB", LocalDate.parse("1999-04-05"), connect.weight(171), connect.height(5,10), "Jacksonville Jaguars"));
        connect.pushDataToPlayers(new Player(138, "L''Jarius Sneed", "Louisiana Tech", "S", LocalDate.parse("1997-01-21"), connect.weight(193), connect.height(6,1), "Kansas City Chiefs"));
        connect.pushDataToPlayers(new Player(139, "Amik Robertson", "Louisiana Tech", "CB", LocalDate.parse("1989-07-06"), connect.weight(183), connect.height(5,9), "Las Vegas Raiders"));
        connect.pushDataToPlayers(new Player(140, "Shaquille Quarterman", "Miami (Fla.)", "LB", LocalDate.parse("1997-10-28"), connect.weight(240), connect.height(6,1), "Jacksonville Jaguars"));
        connect.pushDataToPlayers(new Player(150, "Shane Lemieux", "Oregon", "G", LocalDate.parse("1997-05-12"), connect.weight(316), connect.height(6,4), "New York Giants"));
        connect.pushDataToPlayers(new Player(141, "John Reid", "Penn State", "CB", LocalDate.parse("1996-05-15"), connect.weight(181), connect.height(5,10), "Houston Texans"));
        connect.pushDataToPlayers(new Player(142, "Antonio Gandy-Golden", "Liberty", "WR", LocalDate.parse("1998-04-11"), connect.weight(220), connect.height(6,4), "Washington Redskins"));
        connect.pushDataToPlayers(new Player(143, "Ben Bredeson", "Michigan", "G", LocalDate.parse("1998-02-20"), connect.weight(325), connect.height(6,5), "Baltimore Ravens"));
        connect.pushDataToPlayers(new Player(144, "DeeJay Dallas", "Miami (Fla.)", "RB", LocalDate.parse("1998-09-16"), connect.weight(210), connect.height(5,10), "Seattle Seahawks"));
        connect.pushDataToPlayers(new Player(145, "Jack Driscoll", "Auburn", "OT", LocalDate.parse("1997-04-01"), connect.weight(296), connect.height(6,5), "Philadelphia Eagles"));
        connect.pushDataToPlayers(new Player(146, "Tyler Biadasz", "Wisconsin", "C", LocalDate.parse("1997-09-25"), connect.weight(321), connect.height(6,3), "Los Angeles Rams"));
        connect.pushDataToPlayers(new Player(147, "Khalid Kareem", "Notre Dame", "LB", LocalDate.parse("1998-04-28"), connect.weight(265), connect.height(6,4), "Cincinnati Bengals"));
        connect.pushDataToPlayers(new Player(148, "Alton Robinson", "Syracuse", "LB", LocalDate.parse("1998-07-07"), connect.weight(260), connect.height(6,3), "Seattle Seahawaks"));
        connect.pushDataToPlayers(new Player(149, "Danny Pinter", "Ball State", "G", LocalDate.parse("1996-06-19"), connect.weight(300), connect.height(6,4), "Indianapolis Colts"));
        connect.pushDataToPlayers(new Player(151, "Joe Reed", "Virginia", "WR", LocalDate.parse("1998-01-04"), connect.weight(215), connect.height(6,1), "Los Angeles Chargers"));
        connect.pushDataToPlayers(new Player(152, "Kenny Robinson", "West Virginia", "S", LocalDate.parse("1999-01-08"), connect.weight(198), connect.height(6,2), "Carolina Panthers"));
        connect.pushDataToPlayers(new Player(153, "Colton McKivitz", "West Virginia", "OT", LocalDate.parse("1996-08-09"), connect.weight(304), connect.height(6,6), "San Fransisco 49ers"));
        connect.pushDataToPlayers(new Player(154, "Jason Strowbridge", "North Carolina", "DE", LocalDate.parse("1996-09-10"), connect.weight(285), connect.height(6,5), "Miami Dolphins"));
        connect.pushDataToPlayers(new Player(155, "Trevis Gipson", "Tulsa", "DE", LocalDate.parse("1997-06-13"), connect.weight(268), connect.height(6,4), "Chicago Bears"));
        connect.pushDataToPlayers(new Player(156, "Keith Ismael", "San Diego State", "C", LocalDate.parse("1998-07-25"), connect.weight(300), connect.height(6,3), "Washington Redskins"));
        connect.pushDataToPlayers(new Player(157, "Daniel Thomas", "Auburn", "S", LocalDate.parse("1998-07-01"), connect.weight(209), connect.height(5,11), "Jacksonville Jaguars"));
        connect.pushDataToPlayers(new Player(158, "Bryce Hall", "Virginia", "CB", LocalDate.parse("1997-11-05"), connect.weight(200), connect.height(6,1), "New York Jets"));
        connect.pushDataToPlayers(new Player(159, "Justin Rohrwasser", "Marshall", "K", LocalDate.parse("1998-10-06"), connect.weight(230), connect.height(6,3), "New England Patriots"));
        connect.pushDataToPlayers(new Player(160, "Nick Harris", "Washington", "C", LocalDate.parse("1998-11-13"), connect.weight(302), connect.height(6,1), "Cleveland Browns"));
        connect.pushDataToPlayers(new Player(161, "Tyler Johnson", "Minnesota", "WR", LocalDate.parse("1998-08-25"), connect.weight(205), connect.height(6,2), "Tampa Bay Buccaneers"));
        connect.pushDataToPlayers(new Player(162, "Khaleke Hudson", "Michigan", "LB", LocalDate.parse("1997-12-06"), connect.weight(220), connect.height(5,11), "Washington Redskins"));
        connect.pushDataToPlayers(new Player(163, "Kindle Vildor", "Georgia Southern", "CB", LocalDate.parse("1997-12-11"), connect.weight(190), connect.height(5,11), "Chicago Bears"));
        connect.pushDataToPlayers(new Player(164, "Curtis Weaver", "Boise State", "LB", LocalDate.parse("1998-08-03"), connect.weight(265), connect.height(6,3), "Miami Dolphins"));
        connect.pushDataToPlayers(new Player(165, "Collin Johnson", "Texas", "WR", LocalDate.parse("1997-09-23"), connect.weight(220), connect.height(6,6), "Jacksonville Jaguars"));
        connect.pushDataToPlayers(new Player(166, "Quintez Cephus", "Wisconsin", "WR", LocalDate.parse("1998-04-01"), connect.weight(207), connect.height(6,1), "Detroit Lions"));
        connect.pushDataToPlayers(new Player(167, "Jake Fromm", "Georgia", "QB", LocalDate.parse("1998-07-30"), connect.weight(220), connect.height(6,2), "Buffalo Bills"));
        connect.pushDataToPlayers(new Player(168, "John Hightower", "Boise State", "WR", LocalDate.parse("1996-05-31"), connect.weight(172), connect.height(6,2), "Philadelphia Eagles"));
        connect.pushDataToPlayers(new Player(169, "Harrison Hand", "Temple", "CB", LocalDate.parse("1998-11-12"), connect.weight(192), connect.height(6,0), "Minnesota Vikings"));
        connect.pushDataToPlayers(new Player(170, "Broderick Washington", "Texas Tech", "DT", LocalDate.parse("1999-09-12"), connect.weight(305), connect.height(6,3), "Baltimore Ravens"));
        connect.pushDataToPlayers(new Player(171, "Isaiah Coulter", "Rhode Island", "WR", LocalDate.parse("1998-09-18"), connect.weight(190), connect.height(6,3), "Houston Texans"));
        connect.pushDataToPlayers(new Player(172, "Jason Huntley", "New Mexico State", "RB", LocalDate.parse("1998-04-20"), connect.weight(193), connect.height(5,9), "Detroit Lions"));
        connect.pushDataToPlayers(new Player(173, "Darnell Mooney", "Tulane", "WR", LocalDate.parse("1997-10-29"), connect.weight(175), connect.height(5,11), "Chicago Bears"));
        connect.pushDataToPlayers(new Player(174, "Larrell Murchison", "North Carolina State", "DT", LocalDate.parse("1997-04-24"), connect.weight(291), connect.height(6,2), "Tennessee Titans"));
        connect.pushDataToPlayers(new Player(175, "Kamal Martin", "Minnesota", "LB", LocalDate.parse("1999-06-02"), connect.weight(245), connect.height(6,3), "Green Bay Packers"));
        connect.pushDataToPlayers(new Player(176, "K.J. Osborn", "Miami (Fla.)", "WR", LocalDate.parse("1997-06-10"), connect.weight(206), connect.height(6,0), "Minnesota Vikings"));
        connect.pushDataToPlayers(new Player(177, "Michael Danna", "Michigan", "LB", LocalDate.parse("1998-05-17"), connect.weight(261), connect.height(6,2), "Kansas City Chiefs"));
        connect.pushDataToPlayers(new Player(178, "Justin Strnad", "Wake Forest", "LB", LocalDate.parse("1996-08-21"), connect.weight(235), connect.height(6,3), "Denver Broncos"));
        connect.pushDataToPlayers(new Player(179, "Bradlee Anae", "Utah", "LB", LocalDate.parse("1998-01-17"), connect.weight(265), connect.height(6,3), "Dallas Cowboys"));
        connect.pushDataToPlayers(new Player(180, "Hakeem Adeniji", "Kansas", "G", LocalDate.parse("1997-12-08"), connect.weight(300), connect.height(6,5), "Cincinnati Bengals"));
        connect.pushDataToPlayers(new Player(181, "Netane Muti", "Fresno State", "G", LocalDate.parse("1999-03-27"), connect.weight(307), connect.height(6,3), "Denver Broncos"));
        connect.pushDataToPlayers(new Player(182, "Mike Onwenu", "Michigan", "G", LocalDate.parse("1997-12-10"), connect.weight(350), connect.height(6,3), "New England Patriots"));
        connect.pushDataToPlayers(new Player(183, "Cameron Brown", "Penn State", "LB", LocalDate.parse("1998-04-01"), connect.weight(233), connect.height(6,5), "New York Giants"));
        connect.pushDataToPlayers(new Player(184, "Bravvion Roy", "Baylor", "DT", LocalDate.parse("1997-10-18"), connect.weight(333), connect.height(6,1), "Carolina Panthers"));
        connect.pushDataToPlayers(new Player(185, "Blake Ferguson", "LSU", "LS", LocalDate.parse("1997-04-21"), connect.weight(235), connect.height(6,3), "Miami Dolphins"));
        connect.pushDataToPlayers(new Player(186, "Alohi Gilman", "Notre Dame", "S", LocalDate.parse("1997-09-17"), connect.weight(202), connect.height(5,10), "Los Angeles Chargers"));
        connect.pushDataToPlayers(new Player(187, "Donovan Peoples-Jones", "Michigan", "WR", LocalDate.parse("1999-02-19"), connect.weight(208), connect.height(6,2), "Cleveland Browns"));
        connect.pushDataToPlayers(new Player(188, "Tyler Bass", "Georgia Southern", "K", LocalDate.parse("1998-12-03"), connect.weight(185), connect.height(5,10), "Buffalo Bills"));
        connect.pushDataToPlayers(new Player(189, "Jake Luton", "Oregon State", "QB", LocalDate.parse("1996-04-11"), connect.weight(229), connect.height(6,7), "Jacksonville Jaguars"));
        connect.pushDataToPlayers(new Player(190, "Charlie Woerner", "Georgia", "TE", LocalDate.parse("1997-10-16"), connect.weight(245), connect.height(6,5), "San Fransisco 49ers"));
        connect.pushDataToPlayers(new Player(191, "Braden Mann", "Texas A&M", "P", LocalDate.parse("1997-11-24"), connect.weight(195), connect.height(5,11), "New York Jets"));
        connect.pushDataToPlayers(new Player(192, "Jon Runyan", "Michigan", "G", LocalDate.parse("1997-08-08"), connect.weight(321), connect.height(6,5), "Green bay Packers"));
        connect.pushDataToPlayers(new Player(193, "Robert Windsor", "Penn State", "DT", LocalDate.parse("1997-01-15"), connect.weight(285), connect.height(6,4), "Indianapolis Colts"));
        connect.pushDataToPlayers(new Player(194, "Khalil Davis", "Nebraska", "DT", LocalDate.parse("1996-08-22"), connect.weight(315), connect.height(6,2), "Tampa Bay Buccaneers"));
        connect.pushDataToPlayers(new Player(195, "Justin Herron", "Wake Forest", "G", LocalDate.parse("1995-11-27"), connect.weight(290), connect.height(6,5), "New England Patriots"));
        connect.pushDataToPlayers(new Player(196, "Shaun Bradley", "Temple", "LB", LocalDate.parse("1997-04-08"), connect.weight(230), connect.height(6,1), "Philadelphia Eagles"));
        connect.pushDataToPlayers(new Player(197, "John Penisini", "Utah", "DT", LocalDate.parse("1997-05-31"), connect.weight(333), connect.height(6,2), "Detroit Lions"));
        connect.pushDataToPlayers(new Player(198, "Antoine Brooks Jr.", "Maryland", "S", LocalDate.parse("1997-10-28"), connect.weight(215), connect.height(5,11), "Pittsburgh Steelers"));
        connect.pushDataToPlayers(new Player(199, "Jordan Fuller", "Ohio State", "S", LocalDate.parse("1998-03-04"), connect.weight(205), connect.height(6,2), "Los Angeles Rams"));
        connect.pushDataToPlayers(new Player(200, "Quez Watkins", "Southern Mississippi", "WR", LocalDate.parse("1998-06-09"), connect.weight(190), connect.height(6,2), "Philadelphia Eagles"));
        connect.pushDataToPlayers(new Player(201, "James Proche", "Southern Methodist", "WR", LocalDate.parse("1996-09-21"), connect.weight(193), connect.height(6,0), "Baltimore Ravens"));
        connect.pushDataToPlayers(new Player(202, "Evan Weaver", "California", "LB", LocalDate.parse("1998-08-11"), connect.weight(235), connect.height(6,3), "Arizona Cardinals"));
        connect.pushDataToPlayers(new Player(203, "Blake Brandel", "Oregon State", "G", LocalDate.parse("1997-08-21"), connect.weight(307), connect.height(6,7), "Minnesota Vikings"));
        connect.pushDataToPlayers(new Player(204, "Cassh Maluia", "Wyoming", "LB", LocalDate.parse("1998-10-03"), connect.weight(246), connect.height(6,0), "New England Patriots"));
        connect.pushDataToPlayers(new Player(205, "Josh Metellus", "Michigan", "S", LocalDate.parse("1998-01-21"), connect.weight(210), connect.height(5,11), "Minnesota Vikings"));
        connect.pushDataToPlayers(new Player(206, "Tyler Davis", "Georgia Tech", "TE", LocalDate.parse("1997-01-24"), connect.weight(250), connect.height(6,4), "Jacksonville Jaguars"));
        connect.pushDataToPlayers(new Player(207, "Isaiah Hodgins", "Oregon State", "WR", LocalDate.parse("1998-10-21"), connect.weight(209), connect.height(6,4), "Buffalo Bills"));
        connect.pushDataToPlayers(new Player(208, "Jake Hanson", "Oregon", "C", LocalDate.parse("1997-04-29"), connect.weight(295), connect.height(6,5), "Green Bay Packers"));
        connect.pushDataToPlayers(new Player(209, "Simon Stepaniak", "Indiana", "G", LocalDate.parse("1997-05-15"), connect.weight(321), connect.height(6,4), "Green Bay Packers"));
        connect.pushDataToPlayers(new Player(210, "Prince Tega Wanogho", "Auburn", "OT", LocalDate.parse("1997-11-22"), connect.weight(307), connect.height(6,5), "Philadelphia Eagles"));
        connect.pushDataToPlayers(new Player(211, "Isaiah Rodgers", "Massachusetts", "S", LocalDate.parse("1998-07-27"), connect.weight(170), connect.height(5,10), "Indianapolis Colts"));
        connect.pushDataToPlayers(new Player(212, "Dezmon Patmon", "Washington State", "WR", LocalDate.parse("1998-08-06"), connect.weight(228), connect.height(6,4), "Indianapolis Colts"));
        connect.pushDataToPlayers(new Player(213, "Jordan Glasgow", "Michigan", "LB", LocalDate.parse("1996-06-28"), connect.weight(226), connect.height(6,1), "Indianapolis Colts"));
        connect.pushDataToPlayers(new Player(214, "Freddie Swain", "Florida", "WR", LocalDate.parse("1998-08-04"), connect.weight(199), connect.height(6,0), "Seattle Seahawks"));
        connect.pushDataToPlayers(new Player(215, "Markus Bailey", "Purdue", "LB", LocalDate.parse("1997-03-07"), connect.weight(240), connect.height(6,1), "Cincinnati Bengals"));
        connect.pushDataToPlayers(new Player(216, "Kamren Curl", "Arkansas", "S", LocalDate.parse("1999-03-31"), connect.weight(198), connect.height(6,2), "Washington Redskins"));
        connect.pushDataToPlayers(new Player(217, "Jauan Jennings", "Tennessee", "WR", LocalDate.parse("1997-07-10"), connect.weight(208), connect.height(6,3), "San Fransisco 49ers"));
        connect.pushDataToPlayers(new Player(218, "Carter Coughlin", "Minnesota", "LB", LocalDate.parse("1998-10-01"), connect.weight(234), connect.height(6,3), "New York Giants"));
        connect.pushDataToPlayers(new Player(219, "Geno Stone", "Iowa", "S", LocalDate.parse("1999-04-19"), connect.weight(210), connect.height(5,10), "Baltimore Ravens"));
        connect.pushDataToPlayers(new Player(220, "K.J. Hill", "Ohio State", "WR", LocalDate.parse("1997-09-15"), connect.weight(195), connect.height(6,0), "Los Angeles Chargers"));
        connect.pushDataToPlayers(new Player(221, "Stantley Thomas-Oliver III", "Florida International", "CB", LocalDate.parse("1998-06-04"), connect.weight(184), connect.height(6,2), "Carolina Panthers"));
        connect.pushDataToPlayers(new Player(222, "Eno Benjamin", "Arizona State", "RB", LocalDate.parse("1999-04-13"), connect.weight(201), connect.height(5,10), "Arizona Cardinals"));
        connect.pushDataToPlayers(new Player(223, "Chris Claybrooks", "Memphis", "CB", LocalDate.parse("1997-06-09"), connect.weight(176), connect.height(6,0), "Jacksonville Jaguars"));
        connect.pushDataToPlayers(new Player(224, "Cole McDonald", "Hawaii", "QB", LocalDate.parse("1998-05-20"), connect.weight(220), connect.height(6,4), "Tennessee Titans"));
        connect.pushDataToPlayers(new Player(225, "Kenny Willekes", "Michigan State", "DE", LocalDate.parse("1997-07-22"), connect.weight(252), connect.height(6,4), "Minnesota Vikings"));
        connect.pushDataToPlayers(new Player(226, "Arlington Hambright", "Colorado", "G", LocalDate.parse("1996-01-30"), connect.weight(300), connect.height(6,5), "Chicago Bears"));
        connect.pushDataToPlayers(new Player(227, "Lachavious Simmons", "Tennessee State", "G", LocalDate.parse("1996-09-12"), connect.weight(315), connect.height(6,5), "Chicago Bears"));
        connect.pushDataToPlayers(new Player(228, "Sterling Hofrichter", "Syracuse", "P", LocalDate.parse("1997-04-12"), connect.weight(199), connect.height(5,9), "Atlanta Falcons"));
        connect.pushDataToPlayers(new Player(229, "James Smith-Williams", "North Carolina State", "LB", LocalDate.parse("1997-06-10"), connect.weight(265), connect.height(6,4), "Washington Redskins"));
        connect.pushDataToPlayers(new Player(230, "Dustin Woodard", "Memphis", "C", LocalDate.parse("1996-10-12"), connect.weight(285), connect.height(6,2), "New England Patriots"));
        connect.pushDataToPlayers(new Player(231, "Ben DiNucci", "James Madison", "QB", LocalDate.parse("1996-11-24"), connect.weight(210), connect.height(6,3), "Dallas Cowboys"));
        connect.pushDataToPlayers(new Player(232, "Carlos Davis", "Nebraska", "DT", LocalDate.parse("1996-08-22"), connect.weight(320), connect.height(6,2), "Pittsburgh Steelers"));
        connect.pushDataToPlayers(new Player(233, "Casey Toohill", "Stanford", "LB", LocalDate.parse("1997-10-21"), connect.weight(247), connect.height(6,4), "Philadelphia Eagles"));
        connect.pushDataToPlayers(new Player(234, "Clay Johnston", "Baylor", "LB", LocalDate.parse("1996-01-14"), connect.weight(232), connect.height(6,1), "Los Angeles Rams"));
        connect.pushDataToPlayers(new Player(235, "Jashon Cornell", "Ohio State", "DT", LocalDate.parse("1997-03-22"), connect.weight(285), connect.height(6,3), "Detroit Lions"));
        connect.pushDataToPlayers(new Player(236, "Vernon Scott", "TCU", "S", LocalDate.parse("1996-03-09"), connect.weight(206), connect.height(6,2), "Green Bay Packers"));
        connect.pushDataToPlayers(new Player(237, "Bopete Keyes", "Tulane", "CB", LocalDate.parse("1997-11-09"), connect.weight(200), connect.height(6,1), "Kansas City Chiefs"));
        connect.pushDataToPlayers(new Player(238, "T.J. Brunson", "South Carolina", "LB", LocalDate.parse("1997-12-03"), connect.weight(230), connect.height(6,1), "New York Giants"));
        connect.pushDataToPlayers(new Player(239, "Dane Jackson", "Pittsburgh", "CB", LocalDate.parse("1996-11-29"), connect.weight(190), connect.height(6,0), "Buffalo Bills"));
        connect.pushDataToPlayers(new Player(240, "Tommy Stevens", "Mississippi State", "QB", LocalDate.parse("1996-12-15"), connect.weight(235), connect.height(6,5), "New Orleans Saints"));
        connect.pushDataToPlayers(new Player(241, "Chapelle Russel", "Temple", "LB", LocalDate.parse("1997-01-20"), connect.weight(230), connect.height(6,1), "Tampa Bay Buccaneers"));
        connect.pushDataToPlayers(new Player(242, "Jonathan Garvin", "Miami (Fla.)", "LB", LocalDate.parse("1999-07-28"), connect.weight(256), connect.height(6,4), "Green Bay Packers"));
        connect.pushDataToPlayers(new Player(243, "Chris Jackson", "Marshall", "CB", LocalDate.parse("1998-04-13"), connect.weight(186), connect.height(6,0), "Tennessee Titans"));
        connect.pushDataToPlayers(new Player(244, "Nate Stanley", "Iowa", "QB", LocalDate.parse("1997-08-26"), connect.weight(243), connect.height(6,4), "Minnesota Vikings"));
        connect.pushDataToPlayers(new Player(245, "Raymond Calais", "Louisiana-Lafayette", "RB", LocalDate.parse("1998-04-02"), connect.weight(185), connect.height(5,9), "Tampa Bay Buccaneers"));
        connect.pushDataToPlayers(new Player(246, "Malcolm Perry", "Navy", "WR", LocalDate.parse("1996-08-24"), connect.weight(190), connect.height(5, 9), "Miami Dolphins"));
        connect.pushDataToPlayers(new Player(247, "Chris Williamson", "Minnesota", "CB", LocalDate.parse("1997-03-17"), connect.weight(205), connect.height(6,0), "New York Giants"));
        connect.pushDataToPlayers(new Player(248, "Sam Sloman", "Miami (Ohio)", "S", LocalDate.parse("1997-09-19"), connect.weight(205), connect.height(5,8), "Los Angeles Rams"));
        connect.pushDataToPlayers(new Player(249, "Brian Cole II", "Mississippi State", "S", LocalDate.parse("1997-04-03"), connect.weight(205), connect.height(6,2), "Los Angeles Rams"));
        connect.pushDataToPlayers(new Player(250, "Tremayne Anchrum", "Clemson", "G", LocalDate.parse("1998-06-24"), connect.weight(310), connect.height(6,2), "Los Angeles Rams"));
        connect.pushDataToPlayers(new Player(251, "Stephen Sullivan", "LSU", "TE", LocalDate.parse("1996-11-28"), connect.weight(242), connect.height(6,5), "Seattle Seahawks"));
        connect.pushDataToPlayers(new Player(252, "Tyrie Cleveland", "Florida", "WR", LocalDate.parse("1997-09-20"), connect.weight(205), connect.height(6,2), "Denver Broncos"));
        connect.pushDataToPlayers(new Player(253, "Kyle Hinton", "Washburn", "G", LocalDate.parse("1998-02-27"), connect.weight(295), connect.height(6,2), "Minnesota Vikings"));
        connect.pushDataToPlayers(new Player(254, "Derrek Tuszka", "North Dakota State", "LB", LocalDate.parse("1998-09-29"), connect.weight(246), connect.height(6,5), "Denver Broncos"));
        connect.pushDataToPlayers(new Player(255, "Tae Crowder", "Georgia", "LB", LocalDate.parse("1997-03-12"), connect.weight(235), connect.height(6,3), "New York Giants"));
        launch();
    }
}