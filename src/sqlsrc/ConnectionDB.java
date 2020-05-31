package sqlsrc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sqlsrc.interfaces.SQLConnectionInterface;

public class ConnectionDB implements SQLConnectionInterface{
    private final String URL = "jdbc:sqlserver://LAPTOP-VHMV4UK1:1433;databaseName=Abarrotes";
    private final String USER = "sa";
    private final String PWD = "12345";
    
    private Connection con;
    private Statement statement;
    
    public ConnectionDB(){
        connectDB();
    }
    
    public void connectDB(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            con = DriverManager.getConnection(URL, USER, PWD);
        }catch(ClassNotFoundException cnfE){
            System.out.println("No se a podido cargar el driver.\n" + cnfE.getMessage());
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
        }
    }
    public void send(String sqlUpdate) {
        
    }

    public ResultSet receive(String sqlQuery) {
        return null;
    }
    
    
}
