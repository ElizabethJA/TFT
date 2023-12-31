/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_InicioSesion;

import Conexion.ConectarBD;
import Modulo_Administrador.ModuloPrincipalAdmin;
import Modulo_Catedratico.ModuloPrincipalCatedratico;

import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class IniciarSesion extends javax.swing.JFrame {
    private Connection conexion;
    private String ipServidor;
    /**
     * Creates new form IniciarSesion
     * @throws SQLException 
     * @throws HeadlessException 
     * @throws IOException 
     */
    public IniciarSesion() throws HeadlessException, SQLException, IOException {
        initComponents();
        this.setLocationRelativeTo(null);   // Para centrar esta ventana sobre la pantalla.
        // Antes de iniciar todo, intento realizar la conexión con el servidor donde está la Base de Datos.
        ConectarBD obtenerConexion = new ConectarBD(new javax.swing.JFrame(), true);
        obtenerConexion.setVisible(obtenerConexion.getHacerVisible());
        conexion = obtenerConexion.getConexion();
        if (conexion == null) {
            JOptionPane.showMessageDialog(this, "No se pudo conectar con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        ipServidor = obtenerConexion.getDireccionIPServidor();
        // Después, compruebo si ya existe el Administrador Principal
        try {
            if (!buscar_usuario_principal()) {
                int opcion = JOptionPane.showOptionDialog(this,
                    "Aún no se ha creado el Usuario Principal para el programa.\nEl Usuario Principal es el que tendrá acceso a todas\nlas funcionalidades del sistema.\n\nDesea crearlo ahora?",
                    "Seleccione una opción", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
                if (opcion == JOptionPane.YES_OPTION) {
                    CrearUsuarioAdministrador crearPrincipal = new CrearUsuarioAdministrador(new javax.swing.JFrame(), true, conexion, true);
                    crearPrincipal.setVisible(true);
                    if (!crearPrincipal.isAdministradorPrincipalCreado()) {
                        JOptionPane.showMessageDialog(this, "No se ha definido el Usuario Principal.\nRecuerde crearlo la próxima vez que inicie el programa.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        System.exit(0); // Si no se crea el usuario principal, se cierra el programa
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No se ha definido el Usuario Principal.\nRecuerde crearlo la próxima vez que inicie el programa.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    System.exit(0); // Si no se crea el usuario principal, se cierra el programa
                }
            }
        } catch (SQLException ex) {
            System.out.println("IniciarSesion");
            JOptionPane.showMessageDialog(this, "Error de conexión con la Base de Datos", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0); // En caso de ocurrir un error, cierro el programa
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        javax.swing.JLabel jLabel1;
        javax.swing.JLabel jLabel2;
        javax.swing.JLabel jLabel3;
        javax.swing.JPanel jPanel1;
        javax.swing.JPanel jPanel2;
        javax.swing.JSeparator jSeparator2;
        javax.swing.JSeparator jSeparator1;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        etiqueta_logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        contraseña = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        iniciar_sesion = new javax.swing.JButton();
        panel_minimizar = new javax.swing.JPanel();
        etiqueta_minimizar = new javax.swing.JLabel();
        panel_cerrar = new javax.swing.JPanel();
        etiqueta_cerrar = new javax.swing.JLabel();
        etiqueta_ver_ip_servidor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 500));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 500));

        etiqueta_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiqueta_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo INEB Las Flores.jpg"))); // NOI18N
        etiqueta_logo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                etiqueta_logoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etiqueta_logo, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(etiqueta_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INICIO DE SESIÓN");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel2.setText("USUARIO");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel3.setText("CONTRASEÑA");

        usuario.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        usuario.setText("Admin");
        usuario.setToolTipText("");
        usuario.setBorder(null);
        usuario.setOpaque(false);

        contraseña.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        contraseña.setText("admin");
        contraseña.setToolTipText("");
        contraseña.setBorder(null);
        contraseña.setOpaque(false);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        iniciar_sesion.setBackground(new java.awt.Color(102, 153, 255));
        iniciar_sesion.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        iniciar_sesion.setText("Iniciar Sesión");
        iniciar_sesion.setBorder(null);
        iniciar_sesion.setOpaque(false);
        iniciar_sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciar_sesionActionPerformed(evt);
            }
        });
        iniciar_sesion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                iniciar_sesionKeyPressed(evt);
            }
        });

        panel_minimizar.setBackground(new java.awt.Color(102, 153, 255));

        etiqueta_minimizar.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        etiqueta_minimizar.setForeground(new java.awt.Color(255, 255, 255));
        etiqueta_minimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiqueta_minimizar.setText("_");
        etiqueta_minimizar.setToolTipText("Minimizar");
        etiqueta_minimizar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        etiqueta_minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                etiqueta_minimizarMouseEntered(evt);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                etiqueta_minimizarMouseExited(evt);
            }
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                etiqueta_minimizarMousePressed(evt);
            }
        });

        javax.swing.GroupLayout panel_minimizarLayout = new javax.swing.GroupLayout(panel_minimizar);
        panel_minimizar.setLayout(panel_minimizarLayout);
        panel_minimizarLayout.setHorizontalGroup(
            panel_minimizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etiqueta_minimizar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
        panel_minimizarLayout.setVerticalGroup(
            panel_minimizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etiqueta_minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
        );

        panel_cerrar.setBackground(new java.awt.Color(153, 0, 0));

        etiqueta_cerrar.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        etiqueta_cerrar.setForeground(new java.awt.Color(255, 255, 255));
        etiqueta_cerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiqueta_cerrar.setText("X");
        etiqueta_cerrar.setToolTipText("Cerrar");
        etiqueta_cerrar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        etiqueta_cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                etiqueta_cerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                etiqueta_cerrarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                etiqueta_cerrarMousePressed(evt);
            }
        });

        javax.swing.GroupLayout panel_cerrarLayout = new javax.swing.GroupLayout(panel_cerrar);
        panel_cerrar.setLayout(panel_cerrarLayout);
        panel_cerrarLayout.setHorizontalGroup(
            panel_cerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etiqueta_cerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
        panel_cerrarLayout.setVerticalGroup(
            panel_cerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etiqueta_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
        );

        etiqueta_ver_ip_servidor.setText("Ver IP del Servidor");
        etiqueta_ver_ip_servidor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                etiqueta_ver_ip_servidorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                etiqueta_ver_ip_servidorMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                etiqueta_ver_ip_servidorMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(etiqueta_ver_ip_servidor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panel_minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panel_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(118, 118, 118)
                                        .addComponent(iniciar_sesion, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))))
                                .addGap(0, 109, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usuario, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(contraseña, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiqueta_ver_ip_servidor)
                    .addComponent(panel_minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(iniciar_sesion, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniciar_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciar_sesionActionPerformed
        try {
            iniciar_sesion();
        } catch (SQLException ex) {
            System.out.println("iniciar_sesionActionPerformed");
            JOptionPane.showMessageDialog(this, "Ocurrió un error al intentar conectarse con la Base de Datos.\n"+ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//            Logger.getLogger(IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_iniciar_sesionActionPerformed

    private void iniciar_sesionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_iniciar_sesionKeyPressed
        if(evt.getKeyChar() == '\n'){
            try {
                iniciar_sesion();
            } catch (SQLException ex) {
                System.out.println("iniciar_sesionKeyPressed");
                JOptionPane.showMessageDialog(this, "Ocurrió un error al intentar conectarse con la Base de Datos.\n"+ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//                Logger.getLogger(IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_iniciar_sesionKeyPressed

    private void etiqueta_minimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etiqueta_minimizarMouseEntered
        panel_minimizar.setBackground(new java.awt.Color(0, 0, 255));
    }//GEN-LAST:event_etiqueta_minimizarMouseEntered

    private void etiqueta_minimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etiqueta_minimizarMouseExited
        panel_minimizar.setBackground(new java.awt.Color(102, 153, 255));
    }//GEN-LAST:event_etiqueta_minimizarMouseExited

    private void etiqueta_minimizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etiqueta_minimizarMousePressed
        //        this.setState(ICONIFIED);
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_etiqueta_minimizarMousePressed

    private void etiqueta_cerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etiqueta_cerrarMouseEntered
        panel_cerrar.setBackground(new java.awt.Color(255, 0, 0));
    }//GEN-LAST:event_etiqueta_cerrarMouseEntered

    private void etiqueta_cerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etiqueta_cerrarMouseExited
        panel_cerrar.setBackground(new java.awt.Color(153, 0, 0));
    }//GEN-LAST:event_etiqueta_cerrarMouseExited

    private void etiqueta_cerrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etiqueta_cerrarMousePressed
        System.exit(0);
    }//GEN-LAST:event_etiqueta_cerrarMousePressed

    private void etiqueta_ver_ip_servidorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etiqueta_ver_ip_servidorMouseEntered
        etiqueta_ver_ip_servidor.setFont(new java.awt.Font("Tahoma", 1, 11));
        etiqueta_ver_ip_servidor.setForeground(new java.awt.Color(0, 0, 255));
    }//GEN-LAST:event_etiqueta_ver_ip_servidorMouseEntered

    private void etiqueta_ver_ip_servidorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etiqueta_ver_ip_servidorMouseExited
        etiqueta_ver_ip_servidor.setFont(new java.awt.Font("Tahoma", 0, 11));
        etiqueta_ver_ip_servidor.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_etiqueta_ver_ip_servidorMouseExited

    private void etiqueta_ver_ip_servidorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etiqueta_ver_ip_servidorMousePressed
        JOptionPane.showMessageDialog(this, "Dirección IP del Servidor:\n\n"+ipServidor, "Información", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_etiqueta_ver_ip_servidorMousePressed

    private void etiqueta_logoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etiqueta_logoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_etiqueta_logoMouseClicked

    private void iniciar_sesion() throws SQLException {
        Statement sentencia = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        String contraseña_entrada = String.valueOf(contraseña.getPassword()), usuario_entrada = usuario.getText();
        String tipoEnBD;
        ResultSet cUsuarios = sentencia.executeQuery("CALL obtenerUsuario('"+usuario_entrada+"', '"+contraseña_entrada+"')");
        if(cUsuarios.next()) {  // El Usuario y la Contraseña son correctos
            tipoEnBD = cUsuarios.getString(4);
            if(tipoEnBD.equals("3")) {  // Se inicia sesión como Catedrático
                this.setVisible(false);
                new ModuloPrincipalCatedratico(conexion, this, cUsuarios).setVisible(true);
            }
            else {  // Se inicia sesión como Administrador (Principal o Secundarios)
                ResultSet cAdmin = sentencia.executeQuery("SELECT * FROM Usuarios U INNER JOIN Administrador A ON U.Administrador_Id = A.Id WHERE U.Administrador_Id = " + cUsuarios.getString(6)+";");
                cAdmin.next();
                this.setVisible(false);
                new ModuloPrincipalAdmin(conexion, cAdmin, this).setVisible(true);
            }
            usuario.setText("");
            contraseña.setText("");
        } else
            JOptionPane.showMessageDialog(this, "El Usuario o la Contraseña son incorrectos.", "Iniciar sesión", JOptionPane.ERROR_MESSAGE);
    }
    
    private boolean buscar_usuario_principal() throws SQLException {
        Statement sentencia = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        ResultSet cAdmin = sentencia.executeQuery("SELECT COUNT(Id) Admins FROM Administrador");
        cAdmin.next();
        return (cAdmin.getInt(1) != 0);
    }
    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println("main");
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }   
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(()-> {
                try {
					new IniciarSesion().setVisible(true);
				} catch (HeadlessException | SQLException | IOException e) {
					e.printStackTrace();
				}            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField contraseña;
    private javax.swing.JLabel etiqueta_cerrar;
    private javax.swing.JLabel etiqueta_logo;
    private javax.swing.JLabel etiqueta_minimizar;
    private javax.swing.JLabel etiqueta_ver_ip_servidor;
    private javax.swing.JButton iniciar_sesion;
    private javax.swing.JPanel panel_cerrar;
    private javax.swing.JPanel panel_minimizar;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
