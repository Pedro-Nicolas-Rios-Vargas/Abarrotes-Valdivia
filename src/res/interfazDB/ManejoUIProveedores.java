package res.interfazDB;

import java.sql.ResultSet;
import java.sql.SQLException;

import sqlsrc.ConnectionDB;

import res.Persona;

import lista.ListaCola;

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
    
    public ListaCola<Persona> consulta(Object queryType) throws SQLException{
        ListaCola<Persona> cola = new ListaCola<>();
        ResultSet rs;
        String query = "SELECT * FROM Proveedores ";
        Persona heman;
        
        if(queryType instanceof Character){
            query += "ORDER BY IDPROV asc";
        }else if(queryType instanceof String){
            query += " WHERE Nombre_PROV='" + queryType + "'";
        }else if(queryType instanceof Integer){
            query += " WHERE IDPROV=" + queryType;
        }
        rs = conDB.receive(query);
        
        while(rs.next()){
            heman = new Persona(rs.getInt(1),rs.getString(2));
            cola.push(heman);
        }
        
        return cola;
    }
    
    public boolean modificar(int id, String nombre) throws SQLException {
        int res = -1;
        String update = "UPDATE Proveedores SET Nombre_PROV='" + nombre + "'"
                + " WHERE IDPROV=" + id;
        res = conDB.send(update);
        return res != -1;
    }
    
    public boolean eliminar(Object deleteType) throws SQLException {
        int res = -1;
        String delete = "DELETE FROM Proveedores WHERE ";
        if(deleteType instanceof Integer){
            delete += "IDPROV=" + deleteType;
        }else if(deleteType instanceof String){
            delete += "Nombre_PROV='" + deleteType + "'";
        }
        
        res = conDB.send(delete);
        return res != -1;
    }
    
    
    private int getLastID() throws SQLException{
        ResultSet rs;
        int id = 0;
        String query = "SELECT TOP 1 IDPROV FROM Proveedores ORDER BY IDPROV DESC";
        rs = conDB.receive(query);
        if(rs.next())
            id = rs.getInt(1);
        
        return id;
        
    }
    
    public void closeConnection(){
        conDB.closeConnection();
    }
}
