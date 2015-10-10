/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import dao.CargoDao;
import dto.TrabajadorDto;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Yoyin
 */
public class PaginaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form PaginaPrincipal
     */
    
    TrabajadorDto dtoReturn = new TrabajadorDto();
    
    
    public PaginaPrincipal() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setTitle("MANTENEDORES.");
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIdUser = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuSucursales = new javax.swing.JMenuItem();
        mnuCargos = new javax.swing.JMenuItem();
        mnuUsuarios = new javax.swing.JMenuItem();
        mnuServicios = new javax.swing.JMenuItem();
        mnuLogOut = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblIdUser.setEnabled(false);

        jMenu1.setText("Opciones");

        mnuSucursales.setText("Sucursales");
        mnuSucursales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSucursalesActionPerformed(evt);
            }
        });
        jMenu1.add(mnuSucursales);

        mnuCargos.setText("Cargos");
        mnuCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCargosActionPerformed(evt);
            }
        });
        jMenu1.add(mnuCargos);

        mnuUsuarios.setText("Usuarios");
        mnuUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuUsuariosActionPerformed(evt);
            }
        });
        jMenu1.add(mnuUsuarios);

        mnuServicios.setText("Servicios");
        mnuServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuServiciosActionPerformed(evt);
            }
        });
        jMenu1.add(mnuServicios);

        mnuLogOut.setText("Log out");
        mnuLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLogOutActionPerformed(evt);
            }
        });
        jMenu1.add(mnuLogOut);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 373, Short.MAX_VALUE)
                .addComponent(lblIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 255, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("pagPrincipal");
        getAccessibleContext().setAccessibleDescription("pagPrincipal");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuSucursalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSucursalesActionPerformed
        if(CargoDao.obtenerCargo(dtoReturn.getCargo()).equalsIgnoreCase("administrador") 
                && dtoReturn.isVigente())
        {
            Sucursal sucursal = new Sucursal();
            sucursal.setVisible(true);
            sucursal.setLocationRelativeTo(null);
            //sucursal.setResizable(false);
            sucursal.setTitle("SUCURSALES");
            sucursal.setDefaultCloseOperation(2);
        }else
        {
            JOptionPane.showMessageDialog(null, "NO TIENES PERFIL DE ADMINISTRADOR PARA ENTRAR\nO NO ESTA VIGENTE LA CUENTA.\nCONTACTE AL ADMINISTRADOR SI ESTA INFORMACION NO ES CORRECTA");
        }
    }//GEN-LAST:event_mnuSucursalesActionPerformed

    private void mnuCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCargosActionPerformed
        // TODO add your handling code here:
        if(CargoDao.obtenerCargo(dtoReturn.getCargo()).equalsIgnoreCase("administrador") 
                && dtoReturn.isVigente())
        {
            Cargo cargo = new Cargo();
            cargo.setVisible(true);
            cargo.setLocationRelativeTo(null);
            //sucursal.setResizable(false);
            cargo.setTitle("CARGOS");
            cargo.setDefaultCloseOperation(2);
        }else
        {
            JOptionPane.showMessageDialog(null, "NO TIENES PERFIL DE ADMINISTRADOR PARA ENTRAR\nO NO ESTA VIGENTE LA CUENTA.\nCONTACTE AL ADMINISTRADOR SI ESTA INFORMACION NO ES CORRECTA");
        }
    }//GEN-LAST:event_mnuCargosActionPerformed

    private void mnuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuUsuariosActionPerformed
        // TODO add your handling code here:
        if(CargoDao.obtenerCargo(dtoReturn.getCargo()).equalsIgnoreCase("administrador") 
                && dtoReturn.isVigente())
        {
            MantenedorUsuarios usuarios = new MantenedorUsuarios();
            usuarios.setVisible(true);
            usuarios.setLocationRelativeTo(null);
            //sucursal.setResizable(false);
            usuarios.setTitle("USUARIOS");
            usuarios.setDefaultCloseOperation(2);
        }else
        {
            JOptionPane.showMessageDialog(null, "NO TIENES PERFIL DE ADMINISTRADOR PARA ENTRAR\nO NO ESTA VIGENTE LA CUENTA.\nCONTACTE AL ADMINISTRADOR SI ESTA INFORMACION NO ES CORRECTA");
        }
    }//GEN-LAST:event_mnuUsuariosActionPerformed

    private void mnuServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuServiciosActionPerformed
        // TODO add your handling code here:
        if(CargoDao.obtenerCargo(dtoReturn.getCargo()).equalsIgnoreCase("administrador") 
                && dtoReturn.isVigente())
        {
            Servicio servicio = new Servicio();
            servicio.setVisible(true);
            servicio.setLocationRelativeTo(null);
            //sucursal.setResizable(false);
            servicio.setTitle("USUARIOS");
            servicio.setDefaultCloseOperation(2);
        }else
        {
            JOptionPane.showMessageDialog(null, "NO TIENES PERFIL DE ADMINISTRADOR PARA ENTRAR\nO NO ESTA VIGENTE LA CUENTA.\nCONTACTE AL ADMINISTRADOR SI ESTA INFORMACION NO ES CORRECTA");
        }
    }//GEN-LAST:event_mnuServiciosActionPerformed

    private void mnuLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLogOutActionPerformed
        // TODO add your handling code here:
        dispose();
        login log = new login();
        log.setVisible(true);
        log.setLocationRelativeTo(null);
        log.setDefaultCloseOperation(2);
    }//GEN-LAST:event_mnuLogOutActionPerformed

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
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaginaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    public static javax.swing.JLabel lblIdUser;
    private javax.swing.JMenuItem mnuCargos;
    private javax.swing.JMenuItem mnuLogOut;
    private javax.swing.JMenuItem mnuServicios;
    private javax.swing.JMenuItem mnuSucursales;
    private javax.swing.JMenuItem mnuUsuarios;
    // End of variables declaration//GEN-END:variables
}
