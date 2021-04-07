/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package res.interfazDB;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import sqlsrc.ConnectionDB;
import lista.ListaCola;
import res.Persona;
import res.Producto;
/**
 *
 * @author MrLui
 */
public class ManejoUICompras {
    private ConnectionDB conDB;
    //ArrayList<Object> resultadoQuery = new ArrayList<>();
    public ManejoUICompras(){
        conDB = new ConnectionDB();
    }
    
    public ListaCola<Producto> consulta(int filtro, String busqueda) throws SQLException{
        ListaCola<Producto> queue = new ListaCola<>();
        ResultSet rs;
        String query="SELECT * FROM Productos";
        Producto producto;

        switch (filtro) {
            case 1:
                    //HOAL
                break;
            case 2:
                try {
                    query += " ORDER BY IDPROD ASC";
                } catch (NumberFormatException e) {
                    query += " WHERE IDPROD=" + 0;
                }   
                break;
            case 3:
                query += " WHERE Nombre_Prod like '%" + busqueda + "%'";
                break;
            case 4:
                try {
                    query += " ORDER BY PRECIO ASC";
                } catch (NumberFormatException e) {
                    query += " WHERE Precio=" + 0;
                }
                break;
            case 5:
                try {
                    query += " ORDER BY EXISTENCIA ASC";
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
    
    public ListaCola<Persona> consultaProv() throws SQLException{
        ListaCola<Persona> queue = new ListaCola<>();
        ResultSet rs;
        String query="SELECT * FROM Proveedores ORDER BY IDPROV ASC";
        Persona proveedor;
     
        rs = conDB.receive(query);

        while (rs.next()) {
            proveedor = new Persona(rs.getInt(1), rs.getString(2));
            queue.push(proveedor);
        }
        return queue;
    }
    
    public int agregar(int idprod, int cantidad, float subtotalV) throws SQLException {
        int idc = getLastID();
        String query = "INSERT INTO Compras VALUES (" + idc + ", " + idprod + ", " +
                cantidad + ", " + subtotalV + ")";
        return conDB.send(query);
    }
    
    private int getLastID() throws SQLException {
        ResultSet rs;
        int id = 0;
        String query = "SELECT TOP 1 IDCOM FROM Compras_Detalladas ORDER BY IDCOM DESC";
        rs = conDB.receive(query);
        while (rs.next()) {
            id = rs.getInt(1);
        }
        return id;
    }
    
    public ListaCola<Producto> consultaPorProv(String busqueda) throws SQLException{
        ListaCola<Producto> queue = new ListaCola<>();
        Set<String> idproductos = new LinkedHashSet<>();
        ResultSet rs, rn, rp, rf, rt, rd;
        String query="select IDPROV from Proveedores where Nombre_PROV like ("+"'"+busqueda+"'"+")";
        String query1="";
        String query2="";
        String query3="";
        String query4="";
        Producto producto;
        int idp=0, i=0;
        int idprod;
        
        rs = conDB.receive(query);
        while (rs.next()) {
            idp = rs.getInt(1);
        }
        
        query1="select idprov from Compras_Detalladas where IDPROV = "+idp;
        rt = conDB.receive(query1);
        if (rt.next()) {
            //HOAL
        }else{
            idp = 0;
        }
        
        if (idp==0) {
            query2="select IDPROD from Compras, Compras_Detalladas where compras.IDCOM = Compras_Detalladas.idcom";
            rp = conDB.receive(query2);
            while (rp.next()) {
                idprod = rp.getInt(1);
                idproductos.add(String.valueOf(idprod));
            }
            String strList = String.join(",", idproductos);
            if (idproductos.isEmpty()) {
                query3="select * from productos";
                rd = conDB.receive(query3);
                while(rd.next()){
                        producto = new Producto(rd.getInt(1), rd.getString(2), rd.getInt(3),
                                rd.getInt(4), rd.getFloat(5), rd.getString(6));
                        queue.push(producto);
                }
            }else{
                query3="select * from productos where idprod not in ("+strList+")";
                rd = conDB.receive(query3);
                while(rd.next()){
                        producto = new Producto(rd.getInt(1), rd.getString(2), rd.getInt(3),
                                rd.getInt(4), rd.getFloat(5), rd.getString(6));
                        queue.push(producto);
                }
            }
        }else{
            query3="select IDPROD from Compras, Compras_Detalladas where compras.IDCOM = Compras_Detalladas.idcom and IDPROV = "+idp;
            rn = conDB.receive(query3);
            while(rn.next()){
                idprod = rn.getInt(1);
                idproductos.add(String.valueOf(idprod));
            }
            

            String strList = String.join(",", idproductos);
               query4="SELECT * FROM PRODUCTOS WHERE IDPROD IN "+"("+strList+")";
                rf = conDB.receive(query4);
                while(rf.next()){
                    producto = new Producto(rf.getInt(1), rf.getString(2), rf.getInt(3),
                            rf.getInt(4), rf.getFloat(5), rf.getString(6));
                    queue.push(producto);
                } 
        }
        return queue;
    }
    
        public ListaCola<Producto> consultaPorProvRDB(int filtro, String busqueda) throws SQLException{
        ListaCola<Producto> queue = new ListaCola<>();
        Set<String> idproductos = new LinkedHashSet<>();
        ResultSet rs, rn, rp, rf, rt, rd;
        String query="select IDPROV from Proveedores where Nombre_PROV like ("+"'"+busqueda+"'"+")";
        String query1="";
        String query2="";
        String query3="";
        String query4="";
        Producto producto;
        int idp=0, i=0;
        int idprod;
        
        switch (filtro){
            case 2:
               rs = conDB.receive(query);
                while (rs.next()) {
                    idp = rs.getInt(1);
                }

                query1="select idprov from Compras_Detalladas where IDPROV = "+idp;
                rt = conDB.receive(query1);
                if (rt.next()) {
                    //HOAL
                }else{
                    idp = 0;
                }

                if (idp==0) {
                    query2="select IDPROD from Compras, Compras_Detalladas where compras.IDCOM = Compras_Detalladas.idcom";
                    rp = conDB.receive(query2);
                    while (rp.next()) {
                        idprod = rp.getInt(1);
                        idproductos.add(String.valueOf(idprod));
                    }
                    String strList = String.join(",", idproductos);
                    if (idproductos.isEmpty()) {
                        query3="select * from productos";
                        rd = conDB.receive(query3);
                        while(rd.next()){
                                producto = new Producto(rd.getInt(1), rd.getString(2), rd.getInt(3),
                                        rd.getInt(4), rd.getFloat(5), rd.getString(6));
                                queue.push(producto);
                        }
                    }else{
                        query3="select * from productos where idprod not in ("+strList+")";
                        rd = conDB.receive(query3);
                        while(rd.next()){
                                producto = new Producto(rd.getInt(1), rd.getString(2), rd.getInt(3),
                                        rd.getInt(4), rd.getFloat(5), rd.getString(6));
                                queue.push(producto);
                        }
                    }
                }else{
                    query3="select IDPROD from Compras, Compras_Detalladas where compras.IDCOM = Compras_Detalladas.idcom and IDPROV = "+idp;
                    rn = conDB.receive(query3);
                    while(rn.next()){
                        idprod = rn.getInt(1);
                        idproductos.add(String.valueOf(idprod));
                    }


                    String strList = String.join(",", idproductos);
                       query4="SELECT * FROM PRODUCTOS WHERE IDPROD IN "+"("+strList+") ";
                        rf = conDB.receive(query4);
                        while(rf.next()){
                            producto = new Producto(rf.getInt(1), rf.getString(2), rf.getInt(3),
                                    rf.getInt(4), rf.getFloat(5), rf.getString(6));
                            queue.push(producto);
                        } 
                } 
            break;
            case 4:
                rs = conDB.receive(query);
                while (rs.next()) {
                    idp = rs.getInt(1);
                }

                query1="select idprov from Compras_Detalladas where IDPROV = "+idp;
                rt = conDB.receive(query1);
                if (rt.next()) {
                    //HOAL
                }else{
                    idp = 0;
                }

                if (idp==0) {
                    query2="select IDPROD from Compras, Compras_Detalladas where compras.IDCOM = Compras_Detalladas.idcom";
                    rp = conDB.receive(query2);
                    while (rp.next()) {
                        idprod = rp.getInt(1);
                        idproductos.add(String.valueOf(idprod));
                    }
                    String strList = String.join(",", idproductos);
                    if (idproductos.isEmpty()) {
                        query3="select * from productos";
                        rd = conDB.receive(query3);
                        while(rd.next()){
                                producto = new Producto(rd.getInt(1), rd.getString(2), rd.getInt(3),
                                        rd.getInt(4), rd.getFloat(5), rd.getString(6));
                                queue.push(producto);
                        }
                    }else{
                        query3="select * from productos where idprod not in ("+strList+")";
                        rd = conDB.receive(query3);
                        while(rd.next()){
                                producto = new Producto(rd.getInt(1), rd.getString(2), rd.getInt(3),
                                        rd.getInt(4), rd.getFloat(5), rd.getString(6));
                                queue.push(producto);
                        }
                    }
                }else{
                    query3="select IDPROD from Compras, Compras_Detalladas where compras.IDCOM = Compras_Detalladas.idcom and IDPROV = "+idp;
                    rn = conDB.receive(query3);
                    while(rn.next()){
                        idprod = rn.getInt(1);
                        idproductos.add(String.valueOf(idprod));
                    }


                    String strList = String.join(",", idproductos);
                       query4="SELECT * FROM PRODUCTOS WHERE IDPROD IN "+"("+strList+") ORDER BY PRECIO ASC";
                        rf = conDB.receive(query4);
                        while(rf.next()){
                            producto = new Producto(rf.getInt(1), rf.getString(2), rf.getInt(3),
                                    rf.getInt(4), rf.getFloat(5), rf.getString(6));
                            queue.push(producto);
                        } 
                } 
            break;
            case 5:
                rs = conDB.receive(query);
                while (rs.next()) {
                    idp = rs.getInt(1);
                }

                query1="select idprov from Compras_Detalladas where IDPROV = "+idp;
                rt = conDB.receive(query1);
                if (rt.next()) {
                    //HOAL
                }else{
                    idp = 0;
                }

                if (idp==0) {
                    query2="select IDPROD from Compras, Compras_Detalladas where compras.IDCOM = Compras_Detalladas.idcom";
                    rp = conDB.receive(query2);
                    while (rp.next()) {
                        idprod = rp.getInt(1);
                        idproductos.add(String.valueOf(idprod));
                    }
                    String strList = String.join(",", idproductos);
                    if (idproductos.isEmpty()) {
                        query3="select * from productos";
                        rd = conDB.receive(query3);
                        while(rd.next()){
                                producto = new Producto(rd.getInt(1), rd.getString(2), rd.getInt(3),
                                        rd.getInt(4), rd.getFloat(5), rd.getString(6));
                                queue.push(producto);
                        }
                    }else{
                        query3="select * from productos where idprod not in ("+strList+")";
                        rd = conDB.receive(query3);
                        while(rd.next()){
                                producto = new Producto(rd.getInt(1), rd.getString(2), rd.getInt(3),
                                        rd.getInt(4), rd.getFloat(5), rd.getString(6));
                                queue.push(producto);
                        }
                    }
                }else{
                    query3="select IDPROD from Compras, Compras_Detalladas where compras.IDCOM = Compras_Detalladas.idcom and IDPROV = "+idp;
                    rn = conDB.receive(query3);
                    while(rn.next()){
                        idprod = rn.getInt(1);
                        idproductos.add(String.valueOf(idprod));
                    }


                    String strList = String.join(",", idproductos);
                       query4="SELECT * FROM PRODUCTOS WHERE IDPROD IN "+"("+strList+") ORDER BY EXISTENCIA ASC";
                        rf = conDB.receive(query4);
                        while(rf.next()){
                            producto = new Producto(rf.getInt(1), rf.getString(2), rf.getInt(3),
                                    rf.getInt(4), rf.getFloat(5), rf.getString(6));
                            queue.push(producto);
                        } 
                } 
            break;
            default:
                //HOAL?
            break; 
        }
        return queue;
    }
        
    public ListaCola<Producto> consultaPorProvRDBNom(String busqueda, String busquedaProd) throws SQLException{
        ListaCola<Producto> queue = new ListaCola<>();
        Set<String> idproductos = new LinkedHashSet<>();
        ResultSet rs, rn, rp, rf, rt, rd;
        String query="select IDPROV from Proveedores where Nombre_PROV like ("+"'"+busqueda+"'"+")";
        String query1="";
        String query2="";
        String query3="";
        String query4="";
        Producto producto;
        int idp=0, i=0;
        int idprod;
        
        rs = conDB.receive(query);
        while (rs.next()) {
            idp = rs.getInt(1);
        }

        query1="select idprov from Compras_Detalladas where IDPROV = "+idp;
        rt = conDB.receive(query1);
        if (rt.next()) {
            //HOAL
        }else{
            idp = 0;
        }

        if (idp==0) {
            query2="select IDPROD from Compras, Compras_Detalladas where compras.IDCOM = Compras_Detalladas.idcom";
            rp = conDB.receive(query2);
            while (rp.next()) {
                idprod = rp.getInt(1);
                idproductos.add(String.valueOf(idprod));
            }
            String strList = String.join(",", idproductos);
            if (idproductos.isEmpty()) {
                query3="select * from productos";
                rd = conDB.receive(query3);
                while(rd.next()){
                        producto = new Producto(rd.getInt(1), rd.getString(2), rd.getInt(3),
                                rd.getInt(4), rd.getFloat(5), rd.getString(6));
                        queue.push(producto);
                }
            }else{
                query3="select * from productos where idprod not in ("+strList+")";
                rd = conDB.receive(query3);
                while(rd.next()){
                        producto = new Producto(rd.getInt(1), rd.getString(2), rd.getInt(3),
                                rd.getInt(4), rd.getFloat(5), rd.getString(6));
                        queue.push(producto);
                }
            }
        }else{
            query3="select IDPROD from Compras, Compras_Detalladas where compras.IDCOM = Compras_Detalladas.idcom and IDPROV = "+idp;
            rn = conDB.receive(query3);
            while(rn.next()){
                idprod = rn.getInt(1);
                idproductos.add(String.valueOf(idprod));
            }


            String strList = String.join(",", idproductos);
               query4="SELECT * FROM PRODUCTOS WHERE IDPROD IN "+"("+strList+") AND Nombre_Prod like '%" + busquedaProd + "%'";;
                rf = conDB.receive(query4);
                while(rf.next()){
                    producto = new Producto(rf.getInt(1), rf.getString(2), rf.getInt(3),
                            rf.getInt(4), rf.getFloat(5), rf.getString(6));
                    queue.push(producto);
                } 
        }
        return queue;
    }
    
    public void eliminar(int idc) throws SQLException{
        String query="DELETE FROM COMPRAS WHERE IDCOM = "+idc;
        conDB.send(query);
    }
    
    public ListaCola<Persona> getLastProvID() throws SQLException {
        Persona proveedor;
        ListaCola<Persona> queue = new ListaCola<>();
        ResultSet rs;
        int id = 0;
        String query = "SELECT TOP 1 IDPROV, NOMBRE_PROV FROM Proveedores ORDER BY IDPROV DESC";
        rs = conDB.receive(query);
        while (rs.next()) {
            proveedor = new Persona(rs.getInt(1), rs.getString(2));
            queue.push(proveedor);
        }
        return queue;
    }
    
    public ListaCola<Producto> radioTodos() throws SQLException{
        ListaCola<Producto> queue = new ListaCola<>();
        Set<String> idproductos = new LinkedHashSet<>();
        ResultSet rp, rd;
        String query2="";
        String query3="";
        query2="select IDPROD from Compras, Compras_Detalladas where compras.IDCOM = Compras_Detalladas.idcom";
        int idprod;
        Producto producto;
        rp = conDB.receive(query2);
        while (rp.next()) {
            idprod = rp.getInt(1);
            idproductos.add(String.valueOf(idprod));
        }
        String strList = String.join(",", idproductos);
        query3="select * from productos where idprod not in ("+strList+")";
        rd = conDB.receive(query3);
        while(rd.next()){
                producto = new Producto(rd.getInt(1), rd.getString(2), rd.getInt(3),
                        rd.getInt(4), rd.getFloat(5), rd.getString(6));
                queue.push(producto);
        }
        return queue;
    }
    
    public void closeConnection(){
        conDB.closeConnection();
    }
}
