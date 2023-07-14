/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Administrador;

import Modulo_InicioSesion.CrearUsuarioCatedratico;
import Modulo_AsignacionEST.PrincipalAsignacionEST;
import Modulo_InicioSesion.CambiarContraseña;
import Modulo_Prestamos.ModuloPrestamo;
import Modulo_Catedratico.CrearCatedratico;
import Modulo_Estudiante.CrearEstudiante;
import Modulo_Prestamos.ModuloPaquetes;
import Modulo_Ciclo_Escolar.Ciclo_Escolar;
import Modulo_Ciclo_Escolar.CrearCicloEscolar;
import Modulo_Estudiante.MostrarEstudiantes;
import Modulo_InicioSesion.CrearUsuarioAdministrador;
import Modulo_NotasReporte.CrearReporte;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Wilson Xicará
 */
@SuppressWarnings("serial")
public class ModuloPrincipalAdmin extends javax.swing.JFrame {
    private JFrame ventanaPadre;
    private transient Connection conexion;
    private transient ResultSet cAdmin;
    private static final String TAHOMA = "Tahoma";
    
    /**
     * Creates new form ModuloPrincipalAdmin
     */
    public ModuloPrincipalAdmin() {
        initComponents();
    }
    
    public ModuloPrincipalAdmin(Connection conexion, ResultSet cAdmin, JFrame ventanaPadre) throws SQLException{
        initComponents();
        this.conexion = conexion;
        this.cAdmin = cAdmin;
        this.ventanaPadre = ventanaPadre;
        
        // Obtengo los datos del Usuario a mostrar
        Statement sentencia = null;
        try {
            this.setTitle("Sesión Iniciada: "+cAdmin.getString("NombreUsuario"));
            nombre_usuario.setText(cAdmin.getString("NombreUsuario"));
            nombre_completo.setText(cAdmin.getString("Nombres")+ " " + cAdmin.getString("Apellidos"));
            direccion.setText(cAdmin.getString("Direccion"));
            dpi.setText(cAdmin.getString("Dpi"));
            sexo.setText("M".equals(cAdmin.getString("Sexo")) ? "Masculino" : "Femenino");
            // Obtención del Municipio y el Teléfono del Usuario
            sentencia = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultado = sentencia.executeQuery("SELECT Nombre FROM Municipio WHERE Id = " + cAdmin.getString(13));
            municipio.setText(resultado.next() ? resultado.getString(1) : "<No disponible>");
            resultado = sentencia.executeQuery("SELECT Telefono FROM Telefono WHERE Administrador_Id = " + cAdmin.getString(6));
            telefono.setText(resultado.next() ? resultado.getString(1) : "<No asignado>");
            // Otras configuraciones importantes
            this.setLocationRelativeTo(null);
        } catch (SQLException ex) {
            Logger.getLogger(ModuloPrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
			if (sentencia!=null) {
				sentencia.close();
			}
		}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        javax.swing.JPopupMenu.Separator jSeparator1;
        javax.swing.JPopupMenu.Separator jSeparator2;
        javax.swing.JPopupMenu.Separator jSeparator3;
        javax.swing.JPopupMenu.Separator jSeparator4;
        javax.swing.JPanel panel_info_admin;
        javax.swing.JMenu submenu_crear_usuario;
        javax.swing.JMenuBar jMenuBar1;
        javax.swing.JLabel jLabel10;
        javax.swing.JLabel jLabel19;
        javax.swing.JLabel jLabel3;
        javax.swing.JLabel jLabel4;
        javax.swing.JLabel jLabel5;
        javax.swing.JLabel jLabel6;
        javax.swing.JLabel jLabel7;
        javax.swing.JLabel jLabel8;
        javax.swing.JMenuItem item_nuevo_prestamo_paquete;
        javax.swing.JMenuItem item_info_estudiantes;
        javax.swing.JMenuItem item_info_usuarios;
        javax.swing.JMenuItem item_nuevo_ciclo_escolar;
        javax.swing.JMenuItem item_nuevo_paquete_libro;
        javax.swing.JButton cerrar_sesion;
        javax.swing.JButton cambiar_contrasenia;
        javax.swing.JMenuItem item_asignaciones;

        panel_info_admin = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nombre_usuario = new javax.swing.JTextField();
        nombre_completo = new javax.swing.JTextField();
        direccion = new javax.swing.JTextField();
        dpi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        sexo = new javax.swing.JTextField();
        municipio = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        cerrar_sesion = new javax.swing.JButton();
        cambiar_contrasenia = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_crear = new javax.swing.JMenu();
        item_nuevo_ciclo_escolar = new javax.swing.JMenuItem();
        item_nuevo_reporte = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        item_nuevo_estudiante = new javax.swing.JMenuItem();
        item_nuevo_catedratico = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        submenu_crear_usuario = new javax.swing.JMenu();
        item_nuevo_usuario_catedratico = new javax.swing.JMenuItem();
        item_nuevo_usuario_administrador = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        item_nuevo_paquete_libro = new javax.swing.JMenuItem();
        item_nuevo_prestamo_paquete = new javax.swing.JMenuItem();
        menu_ver = new javax.swing.JMenu();
        item_info_estudiantes = new javax.swing.JMenuItem();
        item_info_catedraticos = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        item_info_usuarios = new javax.swing.JMenuItem();
        item_ciclo_escolar = new javax.swing.JMenuItem();
        menu_asignaciones = new javax.swing.JMenu();
        item_asignaciones = new javax.swing.JMenuItem();
        item_reasignaciones = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sesión iniciada: Administrador");
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panel_info_admin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información del Administrdor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font(TAHOMA, 1, 12))); // NOI18N

        jLabel6.setFont(new java.awt.Font(TAHOMA, 0, 12)); // NOI18N
        jLabel6.setText("Nombre de Usuario:");

        jLabel3.setFont(new java.awt.Font(TAHOMA, 0, 12)); // NOI18N
        jLabel3.setText("Nombre completo:");

        jLabel4.setFont(new java.awt.Font(TAHOMA, 0, 12)); // NOI18N
        jLabel4.setText("Dirección:");

        jLabel5.setFont(new java.awt.Font(TAHOMA, 0, 12)); // NOI18N
        jLabel5.setText("DPI:");

        nombre_usuario.setEditable(false);
        nombre_usuario.setFont(new java.awt.Font(TAHOMA, 1, 14)); // NOI18N

        nombre_completo.setEditable(false);
        nombre_completo.setFont(new java.awt.Font(TAHOMA, 1, 14)); // NOI18N

        direccion.setEditable(false);
        direccion.setFont(new java.awt.Font(TAHOMA, 1, 14)); // NOI18N

        dpi.setEditable(false);
        dpi.setFont(new java.awt.Font(TAHOMA, 1, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font(TAHOMA, 0, 12)); // NOI18N
        jLabel7.setText("Sexo:");

        jLabel8.setFont(new java.awt.Font(TAHOMA, 0, 12)); // NOI18N
        jLabel8.setText("Municipio:");

        jLabel10.setFont(new java.awt.Font(TAHOMA, 0, 12)); // NOI18N
        jLabel10.setText("Teléfono:");

        sexo.setEditable(false);
        sexo.setFont(new java.awt.Font(TAHOMA, 1, 14)); // NOI18N

        municipio.setEditable(false);
        municipio.setFont(new java.awt.Font(TAHOMA, 1, 14)); // NOI18N

        telefono.setEditable(false);
        telefono.setFont(new java.awt.Font(TAHOMA, 1, 14)); // NOI18N

        javax.swing.GroupLayout panel_info_adminLayout = new javax.swing.GroupLayout(panel_info_admin);
        panel_info_admin.setLayout(panel_info_adminLayout);
        panel_info_adminLayout.setHorizontalGroup(
            panel_info_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_info_adminLayout.createSequentialGroup()
                .addGroup(panel_info_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_info_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dpi, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombre_completo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(municipio, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(306, Short.MAX_VALUE))
        );
        panel_info_adminLayout.setVerticalGroup(
            panel_info_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_info_adminLayout.createSequentialGroup()
                .addGroup(panel_info_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(nombre_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_info_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_info_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_completo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_info_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_info_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_info_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(municipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_info_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        jLabel19.setFont(new java.awt.Font(TAHOMA, 1, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Bienvenido Administrador");

        cerrar_sesion.setFont(new java.awt.Font(TAHOMA, 1, 14)); // NOI18N
        cerrar_sesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Regresar.png"))); // NOI18N
        cerrar_sesion.setText("Cerrar Sesión");
        cerrar_sesion.setToolTipText("");
        cerrar_sesion.addActionListener(this::cerrar_sesionActionPerformed);

        cambiar_contrasenia.setFont(new java.awt.Font(TAHOMA, 0, 14)); // NOI18N
        cambiar_contrasenia.setText("Cambiar Contraseña");
        cambiar_contrasenia.addActionListener(this::cambiar_contraseniaActionPerformed);

        menu_crear.setText("Crear");
        menu_crear.setPreferredSize(new java.awt.Dimension(40, 19));

        item_nuevo_ciclo_escolar.setText("Ciclo Escolar");
        item_nuevo_ciclo_escolar.addActionListener(this::item_nuevo_ciclo_escolarActionPerformed);
        menu_crear.add(item_nuevo_ciclo_escolar);

        item_nuevo_reporte.setText("Reporte");
        item_nuevo_reporte.addActionListener(this::item_nuevo_reporteActionPerformed);
        menu_crear.add(item_nuevo_reporte);
        menu_crear.add(jSeparator3);

        item_nuevo_estudiante.setText("Nuevo Estudiante");
        item_nuevo_estudiante.addActionListener(e -> {
			try {
				item_nuevo_estudianteActionPerformed(e);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
        menu_crear.add(item_nuevo_estudiante);

        item_nuevo_catedratico.setText("Nuevo Catedrático");
        item_nuevo_catedratico.addActionListener(e -> {
                try {
					item_nuevo_catedraticoActionPerformed(e);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
        });
        menu_crear.add(item_nuevo_catedratico);
        menu_crear.add(jSeparator1);

        submenu_crear_usuario.setText("Usuario");

        item_nuevo_usuario_catedratico.setText("Catedrático");
        item_nuevo_usuario_catedratico.addActionListener(this::item_nuevo_usuario_catedraticoActionPerformed);
        submenu_crear_usuario.add(item_nuevo_usuario_catedratico);

        item_nuevo_usuario_administrador.setText("Administrador");
        item_nuevo_usuario_administrador.addActionListener(this::item_nuevo_usuario_administradorActionPerformed);
        submenu_crear_usuario.add(item_nuevo_usuario_administrador);

        menu_crear.add(submenu_crear_usuario);
        menu_crear.add(jSeparator2);

        item_nuevo_paquete_libro.setText("Paquete Libro");
        item_nuevo_paquete_libro.addActionListener(this::item_nuevo_paquete_libroActionPerformed);
        menu_crear.add(item_nuevo_paquete_libro);

        item_nuevo_prestamo_paquete.setText("Prestamos");
        item_nuevo_prestamo_paquete.addActionListener(this::item_nuevo_prestamo_paqueteActionPerformed);
        menu_crear.add(item_nuevo_prestamo_paquete);

        jMenuBar1.add(menu_crear);

        menu_ver.setText("Ver");
        menu_ver.setPreferredSize(new java.awt.Dimension(40, 19));

        item_info_estudiantes.setText("Información de Estudiantes");
        item_info_estudiantes.addActionListener(this::item_info_estudiantesActionPerformed);
        menu_ver.add(item_info_estudiantes);

        item_info_catedraticos.setText("Información de Catedráticos");
        item_info_catedraticos.addActionListener(e -> {
                try {
					item_info_catedraticosActionPerformed(e);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
        });
        menu_ver.add(item_info_catedraticos);
        menu_ver.add(jSeparator4);

        item_info_usuarios.setText("Información de Usuarios");
        item_info_usuarios.addActionListener(this::item_info_usuariosActionPerformed);
        menu_ver.add(item_info_usuarios);

        item_ciclo_escolar.setText("Ciclo Escolar");
        item_ciclo_escolar.addActionListener(this::item_ciclo_escolarActionPerformed);
        menu_ver.add(item_ciclo_escolar);

        jMenuBar1.add(menu_ver);

        menu_asignaciones.setText("Asignaciones");

        item_asignaciones.setText("Asignar Estudiantes");
        item_asignaciones.addActionListener(e -> {
			try {
				item_asignacionesActionPerformed(e);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
        menu_asignaciones.add(item_asignaciones);

        item_reasignaciones.setText("Reasignar Estudiantes");
        item_reasignaciones.addActionListener(e -> {
			try {
				item_reasignacionesActionPerformed(e);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
        menu_asignaciones.add(item_reasignaciones);

        jMenuBar1.add(menu_asignaciones);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cambiar_contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cerrar_sesion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_info_admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cerrar_sesion, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cambiar_contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(panel_info_admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void item_nuevo_ciclo_escolarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_nuevo_ciclo_escolarActionPerformed
        // Sólo el Administrador Principal tiene permisos para Crear un nuevo Ciclo Escolar
        try {
            if(cAdmin.getString("Tipo").equals("1"))
                new CrearCicloEscolar(this, conexion).setVisible(true);    // Este es un JDialog
            else
                JOptionPane.showMessageDialog(this, "¡No posee los Permisos para realizar esta operación!\nConsulte con el Administrador Principal", "Permisos de Administrador", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se puede comprobar los permisos de su Cuenta de Usuario", "Permisos de Administrador", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ModuloPrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_item_nuevo_ciclo_escolarActionPerformed

    private void item_nuevo_reporteActionPerformed(ActionEvent evt) {//GEN-FIRST:event_item_nuevo_reporteActionPerformed
        this.setEnabled(false);
        CrearReporte nuevoReporte = new CrearReporte(conexion, this);
        nuevoReporte.setVisible(nuevoReporte.getHacerVisible());
    }//GEN-LAST:event_item_nuevo_reporteActionPerformed

    private void item_nuevo_estudianteActionPerformed(ActionEvent evt) throws SQLException {//GEN-FIRST:event_item_nuevo_estudianteActionPerformed
        this.setEnabled(false);
        CrearEstudiante nueva_ventana = new CrearEstudiante(conexion, this);
        nueva_ventana.setVisible(nueva_ventana.getHacerVisible());
    }//GEN-LAST:event_item_nuevo_estudianteActionPerformed

    private void item_nuevo_catedraticoActionPerformed(ActionEvent evt) throws SQLException {//GEN-FIRST:event_item_nuevo_catedraticoActionPerformed
        this.setEnabled(false);
        CrearCatedratico nuevoCat = new CrearCatedratico(conexion, this);
        nuevoCat.setVisible(nuevoCat.getHacerVisible());
    }//GEN-LAST:event_item_nuevo_catedraticoActionPerformed

    private void item_nuevo_usuario_catedraticoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_item_nuevo_usuario_catedraticoActionPerformed
        // Sólo el Administrador Principal tiene permisos para asignarle una Cuenta de Usuario a un Catedrático
        try {
            if(cAdmin.getString("Tipo").equals("1")) {
                this.setEnabled(false);
                CrearUsuarioCatedratico nuevoUserCat = new CrearUsuarioCatedratico(conexion, this);
                nuevoUserCat.setVisible(nuevoUserCat.getHacerVisible());
            }
            else
                JOptionPane.showMessageDialog(this, "¡No posee los Permisos para realizar esta operación!\nConsulte con el Administrador Principal", "Permisos de Administrador", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se puede comprobar los permisos de su Cuenta de Usuario", "Permisos de Administrador", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ModuloPrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_item_nuevo_usuario_catedraticoActionPerformed

    private void item_nuevo_usuario_administradorActionPerformed(ActionEvent evt) {//GEN-FIRST:event_item_nuevo_usuario_administradorActionPerformed
        // Sólo el Administrador Principal tiene permisos para crear un nuevo Adiministrador
        try {
            if(cAdmin.getString("Tipo").equals("1"))
                new CrearUsuarioAdministrador(this, true, conexion, false).setVisible(true);   // Este es un JDialog
            else
                JOptionPane.showMessageDialog(this, "¡No posee los Permisos para realizar esta operación!\nConsulte con el Administrador Principal", "Permisos de Administrador", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se puede comprobar los permisos de su Cuenta de Usuario", "Permisos de Administrador", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ModuloPrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_item_nuevo_usuario_administradorActionPerformed

    private void item_nuevo_paquete_libroActionPerformed(ActionEvent evt) {//GEN-FIRST:event_item_nuevo_paquete_libroActionPerformed
        this.setEnabled(false);
        new ModuloPaquetes(conexion,this).setVisible(true);
    }//GEN-LAST:event_item_nuevo_paquete_libroActionPerformed

    private void item_nuevo_prestamo_paqueteActionPerformed(ActionEvent evt) {//GEN-FIRST:event_item_nuevo_prestamo_paqueteActionPerformed
        this.setEnabled(false);
        new ModuloPrestamo(conexion,this).setVisible(true);
    }//GEN-LAST:event_item_nuevo_prestamo_paqueteActionPerformed

    private void item_info_estudiantesActionPerformed(ActionEvent evt) {//GEN-FIRST:event_item_info_estudiantesActionPerformed
        this.setEnabled(false);
        MostrarEstudiantes nuevaVentana = new MostrarEstudiantes(conexion, this);
        nuevaVentana.setVisible(nuevaVentana.getHacerVisible());
    }//GEN-LAST:event_item_info_estudiantesActionPerformed

    private void item_info_catedraticosActionPerformed(ActionEvent evt) throws SQLException {//GEN-FIRST:event_item_info_catedraticosActionPerformed
        this.setEnabled(false);
        new CrearCatedratico(conexion,this).setVisible(true);
    }//GEN-LAST:event_item_info_catedraticosActionPerformed

    private void item_info_usuariosActionPerformed(ActionEvent evt) {//GEN-FIRST:event_item_info_usuariosActionPerformed
        // Sólo el Administrador Principal tiene permisos para ver las cuentas de usuarios (incluido contraseñas)
        try {
            if(cAdmin.getString("Tipo").equals("1"))
                new ListadoUsuarios(this, conexion).setVisible(true);   // Este es un JDialog
            else
                JOptionPane.showMessageDialog(this, "¡No posee los Permisos para realizar esta operación!\nConsulte con el Administrador Principal", "Permisos de Administrador", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se puede comprobar los permisos de su Cuenta de Usuario", "Permisos de Administrador", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ModuloPrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_item_info_usuariosActionPerformed

    private void item_ciclo_escolarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_item_ciclo_escolarActionPerformed
        // Sólo el Administrador Principal tiene permisos para configurar los Ciclos Escolares
        try {
            if(cAdmin.getString("Tipo").equals("1"))
                new Ciclo_Escolar(new Frame(), true, conexion).setVisible(true); // Este es un JDialog
            else
                JOptionPane.showMessageDialog(this, "¡No posee los Permisos para realizar esta operación!\nConsulte con el Administrador Principal", "Permisos de Administrador", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se puede comprobar los permisos de su Cuenta de Usuario", "Permisos de Administrador", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ModuloPrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_item_ciclo_escolarActionPerformed

    private void item_asignacionesActionPerformed(ActionEvent evt) throws SQLException {//GEN-FIRST:event_item_asignacionesActionPerformed
        this.setEnabled(false);
        PrincipalAsignacionEST asignaciones = new PrincipalAsignacionEST(conexion, this, false);
        asignaciones.setVisible(asignaciones.getHacerVisible());
    }//GEN-LAST:event_item_asignacionesActionPerformed

    private void item_reasignacionesActionPerformed(ActionEvent evt) throws SQLException {//GEN-FIRST:event_item_reasignacionesActionPerformed
        this.setEnabled(false);
        PrincipalAsignacionEST reasignaciones = new PrincipalAsignacionEST(conexion, this, true);
        reasignaciones.setVisible(reasignaciones.getHacerVisible());
    }//GEN-LAST:event_item_reasignacionesActionPerformed

    private void cambiar_contraseniaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cambiar_contraseniaActionPerformed
        new CambiarContraseña(conexion, cAdmin, this, ventanaPadre).setVisible(true);
    }//GEN-LAST:event_cambiar_contraseniaActionPerformed

    private void cerrar_sesionActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cerrar_sesionActionPerformed
        ventanaPadre.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cerrar_sesionActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int opcion = JOptionPane.showOptionDialog(this, "Está seguro que desea cerrar sesión?", "Cerrar sesión", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        boolean cerrarSesion = (opcion == JOptionPane.YES_OPTION);
        ventanaPadre.setVisible(cerrarSesion);
        this.setDefaultCloseOperation(cerrarSesion ? DISPOSE_ON_CLOSE : DO_NOTHING_ON_CLOSE);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(ModuloPrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(()-> {
                new ModuloPrincipalAdmin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField direccion;
    private javax.swing.JTextField dpi;
    private javax.swing.JMenuItem item_ciclo_escolar;
    private javax.swing.JMenuItem item_info_catedraticos;
    private javax.swing.JMenuItem item_nuevo_catedratico;
    private javax.swing.JMenuItem item_nuevo_estudiante;    
    private javax.swing.JMenuItem item_nuevo_reporte;
    private javax.swing.JMenuItem item_nuevo_usuario_administrador;
    private javax.swing.JMenuItem item_nuevo_usuario_catedratico;
    private javax.swing.JMenuItem item_reasignaciones;    
    private javax.swing.JMenu menu_asignaciones;
    private javax.swing.JMenu menu_crear;
    private javax.swing.JMenu menu_ver;
    private javax.swing.JTextField municipio;
    private javax.swing.JTextField nombre_completo;
    private javax.swing.JTextField nombre_usuario;    
    private javax.swing.JTextField sexo;    
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
