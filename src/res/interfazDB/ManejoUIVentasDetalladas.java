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
 * @author vival
 */
public class ManejoUIVentasDetalladas {
    private ConnectionDB conDB;
    
    public ManejoUIVentasDetalladas() {
        conDB = new ConnectionDB();
        
    }
    
    public int agregar(int idC, int dia, int mes, int year, float total) throws SQLException {
        int idv = getLastID() + 1;
        String query = "INSERT INTO Ventas_Detalladas VALUES (" + idv + ", " + idC + ", " +
                dia + ", " + mes + ", " + year + ", " + total + ")";
        return conDB.send(query);
    }
    
    public ListaCola<Detallada> consultar(int filtro, String busqueda, int dia, int mes, int year) throws SQLException {
        ListaCola<Detallada> queue = new ListaCola<>();
        ResultSet rs;
        String query = "SELECT * FROM Ventas_Detalladas";
        Detallada accion;
        switch (filtro) {
            case 0:
                break;
            case 1:
                try {
                    query += " WHERE IDV like '%" + Integer.parseInt(busqueda) + "%'";
                } catch (NumberFormatException e) {
                    query += " WHERE IDV= " + 0;
                } 
                break;
            case 2:
                try {
                    query += " WHERE diaV = " + dia + " and mesV = " + mes + "yearV = " + year;
                } catch (NumberFormatException e) {
                    query += " WHERE yearV =" + 0;
                } 
                break;
            case 3:
                try {
                    query += " WHERE IDCLIEN = " + Integer.parseInt(busqueda);
                } catch (NumberFormatException e) {
                    query += " WHERE IDCLIEN =" + 0;
                } 
                break;
            case 4:
                try {
                    query += " WHERE TotalV like '%" + Float.valueOf(busqueda) + "%'";
                } catch (NumberFormatException e) {
                    query += " WHERE TotalV=" + 0;
                }
                break;
            default:
                break;
        }
        rs = conDB.receive(query);
        
        while (rs.next()) {
            accion = new Detallada(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                    rs.getInt(4),rs.getInt(5), rs.getFloat(6));
            queue.push(accion);
        }
        return queue;
    }
    
    private int getLastID() throws SQLException {
        ResultSet rs;
        int id = 0;
        String query = "SELECT TOP 1 IDV FROM Ventas_Detalladas ORDER BY IDV DESC";
        rs = conDB.receive(query);
        while (rs.next()) {
            id = rs.getInt(1);
        }
        return id;
    }
}
