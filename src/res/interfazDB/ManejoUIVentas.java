
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
    /**
     * Metodo para agregar una venta
     * @param idprod ID del producto
     * @param cantidad Cantidad del producto a agregar
     * @param subtotalV Cantidad del subtotal de la venta
     * @return Un entero, pero no recuerdo cual xd
     * @throws SQLException 
     */
    public int agregar(int idprod, int cantidad, float subtotalV) throws SQLException {
        int idv = getLastID();
        String query = "execute addVenta " + idv + ", " + idprod + ", " +
                cantidad + ", " + subtotalV;
        return conDB.send(query);
    }
    /**
     * Metodo para consultar las ventas con o sin filtros
     * @param filtro 1 = filtrar por ID de la venta <br> 2 = filtrar por id del producto <br> 3 = filtrar por cantidad 4 = filtrar por subtotal de la venta. Cualquier otro numero busca sin ningun filtro
     * @param busqueda Palabra o numero clave con el que se desea buscar
     * @return Cola en la que contiene los datos de la busqueda
     * @throws SQLException 
     */
    public ListaCola<Accion> consultar(int filtro, String busqueda) throws SQLException {
        ListaCola<Accion> queue = new ListaCola<>();
        ResultSet rs;
        String query = "EXECUTE selectVentas";
        Accion accion;
        switch (filtro) {
            case 0:
                break;
            case 1:
                try {
                    query = "EXECUTE selectVenta " + Integer.parseInt(busqueda);
                } catch (NumberFormatException e) {
                    query = "EXECUTE selectVenta " + 0;
                } 
                break;
            case 2:
                try {
                    query = "EXECUTE selectVenta_Producto " + Integer.parseInt(busqueda);
                } catch (NumberFormatException e) {
                    query = "EXECUTE selectVenta_Producto " + 0;
                } 
                break;
            case 3:
                try {
                    query = "EXECUTE selectVenta_Cantidad " + Integer.parseInt(busqueda);
                } catch (NumberFormatException e) {
                    query = "EXECUTE selectVenta_Cantidad " + 0;
                } 
                break;
            case 4:
                try {
                    query = "EXECUTE selectVenta_SubtotalV " + Float.valueOf(busqueda);
                } catch (NumberFormatException e) {
                    query = "EXECUTE selectVenta_SubtotalV " + -1;
                }
                break;
            default:
                query = "EXECUTE selectVentas";
                break;
        }
        rs = conDB.receive(query);
        
        while (rs.next()) {
            accion = new Accion(rs.getInt(1), rs.getInt(2), rs.getInt(3),  rs.getFloat(4));
            queue.push(accion);
        }
        return queue;
    }
    /**
     * Metodo para regresar el ID del ultimo Venta que tiene la tabla de Ventas
     * @return El ID de la ultima venta en la tabla Ventas
     * @throws SQLException  
     */
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
