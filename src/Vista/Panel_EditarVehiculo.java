/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorCliente;
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
public class Panel_EditarVehiculo extends javax.swing.JPanel {

    /**
     * Creates new form Panel_EditarVehiculo
     */
    DefaultTableModel modelo;
    ControladorVehiculo ctr = new ControladorVehiculo();
    UtilesMecanico uti = new UtilesMecanico();
    File file = null;
    String ColorRGB;
    Long idLong = null;
    
    public Panel_EditarVehiculo() {
        initComponents();
        uti.IniciarConexion();
        modelo = (DefaultTableModel) Tabla1.getModel();
        Tabla1.setModel(modelo);
        jScrollPane1.getViewport().setBackground(new Color(51,51,51)); 
        Noeditar();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        txtModelo = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JLabel();
        imagen = new javax.swing.JLabel();
        btnEditar = new javax.swing.JLabel();
        bxActivo = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JLabel();
        btnBuscarImagen = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservacion = new javax.swing.JTextArea();
        btnColor = new javax.swing.JLabel();
        vColor = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(61, 61, 61));
        setOpaque(false);
        setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Administrar Vehiculos");
        add(jLabel3);
        jLabel3.setBounds(180, 0, 290, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoRayas.jpg"))); // NOI18N
        add(jLabel4);
        jLabel4.setBounds(620, 0, 120, 30);

        jLabel6.setBackground(new java.awt.Color(255, 102, 0));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoRayas.jpg"))); // NOI18N
        add(jLabel6);
        jLabel6.setBounds(0, 0, 620, 30);

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 51, 0));
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Cedula");
        jCheckBox1.setOpaque(false);
        add(jCheckBox1);
        jCheckBox1.setBounds(10, 40, 80, 30);

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(255, 51, 0));
        jCheckBox2.setText("Placa");
        jCheckBox2.setOpaque(false);
        add(jCheckBox2);
        jCheckBox2.setBounds(90, 40, 80, 30);

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox3.setForeground(new java.awt.Color(255, 51, 0));
        jCheckBox3.setText("Actualizar");
        jCheckBox3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        jCheckBox3.setOpaque(false);
        jCheckBox3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jCheckBox3MouseReleased(evt);
            }
        });
        add(jCheckBox3);
        jCheckBox3.setBounds(290, 100, 90, 20);

        jLabel1.setBackground(new java.awt.Color(255, 175, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        jLabel1.setOpaque(true);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        add(jLabel1);
        jLabel1.setBounds(220, 80, 40, 30);
        add(txtBuscar);
        txtBuscar.setBounds(10, 80, 210, 30);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(null);

        txtModelo.setBackground(new java.awt.Color(66, 65, 65));
        txtModelo.setForeground(new java.awt.Color(255, 255, 255));
        txtModelo.setOpaque(true);
        jPanel1.add(txtModelo);
        txtModelo.setBounds(110, 20, 183, 29);

        txtPlaca.setBackground(new java.awt.Color(66, 65, 65));
        txtPlaca.setForeground(new java.awt.Color(255, 255, 255));
        txtPlaca.setOpaque(true);
        jPanel1.add(txtPlaca);
        txtPlaca.setBounds(110, 60, 183, 29);

        imagen.setOpaque(true);
        jPanel1.add(imagen);
        imagen.setBounds(10, 11, 87, 107);

        btnEditar.setBackground(new java.awt.Color(255, 175, 0));
        btnEditar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEditar.setText("Editar");
        btnEditar.setOpaque(true);
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEditarMousePressed(evt);
            }
        });
        jPanel1.add(btnEditar);
        btnEditar.setBounds(220, 305, 80, 25);

        bxActivo.setBackground(new java.awt.Color(255, 204, 0));
        bxActivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        bxActivo.setEnabled(false);
        jPanel1.add(bxActivo);
        bxActivo.setBounds(50, 270, 250, 30);

        btnGuardar.setBackground(new java.awt.Color(255, 175, 0));
        btnGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setOpaque(true);
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnGuardarMousePressed(evt);
            }
        });
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(220, 305, 80, 25);

        btnCancelar.setBackground(new java.awt.Color(255, 175, 0));
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancelar.setText("Cancelar");
        btnCancelar.setOpaque(true);
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCancelarMousePressed(evt);
            }
        });
        jPanel1.add(btnCancelar);
        btnCancelar.setBounds(110, 305, 60, 25);

        btnBuscarImagen.setBackground(new java.awt.Color(255, 175, 0));
        btnBuscarImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBuscarImagen.setText("Buscar");
        btnBuscarImagen.setOpaque(true);
        btnBuscarImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBuscarImagenMousePressed(evt);
            }
        });
        jPanel1.add(btnBuscarImagen);
        btnBuscarImagen.setBounds(10, 120, 87, 20);

        txtObservacion.setBackground(new java.awt.Color(66, 65, 65));
        txtObservacion.setColumns(20);
        txtObservacion.setRows(5);
        jScrollPane2.setViewportView(txtObservacion);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(50, 150, 250, 100);

        btnColor.setBackground(new java.awt.Color(255, 175, 0));
        btnColor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnColor.setText("Color");
        btnColor.setOpaque(true);
        btnColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnColorMousePressed(evt);
            }
        });
        jPanel1.add(btnColor);
        btnColor.setBounds(110, 100, 60, 30);

        javax.swing.GroupLayout vColorLayout = new javax.swing.GroupLayout(vColor);
        vColor.setLayout(vColorLayout);
        vColorLayout.setHorizontalGroup(
            vColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        vColorLayout.setVerticalGroup(
            vColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(vColor);
        vColor.setBounds(170, 100, 70, 30);

        add(jPanel1);
        jPanel1.setBounds(400, 70, 310, 340);

        Tabla1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
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
        jScrollPane1.setBounds(10, 120, 370, 290);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMousePressed
        editar();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarMousePressed

    private void btnGuardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMousePressed
        ColorRGB = String.valueOf(vColor.getBackground().getRGB());
        ctr.Editar(ColorRGB, txtObservacion.getText(), bxActivo.getSelectedItem().toString(), file, String.valueOf(ctr.getVaux().getId()));
        Noeditar();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarMousePressed

    private void btnCancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMousePressed
        Noeditar();
        file = null;
        if (estado) {
            if (txtPlaca.getText().length() > 0) {
                RefrescarDatos(txtPlaca.getText().substring(4));
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarMousePressed

    private void btnBuscarImagenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarImagenMousePressed
        if (estado) {
            file = uti.BuscarImagen();
            System.out.println("ruta" + String.valueOf(file));
            Image foto = getToolkit().getImage(String.valueOf(file));
            foto = foto.getScaledInstance(87, 107, Image.SCALE_DEFAULT);
            imagen.setIcon(new ImageIcon(foto));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarImagenMousePressed

    private void jCheckBox3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox3MouseReleased
        if (jCheckBox3.isSelected()) {
            ctr.llenarTablaVehiculo(modelo);
            Tabla1.updateUI();
            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3MouseReleased

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

    private void Tabla1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla1MouseReleased
        System.out.println("Selecciono: " + (Tabla1.getSelectedRow()) + "Tamaño: " + Tabla1.getRowCount());
        Noeditar();
        String a = Tabla1.getValueAt(Tabla1.getSelectedRow(), 0).toString();
        System.out.println("a: " + a);
        RefrescarDatos(a);        // TODO add your handling code here:
    }//GEN-LAST:event_Tabla1MouseReleased

    private void btnColorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnColorMousePressed
        if (estado) {
            Color color = new Color(240, 240, 240);
            if (JColorChooser.showDialog(null, "Elige un color", Color.BLACK)!=null) {
               color = JColorChooser.showDialog(null, "Elige un color", Color.BLACK); 
            }
            Color co = new Color(color.getRGB());
            vColor.setBackground(co);
            vColor.updateUI();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnColorMousePressed
    /**
     * Metodo de actualizacion de los datos de los campos en la interfaz
     * @param placa 
     */
    private void RefrescarDatos(String placa) {
        ctr.recuperarDatosMod();
        ctr.llenartxt(placa);
        ctr.buscarModeloVehiculo(String.valueOf(ctr.getVaux().getIdModeloVehiculo()));
        ctr.buscarPersona(String.valueOf(ctr.getVaux().getIdPersona()));
        txtModelo.setText(ctr.getMaux().getNombreModelo());
        vColor.setBackground(new Color(Integer.parseInt(ctr.getVaux().getColor())));
        txtPlaca.setText(ctr.getVaux().getPlaca());
        txtObservacion.setText(ctr.getVaux().getObservacion());
        if (ctr.getVaux().getImagen()!=null) {
            imagen.setIcon(uti.img(ctr.getVaux().getImagen(), imagen.getSize()));
        }
        
        if (ctr.getVaux().getEstado().booleanValue()) {
            bxActivo.setSelectedItem("Activo");
        } else {
            bxActivo.setSelectedItem("Inactivo");
        }
    }
    boolean estado = true;
    /**
     * Metodo de alitacion de botones
     */
    public void editar() {
        estado = true;
        btnGuardar.setVisible(true);
        btnCancelar.setVisible(true);
        btnEditar.setVisible(false);
        btnBuscarImagen.setVisible(true);
        txtObservacion.setEditable(true);
        bxActivo.setEnabled(true);
        txtObservacion.setBackground(Color.white);
        
    }
    /**
     * Metodo de desabilitacion de botones en la interfaz
     */
    public void Noeditar() {
        estado = false;
        btnEditar.setVisible(true);
        btnGuardar.setVisible(false);
        btnCancelar.setVisible(false);
        btnBuscarImagen.setVisible(false);
        txtObservacion.setEditable(false);
        bxActivo.setEnabled(false);
        txtObservacion.setBackground(new Color(66, 65, 65));
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla1;
    private javax.swing.JLabel btnBuscarImagen;
    private javax.swing.JLabel btnCancelar;
    private javax.swing.JLabel btnColor;
    private javax.swing.JLabel btnEditar;
    private javax.swing.JLabel btnGuardar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> bxActivo;
    private javax.swing.JLabel imagen;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JLabel txtModelo;
    private javax.swing.JTextArea txtObservacion;
    private javax.swing.JLabel txtPlaca;
    private javax.swing.JPanel vColor;
    // End of variables declaration//GEN-END:variables
}
