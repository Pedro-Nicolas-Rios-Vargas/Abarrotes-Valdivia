
package res.InterfazDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import sqlsrc.ConnectionDB;

public class ManejoUIProductos {
    private ConnectionDB conDB;
    
    public ManejoUIProductos() {
        conDB = new ConnectionDB();
        
    }
    public void agregar(String nombre_Prod, int existencia, int stock, float precio, String UM) {
        int iDPROD = getLastID() + 1;
        String query = "INSERT INTO Productor VALUES (" + iDPROD + ", '" + nombre_Prod + "', "
                + existencia + ", " + stock + ", " + precio + ", '" + UM + "')" ;
        conDB.send(query);
    }
    
    private int getLastID() {
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
