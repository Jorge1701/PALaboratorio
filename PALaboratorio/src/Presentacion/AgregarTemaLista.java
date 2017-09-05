/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Artista;
import Logica.DtAlbum;
import Logica.DtLista;
import Logica.DtTema;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IContenido;
import Logica.IUsuario;
import Logica.Tema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author brian
 */
public class AgregarTemaLista extends javax.swing.JInternalFrame {

    private IContenido iContenido;
    private IUsuario iUsuario;
    private ArrayList<DtUsuario> clientes;
    private ArrayList<DtUsuario> artistas;

    private String nickArtista;
    private ArrayList<DtLista> listasPorDefecto;
    private ArrayList<DtUsuario> listaDeUsuarios;

    /**
     * Creates new form BuscarTema
     */
    public AgregarTemaLista() {
        initComponents();
        iContenido = Fabrica.getIControladorContenido();
        iUsuario = Fabrica.getIControladorUsuario();
        clientes = iUsuario.listarClientes();
        artistas = iUsuario.listarArtistas();
        listasPorDefecto = iContenido.listarLisReproduccionDef();
        listaDeUsuarios = iUsuario.listarUsuarios();
        PestaniaMouseClicked(null);
        DefaultTableModel model = (DefaultTableModel) nombresDeUsuarios.getModel();
        for (DtUsuario dtuser : listaDeUsuarios) {
            Object[] data = {dtuser.getNombre()};
            model.addRow(data);

        }

        tablaClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (tablaClientes.getSelectedRow() == -1) {
                    return;
                }
                cargarDatosListaP(iUsuario.listarListaReproduccionCli(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString()), nombreCliente.getText());
            }
        });
        tablaArtistas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (tablaArtistas.getSelectedRow() == -1) {
                    return;
                }
                cargarDatosAlbumes(iUsuario.listarAlbumesArtista(tablaArtistas.getValueAt(tablaArtistas.getSelectedRow(), 0).toString()), nombreArtistas.getText());
            }
        });
        tablaListaDeAlbumes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (tablaListaDeAlbumes.getSelectedRow() == -1) {
                    return;
                }

                cargarDatosTemaAlbum(iContenido.listarTemas(tablaListaDeAlbumes.getValueAt(tablaListaDeAlbumes.getSelectedRow(), 0).toString(), iUsuario.selectArtista(tablaArtistas.getValueAt(tablaArtistas.getSelectedRow(), 0).toString()).getNickname()), nombreTema.getText());
            }
        });

        tablaListaPordefecto.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (tablaListaPordefecto.getSelectedRow() == -1) {
                    return;
                }
                cargarDatosTemaL(iContenido.listarTemasLD(tablaListaPordefecto.getValueAt(tablaListaPordefecto.getSelectedRow(), 0).toString()), nombreListaD.getText());
            }
        });

        tablaListaParticular.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (tablaListaParticular.getSelectedRow() == -1) {
                    return;
                }
                cargarDatosTemaL(iContenido.listarTemasP(tablaListaParticular.getValueAt(tablaListaParticular.getSelectedRow(), 0).toString()), nombreListaP.getText());
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        nombresDeUsuarios = new javax.swing.JTable();
        agregar = new javax.swing.JToggleButton();
        cancelar = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        nombreTema = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        NombreDelUsuario = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        tablaListaTema = new javax.swing.JTable();
        Pestania = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaListaParticular = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        nombreCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        nombreListaP = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaListaPordefecto = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        nombreListaD = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaListaDeAlbumes = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        tablaArtistas = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        nombreArtistas = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jSplitPane1.setDividerLocation(300);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(jPanel5);

        nombresDeUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane11.setViewportView(nombresDeUsuarios);
        if (nombresDeUsuarios.getColumnModel().getColumnCount() > 0) {
            nombresDeUsuarios.getColumnModel().getColumn(0).setResizable(false);
        }

        agregar.setText("Agregar");

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre De Tema");

        nombreTema.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                nombreTemaCaretUpdate(evt);
            }
        });

        jLabel4.setText("Nombre de Usuario");

        tablaListaTema.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane12.setViewportView(tablaListaTema);
        if (tablaListaTema.getColumnModel().getColumnCount() > 0) {
            tablaListaTema.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(agregar)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                        .addComponent(nombreTema)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cancelar)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(NombreDelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombreDelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar)
                    .addComponent(cancelar))
                .addContainerGap())
        );

        jSplitPane1.setRightComponent(jPanel2);

        Pestania.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PestaniaMouseClicked(evt);
            }
        });

        tablaListaParticular.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre De Lista"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaListaParticular);
        if (tablaListaParticular.getColumnModel().getColumnCount() > 0) {
            tablaListaParticular.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel5.setText("Nombre De Cliente");

        nombreCliente.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                nombreClienteCaretUpdate(evt);
            }
        });

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NickName", "Nombre", "Apellido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaClientes);
        if (tablaClientes.getColumnModel().getColumnCount() > 0) {
            tablaClientes.getColumnModel().getColumn(0).setResizable(false);
            tablaClientes.getColumnModel().getColumn(1).setResizable(false);
            tablaClientes.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel6.setText("Nombre De Lista");

        nombreListaP.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                nombreListaPCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(72, 72, 72)
                                    .addComponent(nombreListaP, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 47, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(nombreListaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        Pestania.addTab("Listas Particular", jPanel7);

        tablaListaPordefecto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre De Lista"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tablaListaPordefecto);
        if (tablaListaPordefecto.getColumnModel().getColumnCount() > 0) {
            tablaListaPordefecto.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel3.setText("Nombre De Lista");

        nombreListaD.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                nombreListaDCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(36, 36, 36)
                .addComponent(nombreListaD, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nombreListaD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
        );

        Pestania.addTab("Listas Por Defecto", jPanel8);

        tablaListaDeAlbumes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre De Album"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tablaListaDeAlbumes);
        if (tablaListaDeAlbumes.getColumnModel().getColumnCount() > 0) {
            tablaListaDeAlbumes.getColumnModel().getColumn(0).setResizable(false);
        }

        tablaArtistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nickname", "Nombre", "Apellido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(tablaArtistas);
        if (tablaArtistas.getColumnModel().getColumnCount() > 0) {
            tablaArtistas.getColumnModel().getColumn(0).setResizable(false);
            tablaArtistas.getColumnModel().getColumn(1).setResizable(false);
            tablaArtistas.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel7.setText("Nombre de artista");

        jLabel1.setText("Nombre De Album");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreArtistas, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(nombreArtistas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Pestania.addTab("Albumes", jPanel9);

        jSplitPane1.setLeftComponent(Pestania);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PestaniaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PestaniaMouseClicked
        if (Pestania.getSelectedIndex() == 0) {
            cargarDatosClientes(clientes, nombreCliente.getText());
        } else if (Pestania.getSelectedIndex() == 1) {
            cargarDatosListaD(listasPorDefecto, nombreListaD.getText());
        } else if (Pestania.getSelectedIndex() == 2) {
            cargarDatosArtistas(artistas, nombreArtistas.getText());

        }
    }//GEN-LAST:event_PestaniaMouseClicked

    private void nombreClienteCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_nombreClienteCaretUpdate
        cargarDatosClientes(clientes, nombreCliente.getText());
    }//GEN-LAST:event_nombreClienteCaretUpdate

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarActionPerformed

    private void nombreTemaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_nombreTemaCaretUpdate
        cargarDatosTemaAlbum(iContenido.listarTemas(tablaListaDeAlbumes.getValueAt(tablaListaDeAlbumes.getSelectedRow(), 0).toString(), iUsuario.selectArtista(tablaArtistas.getValueAt(tablaArtistas.getSelectedRow(), 0).toString()).getNickname()), nombreTema.getText());
    }//GEN-LAST:event_nombreTemaCaretUpdate

    private void nombreListaPCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_nombreListaPCaretUpdate
        cargarDatosListaP(iUsuario.listarListaReproduccionCli(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString()), nombreCliente.getText());
    }//GEN-LAST:event_nombreListaPCaretUpdate

    private void nombreListaDCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_nombreListaDCaretUpdate
        cargarDatosListaD(listasPorDefecto, nombreListaD.getText());
    }//GEN-LAST:event_nombreListaDCaretUpdate

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked

    }//GEN-LAST:event_tablaClientesMouseClicked

    private void cargarDatosListaD(ArrayList<DtLista> dtl, String filtro) {
        if (dtl.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ninguna lista registrado");
        }
        DefaultTableModel tabla = (DefaultTableModel) tablaListaPordefecto.getModel();
        tabla.setRowCount(0);
        for (DtLista dtLista : dtl) {
            if (dtLista.getNombre().contains(filtro)) {
                Object[] data = {dtLista.getNombre()};
                tabla.addRow(data);
            }
        }
    }

    private void cargarDatosClientes(ArrayList<DtUsuario> dtu, String filtro) {
        if (dtu.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ningun cliente registrado");
        }

        DefaultTableModel dtm = (DefaultTableModel) tablaClientes.getModel();
        dtm.setRowCount(0);
        for (DtUsuario dtUsuario : dtu) {
            if (dtUsuario.getNickname().contains(filtro)) {
                Object[] data = {
                    dtUsuario.getNickname(),
                    dtUsuario.getNombre(),
                    dtUsuario.getApellido(),};
                dtm.addRow(data);
            }
        }
    }

    private void cargarDatosArtistas(ArrayList<DtUsuario> dtu, String filtro) {
        if (dtu.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ningun artistas registrado");
        }

        DefaultTableModel dtm = (DefaultTableModel) tablaArtistas.getModel();
        dtm.setRowCount(0);
        for (DtUsuario dtUsuario : dtu) {
            if (dtUsuario.getNickname().contains(filtro)) {
                Object[] data = {
                    dtUsuario.getNickname(),
                    dtUsuario.getNombre(),
                    dtUsuario.getApellido(),};
                dtm.addRow(data);
            }
        }
    }

    private void cargarDatosListaP(ArrayList<DtLista> listaP, String filtro) {
        if (listaP.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ninguna Lista Particular Registrada");
        }
        DefaultTableModel dtl = (DefaultTableModel) tablaListaParticular.getModel();
        dtl.setRowCount(0);

        for (DtLista dtLista : listaP) {
            if (dtLista.getNombre().contains(filtro)) {
                Object[] data = {dtLista.getNombre()};
                dtl.addRow(data);
            }
        }
    }

    private void cargarDatosAlbumes(ArrayList<DtAlbum> albumes, String filtro) {
        if (albumes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ningun album registrado");
        }
        DefaultTableModel model = (DefaultTableModel) tablaListaTema.getModel();
        model.setRowCount(0);
        DefaultTableModel dta = (DefaultTableModel) tablaListaDeAlbumes.getModel();
        dta.setRowCount(0);
        for (DtAlbum dtAlbumbes : albumes) {
            if (dtAlbumbes.getNombre().contains(filtro)) {
                Object[] data = {dtAlbumbes.getNombre()};
                dta.addRow(data);
            }
        }
    }

    private void cargarDatosTemaAlbum(HashMap<String, Tema> temas, String filtro) {
        if (temas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ningun tema registrado");
        }
        Iterator i = temas.entrySet().iterator();
        DefaultTableModel dtt = (DefaultTableModel) tablaListaTema.getModel();
        dtt.setRowCount(0);
        while (i.hasNext()) {
            Tema t = (Tema) ((Map.Entry) i.next()).getValue();
            if (t.getNombre().contains(filtro)) {
                Object[] data = {t.getNombre()};
                dtt.addRow(data);
            }
        }
    }

    private void cargarDatosTemaL(ArrayList<DtTema> temas, String filtro) {
        if (temas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ningun tema registrado");
        }
        DefaultTableModel dtt = (DefaultTableModel) tablaListaTema.getModel();
        dtt.setRowCount(0);
        for (DtTema dtTemas : temas) {
            if (dtTemas.getNombre().contains(filtro)) {
                Object[] data = {dtTemas.getNombre()};
                dtt.addRow(data);
            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NombreDelUsuario;
    private javax.swing.JTabbedPane Pestania;
    private javax.swing.JToggleButton agregar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JToggleButton cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField nombreArtistas;
    private javax.swing.JTextField nombreCliente;
    private javax.swing.JTextField nombreListaD;
    private javax.swing.JTextField nombreListaP;
    private javax.swing.JTextField nombreTema;
    private javax.swing.JTable nombresDeUsuarios;
    private javax.swing.JTable tablaArtistas;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaListaDeAlbumes;
    private javax.swing.JTable tablaListaParticular;
    private javax.swing.JTable tablaListaPordefecto;
    private javax.swing.JTable tablaListaTema;
    // End of variables declaration//GEN-END:variables
}
