
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
        usuario = new javax.swing.JMenuItem();
        genero = new javax.swing.JMenuItem();
        album = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        dejarSeguirUsuario = new javax.swing.JMenuItem();
        consultaPerfilCliente = new javax.swing.JMenuItem();

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
            .addGap(0, 393, Short.MAX_VALUE)
        );

        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jMenu1.setBackground(new java.awt.Color(204, 204, 255));
        jMenu1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu1.setText("Registros");

        usuario.setText("Registrar Usuario");
        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });
        jMenu1.add(usuario);

        genero.setText("Registrar Género");
        genero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generoActionPerformed(evt);
            }
        });
        jMenu1.add(genero);

        album.setText("Registrar Álbum");
        album.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                albumActionPerformed(evt);
            }
        });
        jMenu1.add(album);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Usuario");

        dejarSeguirUsuario.setText("Dejar de Seguir Usuario");
        dejarSeguirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dejarSeguirUsuarioActionPerformed(evt);
            }
        });
        jMenu3.add(dejarSeguirUsuario);

        consultaPerfilCliente.setText("Consulta Perfil Cliente");
        consultaPerfilCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaPerfilClienteActionPerformed(evt);
            }
        });
        jMenu3.add(consultaPerfilCliente);

        jMenuBar1.add(jMenu3);

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
    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        AltarUsuario user = new AltarUsuario();
        this.PanelMenu.add(user);
        user.show();
    }//GEN-LAST:event_usuarioActionPerformed

    private void generoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generoActionPerformed
       AltaArtista  art = new AltaArtista();
       this.PanelMenu.add(art);
       art.show();
    }//GEN-LAST:event_generoActionPerformed

    private void albumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_albumActionPerformed
        AltaAlbum alb = new AltaAlbum();
        this.PanelMenu.add(alb);
        alb.show();
    }//GEN-LAST:event_albumActionPerformed

    private void dejarSeguirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dejarSeguirUsuarioActionPerformed
        DejarSeguirUsuario dsu = new DejarSeguirUsuario();
        this.PanelMenu.add(dsu);
        dsu.show();
    }//GEN-LAST:event_dejarSeguirUsuarioActionPerformed

    private void consultaPerfilClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaPerfilClienteActionPerformed
        ConsultaPerfilCliente cpc = new ConsultaPerfilCliente();
        this.PanelMenu.add(cpc);
        cpc.show();
    }//GEN-LAST:event_consultaPerfilClienteActionPerformed


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
    private javax.swing.JMenuItem album;
    private javax.swing.JMenuItem consultaPerfilCliente;
    private javax.swing.JMenuItem dejarSeguirUsuario;
    private javax.swing.JMenuItem genero;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem usuario;
    // End of variables declaration//GEN-END:variables
}
