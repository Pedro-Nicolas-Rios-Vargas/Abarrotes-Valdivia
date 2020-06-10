package src;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lista.ListaCola;
import res.Detallada;
import res.Accion;
import res.interfazDB.ManejoUIVentasDetalladas;
import res.interfazDB.ManejoUIVentas;

public class ConsultarVenta extends javax.swing.JFrame {

    DefaultTableModel modeloTablaConsVenta, modeloTabla2;
    static String[] cabeceraTablaAlmacen = {"ID", "ID Cliente", "Fecha", "Total"};
    static String[] cabecera2 = {"ID", "IDPROD", "Cantidad", "Subtotal"};
    static String fecha;
    static ManejoUIVentasDetalladas mUIVD = new ManejoUIVentasDetalladas();
    static ManejoUIVentas mUIV = new ManejoUIVentas();
    public ConsultarVenta(double total) {
        initComponents();
        buttonGroup.add(btnRadioID);
        buttonGroup.add(btnRadioIDCliente);
        buttonGroup.add(btnRadioFecha);
        buttonGroup.add(btnRadiototal);
        btnRadioID.setSelected(true);
        total = 100;
        modeloTablaConsVenta = new DefaultTableModel(null, cabeceraTablaAlmacen){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4;
            }
            
        };
        modeloTabla2 = new DefaultTableModel(null, cabecera2){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4;
            }
            
        };
        tabla2.setModel(modeloTabla2);
        tablaConsVenta.setModel(modeloTablaConsVenta);
        tabla2.getTableHeader().setReorderingAllowed(false);
        tablaConsVenta.getTableHeader().setReorderingAllowed(false);
        mostrarFechasOptions(false);
        consultarSQL("", 0, 0, 0, 0);
    }   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaConsVenta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        labelBuscar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnRadioID = new javax.swing.JRadioButton();
        btnRadioIDCliente = new javax.swing.JRadioButton();
        btnRadioFecha = new javax.swing.JRadioButton();
        btnRadiototal = new javax.swing.JRadioButton();
        txtBuscar = new javax.swing.JTextField();
        ComboBoxDia = new javax.swing.JComboBox<>();
        ComboBoxMes = new javax.swing.JComboBox<>();
        txtYear = new javax.swing.JTextField();
        labelDia = new javax.swing.JLabel();
        LabelMes = new javax.swing.JLabel();
        LableYear = new javax.swing.JLabel();
        confirmar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 450));

        tablaConsVenta.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaConsVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaConsVentaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaConsVenta);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consulta de Ventas");

        labelBuscar.setText("Buscar");

        jLabel3.setText("Filtrar por:");

        btnRadioID.setText("ID");
        btnRadioID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRadioIDMouseClicked(evt);
            }
        });

        btnRadioIDCliente.setText("ID Cliente");
        btnRadioIDCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRadioIDClienteMouseClicked(evt);
            }
        });

        btnRadioFecha.setText("Fecha");
        btnRadioFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRadioFechaMouseClicked(evt);
            }
        });

        btnRadiototal.setText("Total");
        btnRadiototal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRadiototalMouseClicked(evt);
            }
        });

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        ComboBoxDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        ComboBoxMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        labelDia.setText("Dia");

        LabelMes.setText("Mes");

        LableYear.setText("Año");

        confirmar.setText("Consultar");
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarActionPerformed(evt);
            }
        });

        tabla2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabla2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnRadioFecha))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(labelDia))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(ComboBoxDia, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnRadiototal))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(LabelMes))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ComboBoxMes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(confirmar, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(LableYear)
                                .addGap(24, 24, 24))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRadioID)
                        .addGap(42, 42, 42)
                        .addComponent(btnRadioIDCliente)))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelBuscar)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRadioIDCliente)
                            .addComponent(btnRadioID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRadioFecha)
                            .addComponent(btnRadiototal))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDia)
                            .addComponent(LabelMes)
                            .addComponent(LableYear))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboBoxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboBoxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(confirmar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
       
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void btnRadiototalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRadiototalMouseClicked
        limpiarTxtYTabla();
        mostrarFechasOptions(false);
    }//GEN-LAST:event_btnRadiototalMouseClicked

    private void btnRadioFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRadioFechaMouseClicked
        limpiarTxtYTabla();
        mostrarFechasOptions(true);
    }//GEN-LAST:event_btnRadioFechaMouseClicked

    private void btnRadioIDClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRadioIDClienteMouseClicked
        limpiarTxtYTabla();
        mostrarFechasOptions(false);
    }//GEN-LAST:event_btnRadioIDClienteMouseClicked

    private void btnRadioIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRadioIDMouseClicked
        limpiarTxtYTabla();
        mostrarFechasOptions(false);
    }//GEN-LAST:event_btnRadioIDMouseClicked

    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
        consultarSQL("", 4, Integer.parseInt(String.valueOf(ComboBoxDia.getSelectedItem())), Integer.parseInt(String.valueOf(ComboBoxMes.getSelectedItem())), Integer.parseInt(txtYear.getText()));
    }//GEN-LAST:event_confirmarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
         if (btnRadioID.isSelected()) {
            consultarSQL(txtBuscar.getText(), 1,0,0,0);
        } else if (btnRadioIDCliente.isSelected()) {
            consultarSQL(txtBuscar.getText(), 3,0,0,0);
        } else if (btnRadioFecha.isSelected()) {
        } else if (btnRadiototal.isSelected()) {
            consultarSQL(txtBuscar.getText(), 4,0,0,0);
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tablaConsVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaConsVentaMouseClicked
        ListaCola<Accion> queue = new ListaCola<Accion>();
        Accion go;
        if (tablaConsVenta.getSelectedRow() != -1) {
            vaciarTabla2();
            try {
                queue = mUIV.consultar(1, (String) modeloTablaConsVenta.getValueAt(tablaConsVenta.getSelectedRow(), 0));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "ERROR: " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            while (true) {
            if (!queue.hasNext()) {
                break;
            }
            go = queue.pop();
            String[] datos = {String.valueOf(go.getId()), String.valueOf(go.getId2()), String.valueOf(go.getCantidad()), String.valueOf(go.getSubTotal())};
            modeloTabla2.addRow(datos);
            }
        }
    }//GEN-LAST:event_tablaConsVentaMouseClicked

    public void vaciarTabla() {
        for (int i =  modeloTablaConsVenta.getRowCount() - 1; i >= 0; i--) {
            modeloTablaConsVenta.removeRow(i);
        }
    }
    
    public void vaciarTabla2() {
        for (int i =  modeloTabla2.getRowCount() - 1; i >= 0; i--) {
            modeloTabla2.removeRow(i);
        }
    }
    
    public void limpiarTxtYTabla() {
        txtBuscar.setText("");
        consultarSQL("", 0,0,0,0);
    }
    
    public void mostrarFechasOptions(boolean seleccion) {
        labelDia.setVisible(seleccion);
        LabelMes.setVisible(seleccion);
        LableYear.setVisible(seleccion);

        ComboBoxDia.setVisible(seleccion);
        ComboBoxMes.setVisible(seleccion);
        txtYear.setVisible(seleccion);
        confirmar.setVisible(seleccion);
        
        txtBuscar.setVisible(!seleccion);
        labelBuscar.setVisible(!seleccion);
    }
    
    public void consultarSQL(String busqueda, int filtro, int dia, int mes, int year) {
        ListaCola<Detallada> queue = new ListaCola<Detallada>();
        Detallada esta;
        try {
            queue = mUIVD.consultar(filtro, txtBuscar.getText(), dia, mes, year);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "ERROR: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        vaciarTabla();
        while (true) {
            if (!queue.hasNext()) {
                break;
            }
            esta = queue.pop();
            String diaCompuesto = String.valueOf(esta.getDia()) + "/" + String.valueOf(esta.getMes()) + "/"  + String.valueOf(esta.getYear());
            String[] datos = {String.valueOf(esta.getId()), String.valueOf(esta.getId2()), diaCompuesto, String.valueOf(esta.getTotal())};
            modeloTablaConsVenta.addRow(datos);
        }
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxDia;
    private javax.swing.JComboBox<String> ComboBoxMes;
    private javax.swing.JLabel LabelMes;
    private javax.swing.JLabel LableYear;
    private javax.swing.JRadioButton btnRadioFecha;
    private javax.swing.JRadioButton btnRadioID;
    private javax.swing.JRadioButton btnRadioIDCliente;
    private javax.swing.JRadioButton btnRadiototal;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton confirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelBuscar;
    private javax.swing.JLabel labelDia;
    private javax.swing.JTable tabla2;
    private javax.swing.JTable tablaConsVenta;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}
