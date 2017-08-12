/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.DtAlbum;
import Logica.DtArtista;
import Logica.DtCliente;
import Logica.DtPerfilArtista;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author brian
 */
public class PerfilArtista extends javax.swing.JInternalFrame {

    /**
     * Creates new form PerfilArtista
     */
    public PerfilArtista(DtPerfilArtista dtPerfilArtista) {
        initComponents();
        setTitle(getTitle() + dtPerfilArtista.getInfo().getNickname());
        txtNickname7.setText(dtPerfilArtista.getInfo().getNickname());
        txtNombre7.setText(dtPerfilArtista.getInfo().getNombre());
        txtApellido7.setText(dtPerfilArtista.getInfo().getApellido());
        txtEmail7.setText(dtPerfilArtista.getInfo().getEmail());
        txtFechaNac7.setText(dtPerfilArtista.getInfo().getFechaNac().toString()); 
        txtBiografia.setText(dtPerfilArtista.getInfoArtista().getBiografia());
        txtSitioWeb.setText(dtPerfilArtista.getInfoArtista().getWeb());

        
        ((TitledBorder) PanelSeguidores.getBorder()).setTitle("Seguidores (" + dtPerfilArtista.getSeguidores().size() + "):");
        
        DefaultTableModel dtmSeguidores = (DefaultTableModel) tablaSeguidores.getModel();
        dtmSeguidores.setRowCount(0);
        
        for (DtCliente dtc : dtPerfilArtista.getSeguidores()) {
            Object[] data = {
                dtc.getNickname(),
                dtc.getNombre(),
                dtc.getApellido(),
                dtc.getEmail(),
                dtc.getFechaNac().toString(),
            };
            dtmSeguidores.addRow(data);
        }
        
        DefaultTableModel dtmAlbumes = (DefaultTableModel) TablaAlbum.getModel();
        dtmAlbumes.setRowCount(0);
        
        for (DtAlbum dta : dtPerfilArtista.getAlbumes()) {
            Object[] data = {
                dta.getNombre(),
            };
            dtmSeguidores.addRow(data);
        }
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jSplitPane3 = new javax.swing.JSplitPane();
        jSplitPane4 = new javax.swing.JSplitPane();
        PanelAlbum = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaAlbum = new javax.swing.JTable();
        PanelSeguidores = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSeguidores = new javax.swing.JTable();
        PanelInfo7 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        txtNickname7 = new javax.swing.JTextField();
        txtNombre7 = new javax.swing.JTextField();
        txtApellido7 = new javax.swing.JTextField();
        txtEmail7 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txtFechaNac7 = new javax.swing.JTextField();
        PanelImagen = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBiografia = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txtSitioWeb = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextField1.setText("jTextField1");

        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.X_AXIS));

        jSplitPane3.setDividerLocation(300);
        jSplitPane3.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jSplitPane4.setDividerLocation(150);
        jSplitPane4.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        PanelAlbum.setBorder(javax.swing.BorderFactory.createTitledBorder("Albumes Publicados: "));

        TablaAlbum.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Nombre"
            }
        ));
        jScrollPane2.setViewportView(TablaAlbum);

        javax.swing.GroupLayout PanelAlbumLayout = new javax.swing.GroupLayout(PanelAlbum);
        PanelAlbum.setLayout(PanelAlbumLayout);
        PanelAlbumLayout.setHorizontalGroup(
            PanelAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAlbumLayout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        PanelAlbumLayout.setVerticalGroup(
            PanelAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jSplitPane4.setLeftComponent(PanelAlbum);

        PanelSeguidores.setBorder(javax.swing.BorderFactory.createTitledBorder("Seguidores:"));

        tablaSeguidores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "nickname", "Nombre", "Apellido"
            }
        ));
        jScrollPane1.setViewportView(tablaSeguidores);

        javax.swing.GroupLayout PanelSeguidoresLayout = new javax.swing.GroupLayout(PanelSeguidores);
        PanelSeguidores.setLayout(PanelSeguidoresLayout);
        PanelSeguidoresLayout.setHorizontalGroup(
            PanelSeguidoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
        );
        PanelSeguidoresLayout.setVerticalGroup(
            PanelSeguidoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSeguidoresLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jSplitPane4.setRightComponent(PanelSeguidores);

        jSplitPane3.setRightComponent(jSplitPane4);

        PanelInfo7.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion Basica:"));

        jLabel38.setText("Fecha Nac");

        txtNickname7.setEnabled(false);

        txtNombre7.setEnabled(false);

        txtApellido7.setEnabled(false);

        txtEmail7.setEnabled(false);

        jLabel39.setText("Nickname");

        jLabel40.setText("Nombre");

        jLabel41.setText("Apellido");

        jLabel42.setText("Email");

        txtFechaNac7.setEnabled(false);
        txtFechaNac7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaNac7ActionPerformed(evt);
            }
        });

        PanelImagen.setBackground(new java.awt.Color(153, 255, 255));

        javax.swing.GroupLayout PanelImagenLayout = new javax.swing.GroupLayout(PanelImagen);
        PanelImagen.setLayout(PanelImagenLayout);
        PanelImagenLayout.setHorizontalGroup(
            PanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        PanelImagenLayout.setVerticalGroup(
            PanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );

        jLabel6.setText("Imagen");

        jLabel7.setText("Biografia");

        txtBiografia.setBackground(new java.awt.Color(240, 240, 240));
        txtBiografia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBiografiaActionPerformed(evt);
            }
        });

        jLabel43.setText("Sitio Web");

        txtSitioWeb.setEnabled(false);

        javax.swing.GroupLayout PanelInfo7Layout = new javax.swing.GroupLayout(PanelInfo7);
        PanelInfo7.setLayout(PanelInfo7Layout);
        PanelInfo7Layout.setHorizontalGroup(
            PanelInfo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInfo7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelInfo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInfo7Layout.createSequentialGroup()
                        .addGroup(PanelInfo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(jLabel42)
                            .addComponent(jLabel39)
                            .addComponent(jLabel40)
                            .addComponent(jLabel38)
                            .addComponent(jLabel43))
                        .addGap(51, 51, 51)
                        .addGroup(PanelInfo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelInfo7Layout.createSequentialGroup()
                                .addGroup(PanelInfo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNickname7, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSitioWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(PanelInfo7Layout.createSequentialGroup()
                                .addGroup(PanelInfo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtApellido7, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail7, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre7, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFechaNac7, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                                .addComponent(PanelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38))))
                    .addGroup(PanelInfo7Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(56, 56, 56)
                        .addComponent(txtBiografia)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInfo7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(79, 79, 79))
        );
        PanelInfo7Layout.setVerticalGroup(
            PanelInfo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInfo7Layout.createSequentialGroup()
                .addGroup(PanelInfo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInfo7Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(PanelInfo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(txtFechaNac7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelInfo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelInfo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(txtApellido7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelInfo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(txtEmail7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInfo7Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PanelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addGroup(PanelInfo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNickname7, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelInfo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSitioWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addGap(23, 23, 23)
                .addGroup(PanelInfo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBiografia, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)))
        );

        jSplitPane3.setLeftComponent(PanelInfo7);

        getContentPane().add(jSplitPane3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBiografiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBiografiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBiografiaActionPerformed

    private void txtFechaNac7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaNac7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaNac7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Imagen;
    private javax.swing.JPanel Imagen1;
    private javax.swing.JPanel Imagen2;
    private javax.swing.JPanel Imagen3;
    private javax.swing.JPanel Imagen4;
    private javax.swing.JPanel Imagen5;
    private javax.swing.JPanel Imagen6;
    private javax.swing.JPanel PanelAlbum;
    private javax.swing.JPanel PanelImagen;
    private javax.swing.JPanel PanelInfo;
    private javax.swing.JPanel PanelInfo1;
    private javax.swing.JPanel PanelInfo2;
    private javax.swing.JPanel PanelInfo3;
    private javax.swing.JPanel PanelInfo4;
    private javax.swing.JPanel PanelInfo5;
    private javax.swing.JPanel PanelInfo6;
    private javax.swing.JPanel PanelInfo7;
    private javax.swing.JPanel PanelSeguidores;
    private javax.swing.JTable TablaAlbum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tablaSeguidores;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtApellido3;
    private javax.swing.JTextField txtApellido4;
    private javax.swing.JTextField txtApellido5;
    private javax.swing.JTextField txtApellido6;
    private javax.swing.JTextField txtApellido7;
    private javax.swing.JTextField txtBiografia;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmail1;
    private javax.swing.JTextField txtEmail2;
    private javax.swing.JTextField txtEmail3;
    private javax.swing.JTextField txtEmail4;
    private javax.swing.JTextField txtEmail5;
    private javax.swing.JTextField txtEmail6;
    private javax.swing.JTextField txtEmail7;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtFechaNac1;
    private javax.swing.JTextField txtFechaNac2;
    private javax.swing.JTextField txtFechaNac3;
    private javax.swing.JTextField txtFechaNac4;
    private javax.swing.JTextField txtFechaNac5;
    private javax.swing.JTextField txtFechaNac6;
    private javax.swing.JTextField txtFechaNac7;
    private javax.swing.JTextField txtNickname;
    private javax.swing.JTextField txtNickname1;
    private javax.swing.JTextField txtNickname2;
    private javax.swing.JTextField txtNickname3;
    private javax.swing.JTextField txtNickname4;
    private javax.swing.JTextField txtNickname5;
    private javax.swing.JTextField txtNickname6;
    private javax.swing.JTextField txtNickname7;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtNombre2;
    private javax.swing.JTextField txtNombre3;
    private javax.swing.JTextField txtNombre4;
    private javax.swing.JTextField txtNombre5;
    private javax.swing.JTextField txtNombre6;
    private javax.swing.JTextField txtNombre7;
    private javax.swing.JTextField txtSitioWeb;
    // End of variables declaration//GEN-END:variables
}
