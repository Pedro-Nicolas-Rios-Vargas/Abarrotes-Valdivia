package src;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;

public class Main extends javax.swing.JFrame {
    static String pago = "";
    static boolean pressbar = true, pressbarOptions = true, pressPriceOptions = true;
    static double resultado, ventaDia;
    static ProductoSave ps = new ProductoSave();
    static VentaDelDiaSave vdds = new VentaDelDiaSave();
    static String articuloABuscar = "", articuloABuscarOptions = "";
    static double cambio;
    static int contGlobal = 0, contDiaVenta = 0, codeProducto;
    static Producto producto= null;
    
    DefaultListModel<Producto> model;
    DefaultListModel<Producto> model2;
    DefaultListModel<Producto> model3;
    
    public Main() {
        initComponents();
        this.setResizable(false);
        this.setSize(1280, 720);
        searchBar.requestFocus();
        labelWarning.setVisible(false);
        labelWarning.setForeground(Color.red);
        btnCobrar.setEnabled(false);
        txtCambio.setEditable(false);
        labelMatches.setVisible(false);
        model = new DefaultListModel<Producto>();
        model2 = new DefaultListModel<Producto>();
        model3 = new DefaultListModel<Producto>();
        listBuscar.setModel(model);
        ListaSeleccionada.setModel(model2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        labelWarning = new javax.swing.JLabel();
        txtPago = new javax.swing.JTextField();
        txtCambio = new javax.swing.JTextField();
        btnCobrar = new javax.swing.JButton();
        searchBar = new javax.swing.JTextField();
        scrollSeleccionado = new javax.swing.JScrollPane();
        ListaSeleccionada = new javax.swing.JList<>();
        scrollBuscar = new javax.swing.JScrollPane();
        listBuscar = new javax.swing.JList<>();
        btnClean = new javax.swing.JButton();
        btnSaveExit = new javax.swing.JButton();
        btnAgregarlist2 = new javax.swing.JButton();
        labelMatches = new javax.swing.JLabel();
        btnQuitar = new javax.swing.JButton();
        labelTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnTotal = new javax.swing.JButton();
        btnNewC = new javax.swing.JButton();
        btnMas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnModification = new javax.swing.JButton();
        btnVentasVisual = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

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

        panelMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelWarning.setText("No se permiten letras");
        panelMain.add(labelWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, -1, -1));

        txtPago.setText("$ ");
        txtPago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPagoMouseClicked(evt);
            }
        });
        txtPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPagoKeyTyped(evt);
            }
        });
        panelMain.add(txtPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 554, -1));

        txtCambio.setText("$ ");
        panelMain.add(txtCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 554, -1));

        btnCobrar.setText("Cambio");
        btnCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobrarActionPerformed(evt);
            }
        });
        panelMain.add(btnCobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 554, -1));

        searchBar.setText("Buscar");
        searchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchBarKeyTyped(evt);
            }
        });
        panelMain.add(searchBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 10, 560, -1));

        ListaSeleccionada.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        scrollSeleccionado.setViewportView(ListaSeleccionada);

        panelMain.add(scrollSeleccionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 540, 470));

        listBuscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        scrollBuscar.setViewportView(listBuscar);

        panelMain.add(scrollBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 610, 445));

        btnClean.setText("X");
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });
        panelMain.add(btnClean, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 10, 40, 30));

        btnSaveExit.setText("Salir y Guardar");
        btnSaveExit.setMaximumSize(new java.awt.Dimension(84, 32));
        btnSaveExit.setMinimumSize(new java.awt.Dimension(84, 32));
        btnSaveExit.setPreferredSize(new java.awt.Dimension(84, 32));
        btnSaveExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveExitActionPerformed(evt);
            }
        });
        panelMain.add(btnSaveExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 650, 120, 30));

        btnAgregarlist2.setText("Agregar");
        btnAgregarlist2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarlist2ActionPerformed(evt);
            }
        });
        panelMain.add(btnAgregarlist2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 80, -1));

        labelMatches.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelMatches.setForeground(new java.awt.Color(255, 0, 0));
        labelMatches.setText("Producto no encontrado");
        panelMain.add(labelMatches, new org.netbeans.lib.awtextra.AbsoluteConstraints(857, 490, 170, -1));

        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        panelMain.add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 80, -1));

        labelTotal.setText("Total");
        panelMain.add(labelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, -1, -1));

        txtTotal.setEditable(false);
        txtTotal.setText("$");
        panelMain.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 484, 500, 30));

        btnTotal.setText("Cobrar");
        btnTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalActionPerformed(evt);
            }
        });
        panelMain.add(btnTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 80, -1));

        btnNewC.setText("Nuevo Cliente");
        btnNewC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewCActionPerformed(evt);
            }
        });
        panelMain.add(btnNewC, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 640, 560, -1));

        btnMas.setText("Agregar Frutas/Verduras/Queso");
        btnMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasActionPerformed(evt);
            }
        });
        panelMain.add(btnMas, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 620, 220, -1));

        jLabel1.setText("Pago");
        panelMain.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 540, -1, -1));

        jLabel2.setText("Cambio");
        panelMain.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 610, -1, -1));

        btnDelete.setText("Eliminar Producto");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        panelMain.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 510, 180, -1));

        btnAdd.setText("Agregar Producto");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        panelMain.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 510, 180, -1));

        btnModification.setText("Modificar Producto");
        btnModification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificationActionPerformed(evt);
            }
        });
        panelMain.add(btnModification, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 510, 180, -1));

        btnVentasVisual.setText("Ventas");
        btnVentasVisual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasVisualActionPerformed(evt);
            }
        });
        panelMain.add(btnVentasVisual, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 620, 120, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panelMain.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 650, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 680, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            int x=ps.readAll();
            int v;
            for(int i=1;i<x;i++){
                v=ps.getCode(i);
                if(v==i){
                    contGlobal++;
                }
            }
        } catch (IOException e) {
        }
        //System.out.println(contGlobal);
        printListBuscar();
    }//GEN-LAST:event_formWindowOpened

    private void btnVentasVisualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasVisualActionPerformed
        VentasTabla vt = new VentasTabla(this, true);
        vt.setVisible(true);
    }//GEN-LAST:event_btnVentasVisualActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        saveSales();
        JOptionPane.showMessageDialog(this, "Ocurrió un error o se a cerrado la aplicación de forma abrupta, los datos serán guardados", "TRUCHA", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_formWindowClosing

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        int code = contGlobal + 1;
        AddProducto ap = new AddProducto(this, true);
        ap.setContGlobal(code);
        ap.title(1);
        ap.setTextProducto(searchBar.getText());
        ap.setVisible(true);
        Producto p = ap.getProducto();
        if (p != null) {
            try {
                ps.add(p);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "ERROR: " + ex.getMessage(), "ERROR",JOptionPane.ERROR_MESSAGE);
            }
            contGlobal++;
        }
        btnCleanActionPerformed(evt);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnModificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificationActionPerformed
        producto = null;
        if (model.getSize() != 0 && listBuscar.getSelectedIndex() >= 0) {
            producto = listBuscar.getSelectedValue();
            AddProducto ap = new AddProducto(this, true);
            ap.title(2);
            ap.setProducto(producto);
            ap.setContGlobal(producto.getCode());
            ap.setTextProducto(producto.getNameProduct());
            ap.setTextPrice(String.valueOf(producto.getPrice()));
            ap.setVisible(true);
            Producto p = ap.getProducto();
            if (p != null) {
                try {
                    ps.modification(p);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "ERROR: " + ex.getMessage(), "ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se a seleccionado ningun elemento a modificar", "No se a seleccionado nada", JOptionPane.INFORMATION_MESSAGE);
        }
        btnCleanActionPerformed(evt);
    }//GEN-LAST:event_btnModificationActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int code = producto.getCode();
        String nameProduct = searchBar.getText();
        double price = Double.valueOf(0);
        Producto p = new Producto(code, nameProduct, price, 0);
        btnGuardar.setVisible(false);
        //btnGuardar.setEnabled(false);
        btnCleanActionPerformed(evt);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        Producto p = null;
        if (model.getSize() != 0 && listBuscar.getSelectedIndex() >= 0) {
            p = listBuscar.getSelectedValue();
            int res = JOptionPane.showConfirmDialog(this, "Estas seguro que desea eliminar el producto:\n" + p.toString() + "\npermanentemente?\n", "Eliminar producto",JOptionPane.YES_NO_OPTION);
            if(res == 0){//YES = 0
                try {
                ps.delete(p);
                } catch (IOException ioe) {
                    JOptionPane.showMessageDialog(this, "ERROR: " + ioe.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }else{//NO = 1
                producto = null;
            }
        }else {
            JOptionPane.showMessageDialog(this, "No se a seleccionado ningun elemento a modificar", "No se a seleccionado nada", JOptionPane.INFORMATION_MESSAGE);
        }
        btnCleanActionPerformed(evt);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasActionPerformed
        Producto p;
        Add add = new Add(this, true);
        add.setVisible(true);
        p = add.regresar();
        if(p != null){
            model2.addElement(p);
        }
    }//GEN-LAST:event_btnMasActionPerformed

    private void btnNewCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewCActionPerformed
        if(!txtTotal.getText().equals("$")){
            double x;
            try {
                //System.out.println();
                x = Double.valueOf(txtTotal.getText(1, txtTotal.getText().length()-1));
                ventaDia += x;
                //System.out.println(ventaDia);
            } catch (BadLocationException ex) {
                JOptionPane.showMessageDialog(this, "ERROR: " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            txtTotal.setText("$");
            model2.removeAllElements();
            txtCambio.setText("$");
            txtPago.setText("$");
            txtCambio.setEditable(true);
            txtPago.setEditable(true);
            btnAgregarlist2.setEnabled(true);
        }
    }//GEN-LAST:event_btnNewCActionPerformed

    private void btnTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalActionPerformed
        if(model2.getSize() != 0){
            double sp = sumatoriaPrecios();
            txtTotal.setText("$ " + Double.toString(sp));
        }
    }//GEN-LAST:event_btnTotalActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        if(ListaSeleccionada.getSelectedValue() instanceof Producto){
            model2.removeElementAt(ListaSeleccionada.getSelectedIndex());
            //System.out.println("Jalo");
        }else{
            //System.out.println("No jalo");
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnAgregarlist2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarlist2ActionPerformed
        if(listBuscar.getSelectedValue() instanceof Producto){
            Producto pro = (Producto) listBuscar.getSelectedValue();
            model2.addElement(pro);
            //System.out.println("Jalo");
        }else{
            //System.out.println("No jalo");
        }
    }//GEN-LAST:event_btnAgregarlist2ActionPerformed

    private void btnSaveExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveExitActionPerformed
        int res = JOptionPane.showConfirmDialog(this, "Desea guardar los datos", "Guardar datos",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(res == 0){//YES = 0
            saveSales();
        }else{//NO = 1

        }
        System.exit(0);
    }//GEN-LAST:event_btnSaveExitActionPerformed

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        model.removeAllElements();
        printListBuscar();
        articuloABuscar = "";
        searchBar.setText("Buscar");
        pressbar= true;
        labelMatches.setVisible(false);
        searchBar.requestFocus();
    }//GEN-LAST:event_btnCleanActionPerformed

    private void searchBarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBarKeyTyped
        if (pressbar) {
            searchBar.setText("");
            pressbar = false;
        }
        Producto p = null;
        int i = 1;
        char c = evt.getKeyChar();
        if(c == '\b'){
            if (articuloABuscar.equals("")) {
                searchBar.setText("Buscar");
                pressbar = true;
            } else {
                articuloABuscar = articuloABuscar.substring(0, articuloABuscar.length() - 1);
            }
        }else{
            articuloABuscar = articuloABuscar.concat(String.valueOf(c));
        }
        model.removeAllElements();
        while (i <= contGlobal) {
            try {
                p = ps.readOne(i);
            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(this, "ERROR: " + ioe.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            if(p != null){
                if(p.getNameProduct().toLowerCase().contains(articuloABuscar.toLowerCase())){
                    labelMatches.setVisible(false);
                    model.addElement(p);
                }
            }
            if(model.isEmpty()){
                labelMatches.setVisible(true);
            }
            i++;
        }
    }//GEN-LAST:event_searchBarKeyTyped

    private void btnCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobrarActionPerformed
        double sumatoria = sumatoriaPrecios();
        String resultadoString;
        resultado = validarInt(pago);
        //System.out.println(resultado);
        if(resultado != -1){
            //System.out.println("Entro aqui y no tenia");
            resultadoString = String.valueOf(resultado - sumatoria);
            //System.out.println(resultadoString);
            txtCambio.setText("$" + resultadoString);
            searchBar.setText("Buscar");
            txtCambio.setEditable(false);
            txtPago.setEditable(false);
            btnAgregarlist2.setEnabled(false);
        }else{
            JOptionPane.showMessageDialog(this, "No se encuentran el pago", "Error",JOptionPane.ERROR_MESSAGE);
        }
        btnCobrar.setEnabled(false);
        resultado = 0;
        pago = "";
    }//GEN-LAST:event_btnCobrarActionPerformed

    private void txtPagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoKeyTyped
        char c = evt.getKeyChar();
        if(model2.getSize() != 0){
            if(c >= 48 && c <= 57 || c == 8 || c == '.'){
                pago = pago.concat(Character.toString(c));
                labelWarning.setVisible(false);
                btnCobrar.setEnabled(true);
            }else{
                labelWarning.setVisible(true);
                evt.consume();
            }
        }else{
            evt.consume();
        }
    }//GEN-LAST:event_txtPagoKeyTyped

    private void txtPagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPagoMouseClicked
        if(txtCambio.getDragEnabled() == true){
            if(model2.getSize() != 0){
                pago = "";
                btnCobrar.setEnabled(false);
                txtCambio.setText("$ ");
                txtPago.setText("$ ");
            }
        }
    }//GEN-LAST:event_txtPagoMouseClicked
    /*-----------------------METODOS-----------------------------------------*/
    /*----------------ValidatDouble------------------------------------------*/
    public double validarInt(String validacion){
        try {
            double x;
            x = Double.parseDouble(validacion);
            return x;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    /*----------------------ImprimirListaPrincipal----------------------------*/
    public void printListBuscar(){
        Producto p = null;
        try {
            int x=ps.readAll();
            int v;
            for(int i=1;i<x;i++){
                v=ps.getCode(i);
                if(v==i){
                    try {
                        p = ps.readOne(i);
                        //System.out.println(p.getCode());
                    } catch (IOException ioe) {
                        JOptionPane.showMessageDialog(this, "ERROR: " + ioe.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                    if(p != null){
                        model.addElement(p);
                    }
                }
            }
        } catch (IOException e) {
        }
    }
    /*-----------------------Sumatoria de precios-----------------------------*/
    public double sumatoriaPrecios(){
        double sumatoria = 0;
        for (int i = 0; i < model2.getSize(); i++) {
            Producto pro = (Producto) model2.getElementAt(i);
            sumatoria += pro.getPrice();
        }
        return sumatoria;
    }
    /*-----------------Metodos para hacer la fecha del dia de hoy--------------*/
    public String ventaDelDiaFechaDay(){
        Calendar today = Calendar.getInstance();
        //System.out.println("Today is " + today.getTime());
        
        switch (today.getTime().getDay()) {
            case 0:
                return "Domingo";
            case 1:
                return "Lunes";
            case 2:
               return "Martes";
            case 3:
                return "Miercoles";
            case 4:
                return "Jueves";
            case 5:
                return "Viernes";
            case 6:
                return "Sabado";
            default:
                throw new AssertionError();
        }
    }
    
    public String getDate(){
        Calendar today = Calendar.getInstance();
        return String.valueOf(today.getTime().getDate());
    }
    
    public String getMonth(){
        Calendar today = Calendar.getInstance();
        return String.valueOf(today.getTime().getMonth()+1);
    }
    
    public String getYear(){
        Calendar today = Calendar.getInstance();
        return String.valueOf(today.getTime().getYear()+1900);
    }
    
    public String getTime(){
        Calendar today = Calendar.getInstance();
        return String.valueOf(today.getTime().getHours()) + ":" +
               String.valueOf(today.getTime().getMinutes()) + ":"
               + String.valueOf(today.getTime().getSeconds());
    }
    /*----------------Metodo para guardar las ventas y la fecha---------------*/
    public void saveSales(){
        File file = new File("Datos.obj");
        VentaDelDia vdd = new VentaDelDia(contDiaVenta, ventaDia,
               ventaDelDiaFechaDay(), getDate(), getMonth(), getYear(),
               getTime());
        if (!file.exists()) {
            vdds.AddFirst(vdd);//Si el archivo no existe
        } else {
            vdds.Add(vdd);
        }
    }
    /*--------------------Metodo imprimir lista opciones----------------------*/
    public void printListOptions(){
        Producto p = null;
        try {
            int x=ps.readAll();
            int v;
            for(int i=1;i<x;i++){
                v=ps.getCode(i);
                if(v==i){
                    try {
                        p = ps.readOne(i);
                        //System.out.println(p.getCode());
                    } catch (IOException ioe) {
                        JOptionPane.showMessageDialog(this, "ERROR: " + ioe.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                    if(p != null){
                        model3.addElement(p);
                    }
                }
            }
        } catch (IOException e) {
        }
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
    private javax.swing.JList<Producto> ListaSeleccionada;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAgregarlist2;
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnCobrar;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMas;
    private javax.swing.JButton btnModification;
    private javax.swing.JButton btnNewC;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnSaveExit;
    private javax.swing.JButton btnTotal;
    private javax.swing.JButton btnVentasVisual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelMatches;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelWarning;
    private javax.swing.JList<Producto> listBuscar;
    private javax.swing.JPanel panelMain;
    private javax.swing.JScrollPane scrollBuscar;
    private javax.swing.JScrollPane scrollSeleccionado;
    private javax.swing.JTextField searchBar;
    private javax.swing.JTextField txtCambio;
    private javax.swing.JTextField txtPago;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
