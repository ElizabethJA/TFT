/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Administrador;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Wilson Xicará
 */
@SuppressWarnings("serial")
public class ListadoUsuarios extends javax.swing.JDialog {
    private transient Connection conexion;
    private static final String TAHOMA = "Tahoma";
    /**
     * Creates new form Prueba
     */
    public ListadoUsuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public ListadoUsuarios(java.awt.Frame parent, Connection conexion) {
        super(parent, true);
        initComponents();
        this.conexion = conexion;
        tabla_usuarios.setShowHorizontalLines(true);
        tabla_usuarios.setShowVerticalLines(true);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings({ })
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        javax.swing.JLabel jLabel2;
        javax.swing.JLabel jLabel3;
        javax.swing.JPanel jPanel1;
        javax.swing.JPanel jPanel2;
        javax.swing.JScrollPane jScrollPane1;
        javax.swing.JButton regresar;

        regresar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        admin_usuario = new javax.swing.JTextField();
        admin_contrasenia = new javax.swing.JPasswordField();
        obtener_lista_usuarios = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_usuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Información de Cuentas de usuario");
        setResizable(false);

        regresar.setFont(new java.awt.Font(TAHOMA, 1, 12)); // NOI18N
        regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.PNG"))); // NOI18N
        regresar.setText("Regresar");
        regresar.addActionListener(this::regresarActionPerformed);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Administrador Principal:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font(TAHOMA, 1, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font(TAHOMA, 1, 14)); // NOI18N
        jLabel2.setText("Usuario:");

        jLabel3.setFont(new java.awt.Font(TAHOMA, 1, 14)); // NOI18N
        jLabel3.setText("Contraseña:");

        admin_usuario.setFont(new java.awt.Font(TAHOMA, 1, 14)); // NOI18N

        admin_contrasenia.setFont(new java.awt.Font(TAHOMA, 1, 14)); // NOI18N

        obtener_lista_usuarios.setFont(new java.awt.Font(TAHOMA, 1, 14)); // NOI18N
        obtener_lista_usuarios.setText("Obtener lista de Usuarios");
        obtener_lista_usuarios.addActionListener(e -> {
			try {
				obtener_lista_usuariosActionPerformed(e);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(obtener_lista_usuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(admin_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(admin_contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(admin_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(admin_contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(obtener_lista_usuarios)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuarios asignados:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font(TAHOMA, 1, 12))); // NOI18N

        tabla_usuarios.setFont(new java.awt.Font(TAHOMA, 1, 14)); // NOI18N
        tabla_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Usuario", "Contraseña", "Tipo de Cuenta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_usuarios.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabla_usuarios.setRowHeight(25);
        tabla_usuarios.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla_usuarios);
        if (tabla_usuarios.getColumnModel().getColumnCount() > 0) {
            tabla_usuarios.getColumnModel().getColumn(0).setPreferredWidth(40);
            tabla_usuarios.getColumnModel().getColumn(1).setPreferredWidth(150);
            tabla_usuarios.getColumnModel().getColumn(2).setPreferredWidth(150);
            tabla_usuarios.getColumnModel().getColumn(3).setPreferredWidth(200);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(regresar))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regresar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void obtener_lista_usuariosActionPerformed(ActionEvent evt) throws SQLException {//GEN-FIRST:event_obtener_lista_usuariosActionPerformed
        DefaultTableModel modelUsuarios = (DefaultTableModel)tabla_usuarios.getModel();
        modelUsuarios.setRowCount(0);  // Borro el contenido de la tabla
        Statement sentencia = null;
        try {
            sentencia = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            ResultSet cUsuarios = sentencia.executeQuery("CALL obtenerListaUsuarios('"+admin_usuario.getText()+"', '"+String.valueOf(admin_contrasenia.getPassword())+"')");
            String tipo = ("1".equals(cUsuarios.getString("Tipo")) ? "Principal" : "Administrador");
            while (cUsuarios.next()) {
                modelUsuarios.addRow(new String[]{
                    ""+(modelUsuarios.getRowCount()+1),
                    cUsuarios.getString("NombreUsuario"),
                    cUsuarios.getString("Contrasenia"),
                    ("3".equals(cUsuarios.getString("Tipo")) ? "Catedrático" : tipo)
                });
            }   // Hasta aquí se garantiza la carga de todas las cuentas de Usuario y su Contraseña (desencriptada).
            if (tabla_usuarios.getRowCount() == 0)  // Si se accede a esta ventana, existe por lo menos la cuenta del Administrador Principal
                JOptionPane.showMessageDialog(this, "El Usuario o la Contraseña son incorrectos.\n\nIngrese correctamente mayúsculas y minúsculas", "Error en datos", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se puede obtener los registros pedidos.\n\nDescripción:\n"+ex.getMessage(), "Error en conexión", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ListadoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
			if (sentencia!=null) {
				sentencia.close();
			}
		}
    }//GEN-LAST:event_obtener_lista_usuariosActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_regresarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }   
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(()-> {
                ListadoUsuarios dialog = new ListadoUsuarios(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField admin_contrasenia;
    private javax.swing.JTextField admin_usuario;
    private javax.swing.JButton obtener_lista_usuarios;
    private javax.swing.JTable tabla_usuarios;
    // End of variables declaration//GEN-END:variables
}
