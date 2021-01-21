/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorCuenta;
import Controlador.ControladorMecanico;
import Controlador.MantenerCesion;
import Controlador.Utiles;
import Modelo.Rol;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Cris2
 */
public class FrmCliente extends javax.swing.JFrame {

    /**
     * Creates new form FrmCliente
     */
    ControladorMecanico ctr = new ControladorMecanico();
    Utiles uti = new Utiles();
    MantenerCesion cs = new MantenerCesion();
    ControladorCuenta ctrc = new ControladorCuenta();
    File file;

    public FrmCliente() {
        initComponents();
        ctr.llenarboxRoles(cmbRol);
//        if (cs.getRol() != null && cs.getRol().getId().equals(3)) {
            cmbRol.removeItem("Administrador");
            cmbRol.removeItem("Mecanico");
//        } else {
//            txtContraseña = new JTextField();
//            jLabel9 = new JLabel("Contraseña");
//            jPanel1.add(txtContraseña);
//            jPanel1.add(jLabel9);
//            txtContraseña.setBounds(90, 330, 230, 30);
//            jLabel9.setBounds(10, 330, 70, 30);
//            txtContraseña.setVisible(true);
//            jLabel9.setVisible(true);
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnBuscarImagen = new javax.swing.JLabel();
        VisatFoto = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        cmbRol = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 51));
        jPanel1.setLayout(null);
        jPanel1.add(txtNombre);
        txtNombre.setBounds(90, 90, 230, 30);
        jPanel1.add(txtCedula);
        txtCedula.setBounds(90, 170, 230, 30);
        jPanel1.add(txtCorreo);
        txtCorreo.setBounds(90, 210, 230, 30);

        jLabel1.setText("Nombre");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 90, 70, 30);

        jLabel2.setText("Cedula");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 170, 70, 30);

        jLabel3.setText("Correo");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 210, 70, 30);
        jPanel1.add(txtTelefono);
        txtTelefono.setBounds(90, 250, 230, 30);

        jLabel4.setText("Telefono");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 250, 70, 30);

        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel2.setLayout(new java.awt.BorderLayout());

        btnBuscarImagen.setBackground(new java.awt.Color(255, 153, 0));
        btnBuscarImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBuscarImagen.setText("Buscar Imagen");
        btnBuscarImagen.setOpaque(true);
        btnBuscarImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscarImagenMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBuscarImagenMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnBuscarImagenMouseReleased(evt);
            }
        });
        jPanel2.add(btnBuscarImagen, java.awt.BorderLayout.PAGE_END);

        VisatFoto.setBackground(new java.awt.Color(255, 255, 255));
        VisatFoto.setMaximumSize(new java.awt.Dimension(108, 139));
        VisatFoto.setMinimumSize(new java.awt.Dimension(108, 139));
        VisatFoto.setOpaque(true);
        VisatFoto.setPreferredSize(new java.awt.Dimension(108, 139));
        jPanel2.add(VisatFoto, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(340, 90, 120, 170);

        btnGuardar.setBackground(new java.awt.Color(255, 153, 0));
        btnGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGuardar.setText("Guardar");
        btnGuardar.setOpaque(true);
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnGuardarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnGuardarMouseReleased(evt);
            }
        });
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(380, 350, 80, 30);

        jLabel8.setBackground(new java.awt.Color(255, 153, 0));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Registrar Clientes");
        jLabel8.setOpaque(true);
        jPanel1.add(jLabel8);
        jLabel8.setBounds(150, 20, 260, 30);
        jPanel1.add(txtApellido);
        txtApellido.setBounds(90, 130, 230, 30);

        jLabel5.setText("Apellido");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 130, 70, 30);
        jPanel1.add(txtDireccion);
        txtDireccion.setBounds(90, 290, 230, 30);

        jPanel1.add(cmbRol);
        cmbRol.setBounds(340, 270, 120, 30);

        jLabel10.setText("Direccion");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(10, 290, 70, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMousePressed
        btnGuardar.setBackground(new Color(255, 204, 51));
        btnGuardar.setForeground(Color.WHITE);
        ctr.RegistrarCliente(txtCedula.getText(), txtNombre.getText(), txtApellido.getText(), txtCorreo.getText(), txtTelefono.getText(), txtDireccion.getText(), file, ctr.idRol(cmbRol.getSelectedItem().toString()), txtContraseña.getText());        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarMousePressed

    private void btnGuardarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseReleased
        btnGuardar.setBackground(new Color(255, 153, 0));
        btnGuardar.setForeground(Color.BLACK);
        ctr.GuardarPersona(ctr.getPersona());
        ctr.GuardarCuenta();// TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarMouseReleased

    private void btnBuscarImagenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarImagenMousePressed

        btnBuscarImagen.setBackground(new Color(255, 204, 51));
        btnBuscarImagen.setForeground(Color.WHITE);
        file = uti.BuscarImagen();
        System.out.println("ruta" + String.valueOf(file));
        Image foto = getToolkit().getImage(String.valueOf(file));
        foto = foto.getScaledInstance(108, 139, Image.SCALE_DEFAULT);
        VisatFoto.setIcon(new ImageIcon(foto));

        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarImagenMousePressed

    private void btnBuscarImagenMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarImagenMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarImagenMouseReleased

    private void btnBuscarImagenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarImagenMouseExited
        btnBuscarImagen.setBackground(new Color(255, 153, 0));
        btnBuscarImagen.setForeground(Color.BLACK);        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarImagenMouseExited

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
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCliente().setVisible(true);
            }
        });
    }
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JLabel jLabel9;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel VisatFoto;
    private javax.swing.JLabel btnBuscarImagen;
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JComboBox<String> cmbRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
