/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorVehiculo;
import Controlador.UtilesMecanico.UtilesMecanico;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cris2
 */
public class Frm_Vehiculo extends javax.swing.JFrame {

    /**
     * Creates new form Frm_Vehiculo
     */
    DefaultTableModel modelo;
    ControladorVehiculo ctr = new ControladorVehiculo();
    UtilesMecanico uti=new UtilesMecanico();
    Long idModelo;
    String ColorRGB;
    File file;
    public Frm_Vehiculo() {
        initComponents();
        modelo = (DefaultTableModel) Tabla1.getModel();
        Tabla1.setModel(modelo);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtPlaca = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacion = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla1 = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        vistaImagen = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPropietario = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        vColor = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(672, 472));
        setPreferredSize(new java.awt.Dimension(672, 472));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(txtPlaca);
        txtPlaca.setBounds(120, 60, 110, 33);

        jLabel1.setText("Placa");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(28, 62, 74, 33);

        jLabel2.setText("Modelo");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(28, 101, 74, 33);

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(290, 410, 100, 30);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Nuevo vehiculo");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(160, 11, 180, 33);

        jLabel6.setText("Color");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 180, 70, 30);

        txtObservacion.setColumns(20);
        txtObservacion.setRows(5);
        jScrollPane1.setViewportView(txtObservacion);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(120, 300, 270, 100);

        Tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula", "Nombre", "Apellido"
            }
        ));
        Tabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Tabla1MousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(Tabla1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(420, 90, 230, 250);

        txtBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtBuscarMousePressed(evt);
            }
        });
        getContentPane().add(txtBuscar);
        txtBuscar.setBounds(420, 60, 180, 30);

        jLabel4.setBackground(new java.awt.Color(255, 153, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Buscar");
        jLabel4.setOpaque(true);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(600, 60, 50, 30);

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Cedula");
        getContentPane().add(jCheckBox1);
        jCheckBox1.setBounds(420, 30, 68, 24);

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setText("Apellido");
        getContentPane().add(jCheckBox2);
        jCheckBox2.setBounds(510, 30, 72, 24);

        jComboBox2.setBackground(new java.awt.Color(255, 102, 0));
        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jComboBox2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jComboBox2MousePressed(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(120, 100, 130, 30);

        jLabel7.setBackground(new java.awt.Color(255, 153, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Buscar imagen");
        jLabel7.setOpaque(true);
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });
        getContentPane().add(jLabel7);
        jLabel7.setBounds(290, 170, 100, 20);

        jLabel8.setText("Observacion");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(30, 300, 80, 100);

        vistaImagen.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(vistaImagen);
        vistaImagen.setBounds(290, 50, 100, 120);

        jLabel11.setBackground(new java.awt.Color(255, 153, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Color");
        jLabel11.setOpaque(true);
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel11MousePressed(evt);
            }
        });
        getContentPane().add(jLabel11);
        jLabel11.setBounds(120, 180, 70, 30);

        txtPropietario.setBackground(new java.awt.Color(255, 255, 255));
        txtPropietario.setOpaque(true);
        getContentPane().add(txtPropietario);
        txtPropietario.setBounds(120, 220, 270, 30);

        jLabel10.setText("Propietario");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(30, 220, 80, 30);

        txtCedula.setBackground(new java.awt.Color(255, 255, 255));
        txtCedula.setOpaque(true);
        getContentPane().add(txtCedula);
        txtCedula.setBounds(120, 260, 270, 30);

        jLabel12.setText("CI.");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(30, 260, 80, 30);

        vColor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(vColor);
        vColor.setBounds(200, 180, 60, 30);

        jLabel3.setBackground(new java.awt.Color(255, 102, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("+");
        jLabel3.setMaximumSize(new java.awt.Dimension(30, 30));
        jLabel3.setMinimumSize(new java.awt.Dimension(30, 30));
        jLabel3.setOpaque(true);
        jLabel3.setPreferredSize(new java.awt.Dimension(30, 30));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(250, 100, 30, 30);

        txtMarca.setBackground(new java.awt.Color(255, 255, 255));
        txtMarca.setOpaque(true);
        getContentPane().add(txtMarca);
        txtMarca.setBounds(120, 140, 130, 30);

        jLabel13.setText("Marca");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(30, 140, 70, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Tabla1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla1MousePressed
        try {
            String a = Tabla1.getValueAt(Tabla1.getSelectedRow() + 1, 0).toString();
            txtPropietario.setText(ctr.BuscarCedula(Long.parseLong(a)).getNombre() + " " + ctr.BuscarCedula(Long.parseLong(a)).getApellido());
            
            txtCedula.setText(ctr.BuscarCedula(Long.parseLong(a)).getId().toString());
        } catch (NumberFormatException e) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_Tabla1MousePressed

    private void txtBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarMousePressed
// TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarMousePressed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowGainedFocus

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        try {
            if (jCheckBox1.isSelected() && ctr.BuscarCedula(Long.parseLong(txtBuscar.getText())) != null) {
                ctr.llenarTablaBusqueda(modelo, ctr.BuscarCedula(Long.parseLong(txtBuscar.getText())));
                Tabla1.updateUI();
            } else {
                ctr.llenarTablaBusqueda(modelo, ctr.Buscar(txtBuscar.getText()));
                Tabla1.updateUI();
            }
        } catch (NumberFormatException e) {
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MousePressed
        Color color=JColorChooser.showDialog(null, "Elige un color", Color.BLACK);
        ColorRGB=String.valueOf(color.getRGB());
        Color co=new Color(color.getRGB());
        vColor.setBackground(co);
        vColor.updateUI();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MousePressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ctr.llenarTabla(modelo);
        ctr.llenarboxRoles(jComboBox2);
        Tabla1.updateUI();
                // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jComboBox2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2MouseExited

    private void jComboBox2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MousePressed
               // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2MousePressed

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
         idModelo=ctr.idModelo(jComboBox2.getSelectedItem().toString());
         txtMarca.setText(ctr.buscarMarca());        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseEntered

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        file = uti.BuscarImagen();
        System.out.println("ruta" + String.valueOf(file));
        Image foto = getToolkit().getImage(String.valueOf(file));
        foto = foto.getScaledInstance(108, 139, Image.SCALE_DEFAULT);
        vistaImagen.setIcon(new ImageIcon(foto));              // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ctr.RegistrarVehiculo(txtPlaca.getText(), idModelo, ColorRGB, txtObservacion.getText(), file, Long.parseLong(txtCedula.getText()));
        ctr.GuardarVehiculo(); 
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Vehiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JLabel txtCedula;
    private javax.swing.JLabel txtMarca;
    private javax.swing.JTextArea txtObservacion;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JLabel txtPropietario;
    private javax.swing.JPanel vColor;
    private javax.swing.JLabel vistaImagen;
    // End of variables declaration//GEN-END:variables
}
