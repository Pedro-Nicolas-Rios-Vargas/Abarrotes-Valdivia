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
public class Clientes extends Persona {
    private String saldo;
    
    public Clientes(int id, String nombre, String saldo) {
        super(id, nombre);
        this.saldo = saldo;
    }
    
    public String getSaldo() {
        return saldo;
    }
    
    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nSaldo: " + saldo;
    }
    
}
