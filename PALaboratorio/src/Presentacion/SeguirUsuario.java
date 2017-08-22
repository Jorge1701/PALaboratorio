package Presentacion;

import Logica.DtArtista;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IUsuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class SeguirUsuario extends javax.swing.JInternalFrame implements ListSelectionListener {

    private final IUsuario iUsuario;

    public SeguirUsuario() {
        initComponents();
        iUsuario = Fabrica.getIControladorUsuario();

        cargarDatos();

        // Hace que al hacer click en una fila de la tablaClientes se llame al metodo valueChanged()
        tablaClientes.getSelectionModel().addListSelectionListener(this);
    }

    private void cargarDatos() {
        // Obtiene todo los clientes
        ArrayList<DtUsuario> dtcs = iUsuario.listarClientes();

        // Obtiene el modelo de la tablaClientes y borra su contenido
        DefaultTableModel dtm = (DefaultTableModel) tablaClientes.getModel();
        dtm.setRowCount(0);

        // Agrega los clientes a la tablaClientes
        for (DtUsuario dtu : dtcs) {
            Object[] data = {
                dtu.getNickname(),
                dtu.getNombre(),
                dtu.getApellido(),
                dtu.getEmail()
            };
            dtm.addRow(data);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        botonAceptar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Seguir Usuario");
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jSplitPane1.setDividerLocation(250);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jSplitPane2.setDividerLocation(250);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuarios"));

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nickname", "Nombre", "Apellido", "Correo", "Tipo"
            }
        ));
        jScrollPane2.setViewportView(tablaUsuarios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
        );

        jSplitPane2.setTopComponent(jPanel2);

        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Al dar 'Aceptar' el cliente comenzara a seguir al usuario");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(botonAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonCancelar)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAceptar)
                    .addComponent(botonCancelar)
                    .addComponent(jLabel1))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jSplitPane2.setRightComponent(jPanel3);

        jSplitPane1.setBottomComponent(jSplitPane2);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Clientes"));

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nickname", "Nombre", "Apellido", "Correo"
            }
        ));
        jScrollPane1.setViewportView(tablaClientes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
        );

        jSplitPane1.setLeftComponent(jPanel1);

        getContentPane().add(jSplitPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void valueChanged(ListSelectionEvent e) {
        // Obtiene el nick del cliente seleccionado y se lo pasa a la funcion cliente seleccionado
        if (tablaClientes.getSelectedRow() != -1) {
            clienteSeleccionado(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString());
        }
    }

    private void clienteSeleccionado(String nickCliente) {
        //Lista en tablaUsuarios los usuarios que el cliente nickCliente puede seguir
        ArrayList<DtUsuario> usuarios = iUsuario.listarUsuarios();

        DefaultTableModel dtm = (DefaultTableModel) tablaUsuarios.getModel();
        dtm.setRowCount(0);

        for (DtUsuario dtu : usuarios) {
            String nick = dtu.getNickname();
            boolean esta = false;

            for (DtUsuario d : iUsuario.listarSeguidosDe(nickCliente)) {
                if (d.getNickname() == dtu.getNickname()) {
                    esta = true;
                }
            }

            if (nick != nickCliente && !esta) {
                Object[] data = {
                    nick,
                    dtu.getNombre(),
                    dtu.getApellido(),
                    dtu.getEmail(),
                    (dtu instanceof DtArtista ? "Artista" : "Cliente")
                };
                dtm.addRow(data);
            }
        }
    }

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        String tablasSinSeleccionar = "";

        if (tablaClientes.getSelectionModel().isSelectionEmpty()) {
            tablasSinSeleccionar += "\nClientes";
        }

        if (tablaUsuarios.getSelectionModel().isSelectionEmpty()) {
            tablasSinSeleccionar += "\nUsuarios";
        }

        if (!tablasSinSeleccionar.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila en las siguientes tablas:\n" + tablasSinSeleccionar);
            return;
        }

        String cliente = tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString();
        String usuario = tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0).toString();

        try {
            iUsuario.seguirUsuario(cliente, usuario);
            JOptionPane.showMessageDialog(this, "El cliente " + cliente + " comenzo a seguir al usuario " + usuario);
        } catch (UnsupportedOperationException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        cargarDatos();

        DefaultTableModel dtm = (DefaultTableModel) tablaUsuarios.getModel();
        dtm.setRowCount(0);
    }//GEN-LAST:event_botonAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaUsuarios;
    // End of variables declaration//GEN-END:variables
}
