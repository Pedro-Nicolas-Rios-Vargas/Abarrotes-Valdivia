/*package Java.Tienda;

import java.util.Scanner;
public class Prueba {
    static ProductoSave pSave = new ProductoSave();
    static int contGlobal = 0;
    
    public static void main(String args[]) {
        
        String sopc;

        Scanner leer = new Scanner(System.in);
        
        do {
            System.out.println("1] Agregar Proucto");
            System.out.println("2] Leer Proucto");
            System.out.println("3] Modificar Proucto");
            System.out.println("4] Borrar Proucto");
            System.out.println("5] Salir");
            System.out.println("Que desea hacer");
            sopc = leer.nextLine();
            switch (sopc) {
                case "1":
                    agregar();
                    break;
                case "2":
                    read();
                    break;
                case "3":
                System.out.println("Perdon por ser tan inutil :(");
                    break;
                case "4":
                    System.out.println("Aun no se como hacer eso xd");
                    break;
                case "5":
                    System.out.println("Gracias por usar el programa");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (!sopc.equals("5"));

    }
    //Agregar nuevo producto
    public static void agregar() {
        Scanner leer = new Scanner(System.in);
        
        String productName;
        double price;

        System.out.print("Agregar el nombre del proucto: ");
        productName = leer.nextLine();
        System.out.print("Agregar el precio del producto: ");
        price = leer.nextDouble();

        Producto p = new Producto(productName, price);
        //ProductoSave pSave = new ProductoSave();
        if(contGlobal == 0){
            pSave.AddFirst(p);
        }else{
            pSave.Add(p);
        }
        
        contGlobal++;
    }
    //leer nuevo producto
    public static void read() {
        //ProductoSave pSave = new ProductoSave();
        /*for (int i = 0; i < contGlobal; i++) {
            System.out.println(contGlobal);
            System.out.println(i);
            Producto p = pSave.read();
            System.out.println(p.getProductName() + "\t" + p.getPrice());
            System.out.println("********************************************");
        }
        pSave.read();
    }
}*/