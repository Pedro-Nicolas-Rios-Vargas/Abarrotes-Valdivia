package res;

import java.awt.*;
import java.awt.print.*;
import java.text.Format;
import java.util.Formatter;

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

            Font font = new Font("Serif", Font.PLAIN, 10);
            FontMetrics metrics = graphics.getFontMetrics(font);
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

            VentaProductoUnitario productoUnitario = productos[0];
            float total = productoUnitario.getTotal();
            for(int line = start; line < end; line++) {
                //Get the n product selled
                productoUnitario = productos[line];

                //Extract the sell's characteristics
                String prodNombre = productoUnitario.getProducto().getNombre();
                int cantidad = productoUnitario.getCantidad();
                float subTotal = productoUnitario.getSubTotal();

                // The Max length of a product name is 25 chars,
                // the quantity can be an infinity value but considering it with only 2 chars
                // 1 because adding an 'x' for specify the number of products bought.
                // The max chars that can contain an subtotal value is 9 (6 from integer numbers,
                // 1 for float point and 2 for float number)
                // The max chars that an line can contain without count the divisors between values is
                // 25 + 1 + 2 = 28 chars
                int numProdNameChars = prodNombre.length();
                for(int prodX = 0; prodX < cantidad; prodX++) {
                    y += lineHeight;
                    graphics.drawString(prodNombre, 0, y);
                    graphics.drawString(String.format("$%.2f", subTotal), 145, y);
                }

            }
            String divisor = "_".repeat(29);
            graphics.drawString(divisor,0,y);
            y += lineHeight;
            String totalSold = String.format("$%.2f",total);
            //Se imprime el total
            graphics.drawString("TOTAL",0,y);
            graphics.drawString(totalSold,140,y);

            Graphics2D g2d = (Graphics2D) graphics;

            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

            return PAGE_EXISTS;
        }
    }
}
