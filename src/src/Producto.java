package src;

/**
 *
 * @author vival
 */
public class Producto {
    
    private int idprod;
    private String nombre_Prod;
    private String um;
    private int stock;
    private double price;
    private int existencia;

    public Producto() {}
    public Producto(int idprod, String nombre_Prod, double price, int existencia, int stock, String um) {
        this.idprod = idprod;
        this.nombre_Prod = nombre_Prod;
        this.um = um;
        this.stock = stock;
        this.price = price;
        this.existencia = existencia;
    }

    public int getIdprod() {
        return idprod;
    }

    public void setIdprod(int idprod) {
        this.idprod = idprod;
    }

    public String getNombre_Prod() {
        return nombre_Prod;
    }

    public void setNombre_Prod(String nombre_Prod) {
        this.nombre_Prod = nombre_Prod;
    }

    public String getUm() {
        return um;
    }

    public void setUm(String um) {
        this.um = um;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return nombre_Prod + " $" + price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

}
