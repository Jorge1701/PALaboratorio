package Presentacion;

import Logica.DtAlbum;
import Logica.DtAlbumContenido;
import Logica.DtGenero;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IContenido;
import Logica.IUsuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

public class ConsultaAlbum extends javax.swing.JInternalFrame {

    IUsuario iUsuario;
    IContenido iContenido;

    public ConsultaAlbum() {
        initComponents();
        this.iUsuario = Fabrica.getIControladorUsuario();
        this.iContenido = Fabrica.getIControladorContenido();

        btnConsultaGenero.setSelected(true);
        btnConsultaGeneroActionPerformed(null);
    }

    private void mostrar() {
        if (btnConsultaGenero.isSelected()) {
            generos.setEnabled(true);
            tablaArtistas.setEnabled(false);
            lblSelec.setText("Seleccione un genero y un album y luego presione 'aceptar'");
        } else if (btnConsultaArtista.isSelected()) {
            generos.setEnabled(false);
            tablaArtistas.setEnabled(true);
            lblSelec.setText("Seleccione un artista y un album y luego presione 'aceptar'");
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

        grupoBotones = new javax.swing.ButtonGroup();
        btnConsultaGenero = new javax.swing.JRadioButton();
        btnConsultaArtista = new javax.swing.JRadioButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        generos = new javax.swing.JTree();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaArtistas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaAlbumes = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        lblSelec = new javax.swing.JLabel();

        setIconifiable(true);
        setTitle("Consulta de album");

        grupoBotones.add(btnConsultaGenero);
        btnConsultaGenero.setText("Consultar por genero");
        btnConsultaGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaGeneroActionPerformed(evt);
            }
        });

        grupoBotones.add(btnConsultaArtista);
        btnConsultaArtista.setText("Consultar por artista");
        btnConsultaArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaArtistaActionPerformed(evt);
            }
        });

        jSplitPane1.setDividerLocation(180);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jSplitPane2.setDividerLocation(300);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Generos"));

        generos.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                generosValueChanged(evt);
            }
        });
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

        tablaArtistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Nick"
            }
        ));
        tablaArtistas.setDragEnabled(true);
        jScrollPane2.setViewportView(tablaArtistas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
        );

        jSplitPane2.setRightComponent(jPanel2);

        jSplitPane1.setTopComponent(jSplitPane2);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Albumes"));

        tablaAlbumes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Artista"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaAlbumes);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
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

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAceptar, btnCancelar});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar)))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAceptar, btnCancelar});

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
                        .addComponent(btnConsultaGenero)
                        .addGap(28, 28, 28)
                        .addComponent(btnConsultaArtista))
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
                    .addComponent(btnConsultaGenero)
                    .addComponent(btnConsultaArtista))
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

    private void btnConsultaGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaGeneroActionPerformed
        mostrar();
        //Carga los generos en el arbol(generos)
        generos.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        DtGenero g = iContenido.listarGenero();

        DefaultTreeModel modelo = new DefaultTreeModel(getNodo(g));
        generos.setModel(modelo);
    }//GEN-LAST:event_btnConsultaGeneroActionPerformed

    private void generosValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_generosValueChanged
        //Carga los albumes del genero seleccionado en la tabla
        DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) generos.getSelectionPath().getLastPathComponent();
        String generoSeleccionado = selectedElement.getUserObject().toString();

        ArrayList<DtAlbum> dta = iContenido.listarAlbumesGenero(generoSeleccionado);

        DefaultTableModel dtm = (DefaultTableModel) tablaAlbumes.getModel();
        dtm.setRowCount(0);

        for (DtAlbum dtAlbum : dta) {
            Object[] data = {
                ((DtAlbum) dtAlbum).getNombre(),
                ((DtAlbum) dtAlbum).getNickArtista(),};
            dtm.addRow(data);
        }


    }//GEN-LAST:event_generosValueChanged

    private void btnConsultaArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaArtistaActionPerformed
        mostrar();
        //Carga  los artistas en la tabla(tablaArtistas)
        ArrayList<DtUsuario> dta = iUsuario.listarArtistas();
        DefaultTableModel dtm = (DefaultTableModel) tablaArtistas.getModel();
        dtm.setRowCount(0);

        for (DtUsuario dtArtista : dta) {
            Object[] data = {
                dtArtista.getNombre(),
                dtArtista.getNickname(),};
            dtm.addRow(data);
        }

        //Permite que al seleccionar una fila se obtenga el dato seleccionado(en este caso el nick)
        tablaArtistas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                artistaSeleccionado(tablaArtistas.getValueAt(tablaArtistas.getSelectedRow(), 1).toString());

            }
        });

    }//GEN-LAST:event_btnConsultaArtistaActionPerformed


    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String nickArtista;
        String nomAlbum;
        DtAlbumContenido albCont;

        if (btnConsultaGenero.isSelected()) {
            if (generos.getSelectionPath() == null) {
                JOptionPane.showMessageDialog(this, "Debe de seleccionar un Genero");
                return;
            }
        } else if (btnConsultaArtista.isSelected()) {
            if (tablaArtistas.getSelectionModel().isSelectionEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe de seleccionar un Artista");
                return;
            }
        }

        if (tablaAlbumes.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe de seleccionar un Album");
        }

        nickArtista = tablaAlbumes.getValueAt(tablaAlbumes.getSelectedRow(), 1).toString();
        nomAlbum = tablaAlbumes.getValueAt(tablaAlbumes.getSelectedRow(), 0).toString();

        try {
            albCont = iUsuario.obtenerAlbumContenido(nickArtista, nomAlbum);
            AlbumContenido albc = new AlbumContenido((DtAlbumContenido) albCont);
            this.getParent().add(albc);
            albc.show();

        } catch (UnsupportedOperationException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void artistaSeleccionado(String nickArtista) {
       //Carga la tabla de albumes del artista(nickArtista)
        ArrayList<DtAlbum> dta = iUsuario.listarAlbumesArtista(nickArtista);

        DefaultTableModel dtm = (DefaultTableModel) tablaAlbumes.getModel();
        dtm.setRowCount(0);

        for (DtAlbum dtAlbum : dta) {
            Object[] data = {
                ((DtAlbum) dtAlbum).getNombre(),
                ((DtAlbum) dtAlbum).getNickArtista(),};
            dtm.addRow(data);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JRadioButton btnConsultaArtista;
    private javax.swing.JRadioButton btnConsultaGenero;
    private javax.swing.JTree generos;
    private javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JLabel lblSelec;
    private javax.swing.JTable tablaAlbumes;
    private javax.swing.JTable tablaArtistas;
    // End of variables declaration//GEN-END:variables
}