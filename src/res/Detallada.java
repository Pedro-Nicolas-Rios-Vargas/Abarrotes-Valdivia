/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package res;

import java.util.Date;

/**
 *
 * @author pnrv2
 */
public class Detallada extends AbarrotesElemento{
    private int id2;
    private Date fecha = new Date();
    private float total;
    
    public Detallada(int id, int id2, Date fecha, float total){
        this.id = id;
        this.id2 = id2;
        this.fecha = fecha;
        this.total = total;
    }
    
    public void setId2(int id2){
        this.id2 = id2;
    }
    public int getId2(){
        return id2;
    }
    
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    public Date getFecha(){
        return fecha;
    }
    
    public void setTotal(float total){
        this.total = total;
    }
    public float getTotal(){
        return total;
    }
}
