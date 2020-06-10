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
    public int send(String sqlUpdate) throws SQLException{

        return statement.executeUpdate(sqlUpdate);
        
            
    }

    public ResultSet receive(String sqlQuery) throws SQLException{
        
        return statement.executeQuery(sqlQuery);
        
    }
    
    public void closeConnection(){
        try{
            con.close();
        }catch(SQLException sqlE){
            System.out.println(sqlE.getMessage());
        }
    }
    

}
