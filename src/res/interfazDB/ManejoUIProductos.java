
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
    /**
     * Metodo para agregar un producto 
     * @param nombre_Prod Nombre del producto
     * @param existencia Existencia del producto
     * @param stock Stock del producto
     * @param precio Precio del producto
     * @param UM Unidad de medida del producto
     * @return Regresa un entero que no recuerdo que hace xd
     * @throws SQLException 
     */
    public int agregar(String nombre_Prod, int existencia, int stock, float precio, String UM) throws SQLException{
        int iDPROD = getLastID() + 1;
        String query = "execute addProduct " + iDPROD + ", '" + nombre_Prod + "', "
                + precio + ", " + stock + ", " + existencia + ", '" + UM + "'" ;
        return conDB.send(query);
    }
    /**
     * Se usa para consultar productos con filtros
     * @param filtro 1 = ID <br> 2 = Nombre <br> 3 = Precio <br> 4 = Existencia
     * @param busqueda
     * @return regresa una cola de tipo Producto 
     * @throws SQLException 
     */
    public ListaCola<Producto> consulta(int filtro, String busqueda) throws SQLException{
        ListaCola<Producto> queue = new ListaCola<>();
        ResultSet rs;
        String query;
        Producto producto;
        switch (filtro) {
            case 1:
                try {
                    query = "execute selectProduc " + Integer.parseInt(busqueda);
                } catch (NumberFormatException e) {
                    query = "execute selectProduc " + 0;
                }   
                break;
            case 2:
                query = "execute selectProductNombre '" + busqueda + "'";
                break;
            case 3:
                try {
                    query = "execute selectProductPrecio " + Float.valueOf(busqueda);
                } catch (NumberFormatException e) {
                    query = "execute selectProductPrecio " + -1;
                }
                break;
            case 4:
                try {
                    query = "execute selectProductExistencia " + Integer.parseInt(busqueda);
                } catch (NumberFormatException e) {
                    query = "execute selectProductExistencia " + -1;
                }
                break;
            default:
                query = "execute selectProducs";
                break;
        }
        rs = conDB.receive(query);
            
        while (rs.next()) {
            producto = new Producto(rs.getInt(1), rs.getString(2), rs.getInt(5),
                    rs.getInt(4), rs.getFloat(3), rs.getString(6));
            queue.push(producto);
            
        }
        return queue;
    }
    /**
     *  Metodo que se utiliza para Modificar un producto ya agregado
     * @param idprod ID del producto a modificar
     * @param nombre_Prod Nombre del producto a modificar
     * @param existencia Existencia del producto a modificar
     * @param stock Sctock del producto a modificar
     * @param precio Precio del producto a modificar
     * @param um Unidad de medida del producto a modificar
     * @return Regrasa diferente de -1 si la modificacion fue realizada, falso en caso contrario No se como funciona Victor 07/04/2021
     * @throws SQLException 
     */
    public boolean modificar(int idprod, String nombre_Prod, int existencia, int stock, float precio, String um) throws SQLException{
        int res = -1;
        String query = "execute updateProduct " + idprod + ", '" + nombre_Prod 
                + "', " + existencia + ", " + stock + ", " + existencia + ", '"
                + um + "'";
        conDB.send(query);
        return (res != -1);
    }
    /**
     * 
     * @param idprod Id del producto a eliminar
     * @return Regrasa diferente de -1 si la eliminacion fue realizada, falso en caso contrario No se como funciona Victor 07/04/2021
     * @throws SQLException 
     */
    public boolean eliminar(int idprod) throws SQLException{
        int res = -1;
        conDB.send("execute deleteProduct " + idprod);
        return (res != -1);
    }
    /**
     * Metodo especial para actualizar la existencia de un producto despues de su venta
     * @param idprod ID del producto a actualizar
     * @param existencia Cantidad que fue vendida del producto
     * @return Un booleano que no se para que sirve
     * @throws SQLException 
     */
    public boolean acutalizarExistencia(int idprod, int existencia) throws SQLException{
        int res = -1;
        conDB.send("execute updateProductExistencia " + idprod + "," + existencia);
        return (res != -1);
    }
    
    /**
     * Metodo para regresar el ID del ultimo Producto que tiene la tabla de Productos
     * @return El ID del ultimo producto en la tabla Productos
     * @throws SQLException 
     */
    private int getLastID() throws SQLException{
        ResultSet rs;
        int id = 0;
        String query = "execute getLastIDProduct";
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
