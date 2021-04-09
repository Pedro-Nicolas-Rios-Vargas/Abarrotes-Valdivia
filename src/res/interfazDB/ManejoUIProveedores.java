package res.interfazDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import sqlsrc.ConnectionDB;
import res.Proveedor;
import lista.ListaCola;

public class ManejoUIProveedores {
    private final ConnectionDB conDB;
    
    public ManejoUIProveedores(){
        conDB = new ConnectionDB();
    }

    /**
     * Permite agregar una nuevo proveedor a la base de datos.
     * @param nombre El nombre del proveedor.
     * @param telefono El teléfono del proveedor.
     * @return Retorna cualquier número.
     * @throws SQLException Si la conexión a la base de datos o algún dato enviado no coincide.
     */
    public int agregar(String nombre, int telefono) throws SQLException{
        int id = getLastID()+1;
        
        String query = String.format("execute insertProv %d, '%s', %d", id, nombre, (telefono != 0) ? telefono : null);
        
        return conDB.send(query);
    }

    /**
     * Permite realizar consultas con diferentes tipos de datos.
     *
     * @param queryType Es el tipo de dato con el que se hará la consulta:
     *<ul>
     *  <li>1 - Consultará todos los Proveedores</li>
     *  <li>2 - Consultará por medio del nombre del proveedor</li>
     *  <li>3 - Consultará por medio del id del proveedor.</li>
     *  <li>4 - Consultará por medio del teléfono del proveedor.</li>
     *</ul>
     * @param queryData Es el dato con el que se realizará la consulta.
     * @return Retorna una lista con todos los proveedores que encajan con los datos consultados.
     * @throws SQLException Si la conexión a la base de datos o algún dato enviado no coincide.
     */
    public ListaCola<Proveedor> consulta(int queryType, Object queryData) throws SQLException{
        ListaCola<Proveedor> cola = new ListaCola<>();
        ResultSet rs;
        String query = "";
        Proveedor heman;
        
        if(queryType == 1){
            query = "execute selectProvs";
        }else if(queryType == 2){
            query = String.format("execute selectProvByName '%s'", queryData);
        }else if(queryType == 3){
            int id = (int) queryData;
            query = String.format("execute selectProvById %d", id);
        }else if(queryType == 4) {
            int tel = (int) queryData;
            query = String.format("execute selectProvByTel %d", tel);
        }
        rs = conDB.receive(query);
        
        while(rs.next()){
            heman = new Proveedor(rs.getInt(1),rs.getString(2), rs.getString(3));
            cola.push(heman);
        }
        
        return cola;
    }

    /**
     * Permite modificar el proveedor que encaja con el id dado.
     * @param id Id del proveedor.
     * @param nombre Nombre del proveedor.
     * @param telefono Teléfono del proveedor.
     * @return true si la modificación fue realizada con éxito. False nunca ocurre.
     * @throws SQLException Si la conexión a la base de datos o algún dato enviado no coincide.
     */
    public boolean modificar(int id, String nombre, int telefono) throws SQLException {
        int res;
        String update = String.format("execute updateProv %d, '%s', %d", id, nombre, (telefono != 0) ? telefono : null);
        res = conDB.send(update);
        return res != -1;
    }

    /**
     * Permite eliminar al proveedor que encaja con el id o nombre dado.
     * @param deleteType Es el tipo de dato con el cual se identificará al proveedor para ser eliminado.
     * @return true si la modificación fue realizada con éxito. False nunca ocurre.
     * @throws SQLException Si la conexión a la base de datos o algún dato enviado no coincide.
     */
    public boolean eliminar(Object deleteType) throws SQLException {
        int res;
        String delete;
        if(deleteType instanceof Integer) {
            delete = String.format("execute deleteProvById %d", deleteType);
        } else {
            // Unicamente se puede tener dos tipos de datos: Integer y String,
            // por ende no se define el instanceof de String
            delete = String.format("execute deleteProvByName '%s'", deleteType);
        }
        
        res = conDB.send(delete);
        return res != -1;
    }

    /**
     * Brinda la id del úiltimo proveedor ingresado.
     * @return La id del último proveedor ingresado.
     * @throws SQLException Si la conexión a la base de datos o algun dato enviado no coincide.
     */
    private int getLastID() throws SQLException{
        ResultSet rs;
        int id = 0;
        String query = "execute selectProvTOP";
        rs = conDB.receive(query);
        if(rs.next())
            id = rs.getInt(1);
        
        return id;
        
    }

    /**
     * Permite cerrar de forma segura el canal de comunicación con la base de datos.
     */
    public void closeConnection(){
        conDB.closeConnection();
    }
}
