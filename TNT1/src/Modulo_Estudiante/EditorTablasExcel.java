/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Estudiante;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
public class EditorTablasExcel extends javax.swing.JDialog {
    private DefaultTableModel modelTabla;
    /**
     * Creates new form EditorTablasExcel
     */
    public EditorTablasExcel(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public EditorTablasExcel(java.awt.Frame parent, boolean modal, JTable tabla) {
        super(parent, modal);
        initComponents();
        this.tabla.setModel(tabla.getModel());
//        this.tabla = tabla;
        modelTabla = (DefaultTableModel)tabla.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        nueva_fila_ultima = new javax.swing.JButton();
        nueva_fila_arriba = new javax.swing.JButton();
        nueva_columna_ultima = new javax.swing.JButton();
        nueva_columna_izquierda = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabla.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        nueva_fila_ultima.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nueva_fila_ultima.setText("Agregar fila al final");
        nueva_fila_ultima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nueva_fila_ultimaActionPerformed(evt);
            }
        });

        nueva_fila_arriba.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nueva_fila_arriba.setText("Agregar fila arriba");
        nueva_fila_arriba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nueva_fila_arribaActionPerformed(evt);
            }
        });

        nueva_columna_ultima.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nueva_columna_ultima.setText("Agregar Columna al Final");
        nueva_columna_ultima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nueva_columna_ultimaActionPerformed(evt);
            }
        });

        nueva_columna_izquierda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nueva_columna_izquierda.setText("Agregar Columna a la izquierda");
        nueva_columna_izquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nueva_columna_izquierdaActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Renombrar columna");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nueva_fila_ultima, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nueva_fila_arriba, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nueva_columna_ultima, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nueva_columna_izquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nueva_fila_ultima, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nueva_fila_arriba, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nueva_columna_ultima, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nueva_columna_izquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nueva_fila_ultimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nueva_fila_ultimaActionPerformed
        // Simplemente se agrega una fila vacía al final
        modelTabla.addRow(new String[tabla.getColumnCount()]);
        tabla.setRowSelectionInterval(tabla.getRowCount()-1, tabla.getRowCount()-1);
    }//GEN-LAST:event_nueva_fila_ultimaActionPerformed

    private void nueva_fila_arribaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nueva_fila_arribaActionPerformed
        // La propiedad 'tabla.setCellSelectionEnabled' permite seleccionar sólo celdas (no filas completas)
        int[] rango = tabla.getSelectedRows();
        if (rango.length == 1) {
            // Primero inserto una fila al final
            modelTabla.addRow(new String[tabla.getColumnCount()]);
            // Muevo una fila hacia abajo todos los datos, desde la fila que está seleccionada hasta el penúltimo
            int contFil;
            int contCol = tabla.getColumnCount();
            for(contFil=tabla.getRowCount()-2; contFil>=rango[0]; contFil--)
                for(int col=0; col<contCol; col++)
                    tabla.setValueAt((String)tabla.getValueAt(contFil, col), contFil+1, col);
            
            // Ahora limpio las casillas de la fila seleccionada
            for(int col=0; col<contCol; col++)
                tabla.setValueAt("", rango[0], col);
            /*Vector hola = modelTabla.getDataVector();
            ((Vector)hola.elementAt(0)).elementAt(0);
            */
        } else
            JOptionPane.showMessageDialog(this, "Seleccione sólo una fila", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_nueva_fila_arribaActionPerformed

    private void nueva_columna_ultimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nueva_columna_ultimaActionPerformed
        modelTabla.addColumn("Columna "+(tabla.getColumnCount()+1));
    }//GEN-LAST:event_nueva_columna_ultimaActionPerformed

    private void nueva_columna_izquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nueva_columna_izquierdaActionPerformed
        /*int[] rango = tabla.getSelectedColumns();
        if (rango.length == 1) {
            // Primero inserto la nueva columna al final
            modelTabla.addColumn(tabla.getColumnName(tabla.getColumnCount()-1));
            tabla.getColumn(tabla.getColumnName(tabla.getColumnCount()-1)).setHeaderValue(modelTabla);
            // Muevo una columna hacia la derecha todos los datos, desde la columna que está seleccionada hasta el penúltimo
//            tabla.moveColumn(tabla.getColumnCount()-1, rango[0]);
            int contFil = tabla.getRowCount(), contCol = tabla.getColumnCount(), fil, col;
            for(col=contCol-2; col>=rango[0]; col--) {
//                tabla.getColumnModel().getColumn(col+1).setIdentifier(tabla.getColumnName(col));
                tabla.getColumnModel().getColumn(col+1).setHeaderValue((col==rango[0])?"Columna "+tabla.getColumnCount():tabla.getColumnName(col));
                for(fil=0; fil<contFil; fil++) {
                    tabla.setValueAt((col==rango[0])?"":(String)tabla.getValueAt(fil, col), fil, col+1);
                }
            }
        } else
            JOptionPane.showMessageDialog(this, "Seleccione sólo una celda, a la drecha de la nueva columna.", "Información", JOptionPane.INFORMATION_MESSAGE);
        */
    }//GEN-LAST:event_nueva_columna_izquierdaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int rango[] = tabla.getSelectedColumns();
        if (rango.length == 1) {
            System.out.println("Identificador = "+tabla.getColumn(tabla.getColumnName(rango[0])).getHeaderValue());
            tabla.getColumn(tabla.getColumnName(rango[0])).setHeaderValue(jTextField1.getText());
//            java.awt.event.FocusEvent evt2 = new java.awt.event.FocusEvent(tabla, WIDTH);
            
//            tabla.getColumn(tabla.getColumnName(tabla.getColumnCount()-1)).setHeaderValue(modelTabla);
        } else
            JOptionPane.showMessageDialog(this, "No se puede renombrar varias columnas", "Información", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

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
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(EditorTablasExcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }   
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                EditorTablasExcel dialog = new EditorTablasExcel(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton nueva_columna_izquierda;
    private javax.swing.JButton nueva_columna_ultima;
    private javax.swing.JButton nueva_fila_arriba;
    private javax.swing.JButton nueva_fila_ultima;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}