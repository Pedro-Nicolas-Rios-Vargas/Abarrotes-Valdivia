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
public class Accion extends AbarrotesElemento{
    private int id2;
    private int cantidad;
    private float subTotal;
    
    public Accion(int id, int id2, int cantidad, float subTotal){
        this.id = id;
        this.id2 = id2;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }
    
    public void setId2(int id2){
        this.id2 = id2;
    }
    public int getId2(){
        return id2;
    }
    
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    public int getCantidad(){
        return cantidad;
    }
    
    public void setSubTotal(float subTotal){
        this.subTotal = subTotal;
    }
    public float getSubTotal(){
        return subTotal;
    }
}
