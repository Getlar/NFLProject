package org.ttbdlk;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateDreamTeamController extends  DAOImplementation{

    private Player akt;
    private Team toBeDreamTeam;
    private boolean finalizePressed = false;
    private boolean createPressed = false;
    private final String[] divisions = {"AFC North", "AFC East", "AFC West", "AFC South", "NFC North","NFC East", "NFC West", "NFC South"};
    private final List<String> teamDivisions = Arrays.asList(divisions);

    @FXML
    private TextField teamNameTextField;

    @FXML
    private TextField teamDivisionTextField;

    @FXML
    private TextField teamHeadCoachTextField;

    @FXML
    private AnchorPane playerAddingAP;

    @FXML
    private TextField teamOwnerTextField;

    @FXML
    private TableView<Player> playerTableView;

    @FXML
    private TableColumn<Player, String> positionColumn;

    @FXML
    private TableColumn<Player, Integer> heightColumn;

    @FXML
    private TableColumn<Player, Integer> weightColumn;

    @FXML
    private TableColumn<Player, LocalDate> dobColumn;

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
    private TableColumn<Player, LocalDate> dobColumn1;

    @FXML
    private TableColumn<Player, String> nameColumn1;

    @FXML
    private TableColumn<Player, String> collegeColumn1;

    @FXML
    private TableColumn<Player, String> teamColumn1;

    @FXML
    private void createTeamButtonPressed() throws IOException {
        if (createPressed){
            App.alertApp(Alert.AlertType.ERROR, "Creation Error!",null,"You have already created your team!");
        }
        else if (teamNameTextField.getText().equals("") || teamOwnerTextField.getText().equals("") || teamHeadCoachTextField.getText().equals("") || teamDivisionTextField.getText().equals("")){
            App.alertApp(Alert.AlertType.ERROR, "Not All Parameters Specified!", null, "Please specify all the given parameters!");
        }
        else if(!teamNameIsValid(teamNameTextField.getText())){
            App.alertApp(Alert.AlertType.ERROR, "Team Name Error!", null, "You Team Name has an invalid format.");
        }else if(!divisionIsValid(teamDivisionTextField.getText())){
            App.alertApp(Alert.AlertType.ERROR, "Team Division Error!", null, "Your division does not exist. Selection examples: AFC North, NFC West etc.");
        }else if(!ownerNameIsValid(teamOwnerTextField.getText())){
            App.alertApp(Alert.AlertType.ERROR, "Team Owner Error!", null, "You Team Owner has an invalid format.");
        }else if(!coachNameIsValid(teamHeadCoachTextField.getText())){
            App.alertApp(Alert.AlertType.ERROR, "Team Head Coach Error!", null, "You Team Head Coach has an invalid format.");
        }
        else{
            tableSetup(nameColumn, collegeColumn, positionColumn, dobColumn, weightColumn, heightColumn, teamColumn, nameColumn1, collegeColumn1, positionColumn1, dobColumn1, weightColumn1, heightColumn1, teamColumn1);
            teamNameTextField.setPromptText("Team Name...");
            teamDivisionTextField.setPromptText("Team Division...");
            teamHeadCoachTextField.setPromptText("Team Head Coach...");
            teamOwnerTextField.setPromptText("Team Owner...");
            playerAddingAP.setVisible(true);
            Team tmp = new Team(teamNameTextField.getText(), teamDivisionTextField.getText(), teamHeadCoachTextField.getText(), teamOwnerTextField.getText());
            toBeDreamTeam = tmp;
            pushDataToDreamTeams(tmp);
            ObservableList<Player> jatekosok = FXCollections.observableArrayList();
            ArrayList<Player> players = GetPlayersData();
            jatekosok.addAll(players);
            playerTableView.setItems(jatekosok);
            playerTableView.setOnMouseClicked(click -> {
                if (click.getClickCount() == 1) {
                    akt = playerTableView.getSelectionModel().getSelectedItem();
                }
            });
            createPressed = true;
        }
    }

    @FXML
    private void buttonToBack() throws IOException {
        if (!finalizePressed && createPressed){
            App.alertApp(Alert.AlertType.CONFIRMATION,"Confirmation Dialog",toBeDreamTeam.getName(),"Are you sure you want to go back?\nYour dream team will be deleted!");
        }else{
            App.setRoot("dreamTeam");
        }
    }

    @FXML
    private void buttonToFomenu() throws IOException {
        if (!finalizePressed && createPressed){
            App.alertApp(Alert.AlertType.CONFIRMATION,"Confirmation Dialog",toBeDreamTeam.getName(),"Are you sure you want to go back?\nYour dream team will be deleted!");
        }else{
            App.setRoot("primary");
        }
    }

    public void initialize() throws IOException {
        playerAddingAP.setVisible(false);
        DbConnect();
    }

    @FXML
    private void handleAddButton() throws IOException {
        if (akt != null && playerTableView2.getItems().size() < 11) {
            playerTableView2.getItems().add(akt);
            playerTableView.getItems().remove(akt);
            akt = null;
        }
        else if (playerTableView2.getItems().size() == 11){
            App.alertApp(Alert.AlertType.ERROR, "Too Many Players!", "Too Many Players!", "You have chosen too many players. Maximum team size is 11!");
        }
    }

    @FXML
    private void handleResetButton() throws IOException {
        if (playerTableView2.getItems().size()!=0) {
            playerTableView.getItems().add(playerTableView2.getItems().get(playerTableView2.getItems().size() - 1));
            playerTableView2.getItems().remove(playerTableView2.getItems().get(playerTableView2.getItems().size() - 1));
        }else{
            App.alertApp(Alert.AlertType.ERROR,"No Players Left!", "No Players Left!", "There are no players left to remove from your team!");
        }
    }
    @FXML
    private void handleFinalizeButton() throws IOException {
        if (playerTableView2.getItems().size()!=11){
            App.alertApp(Alert.AlertType.ERROR,"Not Enough Players!","Not Enough Players!", "You must select exactly 11 players to finalize your team!");
        }else{
            for (Player player :playerTableView2.getItems()
                 ) {
                pushPlayerToDreamTeam(toBeDreamTeam,player);
            }
            playerTableView2.setItems(null);
            App.alertApp(Alert.AlertType.INFORMATION, "Congratulations!","Congratulations!", "Your dream team has been created!");
            finalizePressed = true;
            App.setRoot("dreamTeam");
        }
    }
    static void tableSetup(TableColumn<Player, String> nameColumn, TableColumn<Player, String> collegeColumn, TableColumn<Player, String> positionColumn, TableColumn<Player, LocalDate> dobCollumn, TableColumn<Player, Integer> weightColumn, TableColumn<Player, Integer> heightColumn, TableColumn<Player, String> teamColumn, TableColumn<Player, String> nameColumn1, TableColumn<Player, String> collegeColumn1, TableColumn<Player, String> positionColumn1, TableColumn<Player, LocalDate> dobCollumn1, TableColumn<Player, Integer> weightColumn1, TableColumn<Player, Integer> heightColumn1, TableColumn<Player, String> teamColumn1) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        collegeColumn.setCellValueFactory(new PropertyValueFactory<>("college"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        dobCollumn.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        heightColumn.setCellValueFactory(new PropertyValueFactory<>("height"));
        teamColumn.setCellValueFactory(new PropertyValueFactory<>("draftTeam"));
        nameColumn1.setCellValueFactory(new PropertyValueFactory<>("name"));
        collegeColumn1.setCellValueFactory(new PropertyValueFactory<>("college"));
        positionColumn1.setCellValueFactory(new PropertyValueFactory<>("position"));
        dobCollumn1.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        weightColumn1.setCellValueFactory(new PropertyValueFactory<>("weight"));
        heightColumn1.setCellValueFactory(new PropertyValueFactory<>("height"));
        teamColumn1.setCellValueFactory(new PropertyValueFactory<>("draftTeam"));
    }

}
