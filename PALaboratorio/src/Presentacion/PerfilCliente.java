package Presentacion;

import Logica.DtCliente;
import Logica.DtPerfilCliente;
import Logica.DtUsuario;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PerfilCliente extends javax.swing.JInternalFrame {
    
    
    public PerfilCliente(DtPerfilCliente dtPerfilCliente) {
        initComponents();
        setTitle(getTitle() + dtPerfilCliente.getInfo().getNickname());
        
        txtNickname.setText(dtPerfilCliente.getInfo().getNickname());
        txtNombre.setText(dtPerfilCliente.getInfo().getNombre());
        txtApellido.setText(dtPerfilCliente.getInfo().getApellido());
        txtEmail.setText(dtPerfilCliente.getInfo().getEmail());
        txtFechaNac.setText(dtPerfilCliente.getInfo().getFechaNac().toString());
        
        ((TitledBorder) panelSeguidores.getBorder()).setTitle("Seguidores (" + dtPerfilCliente.getSeguidores().size() + "):");
        
        DefaultTableModel dtmSeguidores = (DefaultTableModel) tablaSeguidores.getModel();
        dtmSeguidores.setRowCount(0);
        for (DtCliente dtc : dtPerfilCliente.getSeguidores()) {
            Object[] data = {
                dtc.getNickname(),
                dtc.getNombre(),
                dtc.getApellido(),
                dtc.getEmail(),
                dtc.getFechaNac().toString(),
            };
            dtmSeguidores.addRow(data);
        }
        
        ((TitledBorder) panelSeguidos.getBorder()).setTitle("Seguidos (" + dtPerfilCliente.getSeguidos().size() + "):");
        
        DefaultTableModel dtmSeguidos = (DefaultTableModel) tablaSeguidos.getModel();
        dtmSeguidos.setRowCount(0);
        for (DtUsuario dtc : dtPerfilCliente.getSeguidos()) {
            Object[] data = {
                dtc.getNickname(),
                (dtc instanceof DtCliente ? "Cliente" : "Artista")
            };
            dtmSeguidos.addRow(data);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtNickname = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFechaNac = new javax.swing.JTextField();
        panelSeguidores = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaSeguidores = new javax.swing.JTable();
        panelSeguidos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSeguidos = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Perfil del Cliente ");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion Basica:"));

        jLabel5.setText("Fecha Nac.");

        txtNickname.setEnabled(false);

        txtNombre.setEnabled(false);

        txtApellido.setEnabled(false);

        txtEmail.setEnabled(false);

        jLabel1.setText("Nickname");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        jLabel4.setText("Email");

        txtFechaNac.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNickname)
                    .addComponent(txtNombre)
                    .addComponent(txtApellido)
                    .addComponent(txtEmail)
                    .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelSeguidores.setBorder(javax.swing.BorderFactory.createTitledBorder("Seguidores:"));

        tablaSeguidores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nickname"
            }
        ));
        jScrollPane2.setViewportView(tablaSeguidores);

        javax.swing.GroupLayout panelSeguidoresLayout = new javax.swing.GroupLayout(panelSeguidores);
        panelSeguidores.setLayout(panelSeguidoresLayout);
        panelSeguidoresLayout.setHorizontalGroup(
            panelSeguidoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        panelSeguidoresLayout.setVerticalGroup(
            panelSeguidoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
        );

        panelSeguidos.setBorder(javax.swing.BorderFactory.createTitledBorder("Sigue a:"));

        tablaSeguidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nickname", "Tipo"
            }
        ));
        jScrollPane1.setViewportView(tablaSeguidos);
        if (tablaSeguidos.getColumnModel().getColumnCount() > 0) {
            tablaSeguidos.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout panelSeguidosLayout = new javax.swing.GroupLayout(panelSeguidos);
        panelSeguidos.setLayout(panelSeguidosLayout);
        panelSeguidosLayout.setHorizontalGroup(
            panelSeguidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
        );
        panelSeguidosLayout.setVerticalGroup(
            panelSeguidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(panelSeguidos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelSeguidores, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSeguidores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSeguidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelSeguidores;
    private javax.swing.JPanel panelSeguidos;
    private javax.swing.JTable tablaSeguidores;
    private javax.swing.JTable tablaSeguidos;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtNickname;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}


