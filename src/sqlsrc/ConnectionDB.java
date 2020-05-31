package sqlsrc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sqlsrc.interfaces.SQLConnectionInterface;

public class ConnectionDB implements SQLConnectionInterface{
    private final String URL = "jdbc:sqlserver://VRVG-ASPIRE:1433;databaseName=Abarrotes";
    private final String USER = "sa";
    private final String PWD = "sa";
    
    private Connection con;
    private Statement statement;
    
    public ConnectionDB(){
        connectDB();
    }
    
    public void connectDB(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            con = DriverManager.getConnection(URL, USER, PWD);
            statement = con.createStatement();
        }catch(ClassNotFoundException cnfE){
            System.out.println("No se a podido cargar el driver.\n" + cnfE.getMessage());
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
        }
    }
    public void send(String sqlUpdate) {
        try {
            statement.executeUpdate(sqlUpdate);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ResultSet receive(String sqlQuery) {
        try {
            return statement.executeQuery(sqlQuery);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
