/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Controladores.ControladorPersonas;
import Logica.Controladores.ControladorReclamos;
import Logica.DataTypes.DataTecnico;
import Logica.DataTypes.DataTipoArticulo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego
 */
public class AltaTecnicosCapacitados extends javax.swing.JInternalFrame implements ListSelectionListener {

    /**
     * Creates new form AltaTecnicosCapacitados
     */
    
    private final ArrayList<DataTipoArticulo> tipoArticulos;
    private ControladorReclamos CR = ControladorReclamos.getInstance();
    private ControladorPersonas CP = ControladorPersonas.getInstance();
    private DataTipoArticulo tArtSeleccionado = null;
    private DataTecnico tecSeleccionado;
    
    public AltaTecnicosCapacitados() {
        initComponents();
        tipoArticulos = (ArrayList<DataTipoArticulo>) CR.darTipoArticulos();
        cargarTipoArticulos(tipoArticulos, "");
        tablaTipoArticulos.getSelectionModel().addListSelectionListener(this);
    }
    
    
    private void cargarTipoArticulos(ArrayList<DataTipoArticulo> dtas, String filtro) {
        // Obtiene el modelo de la tablaClientes y borra su contenido
        DefaultTableModel dtm = (DefaultTableModel) tablaTipoArticulos.getModel();
        dtm.setRowCount(0);

        // Agrega los clientes a la tablaClientes
        for (DataTipoArticulo dtA : dtas) {
            if (dtA.getNombre().contains(filtro)) {
                Object[] data = {
                    dtA                   
                };
                dtm.addRow(data);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTecnicos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaTecnicos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTipoArticulos = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        jPanelTecnicos.setBorder(javax.swing.BorderFactory.createTitledBorder("Tecnicos"));

        tablaTecnicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Nombre", "Apellido", "CI"
            }
        ));
        jScrollPane2.setViewportView(tablaTecnicos);

        javax.swing.GroupLayout jPanelTecnicosLayout = new javax.swing.GroupLayout(jPanelTecnicos);
        jPanelTecnicos.setLayout(jPanelTecnicosLayout);
        jPanelTecnicosLayout.setHorizontalGroup(
            jPanelTecnicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
        );
        jPanelTecnicosLayout.setVerticalGroup(
            jPanelTecnicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Articulos"));
        jPanel1.setToolTipText("");

        tablaTipoArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Nombre"
            }
        ));
        jScrollPane1.setViewportView(tablaTipoArticulos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTecnicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(btnAceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTecnicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAceptar)
                .addContainerGap(225, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        if (tablaTipoArticulos.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de Articulo:\n");
            return;
        }
        
        if (tablaTecnicos.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Tecnico:\n");
            return;
        }
        
        //tArtSeleccionado.getListaTecnicos().add(tecSeleccionado);
        CP.capacitarTecnicoEnTA(tecSeleccionado.getCi(), tArtSeleccionado.getId());
        
       javax.swing.JOptionPane.showMessageDialog(null, "Se ingreso Tecnico como capacitado en: " + tArtSeleccionado.getNombre(), "Felicitaciones!", JOptionPane.INFORMATION_MESSAGE);
        
       tablaTipoArticulos.clearSelection();     
       DefaultTableModel tt = (DefaultTableModel) tablaTecnicos.getModel();
       tt.setRowCount(0);
        
    }//GEN-LAST:event_btnAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelTecnicos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaTecnicos;
    private javax.swing.JTable tablaTipoArticulos;
    // End of variables declaration//GEN-END:variables

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (tablaTipoArticulos.getSelectedRow() != -1){
            tipoArticuloSelecionado((DataTipoArticulo) tablaTipoArticulos.getValueAt(tablaTipoArticulos.getSelectedRow(), 0), "");
        }
        
        if (tablaTecnicos.getSelectedRow() != -1){
        
            tecSeleccionado = (DataTecnico) tablaTecnicos.getValueAt(tablaTecnicos.getSelectedRow(), 0);
        }
    }
    
    
    private void tipoArticuloSelecionado(DataTipoArticulo tipoArticulo, String filtro) {
        
        
        // preguntar si es distinta de null
            tArtSeleccionado = tipoArticulo; 
            
            System.out.println("Aca pasa");
            
            List<DataTecnico> tecnicos = CP.darTecnicosCodTA(tArtSeleccionado.getId());
                
            DefaultTableModel dtt = (DefaultTableModel) tablaTecnicos.getModel();
            dtt.setRowCount(0);

            for (DataTecnico t : tecnicos) {
                Object[] data = {
                        t, t.getApellido(), t.getCi()};
                    dtt.addRow(data);

            }
            
        
        
    }
}
