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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cris2
 */
public class Panel_RegistroVehiculo extends javax.swing.JPanel {

    /**
     * Creates new form Panel_RegistroVehiculo
     */
    DefaultTableModel modelo;
    ControladorVehiculo ctr = new ControladorVehiculo();
    ControladorCliente ctr1 = new ControladorCliente();
    UtilesMecanico uti = new UtilesMecanico();
    Long idModelo;
    String ColorRGB;
    File file = null;
    Panel_RegistrarModelos mv = new Panel_RegistrarModelos(new eventoCerrar());
    /**
     * Metodo que permite mostrar una ventana emergente para registrar
     * modelos en el caso que no estubiera el vehiculo del cliente dentro de los modelos existentes
     */
    public Panel_RegistroVehiculo() {
        emerge = new javax.swing.JPanel();
        emerge.setLayout(new java.awt.BorderLayout());
        initComponents();
        jScrollPane2.getViewport().setBackground(new Color(51, 51, 51));
        uti.IniciarConexion();
        modelo = (DefaultTableModel) Tabla1.getModel();
        Tabla1.setModel(modelo);
        if (this.isVisible()) {
            ctr.llenarTabla(modelo);
            ctr.llenarboxModelos(jComboBox2);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacion = new javax.swing.JTextArea();
        txtCedula = new javax.swing.JLabel();
        txtPropietario = new javax.swing.JLabel();
        vColor = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        vistaImagen = new javax.swing.JLabel();
        txtMarca = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        txtPlaca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla1 = new javax.swing.JTable();
        btnBuscar = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();

        setMinimumSize(new java.awt.Dimension(727, 415));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(727, 415));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(61, 61, 61));
        jPanel1.setMinimumSize(new java.awt.Dimension(727, 415));
        jPanel1.setOpaque(false);
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Nuevo vehiculo");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(200, 0, 280, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoRayas.jpg"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(620, 0, 110, 30);

        title.setBackground(new java.awt.Color(255, 204, 0));
        title.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoRayas.jpg"))); // NOI18N
        title.setOpaque(true);
        jPanel1.add(title);
        title.setBounds(0, 0, 623, 30);

        btnGuardar.setBackground(new java.awt.Color(255, 175, 0));
        btnGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setOpaque(true);
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnGuardarMouseReleased(evt);
            }
        });
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(620, 380, 90, 25);

        txtBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtBuscarMousePressed(evt);
            }
        });
        jPanel1.add(txtBuscar);
        txtBuscar.setBounds(390, 80, 190, 30);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Placa");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 10, 74, 33);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setText("Modelo");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 50, 74, 33);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 153, 0));
        jLabel13.setText("Marca");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(10, 90, 70, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 153, 0));
        jLabel10.setText("Propietario");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(10, 170, 70, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 153, 0));
        jLabel12.setText("CI.");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(10, 210, 70, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 0));
        jLabel8.setText("Observacion");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(10, 250, 70, 100);

        txtObservacion.setColumns(20);
        txtObservacion.setRows(5);
        jScrollPane1.setViewportView(txtObservacion);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(80, 250, 270, 100);

        txtCedula.setBackground(new java.awt.Color(66, 65, 65));
        txtCedula.setOpaque(true);
        jPanel2.add(txtCedula);
        txtCedula.setBounds(80, 210, 270, 30);

        txtPropietario.setBackground(new java.awt.Color(66, 65, 65));
        txtPropietario.setOpaque(true);
        jPanel2.add(txtPropietario);
        txtPropietario.setBounds(80, 170, 270, 30);

        vColor.setBackground(new java.awt.Color(66, 65, 65));
        vColor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(vColor);
        vColor.setBounds(160, 130, 80, 30);

        jLabel11.setBackground(new java.awt.Color(255, 175, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Color");
        jLabel11.setOpaque(true);
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel11MousePressed(evt);
            }
        });
        jPanel2.add(jLabel11);
        jLabel11.setBounds(80, 130, 70, 30);

        jLabel7.setBackground(new java.awt.Color(255, 175, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Buscar imagen");
        jLabel7.setOpaque(true);
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });
        jPanel2.add(jLabel7);
        jLabel7.setBounds(250, 130, 100, 30);

        vistaImagen.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(vistaImagen);
        vistaImagen.setBounds(250, 10, 100, 120);

        txtMarca.setBackground(new java.awt.Color(66, 65, 65));
        txtMarca.setOpaque(true);
        jPanel2.add(txtMarca);
        txtMarca.setBounds(80, 90, 160, 30);

        jComboBox2.setBackground(new java.awt.Color(255, 102, 0));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jComboBox2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jComboBox2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jComboBox2MousePressed(evt);
            }
        });
        jPanel2.add(jComboBox2);
        jComboBox2.setBounds(80, 50, 130, 30);
        jPanel2.add(txtPlaca);
        txtPlaca.setBounds(80, 10, 160, 33);

        jLabel3.setBackground(new java.awt.Color(255, 175, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("+");
        jLabel3.setMaximumSize(new java.awt.Dimension(30, 30));
        jLabel3.setMinimumSize(new java.awt.Dimension(30, 30));
        jLabel3.setOpaque(true);
        jLabel3.setPreferredSize(new java.awt.Dimension(30, 30));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });
        jPanel2.add(jLabel3);
        jLabel3.setBounds(210, 50, 30, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 40, 360, 360);

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
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Tabla1MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(Tabla1);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(390, 120, 330, 250);

        btnBuscar.setBackground(new java.awt.Color(255, 175, 0));
        btnBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btnBuscar.setOpaque(true);
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBuscarMousePressed(evt);
            }
        });
        jPanel1.add(btnBuscar);
        btnBuscar.setBounds(580, 80, 30, 30);

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 51, 0));
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Cedula");
        jCheckBox1.setOpaque(false);
        jPanel1.add(jCheckBox1);
        jCheckBox1.setBounds(390, 50, 70, 23);

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(255, 51, 0));
        jCheckBox2.setText("Apellido");
        jCheckBox2.setOpaque(false);
        jPanel1.add(jCheckBox2);
        jCheckBox2.setBounds(470, 50, 80, 23);

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
        jPanel1.add(jCheckBox3);
        jCheckBox3.setBounds(630, 100, 90, 23);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 727, 415);
    }// </editor-fold>//GEN-END:initComponents

    private void Tabla1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla1MousePressed

    }//GEN-LAST:event_Tabla1MousePressed

    private void txtBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarMousePressed

    private void btnBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMousePressed
        if (estadoBoton) {
            try {
                if (jCheckBox1.isSelected()) {
                    ctr1.Encuentracliente(txtBuscar.getText());
                    if (ctr1.getPersona() != null) {
                        ctr.llenarTablaBusqueda(modelo, ctr1.getPersona());
                        Tabla1.updateUI();
                    }
                } else {
                    ctr.llenarTablaFiltrarApellido(ctr.BuscarApellido(txtBuscar.getText()), modelo);
                    Tabla1.updateUI();
                }
            } catch (NumberFormatException e) {
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarMousePressed

    private void jComboBox2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2MouseExited

    private void jComboBox2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2MousePressed

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        if (estadoBoton) {
            file = uti.BuscarImagen();
            System.out.println("ruta" + String.valueOf(file));
            Image foto = getToolkit().getImage(String.valueOf(file));
            foto = foto.getScaledInstance(108, 139, Image.SCALE_DEFAULT);
            vistaImagen.setIcon(new ImageIcon(foto));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MousePressed

    private void jLabel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MousePressed
        if (estadoBoton) {
            Color color = new Color(240, 240, 240);
            if (JColorChooser.showDialog(null, "Elige un color", Color.BLACK)!=null) {
               color = JColorChooser.showDialog(null, "Elige un color", Color.BLACK);
            }
            
            ColorRGB = String.valueOf(color.getRGB());
            Color co = new Color(color.getRGB());
            vColor.setBackground(co);
            vColor.updateUI();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MousePressed

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
//        if (estadoBoton) {
//            System.out.println("Modelo: "+idModelo);
//            idModelo = ctr.idModelo(jComboBox2.getSelectedItem().toString());
//            txtMarca.setText(ctr.buscarMarca());
//        }

// TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseMoved

    private void Tabla1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla1MouseReleased
        if (estadoBoton) {
            System.out.println("Selecciono: " + (Tabla1.getSelectedRow()) + "Tamaño: " + Tabla1.getRowCount());
            try {

                String a = Tabla1.getValueAt(Tabla1.getSelectedRow(), 0).toString();
                ctr1.Encuentracliente(a);
                txtPropietario.setText(ctr1.getPersona().getNombre() + " " + ctr1.getPersona().getApellido());
                txtCedula.setText(ctr1.getPersona().getCedula().toString());

            } catch (NumberFormatException e) {
            }
        }

        // TODO add your handling code here:       // TODO add your handling code here:
    }//GEN-LAST:event_Tabla1MouseReleased

    private void jCheckBox3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox3MouseReleased
        if (jCheckBox3.isSelected()) {
            ctr.llenarTabla(modelo);
            Tabla1.updateUI();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3MouseReleased
    boolean estadoBoton = true;
    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        if (estadoBoton) {
            for (int i = 1; i < jPanel1.getComponentCount(); i++) {
                jPanel1.getComponents()[i].setEnabled(false);
                Tabla1.setEnabled(false);
                txtObservacion.setEnabled(false);
                title.setEnabled(true);
                jLabel3.setEnabled(true);
            }
            jPanel1.add(emerge, 0);
            emerge.setBounds(230, 130, 301, 169);
            //emerge.setVisible(true);
            emerge.add(mv);
            jPanel1.updateUI();
            estadoBoton = false;
        } else {
            for (int i = 0; i < jPanel1.getComponentCount(); i++) {
                jPanel1.getComponents()[i].setEnabled(true);
                Tabla1.setEnabled(true);
                txtObservacion.setEnabled(true);
                title.setEnabled(true);
                jLabel3.setEnabled(true);
            }
            jPanel1.remove(emerge);
            jPanel1.updateUI();
            estadoBoton = true;
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MousePressed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jComboBox2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox2PopupMenuWillBecomeInvisible
        if (estadoBoton) {
                System.out.println("Modelo: " + idModelo);
                idModelo = ctr.idModelo(jComboBox2.getSelectedItem().toString());
                txtMarca.setText(ctr.buscarMarca());
            
        }// TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2PopupMenuWillBecomeInvisible

    private void btnGuardarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseReleased
       if (estadoBoton) {
            ctr1.Encuentracliente(txtCedula.getText());
            ctr.RegistrarVehiculo(txtPlaca.getText(), idModelo, ColorRGB, txtObservacion.getText(), file, ctr1.getPersona().getId());
            ctr.GuardarVehiculo();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarMouseReleased
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
            System.out.println("datos: " + mv.txtNombreModelo.getText() + " " + mv.bxMarca.getSelectedItem().toString());
            Long Marca = ctr.buscarMNombre(mv.bxMarca.getSelectedItem().toString());
            String nombre = mv.txtNombreModelo.getText();
            ctr.RegistrarModelo(nombre, Marca);
            ctr.GuardarModelo();
            jComboBox2.removeAllItems();
            ctr.llenarboxModelos(jComboBox2);
            //emerge.setVisible(false);
            for (int i = 0; i < jPanel1.getComponentCount(); i++) {
                jPanel1.getComponents()[i].setEnabled(true);
                Tabla1.setEnabled(true);
                txtObservacion.setEnabled(true);
                jLabel3.setEnabled(true);
            }
            estadoBoton = true;
            jPanel1.remove(emerge);
            jPanel1.updateUI();//To change body of generated methods, choose Tools | Templates.
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
    private javax.swing.JPanel emerge;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla1;
    private javax.swing.JLabel btnBuscar;
    private javax.swing.JLabel btnGuardar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel title;
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
