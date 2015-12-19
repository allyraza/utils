
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBWrapper
{


    Connection connection= null;



    public void init() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root" , "admin");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public synchronized void persist(long id, String request) {

        try {
            Statement stmt = connection.createStatement();
            String s = "Hello World from facade";
            int i= 500;

            String sql = "INSERT INTO Request VALUES (" + (int)id + ",'" +  request + "')";
            //   String sql = "INSERT INTO Request VALUES (" + id +  ")";
            stmt.executeUpdate(sql);

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public void destroy() {

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {

        DBWrapper wrapper = new DBWrapper();

        wrapper.init();
        wrapper.persist(100, "Hello World");
        wrapper.destroy();


    }



}
