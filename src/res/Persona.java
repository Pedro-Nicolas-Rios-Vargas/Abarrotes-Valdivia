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
public class Persona extends AbarrotesElemento{
    private String nombre;
    
    public Persona(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String toString(){
        return "ID: " + id + "\nNombre: " + nombre;
    }
}
