/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Ciclo_Escolar;


import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
@SuppressWarnings("serial")
public class Asignar_curso_a_grado extends javax.swing.JDialog {
    transient Connection base;
    private static final String MENSAJECAMBIOS = "Desea guardar los cambios realizados";
    private static final String CAMBIOS = "Cambios";
    String ciclo;
    ArrayList<String> Id_grado;
    ArrayList<String> Id_curso;
    ArrayList<String> Id_catedratico;
   
    ArrayList<String> nombres;
    ArrayList<String> apellidos;
    //Contiene informacion de las relaciones que se tienen en la base
    ArrayList<String> conjunto_actuales;
    ArrayList<String> conjunto_agregados;
    ArrayList<String> conjunto_borrados;
    ArrayList<String[]> id_conjunto_actuales;
    ArrayList<String[]> id_conjunto_agregados;
    ArrayList<String[]> id_conjunto_borrados;
    int posicion =0;
    int pos_cur;
    int pos_cat;
    int pos_tab;
    /**
     * Creates new form Asignar_curso_a_grado
     */
    public Asignar_curso_a_grado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    
    public Asignar_curso_a_grado(java.awt.Frame parent, boolean modal,Connection base, String ciclo) throws SQLException {
        super(parent, modal);
        initComponents();
        this.base = base;
        this.ciclo = ciclo;
        Id_grado = new ArrayList<>();
        Id_curso = new ArrayList<>();
        Id_catedratico = new ArrayList<>();
        id_conjunto_actuales = new ArrayList<>();
        id_conjunto_agregados = new ArrayList<>();
        id_conjunto_borrados = new ArrayList<>();
        conjunto_actuales = new ArrayList<>();
        conjunto_agregados = new ArrayList<>();
        conjunto_borrados = new ArrayList<>();
        pos_cur = 0;
        pos_cat = 0;
        pos_tab= -1;
        //Agrego todos los grados al combobox
        Statement a = null;
        try {
        	a = base.createStatement();
        	ResultSet consulta = a.executeQuery("SELECT  grado.*  FROM asignacioncat INNER JOIN grado ON asignacioncat.Grado_Id = grado.Id INNER JOIN cicloescolar ON asignacioncat.CicloEscolar_Id = cicloescolar.Id WHERE asignacioncat.CicloEscolar_Id = "+ciclo+" AND asignacioncat.Curso_Id is null AND asignacioncat.Catedratico_Id is null;");
            while(consulta.next()){
                String Id = consulta.getString(1);
                String Nombre = consulta.getString(2)+" "+consulta.getString(3);
                Id_grado.add(Id);
                grado.addItem(Nombre);
            }
            
             //obtengo todos los cursos que corresponden al año seleccionado 
                consulta = a.executeQuery("SELECT  curso.Id, curso.Nombre  FROM asignacioncat INNER JOIN cicloescolar ON asignacioncat.CicloEscolar_Id = cicloescolar.Id INNER JOIN curso ON asignacioncat.Curso_Id = Curso.Id WHERE asignacioncat.CicloEscolar_Id = "+ciclo+" AND asignacioncat.Grado_Id is null AND asignacioncat.Catedratico_Id is null;");
                while(consulta.next()){
                    String Id = consulta.getString(1);
                    String Nombre = consulta.getString(2);
                    Id_curso.add(Id);
                    Asig_cursos.addItem(Nombre);
                }
                
                //Obtengo todos los catedraticos existentes
                consulta = a.executeQuery("SELECT catedratico.Id, catedratico.nombres, catedratico.Apellidos FROM catedratico");
                while(consulta.next()){
                    String Id = consulta.getString(1);
                    String Nombre = consulta.getString(2)+" "+consulta.getString(3);
                    Id_catedratico.add(Id);
                    Asig_catedraticos.addItem(Nombre);
                }
		} finally {
			if (a!=null) {
				a.close();
			}
		}
            
            this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent we) {
              // Method is empty
            }

            @Override
            public void windowClosing(WindowEvent we) {
             if(!id_conjunto_agregados.isEmpty() || !id_conjunto_borrados.isEmpty()){
            String[] opciones = new String[2];
            opciones[0] = "SI";
            opciones[1] = "NO";
            //Pregunto si desea guardar los cursos agregados
            int eleccion = JOptionPane.showOptionDialog(null, MENSAJECAMBIOS, CAMBIOS, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            if(eleccion == JOptionPane.YES_OPTION) {
               Guardar_cambios();
               id_conjunto_agregados = new ArrayList<>();
               conjunto_agregados = new ArrayList<>();
               id_conjunto_borrados = new ArrayList<>();
               conjunto_borrados = new ArrayList<>();
               try {
				Actualizar_tabla();
			} catch (SQLException e) {
				e.printStackTrace();
			}
            }
            else{
                id_conjunto_agregados = new ArrayList<>();
               conjunto_agregados = new ArrayList<>();
               id_conjunto_borrados = new ArrayList<>();
               conjunto_borrados = new ArrayList<>();
            }
        }
            }

            @Override
            public void windowClosed(WindowEvent we) {
            	// Method is empty
          }

            @Override
            public void windowIconified(WindowEvent we) {
            	// Method is empty
           }

            @Override
            public void windowDeiconified(WindowEvent we) {
            	// Method is empty
          }

            @Override
            public void windowActivated(WindowEvent we) {
              // Method is empty
            }

            @Override
            public void windowDeactivated(WindowEvent we) {
            	// Method is empty
           }
        });
            
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        javax.swing.JScrollPane jScrollPane1;
        javax.swing.JPanel jPanel1;
        javax.swing.JPanel jPanel2;
        javax.swing.JLabel jLabel3;
        javax.swing.JLabel jLabel2;
        javax.swing.JButton jButton3;
        javax.swing.JButton jButton2;
        javax.swing.JButton jButton5;
        javax.swing.JButton jButton4;
        javax.swing.JLabel jLabel1;
        javax.swing.JButton jButton6;

        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        grado = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Cursos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Asig_catedraticos = new javax.swing.JComboBox<>();
        Asig_cursos = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jButton4.setText("jButton4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Grado:");

        grado.addItemListener(e -> {
                try {
					gradoItemStateChanged(e);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
        });

        jButton2.setText("Regresar");
        jButton2.addActionListener(e -> {
                try {
					jButton2ActionPerformed(e);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cursos Asignados"));

        Cursos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CursosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Cursos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Asignación"));

        jLabel2.setText("Curso :");

        jLabel3.setText("Catedratico :");

        Asig_catedraticos.addItemListener(this::Asig_catedraticosItemStateChanged);

        Asig_cursos.addItemListener(this::Asig_cursosItemStateChanged);
        
        Asig_cursos.addActionListener(this::Asig_cursosActionPerformed);

        jButton3.setText("Asignar");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Asig_catedraticos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Asig_cursos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Asig_cursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Asig_catedraticos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton5.setText("Desasignar");
        jButton5.addActionListener(this::jButton5ActionPerformed);

        jButton6.setText("Guardar");
        jButton6.addActionListener(e -> {
                try {
					jButton6ActionPerformed(e);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(grado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addGap(26, 26, 26)
                        .addComponent(jButton2)
                        .addContainerGap(70, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(grado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton5)
                            .addComponent(jButton6))
                        .addGap(92, 92, 92))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gradoItemStateChanged(java.awt.event.ItemEvent evt) throws SQLException {//GEN-FIRST:event_gradoItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            String[] opciones = new String[2];
            opciones[0] = "SI";
            opciones[1] = "NO";
            if(!conjunto_agregados.isEmpty() || !conjunto_borrados.isEmpty()){
            //Pregunto si desea guardar los cursos agregados
            int eleccion = JOptionPane.showOptionDialog(null, MENSAJECAMBIOS, CAMBIOS, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            if(eleccion == JOptionPane.YES_OPTION) {
                 Guardar_cambios();
                 posicion = grado.getSelectedIndex();
               id_conjunto_agregados = new ArrayList<>();
               conjunto_agregados = new ArrayList<>();
               id_conjunto_borrados = new ArrayList<>();
               conjunto_borrados = new ArrayList<>();
                 Actualizar_tabla();
            }else{
                 id_conjunto_agregados = new ArrayList<>();
               conjunto_agregados = new ArrayList<>();
               id_conjunto_borrados = new ArrayList<>();
               conjunto_borrados = new ArrayList<>();
                 posicion = grado.getSelectedIndex();
                Actualizar_tabla();
            }
            }else{
                id_conjunto_agregados = new ArrayList<>();
               conjunto_agregados = new ArrayList<>();
               id_conjunto_borrados = new ArrayList<>();
               conjunto_borrados = new ArrayList<>();
               posicion = grado.getSelectedIndex();
                Actualizar_tabla(); 
            }
        }
    }//GEN-LAST:event_gradoItemStateChanged

    private void jButton2ActionPerformed(ActionEvent evt) throws SQLException {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        if(!id_conjunto_agregados.isEmpty() || !id_conjunto_borrados.isEmpty()){
            String[] opciones = new String[2];
            opciones[0] = "SI";
            opciones[1] = "NO";
            //Pregunto si desea guardar los cursos agregados
            int eleccion = JOptionPane.showOptionDialog(null, MENSAJECAMBIOS, CAMBIOS, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            if(eleccion == JOptionPane.YES_OPTION) {
               Guardar_cambios();
               id_conjunto_agregados = new ArrayList<>();
               conjunto_agregados = new ArrayList<>();
               id_conjunto_borrados = new ArrayList<>();
               conjunto_borrados = new ArrayList<>();
               Actualizar_tabla();
            }
            else{
                id_conjunto_agregados = new ArrayList<>();
               conjunto_agregados = new ArrayList<>();
               id_conjunto_borrados = new ArrayList<>();
               conjunto_borrados = new ArrayList<>();
            }
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String cursos =(String) Asig_cursos.getSelectedItem();
        String catedratico = (String) Asig_catedraticos.getSelectedItem();
        String prueba = cursos + " " + catedratico;
        if(conjunto_borrados.contains(prueba)){
          int aux = conjunto_borrados.indexOf(prueba);
          id_conjunto_borrados.remove(aux);
          conjunto_borrados.remove(aux);
          DefaultTableModel a = (DefaultTableModel) this.Cursos.getModel();
          String[] b = new String[2];
          b[0] = cursos;
          b[1] = catedratico;
          a.addRow(b);
        }else if(!conjunto_actuales.contains(prueba)){
            if(!conjunto_agregados.contains(prueba)){
                String[] Id = new String[2];
                Id[0] = Id_curso.get(pos_cur);
                Id[1] = Id_catedratico.get(pos_cat);
                String[] a = new String[2];
                a[0] = cursos;
                a[1] = catedratico;
                id_conjunto_agregados.add(Id);
                conjunto_agregados.add(prueba);
                DefaultTableModel  aux = (DefaultTableModel) this.Cursos.getModel();
                aux.addRow(a);
                
            }else{
                 JOptionPane.showMessageDialog(this, "La asignacion ya se ha hecho con anteioridad", "ERROR", JOptionPane.ERROR_MESSAGE, null);
            }
        }else{
             JOptionPane.showMessageDialog(this, "La asignacion ya se ha hecho con anteioridad", "ERROR", JOptionPane.ERROR_MESSAGE, null);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void CursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CursosMouseClicked
        pos_tab = Cursos.getSelectedRow();
    }//GEN-LAST:event_CursosMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(pos_tab != -1){
            String nombre = Cursos.getValueAt(pos_tab, 0) +" "+Cursos.getValueAt(pos_tab, 1);
            if(conjunto_agregados.contains(nombre)){
                int aux = conjunto_agregados.indexOf(nombre);
                conjunto_agregados.remove(aux);
                id_conjunto_agregados.remove(aux);
                DefaultTableModel  a = (DefaultTableModel)Cursos.getModel();
                a.removeRow(pos_tab);
                
            }else{
                int aux = conjunto_actuales.indexOf(nombre);
                conjunto_borrados.add(nombre);
                id_conjunto_borrados.add(id_conjunto_actuales.get(aux));
                DefaultTableModel  a = (DefaultTableModel)Cursos.getModel();
                a.removeRow(pos_tab);
            }
            pos_tab = -1;
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void Asig_cursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Asig_cursosActionPerformed
        
    }//GEN-LAST:event_Asig_cursosActionPerformed

    private void Asig_cursosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Asig_cursosItemStateChanged
        pos_cur = Asig_cursos.getSelectedIndex();
    }//GEN-LAST:event_Asig_cursosItemStateChanged

    private void Asig_catedraticosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Asig_catedraticosItemStateChanged
        pos_cat = Asig_catedraticos.getSelectedIndex();
    }//GEN-LAST:event_Asig_catedraticosItemStateChanged

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_jButton6ActionPerformed
        if(!id_conjunto_agregados.isEmpty() || !id_conjunto_borrados.isEmpty()){
            String[] opciones = new String[2];
            opciones[0] = "SI";
            opciones[1] = "NO";
            //Pregunto si desea guardar los cursos agregados
            int eleccion = JOptionPane.showOptionDialog(null, MENSAJECAMBIOS, CAMBIOS, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            if(eleccion == JOptionPane.YES_OPTION) {
               Guardar_cambios();
               id_conjunto_agregados = new ArrayList<>();
               conjunto_agregados = new ArrayList<>();
               id_conjunto_borrados = new ArrayList<>();
               conjunto_borrados = new ArrayList<>();
               Actualizar_tabla();
            }
            else{
                id_conjunto_agregados = new ArrayList<>();
               conjunto_agregados = new ArrayList<>();
               id_conjunto_borrados = new ArrayList<>();
               conjunto_borrados = new ArrayList<>();
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

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
//            java.util.logging.Logger.getLogger(Asignar_curso_a_grado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }   
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(() -> {
//                Asignar_curso_a_grado dialog = new Asignar_curso_a_grado(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//        });
//    }
    
    public void Actualizar_tabla() throws SQLException{
    	Statement a = null;
        try {
                a = base.createStatement();
                ResultSet consulta = a.executeQuery("SELECT  curso.Nombre , catedratico.nombres, catedratico.Apellidos, curso.Id,catedratico.Id FROM asignacioncat INNER JOIN grado ON asignacioncat.Grado_Id = grado.Id INNER JOIN cicloescolar ON asignacioncat.CicloEscolar_Id = cicloescolar.Id INNER JOIN curso ON asignacioncat.Curso_Id = curso.Id INNER JOIN catedratico ON asignacioncat.Catedratico_Id = catedratico.Id WHERE asignacioncat.CicloEscolar_Id ="+ciclo+" AND asignacioncat.Grado_Id = "+Id_grado.get(posicion)+";");
                DefaultTableModel tabla = new DefaultTableModel();
                tabla.addColumn("Curso");
                tabla.addColumn("Catedratico Asignado");
                String[] filas = new String[2];
                while(consulta.next()){
                    filas[0] = consulta.getString(1);
                    filas[1] = consulta.getString(2)+" "+consulta.getString(3);
                    conjunto_actuales.add(filas[0] + " " + filas[1]);
                    String[] Id = new String[2];
                    Id[0] = consulta.getString(4);
                    Id[1] = consulta.getString(5);
                    id_conjunto_actuales.add(Id);
                    tabla.addRow(filas);
                }
                Cursos.setModel(tabla);
                
            } catch (SQLException ex) {
                Logger.getLogger(Asignar_curso_a_grado.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
				if (a!=null) {
					a.close();
				}
			}
    }
    
    public void Guardar_cambios(){
        try {
            for (int i = 0; i < id_conjunto_agregados.size(); i++) {
                String[] Id = id_conjunto_agregados.get(i);
                String instruccion_asignacion = "INSERT INTO asignacioncat(asignacioncat.CicloEscolar_Id,asignacioncat.Grado_Id,asignacioncat.Curso_Id,asignacioncat.Catedratico_Id) VALUES("+ciclo+","+Id_grado.get(posicion)+","+Id[0]+","+Id[1]+");";
                PreparedStatement pst = null;
                try {
                	pst = base.prepareStatement(instruccion_asignacion);
                	pst.executeUpdate();
            	}finally {
					if (pst!=null) {
						pst.close();
					}
				}
            }
            for (int i = 0; i < id_conjunto_borrados.size(); i++) {
                String[] Id = id_conjunto_borrados.get(i);
                String instruccion_asignacion = "DELETE FROM asignacioncat WHERE asignacioncat.CicloEscolar_Id = "+ciclo+" AND asignacioncat.Grado_Id = "+Id_grado.get(posicion)+" AND asignacioncat.Curso_Id= "+Id[0] +" AND asignacioncat.Catedratico_Id = "+Id[1]+";";
                PreparedStatement pst = null;
                try {
                	pst = base.prepareStatement(instruccion_asignacion);
                	pst.executeUpdate();
                } finally {
					if (pst!=null) {
						pst.close();
					}
				}
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Asignar_curso_a_grado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Asig_catedraticos;
    private javax.swing.JComboBox<String> Asig_cursos;
    private javax.swing.JTable Cursos;
    private javax.swing.JComboBox<String> grado;
    // End of variables declaration//GEN-END:variables
}
