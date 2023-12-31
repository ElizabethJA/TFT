/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_AsignacionEST;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

/**
 * Clase que permite crear UNA ASIGNACIÓN O UNA REASIGNACIÓN PARA UN ESTUDIANTE. Para ello, se evalúa si la Asignación que
 * se quiere crear ya existe (que exista un registro de Asignación correspondiente al Ciclo Escolar seleccionado).
 * Al seleccionar un Ciclo en (JComboBox)ciclo_escolar se evalúa que dicho ciclo esté Listo y no esté Cerrado; en caso
 * contrario no se podrá crear la Asignación. En último caso, sólo queda evaluar que la Asignación no se intente en un
 * ciclo escolar anterior a uno que ya tenga el estudiante.
 * @author Wilson Xicará
 */
@SuppressWarnings("serial")
public class AsignarEstudiante extends javax.swing.JDialog {
    private transient Connection conexion;
    private static final String TAHOMA = "Tahoma";
    private static final String ERRORCONEXION = "Error en conexión";
    private static final String CREARASIGNACION = "Crear Asignación";
    private boolean hacerVisible;
    private boolean paraReasignacion;
    private boolean ciclosCargados;
    private boolean gradosCargados;
    private boolean asignacionCreada;
    private int idEstudiante;
    private ArrayList<Integer> listaIDCiclos;
    private ArrayList<Integer> listaIDGrados;
    private ArrayList<Boolean> listaCicloListo;
    private ArrayList<Boolean> listaCicloCerrado;
    /**
     * Creates new form AsignacionEST
     */
    public AsignarEstudiante(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    /**
     * Inicia la ventana para crear la Asignación o Reasignación del Estudiante seleccionado desde PrincipalAsignaciónEST.
     * Obtiene el listado de Ciclos Escolares y el estado de los mismos (Listo y/o Cerrado).
     * @param parent
     * @param conexion objeto que permite la conexión con la Base de Datos.
     * @param paraReasignacion booleano que indica si se llama a esta ventana para Asignación o Reasignación.
     * @param idEstudiante entero que indica el ID del Estudiante al que se le creará la Asignación.
     * @param codigoPersonal información del Estudiante.
     * @param nombreCompleto información del Estudiante.
     * @throws SQLException 
     */
    public AsignarEstudiante(java.awt.Frame parent, Connection conexion, boolean paraReasignacion, int idEstudiante, String codigoPersonal, String nombreCompleto) throws SQLException {
        super(parent, true);
        initComponents();
        this.conexion = conexion;
        this.paraReasignacion = paraReasignacion;
        this.idEstudiante = idEstudiante;
        ciclosCargados = gradosCargados = false;
        hacerVisible = !(asignacionCreada); // Inicialmente se mostrará la ventana, y no se ha creado la Asignación
        
        // Obtengo los datos necesarios desde la Base de Datos
        Statement sentencia = null;
        try {
            sentencia = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            ResultSet cConsulta;
            // Obtengo el listado de Ciclos Escolares de los cuales se puede buscar y crear Asignaciones
            cConsulta = sentencia.executeQuery("SELECT Id, Anio, Listo, Cerrado FROM CicloEscolar");
            listaIDCiclos = new ArrayList<>();
            listaCicloListo = new ArrayList<>();
            listaCicloCerrado = new ArrayList<>();
            listaIDGrados = new ArrayList<>();
            while (cConsulta.next()) {
                listaIDCiclos.add(cConsulta.getInt("Id"));
                listaCicloListo.add(cConsulta.getBoolean("Listo"));
                listaCicloCerrado.add(cConsulta.getBoolean("Cerrado"));
                ciclo_escolar.addItem(cConsulta.getString("Anio"));
            } ciclosCargados = true;
            ciclo_escolar.setSelectedIndex(-1);
            ciclo_escolar.setSelectedIndex(ciclo_escolar.getItemCount()-1);
            etiqueta_codigo_personal.setText(codigoPersonal);
            etiqueta_nombre_completo.setText(nombreCompleto);
            this.setLocationRelativeTo(null);   // Para centrar esta ventana sobre la pantalla.
        } catch (SQLException ex) {
            hacerVisible = false;
            JOptionPane.showMessageDialog(this, "No se pudo obtener algunos datos necesarios.\n\nDescripción:\n"+ex.getMessage(), ERRORCONEXION, JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(AsignarEstudiante.class.getName()).log(Level.SEVERE, null, ex);
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
        javax.swing.JScrollPane jScrollPane2;
        javax.swing.JLabel jLabel6;
        javax.swing.JLabel jLabel5;
        javax.swing.JLabel jLabel4;
        javax.swing.JLabel jLabel1;
        javax.swing.JLabel jLabel2;
        javax.swing.JLabel jLabel3;

        jLabel2 = new javax.swing.JLabel();
        ciclo_escolar = new javax.swing.JComboBox<>();
        grado = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        crear_asignacion = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_info_cursos = new javax.swing.JTable();
        etiqueta_aviso = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        etiqueta_codigo_personal = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        etiqueta_nombre_completo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Asignación de Estudiantes");

        jLabel2.setFont(new java.awt.Font(TAHOMA, 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ciclo escolar:");
        jLabel2.setOpaque(true);

        ciclo_escolar.setFont(new java.awt.Font(TAHOMA, 0, 14)); // NOI18N
        ciclo_escolar.addItemListener(e -> {
                try {
					ciclo_escolarItemStateChanged(e);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
        });

        grado.setFont(new java.awt.Font(TAHOMA, 0, 14)); // NOI18N
        grado.addItemListener(e ->{
        	try {
				gradoItemStateChanged(e);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
        });

        jLabel3.setFont(new java.awt.Font(TAHOMA, 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Grado:");
        jLabel3.setOpaque(true);

        crear_asignacion.setFont(new java.awt.Font(TAHOMA, 1, 16)); // NOI18N
        crear_asignacion.setText(CREARASIGNACION);
        crear_asignacion.addActionListener(e -> {
                try {
					crear_asignacionActionPerformed(e);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
        });

        tabla_info_cursos.setFont(new java.awt.Font(TAHOMA, 0, 14)); // NOI18N
        tabla_info_cursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Nombre"
            }
        ) {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_info_cursos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabla_info_cursos.setRowHeight(25);
        tabla_info_cursos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabla_info_cursos);
        if (tabla_info_cursos.getColumnModel().getColumnCount() > 0) {
            tabla_info_cursos.getColumnModel().getColumn(0).setPreferredWidth(40);
            tabla_info_cursos.getColumnModel().getColumn(1).setPreferredWidth(350);
        }

        etiqueta_aviso.setFont(new java.awt.Font(TAHOMA, 1, 10)); // NOI18N
        etiqueta_aviso.setOpaque(true);

        jLabel1.setFont(new java.awt.Font(TAHOMA, 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Información del Estudiante:");

        jLabel4.setFont(new java.awt.Font(TAHOMA, 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Código Personal:");

        etiqueta_codigo_personal.setBackground(new java.awt.Color(255, 255, 255));
        etiqueta_codigo_personal.setFont(new java.awt.Font(TAHOMA, 1, 12)); // NOI18N
        etiqueta_codigo_personal.setOpaque(true);

        jLabel6.setFont(new java.awt.Font(TAHOMA, 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Nombre completo:");

        etiqueta_nombre_completo.setBackground(new java.awt.Color(255, 255, 255));
        etiqueta_nombre_completo.setFont(new java.awt.Font(TAHOMA, 1, 12)); // NOI18N
        etiqueta_nombre_completo.setOpaque(true);

        jLabel5.setFont(new java.awt.Font(TAHOMA, 1, 12)); // NOI18N
        jLabel5.setText("Cursos del Grado seleccionado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ciclo_escolar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(etiqueta_aviso)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(grado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiqueta_codigo_personal, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etiqueta_nombre_completo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(crear_asignacion, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ciclo_escolar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiqueta_aviso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(crear_asignacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_nombre_completo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiqueta_codigo_personal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Acción que se ejecuta cuando se selecciona un nuevo ciclo escolar. Para ello, se obtiene todos los Grados asignados
     * al ciclo escolar seleccionado y se carga en (JComboBox)grado. Además, notifica el estado del Ciclo (Listo y/o Cerrado)
     * e inhabilita el botón 'crear_asignacion' en caso de que no se pueda asignar el Estudiante al Ciclo seleccionado.
     * @param evt 
     * @throws SQLException 
     */
    private void ciclo_escolarItemStateChanged(ItemEvent evt) throws SQLException {//GEN-FIRST:event_ciclo_escolarItemStateChanged
        // Al seleccionar un nuevo ciclo escolar se deben actualizar 'grado' con los grados del ciclo seleccionado
        int indexCiclo = ciclo_escolar.getSelectedIndex();  // Obtengo el item seleccionado
        if (ciclosCargados && indexCiclo != -1) {
            grado.removeAllItems();
            listaIDGrados.clear();
            gradosCargados = false;
            // Al cambiar de ciclo, cambia de grados y por tanto de cursos. Elimino los cursos de la búsqueda anterior
            ((DefaultTableModel)tabla_info_cursos.getModel()).setRowCount(0);
            Statement sentencia = null;
            try {   // Obtengo todos los grados del ciclo escolar seleccionado
                sentencia = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
                ResultSet cGrados = sentencia.executeQuery("SELECT AsignacionCAT.Grado_Id idGrado, Grado.Nombre Grado, Grado.Seccion FROM AsignacionCAT "
                    + "INNER JOIN Grado ON AsignacionCAT.Grado_Id = Grado.Id "
                    + "WHERE AsignacionCAT.CicloEscolar_Id = "+listaIDCiclos.get(indexCiclo)+" "
                    + "GROUP BY AsignacionCAT.Grado_Id");
                while (cGrados.next()) {
                    listaIDGrados.add(cGrados.getInt("idGrado"));
                    grado.addItem(cGrados.getString("Grado")+" "+cGrados.getString("Seccion"));
                } gradosCargados = true;
                grado.setSelectedIndex(-1);
                grado.setSelectedIndex(grado.getItemCount()-1);
                // Notifico si el Ciclo Escolar está o no Listo y/o Cerrado
                String estado = (Boolean.FALSE.equals(listaCicloListo.get(indexCiclo))?"no Listo":"Cerrado");
                etiqueta_aviso.setText((!listaCicloListo.get(indexCiclo) || listaCicloCerrado.get(indexCiclo)) ?
                    "No se puede Crear la Asignación. Ciclo Escolar "+ estado : "");
                
                // Se puede crear la Asignación sí y sólo si el Ciclo está Listo y no está Cerrado
                crear_asignacion.setEnabled(listaCicloListo.get(indexCiclo) && !listaCicloCerrado.get(indexCiclo));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo obtener los Grados del Ciclo.\n\nDescripción:\n"+ex.getMessage(), ERRORCONEXION, JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(AsignarEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
				if (sentencia!=null) {
					sentencia.close();
				}
			}
        }
    }//GEN-LAST:event_ciclo_escolarItemStateChanged
    /**
     * Acción que se ejecuta cuando se selecciona un nuevo Grado, perteneciente al Ciclo Escolar seleccionado. Para ello,
     * se obtiene todos los Cursos asignados al grado seleccionado y se carga en (JTable)tabla_info_cursos.
     * @param evt 
     * @throws SQLException 
     */
    private void gradoItemStateChanged(ItemEvent evt) throws SQLException {//GEN-FIRST:event_gradoItemStateChanged
        // Al seleccionar un nuevo grado se deben actualizar los cursos que se le ha asignado
        int indexGrado = grado.getSelectedIndex();
        if (gradosCargados && indexGrado != -1) {
            int indexCiclo = ciclo_escolar.getSelectedIndex();
            // Obtengo el listado de Cursos del Ciclo Escolar y Grado seleccionados
            Statement sentencia = null;
            try {
                sentencia = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
                ResultSet cCursos = sentencia.executeQuery("SELECT Curso.Nombre Curso FROM AsignacionCAT "
                    + "INNER JOIN Curso ON AsignacionCAT.Curso_Id = Curso.Id "
                    + "WHERE AsignacionCAT.CicloEscolar_Id = "+listaIDCiclos.get(indexCiclo)+" AND AsignacionCAT.Grado_Id = "+listaIDGrados.get(indexGrado));
                DefaultTableModel modelCursos = (DefaultTableModel)tabla_info_cursos.getModel();
                modelCursos.setRowCount(0);
                while (cCursos.next())
                	modelCursos.addRow(new String[]{
                			""+(modelCursos.getRowCount()+1),
                			cCursos.getString("Curso")
                	});
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo obtener los Cursos del Grado.\n\nDescripción:\n"+ex.getMessage(), ERRORCONEXION, JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(AsignarEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
				if (sentencia!=null) {
					sentencia.close();
				}
			}
        }
    }//GEN-LAST:event_gradoItemStateChanged
    /**
     * Acción que permite Asignar al Estudiante en el Ciclo y Grado seleccionados. Para ello, evalúa que:
     * - El Estudiante no tenga una Asignación en el ciclo seleccionado (sin importar el grado).
     * - La Asignación no sea en un Ciclo Escolar anterior a uno que ya tenga.
     * @param evt 
     * @throws SQLException 
     */
    private void crear_asignacionActionPerformed(ActionEvent evt) throws SQLException {//GEN-FIRST:event_crear_asignacionActionPerformed
        // Hasta este punto ya se ha comprobado que el Ciclo Escolar esté Listo y que no esté Cerrado. Lo último por
        // es que el Estudiante no tenga una Asignación igual a la que se intentará crear o que el ciclo al que se le quiere
        // asignar no sea anterior a uno que ya tenga
        int idCiclo = listaIDCiclos.get(ciclo_escolar.getSelectedIndex());
        Statement sentencia = null;
        try {
            sentencia = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            ResultSet cConsulta;
            int crearAsignacion = JOptionPane.YES_OPTION;   // Inicialmente asumo que es una Asignación Nueva
            // Verifico cuántas Asignaciones ya ha tenido el Estudiante (si son más de 0 entonces es una Reasignación y evalúo los casos)
            cConsulta = sentencia.executeQuery("SELECT COUNT(Id) FROM AsignacionEST WHERE Estudiante_Id = "+idEstudiante);
            cConsulta.next();
            if (cConsulta.getInt(1) > 0) {  // Es una Reasignación. Evalúo los casos
                // Los casos no aceptables son:
                // (1) Que se intente asignar a un Ciclo Escolar al que ya fue Asignado
                // (2) Que se intente asignar a un Ciclo Escolar anterior a uno que ya fue asignado
                cConsulta = sentencia.executeQuery("SELECT COUNT(Id) FROM AsignacionEST WHERE CicloEscolar_Id = "+idCiclo+" AND Estudiante_Id = "+idEstudiante);
                cConsulta.next();   // Caso (1)
                if (cConsulta.getInt(1) > 0) {  // Ya tiene una Asignación en el Ciclo Escolar seleccionado (puede que en diferente grado)
                    crearAsignacion = JOptionPane.NO_OPTION;
                    JOptionPane.showMessageDialog(this, "El Estudiante ya fue asignado al Ciclo "+(String)ciclo_escolar.getSelectedItem(), CREARASIGNACION, JOptionPane.ERROR_MESSAGE);
                } else {
                    cConsulta = sentencia.executeQuery("SELECT MAX(Anio) FROM AsignacionEST "
                        + "INNER JOIN CicloEscolar ON AsignacionEST.CicloEscolar_Id = CicloEscolar.Id "
                        + "WHERE Estudiante_Id = "+idEstudiante);
                    cConsulta.next();   // Caso (2)
                    // En la Base de Datos, los Ciclos Escolares son cantidades enteras:
                    if (Integer.parseInt((String)ciclo_escolar.getSelectedItem()) < cConsulta.getInt(1)) {
                        crearAsignacion = JOptionPane.NO_OPTION;
                        JOptionPane.showMessageDialog(this, "El Estudiante no puede ser Asignado al Ciclo "+(String)ciclo_escolar.getSelectedItem()+" pues es anterior\na una de sus Asignaciones pasadas.", CREARASIGNACION, JOptionPane.ERROR_MESSAGE);
                    }
                }
            }   // Hasta aquí ya se ha evaluado si se puede o no crear la Reasignación
            if (crearAsignacion == JOptionPane.YES_OPTION) {    // Pido confirmación de realizar la Asignación
                crearAsignacion = JOptionPane.showOptionDialog(this,
                    "Se creará la "+((paraReasignacion)?"Rea":"A")+"signación de "+etiqueta_nombre_completo.getText()+":"
                    + "\nCiclo:  "+(String)ciclo_escolar.getSelectedItem()+""
                    + "\nGrado:  "+(String)grado.getSelectedItem()+""
                    + "\n\nEstá seguro que desea continuar?",
                    "Confirmar Asignación", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            }
            if (crearAsignacion == JOptionPane.YES_OPTION) {    // Se creará la Asignación
                String nuevaAsignacion = "INSERT INTO AsignacionEst(CicloEscolar_Id, Grado_Id, Estudiante_Id) VALUES("
                        + idCiclo+", "+listaIDGrados.get(grado.getSelectedIndex())+", "+idEstudiante+")";
                PreparedStatement st = null;
                try{
                	st = (PreparedStatement) conexion.prepareStatement(nuevaAsignacion);
                	st.executeUpdate(); // Inserto y actulizoç
                }finally {
					if (st!=null) {
						st.close();
					}
				}
                JOptionPane.showMessageDialog(this, "Asignación creada exitosamente", CREARASIGNACION, JOptionPane.INFORMATION_MESSAGE);
                // Procedo a cerrar esta ventana
                asignacionCreada = true;
                this.dispose();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo completar la Asginación.\n\nDescripción:\n"+ex.getMessage(), ERRORCONEXION, JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(AsignarEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
			if (sentencia!=null) {
				sentencia.close();
			}
		}
    }//GEN-LAST:event_crear_asignacionActionPerformed

    /**
     * Función que devuelve el valor de 'hacerVisible'. Al obtener datos desde la Base de Datos pueden surgir errores de
     * conexión o con la instrucción SQL por lo que puede arrojar valores erróneos o generar problemas mayores, por lo que
     * se controla y notifica en 'hacerVisible'.
     * @return 'true' si no ocurrió algún problema al intentar obtener datos desde la Base de Datos; 'false' en caso contrario.
     */
    public boolean getHacerVisible() { return hacerVisible; }
    /**
     * Función que devuelve si se creó la Asignación del Estudiante seleccionado.
     * @return 'true' si la Asignación fue creada con éxito; 'false' en caso contrario.
     */
    public boolean getAsignacionCreada() { return asignacionCreada; }
    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
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
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AsignarEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(() -> {
//                AsignarEstudiante dialog = new AsignarEstudiante(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ciclo_escolar;
    private javax.swing.JButton crear_asignacion;
    private javax.swing.JLabel etiqueta_aviso;
    private javax.swing.JLabel etiqueta_codigo_personal;
    private javax.swing.JLabel etiqueta_nombre_completo;
    private javax.swing.JComboBox<String> grado;
    private javax.swing.JTable tabla_info_cursos;
    // End of variables declaration//GEN-END:variables
}
