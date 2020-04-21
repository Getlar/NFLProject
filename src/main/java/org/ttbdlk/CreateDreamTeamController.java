package org.ttbdlk;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.PointLight;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class CreateDreamTeamController{
    private final DAOImplementation connect = new DAOImplementation();
    public Player akt;
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
    private ListView<Player> playerTextArea;

    @FXML
    private AnchorPane playerAddingAP;

    @FXML
    private TextField teamOwnerTextField;

    @FXML
    private TextField playerDateOfBirthTextField;

    @FXML
    private ListView<Player> playerTextArea2;


    @FXML
    void createTeamButtonPressed()
    {
        connect.DbConnect();
        Team tmp = new Team(teamNameTextField.getText(),teamDivisionTextField.getText(),teamOwnerTextField.getText(),teamHeadCoachTextField.getText());
        connect.pushDataToTeams(tmp);
        playerAddingAP.setVisible(true);
        ArrayList<Player> players = connect.GetPlayersData();
        for (Player player : players) {
            System.out.println(player.getName());
            playerTextArea.getItems().add(player);
        }
        playerTextArea.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount()==1){
                    Player itemsSelected = playerTextArea.getSelectionModel().getSelectedItem();
                    akt = itemsSelected;
                    System.out.println(itemsSelected);
                }
            }
        });
    }

    public void initialize(){
        playerAddingAP.setVisible(false);
    }
    @FXML
    void buttonToFomenu(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }


    @FXML
    void handleAddButton(ActionEvent event) {

        connect.DbConnect();
        if (akt != null && playerTextArea2.getItems().size() < 12) {
            playerTextArea2.getItems().add(akt);
            playerTextArea.getItems().remove(akt);
            akt = null;
        }
        if (playerTextArea2.getItems().size() == 12){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Too Many Players");
            alert.setHeaderText("Too Many Players");
            alert.setContentText("You Have Chosen Too Many Players. Maximum Team Size Is 12!");
            alert.showAndWait();
        }
    }

    @FXML
    void handleResetButton(ActionEvent event) {
        playerTextArea.getItems().add(playerTextArea2.getItems().get(playerTextArea2.getItems().size()-1));
        playerTextArea2.getItems().remove(playerTextArea2.getItems().get(playerTextArea2.getItems().size()-1));
    }
    @FXML
    void handleFinalizeButton(ActionEvent event) {

    }
}
