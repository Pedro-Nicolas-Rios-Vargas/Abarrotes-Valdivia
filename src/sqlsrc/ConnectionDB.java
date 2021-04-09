package sqlsrc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


import sqlsrc.interfaces.SQLConnectionInterface;
/**
 * La clase ConnectionDB permite manejar la conexion entre el programa y la base
 * de datos incluyendo la entrada y salida de datos.
 */
public class ConnectionDB implements SQLConnectionInterface{
    private final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Abarrotes_ValdiviaOLD";
    private final String USER = "sa";
    private final String PWD = "sa";
    
    private Connection con;
    private Statement statement;
    
    public ConnectionDB(){
        connectDB();
    }
    /**
     * El metodo connectDB carga el driver de sql server y establece la conexion
     * entre la base de datos y el programa.
     */
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
    
    /**
     * El metodo <b>send</b> es el encargado de enviar comandos INSERT, UPDATE, o
     * DELETE a la base de datos. Este metodo recibe la consulta en forma de
     * String delegando la configuracion de la misma a la clase que vaya a 
     * consultar la base de datos.
     * 
     * @param sqlUpdate Recibe la consulta a realizarse en la base de datos.
     * 
     * @return  Cualquier numero cuando la actualizacion se realizo con exito si
     *          no, posiblemente lanzara una SQLException
     * 
     * @throws  SQLException    Si la conexion a la base de datos no se pudo
     *                          realizar o posiblemente si no se pudo realizar
     *                          la actualizacion.
     * 
     */
    public int send(String sqlUpdate) throws SQLException{
        
        return statement.executeUpdate(sqlUpdate);
        
            
    }

    /**
     * El metodo <b>receive</b> se encarga de realizar las consultas de tipo
     * SELECT a la base de datos. Este metodo recibe la consulta en forma de 
     * String delegando la configuracion de la misma a la clase que vaya a 
     * consultar la base de datos.
     * 
     * @param sqlQuery  Recibe la consulta a realizarse en la base de datos.
     * 
     * @return  Retorna un objeto de tipo ResultSet de la consulta realizada
     *          este debera ser tratado por la clase que vaya a utilizar este
     *          metodo.
     * 
     * @throws SQLException Si la conexion a la base de datos no se pudo
     *                      realizar o posiblemente si la consulta no se pudo
     *                      realizar.
     */
    public ResultSet receive(String sqlQuery) throws SQLException{
        
        return statement.executeQuery(sqlQuery);
        
    }
    
    
    /**
     * El metodo <b>closeConnection</b> se debe usar al final de cada consulta
     * para cerrar el canal a la base de datos una vez que se realizaron
     * las operaciones necesarias.
     */
    public void closeConnection(){
        try{
            con.close();
        }catch(SQLException sqlE){
            System.out.println(sqlE.getMessage());
        }
    }
    

}
