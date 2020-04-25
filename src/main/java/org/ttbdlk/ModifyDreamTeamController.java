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

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ModifyDreamTeamController extends DAOImplementation  {

    private Team chosen;
    private Player firstPlayer = null;
    private Player secondPLayer = null;
    private int changeCount = 0;
    private boolean modifyButtonChanged = false;
    private final String[] divisions = {"AFC North", "AFC East", "AFC West", "AFC South", "NFC North","NFC East", "NFC West", "NFC South"};
    private final List<String> teamDivisions = Arrays.asList(divisions);
    private List<String> changed = new ArrayList<>();
    private List<String> change = new ArrayList<>();

    @FXML
    private TextField changeDivisionTextField;

    @FXML
    private TableColumn<Player, Integer> weightColumn1;

    @FXML
    private TableColumn<Player, String> teamColumn1;

    @FXML
    private TableColumn<Team, String> teamDivColumn;

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
    private TableColumn<Player, String> nameColumn;

    @FXML
    private TextField changeTeamNameTextField;

    @FXML
    private TableColumn<Player, String> teamColumn;

    @FXML
    private TableColumn<Team, String> teamOwnerColumn;

    @FXML
    private TableView<Team> dreamTeamTableView;

    @FXML
    private TableColumn<Player, String> positionColumn;

    @FXML
    private TableColumn<Player, Integer> heightColumn1;

    @FXML
    private TableColumn<Player, Integer> heightColumn;

    @FXML
    private TableView<Player> exchangePlayerTableView1;

    @FXML
    private TableView<Player> exchangePlayerTableView;

    @FXML
    private TableColumn<Player, String> collegeColumn1;

    @FXML
    private TableColumn<Team, String> teamHeadCoachColumn;

    @FXML
    private TableColumn<Player, String> collegeColumn;

    @FXML
    private TableColumn<Player, String> nameColumn1;

    @FXML
    private TableColumn<Team, String> teamNameColumn;

    @FXML
    public void initialize() throws IOException {
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
        DbConnect();
        ArrayList<Team> dreamTeams = getDreamTeams();
        ObservableList<Team> dream = FXCollections.observableArrayList();
        dream.addAll(dreamTeams);
        dreamTeamTableView.setItems(dream);
    }

    @FXML
    void handleExchangePlayerButton(ActionEvent event) throws IOException {
        if (firstPlayer == null || secondPLayer == null){
            App.alertApp(Alert.AlertType.ERROR,"Selection Error!", null, "Please select one player from each team to exchange!");
        }else {
            if (changeCount != 4) {
                exchangePlayerTableView.getItems().remove(firstPlayer);
                exchangePlayerTableView.getItems().add(secondPLayer);
                exchangePlayerTableView1.getItems().remove(secondPLayer);
                exchangePlayerTableView1.getItems().add(firstPlayer);
                change.add(firstPlayer.getName());
                changed.add(secondPLayer.getName());
                changeCount++;
                exchangePlayers(chosen, firstPlayer, secondPLayer);
                firstPlayer = null;
                secondPLayer = null;
            } else {
                App.alertApp(Alert.AlertType.ERROR,"Exchange Limit Reached!", null, "You have reached your exchange limit of 4!");
            }
        }
    }

    @FXML
    void handleFinalizeTeamButton(ActionEvent event) throws IOException {
        String teamName = changeTeamNameTextField.getText();
        String teamOwner = changeOwnerTextField.getText();
        String teamCoach = changeHeadCoachTextField.getText();
        String teamDivision = changeDivisionTextField.getText();
        if (teamName.equals("")){
            teamName = chosen.getName();
        }
        if (teamOwner.equals("")){
            teamOwner = chosen.getOwner();
        }
        if (teamCoach.equals("")){
            teamCoach = chosen.getHeadCoach();
        }
        if (teamDivision.equals("")){
            teamDivision = chosen.getDivision();
        }
        if(!teamDivisions.contains(teamDivision)){
            App.alertApp(Alert.AlertType.ERROR, "Team Division Error!", null, "Your division does not exist. Selection examples: AFC North, NFC West etc.");
        }else {
            Team newTeam = new Team(teamName, teamDivision, teamCoach, teamOwner);
            StringBuilder sb = new StringBuilder();
            sb.append("Are you sure you want to apply these changes?\n").append("Team Name: ").append(chosen.getName()).append(" -> ").append(teamName).append("\n").append("Team Division: ").append(chosen.getDivision()).append(" -> ").append(teamDivision).append("\n").append("Team Head Coach: ").append(chosen.getHeadCoach()).append(" -> ").append(teamCoach).append("\n").append("Team Owner: ").append(chosen.getOwner()).append(" -> ").append(teamOwner);
            if (change.size()!=0){
                for (int i = 0; i < change.size(); i++){
                    sb.append("\n" + changed.get(i)+" -> " + change.get(i));
                }
            }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Modifications!");
            alert.setHeaderText(null);
            alert.setContentText(sb.toString());
            Optional <ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK){
                updateDataInDreamTeams(newTeam, chosen);
                exchangePlayerTableView1.setItems(null);
                exchangePlayerTableView.setItems(null);
                App.setRoot("dreamTeam");
            }
        }
    }

    @FXML
    void handleDeleteSelectedTeamButton(ActionEvent event) throws IOException {
        if (chosen!=null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Deleting Dream Team");
            alert.setHeaderText(null);
            alert.setContentText("Do you wish to delete dream team?");
            Optional<ButtonType> action = alert.showAndWait();
            //noinspection OptionalGetWithoutIsPresent
            if (action.get() == ButtonType.OK) {
                deleteDreamTeam(chosen.getName());
                dreamTeamTableView.getItems().remove(chosen);
                chosen = null;
                playersAP.setVisible(false);
                modifyButtonChanged = false;
            }
        }else{
            App.alertApp(Alert.AlertType.ERROR,"Selection Error!",null,"Please select a team first before deleting!");
        }
    }

    @FXML
    void handleModifyTeamButton(ActionEvent event) throws IOException {
        if (modifyButtonChanged) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Deleting Modifications!");
            alert.setHeaderText(null);
            alert.setContentText("Your modifications will be reverted. Do you wish to proceed?");
            Optional<ButtonType> action = alert.showAndWait();
            //noinspection OptionalGetWithoutIsPresent
            if (action.get() == ButtonType.OK) {
                buttonListing();
                changeOwnerTextField.setText("");
                changeHeadCoachTextField.setText("");
                changeDivisionTextField.setText("");
                changeTeamNameTextField.setText("");
            }
        }
        buttonListing();
    }

    private void buttonListing() throws IOException {
        if (chosen != null) {
            playersAP.setVisible(true);
            CreateDreamTeamController.tableSetup(nameColumn, collegeColumn, positionColumn, dobColumn, weightColumn, heightColumn, teamColumn, nameColumn1, collegeColumn1, positionColumn1, dobColumn1, weightColumn1, heightColumn1, teamColumn1);
            exchangePlayerTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent click) {
                    if (click.getClickCount() == 1) {
                        Player p = exchangePlayerTableView.getSelectionModel().getSelectedItem();
                        firstPlayer = p;
                    }
                }
            });
            exchangePlayerTableView1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent click) {
                    if (click.getClickCount() == 1) {
                        Player p = exchangePlayerTableView1.getSelectionModel().getSelectedItem();
                        secondPLayer = p;
                    }
                }
            });
            ArrayList<Player> players = new ArrayList<>();
            players = GetPlayersData();
            ObservableList<Player> jatekosok = FXCollections.observableArrayList();
            jatekosok.addAll(players);
            exchangePlayerTableView1.setItems(jatekosok);
            ArrayList<Player> dreamPlayers = new ArrayList<>();
            dreamPlayers = getPlayersFromDreamTeam(chosen);
            ObservableList<Player> alomJatekosok = FXCollections.observableArrayList();
            alomJatekosok.addAll(dreamPlayers);
            exchangePlayerTableView.setItems(alomJatekosok);
            changeTeamNameTextField.setPromptText("Change Team Name...");
            changeDivisionTextField.setPromptText("Change Division...");
            changeHeadCoachTextField.setPromptText("Change Head Coach...");
            changeOwnerTextField.setPromptText("Change Owner...");
            modifyButtonChanged = true;
        }else{
            App.alertApp(Alert.AlertType.ERROR,"Selection Error!",null,"Please select a team to modify!");
        }
    }

    @FXML
    void handleMainMenuButton(ActionEvent event) throws IOException {
        if (modifyButtonChanged){
            App.alertApp(Alert.AlertType.CONFIRMATION,"Confirmation Dialog",null,"Are you sure you want to go back?\nYour modifications will be deleted!");
        }else{
            App.setRoot("primary");
        }
    }

    @FXML
    void handleBackButton(ActionEvent event) throws IOException {
        if (modifyButtonChanged){
            App.alertApp(Alert.AlertType.CONFIRMATION,"Confirmation Dialog",null,"Are you sure you want to go back?\nYour modifications will be deleted!");
        }else{
            App.setRoot("primary");
        }
    }
}
