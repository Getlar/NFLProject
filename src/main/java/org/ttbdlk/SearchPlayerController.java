package org.ttbdlk;

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

    private ArrayList<Player> players;
    private String positionSortingValue;
    private String collegeSortingValue;


    private ArrayList<String> sortingValuesForPositionComboBox(){
        ArrayList<String> values = new ArrayList<>();
        for (Player player : players) {
            boolean bennevan = false;
            for (String value : values) {
                if (player.getPosition().equals(value)) {
                    bennevan = true;
                    break;
                }
            }
            if (!bennevan) {
                values.add(player.getPosition());
            }
        }
        return values;
    }

    private ArrayList<String> sortingValuesForCollegeComboBox(){
        ArrayList<String> values = new ArrayList<>();
        for (Player player : players) {
            boolean bennevan = false;
            for (String value : values) {
                if (player.getCollege().equals(value)) {
                    bennevan = true;
                    break;
                }
            }
            if (!bennevan) {
                values.add(player.getCollege());
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
            for (Player player : players) {
                PlayerListView.getItems().add(player);
            }
        }
    }

    public void initialize()  throws IOException{
        DbConnect();
        fillTheTeamList();
        ArrayList<String> collegeValues = sortingValuesForCollegeComboBox();
        collegeComboBox.getItems().add("none");
        for (String collegeValue : collegeValues) {
            collegeComboBox.getItems().add(collegeValue);
        }
        ArrayList<String> positionValues = sortingValuesForPositionComboBox();
        positionComboBox.getItems().add("none");
        for (String positionValue : positionValues) {
            positionComboBox.getItems().add(positionValue);
        }
        positionComboBox.getSelectionModel().select(0);
        collegeComboBox.getSelectionModel().select(0);
        collegeSortingValue = "none";
        positionSortingValue = "none";
    }

    @FXML
    private void handleSelectionChangedPositionComboBox() {
        positionSortingValue = positionComboBox.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void handleSelectionChangedCollegeComboBox() {
        collegeSortingValue = collegeComboBox.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void handleButtonBackPushed() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void handleButtonViewPushed() throws IOException {
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
    private void handleButtonSearchPushed() throws IOException {
        String criteria = searchTeamTextField.getText();
        PlayerListView.getItems().clear();
        if(criteria.equals("") && positionSortingValue.equals("none") && collegeSortingValue.equals("none")){
            App.alertApp(Alert.AlertType.WARNING, "Add searching criteria!", "", "You need to add one or more criterias to search!");
        }else if(collegeSortingValue.equals("none") && positionSortingValue.equals("none")){

            for (Player player : players) {
                if (player.getName().toLowerCase().contains(criteria.toLowerCase())) {
                    PlayerListView.getItems().add(player);
                }
            }
        }else if(!collegeSortingValue.equals("none") && positionSortingValue.equals("none")){
            for (Player player : players) {
                if (player.getName().toLowerCase().contains(criteria.toLowerCase())
                        && collegeSortingValue.equals(player.getCollege())) {
                    PlayerListView.getItems().add(player);
                }
            }
        }else if(collegeSortingValue.equals("none")){
            for (Player player : players) {
                if (player.getName().toLowerCase().contains(criteria.toLowerCase())
                        && positionSortingValue.equals(player.getPosition())) {
                    PlayerListView.getItems().add(player);
                }
            }
        }else
            {
            PlayerListView.getItems().clear();
                for (Player player : players) {
                    if (player.getName().toLowerCase().contains(criteria.toLowerCase())
                            && positionSortingValue.equals(player.getPosition())
                            && collegeSortingValue.equals(player.getCollege())) {
                        PlayerListView.getItems().add(player);
                    }
                }
        }
    }

    public void onEnter() throws IOException {
        handleButtonSearchPushed();
    }
}
