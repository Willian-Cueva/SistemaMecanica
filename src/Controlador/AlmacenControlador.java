/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.Conexion.ConeccionBDD;
import Controlador.Utiles.Producto.Utiles;
import Modelo.DetalleReparacion;
import Modelo.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author LENOVO LEGION
 */
public class AlmacenControlador {

    private Utiles u = new Utiles();
    private ListaSimpleAvanzada productoOrden = new ListaSimpleAvanzada();
    private ListaSimpleAvanzada producto = new ListaSimpleAvanzada();
    private ListaSimpleAvanzada productoBaseDatos = u.listaProductos();
    /**
     * Retorna una ListaSimpleAvanzada de productos de esta clase
     * @return ListaSimpleAvanzada
     */
    public ListaSimpleAvanzada getProducto() {
        if (producto == null) {
            producto = new ListaSimpleAvanzada();
        }
        return producto;
    }
    /**
     * Recive una ListaSimpleAvanzada de productos
     * @param producto ListaSimpleAvanzada
     */
    public void setProducto(ListaSimpleAvanzada producto) {
        this.producto = new ListaSimpleAvanzada();
        this.producto = producto;
    }
    /**
     * Retorna una ListaSimpleAvanzada de los productos de dicha orden en 
     * @return ListaSimpleAvanzada 
     */
    public ListaSimpleAvanzada getProductoOrden() {
        if (productoOrden == null) {
            productoOrden = new ListaSimpleAvanzada();
        }
        return productoOrden;
    }
    /**
     * Recibe una ListaSimpleAvanzada de productos de dicha orden
     * @param productoOrden ListaSimpleAvanzada
     */
    public void setProductoOrden(ListaSimpleAvanzada productoOrden) {
        this.productoOrden = new ListaSimpleAvanzada();
        this.productoOrden = productoOrden;
    }
    /**
     * Retorna una ListaSimpleAvanzada extraida del atributo utiles de esta clase
     * @return ListaSimpleAvanzada
     */
    public ListaSimpleAvanzada obtenerLista() {
        return u.listaProductos();
    }

 
    /**
     * Retorna un objeto de tipo producto, recibe como parametro row que es el
     * objeto a transdfrmar
     * @param row Arreglod e objetos
     * @return Retorna uN producto
     */
    public Producto transformar(Object[] row) {
        Producto prdt = new Producto();
        prdt.setId((Long) row[0]);
        prdt.setNombre((String) row[1]);
        prdt.setCantidad((int) row[2]);
        prdt.setMarca((String) row[3]);
        prdt.setPrecio((double) row[4]);
        prdt.setIva((double) row[5]);
        prdt.setExternal_id((String) row[6]);
        return prdt;
    }

    /**
     * Este metodo nos permite guardar el detalle de productos de cada auto.
     *
     * @param idDetalle ind del detalle de reparacion
     *
     */
    public void guardarProducto(long idDetalle) {
        productoOrden.present();
        for (int i = 0; i < productoOrden.tamano(); i++) {
            Producto miPrdt = (Producto) productoOrden.obtenerObjetopp(i);
            try {
                String sql = "INSERT INTO `baseddmecanica`.`salidaproducto` (`idProducto`, `idDetalle`, `cantidad`) VALUES (?,?,?);";
                PreparedStatement ps = (PreparedStatement) ConeccionBDD.IniciarConexion().prepareCall(sql);
                ps.setString(1, String.valueOf(miPrdt.getId()));
                ps.setString(2, String.valueOf(idDetalle));
                ps.setString(3, String.valueOf(miPrdt.getCantidad()));
                ps.executeUpdate();
            } catch (java.sql.SQLException ex) {
                System.err.println("Error para guardar el Detalle ----- Frm_Almacen");
                JOptionPane.showMessageDialog(null, "No se pudo  insertar");
            }

        }

    }

    /**
     * Este metodo permite ingresar productos al detalle de reparacion
     *
     * @param row Objeto a ingresar a la lista
     * @return Lista.
     */
    public ListaSimpleAvanzada Ml(Object[] row) {
        productoOrden.insertar(transformar(row));
        return productoOrden;
    }

    /**
     * Este metodo permite verificar por los id si ya se agrego un producto
     *
     * @param indice id a buscas
     * @param tabla Tabla en la que se requiere bucar
     * @return true si existe coincidencia por lo contrario devuelve false si no
     * se a encontrado
     */
    public boolean ExisteEnLaTabla(long indice, JTable tabla) {
        boolean v = false;
        for (int i = 0; i < tabla.getRowCount(); i++) {
            String valorO = tabla.getValueAt(i, 0).toString();
            long valor = Long.valueOf(valorO);
            if (indice == valor) {

                v = true;
            }
        }
        return v;
    }

    /**
     * Nos permite buscar los stock en las listas que se manejan en las tablas
     * @param indice id del producto que se agrego a la order de reparacion
     * @param cantidad cantidad del producto que se agrego
     * @return Stock actualizado
     */
    public int BuscarStock(long indice, int cantidad) {
        int respuesta = 0;
        for (int i = 0; i < productoBaseDatos.tamano(); i++) {
            Producto objpro = new Producto();
            objpro = (Producto) productoBaseDatos.obtenerObjetopp(i);
            Long v = objpro.getId();
            if (indice == v) {
                respuesta = objpro.getCantidad() - cantidad;
                break;
            }
        }
        return respuesta;
    }
    /**
     * Nos permite actualizar el estock de produntos een la base de datos.
     */
    public void ActualizaeStock() {
        for (int i = 0; i < productoOrden.tamano(); i++) {
            Producto objpro = new Producto();
            objpro = (Producto) productoOrden.obtenerObjetopp(i);
            int StockAtualizado = BuscarStock(objpro.getId(), objpro.getCantidad());
            System.out.println("NOMBRE: " + objpro.getNombre() + "  STCK ACTUAL :" + StockAtualizado);
            SentenciasSQL(objpro.getId(), StockAtualizado);
        }
    }
    /**
     * Este metodo nos permite realizar la modificacion en la base de datos 
     * @param id Representa el id del producto que agregamos en la orden.
     * @param stockA Representa el stock que se desee poner en la base de datos 
     */
    public void SentenciasSQL(long id, int stockA) {
        String sql = "UPDATE `producto` SET `cantidad` = '"+stockA+"' WHERE (`producto`.`idProducto` = '"+id+"')";
        try {
            System.out.println("ACTUALIZA STOCK");
            PreparedStatement ps = (PreparedStatement) ConeccionBDD.IniciarConexion().prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se actualizaron los datos correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar los datos en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("No se actualizaron los datos - error:" + ex);
        }
    }
}
