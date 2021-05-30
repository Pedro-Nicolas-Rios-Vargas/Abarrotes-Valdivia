package res;

import java.awt.*;
import java.awt.print.*;
import java.text.Format;
import java.util.*;

public class Printer {
    private PrinterJob job;

    public Printer() {
        job = PrinterJob.getPrinterJob();
    }

    public void printTicket(VentaProductoUnitario[] productos) {
        job.setPrintable(new Ticket(productos));
        boolean doPrint = job.printDialog();
        if(doPrint) {
            try {
                job.print();
            } catch (PrinterException pE) {
                System.out.println("No se pudo realizar la impresion. " + pE.getMessage());
            }
        }
    }
    class Ticket implements Printable {
        private VentaProductoUnitario[] productos;

        public Ticket(VentaProductoUnitario[] productos) {
            this.productos = productos;
        }

        @Override
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
            if (pageIndex > 0) {
                return NO_SUCH_PAGE;
            }

            Font fontGeneral = new Font("Serif", Font.PLAIN, 10);
            Font fontTitulo = new Font("Serif", Font.BOLD, 15);
            FontMetrics metrics = graphics.getFontMetrics(fontGeneral);
            int lineHeight = metrics.getHeight();
            double pageHeight = pageFormat.getImageableHeight();

            int linesPerPage = ((int) pageHeight) / lineHeight;
            int numBreaks = (productos.length-1) / linesPerPage;
            int[] pageBreaks = new int[numBreaks];
            for(int breakIdx = 0; breakIdx < numBreaks; breakIdx++) {
                pageBreaks[breakIdx] = (breakIdx + 1) * linesPerPage;
            }

            int y = 0;
            int start = (pageIndex == 0) ? 0 : pageBreaks[pageIndex-1];
            int end = (pageIndex == pageBreaks.length) ? productos.length : pageBreaks[pageIndex];
            y += lineHeight * 2;
            graphics.setFont(fontTitulo);
            graphics.drawString("ABARROTES VALDIVIA", 20,y);

            y += lineHeight;
            graphics.setFont(fontGeneral);
            // Imprime la fecha del dia
            Calendar calendario = new GregorianCalendar(TimeZone.getDefault());
            int dia = calendario.get(Calendar.DAY_OF_MONTH);
            int mes = calendario.get(Calendar.MONTH) + 1;
            int anio = calendario.get(Calendar.YEAR);
            int hora = calendario.get(Calendar.HOUR_OF_DAY);
            int minuto = calendario.get(Calendar.MINUTE);
            int segundo = calendario.get(Calendar.SECOND);
            graphics.drawString(String.format("%d/%d/%d \t %d:%d:%d",dia,mes,anio,hora,minuto,segundo),70,y);

            // Impreme encabezado de la tabla de ventas

            y += lineHeight;
            graphics.drawString("CANT.",0,y);
            graphics.drawString("ARTICULO",50,y);
            graphics.drawString("SUBTOTAL",175,y);
            //y += lineHeight;

            //Imprime todos los productos vendidos
            VentaProductoUnitario producto = productos[0];
            float total = producto.getTotal();
            for(int line = start; line < end; line++) {
                y += lineHeight;
                //Get the n product selled
                producto = productos[line];
                printProduct(graphics,producto, y);
            }
            //Imprime el divisor entre productos y total
            String divisor = "_".repeat(41);
            graphics.drawString(divisor,0,y);
            y += lineHeight;
            //Se imprime el total vendido
            String totalSold = String.format("$%.2f",total);
            graphics.drawString("TOTAL",60,y);
            graphics.drawString(totalSold,175,y);

            Graphics2D g2d = (Graphics2D) graphics;

            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

            return PAGE_EXISTS;
        }

        private void printProducts(Graphics graphics, VentaProductoUnitario producto, int y) {

        }

        private void printProduct(Graphics graphics, VentaProductoUnitario producto, int y) {
            //Extract the sell's characteristics
            String prodNombre = producto.getProducto().getNombre();
            int cantidad = producto.getCantidad();
            float subTotal = producto.getSubTotal();

            graphics.drawString(String.format("%d",cantidad), 0, y);
            graphics.drawString(prodNombre, 50, y);
            graphics.drawString(String.format("$%.2f", subTotal), 175, y);

        }
    }
}
