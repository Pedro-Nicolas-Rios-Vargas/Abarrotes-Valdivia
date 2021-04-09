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
public class Proveedor extends Persona {
    private String telefono;
    
    public Proveedor(int id, String nombre, String telefono) {
        super(id, nombre);
        this.telefono = telefono;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nTelefono: " + telefono;
    }
    
}
