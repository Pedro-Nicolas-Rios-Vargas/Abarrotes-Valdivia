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
    /**
     * Metodo para agregar una ventada detallada
     * @param idC ID del cliente
     * @param total Total de la venta
     * @return Regresa un nuemero entero que no recuerdo que es lo que hace xd
     * @throws SQLException 
     */
    public int agregar(int idC, float total) throws SQLException {
        int idv = getLastID() + 1;
        String query = "execute insert_VD " + idv + ", " + idC + ", " + ", " + 
                total;
        return conDB.send(query);
    }
    /**
     * Metodo para consultar las ventas detalladas con filtros
     * @param filtro filtro 1 = filtrar por ID de la venta <br> 2 = filtrar por fecha de venta <br> 3 = filtrar por ID del cliente 4 = filtrar por total de la venta. Cualquier otro numero busca sin ningun filtro
     * @param busqueda
     * @param dia
     * @param mes
     * @param year
     * @return Cola en la que contiene los datos de la busqueda 
     * @throws SQLException 
     */
    public ListaCola<Detallada> consultar(int filtro, String busqueda, int dia, int mes, int year) throws SQLException {
        ListaCola<Detallada> queue = new ListaCola<>();
        ResultSet rs;
        String query = "execute selectVDs";
        Detallada accion;
        switch (filtro) {
            case 0:
                break;
            case 1:
                try {
                    query = "execute selectVD " + Integer.parseInt(busqueda);
                } catch (NumberFormatException e) {
                    query = "execute selectVD " + 0;
                } 
                break;
            case 2:
                try {
                    query = "execute selectVD_Fecha '" + year + "-" + mes + "-" + dia + "'"; 
                } catch (NumberFormatException e) {
                    query = "execute selectVD_Fecha '1-1-1'";
                } 
                break;
            case 3:
                try {
                    query = "EXECUTE selectVD_IDCLIEN " + Integer.parseInt(busqueda);
                } catch (NumberFormatException e) {
                    query = "EXECUTE selectVD_IDCLIEN " + 0;
                } 
                break;
            case 4:
                try {
                    query = "EXECUTE selectVD_TotalVenta " + Float.valueOf(busqueda);
                } catch (NumberFormatException e) {
                    query = " EXECUTE selectVD_TotalVenta " + -1;
                }
                break;
            default:
                query = "execute selectVDs";
                break;
        }
        rs = conDB.receive(query);
        
        while (rs.next()) {
            accion = new Detallada(rs.getInt(1), rs.getInt(2), rs.getFloat(3),
                    rs.getDate(4));
            queue.push(accion);
        }
        return queue;
    }
    
    /**
     * Metodo para regresar el ID del ultimo Venta_Detallada que tiene la tabla de Ventas_Detalladas
     * @return El ID de la ultima venta_Detallada en la tabla Ventas_Detalladas
     * @throws SQLException 
     */
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
