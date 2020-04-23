/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author vival
 */
public class VentasTabla extends javax.swing.JDialog {
    DefaultListModel<VentaDelDia> model;
    FileInputStream fis;
    ObjectInputStream ois;
    /**
     * Creates new form VentasTabla
     */
    public VentasTabla(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        model = new DefaultListModel<VentaDelDia>();
        listSells.setModel(model);
        this.setResizable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listSells = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setText("Regresar");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 560, -1, -1));

        jScrollPane1.setViewportView(listSells);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -3, 800, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        read();
    }//GEN-LAST:event_formWindowOpened
    /*--------------------------METODOS---------------------------------------*/
    /*---------------------------Leer-----------------------------------------*/
    public void read(){
        VentaDelDia p = null;
        VentaDelDia p2 = null;
        VentaDelDia pf = null;
        int i = 0;
        try {
            fis = new FileInputStream("Datos.obj");
            ois = new ObjectInputStream(fis);
            while (true) {
                p = (VentaDelDia) ois.readObject();
                p2 = (VentaDelDia) ois.readObject();
                if (i == 1 && pf != null) {
                    if ((pf.getDate() + pf.getMonth() + pf.getYear()).equals(p.getDate() + p.getMonth() + p.getYear())) {
                            double num1 = pf.getVenta();
                            double num2 = p.getVenta();
                            double suma = num1 + num2;
                        pf = new VentaDelDia(0, suma, pf.getDay(), pf.getDate(), pf.getMonth(), pf.getYear(), pf.getTime());
                        i = 1;
                        if((pf.getDate() + pf.getMonth() + pf.getYear()).equals(p2.getDate() + p2.getMonth() + p2.getYear())){
                            num1 = pf.getVenta();
                            num2 = p2.getVenta();
                            suma = num1 + num2;
                        pf = new VentaDelDia(0, suma, pf.getDay(), pf.getDate(), pf.getMonth(), pf.getYear(), pf.getTime());
                        i = 1;
                        }else{
                            model.addElement(pf);
                            i = 0;
                        }
                    } else {
                        model.addElement(pf);
                        i = 0;
                    }
                }else if(i == 0){
                    if(p != null){
                        if(p2 != null){
                            if ((p.getDate() + p.getMonth() + p.getYear()).equals(p2.getDate() + p2.getMonth() + p2.getYear())) {
                                double num1 = p.getVenta();
                                double num2 = p2.getVenta();
                                double suma = num1 + num2;
                                pf = new VentaDelDia(0, suma, p.getDay(), p.getDate(), p.getMonth(), p.getYear(), p.getTime());
                                i = 1;
                                //model.addElement(pf);
                            } else {
                                if(pf != null){
                                    pf = p2;
                                    i = 1;
                                }
                                model.addElement(p);
                                pf = p2;
                                i = 1;
                            }
                        }
                    }
                }
            }  
        } catch (ClassNotFoundException ioe) {
            JOptionPane.showMessageDialog(this, "ERROR: " + ioe.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }catch(FileNotFoundException fnfe){
            JOptionPane.showMessageDialog(this, "NO se a encontrado ningun archivo de guardado", "Archivo de guardado no encontrado", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
        catch(EOFException eofe){
            if(pf != null && p != null){
                if((pf.getDate() + pf.getMonth() + pf.getYear()).equals(p.getDate() + p.getMonth() + p.getYear())){
                    double num1 = pf.getVenta();
                    double num2 = p.getVenta();
                    double suma = num1 + num2;
                    pf = new VentaDelDia(0, suma, pf.getDay(), pf.getDate(), pf.getMonth(), pf.getYear(), pf.getTime());
                    model.addElement(pf);
                }else{
                    model.addElement(pf);
                    model.addElement(p);
                }
            }else{
                model.addElement(p);
            }
            
        }
        catch (IOException ioe) { 
            JOptionPane.showMessageDialog(this, "ERROR: 1542" + ioe.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } 
        finally{
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(this, "ERROR: 2" + ioe.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    /*-----------------------FIN DE LOS METODOS-------------------------------*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<VentaDelDia> listSells;
    // End of variables declaration//GEN-END:variables
}
