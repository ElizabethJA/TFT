package Modulo_Prestamos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author SERGIO
 */
public class ModuloPaquetes extends javax.swing.JFrame {

    /**
     * Creates new form ModuloPaquetes
     */
    Connection conexcion;
    int contaLibros = 0;
    JFrame Ventanita;
    DefaultTableModel modelo;
    public ModuloPaquetes() {
        initComponents();
    }
    
    public ModuloPaquetes(Connection conec,JFrame ventana){
        
        initComponents();
        this.setLocationRelativeTo(null);
        conexcion = conec;
        modelo = (DefaultTableModel) Libros.getModel();
        Ventanita = ventana;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CodigoPaquete = new javax.swing.JTextField();
        Descripcion = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CodigoLibro = new javax.swing.JTextField();
        Nombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Autor = new javax.swing.JTextField();
        Editorial = new javax.swing.JTextField();
        Estado = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Libros = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Crear Nuevo Paquete");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Codigo del Paquete");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Descripción");

        CodigoPaquete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CodigoPaquete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CodigoPaqueteKeyTyped(evt);
            }
        });

        Descripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Crear Paquete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Agregar Libro");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Borrar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setText("Listado Paquetes");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setText("Regresar Menú Administrador");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Libro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Codigo del Libro");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Nombre");

        CodigoLibro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CodigoLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodigoLibroActionPerformed(evt);
            }
        });
        CodigoLibro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CodigoLibroKeyTyped(evt);
            }
        });

        Nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Autor");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Editorial");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Estado (1-5)");

        Autor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        Editorial.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        Estado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Estado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EstadoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Estado, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(CodigoLibro)
                    .addComponent(Nombre)
                    .addComponent(Autor)
                    .addComponent(Editorial, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(CodigoLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(Autor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(Editorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        Libros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Autor", "Editorial", "Estado"
            }
        ));
        jScrollPane1.setViewportView(Libros);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CodigoPaquete)
                                    .addComponent(Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(29, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CodigoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)))
                .addGap(31, 31, 31)
                .addComponent(jButton6)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CodigoLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodigoLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodigoLibroActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int filas = Libros.getRowCount();
        for (int i = 0;filas>i; i++) {
            modelo.removeRow(0);
        }
        CodigoPaquete.setText("");
        Descripcion.setText("");
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ResultSet librito = null;
        String codLib = CodigoLibro.getText();
        String Nom = Nombre.getText();
        String Aut = Autor.getText();
        String Edit = Editorial.getText();
        String Est = Estado.getText();
        int filas = Libros.getRowCount(), bandera = 0, bandera2 = 0;
        if(contaLibros < 4){
            if((codLib.equals(""))||(Nom.equals(""))||(Aut.equals(""))||(Edit.equals(""))||(Est.equals(""))){
                JOptionPane.showMessageDialog(null, "Hay Campos Vacios");
            }
            else{
                //verificar
                for(int cont = 0; cont < filas; cont++){
                    if(Libros.getValueAt(0, cont).equals(codLib)){
                        bandera = 1;
                    }
                    if(Libros.getValueAt(1, cont).equals(Nom)){
                        bandera2 = 1;
                    }
                }
                if((bandera == 1)&&(bandera2 == 1)){
                    JOptionPane.showMessageDialog(null, "El Codigo y el Nombre del libro ya existe en la tabla");
                }
                else if(bandera == 1){
                    JOptionPane.showMessageDialog(null, "El Codigo del libro ya existe en la tabla");
                }
                else if(bandera2 == 1){
                    JOptionPane.showMessageDialog(null, "El Nombre del libro ya existe en la tabla");
                }
                else{
                    try {
                        Statement sentencia = conexcion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
                        librito = sentencia.executeQuery("SELECT libro.Id FROM libro WHERE libro.Codigo = '" + codLib +"';");
                        if(librito.next() == false){
                            modelo.addRow(new Object[]{codLib,Nom,Aut,Edit,Est});
                            contaLibros++;
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "El Codigo del Libro ya existe en otro paquete");
                        }        
                    } catch (SQLException ex) {
                        Logger.getLogger(ModuloPaquetes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        else{
           JOptionPane.showMessageDialog(null, "No es posible agregar más libros"); 
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String codPaquete = CodigoPaquete.getText();
        String Desc = Descripcion.getText();
        String Instruccion = "", Instruccion2 = "";
        String CodPack, CodLibro, Nom, Aut, Edit, EstadoL;
        ResultSet resultado = null, paquetito = null;
        if(modelo.getRowCount() == 4){
            if((codPaquete.equals(""))||(Desc.equals(""))){
                JOptionPane.showMessageDialog(null, "Hay Campos Vacios");
            }
            else{
                //si se puede crear los libros y el paquete
                try {
                    Statement sentencia = conexcion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
                    resultado = sentencia.executeQuery("SELECT * FROM PaqueteLibro WHERE Codigo = '" + codPaquete + "';");
                    //Condicion que me verifica si no existe un paquete libro con el mismo codigo
                    if(resultado.next() == false){  //Si no existe entonces creará un paquete con ese codigo
                        Instruccion = "INSERT INTO PaqueteLibro (Codigo, Descripcion) VALUES (" + "'" + codPaquete + "'"+ "," + "'" + Desc + "'" + ");";
                        try {
                            
                            PreparedStatement  pst = conexcion.prepareStatement(Instruccion);
                            System.out.println("hace el preparedStatement");
                            int a = pst.executeUpdate();
                            System.out.println("int a");
                            pst.close();
                            System.out.println("pst.close");
                            if (a>0){
                                System.out.println("entra al if a> 0");
                                //JOptionPane.showMessageDialog(null, "¡Se ha Creado el paquete prueba1" + codPaquete + " Exitosamente!");
                                System.out.println("Guardado");
                                //se agregan los libros
                                Statement sentencia2 = conexcion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
                                paquetito = sentencia2.executeQuery("SELECT * FROM paquetelibro WHERE paquetelibro.Codigo = '" + codPaquete + "';");
                                if(paquetito.next() == true){
                                    System.out.println("paquetito true");
                                }
                                else{
                                    System.out.println("paquetito false");
                                }
                                for(int cont = 0; cont < 4; cont++){
                                    System.out.println("Cont" + cont);
                                    CodPack = codPaquete;
                                    CodLibro = Libros.getValueAt(cont, 0).toString();
                                    Nom = Libros.getValueAt(cont, 1).toString();
                                    Aut = Libros.getValueAt(cont, 2).toString();
                                    Edit = Libros.getValueAt(cont,3).toString();
                                    EstadoL = Libros.getValueAt(cont, 4).toString();
                                    //ingresar libros
                                    Instruccion2 = "INSERT INTO libro (libro.Codigo,libro.Nombre,libro.Autor,libro.Editorial,libro.Estado,libro.PaqueteLibro_Codigo) VALUES ('" + CodLibro + "','" + Nom + "','" + Aut + "','" + Edit + "','" + EstadoL + "'," + paquetito.getString(1)+ ");";
                                    int  b;
                                    try (PreparedStatement pst2 = conexcion.prepareStatement(Instruccion2)) {
                                        b = pst2.executeUpdate();
                                        if (b>0){
                                            System.out.println("Entra al if b >0");
                                            System.out.println("Guardado");
                                            //JOptionPane.showMessageDialog(null, "¡El libro "+ CodLibro + " se ha agregado al paquete "+ CodPack + " Exitosamente!");
                                            
                                        }
                                    }
                                }
                                int filas = Libros.getRowCount();
                                for (int i = 0;filas>i; i++) {
                                    modelo.removeRow(0);
                                }
                                JOptionPane.showMessageDialog(null, "¡Se ha Creado el paquete " + codPaquete + " Exitosamente!");
                                //JOptionPane.showMessageDialog(null, "¡Se ha Creado el paquete " + codPaquete + " Exitosamente!");
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(ModuloPaquetes.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error en SQLException: "+ex.getMessage());
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "El Paquete ya existe");
                    }
                } catch (SQLException e) {
                        e.printStackTrace();
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Faltan libros para crear el paquete");
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.setEnabled(false);
        new ListadoPaquetes(conexcion).setVisible(true);
        this.setEnabled(true);
        //this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Ventanita.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        CodigoLibro.setText("");
        Nombre.setText("");
        Autor.setText("");
        Editorial.setText("");
        Estado.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        Ventanita.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void CodigoLibroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CodigoLibroKeyTyped
        // TODO add your handling code here:
        int limite = 5;
        if(CodigoLibro.getText().length() == limite){
            evt.consume();
        }
    }//GEN-LAST:event_CodigoLibroKeyTyped

    private void CodigoPaqueteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CodigoPaqueteKeyTyped
        // TODO add your handling code here:int limite = 5;
        int limite = 5;
        if(CodigoPaquete.getText().length() == limite){
            evt.consume();
        }
    }//GEN-LAST:event_CodigoPaqueteKeyTyped

    private void EstadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EstadoKeyTyped
        // TODO add your handling code here:
        int limite = 1;
        if(Estado.getText().length() == limite){
            evt.consume();
        }
    }//GEN-LAST:event_EstadoKeyTyped

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ModuloPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ModuloPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ModuloPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ModuloPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ModuloPaquetes().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Autor;
    private javax.swing.JTextField CodigoLibro;
    private javax.swing.JTextField CodigoPaquete;
    private javax.swing.JTextField Descripcion;
    private javax.swing.JTextField Editorial;
    private javax.swing.JTextField Estado;
    private javax.swing.JTable Libros;
    private javax.swing.JTextField Nombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
