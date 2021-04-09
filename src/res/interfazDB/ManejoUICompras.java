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
        String query="";
        Producto producto;

        switch (filtro) {
            case 1:
                    query = "execute selectProducs";
                break;
            case 2:
                try {
                    query = "execute OrdID";
                } catch (NumberFormatException e) {
                    query = "execute OrdIDEx";
                }   
                break;
            case 3:
                String busquedaAux = "'"+busqueda+"'";
                query = "execute OrdNomb "+busquedaAux;
                break;
            case 4:
                try {
                    query = "execute OrdPrecio";
                } catch (NumberFormatException e) {
                    query = "execute OrdPrecioEx";
                }
                break;
            case 5:
                try {
                    query = "execute OrdExistencia";
                } catch (NumberFormatException e) {
                   query = "execute OrdExistencia";
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
        String query="execute consultaProv";
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
        String query = "execute addCompras " + idc + ", " + idprod + ", " +
                cantidad + ", " + subtotalV;
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
    
    public ListaCola<Producto> consultaPorProv(String busqueda) throws SQLException{
        ListaCola<Producto> queue = new ListaCola<>();
        Set<String> idproductos = new LinkedHashSet<>();
        ResultSet rs, rn, rp, rf, rt, rd;
        String busquedaAux = "'"+busqueda+"'";
        String query="execute PROVidNomb "+busquedaAux;
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
        
        query1="execute PROVidCDs "+idp;
        rt = conDB.receive(query1);
        if (rt.next()) {
            //HOAL
        }else{
            idp = 0;
        }
        
        if (idp==0) {
            query2="execute PRODidCDs";
            rp = conDB.receive(query2);
            while (rp.next()) {
                idprod = rp.getInt(1);
                idproductos.add(String.valueOf(idprod));
            }
            String strList = String.join(",", idproductos);
            if (idproductos.isEmpty()) {
                query3="execute selectProducs";
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
            query3="execute PRODidCsProv "+idp;
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
        String busquedaAux = "'"+busqueda+"'";
        String query="execute PROVidNomb "+busquedaAux;
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

                query1="execute PROVidCDs "+idp;
                rt = conDB.receive(query1);
                if (rt.next()) {
                    //HOAL
                }else{
                    idp = 0;
                }

                if (idp==0) {
                    query2="execute PRODidCDs";
                    rp = conDB.receive(query2);
                    while (rp.next()) {
                        idprod = rp.getInt(1);
                        idproductos.add(String.valueOf(idprod));
                    }
                    String strList = String.join(",", idproductos);
                    if (idproductos.isEmpty()) {
                        query3="execute selectProducs";
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
                    query3="execute PRODidCsProv "+idp;
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

                query1="execute PRODidCsProv "+idp;
                rt = conDB.receive(query1);
                if (rt.next()) {
                    //HOAL
                }else{
                    idp = 0;
                }

                if (idp==0) {
                    query2="execute PRODidCDs";
                    rp = conDB.receive(query2);
                    while (rp.next()) {
                        idprod = rp.getInt(1);
                        idproductos.add(String.valueOf(idprod));
                    }
                    String strList = String.join(",", idproductos);
                    if (idproductos.isEmpty()) {
                        query3="execute selectProducs";
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
                    query3="execute PRODidCsProv "+idp;
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

                query1="execute PRODidCsProv "+idp;
                rt = conDB.receive(query1);
                if (rt.next()) {
                    //HOAL
                }else{
                    idp = 0;
                }

                if (idp==0) {
                    query2="execute PRODidCDs";
                    rp = conDB.receive(query2);
                    while (rp.next()) {
                        idprod = rp.getInt(1);
                        idproductos.add(String.valueOf(idprod));
                    }
                    String strList = String.join(",", idproductos);
                    if (idproductos.isEmpty()) {
                        query3="execute selectProducs";
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
                    query3="execute PRODidCsProv "+idp;
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
        String busquedaAux = "'"+busqueda+"'";
        String query="execute PROVidNomb "+busquedaAux;
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

        query1="execute PRODidCsProv "+idp;
        rt = conDB.receive(query1);
        if (rt.next()) {
            //HOAL
        }else{
            idp = 0;
        }

        if (idp==0) {
            query2="execute PRODidCDs";
            rp = conDB.receive(query2);
            while (rp.next()) {
                idprod = rp.getInt(1);
                idproductos.add(String.valueOf(idprod));
            }
            String strList = String.join(",", idproductos);
            if (idproductos.isEmpty()) {
                query3="execute selectProducs";
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
            query3="execute PRODidCsProv "+idp;
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
    
    
    public ListaCola<Persona> getLastProvID() throws SQLException {
        Persona proveedor;
        ListaCola<Persona> queue = new ListaCola<>();
        ResultSet rs;
        int id = 0;
        String query = "execute getLastProvID";
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
        query2="execute PRODidCDs";
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
    
    public int ExistenciaConsul(int idProd)throws SQLException{
        ResultSet rs;
        String query = "execute ExistenciaConsul "+idProd;
        int existencia = 0;
        rs = conDB.receive(query);
            
        while (rs.next()) {
            existencia = rs.getInt(1); 
        }
        return existencia;
    }
    
    public void UpdateProdEx(int idProd, int Nexistencia)throws SQLException{
        String query = "execute UpdateEx "+Nexistencia+","+idProd;
        conDB.send(query);
    }
    
    
    public void closeConnection(){
        conDB.closeConnection();
    }
}
