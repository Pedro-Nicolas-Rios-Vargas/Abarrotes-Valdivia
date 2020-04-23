/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;
import java.io.Serializable;
/**
 *
 * @author vival
 */
public class VentaDelDia implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int seek;
    private double venta;
    private String day;
    private String date;
    private String month;
    private String year;
    private String time;

    public VentaDelDia(int seek, double venta, String day, String date, String month, String year, String time) {
        this.seek = seek;
        this.venta = venta;
        this.day = day;
        this.date = date;
        this.month = month;
        this.year = year;
        this.time = time;
    }

    @Override
    public String toString() {
        return "$ " + venta + " " + day + " " + date + "/" + month + "/" + year + " " + time;
    }

    public int getSeek() {
        return seek;
    }

    public void setSeek(int seek) {
        this.seek = seek;
    }

    public double getVenta() {
        return venta;
    }

    public void setVenta(double venta) {
        this.venta = venta;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    } 
}
