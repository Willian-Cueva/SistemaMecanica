/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.AlmacenControlador;
import Controlador.Conexion.ConeccionBDD;
import Vista.Modelo.TablaProducto;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import Controlador.Utiles.Utiles;
import Modelo.DetalleReparacion;
import java.awt.Image;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Willian
 */
public class Frm_Almacen extends javax.swing.JFrame {

    private TablaProducto tp = new TablaProducto();
    //private TablaProductosSalientes stp =  new TablaProductosSalientes();
    private AlmacenControlador cp = new AlmacenControlador();
    private int idProducto = -1;
    private ImageIcon wallpp = new ImageIcon("src\\Imagenes\\FondoMetalico.jpg");
    private ImageIcon wallpp1 = new ImageIcon("src\\Imagenes\\fondoRayas.jpg");
    private DetalleReparacion detalleReparacion = new DetalleReparacion();

    public Frm_Almacen(DetalleReparacion detalleReparacion) {
        initComponents();
        this.setLocationRelativeTo(null);
        TablaPedido.updateUI();
        setResizable(false);
        escalar(Fondo, wallpp);
        escalar(FondoR, wallpp1);
        escalar(Fondo2, wallpp);
        cargarTablaProducto();
        this.detalleReparacion = detalleReparacion;
        llenarTabla();
    }

    public Frm_Almacen() {
        initComponents();
        this.setLocationRelativeTo(null);
        TablaPedido.updateUI();
        setResizable(false);
        escalar(Fondo, wallpp);
        escalar(FondoR, wallpp1);
        escalar(Fondo2, wallpp);
        cargarTablaProducto();
        llenarTabla();

    }

    public void escalar(JLabel x, ImageIcon wallpp) {
        Icon icono = new ImageIcon(wallpp.getImage().getScaledInstance(x.getWidth(), x.getHeight(), Image.SCALE_DEFAULT));
        x.setIcon(icono);
        this.repaint();
    }

    public void LimpiarCampos() {
        txtNombre.setText("");
        txtMarca.setText("");
        txtPrecio.setText("");
        txtIva.setText("");
        txtStock.setText("");
    }

    private void cargarTablaProducto() {

        tp.setLsp(cp.obtenerLista());
        TablaProductos.setModel(tp);
        TablaProductos.updateUI();
        TablaProductosLista.setModel(tp);
        TablaProductosLista.updateUI();

    }

    private void cargarModelo() {

    }

    public void llenarTabla() {
        cargarTablaProducto();
        for (int i = 0; i < tp.getLsp().tamano(); i++) {
            tp.getValueAt(i, i);
        }
    }

    private void guardarProducto() {
        try {
            String sql = "INSERT INTO `baseddmecanica`.`producto` (`nombre`, `cantidad`, `marca`, `precio`, `IVA`, `external_idProducto`) VALUES (?,?,?,?,?,?);";
            PreparedStatement ps = (PreparedStatement) ConeccionBDD.IniciarConexion().prepareCall(sql);
            ps.setString(1, txtNombre.getText());
            ps.setString(2, txtStock.getText());
            ps.setString(3, txtMarca.getText());
            ps.setString(4, txtPrecio.getText());
            ps.setString(5, txtIva.getText());
            ps.setString(6, "Exter" + txtMarca.getText() + txtNombre.getText());
            ps.executeUpdate();
            LimpiarCampos();
            llenarTabla();
        } catch (java.sql.SQLException ex) {
            System.err.println("Error para guardar el produccto- guardarProducto() - Frm_Almacen");
            JOptionPane.showMessageDialog(this, "No se pudo  insertar");
        }
    }

    private void actualizarPersona() {
        String n = txtNombre.getText(),
                c = txtStock.getText(),
                m = txtMarca.getText(),
                p = txtPrecio.getText(),
                i = txtIva.getText(),
                e = "Exter" + m + n;
        String sql = "UPDATE `producto` SET `nombre` = '" + n + "', `cantidad` = '" + c
                + "', `marca` = '" + m + "', `precio` = '" + p + "', `IVA` = '" + i
                + "', `external_idProducto` = '" + e + "' WHERE (`producto`.`idProducto` = '" + idProducto + "')";
        try {
            PreparedStatement ps = (PreparedStatement) ConeccionBDD.IniciarConexion().prepareStatement(sql);
            ps.executeUpdate();
            llenarTabla();
            LimpiarCampos();
            JOptionPane.showMessageDialog(this, "Se actualizaron los datos correctamente");
        } catch (SQLException ex) {
            LimpiarCampos();
            JOptionPane.showMessageDialog(this, "Error al actualizar los datos en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("No se actualizaron los datos - error:" + ex);
        }
    }

    private void llenarCampos(int s) {
        idProducto = Integer.parseInt(String.valueOf(TablaProductos.getValueAt(s, 0)));
        txtNombre.setText(String.valueOf(TablaProductos.getValueAt(s, 1)));
        txtStock.setText(String.valueOf(TablaProductos.getValueAt(s, 2)));
        txtMarca.setText(String.valueOf(TablaProductos.getValueAt(s, 3)));
        txtPrecio.setText(String.valueOf(TablaProductos.getValueAt(s, 4)));
        txtIva.setText(String.valueOf(TablaProductos.getValueAt(s, 5)));
        btnSalir.setEnabled(false);
        btnLimpiar.setEnabled(false);
        TablaProductos.setEnabled(false);
        btnActualizar.setEnabled(true);
        btnGuardarProducto1.setEnabled(false);
    }

    private void modificarPersona() {
        int s = TablaProductos.getSelectedRow();
        if (s > -1) {
            llenarCampos(s);
        } else {
            JOptionPane.showConfirmDialog(this, "Seleccione un elemento de la tabla", "No Seleccionado", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void buscar(JTable tabla) {
        String atributo = "";
        boolean v = false;
        if (rdNombre.isSelected()) {
            atributo = "Nombre";
            v = true;
        } else if (rdExternalID.isSelected()) {
            atributo = "External_id";
            v = true;
        } else {
            JOptionPane.showMessageDialog(this, "Debe selecionar un atributo de busqueda", "Seleccione", JOptionPane.INFORMATION_MESSAGE);
        }
        if (v = true) {
//            tp.setLsp(Controlador.Utiles.Utiles.busquedaSecuencial(cp.getProducto(), txtBuscar.getText(), atributo));
            tp.setLsp(Utiles.busquedaSecuencial(Utiles.listaProductos(), txtBuscar.getText(), atributo));
            tabla.setModel(tp);
            tabla.updateUI();
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
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProductos = new javax.swing.JTable();
        btnInf = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnGuardarProducto1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jcroopPanel = new javax.swing.JScrollPane();
        TablaProductosLista = new javax.swing.JTable();
        rdNombre = new javax.swing.JRadioButton();
        rdExternalID = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar4 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaPedido = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Fondo2 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        FondoR = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 48)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Almacen");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(110, 10, 203, 55);

        jTabbedPane1.setBackground(java.awt.Color.black);
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTabbedPane1.setForeground(java.awt.Color.orange);
        jTabbedPane1.setAutoscrolls(true);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Courier New", 0, 12))); // NOI18N
        jPanel5.setForeground(java.awt.Color.orange);
        jPanel5.setLayout(null);

        jPanel3.setBackground(java.awt.Color.black);

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel2.setForeground(java.awt.Color.orange);
        jLabel2.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel3.setForeground(java.awt.Color.orange);
        jLabel3.setText("Marca:");

        txtMarca.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel4.setForeground(java.awt.Color.orange);
        jLabel4.setText("Precio:");

        txtPrecio.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel5.setForeground(java.awt.Color.orange);
        jLabel5.setText("IVA:");

        txtIva.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel6.setForeground(java.awt.Color.orange);
        jLabel6.setText("Cantidad:");

        txtStock.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                            .addComponent(txtMarca, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtIva)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(29, 29, 29)
                        .addComponent(txtPrecio))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jPanel5.add(jPanel3);
        jPanel3.setBounds(30, 60, 320, 230);

        TablaProductos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        TablaProductos.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        TablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaProductos.setFocusable(false);
        TablaProductos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TablaProductos);

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(380, 80, 450, 370);

        btnInf.setBackground(java.awt.Color.orange);
        btnInf.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnInf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/008-informacion.png"))); // NOI18N
        btnInf.setText("inf");
        btnInf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfActionPerformed(evt);
            }
        });
        jPanel5.add(btnInf);
        btnInf.setBounds(10, 350, 90, 50);

        btnLimpiar.setBackground(java.awt.Color.orange);
        btnLimpiar.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/001-escoba.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel5.add(btnLimpiar);
        btnLimpiar.setBounds(100, 350, 110, 50);

        btnModificar.setBackground(java.awt.Color.orange);
        btnModificar.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/007-lapiz.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel5.add(btnModificar);
        btnModificar.setBounds(10, 430, 150, 60);

        btnActualizar.setBackground(java.awt.Color.orange);
        btnActualizar.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/003-actualizar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setEnabled(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel5.add(btnActualizar);
        btnActualizar.setBounds(170, 430, 180, 60);

        btnGuardarProducto1.setBackground(java.awt.Color.orange);
        btnGuardarProducto1.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnGuardarProducto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/002-disquete.png"))); // NOI18N
        btnGuardarProducto1.setText("Guardar");
        btnGuardarProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProducto1ActionPerformed(evt);
            }
        });
        jPanel5.add(btnGuardarProducto1);
        btnGuardarProducto1.setBounds(220, 350, 120, 50);

        jLabel7.setBackground(java.awt.Color.black);
        jLabel7.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel7.setForeground(java.awt.Color.orange);
        jLabel7.setText("TABLA PRODUCTOS");
        jPanel5.add(jLabel7);
        jLabel7.setBounds(520, 40, 170, 30);
        jPanel5.add(Fondo);
        Fondo.setBounds(-10, 20, 850, 550);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("Producto", jPanel4);

        jPanel2.setLayout(null);

        jPanel9.setBackground(new java.awt.Color(242, 224, 180));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Stock"));

        TablaProductosLista.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        TablaProductosLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaProductosLista.setFocusable(false);
        TablaProductosLista.getTableHeader().setReorderingAllowed(false);
        jcroopPanel.setViewportView(TablaProductosLista);

        buttonGroup1.add(rdNombre);
        rdNombre.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        rdNombre.setText("Nombre");
        rdNombre.setBorderPainted(true);

        buttonGroup1.add(rdExternalID);
        rdExternalID.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        rdExternalID.setText("External_id");
        rdExternalID.setBorderPainted(true);
        rdExternalID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdExternalIDActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel16.setText("Buscar:");

        txtBuscar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        btnBuscar4.setBackground(java.awt.Color.orange);
        btnBuscar4.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnBuscar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/006-lupa.png"))); // NOI18N
        btnBuscar4.setText("Buscar");
        btnBuscar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(rdNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdExternalID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar4)
                .addGap(35, 35, 35))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcroopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdNombre)
                    .addComponent(rdExternalID)
                    .addComponent(jLabel16)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcroopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel9);
        jPanel9.setBounds(6, 32, 830, 220);

        jPanel10.setBackground(new java.awt.Color(242, 224, 180));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de compra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Courier New", 0, 12))); // NOI18N

        TablaPedido.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        TablaPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Stock", "Precio", "IVA", "ExternalId"
            }
        ));
        TablaPedido.setFocusable(false);
        TablaPedido.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(TablaPedido);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel10);
        jPanel10.setBounds(10, 330, 820, 180);

        jButton10.setBackground(java.awt.Color.orange);
        jButton10.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/004-eliminar.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton10);
        jButton10.setBounds(230, 270, 59, 53);

        jButton9.setBackground(java.awt.Color.orange);
        jButton9.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/008-informacion.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton9);
        jButton9.setBounds(70, 270, 54, 53);

        btnAgregar.setBackground(java.awt.Color.orange);
        btnAgregar.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/002-cuenta.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregar);
        btnAgregar.setBounds(400, 270, 170, 52);

        jButton2.setBackground(java.awt.Color.orange);
        jButton2.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/003-actualizar.png"))); // NOI18N
        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(670, 270, 159, 53);
        jPanel2.add(Fondo2);
        Fondo2.setBounds(0, 0, 860, 580);

        jTabbedPane1.addTab("Lista", jPanel2);

        jPanel1.add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 80, 870, 620);

        btnSalir.setBackground(java.awt.Color.orange);
        btnSalir.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logout (1).png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir);
        btnSalir.setBounds(690, 10, 120, 50);
        jPanel1.add(FondoR);
        FondoR.setBounds(2, 2, 870, 74);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        LimpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnInfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfActionPerformed

        JOptionPane.showMessageDialog(null, "La siguiente ventana..... \n Permite el registro de productos. \n La modificacion de productos");

    }//GEN-LAST:event_btnInfActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        int s = TablaProductos.getSelectedRow();
        if (s > -1) {
            modificarPersona();
        } else {
            JOptionPane.showMessageDialog(this, "Selecciones un elemento de la tabla", "Seleccion", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        actualizarPersona();
        btnSalir.setEnabled(true);
        btnLimpiar.setEnabled(true);
        TablaProductos.setEnabled(true);
        btnActualizar.setEnabled(false);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void rdExternalIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdExternalIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdExternalIDActionPerformed

    private void btnBuscar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar4ActionPerformed
        buscar(TablaProductosLista);
    }//GEN-LAST:event_btnBuscar4ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        String inf = "EN ESTE PANTALA NOS PERMITE REGISTRAR \nLOS PRODUCTOS QUE DESEE ADQUIRIR\n";
        JOptionPane.showMessageDialog(this, inf, "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jButton10ActionPerformed

    private void btnGuardarProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProducto1ActionPerformed
        // TODO add your handling code here:
        guardarProducto();
    }//GEN-LAST:event_btnGuardarProducto1ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        TableModel modelo1 = TablaProductosLista.getModel();
        int[] filas = TablaProductosLista.getSelectedRows();
        Object[] row = new Object[7];
        DefaultTableModel modelo2 = (DefaultTableModel) TablaPedido.getModel();
        String CantidadVender;
        boolean v = false;
        do {
            CantidadVender = JOptionPane.showInputDialog("Ingrese cantidad a vender: ");
            if (CantidadVender.length() != 0) {
                if (CantidadVender.matches("[0-9]*")) {
                    JOptionPane.showMessageDialog(null, "DATO CORRECTO", "INGRESO CORRECTO", JOptionPane.INFORMATION_MESSAGE);
                    for (int i = 0; i < filas.length; i++) {
                        row[0] = modelo1.getValueAt(filas[i], 0);
                        row[1] = modelo1.getValueAt(filas[i], 1);
                        row[2] = Integer.parseInt(CantidadVender);
                        row[3] = modelo1.getValueAt(filas[i], 3);
                        row[4] = modelo1.getValueAt(filas[i], 4);
                        row[5] = modelo1.getValueAt(filas[i], 5);
                        row[6] = modelo1.getValueAt(filas[i], 6);
                        String valorO = modelo1.getValueAt(filas[i], 2).toString();
                        int valor = Integer.parseInt(CantidadVender);
                        // ----
                        String aux = row[0].toString();
                        Long aux1 = Long.valueOf(aux);
                        if (!cp.ExisteEnLaTabla(aux1, TablaPedido)) {
                            if (valor <= Integer.parseInt(valorO)) {
                                modelo2.addRow(row);
                                cp.Ml(row);
                                v = true;
                            } else {
                                JOptionPane.showMessageDialog(null, "ERROR INGRESO", "Stock Insuficiente", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "INTENTO NO VALIDO", "DATO YA HA SIDO AGREGADO", JOptionPane.ERROR_MESSAGE);
                            v = true;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR INGRESO", "DATO NO VALIDO", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "ERROR INGRESO", "DATO VACIO", JOptionPane.ERROR_MESSAGE);
            }
        } while (v != true);
        cp.getProductoOrden().present();


    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel modelo2 = (DefaultTableModel) TablaPedido.getModel();
        // System.out.println("Filas: " + modelo2.getRowCount());
        if (modelo2.getRowCount() > 0) {
            cp.guardarProducto(detalleReparacion.getIdDetalle());
            cp.ActualizaeStock();
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(null, "ERROR EN TABLA", "TABLA VACIA", JOptionPane.ERROR_MESSAGE);
        }

        //cp.actualizaBaseDatos();

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Almacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Almacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Almacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Almacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Almacen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel Fondo2;
    private javax.swing.JLabel FondoR;
    private javax.swing.JTable TablaPedido;
    private javax.swing.JTable TablaProductos;
    private javax.swing.JTable TablaProductosLista;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar4;
    private javax.swing.JButton btnGuardarProducto1;
    private javax.swing.JButton btnInf;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JScrollPane jcroopPanel;
    private javax.swing.JRadioButton rdExternalID;
    private javax.swing.JRadioButton rdNombre;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables

}
