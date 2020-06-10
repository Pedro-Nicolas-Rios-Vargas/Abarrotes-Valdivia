
package res.interfazDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import lista.ListaCola;
import sqlsrc.ConnectionDB;
import res.Producto;

public class ManejoUIProductos {
    private ConnectionDB conDB;
    
    public ManejoUIProductos() {
        conDB = new ConnectionDB();
        
    }
    public int agregar(String nombre_Prod, int existencia, int stock, float precio, String UM) throws SQLException{
        int iDPROD = getLastID() + 1;
        String query = "INSERT INTO Productos VALUES (" + iDPROD + ", '" + nombre_Prod + "', "
                + existencia + ", " + stock + ", " + precio + ", '" + UM + "')" ;
        return conDB.send(query);
    }
    /**
     * Se usa para consultar productos con filtros
     * @param filtro
     * @param busqueda
     * @return regresa una cola de tipo Producto 
     * @throws SQLException 
     */
    public ListaCola<Producto> consulta(int filtro, String busqueda) throws SQLException{
        ListaCola<Producto> queue = new ListaCola<>();
        ResultSet rs;
        String query = "SELECT * FROM Productos";
        Producto producto;
        switch (filtro) {
            case 1:
                try {
                    query += " WHERE IDPROD like '%" + Integer.parseInt(busqueda) + "%'";
                } catch (NumberFormatException e) {
                    query += " WHERE IDPROD=" + 0;
                }   
                break;
            case 2:
                query += " WHERE Nombre_Prod like '%" + busqueda + "%'";
                break;
            case 3:
                try {
                    query += " WHERE Precio like '%" + Float.valueOf(busqueda) + "%'";
                } catch (NumberFormatException e) {
                    query += " WHERE Precio=" + 0;
                }
                break;
            case 4:
                try {
                    query += " WHERE Existencia like '%" + Integer.parseInt(busqueda) + "%'";
                } catch (NumberFormatException e) {
                    query += " WHERE Existencia=" + 0;
                }
                break;
            default:
                break;
        }
        rs = conDB.receive(query);
            
        while (rs.next()) {
            producto = new Producto(rs.getInt(1), rs.getString(2), rs.getInt(3),
                    rs.getInt(4), rs.getFloat(5), rs.getString(6));
            queue.push(producto);
            
        }
        return queue;
    }
    /**
     * 
     * @param idprod
     * @param nombre_Prod
     * @param existencia
     * @param stock
     * @param precio
     * @param um
     * @return Regrasa diferente de -1 si la modificacion fue realizada, falso en caso contrario
     * @throws SQLException 
     */
    public boolean modificar(int idprod, String nombre_Prod, int existencia, int stock, float precio, String um) throws SQLException{
        int res = -1;
        String query = "UPDATE Productos set " + " Nombre_Prod = '" + nombre_Prod + "', " + 
                "Existencia = " + existencia + ", " + "Stock = " + stock + ", " + "Precio = " + precio + ", " + "UM = '" + um +"'"
                + "WHERE IDPROD = " + idprod;
        conDB.send(query);
        return (res != -1);
    }
    /**
     * 
     * @param idprod
     * @return Regrasa diferente de -1 si la eliminacion fue realizada, falso en caso contrario 
     * @throws SQLException 
     */
    public boolean eliminar(int idprod) throws SQLException{
        int res = -1;
        conDB.send("DELETE FROM Productos WHERE IDPROD = " + idprod);
        return (res != -1);
    }
    
    private int getLastID() throws SQLException{
        ResultSet rs;
        int id = 0;
        String query = "SELECT TOP 1 IDPROD FROM Productos ORDER BY IDPROD DESC";
        rs = conDB.receive(query);
        try {
            while (rs.next()) {
            id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }
}
