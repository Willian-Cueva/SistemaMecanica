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
import java.util.Calendar;
import java.util.GregorianCalendar;
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
    private final int PRECARGA = 0;
    private final int ENCONTRADO = 1;

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
        jLabel5 = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        labelHora = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cajaTexto = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        labelPlaca = new javax.swing.JLabel();
        labelSubtotal = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        btnFacturar = new javax.swing.JButton();
        btnGuardarOrden = new javax.swing.JButton();
        btnDetalle = new javax.swing.JButton();
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
        Tabla1.getTableHeader().setReorderingAllowed(false);
        Tabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Tabla1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla1);

        add(jScrollPane1);
        jScrollPane1.setBounds(360, 110, 350, 210);
        add(txtBuscar);
        txtBuscar.setBounds(360, 70, 230, 30);

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
        jLabel1.setBounds(590, 70, 70, 30);

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox3.setForeground(new java.awt.Color(255, 153, 0));
        jCheckBox3.setText("Actualizar");
        jCheckBox3.setOpaque(false);
        jCheckBox3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jCheckBox3MouseReleased(evt);
            }
        });
        add(jCheckBox3);
        jCheckBox3.setBounds(530, 30, 80, 30);

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(255, 153, 0));
        jCheckBox2.setText("Placa");
        jCheckBox2.setOpaque(false);
        add(jCheckBox2);
        jCheckBox2.setBounds(440, 30, 80, 30);

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 153, 0));
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Cedula");
        jCheckBox1.setOpaque(false);
        add(jCheckBox1);
        jCheckBox1.setBounds(360, 30, 80, 30);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel7.setText("Observacion:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 150, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("Hora: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, 20));

        labelFecha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        labelFecha.setText("-");
        jPanel1.add(labelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 100, 20));

        labelHora.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        labelHora.setText("-");
        jPanel1.add(labelHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 80, 20));

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel10.setText("Fecha: ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel11.setText("Subtotal:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 110, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel12.setText("Total:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 110, -1));

        labelTotal.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        labelTotal.setForeground(new java.awt.Color(51, 51, 51));
        labelTotal.setText("-");
        jPanel1.add(labelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 150, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel8.setText("Descuento:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 130, -1));

        cajaTexto.setColumns(20);
        cajaTexto.setRows(5);
        jScrollPane2.setViewportView(cajaTexto);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 290, 70));

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel14.setText("Placa:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 80, -1));

        labelPlaca.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        labelPlaca.setForeground(new java.awt.Color(51, 51, 51));
        labelPlaca.setText("-");
        jPanel1.add(labelPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 150, -1));

        labelSubtotal.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        labelSubtotal.setForeground(new java.awt.Color(51, 51, 51));
        labelSubtotal.setText("-");
        jPanel1.add(labelSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 150, -1));
        jPanel1.add(txtDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 160, 30));

        add(jPanel1);
        jPanel1.setBounds(10, 40, 340, 360);

        btnFacturar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnFacturar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/002-cuenta.png"))); // NOI18N
        btnFacturar.setText("Facturar");
        btnFacturar.setDefaultCapable(false);
        btnFacturar.setEnabled(false);
        btnFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturarActionPerformed(evt);
            }
        });
        add(btnFacturar);
        btnFacturar.setBounds(450, 370, 150, 40);

        btnGuardarOrden.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnGuardarOrden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/002-disquete.png"))); // NOI18N
        btnGuardarOrden.setText("Guardar");
        btnGuardarOrden.setEnabled(false);
        btnGuardarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarOrdenActionPerformed(evt);
            }
        });
        add(btnGuardarOrden);
        btnGuardarOrden.setBounds(360, 330, 120, 30);

        btnDetalle.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/001-empleado.png"))); // NOI18N
        btnDetalle.setText("Detalle de Reparacion");
        btnDetalle.setEnabled(false);
        btnDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalleActionPerformed(evt);
            }
        });
        add(btnDetalle);
        btnDetalle.setBounds(500, 330, 200, 44);

        jLabel2.setBackground(new java.awt.Color(61, 61, 61));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoMetalico.jpg"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(0, 0, 730, 440);
    }// </editor-fold>//GEN-END:initComponents

    private void Tabla1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla1MouseReleased
        int s = Tabla1.getSelectedRow();
        String placa = Tabla1.getValueAt(s, 0).toString();
        if (coddr.tieneOrdenActiva(Utiles.busquedaSecuencial(Utiles.listaVehiculos(), placa, "Placa").obtenerObjetopp(0))) {
            cargarCampos(ENCONTRADO);
            btnGuardarOrden.setEnabled(false);
            btnDetalle.setEnabled(true);
            btnFacturar.setEnabled(true);
            JOptionPane.showMessageDialog(this, "Orden Activa", "Activo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("No existen ordennes de reparacion activas pero si funciona xd");
            cargarCampos(PRECARGA);
            btnDetalle.setEnabled(false);
            btnFacturar.setEnabled(false);
            btnGuardarOrden.setEnabled(true);
            JOptionPane.showMessageDialog(this, "No existe una orden de reparacion para este vehiculo", "Orden de Reparación", JOptionPane.INFORMATION_MESSAGE);
        }
        coddr.getVehiculo().setPlaca(labelPlaca.getText());
        txtDescuento.setEnabled(true);
    }//GEN-LAST:event_Tabla1MouseReleased
    private void cargarCampos(int s) {
        String f = "", h = "", p = "", sub = "", t = "",d="", des = "";
        if (s == 0) {
            Calendar c = new GregorianCalendar();
            f = c.get(Calendar.DAY_OF_MONTH) + "/" + c.get(Calendar.MONTH) + "/" + c.get(Calendar.YEAR);
            h = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE);
            p = Tabla1.getValueAt(Tabla1.getSelectedRow(), 0).toString();
            sub = "0.0";
            t ="0.0";
            d="0.0";
            des="ninguna";
        } else if (s == 1) {
            f=coddr.getOrden().getFecha();
            h=coddr.getOrden().getHora();
            p=coddr.getVehiculo().getPlaca();
            sub=String.valueOf(coddr.getOrden().getSubtotal());
            t=String.valueOf(coddr.getOrden().getTotal());
            d=String.valueOf(coddr.getOrden().getDescuent());
            des=coddr.getOrden().getObservacion();
        }
        labelFecha.setText(f);
        labelHora.setText(h);
        labelPlaca.setText(p);
        labelSubtotal.setText(sub);
        labelTotal.setText(t);
        txtDescuento.setText(d);
        cajaTexto.setText(des);
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
        coddr.getVehiculo().setPlaca(labelPlaca.getText());
        coddr.guardarOrden(labelFecha.getText(), labelHora.getText(), txtDescuento.getText(), cajaTexto.getText(), labelPlaca.getText());
//        JOptionPane.showMessageDialog(this, coddr.getOrden());
        btnGuardarOrden.setEnabled(false);
        actualizardatos();
        btnDetalle.setEnabled(true);
        btnFacturar.setEnabled(true);
    }//GEN-LAST:event_btnGuardarOrdenActionPerformed

    private void btnDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalleActionPerformed
        // TODO add your handling code here:
        actualizardatos();
        new Frm_Detalle(coddr).setVisible(true);
    }//GEN-LAST:event_btnDetalleActionPerformed

    private void btnFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturarActionPerformed
        // TODO add your handling code here:
         actualizardatos();
         new Frm_Facturar(coddr).setVisible(true);
    }//GEN-LAST:event_btnFacturarActionPerformed
//    private void RefrescarDatos(String placa) {
//        ctr.recuperarDatosMod();
//        ctr.llenartxt(placa);
//        ctr.buscarModeloVehiculo(String.valueOf(ctr.getVaux().getIdModeloVehiculo()));
//        ctr.buscarPersona(String.valueOf(ctr.getVaux().getIdPersona()));
//        txtDescuento.setText(ctr.getMaux().getNombreModelo());
//        txtSubtotal.setText(ctr.getVaux().getPlaca());
//        txtDescuento.setText(ctr.getPaux().getNombre() + " " + ctr.getPaux().getApellido());
//        txtTotal.setText(ctr.getPaux().getCedula());
//    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla1;
    private javax.swing.JButton btnDetalle;
    private javax.swing.JButton btnFacturar;
    private javax.swing.JButton btnGuardarOrden;
    private javax.swing.JTextArea cajaTexto;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JLabel labelPlaca;
    private javax.swing.JLabel labelSubtotal;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDescuento;
    // End of variables declaration//GEN-END:variables

    private void actualizardatos() {
        coddr.getOrden().setDescuent(Double.parseDouble(labelTotal.getText()));
        coddr.getOrden().setDescuent(Double.parseDouble(txtDescuento.getText()));
        coddr.getOrden().setObservacion(cajaTexto.getText());
        
    }

}
