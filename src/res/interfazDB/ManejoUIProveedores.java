package res.interfazDB;

import java.sql.ResultSet;
import java.sql.SQLException;

import sqlsrc.ConnectionDB;

import res.Persona;

public class ManejoUIProveedores {
    private ConnectionDB conDB;
    
    public ManejoUIProveedores(){
        conDB = new ConnectionDB();
    }
    
    public int agregar(String nombre) throws SQLException{
        int id = getLastID()+1;
        
        String query = "INSERT INTO Proveedores VALUES (" + id + ", '" + nombre + "')";
        
        return conDB.send(query);
    }
    
    /*
        opcQuery una de las tres opciones de consulta
            Todos   1
            ID      2
            Nombre  3
    */
    public Persona[] consulta(Object queryType) throws SQLException{
        ResultSet rs;
        String query = "SELECT * FROM Proveedores";
        
        if(queryType instanceof Character){
            
        }else if(queryType instanceof String){
            query += " WHERE Nombre_PROV='" + queryType + "'";
        }else if(queryType instanceof Integer){
            query += " WHERE IDPROV=" + queryType;
        }
        rs = conDB.receive(query);
        
        while(rs.next()){
            
        }
        
        return null;
    }
    
    private int getLastID() throws SQLException{
        ResultSet rs;
        int id = 0;
        String query = "SELECT TOP 1 IDPROV FROM Proveedores ORDER BY IDPROV DESC";
        rs = conDB.receive(query);
        
        id = rs.getInt(1);
        
        System.out.println(id);
        return id;
        
    }
}
