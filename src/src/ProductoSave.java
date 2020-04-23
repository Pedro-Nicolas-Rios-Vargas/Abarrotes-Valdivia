
package src;

import java.io.*;
import java.io.RandomAccessFile;

public class ProductoSave {
    
    RandomAccessFile raf;
    int lenghtRaf;
    
    public ProductoSave(){
        raf = null;
        lenghtRaf = 104;
    }
    
    public void add(Producto p) throws IOException {
        try {
            raf = new RandomAccessFile("datos.Files", "rw");
            raf.seek(p.getCode()*lenghtRaf-lenghtRaf);
            raf.writeInt(p.getCode());
            raf.writeUTF(p.getNameProduct());
            raf.writeDouble(p.getPrice());
            raf.writeInt(p.getCantidad());
        } catch (IOException ioe) {
            System.out.println("ERROR: " + ioe.toString());
        }finally{
            if(raf != null){
                raf.close();
            }

        }
    }

    public int readAll() throws IOException {
    int clave, x=1;
        try {
            raf = new RandomAccessFile("datos.Files","r");
            do {                
                raf.seek(x*lenghtRaf-lenghtRaf);
                clave = raf.readInt();
                x++;
            } while (true);
        }
        catch(EOFException e){}
        finally{
                if(raf!=null){
                    raf.close();
                }
        }
        return x;//Por si en el hay pedos quita el - 1
    }

    public Producto readOne(int code) throws IOException{
        Producto p = null;
        try {
            raf = new RandomAccessFile("datos.Files", "r");
            raf.seek(code*lenghtRaf-lenghtRaf);
            int cve = raf.readInt();
            if (cve == code) {
                String producto = raf.readUTF();
                double price = raf.readDouble();
                int cantidad = raf.readInt();
                p = new Producto(cve, producto, price, cantidad);
            }
        } catch (IOException e) {
        return null;
        }
        finally{
            if (raf != null) {
                raf.close();
            }
        }
        return p;
    }

    public void modification(Producto p) throws IOException{
        try {
            raf = new RandomAccessFile("datos.Files", "rw");
            raf.seek(p.getCode()*lenghtRaf-lenghtRaf);
            raf.writeInt(p.getCode());
            raf.writeUTF(p.getNameProduct());
            raf.writeDouble(p.getPrice());
            raf.writeInt(p.getCantidad());
        } catch (IOException e) {}
        finally{
            if (raf != null) {
                raf.close();
            }
        }
    }

    public void delete(Producto p) throws IOException{
        try {
            raf = new RandomAccessFile("datos.Files", "rw");
            raf.seek(p.getCode()*lenghtRaf-lenghtRaf);
            raf.writeInt(0);
            raf.writeUTF("");
            raf.writeDouble(0);
            raf.writeInt(0);
        } catch (IOException e) {}
        finally{
            if (raf != null) {
                raf.close();
            }
        }
    }
    
    public int getCode(int clave)throws IOException{
        int cve=-1;
        try {
            raf = new RandomAccessFile("datos.Files","r");
            raf.seek(clave*lenghtRaf-lenghtRaf);
            cve=raf.readInt();
        } catch (EOFException e) {}
        catch(IOException ioe){}
        finally{
            if(raf!=null){
                raf.close();
            }
        }
        return cve;
    }
}