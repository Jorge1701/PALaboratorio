/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.DtAlbum;
import Logica.DtAlbumContenido;
import Logica.DtGenero;
import Logica.DtUsuario;
import Logica.Fabrica;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author Ale
 */
public class ConsultarAlbum extends javax.swing.JInternalFrame {

    public ConsultarAlbum() {
        initComponents();
        consultaGenero.setSelected(true);
        consultaGeneroActionPerformed(null);

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

        Grupo = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        consultaGenero = new javax.swing.JRadioButton();
        consultaArtista = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        generos = new javax.swing.JTree();
        jScrollPane4 = new javax.swing.JScrollPane();
        JTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstArtistas = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstAlbumes = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consultar Album");

        Grupo.add(consultaGenero);
        consultaGenero.setText("Consultar por género");
        consultaGenero.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                consultaGeneroStateChanged(evt);
            }
        });
        consultaGenero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                consultaGeneroMouseClicked(evt);
            }
        });
        consultaGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaGeneroActionPerformed(evt);
            }
        });

        Grupo.add(consultaArtista);
        consultaArtista.setText("Consultar por artista");
        consultaArtista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                consultaArtistaMouseClicked(evt);
            }
        });
        consultaArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaArtistaActionPerformed(evt);
            }
        });

        generos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        generos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                generosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                generosMousePressed(evt);
            }
        });
        generos.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                generosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(generos);

        JTable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Abum", "del artista"
            }
        ));
        JTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(JTable);

        jLabel1.setText("Albumes del genero seleccionado:");

        jLabel3.setText("Generos:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lstArtistas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lstArtistas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstArtistasValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstArtistas);

        lstAlbumes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lstAlbumes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstAlbumesValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lstAlbumes);

        jLabel2.setText("Albumes del artista seleccionado:");

        jLabel4.setText("Artistas:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
            .addComponent(jScrollPane3)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnAceptar.setText("Aceptar");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(201, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAceptar)
                                .addGap(43, 43, 43))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(consultaGenero)
                                .addGap(98, 98, 98)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnCancelar)
                                .addGap(266, 266, 266))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(consultaArtista))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(consultaGenero)
                    .addComponent(consultaArtista))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void consultaGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaGeneroActionPerformed
        this.mostrar();
        generos.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        DtGenero g = Fabrica.getInstance().getIControladorContenido().listarGenero();
        DefaultTreeModel modelo = new DefaultTreeModel(getNodo(g));
        generos.setModel(modelo);
    }//GEN-LAST:event_consultaGeneroActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String nickArtista = null;
        String nomAlbum = null;
        DtAlbumContenido albCont;

        if (consultaGenero.isSelected()) {
            if (generos.getSelectionPath() != null) {

                int row = JTable.getSelectedRow();
                if (row > -1) {
                    nomAlbum = (String) JTable.getValueAt(row, 0);
                    nickArtista = (String) JTable.getValueAt(row, 1);
                } else {
                    JOptionPane.showMessageDialog(this, "Debe de seleccionar un Album");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe de seleccionar un Genero");
                return;
            }
        } else if (consultaArtista.isSelected()) {
            nickArtista = (String) lstArtistas.getSelectedValue();
            nomAlbum = (String) lstAlbumes.getSelectedValue();
            if (nickArtista == null) {
                JOptionPane.showMessageDialog(this, "Debe de seleccionar un Artista");
                return;
            }
            if (nomAlbum == null) {
                JOptionPane.showMessageDialog(this, "Debe de seleccionar un Album");
                return;
            }

        }

        try {
            albCont = Fabrica.getInstance().getIControladorUsuario().obtenerAlbumContenido(nickArtista, nomAlbum);
            AlbumContenido albc = new AlbumContenido(albCont);
            this.getParent().add(albc);
            albc.show();

        } catch (UnsupportedOperationException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void consultaArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaArtistaActionPerformed
        mostrar();
        DefaultListModel<String> model = new DefaultListModel<>();
        lstArtistas.setModel(model);
        for (DtUsuario dtg : Fabrica.getInstance().getIControladorUsuario().listarArtistas()) {
            model.addElement(dtg.getNickname());
        }
    }//GEN-LAST:event_consultaArtistaActionPerformed

    private void consultaGeneroStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_consultaGeneroStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_consultaGeneroStateChanged

    private void consultaGeneroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consultaGeneroMouseClicked

    }//GEN-LAST:event_consultaGeneroMouseClicked

    private void mostrar() {
        if (consultaGenero.isSelected()) {
            generos.setEnabled(true);
            JTable.setEnabled(true);
            lstArtistas.setEnabled(false);
            lstAlbumes.setEnabled(false);

        } else if (consultaArtista.isSelected()) {
            lstArtistas.setEnabled(true);
            lstAlbumes.setEnabled(true);
            generos.setEnabled(false);
            JTable.setEnabled(false);

        }
        repaint();
    }

    private void consultaArtistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consultaArtistaMouseClicked

    }//GEN-LAST:event_consultaArtistaMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void generosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_generosMouseClicked

    private void generosValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_generosValueChanged

        DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) generos.getSelectionPath().getLastPathComponent();
        String generoSeleccionado = selectedElement.getUserObject().toString();

        ArrayList<DtAlbum> dta = Fabrica.getInstance().getIControladorContenido().listarAlbumesGenero(generoSeleccionado);

        DefaultTableModel dtm = (DefaultTableModel) JTable.getModel();
        dtm.setRowCount(0);

        for (DtAlbum dtAlbum : dta) {
            Object[] data = {
                ((DtAlbum) dtAlbum).getNickArtista(),
                ((DtAlbum) dtAlbum).getNombre(),};
            dtm.addRow(data);
        }


    }//GEN-LAST:event_generosValueChanged

    private void lstArtistasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstArtistasValueChanged
        String nickArtista = lstArtistas.getSelectedValue().toString();

        DefaultListModel<String> model = new DefaultListModel<>();
        lstAlbumes.setModel(model);

        for (DtAlbum dta : Fabrica.getInstance().getIControladorUsuario().listarAlbumesArtista(nickArtista)) {
            model.addElement(dta.getNombre());
        }

    }//GEN-LAST:event_lstArtistasValueChanged

    private void lstAlbumesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstAlbumesValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_lstAlbumesValueChanged

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked

    }//GEN-LAST:event_btnAceptarMouseClicked

    private void JTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableMouseClicked

    }//GEN-LAST:event_JTableMouseClicked

    private void generosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generosMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_generosMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Grupo;
    private javax.swing.JTable JTable;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    public static javax.swing.JRadioButton consultaArtista;
    public static javax.swing.JRadioButton consultaGenero;
    private javax.swing.JTree generos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<String> lstAlbumes;
    private javax.swing.JList<String> lstArtistas;
    // End of variables declaration//GEN-END:variables
}
