package org.ttbdlk;
import java.sql.*;

public class DbConnect {
    private Connection connection;
    private Statement statement;
    private ResultSet resultset;

    public DbConnect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nfl", "root", "");
            statement = connection.createStatement();
        }
        catch (Exception ex){
            System.out.println("Error: "+ex);
        }
    }
    public void getData(String tableName){
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

    public void pushDataToTeams(Team team){//without badge
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

    public void pushDataToPlayers(Player player){//without picture
        int pick=player.getPick();
        String name=player.getName();
        String college= player.getCollege();
        String position=player.getPosition();
        Date dateOfBirth=player.getDateOfBirth();
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

    public void updateDataInTeams(Team team){ //csak egy függvény, ami updatel egy egész rekordot (egy csapat összes mezőjét akár, de most csak a nevét, mert elírtam egyet)
        String name = team.getName();
        String division = team.getDivision();
        String owner = team.getOwner();
        try{
            String query = "update teams set name = '"+name+"' where name = 'Green Byy Packers';";
            statement.execute(query);
        } catch (Exception ex){
            System.out.println("Error: "+ex);
        }
    }

    public void deleteData(int name){
        try{
            String query = "delete from teams where name="+name;
            statement.execute(query);
        }catch (Exception ex){
            System.out.println("Error: "+ex);
        }
    }

    public void createTable(){//valamiért nem működött
        String query = "CREATE TABLE Teams (name VARCHAR(25) PRIMARY KEY, division varchar(10) NOT NULL, owner varchar(40) NOT NULL);";
    }
}
