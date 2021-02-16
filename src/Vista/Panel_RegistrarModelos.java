/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorVehiculo;
import Controlador.UtilesMecanico.UtilesMecanico;
import java.awt.event.MouseListener;

/**
 *
 * @author Cris2
 */
public class Panel_RegistrarModelos extends javax.swing.JPanel {
    
    ControladorVehiculo ctr=new ControladorVehiculo();
    UtilesMecanico uti=new UtilesMecanico();
    /**
     * 
     * @param   evento de soltar el mouse
     */
    public Panel_RegistrarModelos(MouseListener aL) {
        initComponents();
        uti.IniciarConexion();
        System.out.println("Prueba de entrada");
        btnGuardar.addMouseListener(aL);
        ctr.recuperarDatosMod();
        ctr.llenarboxMarcas(bxMarca);
        bxMarca.updateUI();  
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
        txtNombreModelo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        bxMarca = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(73, 73, 73));
        jPanel1.setLayout(null);
        jPanel1.add(txtNombreModelo);
        txtNombreModelo.setBounds(90, 40, 180, 30);

        jLabel1.setText("Marca");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 80, 50, 30);

        jPanel1.add(bxMarca);
        bxMarca.setBounds(90, 80, 180, 30);

        jLabel2.setText("Modelo");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 40, 50, 30);

        btnGuardar.setBackground(new java.awt.Color(255, 175, 0));
        btnGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setOpaque(true);
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(190, 130, 80, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnGuardar;
    public static javax.swing.JComboBox<String> bxMarca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JTextField txtNombreModelo;
    // End of variables declaration//GEN-END:variables
}
