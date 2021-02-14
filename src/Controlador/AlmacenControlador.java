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
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO LEGION
 */
public class AlmacenControlador {
    
    private ListaSimpleAvanzada productoOrden = new ListaSimpleAvanzada();
    private ListaSimpleAvanzada producto = new ListaSimpleAvanzada();
    private Utiles u = new Utiles();

    public ListaSimpleAvanzada getProducto() {
        if (producto == null) {
            producto = new ListaSimpleAvanzada();
        }
        return producto;
    }

    public void setProducto(ListaSimpleAvanzada producto) {
        this.producto = new ListaSimpleAvanzada();
        this.producto = producto;
    }

    public ListaSimpleAvanzada getProductoOrden() {
        if (productoOrden == null) {
            productoOrden = new ListaSimpleAvanzada();
        }
        return productoOrden;
    }

    public void setProductoOrden(ListaSimpleAvanzada productoOrden) {
        this.productoOrden = new ListaSimpleAvanzada();
        this.productoOrden = productoOrden;
    }
    
    

    public ListaSimpleAvanzada obtenerLista() {
        return u.listaProductos();
    }

    /**
     * Retorna un objeto de tipo producto, recibe como parametro row que es el
     * objeto a transdfrmar
     *
     *
     * @return Un objeto Producto
     */
    public Producto transformar(Object [] row) {
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
     *  Este metodo nos permite guardar el detalle de productos de cada auto.
     * @param detalleReparacion ingresa el detalle de reparacion de cada auto
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
    
    public ListaSimpleAvanzada Ml (Object [] row){
           productoOrden.insertar(transformar(row));
    return productoOrden;
    }
}
