package org.ttbdlk;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.PointLight;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.security.spec.RSAOtherPrimeInfo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class CreateDreamTeamController{
    private final DAOImplementation connect = new DAOImplementation();
    public Player akt;
    public Text texxt;
    @FXML
    private TextField playerNameTextField;

    @FXML
    private TextField teamNameTextField;

    @FXML
    private TextField playerPositionTextField;

    @FXML
    private TextField playerHeightTextField;

    @FXML
    private TextField playerDraftTeamTextField;

    @FXML
    private TextField teamDivisionTextField;

    @FXML
    private TextField teamHeadCoachTextField;

    @FXML
    private TextField playerWeightTextField;

    @FXML
    private TextField playerCollegeTextField;

    @FXML
    private AnchorPane playerAddingAP;

    @FXML
    private TextField teamOwnerTextField;

    @FXML
    private TextField playerDateOfBirthTextField;

    @FXML
    private TableView<Player> playerTableView;

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

    @FXML
    private TableView<Player> playerTableView2;

    @FXML
    private TableColumn<Player, String> positionColumn1;

    @FXML
    private TableColumn<Player, Integer> heightColumn1;

    @FXML
    private TableColumn<Player, Integer> weightColumn1;

    @FXML
    private TableColumn<Player, LocalDate> dobCollumn1;

    @FXML
    private TableColumn<Player, String> nameColumn1;

    @FXML
    private TableColumn<Player, String> collegeColumn1;

    @FXML
    private TableColumn<Player, String> teamColumn1;

    @FXML
    void createTeamButtonPressed()
    {
        connect.DbConnect();
        Team tmp = new Team(teamNameTextField.getText(),teamDivisionTextField.getText(),teamOwnerTextField.getText(),teamHeadCoachTextField.getText());
        connect.pushDataToTeams(tmp);
        playerAddingAP.setVisible(true);
        ObservableList<Player> jatekosok = FXCollections.observableArrayList();

        ArrayList<Player> players = connect.GetPlayersData();
        jatekosok.addAll(players);
        playerTableView.setItems(jatekosok);
        playerTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount()==1){
                    Player p = playerTableView.getSelectionModel().getSelectedItem();
                    akt = p;
                }
            }
        });
    }
    @FXML
    void buttonToBack() throws IOException {
        App.setRoot("dreamTeam");
    }

    public void initialize(){
        playerAddingAP.setVisible(false);
        nameColumn.setCellValueFactory(new PropertyValueFactory<Player,String>("name"));
        collegeColumn.setCellValueFactory(new PropertyValueFactory<Player,String>("college"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<Player,String>("position"));
        dobCollumn.setCellValueFactory(new PropertyValueFactory<Player,LocalDate>("dateOfBirth"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<Player,Integer>("weight"));
        heightColumn.setCellValueFactory(new PropertyValueFactory<Player,Integer>("height"));
        teamColumn.setCellValueFactory(new PropertyValueFactory<Player,String>("draftTeam"));
        nameColumn1.setCellValueFactory(new PropertyValueFactory<Player,String>("name"));
        collegeColumn1.setCellValueFactory(new PropertyValueFactory<Player,String>("college"));
        positionColumn1.setCellValueFactory(new PropertyValueFactory<Player,String>("position"));
        dobCollumn1.setCellValueFactory(new PropertyValueFactory<Player,LocalDate>("dateOfBirth"));
        weightColumn1.setCellValueFactory(new PropertyValueFactory<Player,Integer>("weight"));
        heightColumn1.setCellValueFactory(new PropertyValueFactory<Player,Integer>("height"));
        teamColumn1.setCellValueFactory(new PropertyValueFactory<Player,String>("draftTeam"));
        teamNameTextField.setPromptText("Team Name...");
        teamDivisionTextField.setPromptText("Team Division...");
        teamHeadCoachTextField.setPromptText("Team Head Coach...");
        teamOwnerTextField.setPromptText("Team Owner...");
    }
    @FXML
    void buttonToFomenu(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }

    @FXML
    void handleAddButton(ActionEvent event) {

        connect.DbConnect();
        if (akt != null && playerTableView2.getItems().size() < 12) {
            playerTableView2.getItems().add(akt);
            playerTableView.getItems().remove(akt);
            akt = null;
        }
        else if (playerTableView2.getItems().size() == 12){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Too Many Players");
            alert.setHeaderText("Too Many Players");
            alert.setContentText("You Have Chosen Too Many Players. Maximum Team Size Is 12!");
            alert.showAndWait();
        }
    }

    @FXML
    void handleResetButton(ActionEvent event) {
        if (playerTableView2.getItems().size()!=0) {
            playerTableView.getItems().add(playerTableView2.getItems().get(playerTableView2.getItems().size() - 1));
            playerTableView2.getItems().remove(playerTableView2.getItems().get(playerTableView2.getItems().size() - 1));
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("No Players Left");
            alert.setHeaderText("No Players Left");
            alert.setContentText("There are no players left in your Dream Team!");
            alert.showAndWait();
        }
    }
    @FXML
    void handleFinalizeButton(ActionEvent event) throws IOException {
        if (playerTableView2.getItems().size()!=12){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Not Enough Players");
            alert.setHeaderText("Not Enough Players");
            alert.setContentText("You must select at least 12 players to complete your team!");
            alert.showAndWait();
        }else{
            DAOImplementation connect = new DAOImplementation();
            connect.DbConnect();
            for (Player player :playerTableView2.getItems()
                 ) {
                connect.pushDataToPlayers(player);
            }
            playerTableView2.setItems(null);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Siker!");
            alert.setHeaderText("Siker!");
            alert.setContentText("Sikeresen létrehoztad a szupercsapatodat!");
            alert.showAndWait();
            App.setRoot("dreamTeam");
        }
    }
}
