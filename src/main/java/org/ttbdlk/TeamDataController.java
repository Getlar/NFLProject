package org.ttbdlk;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class TeamDataController extends DAOImplementation {

    @FXML
    private Text headcoachText;
    @FXML
    private Text OwnerText;
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

    private static Team team;

    public void passingSelectedTeam(Team _team){
        team = _team;
    }

    public void initialize() throws IOException{
        nameText.setText(team.getName());
        divisionText.setText(team.getDivision());
        headcoachText.setText(team.getHeadCoach());
        OwnerText.setText(team.getOwner());
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        collegeColumn.setCellValueFactory(new PropertyValueFactory<>("college"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        dobCollumn.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        heightColumn.setCellValueFactory(new PropertyValueFactory<>("height"));
        teamColumn.setCellValueFactory(new PropertyValueFactory<>("draftTeam"));
        DbConnect();
        ArrayList<Player> players = GetPlayersData();
        for (Player player : players) {
            if (player.getDraftTeam().equals(team.getName())) {
                TeamTableView.getItems().add(player);
            }
        }
    }

    @FXML
    private void handleButtonBackPushed() throws IOException {
        App.setRoot("searchTeam");
    }
}
