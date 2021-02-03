/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorCuenta;
import Controlador.UtilesMecanico.UtilesMecanico;
import ControladorDao.MantenerCesion;
import Modelo.Cuenta;
import Modelo.Persona;
import Modelo.Rol;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Willian
 */
public class Frm_Login extends javax.swing.JFrame {

    /**
     * Creates new form Frm_Login
     */
    RecuperarClave rec = new RecuperarClave(new eventoCerrar());
    UtilesMecanico uti = new UtilesMecanico();
    ControladorCuenta ctr = new ControladorCuenta();
    Frm_Mecanico mec = new Frm_Mecanico();
    Frm_Administrador adm=new Frm_Administrador();
    public Frm_Login() {
        initComponents();
        ctr.RecuperarData();
        uti.IniciarConexion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        btnRecuperarCuenta = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        btnContinuar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(375, 360));
        setMinimumSize(new java.awt.Dimension(375, 360));
        setPreferredSize(new java.awt.Dimension(375, 360));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRecuperarCuenta.setText("¿Se te olvido tu contraseña ?");
        btnRecuperarCuenta.setContentAreaFilled(false);
        btnRecuperarCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRecuperarCuentaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnRecuperarCuentaMouseReleased(evt);
            }
        });
        jPanel1.add(btnRecuperarCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 190, 20));

        jCheckBox1.setText("Recordar contraseña");
        jCheckBox1.setContentAreaFilled(false);
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 293, -1, 20));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 170, 10));

        btnContinuar.setBackground(new java.awt.Color(102, 102, 255));
        btnContinuar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnContinuar.setText("Continuar");
        btnContinuar.setOpaque(true);
        btnContinuar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnContinuarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnContinuarMouseReleased(evt);
            }
        });
        jPanel1.add(btnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 110, 20));

        jPanel2.setBackground(null);
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsuario.setText("Usuario");
        jPanel2.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 8, 283, 37));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconoUsuario.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 10, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconoContraseña.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 50, -1, -1));

        txtContraseña.setText("Contraseña");
        txtContraseña.setEchoChar('\u0000');
        jPanel2.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 48, 283, 37));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 340, 90));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/UsuarioImg.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 18, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoLogin.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 340));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 360, 340);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContinuarMousePressed
       //Aqui es donde te permite ingresar decide tu rol y de acuerdo a eso te da paso a la ventana que te corresponde
        btnContinuar.setBackground(new Color(12, 12, 47));
        btnContinuar.setForeground(Color.WHITE);
        ctr.buscarCuenta(ctr.getLiCuenta(), ctr.getLiPersona(), ctr.getLiRol(), txtUsuario.getText(), txtContraseña.getText());
        //cs.mantenerdatos(ctr.getCuenta(), ctr.getPersona(), ctr.getRol());
        //Aqui tambien guarda los datos en un archivo para mantener la cesion
        MantenerCesion<Cuenta> cuenta=new MantenerCesion<>();
        MantenerCesion<Persona> persona=new MantenerCesion<>();
        MantenerCesion<Rol> rol=new MantenerCesion<>();
        try {
            cuenta.guardar(ctr.getCuenta(), "Cuenta");
            persona.guardar(ctr.getPersona(),"Persona");
            rol.guardar(ctr.getRol(),"Rol");
        } catch (Exception ex) {
            Logger.getLogger(Frm_Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("llega hasta aqui");
        if (ctr.isExisteCuenta()) {
            if (ctr.getRol().getNombreRol().equals("Administrador")) {
                  adm.setVisible(true);
                  this.dispose();
            } else if (ctr.getRol().getNombreRol().equals("Mecanico")) {
                  mec.setVisible(true);
                  this.dispose();
            } else {

            }
        } 
        //Comentando
// TODO add your handling code here:
    }//GEN-LAST:event_btnContinuarMousePressed

    private void btnContinuarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContinuarMouseReleased
        //Estetica del boton
        btnContinuar.setBackground(new Color(102, 102, 255));
        btnContinuar.setForeground(Color.BLACK);// TODO add your handling code here:
    }//GEN-LAST:event_btnContinuarMouseReleased

    private void btnRecuperarCuentaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecuperarCuentaMousePressed
       //Estetica del boton y hace visible una ventanita para recuperar contraseña que aun no programo
        btnRecuperarCuenta.setForeground(Color.WHITE);
        jSeparator1.setBackground(Color.WHITE);
        rec.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_btnRecuperarCuentaMousePressed

    private void btnRecuperarCuentaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecuperarCuentaMouseReleased
        //Estetica del boton
        btnRecuperarCuenta.setForeground(Color.BLACK);
        jSeparator1.setBackground(Color.BLACK);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRecuperarCuentaMouseReleased
    //A esto no le paren bola jjj
    class eventoCerrar implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println("datos: " + RecuperarClave.correo + " " + RecuperarClave.Contraseña); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //To change body of generated methods, choose Tools | Templates.
        }
    }

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
            java.util.logging.Logger.getLogger(Frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnContinuar;
    private javax.swing.JButton btnRecuperarCuenta;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
