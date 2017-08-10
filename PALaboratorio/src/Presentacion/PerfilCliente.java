package Presentacion;

import Logica.DtAlbum;
import Logica.DtCliente;
import Logica.DtLista;
import Logica.DtListaParticular;
import Logica.DtPerfilCliente;
import Logica.DtTema;
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
        
        
        // Cargar Seguidores
        ((TitledBorder) panelSeguidores.getBorder()).setTitle("Seguidores (" + dtPerfilCliente.getSeguidores().size() + "):");
        
        DefaultTableModel dtmSeguidores = (DefaultTableModel) talbaSeguidores.getModel();
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
        
        // Cargar Seguidos
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
        
        // Cargar Listas Creadas
        ((TitledBorder) panelListasCreadas.getBorder()).setTitle("Listas Creadas (" + dtPerfilCliente.getListasCreadas().size() + "):");
        
        DefaultTableModel dtmListasCreadas = (DefaultTableModel) tablaListasCreadas.getModel();
        dtmListasCreadas.setRowCount(0);
        for (DtListaParticular dtlp : dtPerfilCliente.getListasCreadas()) {
            Object[] data = {
                dtlp.getNombre(),
                dtlp.getTemas().size()
            };
            dtmListasCreadas.addRow(data);
        }
        
        // Cargar Listas Favoritos
        ((TitledBorder) panelListasFavs.getBorder()).setTitle("Listas Favoritas (" + dtPerfilCliente.getListasFavoritas().size() + "):");
        
        DefaultTableModel dtmListasFavs = (DefaultTableModel) tablaListasFavs.getModel();
        dtmListasFavs.setRowCount(0);
        for (DtLista dtl : dtPerfilCliente.getListasFavoritas()) {
            Object[] data = {
                dtl.getNombre(),
                dtl.getTemas().size()
            };
        }
        
        // Cargar Albumes Favoritos
        ((TitledBorder) panelAlbumes.getBorder()).setTitle("Albumes Favoritos (" + dtPerfilCliente.getAlbumes().size() + "):");
        
        DefaultTableModel dtmAlbumes = (DefaultTableModel) tablaAlbumes.getModel();
        dtmAlbumes.setRowCount(0);
        for (DtAlbum dta : dtPerfilCliente.getAlbumes()) {
            Object[] data = {
                dta.getNickArtista(),
                dta.getNombre(),
                dta.getAnio()
            };
            dtmAlbumes.addRow(data);
        }
        
        // Cargar Temas Favoritos
        ((TitledBorder) panelTemas.getBorder()).setTitle("Temas Favoritos (" + dtPerfilCliente.getTemas().size() + "):");
        
        DefaultTableModel dtmTemas = (DefaultTableModel) tablaTemas.getModel();
        dtmTemas.setRowCount(0);
        for (DtTema dtt : dtPerfilCliente.getTemas()) {
            Object[] data = {
                dtt.getNombre(),
                dtt.getDuracion()
            };
            dtmTemas.addRow(data);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InfoYListasCreadas = new javax.swing.JSplitPane();
        PanelInfo = new javax.swing.JPanel();
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
        spanelSocial = new javax.swing.JSplitPane();
        panelSeguidores = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        talbaSeguidores = new javax.swing.JTable();
        panelSeguidos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaSeguidos = new javax.swing.JTable();
        spanelListas = new javax.swing.JSplitPane();
        panelListasCreadas = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaListasCreadas = new javax.swing.JTable();
        panelListasFavs = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaListasFavs = new javax.swing.JTable();
        spanelAlbumTemas = new javax.swing.JSplitPane();
        panelAlbumes = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaAlbumes = new javax.swing.JTable();
        panelTemas = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaTemas = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Perfil del Cliente ");
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        InfoYListasCreadas.setDividerLocation(450);

        PanelInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion Basica:"));

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

        javax.swing.GroupLayout PanelInfoLayout = new javax.swing.GroupLayout(PanelInfo);
        PanelInfo.setLayout(PanelInfoLayout);
        PanelInfoLayout.setHorizontalGroup(
            PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(46, 46, 46)
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNickname)
                    .addComponent(txtNombre)
                    .addComponent(txtApellido)
                    .addComponent(txtEmail)
                    .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        PanelInfoLayout.setVerticalGroup(
            PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        InfoYListasCreadas.setLeftComponent(PanelInfo);

        spanelSocial.setDividerLocation(240);

        panelSeguidores.setBorder(javax.swing.BorderFactory.createTitledBorder("Seguidores:"));

        talbaSeguidores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nickname"
            }
        ));
        jScrollPane1.setViewportView(talbaSeguidores);

        javax.swing.GroupLayout panelSeguidoresLayout = new javax.swing.GroupLayout(panelSeguidores);
        panelSeguidores.setLayout(panelSeguidoresLayout);
        panelSeguidoresLayout.setHorizontalGroup(
            panelSeguidoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
        );
        panelSeguidoresLayout.setVerticalGroup(
            panelSeguidoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
        );

        spanelSocial.setLeftComponent(panelSeguidores);

        panelSeguidos.setBorder(javax.swing.BorderFactory.createTitledBorder("Seguidos:"));

        tablaSeguidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nickname", "Tipo"
            }
        ));
        jScrollPane2.setViewportView(tablaSeguidos);

        javax.swing.GroupLayout panelSeguidosLayout = new javax.swing.GroupLayout(panelSeguidos);
        panelSeguidos.setLayout(panelSeguidosLayout);
        panelSeguidosLayout.setHorizontalGroup(
            panelSeguidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
        );
        panelSeguidosLayout.setVerticalGroup(
            panelSeguidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
        );

        spanelSocial.setRightComponent(panelSeguidos);

        InfoYListasCreadas.setRightComponent(spanelSocial);

        getContentPane().add(InfoYListasCreadas);

        spanelListas.setDividerLocation(450);

        panelListasCreadas.setBorder(javax.swing.BorderFactory.createTitledBorder("Listas Creadas:"));

        tablaListasCreadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cant. Temas"
            }
        ));
        jScrollPane6.setViewportView(tablaListasCreadas);

        javax.swing.GroupLayout panelListasCreadasLayout = new javax.swing.GroupLayout(panelListasCreadas);
        panelListasCreadas.setLayout(panelListasCreadasLayout);
        panelListasCreadasLayout.setHorizontalGroup(
            panelListasCreadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
        );
        panelListasCreadasLayout.setVerticalGroup(
            panelListasCreadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
        );

        spanelListas.setLeftComponent(panelListasCreadas);

        panelListasFavs.setBorder(javax.swing.BorderFactory.createTitledBorder("Listas Favoritas:"));

        tablaListasFavs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cant. Temas"
            }
        ));
        jScrollPane3.setViewportView(tablaListasFavs);

        javax.swing.GroupLayout panelListasFavsLayout = new javax.swing.GroupLayout(panelListasFavs);
        panelListasFavs.setLayout(panelListasFavsLayout);
        panelListasFavsLayout.setHorizontalGroup(
            panelListasFavsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
        );
        panelListasFavsLayout.setVerticalGroup(
            panelListasFavsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListasFavsLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        spanelListas.setRightComponent(panelListasFavs);

        getContentPane().add(spanelListas);

        spanelAlbumTemas.setDividerLocation(450);

        panelAlbumes.setBorder(javax.swing.BorderFactory.createTitledBorder("Albumes Favoritos:"));

        tablaAlbumes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Artista", "Nombre", "Año"
            }
        ));
        jScrollPane5.setViewportView(tablaAlbumes);

        javax.swing.GroupLayout panelAlbumesLayout = new javax.swing.GroupLayout(panelAlbumes);
        panelAlbumes.setLayout(panelAlbumesLayout);
        panelAlbumesLayout.setHorizontalGroup(
            panelAlbumesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
        );
        panelAlbumesLayout.setVerticalGroup(
            panelAlbumesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlbumesLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        spanelAlbumTemas.setLeftComponent(panelAlbumes);

        panelTemas.setBorder(javax.swing.BorderFactory.createTitledBorder("Temas Favoritos:"));

        tablaTemas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Duracion"
            }
        ));
        jScrollPane4.setViewportView(tablaTemas);

        javax.swing.GroupLayout panelTemasLayout = new javax.swing.GroupLayout(panelTemas);
        panelTemas.setLayout(panelTemasLayout);
        panelTemasLayout.setHorizontalGroup(
            panelTemasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
        );
        panelTemasLayout.setVerticalGroup(
            panelTemasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
        );

        spanelAlbumTemas.setRightComponent(panelTemas);

        getContentPane().add(spanelAlbumTemas);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSplitPane InfoYListasCreadas;
    private javax.swing.JPanel PanelInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPanel panelAlbumes;
    private javax.swing.JPanel panelListasCreadas;
    private javax.swing.JPanel panelListasFavs;
    private javax.swing.JPanel panelSeguidores;
    private javax.swing.JPanel panelSeguidos;
    private javax.swing.JPanel panelTemas;
    private javax.swing.JSplitPane spanelAlbumTemas;
    private javax.swing.JSplitPane spanelListas;
    private javax.swing.JSplitPane spanelSocial;
    private javax.swing.JTable tablaAlbumes;
    private javax.swing.JTable tablaListasCreadas;
    private javax.swing.JTable tablaListasFavs;
    private javax.swing.JTable tablaSeguidos;
    private javax.swing.JTable tablaTemas;
    private javax.swing.JTable talbaSeguidores;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtNickname;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}


