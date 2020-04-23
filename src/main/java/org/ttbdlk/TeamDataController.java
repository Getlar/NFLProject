package org.ttbdlk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class TeamDataController {

    @FXML
    private Text headcoachText;

    @FXML
    private Text ownerText;

    //@FXML
    //private TextField nameText;

    @FXML
    private Text divisionText;
    @FXML
    private Text nameText;
    @FXML
    private TableView<Player> TeamTableView;
    @FXML
    private TableColumn<Player, String> positionColumn;
    @FXML
    private TableColumn<Player, Integer> heightColumn;
    @FXML
    private TableColumn<Player, Integer> weightColumn;
    @FXML
    private TableColumn<Player, LocalDate> dobCollumn;
    @FXML
    private TableColumn<Player, String> nameColumn;
    @FXML
    private TableColumn<Player, String> collegeColumn;
    @FXML
    private TableColumn<Player, String> teamColumn;

    public static Team team;

    public void passingSelectedTeam(Team _team){
        team = _team;
    }

    public void initialize(){
        nameText.setText(team.getName());
        divisionText.setText(team.getDivision());
        headcoachText.setText(team.getHeadCoach());
        ownerText.setText(team.getOwner());
        nameColumn.setCellValueFactory(new PropertyValueFactory<Player,String>("name"));
        collegeColumn.setCellValueFactory(new PropertyValueFactory<Player,String>("college"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<Player,String>("position"));
        dobCollumn.setCellValueFactory(new PropertyValueFactory<Player, LocalDate>("dateOfBirth"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<Player,Integer>("weight"));
        heightColumn.setCellValueFactory(new PropertyValueFactory<Player,Integer>("height"));
        teamColumn.setCellValueFactory(new PropertyValueFactory<Player,String>("draftTeam"));
        DAOImplementation dao = new DAOImplementation();
        dao.DbConnect();
        ArrayList<Player> players = dao.GetPlayersData();
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).getDraftTeam().equals(team.getName())){
                TeamTableView.getItems().add(players.get(i));
                System.out.println(players.get(i).getDraftTeam());
                System.out.println(team.getName());
            }
        }

    }
    @FXML
    void handleButtonBackPushed(ActionEvent event) throws IOException {
        App.setRoot("searchTeam");
    }

}
