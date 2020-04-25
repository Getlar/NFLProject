package org.ttbdlk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.ArrayList;

public class SearchPlayerController extends DAOImplementation{
    @FXML
    private ListView<Player> PlayerListView;
    @FXML
    private ComboBox<String> collegeComboBox;
    @FXML
    private ComboBox<String> positionComboBox;
    @FXML
    private TextField searchTeamTextField;

    ArrayList<Player> players;
    String positionSortingValue;
    String collegeSortingValue;


    private ArrayList<String> sortingValuesForPositionComboBox(){
        ArrayList<String> values = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            boolean bennevan = false;
            for (int j = 0; j < values.size(); j++) {
                if(players.get(i).getPosition().equals(values.get(j))){
                    bennevan = true;
                    break;
                }
            }
            if(!bennevan){
                values.add(players.get(i).getPosition());
            }
        }
        return values;
    }

    private ArrayList<String> sortingValuesForCollegeComboBox(){
        ArrayList<String> values = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            boolean bennevan = false;
            for (int j = 0; j < values.size(); j++) {
                if(players.get(i).getCollege().equals(values.get(j))){
                    bennevan = true;
                    break;
                }
            }
            if(!bennevan){
                values.add(players.get(i).getCollege());
            }
        }
        return values;
    }

    private void fillTheTeamList()  throws IOException{
        players = GetPlayersData();
        if(players == null){
            App.alertApp(Alert.AlertType.WARNING, "Database error!", "", "Something went wrong with the database!");
        }else{
            PlayerListView.getItems().clear();
            for (int i = 0; i < players.size(); i++) {
                PlayerListView.getItems().add(players.get(i));
            }
        }
    }

    public void initialize()  throws IOException{
        DbConnect();
        fillTheTeamList();
        ArrayList<String> collegeValues = sortingValuesForCollegeComboBox();
        collegeComboBox.getItems().add("none");
        for (int i = 0; i < collegeValues.size(); i++) {
            collegeComboBox.getItems().add(collegeValues.get(i));
        }
        ArrayList<String> positionValues = sortingValuesForPositionComboBox();
        positionComboBox.getItems().add("none");
        for (int i = 0; i < positionValues.size(); i++) {
            positionComboBox.getItems().add(positionValues.get(i));
        }
        positionComboBox.getSelectionModel().select(0);
        collegeComboBox.getSelectionModel().select(0);
        collegeSortingValue = "none";
        positionSortingValue = "none";
    }

    @FXML
    void handleSelectionChangedPositionComboBox(ActionEvent event) {
        positionSortingValue = positionComboBox.getSelectionModel().getSelectedItem();
    }

    @FXML
    void handleSelectionChangedCollegeComboBox(ActionEvent event) {
        collegeSortingValue = collegeComboBox.getSelectionModel().getSelectedItem();
    }

    @FXML
    void handleButtonBackPushed(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }

    @FXML
    void handleButtonViewPushed(ActionEvent event) throws IOException {
        Player _player = PlayerListView.getSelectionModel().getSelectedItem();
        if(_player == null){
            App.alertApp(Alert.AlertType.WARNING, "Select player!", "", "You need to select a player from the list to check it out!");
        }else{
            PlayerDataController pdc = new PlayerDataController();
            pdc.passingSelectedPlayer(_player);
            App.setRoot("playerData");
        }
    }

    @FXML
    void handleButtonSearchPushed(ActionEvent event) throws IOException {
        String criteria = searchTeamTextField.getText();
        PlayerListView.getItems().clear();
        if(criteria.equals("") && positionSortingValue.equals("none") && collegeSortingValue.equals("none")){
            App.alertApp(Alert.AlertType.WARNING, "Add searching criteria!", "", "You need to add one or more criterias to search!");
        }else if(collegeSortingValue.equals("none") && positionSortingValue.equals("none")){

            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).getName().toLowerCase().contains(criteria.toLowerCase())) {
                    PlayerListView.getItems().add(players.get(i));
                }
            }
        }else if(!collegeSortingValue.equals("none") && positionSortingValue.equals("none")){
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).getName().toLowerCase().contains(criteria.toLowerCase())
                        && collegeSortingValue.equals(players.get(i).getCollege()))
                {
                    PlayerListView.getItems().add(players.get(i));
                }
            }
        }else if(collegeSortingValue.equals("none") && !positionSortingValue.equals("none")){
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).getName().toLowerCase().contains(criteria.toLowerCase())
                        && positionSortingValue.equals(players.get(i).getPosition()))
                {
                    PlayerListView.getItems().add(players.get(i));
                }
            }
        }else
            {
            PlayerListView.getItems().clear();
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).getName().toLowerCase().contains(criteria.toLowerCase())
                        && positionSortingValue.equals(players.get(i).getPosition())
                        && collegeSortingValue.equals(players.get(i).getCollege()))
                {
                    PlayerListView.getItems().add(players.get(i));
                }
            }
        }
    }

    public void onEnter(ActionEvent event) throws IOException {
        handleButtonSearchPushed(event);
    }
}
