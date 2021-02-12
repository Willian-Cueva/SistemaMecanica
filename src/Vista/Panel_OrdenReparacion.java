/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorOrdeDeReparacion;
import Controlador.ControladorVehiculo;
import Controlador.Utiles.Utiles;
import Controlador.UtilesMecanico.UtilesMecanico;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cris2
 */
public class Panel_OrdenReparacion extends javax.swing.JPanel {

    /**
     * Creates new form Panel_OrdenReparacion
     */
    DefaultTableModel modelo;
    ControladorVehiculo ctr = new ControladorVehiculo();
    UtilesMecanico uti = new UtilesMecanico();
    File file = null;
    String ColorRGB;
    Long idLong = null;
    private ControladorOrdeDeReparacion coddr;

    public Panel_OrdenReparacion() {
        initComponents();
        uti.IniciarConexion();
        modelo = (DefaultTableModel) Tabla1.getModel();
        Tabla1.setModel(modelo);
        coddr = new ControladorOrdeDeReparacion();
        if (this.isVisible()) {
            ctr.llenarTablaVehiculo(modelo);
            Tabla1.updateUI();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla1 = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        labelHora = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JLabel();
        btnDetalle = new javax.swing.JButton();
        btnGuardarOrden = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cajaTexto = new javax.swing.JTextArea();
        txtTotal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(61, 61, 61));
        setLayout(null);

        Tabla1.setForeground(new java.awt.Color(60, 63, 65));
        Tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Placa", "Modelo", "Propietario", "Cedula"
            }
        ));
        Tabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Tabla1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla1);

        add(jScrollPane1);
        jScrollPane1.setBounds(360, 130, 350, 240);
        add(txtBuscar);
        txtBuscar.setBounds(360, 90, 230, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Orden de reparacion");
        add(jLabel3);
        jLabel3.setBounds(180, 0, 290, 30);

        jLabel6.setBackground(new java.awt.Color(255, 102, 0));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoRayas.jpg"))); // NOI18N
        add(jLabel6);
        jLabel6.setBounds(0, 0, 620, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoRayas.jpg"))); // NOI18N
        add(jLabel4);
        jLabel4.setBounds(620, 0, 120, 30);

        jLabel1.setBackground(new java.awt.Color(255, 175, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Buscar");
        jLabel1.setOpaque(true);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        add(jLabel1);
        jLabel1.setBounds(590, 90, 70, 30);

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox3.setForeground(new java.awt.Color(255, 153, 0));
        jCheckBox3.setText("Todo");
        jCheckBox3.setOpaque(false);
        jCheckBox3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jCheckBox3MouseReleased(evt);
            }
        });
        add(jCheckBox3);
        jCheckBox3.setBounds(530, 50, 80, 30);

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(255, 153, 0));
        jCheckBox2.setText("Placa");
        jCheckBox2.setOpaque(false);
        add(jCheckBox2);
        jCheckBox2.setBounds(440, 50, 80, 30);

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 153, 0));
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Cedula");
        jCheckBox1.setOpaque(false);
        add(jCheckBox1);
        jCheckBox1.setBounds(360, 50, 80, 30);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Observacion:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 150, -1));

        txtSubtotal.setBackground(new java.awt.Color(102, 102, 102));
        txtSubtotal.setForeground(new java.awt.Color(255, 255, 255));
        txtSubtotal.setOpaque(true);
        jPanel1.add(txtSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 180, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Hora: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, 20));

        txtDescuento.setBackground(new java.awt.Color(102, 102, 102));
        txtDescuento.setForeground(new java.awt.Color(255, 255, 255));
        txtDescuento.setOpaque(true);
        jPanel1.add(txtDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 170, 29));

        labelFecha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        labelFecha.setText("-");
        jPanel1.add(labelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 100, 20));

        labelHora.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        labelHora.setText("-");
        jPanel1.add(labelHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 80, 20));

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Fecha: ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Subtotal:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 110, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Total:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 110, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Placa:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 80, -1));

        txtPlaca.setBackground(new java.awt.Color(102, 102, 102));
        txtPlaca.setForeground(new java.awt.Color(255, 255, 255));
        txtPlaca.setOpaque(true);
        jPanel1.add(txtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 180, 30));

        btnDetalle.setText("Detalle de Reparacion");
        jPanel1.add(btnDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 190, -1));

        btnGuardarOrden.setText("Guardar");
        btnGuardarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarOrdenActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardarOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 90, 20));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Descuento:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 130, -1));

        cajaTexto.setColumns(20);
        cajaTexto.setRows(5);
        jScrollPane2.setViewportView(cajaTexto);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 290, 70));

        txtTotal.setBackground(new java.awt.Color(102, 102, 102));
        txtTotal.setForeground(new java.awt.Color(255, 255, 255));
        txtTotal.setOpaque(true);
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 180, 29));

        add(jPanel1);
        jPanel1.setBounds(20, 40, 320, 380);

        jLabel2.setBackground(new java.awt.Color(61, 61, 61));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoMetalico.jpg"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(0, 0, 730, 440);
    }// </editor-fold>//GEN-END:initComponents

    private void Tabla1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla1MouseReleased
        int s = Tabla1.getSelectedRow();
        String placa = Tabla1.getValueAt(s, 0).toString();
        if (coddr.tieneOrdenActiva(Utiles.busquedaSecuencial(Utiles.listaVehiculos(), placa, "Placa").obtenerObjetopp(0))) {
            cargarCampos();
        } else {
            
        }
    }//GEN-LAST:event_Tabla1MouseReleased
    private void cargarCampos() {
        labelFecha.setText(coddr.getOrden().getFecha());
        labelHora.setText(coddr.getOrden().getHora());
        txtPlaca.setText(coddr.getPlaca());
        txtSubtotal.setText(String.valueOf(coddr.getOrden().getSubtotal()));
        txtTotal.setText(String.valueOf(coddr.getOrden().getTotal()));
        txtDescuento.setText(String.valueOf(coddr.getOrden().getDescuent()));
        cajaTexto.setText(coddr.getOrden().getObservacion());
    }
    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        try {
            if (jCheckBox1.isSelected()) {
                ctr.buscarPersona(String.valueOf(txtBuscar.getText()));
                if (ctr.getPaux() != null) {
                    ctr.llenarTablaBusquedaVehiculo(modelo, ctr.getPaux());
                    Tabla1.updateUI();
                }
            } else {
                ctr.llenarTablaFiltrarPlaca(ctr.BuscarPlaca(txtBuscar.getText()), modelo);
                Tabla1.updateUI();
            }
        } catch (NumberFormatException e) {
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MousePressed

    private void jCheckBox3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox3MouseReleased
        if (jCheckBox3.isSelected()) {
            ctr.llenarTablaVehiculo(modelo);
            Tabla1.updateUI();

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3MouseReleased

    private void btnGuardarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarOrdenActionPerformed

    }//GEN-LAST:event_btnGuardarOrdenActionPerformed
    private void RefrescarDatos(String placa) {
        ctr.recuperarDatosMod();
        ctr.llenartxt(placa);
        ctr.buscarModeloVehiculo(String.valueOf(ctr.getVaux().getIdModeloVehiculo()));
        ctr.buscarPersona(String.valueOf(ctr.getVaux().getIdPersona()));
        txtDescuento.setText(ctr.getMaux().getNombreModelo());
        txtSubtotal.setText(ctr.getVaux().getPlaca());
        txtDescuento.setText(ctr.getPaux().getNombre() + " " + ctr.getPaux().getApellido());
        txtTotal.setText(ctr.getPaux().getCedula());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla1;
    private javax.swing.JButton btnDetalle;
    private javax.swing.JButton btnGuardarOrden;
    private javax.swing.JTextArea cajaTexto;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelHora;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JLabel txtDescuento;
    private javax.swing.JLabel txtPlaca;
    private javax.swing.JLabel txtSubtotal;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables

}
