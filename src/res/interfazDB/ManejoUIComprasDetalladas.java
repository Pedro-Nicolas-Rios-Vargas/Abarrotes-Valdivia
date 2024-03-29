/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package res.interfazDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import lista.ListaCola;
import res.Detallada;
import sqlsrc.ConnectionDB;

/**
 *
 * @author MrLui
 */
public class ManejoUIComprasDetalladas {
    private ConnectionDB conDB;
    
    public Detallada compras;
    ListaCola<Detallada> queue = new ListaCola<>();
    
    public ManejoUIComprasDetalladas() {
        conDB = new ConnectionDB();
        
    }
    
    public int conProvID(String nombre) throws SQLException{
        int idP = 0;
        ResultSet rs;
        String busquedaAux = "'"+nombre+"'";
        String query = " execute CDprovID "+busquedaAux;
        rs = conDB.receive(query);
        while(rs.next()){
            idP = rs.getInt(1);
        }   
        return idP;
    }
    
    public int agregar(int idP, float total) throws SQLException {
        int idc = getLastID() + 1;
        String query = "execute insert_CD " + idc + ", " + idP + ", " + total;
        return conDB.send(query);
    }
    
    private int getLastID() throws SQLException {
        ResultSet rs;
        int id = 0;
        String query = "execute getLastIDCs";
        rs = conDB.receive(query);
        while (rs.next()) {
            id = rs.getInt(1);
        }
        return id;
    }
    
    public ListaCola<Detallada> consulta() throws SQLException{
        ResultSet rs;
        String query="execute selectCDs";
        rs = conDB.receive(query);
        while(rs.next()){
            compras = new Detallada(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getFloat(4));
            queue.push(compras);
        }
        return queue;
    }
    
}
