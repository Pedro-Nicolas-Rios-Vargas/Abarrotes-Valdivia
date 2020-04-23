package src;

/**
 *
 * @author vival
 */
public class Producto {
    
    private int code;
    private String nameProduct;
    private double price;
    private int cantidad;
    
    public Producto(){}
    
    public Producto(int code, String nameProduct, double price, int cantidad){
        this.code = code;
        this.nameProduct = nameProduct;
        this.price = price;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return nameProduct + " $" + price;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
