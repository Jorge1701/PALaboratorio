
package Presentacion;

import Logica.DtGenero;
import Logica.DtTema;
import Logica.DtTemaLocal;
import Logica.DtTemaRemoto;
import Logica.DtTime;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IContenido;
import com.sun.glass.events.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

 

public class AltaAlbum extends javax.swing.JInternalFrame {
    
    private IContenido iContenido;
    ArrayList<String> generos;
    DefaultListModel<String> model;
    private final JFileChooser archivoTema;
    ArrayList<DtTema> temas;
    String pathMp3;
    DefaultTableModel dtm;
    
    public AltaAlbum() {
        initComponents();
        archivoTema = new JFileChooser();
        archivoTema.setFileFilter(new FileNameExtensionFilter("mp3 files" , "mp3"));
        this.iContenido = Fabrica.getIControladorContenido();
        temas = new ArrayList<DtTema>();
        mostrarGeneros();
        //jScrollPane2.setViewportView(ListaGeneros);
        buttonStream.setSelected(true);
        mostrarTema();
        dtm = (DefaultTableModel) tableTemas.getModel();
        dtm.setRowCount(0);
        pathMp3 = "";
        
    }
    
    private DefaultMutableTreeNode getNodo(DtGenero g) {
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode(g.getNombre());
        for (DtGenero dtg : g.getSubGeneros()) {
            DefaultMutableTreeNode hijo = getNodo(dtg);
            padre.add(hijo);
        }
        return padre;
    }
    
    
    void mostrarGeneros() {    
       
        jTreeGeneros.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        DtGenero g = iContenido.listarGenero();

        DefaultTreeModel modelo = new DefaultTreeModel(getNodo(g));
        jTreeGeneros.setModel(modelo);
        
        model = new DefaultListModel<>();
        jListGros.setModel(model);
        generos = new ArrayList<>();
    }
    
    void mostrarTema() {
        if(buttonStream.isSelected()){
            txtStremTema.setEnabled(true);
            btnSelecMp3.setEnabled(false);
        
        } else if (buttonArch.isSelected()) {
            txtStremTema.setEnabled(false);
            btnSelecMp3.setEnabled(true);
        }
        
        
    
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btonGroupTema = new javax.swing.ButtonGroup();
        AlbumTx = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreAlbum = new javax.swing.JTextField();
        txtNick = new javax.swing.JTextField();
        NombreTx = new javax.swing.JLabel();
        comboAnio = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTreeGeneros = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListGros = new javax.swing.JList<>();
        jbtnAgregarGro = new javax.swing.JButton();
        btnQuitarGro = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNomTema = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        buttonArch = new javax.swing.JRadioButton();
        buttonStream = new javax.swing.JRadioButton();
        btnAgregarTema = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtUbicacionTema = new javax.swing.JTextField();
        txtStremTema = new javax.swing.JTextField();
        Date date = new Date();
        SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        jSpinnerDuracion = new javax.swing.JSpinner(sm);
        jScrollPane3 = new javax.swing.JScrollPane();
        tableTemas = new javax.swing.JTable();
        btnSelecMp3 = new javax.swing.JButton();
        lblImagen = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setFocusCycleRoot(false);
        setMaximumSize(new java.awt.Dimension(214748, 214748));

        AlbumTx.setText("Nombre De Album :");

        jLabel2.setText("Año :");

        txtNick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNickActionPerformed(evt);
            }
        });

        NombreTx.setText("Nick De Artista :");

        comboAnio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", " " }));
        comboAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAnioActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Generos"));
        jPanel1.setName("Generos"); // NOI18N

        jTreeGeneros.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeGenerosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTreeGeneros);

        jScrollPane2.setViewportView(jListGros);

        jbtnAgregarGro.setText("Agregar");
        jbtnAgregarGro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarGroActionPerformed(evt);
            }
        });

        btnQuitarGro.setText("Quitar");
        btnQuitarGro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarGroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 62, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jbtnAgregarGro)
                .addGap(121, 121, 121)
                .addComponent(btnQuitarGro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuitarGro)
                    .addComponent(jbtnAgregarGro)))
        );

        jButton2.setText("Cancelar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton1.setText("Guardar Album");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tenas"));

        jLabel1.setText("Nombre:");

        jLabel3.setText("Duracion:");

        btonGroupTema.add(buttonArch);
        buttonArch.setText("Archivo");
        buttonArch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonArchActionPerformed(evt);
            }
        });

        btonGroupTema.add(buttonStream);
        buttonStream.setText("Stream");
        buttonStream.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStreamActionPerformed(evt);
            }
        });

        btnAgregarTema.setText("Agregar");
        btnAgregarTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTemaActionPerformed(evt);
            }
        });

        jLabel4.setText("Ubicacion");

        JSpinner.DateEditor de = new JSpinner.DateEditor(jSpinnerDuracion, "HH:mm:ss");
        jSpinnerDuracion.setEditor(de);
        jSpinnerDuracion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSpinnerDuracion.setFocusable(false);

        tableTemas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Ubicacion", "Duración", "Path o Url"
            }
        ));
        jScrollPane3.setViewportView(tableTemas);

        btnSelecMp3.setText("Select .mp3..");
        btnSelecMp3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecMp3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAgregarTema)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinnerDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUbicacionTema, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(buttonStream))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(txtStremTema, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonArch)
                            .addComponent(btnSelecMp3))
                        .addGap(37, 37, 37))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtNomTema, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNomTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonStream)
                        .addComponent(buttonArch))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jSpinnerDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addComponent(txtStremTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtUbicacionTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSelecMp3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btnAgregarTema)
                        .addGap(51, 51, 51))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        lblImagen.setText("Imagen");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jButton1)
                        .addGap(233, 233, 233)
                        .addComponent(jButton2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(248, 248, 248))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(NombreTx, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(41, 41, 41)
                                    .addComponent(txtNick, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblImagen))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(AlbumTx)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreTx)
                    .addComponent(txtNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AlbumTx))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblImagen)
                .addGap(18, 40, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(25, 25, 25))
        );

        jPanel2.getAccessibleContext().setAccessibleName("Temas");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAnioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboAnioActionPerformed

    private void txtNickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNickActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNickActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nickA = txtNick.getText();
        String album = txtNombreAlbum.getText();
        int anio = Integer.parseInt(comboAnio.getSelectedItem().toString());
        String camposVacios = "";
        if (nickA.isEmpty()) {
            camposVacios += "Nick Artista\n";
        }
        if (album.isEmpty()) {
            camposVacios += "Nombre Album \n";
        }
        
        if (!camposVacios.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hay campos obligatorios vacios:\n" + camposVacios);
            return;
        }
        
        try {
            iContenido.selectArtista(nickA);
            
            //generos.add("Rock");
            
            //DtTema dtT = new DtTema( "pista1", new DtTime(0, 2, 23), 1);
            //ArrayList<DtTema> temas = new ArrayList<DtTema>();
            //temas.add(dtT);
            
            iContenido.ingresarAlbum(album, anio, generos, temas);
            
            
        } catch (UnsupportedOperationException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            return;
        }
        
        JOptionPane.showMessageDialog(this, "Se ingreso Album");
        txtNick.setText("");
        txtNombreAlbum.setText("");
        dtm.setRowCount(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
    dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jTreeGenerosValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeGenerosValueChanged
        // TODO add your handling code here:
              
    }//GEN-LAST:event_jTreeGenerosValueChanged

    private void jbtnAgregarGroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarGroActionPerformed
        // TODO add your handling code here:
        
        DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) jTreeGeneros.getSelectionPath().getLastPathComponent();
        
        if (selectedElement.isRoot()) {
            JOptionPane.showMessageDialog(this, "No puede seleccionar nodo Raiz:\n");
        } else {
            String generoSeleccionado = selectedElement.getUserObject().toString();        
            generos.add(generoSeleccionado);
            model.addElement(generoSeleccionado);
        }
        
    }//GEN-LAST:event_jbtnAgregarGroActionPerformed

    private void btnQuitarGroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarGroActionPerformed
        // TODO add your handling code here:
       
        String pos = jListGros.getSelectedValue();
        if (pos != null){
            generos.remove(pos);
            model.removeElement(pos);        
        } else{
            JOptionPane.showMessageDialog(this, "Debe seleccionar un genero:\n");
        }
        
    }//GEN-LAST:event_btnQuitarGroActionPerformed

    private void btnSelecMp3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecMp3ActionPerformed
        // TODO add your handling code here:
        
         try {
             int retorno = archivoTema.showOpenDialog(this);        
             File arch = archivoTema.getSelectedFile();
             pathMp3 = "C:\\temp\\"+ arch.getName();
             if (arch != null) {
                  InputStream is = new FileInputStream(arch);
                    OutputStream outstream = new FileOutputStream(new File(pathMp3));
                    byte[] buffer = new byte[4096];
                    int len;
                    while ((len = is.read(buffer)) > 0) {
                        outstream.write(buffer, 0, len);
                    }
                    outstream.close();
                    JOptionPane.showMessageDialog(null, "El archivo se a guardado Exitosamente", "Información",JOptionPane.INFORMATION_MESSAGE);
             
             }
             
            
        } catch (FileNotFoundException ex) {
             JOptionPane.showMessageDialog(null, "El directorio o nombre de archivo incorrecto.","Error", JOptionPane.WARNING_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(AltaAlbum.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
    }//GEN-LAST:event_btnSelecMp3ActionPerformed

    private void buttonStreamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStreamActionPerformed
       mostrarTema();
    }//GEN-LAST:event_buttonStreamActionPerformed

    private void buttonArchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonArchActionPerformed
        mostrarTema();
    }//GEN-LAST:event_buttonArchActionPerformed

    private void btnAgregarTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTemaActionPerformed
        
        String nomTema = txtNomTema.getText();
        Date time = new Date();
        time  = (Date) jSpinnerDuracion.getValue();
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        DtTime dtTime = new DtTime(cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
        //System.out.println(cal.get(Calendar.HOUR));
        //System.out.println(cal.get(Calendar.MINUTE));
        //System.out.println(cal.get(Calendar.SECOND));
        String ubicacion = txtUbicacionTema.getText();
        String stream;
        String pathtArch;
        DtTema dtTema;
        
        String camposVacios = "";
        if (nomTema.isEmpty()) {
            camposVacios += "Nombre Tema\n";
        }
        
        if (ubicacion.isEmpty()) {
            camposVacios += "Ubicacion Tema\n";
        }
                
        if (!camposVacios.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hay campos obligatorios vacios:\n" + camposVacios);
            return;
        }
        
        if( txtStremTema.isEnabled()){
            stream = txtStremTema.getText();
            if(stream.isEmpty()){
                JOptionPane.showMessageDialog(this, "Debe indicar la url");
                return;            
            }
            dtTema = new DtTemaRemoto(stream, nomTema, dtTime, Integer.parseInt(ubicacion));
            Object[] data = {
                nomTema,
                ubicacion,
                dtTime.getHoras() + ":" + dtTime.getMinutos() + ":" + dtTime.getSegundos(),                
                stream,};
            dtm.addRow(data);
            System.out.println("Agrego tema" + nomTema);
            temas.add(dtTema);
            
        } else if(btnSelecMp3.isEnabled()){
            
            if(pathMp3 == ""){                
                JOptionPane.showMessageDialog(this, "Debe seleccionar un archivo");
                return;              
            }
            dtTema = new DtTemaLocal(pathMp3, nomTema, dtTime, Integer.parseInt(ubicacion));
            Object[] data = {
                nomTema,
                ubicacion,
                dtTime.getHoras() + ":" + dtTime.getMinutos() + ":" + dtTime.getSegundos(),                
                pathMp3,};
            dtm.addRow(data);
            System.out.println("Agrego Tema" + nomTema);
            temas.add(dtTema);
            pathMp3 = "";
            
                    
        }
        
        txtStremTema.setText("");
        txtUbicacionTema.setText("");
        txtNomTema.setText("");
        
    }//GEN-LAST:event_btnAgregarTemaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AlbumTx;
    private javax.swing.JLabel NombreTx;
    private javax.swing.JButton btnAgregarTema;
    private javax.swing.JButton btnQuitarGro;
    private javax.swing.JButton btnSelecMp3;
    private javax.swing.ButtonGroup btonGroupTema;
    private javax.swing.JRadioButton buttonArch;
    private javax.swing.JRadioButton buttonStream;
    private javax.swing.JComboBox<String> comboAnio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jListGros;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinnerDuracion;
    private javax.swing.JTree jTreeGeneros;
    private javax.swing.JButton jbtnAgregarGro;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JTable tableTemas;
    private javax.swing.JTextField txtNick;
    private javax.swing.JTextField txtNomTema;
    private javax.swing.JTextField txtNombreAlbum;
    private javax.swing.JTextField txtStremTema;
    private javax.swing.JTextField txtUbicacionTema;
    // End of variables declaration//GEN-END:variables
}


