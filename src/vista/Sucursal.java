/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import dao.*;
import dto.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author pamela.navarro
 */
public class Sucursal extends javax.swing.JFrame {

    /**
     * Creates new form Sucursal
     */
    
    SucursalDao sucursal = new SucursalDao();
    DefaultComboBoxModel cmbo = sucursal.listarComunas();
    public Sucursal() {
        initComponents();
        cmbComuna.setModel(cmbo);
        cmbComunaB.setModel(cmbo);
        cmbLista.setModel(cmbo);
        llenarLista(SucursalDao.listarTodos());
    }
    
    public DefaultTableModel modeloSalida(){
        DefaultTableModel modelo = new DefaultTableModel();
        return modelo;
    }
    
    public void llenarLista(ArrayList<SucursalDto> array)
    {
        LimpiarJTable();
        DefaultTableModel modeloT = modeloSalida();
        modeloT = (DefaultTableModel)jTableSucursales.getModel();
        ArrayList<SucursalDto> lista = array;
        Object[] fila = new Object[modeloT.getColumnCount()];
        for(int i = 0; i < lista.size(); i++)
        {
            fila[0] = lista.get(i).getIdSucursal();
            fila[1] = lista.get(i).getNombreSucursal();
            fila[2] = lista.get(i).getFono();
            fila[3] = SucursalDao.obtenerComuna(lista.get(i).getComuna());
            fila[4] = lista.get(i).getDireccion();
            modeloT.addRow(fila);
        }
    }
    
    public void LimpiarJTable(){
        DefaultTableModel modelo = (DefaultTableModel) jTableSucursales.getModel();
        while(modelo.getRowCount()>0){
            modelo.removeRow(0);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        cmbComuna = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreSucursal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnAgregarSucursal = new javax.swing.JButton();
        txtFono = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtNombreSucursalB = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        txtFonoB = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cmbComunaB = new javax.swing.JComboBox();
        txtDireccionB = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        lblId = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cmbLista = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSucursales = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Comuna:");

        jLabel2.setText("Nombre Sucursal:");

        jLabel3.setText("Fono:");

        jLabel4.setText("Direccion");

        jLabel5.setText("INGRESO DE SUCURSAL");

        btnAgregarSucursal.setText("Agregar Sucursal");
        btnAgregarSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarSucursalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFono, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAgregarSucursal, cmbComuna, txtDireccion, txtFono, txtNombreSucursal});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jSeparator1, jSeparator2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbComuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(btnAgregarSucursal)
                .addContainerGap(162, Short.MAX_VALUE))
            .addComponent(jSeparator2)
            .addComponent(jSeparator1)
        );

        jTabbedPane1.addTab("AGREGAR SUCURSAL", jPanel1);

        jLabel7.setText("Nombre Sucursal:");

        jLabel8.setText("Fono:");

        txtFonoB.setEnabled(false);

        jLabel9.setText("Comuna:");

        cmbComunaB.setEnabled(false);

        txtDireccionB.setEnabled(false);

        jLabel10.setText("Direccion");

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnModificar.setText("MODIFICAR");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.setEnabled(false);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        lblId.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbComunaB, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFonoB, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDireccionB, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreSucursalB, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnEliminar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar)
                            .addComponent(btnLimpiar)
                            .addComponent(btnModificar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 24, Short.MAX_VALUE)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBuscar, btnEliminar, btnLimpiar, btnModificar});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel7, jLabel8, jLabel9});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreSucursalB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFonoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(btnModificar))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbComunaB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccionB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(btnLimpiar))
                .addContainerGap(192, Short.MAX_VALUE))
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPane1.addTab("MODIFICAR", jPanel2);

        jLabel6.setText("COMUNA");

        cmbLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbListaActionPerformed(evt);
            }
        });

        jTableSucursales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "FONO", "COMUNA", "DIRECCION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableSucursales);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(cmbLista, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("LISTA DE SUCURSALES", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarSucursalActionPerformed
        // TODO add your handling code here:
        
        SucursalDto dto = new SucursalDto();
        if(cmbComuna.getSelectedItem().toString().equals("Seleccione")
                || txtNombreSucursal.getText().length() == 0
                || txtDireccion.getText().length() == 0
                || txtFono.getText().length() == 0)
        {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos para agregar nueva sucursal.");
        }
        else
        {
            if(SucursalDao.validarSucursal(txtNombreSucursal.getText()))
            {
                dto.setComuna(dao.SucursalDao.buscarIDComuna(cmbComuna.getSelectedItem().toString()));
                dto.setDireccion(txtDireccion.getText());
                dto.setFono(txtFono.getText());
                dto.setNombreSucursal(txtNombreSucursal.getText());
                boolean agrego = dao.SucursalDao.addSucursal(dto);
                if(agrego)
                {
                    JOptionPane.showMessageDialog(null, "Sucursal Agregada correctamente");
                    cmbComuna.setSelectedItem("Seleccione");
                    txtDireccion.setText(null);
                    txtFono.setText(null);
                    txtNombreSucursal.setText(null);
                }else
                {
                    JOptionPane.showMessageDialog(null, "UPS! ocurrio un problema.\nContactate con el administrador.");
                }   
            }else
            {
                JOptionPane.showMessageDialog(null, "Ya existe la sucursal.");
                txtNombreSucursal.setText(null);
            }
            
        }
        
    }//GEN-LAST:event_btnAgregarSucursalActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        if(txtNombreSucursalB.getText().length() > 0)
        {
            SucursalDto dto = new SucursalDto();
            dto = SucursalDao.buscarSucursal(txtNombreSucursalB.getText());
            if(dto.getIdSucursal() == 0)
            {
                JOptionPane.showMessageDialog(null, "No se encontro la sucursal.");
            }else
            {
                lblId.setText(String.valueOf(dto.getIdSucursal()));
                txtNombreSucursalB.setText(dto.getNombreSucursal());
                txtFonoB.setText(dto.getFono());
                cmbComunaB.setSelectedItem(SucursalDao.obtenerComuna(dto.getComuna()));
                txtDireccionB.setText(dto.getDireccion());
                
                txtNombreSucursalB.setEnabled(true);
                txtFonoB.setEnabled(true);
                cmbComunaB.setEnabled(true); 
                txtDireccionB.setEnabled(true);
                btnBuscar.setEnabled(false);
                btnModificar.setEnabled(true);
                btnLimpiar.setEnabled(true);
                btnEliminar.setEnabled(false);
            }
        }else
        {
            JOptionPane.showMessageDialog(null, "Debes ingresar un nombre para buscar.");
        }
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if(Integer.valueOf(lblId.getText()) != 0)
        {
            JOptionPane.showMessageDialog(null, "No hay sucursal para eliminar");
        }else
        {
            boolean elimino = SucursalDao.eliminarSucursal(Integer.valueOf(lblId.getText()));
            if(elimino)
            {
                JOptionPane.showMessageDialog(null, "Sucursal Eliminada");
                lblId.setText(null);
                txtNombreSucursalB.setText(null);
                txtFonoB.setText(null);
                cmbComunaB.setSelectedItem("Seleccione");
                txtDireccionB.setText(null);
                
                txtNombreSucursalB.setEnabled(true);
                txtFonoB.setEnabled(false);
                cmbComunaB.setEnabled(false); 
                txtDireccionB.setEnabled(false);
                btnBuscar.setEnabled(true);
                btnModificar.setEnabled(false);
                btnLimpiar.setEnabled(false);
                btnEliminar.setEnabled(false);
            }else
            {
                JOptionPane.showMessageDialog(null, "UPS! ocurrio un problema.\nContactate con el administrador.");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if(lblId.getText().length() == 0 
                || txtNombreSucursalB.getText().length() == 0
                || txtFonoB.getText().length() == 0
                || cmbComunaB.getSelectedItem().toString().equals("Seleccione")
                || txtDireccionB.getText().length() == 0)
        {
            JOptionPane.showMessageDialog(null, "Deben estar todos los campos llenos");
        }else
        {
            SucursalDto dto = new SucursalDto();
            dto.setComuna(dao.SucursalDao.buscarIDComuna(cmbComuna.getSelectedItem().toString()));
            dto.setDireccion(txtDireccion.getText());
            dto.setFono(txtFono.getText());
            dto.setNombreSucursal(txtNombreSucursal.getText());
            boolean modifico = SucursalDao.modificarSucursal(dto);
            if(modifico)
            {
                JOptionPane.showMessageDialog(null, "Sucursal modificada correctamente");
                lblId.setText(null);
                txtNombreSucursalB.setText(null);
                txtFonoB.setText(null);
                cmbComunaB.setSelectedItem("Seleccione");
                txtDireccionB.setText(null);
                
                txtNombreSucursalB.setEnabled(true);
                txtFonoB.setEnabled(false);
                cmbComunaB.setEnabled(false); 
                txtDireccionB.setEnabled(false);
                btnBuscar.setEnabled(true);
                btnModificar.setEnabled(false);
                btnLimpiar.setEnabled(false);
                btnEliminar.setEnabled(false);
            }else
            {
                JOptionPane.showMessageDialog(null, "UPS! ocurrio un problema.\nContactate con el administrador.");
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        lblId.setText(null);
        txtNombreSucursalB.setText(null);
        txtFonoB.setText(null);
        cmbComunaB.setSelectedItem("Seleccione");
        txtDireccionB.setText(null);
                
        txtNombreSucursalB.setEnabled(true);
        txtFonoB.setEnabled(false);
        cmbComunaB.setEnabled(false); 
        txtDireccionB.setEnabled(false);
        btnBuscar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnLimpiar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void cmbListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbListaActionPerformed
        // TODO add your handling code here:
        
        if(cmbLista.getSelectedItem().toString().equals("Seleccione"))
        {
            llenarLista(SucursalDao.listarTodos());
        }else
        {
            llenarLista(SucursalDao.listarPorComuna(SucursalDao.buscarIDComuna(cmbLista.getSelectedItem().toString())));
        }
        
        
    }//GEN-LAST:event_cmbListaActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Sucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sucursal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarSucursal;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox cmbComuna;
    private javax.swing.JComboBox cmbComunaB;
    private javax.swing.JComboBox cmbLista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableSucursales;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDireccionB;
    private javax.swing.JTextField txtFono;
    private javax.swing.JTextField txtFonoB;
    private javax.swing.JTextField txtNombreSucursal;
    private javax.swing.JTextField txtNombreSucursalB;
    // End of variables declaration//GEN-END:variables
}
