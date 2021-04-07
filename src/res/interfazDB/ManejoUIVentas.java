
package res.interfazDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import lista.ListaCola;
import res.Accion;
import sqlsrc.ConnectionDB;


public class ManejoUIVentas {
    private ConnectionDB conDB;
    public ManejoUIVentas() {
        conDB = new ConnectionDB();
        
    }
    public int agregar(int idprod, int cantidad, float subtotalV) throws SQLException {
        int idv = getLastID();
        String query = "INSERT INTO Ventas VALUES (" + idv + ", " + idprod + ", " +
                cantidad + ", " + subtotalV + ")";
        return conDB.send(query);
    }
    public ListaCola<Accion> consultar(int filtro, String busqueda) throws SQLException {
        ListaCola<Accion> queue = new ListaCola<>();
        ResultSet rs;
        String query = "SELECT * FROM Ventas";
        Accion accion;
        switch (filtro) {
            case 0:
                break;
            case 1:
                try {
                    query += " WHERE IDV = " + Integer.parseInt(busqueda);
                } catch (NumberFormatException e) {
                    query += " WHERE IDV= " + 0;
                } 
                break;
            case 2:
                try {
                    query += " WHERE IDPROD like '%" + Integer.parseInt(busqueda) + "%'";
                } catch (NumberFormatException e) {
                    query += " WHERE IDPROD=" + 0;
                } 
                break;
            case 3:
                try {
                    query += " WHERE Cantidad like '%" + Integer.parseInt(busqueda) + "%'";
                } catch (NumberFormatException e) {
                    query += " WHERE Cantidad=" + 0;
                } 
                break;
            case 4:
                try {
                    query += " WHERE SubtotalV like '%" + Float.valueOf(busqueda) + "%'";
                } catch (NumberFormatException e) {
                    query += " WHERE SubtotalV=" + 0;
                }
                break;
            default:
                break;
        }
        rs = conDB.receive(query);
        
        while (rs.next()) {
            accion = new Accion(rs.getInt(1), rs.getInt(2), rs.getInt(3),  rs.getFloat(4));
            queue.push(accion);
        }
        return queue;
    }
    
    private int getLastID() throws SQLException {
        ResultSet rs;
        int id = 0;
        String query = "SELECT TOP 1 IDV FROM Ventas_Detalladas ORDER BY IDV DESC";
        rs = conDB.receive(query);
        try {
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return id;
    }
}
