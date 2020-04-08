package org.ttbdlk;
import java.sql.*;

public class DbConnect {
    private Connection connection;
    private Statement statment;
    private ResultSet resultset;

    public DbConnect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nfl", "root", "");
            statment = connection.createStatement();

        }catch (Exception ex){
            System.out.println("Error: "+ex);
        }
    }
    public void getData(){
        try {
          String query = "select * from csapatok";
          resultset = statment.executeQuery(query);
            System.out.println("Records from database");
            while(resultset.next()){
                String name = resultset.getString("name");
                String age = resultset.getString("age");
                System.out.println("name: " + name+ "  "+ "Age: "+age);
            }
        }catch (Exception ex){
            System.out.println("Error: "+ex);
        }
    }

    public void pushData(Team csapat){
        int id = csapat.getId();
        String name = csapat.getName();
        String age = csapat.getAge();
        try{
            String query = "insert into csapatok (id, name, age) values("+id +", '"+ name+"', '"+age+"');";
            //String query =" insert into csapatok (name, age)"+" values ('"+name+"', '"+age+"')";
            statment.execute(query);
        } catch (Exception ex){
            System.out.println("Error: "+ex);
    }
    }

    public void deleteData(int id){

        try{
            String query = "delete from csapatok where id="+id;
            statment.execute(query);
        }catch (Exception ex){
            System.out.println("Error: "+ex);
        }
    }
}
