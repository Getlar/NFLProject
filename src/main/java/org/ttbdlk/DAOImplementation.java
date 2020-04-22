package org.ttbdlk;
import javax.persistence.criteria.CriteriaBuilder;
import java.security.spec.ECField;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class DAOImplementation implements DAO{
    private Connection connection;
    private Statement statement;
    private ResultSet resultset;

    @Override
    public void DbConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nfl", "root", "");
            statement = connection.createStatement();
        }
        catch (Exception ex){
            System.out.println("Error: "+ex);
        }
    }

    @Override
    public ArrayList<Player> GetPlayersData() {
        ArrayList<Player> players = new ArrayList<>();
        try {
            String query = "select * from players";
            resultset = statement.executeQuery(query);
            System.out.println("Records from database");

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
            System.out.println("Error: " + ex);
        }
        return players;
    }

    @Override
    public ArrayList<Team> GetTeamsData() {
        ArrayList<Team> teams = new ArrayList<>();
        try {
            String query = "select * from teams";
            resultset = statement.executeQuery(query);
            System.out.println("Records from database");
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
                System.out.println("name: " + name + "  " + "division: " + division + " " + "owner: " + owner);

            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
        return teams;
    }

    @Override
    public void pushDataToTeams(Team team) {
        String name = team.getName();
        String division = team.getDivision();
        String owner = team.getOwner();
        String headCoach = team.getHeadCoach();
        try{
            String query = "insert into teams (name, division, HeadCoach, owner) values('"+name+"', '"+division+"', '"+headCoach+"', '"+owner+"');";
            statement.execute(query);
            System.out.println("kesz");
        } catch (Exception ex){
            System.out.println("Error: "+ex);
        }
    }

    @Override
    public void pushDataToPlayers(Player player) {
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
            System.out.println("Error: "+ex);
        }
    }

    public void updateDataInDreamTeams(Team newDreamTeam, Team oldDreamTeam) {
        try{
            String query = "UPDATE dreamteams SET Name = '"+newDreamTeam.getName()+"', Division = '"+newDreamTeam.getDivision()+
                    "', HeadCoach = '"+newDreamTeam.getHeadCoach()+"', Owner = '"+newDreamTeam.getOwner()+"' WHERE Name = '"+
                    oldDreamTeam.getName()+"';";
            statement.execute(query);
        } catch (Exception ex){
            System.out.println("Error: "+ex);
        }
    }

    public void deleteDreamTeam(String dreamTeamName) {
        try{
            String query = "DELETE FROM dreamteams WHERE name = '"+dreamTeamName+"';";
            statement.execute(query);
        }catch (Exception ex){
            System.out.println("Error: "+ex);
        }
    }

    @Override
    public void pushDataToDreamTeams(Team newDreamTeam) {
        try {
            String query = "INSERT INTO dreamteams (Name, Division, HeadCoach, Owner) VALUES('" + newDreamTeam.getName() + "', '" + newDreamTeam.getHeadCoach() + "', " +
                    "'" + newDreamTeam.getDivision() + "', '" + newDreamTeam.getOwner() + "');";
            statement.execute(query);
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }

    @Override
    public void pushPlayerToDreamTeam(Team dreamTeam, Player player){
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
            System.out.println("Error: "+ex);
        }
    }

    @Override
    public int playersInTheDreamTeam(Team dreamTeam){
        int playersSum=0;
        try{
            String query="SELECT LastPlayer FROM dreamteams WHERE Name = '"+dreamTeam.getName()+"';";
            resultset=statement.executeQuery(query);
            while(resultset.next()){
                playersSum=resultset.getInt(1);
            }
        }catch (Exception ex){
            System.out.println("Error: "+ex);
        }
        return playersSum;
    }

    @Override
    public ArrayList<Team> getDreamTeams(){
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
            System.out.println("Error: " +ex);
        }
        return dreamTeams;
    }

    @Override
    public ArrayList<Player> getPlayersFromDreamTeam(Team dreamTeam){
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
                    System.out.println("Error: "+ex);
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
                    System.out.println("Error: " + ex);
                }
            }
        }
        else{
            return null;
        }
        return playersFromDreamTeam;
    }

    @Override
    public void exchangePlayers(Team dreamTeam, Player in, Player out){
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
                        System.out.println("Error: "+ex);
                    }
                    break;
                }
            } catch (Exception ex){
                System.out.println("Error: "+ex);
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
