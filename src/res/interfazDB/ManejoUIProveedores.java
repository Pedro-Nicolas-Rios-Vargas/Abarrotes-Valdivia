package res.interfazDB;

import java.sql.ResultSet;
import java.sql.SQLException;

import sqlsrc.ConnectionDB;

import res.Proveedor;

import lista.ListaCola;

public class ManejoUIProveedores {
    private ConnectionDB conDB;
    
    public ManejoUIProveedores(){
        conDB = new ConnectionDB();
    }
    
    public int agregar(String nombre, int telefono) throws SQLException{
        int id = getLastID()+1;
        
        String query = String.format("execute insertProv %d, '%s', %d", id, nombre, (telefono != 0) ? telefono : null);
        
        return conDB.send(query);
    }
    
    public ListaCola<Proveedor> consulta(int queryType, Object queryData) throws SQLException{
        ListaCola<Proveedor> cola = new ListaCola<>();
        ResultSet rs;
        String query = "SELECT * FROM Proveedores ";
        Proveedor heman;
        
        if(queryType == 1){
            query += "ORDER BY IDPROV asc";
        }else if(queryType == 2){
            query += " WHERE Nombre_PROV='" + queryData + "'";
        }else if(queryType == 3){
            query += " WHERE IDPROV=" + queryData;
        }else if(queryType == 4) {
            query += " WHERE TELEFONO_PRO=" + queryData;
        }
        rs = conDB.receive(query);
        
        while(rs.next()){
            heman = new Proveedor(rs.getInt(1),rs.getString(2), rs.getString(3));
            cola.push(heman);
        }
        
        return cola;
    }
    
    public boolean modificar(int id, String nombre, int telefono) throws SQLException {
        int res = -1;
        String update = String.format("execute updateProv %d, '%s', %d", id, nombre, telefono);
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
