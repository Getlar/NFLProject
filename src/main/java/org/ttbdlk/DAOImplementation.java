package org.ttbdlk;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DAOImplementation implements DAO{
    private Connection connection;
    private Statement statement;
    private ResultSet resultset;
    //temporary
    @Override
    public void updateDataInPlayers(int pick, String name){
        try{
            String query="UPDATE players SET Pick = "+pick+"WHERE Name = "+name+";";
            statement.executeQuery(query);

        }catch (Exception ex){
            System.out.println("Error: "+ex);
        }
    }

    @Override
    public int height(int feet, int inch){
        float cm;
        cm= (float) (feet*30.48+2.54*inch);
        return Math.round(cm);
    }

    @Override
    public int weight(int lbs){
        float kg;
        kg=(float) (lbs*0.45359);
        return Math.round(kg);
    }

    //temprorary end
    @Override
    public void DbConnect() throws IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nfl", "root", "");
            statement = connection.createStatement();
        }
        catch (Exception ex){
            App.alertApp(Alert.AlertType.ERROR,"DataBase Error!", "DataBase Error!","There was a problem with our Database. Process aborted!");
            App.setRoot("primary");
        }
    }

    @Override
    public ArrayList<Player> GetPlayersData() throws IOException {
        ArrayList<Player> players = new ArrayList<>();
        try {
            String query = "select * from players";
            resultset = statement.executeQuery(query);

            while (resultset.next()) {
                players.add(new Player(
                        Integer.parseInt(resultset.getString("Pick")),
                        resultset.getString("Name"),
                        resultset.getString("College"),
                        resultset.getString("Position"),
                        LocalDate.parse(resultset.getString("DateOfBirth"), DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                        Integer.parseInt(resultset.getString("Weight")),
                        Integer.parseInt(resultset.getString("Height")),
                        resultset.getString("DraftTeam")
                ));

            }
        } catch (Exception ex) {
            App.alertApp(Alert.AlertType.ERROR,"DataBase Error!", "DataBase Error!","There was a problem with our Database. Process aborted!");
            App.setRoot("primary");
        }
        return players;
    }

    @Override
    public ArrayList<Team> GetTeamsData() throws IOException {
        ArrayList<Team> teams = new ArrayList<>();
        try {
            String query = "select * from teams";
            resultset = statement.executeQuery(query);
            while (resultset.next()) {
                teams.add(new Team(
                        resultset.getString("name"),
                        resultset.getString("division"),
                        resultset.getString("headCoach"),
                        resultset.getString("owner")
                ));

                String name = resultset.getString("name");
                String division = resultset.getString("division");
                String owner = resultset.getString("owner");

            }
        } catch (Exception ex) {
            App.alertApp(Alert.AlertType.ERROR,"DataBase Error!", "DataBase Error!","There was a problem with our Database. Process aborted!");
            App.setRoot("primary");
            App.setRoot("primary");
        }
        return teams;
    }

    @Override
    public void pushDataToTeams(Team team) throws IOException {
        String name = team.getName();
        String division = team.getDivision();
        String owner = team.getOwner();
        String headCoach = team.getHeadCoach();
        try{
            String query = "insert into teams (name, division, HeadCoach, owner) values('"+name+"', '"+division+"', '"+headCoach+"', '"+owner+"');";
            statement.execute(query);
        } catch (Exception ex){
            App.alertApp(Alert.AlertType.ERROR,"DataBase Error!", "DataBase Error!","There was a problem with our Database. Process aborted!");
            App.setRoot("primary");
        }
    }

    @Override
    public void pushDataToPlayers(Player player) throws IOException {
        int pick=player.getPick();
        String name=player.getName();
        String college= player.getCollege();
        String position=player.getPosition();
        LocalDate dateOfBirth=player.getDateOfBirth();
        int weight=player.getWeight();
        int height=player.getHeight();
        String draftTeam=player.getDraftTeam();
        try{
            String query="INSERT INTO Players (Pick, Name, College, Position, DateOfBirth, Weight, Height, DraftTeam) values('"+pick+"', '"+name+"', '"+college+"', '"
                    +position+"', '"+dateOfBirth+"', '"+weight+"', '"+height+"', '"+draftTeam+"');";
            statement.execute(query);
        }catch (Exception ex){
            App.alertApp(Alert.AlertType.ERROR,"DataBase Error!", "DataBase Error!","There was a problem with our Database. Process aborted!");
            App.setRoot("primary");
        }
    }

    public void updateDataInDreamTeams(Team newDreamTeam, Team oldDreamTeam) throws IOException {
        try{
            String query = "UPDATE dreamteams SET Name = '"+newDreamTeam.getName()+"', Division = '"+newDreamTeam.getDivision()+
                    "', HeadCoach = '"+newDreamTeam.getHeadCoach()+"', Owner = '"+newDreamTeam.getOwner()+"' WHERE Name = '"+
                    oldDreamTeam.getName()+"';";
            statement.execute(query);
        } catch (Exception ex){
            App.alertApp(Alert.AlertType.ERROR,"DataBase Error!", "DataBase Error!",ex.toString());
            App.setRoot("primary");
        }
    }

    public void deleteDreamTeam(String dreamTeamName) throws IOException {
        try{
            String query = "DELETE FROM dreamteams WHERE name = '"+dreamTeamName+"';";
            statement.execute(query);
        }catch (Exception ex){
            App.alertApp(Alert.AlertType.ERROR,"DataBase Error!", "DataBase Error!",ex.toString());
            App.setRoot("primary");
        }
    }

    @Override
    public void pushDataToDreamTeams(Team newDreamTeam) throws IOException {
        try {
            String query = "INSERT INTO dreamteams (Name, Division, HeadCoach, Owner) VALUES('" + newDreamTeam.getName() + "', '" + newDreamTeam.getDivision() + "', " +
                    "'" + newDreamTeam.getHeadCoach() + "', '" + newDreamTeam.getOwner() + "');";
            statement.execute(query);
        } catch (Exception ex) {
            App.alertApp(Alert.AlertType.ERROR,"DataBase Error!", "DataBase Error!",ex.toString());
            App.setRoot("primary");
        }
    }

    @Override
    public void pushPlayerToDreamTeam(Team dreamTeam, Player player) throws IOException {
        try{
            String query="SELECT LastPlayer FROM dreamteams WHERE Name = '"+dreamTeam.getName()+"'";
            String modifyLastPlayer;
            int lastPlayerColumn=0;
            resultset=statement.executeQuery(query);
            while(resultset.next()){
                lastPlayerColumn=resultset.getInt(1);
            }
            if(lastPlayerColumn==0){
                query="UPDATE dreamteams SET Player1 ='"+player.getPick()+"' WHERE Name = '"+dreamTeam.getName()+"';";
                modifyLastPlayer="UPDATE dreamteams SET LastPlayer ='1' WHERE Name = '"+dreamTeam.getName()+"';";
            }
            else{
                lastPlayerColumn++;
                query="UPDATE dreamteams SET Player"+lastPlayerColumn+" ='"+player.getPick()+"' WHERE Name = '"+dreamTeam.getName()+"';";
                modifyLastPlayer="UPDATE dreamteams SET LastPlayer ='"+lastPlayerColumn+"' WHERE Name = '"+dreamTeam.getName()+"';";
            }
            //actually pusholás és LastPlayer módosítás
            statement.execute(query);
            statement.execute(modifyLastPlayer);
        }catch (Exception ex){
            App.alertApp(Alert.AlertType.ERROR,"DataBase Error!", "DataBase Error!","There was a problem with our Database. Process aborted!");
            App.setRoot("primary");
        }
    }

    @Override
    public int playersInTheDreamTeam(Team dreamTeam) throws IOException {
        int playersSum=0;
        try{
            String query="SELECT LastPlayer FROM dreamteams WHERE Name = '"+dreamTeam.getName()+"';";
            resultset=statement.executeQuery(query);
            while(resultset.next()){
                playersSum=resultset.getInt(1);
            }
        }catch (Exception ex){
            App.alertApp(Alert.AlertType.ERROR,"DataBase Error!", "DataBase Error!","There was a problem with our Database. Process aborted!");
            App.setRoot("primary");
        }
        return playersSum;
    }

    @Override
    public ArrayList<Team> getDreamTeams() throws IOException {
        ArrayList<Team> dreamTeams=new ArrayList<>();
        String query="SELECT Name, Division, HeadCoach, Owner FROM dreamteams";
        try {
            resultset = statement.executeQuery(query);
            while (resultset.next()) {
                dreamTeams.add(new Team(resultset.getString("Name"),
                        resultset.getString("Division"),
                        resultset.getString("HeadCoach"),
                        resultset.getString("Owner")
                ));
            }
        } catch (Exception ex) {
            App.alertApp(Alert.AlertType.ERROR,"DataBase Error!", "DataBase Error!","There was a problem with our Database. Process aborted!");
            App.setRoot("primary");
        }
        return dreamTeams;
    }

    @Override
    public ArrayList<Player> getPlayersFromDreamTeam(Team dreamTeam) throws IOException {
        ArrayList<Player> playersFromDreamTeam=new ArrayList<>();
        String query;
        int playersInTheDreamTeam=playersInTheDreamTeam(dreamTeam);
        if(playersInTheDreamTeam>0) {
            for (int i=0; i<playersInTheDreamTeam; i++) {
                int actualPlayersId=0;
                query="SELECT Player"+(i+1)+" FROM dreamteams WHERE Name = '"+dreamTeam.getName()+"';";
                try{
                    resultset=statement.executeQuery(query);
                    while (resultset.next()){
                        actualPlayersId=resultset.getInt(1);
                    }
                } catch(Exception ex){
                    App.alertApp(Alert.AlertType.ERROR,"DataBase Error!", "DataBase Error!","There was a problem with our Database. Process aborted!");
                    App.setRoot("primary");
                }
                query = "SELECT * FROM players WHERE pick = "+actualPlayersId+";";
                try {
                    resultset = statement.executeQuery(query);
                    while (resultset.next()) {
                        playersFromDreamTeam.add(new Player(actualPlayersId, resultset.getString(2), resultset.getString(3),
                                resultset.getString(4), LocalDate.parse(resultset.getString(5)), resultset.getInt(6),
                                resultset.getInt(7), resultset.getString(8)));
                    }
                } catch (Exception ex) {
                    App.alertApp(Alert.AlertType.ERROR,"DataBase Error!", "DataBase Error!","There was a problem with our Database. Process aborted!");
                    App.setRoot("primary");
                }
            }
        }
        else{
            return null;
        }
        return playersFromDreamTeam;
    }

    @Override
    public void exchangePlayers(Team dreamTeam, Player in, Player out) throws IOException {
        int lastPlayer=playersInTheDreamTeam(dreamTeam);
        String query;
        int result=0;
        for(int i=0; i<lastPlayer; i++){
            query="SELECT 'Player"+(i+1)+"' FROM dreamteams WHERE 'Player"+(i+1)+"' = "+out.getPick()+";";
            try{
                resultset=statement.executeQuery(query);
                while(resultset.next()){
                   result=Integer.parseInt(resultset.getString(1));
                }
                if(result==out.getPick()){
                    query="UPDATE dreamteams SET 'Player"+(i+1)+"' "+in.getPick()+"WHERE 'Player"+(i+1)+" = "+out.getPick()+";";
                    try{
                        statement.executeQuery(query);
                    }catch (Exception ex){
                        App.alertApp(Alert.AlertType.ERROR,"DataBase Error!", "DataBase Error!","There was a problem with our Database. Process aborted!");
                        App.setRoot("primary");
                    }
                    break;
                }
            } catch (Exception ex){
                App.alertApp(Alert.AlertType.ERROR,"DataBase Error!", "DataBase Error!","There was a problem with our Database. Process aborted!");
                App.setRoot("primary");
            }
        }
    }

  /*  public void getData(String tableName){
        try {
          String query = "select * from "+tableName;
          resultset = statement.executeQuery(query);
            System.out.println("Records from database");
            if(tableName.compareToIgnoreCase("teams")==0) {
                while (resultset.next()) {
                    String name = resultset.getString("name");
                    String division = resultset.getString("division");
                    String owner = resultset.getString("owner");
                    System.out.println("name: " + name + "  " + "division: " + division + " " + "owner: " + owner);
                }
            }
            else if(tableName.compareToIgnoreCase("players")==0){
                while(resultset.next()) {
                    String pick = resultset.getString("Pick");
                    String name = resultset.getString("Name");
                    String college = resultset.getString("College");
                    System.out.println("name: " + name + "  " + "pick: " + pick + " " + "college: " + college);
                }
            }
        }catch (Exception ex){
            System.out.println("Error: "+ex);
        }
    }
*/
    // azért szedtem ezt ki mert nekünk ezekkel a getData függvényekkel vissza kell terjunk egy team vagy player listaval
    // abban az egy fugvenyben nem tudtuk volna mert nem lehet ket visszateresi erteke
    // ez a komment alatt levo ket fuggveny feltolt egy megfelelo tipusu listat amit majd vissza is ad

}
