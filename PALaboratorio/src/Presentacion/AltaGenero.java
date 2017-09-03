package Presentacion;

import Persistencia.BDGenero;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AltaGenero extends javax.swing.JInternalFrame {

    public AltaGenero() throws SQLException {
        initComponents();
        BDGenero datos = new BDGenero(); // creo una instancia de bdgenero y la llamo datos

        //datos.ActualizarTablaGenero(tabla);//llamo a la funcion llenar genero que se encuentra en esa instancia datos , y le paso la lista de generros para que me la llene 
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        ninguno = new javax.swing.JCheckBox();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setTitle("Alta de género");

        jLabel1.setText("genero");

        ninguno.setText("Ninguno");
        ninguno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ningunoActionPerformed(evt);
            }
        });

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(jLabel1)
                            .addGap(26, 26, 26)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(btnguardar)
                                .addGap(26, 26, 26)
                                .addComponent(btncancelar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(ninguno)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(ninguno)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar)
                    .addComponent(btncancelar))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed

        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed

        if ("".equals(txtnombre.getText())) // pregunto si la caja de texto es vacia 
        {
            JOptionPane.showMessageDialog(null, "No deje campos vacios", "Cheeee", JOptionPane.INFORMATION_MESSAGE);
        } else {

            if (ninguno.isSelected() == true) { // pregunto si esta checkjeado ninguno

                BDGenero datos = new BDGenero(); //creo una intancia de bd genero 
                if (datos.insertar_genero(txtnombre.getText()) == true) // llamo a insertar genero , pasandole el textbox y si medevuelve tru ( osea que guardo), tiro cartel y rellen o la lista 
                {

                    JOptionPane.showMessageDialog(null, "Genero Padre Agregado Correctamente", "Cheeee", JOptionPane.INFORMATION_MESSAGE);

                    datos.ActualizarTablaGenero(tabla);//llamo a la funcion llenar genero que se encuentra en esa instancia datos , y le paso la lista de generros para que me la llene 
                } else {

                    JOptionPane.showMessageDialog(null, "No se pudo guardar el dato", "Error", JOptionPane.INFORMATION_MESSAGE);

                }

            } else {
                DefaultTableModel mi = (DefaultTableModel) this.tabla.getModel();
                int i = tabla.getSelectedRow();
                if (i == -1) {
                    JOptionPane.showMessageDialog(null, "Seleccione una fila");
                } else//de lo contrario si se selecciono la fila
                {

                    BDGenero datos = new BDGenero(); //creo una intancia de bd genero 
                    if (/*datos.insertar_subgenero((String)tabla.getValueAt(i,0) ,txtnombre.getText())*/true) {

                        JOptionPane.showMessageDialog(null, "Sub genero Agregado", "Cheeee", JOptionPane.INFORMATION_MESSAGE);
                    }

                }

            }

        }

    }//GEN-LAST:event_btnguardarActionPerformed

    private void ningunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ningunoActionPerformed
        if (ninguno.isSelected() == true) { // si el check esta en true , oculto la lista
            tabla.setVisible(false);
        } else {
            tabla.setVisible(true);
        } // TODO add your handling code here:
    }//GEN-LAST:event_ningunoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JCheckBox ninguno;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
