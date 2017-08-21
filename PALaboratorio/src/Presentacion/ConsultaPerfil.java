package Presentacion;

import Logica.DtArtista;
import Logica.DtUsuario;
import Logica.DtCliente;
import Logica.DtPerfilArtista;
import Logica.DtPerfilCliente;
import Logica.DtPerfilUsuario;
import Logica.Fabrica;
import Logica.IUsuario;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultaPerfil extends javax.swing.JInternalFrame {

    private IUsuario iUsuario;
    private String tipo;

    public ConsultaPerfil(String tipo) {
        initComponents();
        this.tipo = tipo;

        iUsuario = Fabrica.getIControladorUsuario();
        ArrayList<DtUsuario> dtc = null;

        ArrayList<DtUsuario> dta = null;

        if (tipo.equals("Cliente")) {
            dtc = iUsuario.listarClientes();
            if (dtc.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay ningun cliente registrado");
            }

            DefaultTableModel dtm = (DefaultTableModel) tablaClientes.getModel();
            dtm.setRowCount(0);
            for (DtUsuario dtUsuario : dtc) {
                Object[] data = {
                    ((DtCliente) dtUsuario).getNickname(),
                    ((DtCliente) dtUsuario).getNombre(),
                    ((DtCliente) dtUsuario).getApellido(),
                    ((DtCliente) dtUsuario).getEmail(),
                    ((DtCliente) dtUsuario).getFechaNac().toString()
                };
                dtm.addRow(data);
            }
        } else if (tipo.equals("Artista")) {
            dta = iUsuario.listarArtistas();
            if (dta.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay ningun artista registrado");
            }

            DefaultTableModel dtm2 = (DefaultTableModel) tablaClientes.getModel();
            dtm2.setRowCount(0);
            for (DtUsuario dtUsuario : dta) {
                Object[] data = {
                    ((DtArtista) dtUsuario).getNickname(),
                    ((DtArtista) dtUsuario).getNombre(),
                    ((DtArtista) dtUsuario).getApellido(),
                    ((DtArtista) dtUsuario).getEmail(),
                    ((DtArtista) dtUsuario).getFechaNac().toString()
                };
                dtm2.addRow(data);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Consulta de Perfil");

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nickname", "Nombre", "Apellido", "Email", "Fecha Nac."
            }
        ));
        jScrollPane1.setViewportView(tablaClientes);

        jLabel1.setText("Seleccione un usuario y presione 'Aceptar' para ver su perfil");

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (tablaClientes.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "No hay ningun usuario seleccionado");
            return;
        }

        String nickname = tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString();

        if (nickname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campos obligatorio vacios:\nNickname");
            return;
        }
        if (tipo.equals("Cliente")) {
            try {
                DtPerfilUsuario dtpu = iUsuario.obtenerPerfilCliente(nickname);
                PerfilCliente pc = new PerfilCliente((DtPerfilCliente) dtpu);
                getParent().add(pc);
                pc.show();
            } catch (UnsupportedOperationException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else {
            try {
                DtPerfilUsuario dtpu = iUsuario.obtenerPerfilArtista(nickname);
                PerfilArtista pc = new PerfilArtista((DtPerfilArtista) dtpu);
                getParent().add(pc);
                pc.show();
            } catch (UnsupportedOperationException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaClientes;
    // End of variables declaration//GEN-END:variables
}
