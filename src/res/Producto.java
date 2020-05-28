/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package res;

/**
 *
 * @author pnrv2
 */
public class Producto extends AbarrotesElemento{
    private String nombre;
    private int existencia;
    private int stock;
    private float precio;
    private String um;
    
    public Producto(int id, String nombre, int existencia, int stock,
            int precio, String um){
        this.id = id;
        this.nombre = nombre;
        this.existencia = existencia;
        this.stock = stock;
        this.precio = precio;
        this.um = um;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    
    public void setExistencia(int existencia){
        this.existencia = existencia;
    }
    public int getExistencia(){
        return existencia;
    }
    
    public void setStock(int stock){
        this.stock = stock;
    }
    public int getStock(){
        return stock;
    }
    
    public void setPrecio(float precio){
        this.precio = precio;
    }
    public float getPrecio(){
        return precio;
    }
    
    public void setUM(String um){
        this.um = um;
    }
    public String getUM(){
        return um;
    }
}
