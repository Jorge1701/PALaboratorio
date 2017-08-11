package Presentacion;

public class menu extends javax.swing.JFrame {

    public menu() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelMenu = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        altaPerfil = new javax.swing.JMenuItem();
        altaAlbum = new javax.swing.JMenuItem();
        altaGenero = new javax.swing.JMenuItem();
        crearListaRep = new javax.swing.JMenuItem();
        publicarLista = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        consultaPerfilCliente = new javax.swing.JMenuItem();
        consultaPerfilArtista = new javax.swing.JMenuItem();
        consultaAlbum = new javax.swing.JMenuItem();
        consultaListaRep = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        seguirUsuario = new javax.swing.JMenuItem();
        dejarSeguirUsuario = new javax.swing.JMenuItem();
        agregarTemaLista = new javax.swing.JMenuItem();
        quitarTemaLista = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        guardarTLA = new javax.swing.JMenuItem();
        eliminarTLA = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        cargarDatos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelMenu.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );

        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jMenu1.setText("Registros");

        altaPerfil.setText("Alta de Perfil");
        jMenu1.add(altaPerfil);

        altaAlbum.setText("Alta Album");
        jMenu1.add(altaAlbum);

        altaGenero.setText("Alta de Genero");
        jMenu1.add(altaGenero);

        crearListaRep.setText("Crear Lista de Reproduccion");
        jMenu1.add(crearListaRep);

        publicarLista.setText("Publicar Lista");
        jMenu1.add(publicarLista);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Consultas");

        consultaPerfilCliente.setText("Consulta de Perfil de Cliente");
        consultaPerfilCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaPerfilClienteActionPerformed(evt);
            }
        });
        jMenu2.add(consultaPerfilCliente);

        consultaPerfilArtista.setText("Consulta de Perfil de Artista");
        consultaPerfilArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaPerfilArtistaActionPerformed(evt);
            }
        });
        jMenu2.add(consultaPerfilArtista);

        consultaAlbum.setText("Consulta de Album");
        jMenu2.add(consultaAlbum);

        consultaListaRep.setText("Consulta de Lista de Reproduccion");
        jMenu2.add(consultaListaRep);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Relaciones");

        seguirUsuario.setText("Seguir Usuario");
        seguirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seguirUsuarioActionPerformed(evt);
            }
        });
        jMenu3.add(seguirUsuario);

        dejarSeguirUsuario.setText("Dejar de Seguir Usuario");
        dejarSeguirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dejarSeguirUsuarioActionPerformed(evt);
            }
        });
        jMenu3.add(dejarSeguirUsuario);

        agregarTemaLista.setText("Agregar Tema a Lista");
        jMenu3.add(agregarTemaLista);

        quitarTemaLista.setText("Quitar Tema de Lista");
        jMenu3.add(quitarTemaLista);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Favoritos");

        guardarTLA.setText("Guardar Tema/Lista/Album");
        jMenu4.add(guardarTLA);

        eliminarTLA.setText("Eliminar Tema/Lista/Album");
        jMenu4.add(eliminarTLA);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Datos de Prueba");

        cargarDatos.setText("Cargar");
        jMenu5.add(cargarDatos);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMenu, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMenu)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dejarSeguirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dejarSeguirUsuarioActionPerformed
        DejarSeguirUsuario dsu = new DejarSeguirUsuario();
        PanelMenu.add(dsu);
        dsu.show();
    }//GEN-LAST:event_dejarSeguirUsuarioActionPerformed

    private void consultaPerfilClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaPerfilClienteActionPerformed
        ConsultaPerfil cpc = new ConsultaPerfil("Cliente");
        PanelMenu.add(cpc);
        cpc.show();
    }//GEN-LAST:event_consultaPerfilClienteActionPerformed

    private void seguirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seguirUsuarioActionPerformed
        SeguirUsuario cpc = new SeguirUsuario();
        PanelMenu.add(cpc);
        cpc.show();
    }//GEN-LAST:event_seguirUsuarioActionPerformed

    private void consultaPerfilArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaPerfilArtistaActionPerformed
        ConsultaPerfil cpc = new ConsultaPerfil("Artista");
        PanelMenu.add(cpc);
        cpc.show();
    }//GEN-LAST:event_consultaPerfilArtistaActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane PanelMenu;
    private javax.swing.JMenuItem agregarTemaLista;
    private javax.swing.JMenuItem altaAlbum;
    private javax.swing.JMenuItem altaGenero;
    private javax.swing.JMenuItem altaPerfil;
    private javax.swing.JMenuItem cargarDatos;
    private javax.swing.JMenuItem consultaAlbum;
    private javax.swing.JMenuItem consultaListaRep;
    private javax.swing.JMenuItem consultaPerfilArtista;
    private javax.swing.JMenuItem consultaPerfilCliente;
    private javax.swing.JMenuItem crearListaRep;
    private javax.swing.JMenuItem dejarSeguirUsuario;
    private javax.swing.JMenuItem eliminarTLA;
    private javax.swing.JMenuItem guardarTLA;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem publicarLista;
    private javax.swing.JMenuItem quitarTemaLista;
    private javax.swing.JMenuItem seguirUsuario;
    // End of variables declaration//GEN-END:variables
}
