package org.ttbdlk;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ModifyDreamTeamController {

    Team chosen;
    Player firstPlayer;
    Player secondPLayer;
    DAOImplementation connect = new DAOImplementation();
    int changeCount = 0;

    @FXML
    private TextField changeDivisionTextField;

    @FXML
    private Text teamOwnerText;

    @FXML
    private TableColumn<Player, Integer> weightColumn1;

    @FXML
    private TableColumn<Player, String> teamColumn1;

    @FXML
    private TableColumn<Team, String> teamDivColumn;

    @FXML
    private Button mainMenuButton;

    @FXML
    private Button deleteSelectedTeamButton;

    @FXML
    private TableColumn<Player, LocalDate> dobColumn1;

    @FXML
    private TableColumn<Player, LocalDate> dobColumn;

    @FXML
    private TableColumn<Player, Integer> weightColumn;

    @FXML
    private AnchorPane playersAP;

    @FXML
    private TextField changeHeadCoachTextField;

    @FXML
    private TextField changeOwnerTextField;

    @FXML
    private TableColumn<Player, String> positionColumn1;

    @FXML
    private AnchorPane teamsAP;

    @FXML
    private TableColumn<Player, String> nameColumn;

    @FXML
    private Button finalizePlayerButton;

    @FXML
    private Text changeTeamOptionsText;

    @FXML
    private TextField changeTeamNameTextField;

    @FXML
    private TableColumn<Player, String> teamColumn;

    @FXML
    private Button exchangePlayerButton;

    @FXML
    private TableColumn<Team, String> teamOwnerColumn;

    @FXML
    private Button backButton;

    @FXML
    private TableView<Team> dreamTeamTableView;

    @FXML
    private TableColumn<Player, String> positionColumn;

    @FXML
    private TableColumn<Player, Integer> heightColumn1;

    @FXML
    private TableColumn<Player, Integer> heightColumn;

    @FXML
    private Button deletePlayerButton;

    @FXML
    private TableView<Player> exchangePlayerTableView1;

    @FXML
    private Text teamNameText;

    @FXML
    private TableView<Player> exchangePlayerTableView;

    @FXML
    private TableColumn<Player, String> collegeColumn1;

    @FXML
    private Text dreamTeamText;

    @FXML
    private Text teamDivisionText;

    @FXML
    private TableColumn<Team, String> teamHeadCoachColumn;

    @FXML
    private Button modifyTeamButton;

    @FXML
    private Text teamHeadCoachText;

    @FXML
    private Text exchangePlayerText;

    @FXML
    private TableColumn<Player, String> collegeColumn;

    @FXML
    private TableColumn<Player, String> nameColumn1;

    @FXML
    private TableColumn<Team, String> teamNameColumn;

    @FXML
    public void initialize(){
        playersAP.setVisible(false);
        teamNameColumn.setCellValueFactory(new PropertyValueFactory<Team, String>("name"));
        teamDivColumn.setCellValueFactory(new PropertyValueFactory<Team, String>("division"));
        teamHeadCoachColumn.setCellValueFactory(new PropertyValueFactory<Team, String>("headCoach"));
        teamOwnerColumn.setCellValueFactory(new PropertyValueFactory<Team, String>("owner"));
        dreamTeamTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount()==1){
                    Team t = dreamTeamTableView.getSelectionModel().getSelectedItem();
                    chosen = t;
                }
            }
        });
        connect.DbConnect();
        //connect.GetTeamsData();
        //kiiratas tablaba
    }

    @FXML
    void handleExchangePlayerButton(ActionEvent event) {
        if (changeCount != 4) {
            exchangePlayerTableView.getItems().remove(firstPlayer);
            exchangePlayerTableView.getItems().add(secondPLayer);
            exchangePlayerTableView1.getItems().remove(secondPLayer);
            exchangePlayerTableView1.getItems().add(firstPlayer);
            changeCount++;
            //connect.exchangePlayers(firstPlayer,secondPLayer,chosen);
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Exchange Limit Reached!");
            alert.setHeaderText("Exchange Limit Reached!");
            alert.setContentText("You have reached your exchange limit of 4!");
            alert.showAndWait();
        }
    }

    @FXML
    void handleFinalizeTeamButton(ActionEvent event) {

    }

    @FXML
    void handleDeleteSelectedTeamButton(ActionEvent event) {
        dreamTeamTableView.getItems().remove(chosen);
        //connect.deleteTeamFromDreamTeam(chosen);
    }

    @FXML
    void handleModifyTeamButton(ActionEvent event) {
        playersAP.setVisible(true);
        nameColumn.setCellValueFactory(new PropertyValueFactory<Player,String>("name"));
        collegeColumn.setCellValueFactory(new PropertyValueFactory<Player,String>("college"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<Player,String>("position"));
        dobColumn.setCellValueFactory(new PropertyValueFactory<Player, LocalDate>("dateOfBirth"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<Player,Integer>("weight"));
        heightColumn.setCellValueFactory(new PropertyValueFactory<Player,Integer>("height"));
        teamColumn.setCellValueFactory(new PropertyValueFactory<Player,String>("draftTeam"));
        nameColumn1.setCellValueFactory(new PropertyValueFactory<Player,String>("name"));
        collegeColumn1.setCellValueFactory(new PropertyValueFactory<Player,String>("college"));
        positionColumn1.setCellValueFactory(new PropertyValueFactory<Player,String>("position"));
        dobColumn1.setCellValueFactory(new PropertyValueFactory<Player, LocalDate>("dateOfBirth"));
        weightColumn1.setCellValueFactory(new PropertyValueFactory<Player,Integer>("weight"));
        heightColumn1.setCellValueFactory(new PropertyValueFactory<Player,Integer>("height"));
        teamColumn1.setCellValueFactory(new PropertyValueFactory<Player,String>("draftTeam"));
        exchangePlayerTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount()==1){
                    Player p = exchangePlayerTableView.getSelectionModel().getSelectedItem();
                    firstPlayer = p;
                }
            }
        });
        exchangePlayerTableView1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount()==1){
                    Player p = exchangePlayerTableView1.getSelectionModel().getSelectedItem();
                    secondPLayer = p;
                }
            }
        });
        ArrayList<Player> players = new ArrayList<>();
        players = connect.GetPlayersData();
        ObservableList<Player> jatekosok = FXCollections.observableArrayList();
        jatekosok.addAll(players);
        exchangePlayerTableView1.setItems(jatekosok);
        ArrayList<Player> dreamPlayers = new ArrayList<>();
        dreamPlayers = connect.GetPlayersData(); //////////////
        ObservableList<Player> alomJatekosok = FXCollections.observableArrayList();
        exchangePlayerTableView.setItems(alomJatekosok);
        changeTeamNameTextField.setPromptText("Change Team Name...");
        changeDivisionTextField.setPromptText("Change Division...");
        changeHeadCoachTextField.setPromptText("Change Head Coach...");
        changeOwnerTextField.setPromptText("Change Owner...");
    }

    @FXML
    void handleMainMenuButton(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }

    @FXML
    void handleBackButton(ActionEvent event) throws IOException {
        App.setRoot("dreamTeam");
    }
}
