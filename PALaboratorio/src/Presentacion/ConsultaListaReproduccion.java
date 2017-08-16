package Presentacion;

import Logica.DtGenero;
import Logica.DtLista;
import Logica.DtUsuario;
import Logica.Fabrica;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

public class ConsultaListaReproduccion extends javax.swing.JInternalFrame {

    public ConsultaListaReproduccion() {
        initComponents();
        consultaGenero.setSelected(true);
        consultaGeneroActionPerformed(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        generos = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstArtistas = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        consultaGenero = new javax.swing.JRadioButton();
        consultaCliente = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstListasRep = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Consulta de lista de reproducción");

        generos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        generos.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                generosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(generos);

        lstArtistas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lstArtistas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstArtistasValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstArtistas);

        jLabel3.setText("Generos:");

        jLabel4.setText("Clientes:");

        buttonGroup1.add(consultaGenero);
        consultaGenero.setText("Consultar por género");
        consultaGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaGeneroActionPerformed(evt);
            }
        });

        buttonGroup1.add(consultaCliente);
        consultaCliente.setText("Consultar por cliente");
        consultaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaClienteActionPerformed(evt);
            }
        });

        lstListasRep.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane3.setViewportView(lstListasRep);

        jLabel1.setText("Listas de Reproduccion:");

        btnAceptar.setText("Aceptar");
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
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(consultaGenero)
                                .addGap(13, 13, 13)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(consultaCliente)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(btnAceptar)
                        .addGap(71, 71, 71)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAceptar, btnCancelar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(consultaCliente)
                    .addComponent(consultaGenero))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAceptar, btnCancelar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private DefaultMutableTreeNode getNodo(DtGenero g) {
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode(g.getNombre());
        for (DtGenero dtg : g.getSubGeneros()) {
            DefaultMutableTreeNode hijo = getNodo(dtg);
            padre.add(hijo);
        }
        return padre;
    }

    private void mostrar() {
        if (consultaGenero.isSelected()) {
            generos.setEnabled(true);
            lstArtistas.setEnabled(false);

        } else if (consultaCliente.isSelected()) {
            lstArtistas.setEnabled(true);
            generos.setEnabled(false);

        }
        repaint();
    }
    private void consultaGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaGeneroActionPerformed
        this.mostrar();
        generos.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        DtGenero g = Fabrica.getInstance().getIControladorContenido().listarGenero();
        DefaultTreeModel modelo = new DefaultTreeModel(getNodo(g));
        generos.setModel(modelo);
    }//GEN-LAST:event_consultaGeneroActionPerformed

    private void consultaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaClienteActionPerformed
        mostrar();
        DefaultListModel<String> model = new DefaultListModel<>();
        lstArtistas.setModel(model);
        for (DtUsuario dtg : Fabrica.getInstance().getIControladorUsuario().listarClientes()) {
            model.addElement(dtg.getNickname());
        }
    }//GEN-LAST:event_consultaClienteActionPerformed

    private void generosValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_generosValueChanged

        DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) generos.getSelectionPath().getLastPathComponent();
        String generoSeleccionado = selectedElement.getUserObject().toString();

        ArrayList<DtLista> dtl = Fabrica.getInstance().getIControladorContenido().listarLisReproduccionGen(generoSeleccionado);

        DefaultListModel<String> model = new DefaultListModel<>();
        lstListasRep.setModel(model);

        for (DtLista dta : dtl) {
            model.addElement(dta.getNombre());
        }

    }//GEN-LAST:event_generosValueChanged

    private void lstArtistasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstArtistasValueChanged
        String nickArtista = lstArtistas.getSelectedValue().toString();

        DefaultListModel<String> model = new DefaultListModel<>();
        lstListasRep.setModel(model);

        ArrayList<DtLista> dtl = Fabrica.getInstance().getIControladorUsuario().listarListaReproduccionCli(nickArtista);

        for (DtLista dta : dtl) {
            model.addElement(dta.getNombre());
        }
    }//GEN-LAST:event_lstArtistasValueChanged

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String nickArtista = null;
        String nomLista = null;
        DtLista lista = null;

        if (consultaGenero.isSelected()) {
            if (generos.getSelectionPath() == null) {
                JOptionPane.showMessageDialog(this, "Debe de seleccionar un Genero");
                return;
            } else {

                DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) generos.getSelectionPath().getLastPathComponent();
                String generoSeleccionado = selectedElement.getUserObject().toString();

                if (nomLista == null) {
                    JOptionPane.showMessageDialog(this, "Debe de seleccionar una Lista");
                    return;
                } else {
                    try {
                        lista = Fabrica.getInstance().getIControladorContenido().selecListGen(nomLista);
                        InfoListaReproduccion l = new InfoListaReproduccion(lista, generoSeleccionado);
                        this.getParent().add(l);
                        l.show();

                    } catch (UnsupportedOperationException e) {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
                }
            }
        } else if (consultaCliente.isSelected()) {
            nickArtista = (String) lstArtistas.getSelectedValue();
            if (nickArtista == null) {
                JOptionPane.showMessageDialog(this, "Debe de seleccionar un Artista");
                return;
            } else {
                if (nomLista == null) {
                    JOptionPane.showMessageDialog(this, "Debe de seleccionar una Lista");
                    return;
                } else {
                    try {
                        lista = Fabrica.getInstance().getIControladorUsuario().selectListaCli(nomLista);
                        InfoListaReproduccion l = new InfoListaReproduccion(lista, nickArtista);
                        this.getParent().add(l);
                        l.show();

                    } catch (UnsupportedOperationException e) {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
                }
            }

    }//GEN-LAST:event_btnAceptarActionPerformed
    }
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JRadioButton consultaCliente;
    public static javax.swing.JRadioButton consultaGenero;
    private javax.swing.JTree generos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> lstArtistas;
    private javax.swing.JList<String> lstListasRep;
    // End of variables declaration//GEN-END:variables
}
