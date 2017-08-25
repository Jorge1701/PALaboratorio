package Presentacion;

import Logica.DtAlbum;
import Logica.DtAlbumContenido;
import Logica.DtTema;
import Logica.DtTemaLocal;
import Logica.DtTemaRemoto;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class AlbumContenido extends javax.swing.JInternalFrame implements ListSelectionListener {
    
    public AlbumContenido(DtAlbumContenido dtac) {
        initComponents();
        btnAbrirNavegador.setVisible(false);
        tablaTemas.getColumnModel().getColumn(0).setMinWidth(0);
        tablaTemas.getColumnModel().getColumn(0).setMaxWidth(0);

        //Cargar la informacion
        DtAlbum info = dtac.getInfo();
        txtNombre.setText(info.getNombre());
        txtNickArtista.setText(info.getNickArtista());
        txtAnio.setText(Integer.toString(info.getAnio()));

        // Cargar imagen
        try {
            String imagen = dtac.getInfo().getImagen();
            BufferedImage img;
            if (imagen == null || imagen.isEmpty()) {
                img = ImageIO.read(PerfilCliente.class.getResource("/Recursos/Imagenes/Albumes/albumDefault.png"));
            } else {
                img = ImageIO.read(PerfilCliente.class.getResource(imagen));
            }
            PanelImagen pImg = new PanelImagen(img);
            imagenPanel.add(pImg);
            pImg.setBounds(0, 0, 136, 126);
            
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen del usuario");
        }

        //Cargar tabla de Temas
        DefaultTableModel dtm = (DefaultTableModel) tablaTemas.getModel();
        dtm.setRowCount(0);
        
        for (DtTema dtt : dtac.getTemas()) {
            Object[] data = {
                dtt instanceof DtTemaLocal ? "A" : "S",
                ((DtTema) dtt).getNombre(),
                ((DtTema) dtt).getDuracion().getHoras() + ":" + ((DtTema) dtt).getDuracion().getMinutos() + ":" + ((DtTema) dtt).getDuracion().getSegundos(),
                ((DtTema) dtt).getUbicacion(),
                dtt instanceof DtTemaLocal ? ((DtTemaLocal) dtt).getDirectorio() : ((DtTemaRemoto) dtt).getUrl()
            };
            dtm.addRow(data);
        }

        //Ordenar tabla por Ubicacion del tema
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tablaTemas.getModel());
        tablaTemas.setRowSorter(sorter);
        ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>();
        
        int columnIndexToSort = 3;
        sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
        
        sorter.setSortKeys(sortKeys);
        sorter.sort();

        //Cargar lista de generos
        ArrayList<String> generos = dtac.getGeneros();
        
        DefaultListModel<String> model = new DefaultListModel<>();
        lstGeneros.setModel(model);
        
        for (String g : generos) {
            model.addElement(g);
        }

        // Hace que al hacer click en una fila de la tablaClientes se llame al metodo valueChanged()
        tablaTemas.getSelectionModel().addListSelectionListener(this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtNickArtista = new javax.swing.JTextField();
        txtAnio = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTemas = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstGeneros = new javax.swing.JList<>();
        btnDescargar = new javax.swing.JButton();
        btnAbrirNavegador = new javax.swing.JButton();
        imagenPanel = new javax.swing.JPanel();

        setTitle("Informacion del album");

        jLabel1.setText("Nombre:");

        jLabel2.setText("Nickname del artista:");

        jLabel3.setText("Año de creacion:");

        txtNombre.setEditable(false);

        txtNickArtista.setEditable(false);

        txtAnio.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(txtNickArtista)
                    .addComponent(txtAnio))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNickArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSplitPane1.setDividerLocation(400);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Temas"));

        tablaTemas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Nombre", "Duracion", "Ubicacion", "Archivo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaTemas);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
        );

        jSplitPane1.setLeftComponent(jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Generos"));

        jScrollPane2.setViewportView(lstGeneros);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(jPanel5);

        btnDescargar.setText("Descargar");
        btnDescargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescargarActionPerformed(evt);
            }
        });

        btnAbrirNavegador.setText("Abrir en navegador");
        btnAbrirNavegador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirNavegadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imagenPanelLayout = new javax.swing.GroupLayout(imagenPanel);
        imagenPanel.setLayout(imagenPanelLayout);
        imagenPanelLayout.setHorizontalGroup(
            imagenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 136, Short.MAX_VALUE)
        );
        imagenPanelLayout.setVerticalGroup(
            imagenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnDescargar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAbrirNavegador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(imagenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addComponent(imagenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSplitPane1)
                        .addGap(23, 23, 23)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDescargar)
                            .addComponent(btnAbrirNavegador))
                        .addGap(29, 29, 29))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDescargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescargarActionPerformed
        if (tablaTemas.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe de seleccionar un tema");
            return;
        }
        
        String link = tablaTemas.getValueAt(tablaTemas.getSelectedRow(), 4).toString();
        if (btnDescargar.getText().equals("Descargar")) {
            
            JFileChooser fc = new JFileChooser();
            
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int o = fc.showOpenDialog(this);
            if (o == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fc.getSelectedFile();
                String path = selectedFile.getAbsolutePath();
                File archivo = new File(link);
                JOptionPane.showMessageDialog(this, link);
                if (!archivo.renameTo(new File(path + "\\" + archivo.getName()))) {
                    JOptionPane.showMessageDialog(this, "No se pudo descargar el archivo", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No selecciono una carpeta", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection data = new StringSelection(link);
            clipboard.setContents(data, data);
            JOptionPane.showMessageDialog(this, "Copiado al portapapeles: " + link);
        }
    }//GEN-LAST:event_btnDescargarActionPerformed

    private void btnAbrirNavegadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirNavegadorActionPerformed
        if (tablaTemas.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe de seleccionar un tema");
            return;
        }
        
        String link = tablaTemas.getValueAt(tablaTemas.getSelectedRow(), 4).toString();
        
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI("http://" + link));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo abrir el navegador", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (URISyntaxException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo abrir el navegador", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAbrirNavegadorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirNavegador;
    private javax.swing.JButton btnDescargar;
    private javax.swing.JPanel imagenPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JList<String> lstGeneros;
    private javax.swing.JTable tablaTemas;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtNickArtista;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (tablaTemas.getValueAt(tablaTemas.getSelectedRow(), 0).toString().equals("A")) {
            btnDescargar.setText("Descargar");
            btnAbrirNavegador.setVisible(false);
        } else {
            btnDescargar.setText("Copiar Link");
            btnAbrirNavegador.setVisible(true);
        }
    }
    
}
