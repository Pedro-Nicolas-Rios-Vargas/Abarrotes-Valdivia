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
public class Detallada extends AbarrotesElemento{
    private int id2;
    private int dia;
    private int mes;
    private int year;
    private float total;
    
    public Detallada(int id, int id2, int dia, int mes, int year, float total){
        this.id = id;
        this.id2 = id2;
        this.dia = dia;
        this.mes = mes;
        this.year = year;
        this.total = total;
    }
    
    public void setId2(int id2){
        this.id2 = id2;
    }
    public int getId2(){
        return id2;
    }
    
    public void setDia(int dia){
        this.dia = dia;
    }
    public int getDia(){
        return dia;
    }
    
    public void setMes(int mes){
        this.mes = mes;
    }
    public int getMes(){
        return mes;
    }
    
    public void setYear(int year){
        this.year = year;
    }
    public int getYear(){
        return year;
    }
    
    public void setTotal(float total){
        this.total = total;
    }
    public float getTotal(){
        return total;
    }
}
