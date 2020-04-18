package org.ttbdlk;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
                System.out.println("itt jarok");
                String name =resultset.getString("Name");
                String division = resultset.getString("College");
                LocalDate owner = LocalDate.parse(resultset.getString("DateOfBirth"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                System.out.println("name: " + name + "  " + "division: " + division + " " + "owner: " + owner);

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
        try{
            String query = "insert into teams (name, division, owner) values('"+name+"', '"+division+"', '"+owner+"');";
            statement.execute(query);
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

    @Override
    public void updateDataInTeams(Team team) {
        String name = team.getName();
        String division = team.getDivision();
        String owner = team.getOwner();
        try{
            String query = "update teams set HeadCoach = '"+name+"' where name = '"+team.getName()+"';";
            statement.execute(query);
        } catch (Exception ex){
            System.out.println("Error: "+ex);
        }
    }

    @Override
    public void deleteData(int name) {
        try{
            String query = "delete from teams where name="+name;
            statement.execute(query);
        }catch (Exception ex){
            System.out.println("Error: "+ex);
        }
    }
    @Override
    public void createTable(){//valamiért nem működött
        String query = "CREATE TABLE Teams (name VARCHAR(25) PRIMARY KEY, division varchar(10) NOT NULL, owner varchar(40) NOT NULL);";
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
