/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lista.ListaCola;
import res.Producto;
import res.interfazDB.ManejoUIProductos;
import res.interfazDB.ManejoUIVentas;
import res.interfazDB.ManejoUIVentasDetalladas;
/**
 *
 * @author vival
 */
public class GestionarVentas extends javax.swing.JPanel {

    DefaultTableModel modeloTablaAlmacen, modeloPrueba;
    static String[] cabeceraTablaAlmacen = {"ID", "Nombre", "Precio", "Existencia", "Stock", "Unidad de Medida"};
    static float total = 0;
    static String pagoS = "0";
    static ManejoUIProductos mUIP = new ManejoUIProductos();
    static ManejoUIVentas mUIV = new ManejoUIVentas();
    static ManejoUIVentasDetalladas mIUVD = new ManejoUIVentasDetalladas();
    static String[] pruebaC = {"Producto","Cantidad"};
    /**
     * Creates new form GestionarVentas
     */
    public GestionarVentas() {
        initComponents();
        GrupoBtnRadio.add(btnRadioID);
        GrupoBtnRadio.add(btnRadioCantidad);
        GrupoBtnRadio.add(btnRadioNombre);
        GrupoBtnRadio.add(btnRadioPrecio);
        
        btnRadioID.setSelected(true);
        
        modeloPrueba = new DefaultTableModel(null, pruebaC){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 6;
            }
            
        };
        tablaPito.setModel(modeloPrueba);
        modeloTablaAlmacen = new DefaultTableModel(null,cabeceraTablaAlmacen){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2;
            }
            
        };
        tablaAlmacen.setModel(modeloTablaAlmacen);
        tablaAlmacen.getTableHeader().setReorderingAllowed(false);
        tablaPito.getTableHeader().setReorderingAllowed(false);
        consultarSQL("", 0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoBtnRadio = new javax.swing.ButtonGroup();
        txtPago = new javax.swing.JTextField();
        BarraBuscar = new javax.swing.JTextField();
        btnAgregarlist2 = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        labelTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnNewC = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlmacen = new javax.swing.JTable();
        ConsVenta = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnRadioID = new javax.swing.JRadioButton();
        btnRadioNombre = new javax.swing.JRadioButton();
        btnRadioPrecio = new javax.swing.JRadioButton();
        btnRadioCantidad = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txtCambio = new javax.swing.JTextField();
        pito = new javax.swing.JScrollPane();
        tablaPito = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setLayout(null);

        txtPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPagoKeyTyped(evt);
            }
        });
        add(txtPago);
        txtPago.setBounds(55, 610, 429, 30);

        BarraBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BarraBuscarKeyReleased(evt);
            }
        });
        add(BarraBuscar);
        BarraBuscar.setBounds(630, 40, 540, 24);

        btnAgregarlist2.setText("Agregar");
        btnAgregarlist2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarlist2ActionPerformed(evt);
            }
        });
        add(btnAgregarlist2);
        btnAgregarlist2.setBounds(543, 128, 90, 32);

        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        add(btnQuitar);
        btnQuitar.setBounds(543, 79, 90, 32);

        labelTotal.setText("Total");
        add(labelTotal);
        labelTotal.setBounds(0, 590, 28, 16);

        txtTotal.setEditable(false);
        txtTotal.setText("$");
        add(txtTotal);
        txtTotal.setBounds(54, 580, 430, 30);

        btnNewC.setText("Finalizar compra");
        btnNewC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewCActionPerformed(evt);
            }
        });
        add(btnNewC);
        btnNewC.setBounds(0, 670, 484, 32);

        jLabel1.setText("Pago");
        add(jLabel1);
        jLabel1.setBounds(0, 620, 29, 16);

        tablaAlmacen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaAlmacen);

        add(jScrollPane1);
        jScrollPane1.setBounds(543, 171, 630, 510);

        ConsVenta.setText("Consultar Ventas");
        ConsVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsVentaActionPerformed(evt);
            }
        });
        add(ConsVenta);
        ConsVenta.setBounds(1033, 99, 140, 32);

        jLabel3.setText("Filtrar por:");
        add(jLabel3);
        jLabel3.setBounds(643, 79, 80, 16);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Gestionar Ventas");
        add(jLabel4);
        jLabel4.setBounds(783, 0, 200, 40);

        btnRadioID.setText("ID");
        btnRadioID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRadioIDMouseClicked(evt);
            }
        });
        add(btnRadioID);
        btnRadioID.setBounds(643, 101, 50, 28);

        btnRadioNombre.setText("Nombre");
        btnRadioNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRadioNombreMouseClicked(evt);
            }
        });
        add(btnRadioNombre);
        btnRadioNombre.setBounds(643, 136, 90, 28);

        btnRadioPrecio.setText("Precio");
        btnRadioPrecio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRadioPrecioMouseClicked(evt);
            }
        });
        add(btnRadioPrecio);
        btnRadioPrecio.setBounds(733, 99, 80, 28);

        btnRadioCantidad.setText("Existencia");
        btnRadioCantidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRadioCantidadMouseClicked(evt);
            }
        });
        add(btnRadioCantidad);
        btnRadioCantidad.setBounds(733, 134, 120, 28);

        jLabel2.setText("Cambio");
        add(jLabel2);
        jLabel2.setBounds(0, 650, 50, 16);

        txtCambio.setEditable(false);
        txtCambio.setText("$");
        add(txtCambio);
        txtCambio.setBounds(56, 640, 428, 30);

        tablaPito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        pito.setViewportView(tablaPito);

        add(pito);
        pito.setBounds(0, 40, 531, 522);

        jLabel5.setText("Buscar");
        add(jLabel5);
        jLabel5.setBounds(560, 40, 50, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarlist2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarlist2ActionPerformed
        if (tablaAlmacen.getSelectedRow() != -1 ) {
            String[] aux = new String[modeloTablaAlmacen.getColumnCount()];
            for (int i = 0; i < aux.length; i++) {
                aux[i] = modeloTablaAlmacen.getValueAt(tablaAlmacen.getSelectedRow(), i).toString();
            }
           
           Producto producto = new Producto(Integer.parseInt(aux[0]), aux[1], Integer.parseInt(aux[3]), Integer.parseInt(aux[4]), Float.valueOf(aux[2]), aux[5]);
           total += producto.getPrecio();
           int i = 0;
           int catidad = 1;
           while (i < modeloPrueba.getRowCount()) {
               if (modeloPrueba.getValueAt(i, 0) instanceof Producto) {
                   if (producto.getId() == ((Producto) (modeloPrueba.getValueAt(i, 0))).getId()) {
                       catidad += (Integer)modeloPrueba.getValueAt(i, 1);
                       producto = new Producto(producto.getId(), producto.getNombre(), producto.getExistencia(), producto.getStock(), producto.getPrecio() * catidad, producto.getUM());
                       modeloPrueba.removeRow(i);
                   }
                   i++;
               }
            }
           Object[] pruba321 = {producto,catidad};
           modeloPrueba.addRow(pruba321);
           
        } else {
            JOptionPane.showMessageDialog(this, "Favor de seleccionar un producto de la tabla", "Sin seleccion", JOptionPane.INFORMATION_MESSAGE);
        }
        actualizarTotal();
        actualizarCambio();
    }//GEN-LAST:event_btnAgregarlist2ActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        if(tablaPito.getSelectedRow() != -1) {
            int catidad = ((Integer) modeloPrueba.getValueAt(tablaPito.getSelectedRow(), 1));
            float precioNew = (((Producto) modeloPrueba.getValueAt(tablaPito.getSelectedRow(), 0)).getPrecio());
            float precioVergas = precioNew - ((precioNew)/catidad);
            total -= precioNew/catidad;//Estoy tomando el dinero que se va a quitar del total
            Producto producto = ((Producto) modeloPrueba.getValueAt(tablaPito.getSelectedRow(), 0));
            producto = new Producto(producto.getId(), producto.getNombre(), producto.getExistencia(), producto.getStock(), precioVergas, producto.getUM());
            if ((catidad - 1) == 0) {
                modeloPrueba.removeRow(tablaPito.getSelectedRow());
            } else {
                modeloPrueba.setValueAt(catidad - 1, tablaPito.getSelectedRow(), 1);
                modeloPrueba.setValueAt(producto, tablaPito.getSelectedRow(), 0);
            }
            
        } else {
            JOptionPane.showMessageDialog(this, "Favor de seleccionar un producto de la tabla de ventas", "Sin seleccion", JOptionPane.INFORMATION_MESSAGE);
        }
        actualizarTotal();
        actualizarCambio();
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnNewCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewCActionPerformed
        String pagoEnString = txtPago.getText();
        float pagoEnFloat = Float.valueOf(txtPago.getText());
        int paso = 2;
        if ((!(pagoEnString.equals(""))) && pagoEnFloat >= 0 && (Double.valueOf(pagoS) - total) >= 0) {
            try {
                paso = mIUVD.agregar(1, dia(), mes(), year(), total);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "ERROR: " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            if (paso == 1) {   
                for (int i = 0; i < modeloPrueba.getRowCount(); i++) {
                    try {
                        Producto producto = ((Producto) modeloPrueba.getValueAt(i, 0));
                        int id = producto.getId();
                        int cantidad = ((Integer) modeloPrueba.getValueAt(i, 1));
                        float subTotal = (producto.getPrecio());
                        mUIV.agregar(id, cantidad, subTotal);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, "ERROR: " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
                JOptionPane.showMessageDialog(this, "El cambio es " + txtCambio.getText(), "Venta realizada con exito", JOptionPane.INFORMATION_MESSAGE);
            }
            for (int i = modeloPrueba.getRowCount() - 1; i >= 0; i--) {
                modeloPrueba.removeRow(i);
            }
            txtPago.setText("");
            total = 0;
            pagoS = "0";
            actualizarTotal();
            actualizarCambio();
        } else {
            JOptionPane.showMessageDialog(this, "Falta dinero a pagar", "Cambio negativo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnNewCActionPerformed

    private void txtPagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoKeyTyped
        char c = evt.getKeyChar();
        if (c >= 48 && c <= 57 || c == 8) {
            if( c == 8) {
                pagoS = pagoS.substring(0, pagoS.length()-1);
            } else {
                pagoS = pagoS.concat(String.valueOf(c));
            }
        } else {
            JOptionPane.showMessageDialog(this, "El caracter " + c + " no es valido", "Caracter Invalido", JOptionPane.ERROR_MESSAGE);
            evt.consume();
        }
        actualizarCambio();
    }//GEN-LAST:event_txtPagoKeyTyped

    private void btnRadioIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRadioIDMouseClicked
        limpiarTxtYTabla();
    }//GEN-LAST:event_btnRadioIDMouseClicked

    private void btnRadioNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRadioNombreMouseClicked
        limpiarTxtYTabla();
    }//GEN-LAST:event_btnRadioNombreMouseClicked

    private void btnRadioPrecioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRadioPrecioMouseClicked
        limpiarTxtYTabla();
    }//GEN-LAST:event_btnRadioPrecioMouseClicked

    private void btnRadioCantidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRadioCantidadMouseClicked
        limpiarTxtYTabla();
    }//GEN-LAST:event_btnRadioCantidadMouseClicked

    private void ConsVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsVentaActionPerformed
        ConsultarVenta consultarVenta = new ConsultarVenta(100);
        consultarVenta.setVisible(true);
    }//GEN-LAST:event_ConsVentaActionPerformed

    private void BarraBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BarraBuscarKeyReleased
        if (btnRadioID.isSelected()) {
            consultarSQL(BarraBuscar.getText(), 1);
        } else if (btnRadioNombre.isSelected()) {
            consultarSQL(BarraBuscar.getText(), 2);
        } else if (btnRadioPrecio.isSelected()) {
            consultarSQL(BarraBuscar.getText(), 3);
        } else if (btnRadioCantidad.isSelected()) {
            consultarSQL(BarraBuscar.getText(), 4);
        }
    }//GEN-LAST:event_BarraBuscarKeyReleased

    //-----------------Metodos-----------------------------
    
    //-------------------Metodo para poner el total dinamicamente----------------------
    public void actualizarTotal() {
        txtTotal.setText("$ " + total);
    }
    //----------------------Cambio actualizado----------------------------
    public void actualizarCambio() {
        txtCambio.setText("$ " + (Double.valueOf(pagoS) - total));
    }

    public void limpiarTxtYTabla() {
        BarraBuscar.setText("");
        consultarSQL("", 0);
    }
    /**
     * Hace la consulta dependiendo el filtro que se aplique
     * @param consulta
     * @param filtro 
     */
    public void consultarSQL(String consulta, int filtro) {
        ListaCola<Producto> queue = new ListaCola<Producto>();
        
        Producto seihin;
        try {
            queue = mUIP.consulta(filtro, consulta);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "ERROR: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        vaciarTabla();
        while (true) {
            if (!queue.hasNext()) {
                break;
            }
            seihin = queue.pop();
            String[] datos = {String.valueOf(seihin.getId()), seihin.getNombre(),String.valueOf(seihin.getPrecio()),
            String.valueOf(seihin.getExistencia()), String.valueOf(seihin.getStock()), seihin.getUM()};
            modeloTablaAlmacen.addRow(datos);
        }
    }
    /**
     * Metodo para vaciar la tabla 
     * Si esto falla o marca error cambiar el for por 
     * for(int i = 0; i < modeloTabla2.getRowCount(); i++)
     */
    public void vaciarTabla() {
        for (int i =  modeloTablaAlmacen.getRowCount() - 1; i >= 0; i--) {
            modeloTablaAlmacen.removeRow(i);
        }
    }
    /**
     * Metodo para conseguir el dia actual
     * @return Dia en forma de int
     */
    public static int dia() {
        Calendar fechaC = Calendar.getInstance();
        return fechaC.getTime().getDate();
    }
    /**
     * Metodo para conseguir el mes actual
     * @return El mes en forma de entero, Enero = 1
     */
    public static int mes() {
        Calendar fechaC = Calendar.getInstance();
        return (fechaC.getTime().getMonth()+1);
    }
    /**
     * Metodo para conseguir el year actual
     * @return Regresa el year actual en entero
     */
    public static int year() {
        Calendar fechaC = Calendar.getInstance();
        return (fechaC.getTime().getYear()+1900);
    }
    
    //--------------Fin Metodos----------------------------

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BarraBuscar;
    private javax.swing.JButton ConsVenta;
    private javax.swing.ButtonGroup GrupoBtnRadio;
    private javax.swing.JButton btnAgregarlist2;
    private javax.swing.JButton btnNewC;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JRadioButton btnRadioCantidad;
    private javax.swing.JRadioButton btnRadioID;
    private javax.swing.JRadioButton btnRadioNombre;
    private javax.swing.JRadioButton btnRadioPrecio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JScrollPane pito;
    private javax.swing.JTable tablaAlmacen;
    private javax.swing.JTable tablaPito;
    private javax.swing.JTextField txtCambio;
    private javax.swing.JTextField txtPago;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
