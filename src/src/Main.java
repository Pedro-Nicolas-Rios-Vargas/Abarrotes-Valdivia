package src;
/*
Probando que funcione el branch que cree
*/
import java.util.Calendar;
import java.awt.*;

public class Main extends javax.swing.JFrame {

    static CardLayout cardLayout;
    static boolean successLogIn = false;
    GestionarAlmacen gestionarAlmacen = new GestionarAlmacen();
    PanelCompras panelCompras = new PanelCompras();
    GestionarVentas gestionarVentas = new GestionarVentas();
    private IngresoDialog ingreso;
    private Dimension d;
    
    public Main() {
        initComponents();
        d = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(0,0,d.width,d.height);
        this.setResizable(false);
        cardLayout = (CardLayout)PanelCardLayout.getLayout();
        PanelCardLayout.add(gestionarAlmacen, "Gestionar Almecen");
        PanelCardLayout.add(gestionarVentas, "Gestionar Ventas");
        PanelCardLayout.add(panelCompras, "Gestionar Compras");
   
        cardLayout.show(PanelCardLayout, "Gestionar Ventas");
        
        ingreso = new IngresoDialog(this, true);
        ingreso.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupAlmacen = new javax.swing.ButtonGroup();
        panelGestionar = new javax.swing.JPanel();
        btnGesVentas = new javax.swing.JButton();
        btnGesCompras = new javax.swing.JButton();
        btnGesAlmacen = new javax.swing.JButton();
        labelGestionar = new javax.swing.JLabel();
        btnGesProveedor = new javax.swing.JButton();
        PanelCardLayout = new javax.swing.JPanel();
        panelProveedores = new GestionarProveedores();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Version 1.3");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnGesVentas.setText("Ventas");
        btnGesVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGesVentasActionPerformed(evt);
            }
        });

        btnGesCompras.setText("Compras");
        btnGesCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGesComprasActionPerformed(evt);
            }
        });

        btnGesAlmacen.setText("Almacen");
        btnGesAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGesAlmacenActionPerformed(evt);
            }
        });

        labelGestionar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelGestionar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelGestionar.setText("Gestionar");

        btnGesProveedor.setText("Proveedores");
        btnGesProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGesProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGestionarLayout = new javax.swing.GroupLayout(panelGestionar);
        panelGestionar.setLayout(panelGestionarLayout);
        panelGestionarLayout.setHorizontalGroup(
            panelGestionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGestionarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelGestionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelGestionarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelGestionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGesVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGesCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGesAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGesProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelGestionarLayout.setVerticalGroup(
            panelGestionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGestionarLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(labelGestionar)
                .addGap(36, 36, 36)
                .addComponent(btnGesVentas)
                .addGap(18, 18, 18)
                .addComponent(btnGesCompras)
                .addGap(18, 18, 18)
                .addComponent(btnGesAlmacen)
                .addGap(18, 18, 18)
                .addComponent(btnGesProveedor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelCardLayout.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout panelProveedoresLayout = new javax.swing.GroupLayout(panelProveedores);
        panelProveedores.setLayout(panelProveedoresLayout);
        panelProveedoresLayout.setHorizontalGroup(
            panelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1450, Short.MAX_VALUE)
        );
        panelProveedoresLayout.setVerticalGroup(
            panelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 694, Short.MAX_VALUE)
        );

        /*

        PanelCardLayout.add(panelProveedores, "Proveedores");
        */
        PanelCardLayout.add(new GestionarProveedores(), "Proveedores");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelGestionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelCardLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelCardLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelGestionar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
 
    }//GEN-LAST:event_formWindowClosing

    private void btnGesVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGesVentasActionPerformed
        cardLayout.show(PanelCardLayout, "Gestionar Ventas");
    }//GEN-LAST:event_btnGesVentasActionPerformed

    private void btnGesComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGesComprasActionPerformed
        cardLayout.show(PanelCardLayout, "Gestionar Compras");
    }//GEN-LAST:event_btnGesComprasActionPerformed

    private void btnGesAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGesAlmacenActionPerformed
        cardLayout.show(PanelCardLayout, "Gestionar Almecen");
        gestionarAlmacen.almacenFormaBase();
    }//GEN-LAST:event_btnGesAlmacenActionPerformed
        
    private void btnGesProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGesProveedorActionPerformed
        cardLayout.show(PanelCardLayout, "Proveedores");
    }//GEN-LAST:event_btnGesProveedorActionPerformed
    /*-----------------------METODOS-----------------------------------------*/
    public static void terminarPrograma(){
        System.exit(0);
    }
    /*--------------------Fin de los metodos----------------------------------*/
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCardLayout;
    private javax.swing.JButton btnGesAlmacen;
    private javax.swing.JButton btnGesCompras;
    private javax.swing.JButton btnGesProveedor;
    private javax.swing.JButton btnGesVentas;
    private javax.swing.ButtonGroup btnGroupAlmacen;
    private javax.swing.JLabel labelGestionar;
    private javax.swing.JPanel panelGestionar;
    private javax.swing.JPanel panelProveedores;
    // End of variables declaration//GEN-END:variables
}
