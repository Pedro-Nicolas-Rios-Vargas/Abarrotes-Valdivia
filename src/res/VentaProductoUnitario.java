package res;

public class VentaProductoUnitario {
    private Producto producto;
    private int cantidad;
    private float subTotal;
    private float total;

    public VentaProductoUnitario(Producto producto, int cantidad, float subTotal, float total) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
        this.total = total;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public float getTotal() {
        return total;
    }
}
