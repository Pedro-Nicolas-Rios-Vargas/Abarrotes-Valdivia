/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.*;

/**
 *
 * @author vival
 */
public class VentaDelDiaSave {
    private FileOutputStream fos;
    private ObjectOutputStream oos;

    public VentaDelDiaSave(){}
    
    //AgregarCrearElArchivo Datos.obj
    public void AddFirst(VentaDelDia p){
        try {
            fos = new FileOutputStream("Datos.obj", true);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(p);
        } catch (IOException ioe) {
            System.out.println("Error: 1" + ioe.toString());
        }
        finally{
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ioe) {
                System.out.println("Error: 2" + ioe.toString());
            }
        } 
    }
    //Agregar sin crear el archivo y sin agregar la cabezera
    public void Add(VentaDelDia p){
        try {
            fos = new FileOutputStream("Datos.obj", true);
            oos = new MiObjectOutputStream(fos);
            oos.writeObject(p);
        } catch (IOException ioe) {
            System.out.println("Error: 3" + ioe.toString());
        }
        finally{
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ioe) {
                System.out.println("Error: 4" + ioe.toString());
            }
        } 
    }
}
