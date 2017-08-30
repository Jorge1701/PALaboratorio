package Presentacion;

import Logica.DtGenero;
import Logica.DtLista;
import Logica.DtListaDefecto;
import Logica.DtListaParticular;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IContenido;
import Logica.IUsuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

public class CrearListaReproduccion extends javax.swing.JInternalFrame {

    IUsuario iUsuario;
    IContenido iContenido;

    public CrearListaReproduccion() {
        initComponents();
        this.iUsuario = Fabrica.getIControladorUsuario();
        this.iContenido = Fabrica.getIControladorContenido();

        btnListaDefecto.setSelected(true);
        btnListaDefectoActionPerformed(null);
    }

    private void mostrar() {
        if (btnListaDefecto.isSelected()) {
            generos.setEnabled(true);
            tablaClientes.setEnabled(false);
            lblSelec.setText("Seleccione un genero y luego presione 'aceptar'");
        } else if (btnListaParticular.isSelected()) {
            generos.setEnabled(false);
            tablaClientes.setEnabled(true);
            lblSelec.setText("Seleccione un cliente y luego presione 'aceptar'");
        }
    }

    private DefaultMutableTreeNode getNodo(DtGenero g) {
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode(g.getNombre());
        for (DtGenero dtg : g.getSubGeneros()) {
            DefaultMutableTreeNode hijo = getNodo(dtg);
            padre.add(hijo);
        }
        return padre;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnListaDefecto = new javax.swing.JRadioButton();
        btnListaParticular = new javax.swing.JRadioButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        generos = new javax.swing.JTree();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        lblSelec = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Crear Lista de Reproducción");

        buttonGroup1.add(btnListaDefecto);
        btnListaDefecto.setText("Lista Por Defecto");
        btnListaDefecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaDefectoActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnListaParticular);
        btnListaParticular.setText("Lista Particular");
        btnListaParticular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaParticularActionPerformed(evt);
            }
        });

        jSplitPane1.setDividerLocation(180);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jSplitPane2.setDividerLocation(300);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Generos"));

        jScrollPane1.setViewportView(generos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
        );

        jSplitPane2.setLeftComponent(jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Artistas"));

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Nick"
            }
        ));
        tablaClientes.setDragEnabled(true);
        jScrollPane2.setViewportView(tablaClientes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
        );

        jSplitPane2.setRightComponent(jPanel2);

        jSplitPane1.setTopComponent(jSplitPane2);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista"));

        jLabel1.setText("Nombre:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 429, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(jPanel3);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(22, 22, 22))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar)))
        );

        lblSelec.setText("Seleccione un y un album y luego presione 'aceptar'");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(btnListaDefecto)
                        .addGap(28, 28, 28)
                        .addComponent(btnListaParticular))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblSelec)
                        .addGap(48, 48, 48)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListaDefecto)
                    .addComponent(btnListaParticular))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSelec)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListaDefectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaDefectoActionPerformed
        mostrar();
        //Carga los generos en el arbol(generos)
        generos.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        DtGenero g = iContenido.listarGenero();

        DefaultTreeModel modelo = new DefaultTreeModel(getNodo(g));
        generos.setModel(modelo);
    }//GEN-LAST:event_btnListaDefectoActionPerformed

    private void btnListaParticularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaParticularActionPerformed
        mostrar();
        //Carga  los artistas en la tabla(tablaArtistas)
        ArrayList<DtUsuario> dta = iUsuario.listarClientes();
        DefaultTableModel dtm = (DefaultTableModel) tablaClientes.getModel();
        dtm.setRowCount(0);

        for (DtUsuario dtCliente : dta) {
            Object[] data = {
                dtCliente.getNombre(),
                dtCliente.getNickname(),};
            dtm.addRow(data);
        }
    }//GEN-LAST:event_btnListaParticularActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String nickCliente, nomGenero, nomLista;
        DtLista lista;
        nomLista = nombre.getText();
        nickCliente = tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 1).toString();
        if (btnListaDefecto.isSelected()) {
            if (generos.getSelectionPath() == null) {
                JOptionPane.showMessageDialog(this, "Debe de seleccionar un Genero");
                return;
            } else if (nombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un nombre");
                return;
            } else {
                DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) generos.getSelectionPath().getLastPathComponent();
                nomGenero = selectedElement.getUserObject().toString();
                lista = new DtListaDefecto(iContenido.selecGenero(nomGenero), nomLista, null, null);   // Agregar que se ingrese la imagen en el diseño.
                if (!iContenido.crearListaReproduccion(lista, nickCliente)) {
                    JOptionPane.showMessageDialog(this, "Ocurrió un error al ingresar la lista", "Mensaje", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "La lista se ingresó correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

            }
        } else {

            if (tablaClientes.getSelectionModel().isSelectionEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe de seleccionar un Cliente");
                return;
            } else if (nombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un nombre");
                return;

            } else {
                lista = new DtListaParticular(true, nomLista, null, null);  // Agregar que se ingrese la imagen en el diseño.
                if (!iContenido.crearListaReproduccion(lista, nickCliente)) {
                    JOptionPane.showMessageDialog(this, "Ocurrió un error al ingresar la lista", "Mensaje", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "La lista se ingresó correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }

        }

    }//GEN-LAST:event_btnAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JRadioButton btnListaDefecto;
    private javax.swing.JRadioButton btnListaParticular;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTree generos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JLabel lblSelec;
    private javax.swing.JTextField nombre;
    private javax.swing.JTable tablaClientes;
    // End of variables declaration//GEN-END:variables
}
