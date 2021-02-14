/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Utiles.Producto;

import Controlador.Conexion.ConeccionBDD;
import Controlador.ListaSimpleAvanzada;
import Modelo.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO LEGION
 */
public class Utiles {

    /**
     * Retorna una lista de productos, la colsulta es realizada en la base de
     * datos
     *
     *
     * @return litsa de prodcuto
     */
    public ListaSimpleAvanzada listaProductos() {
        ListaSimpleAvanzada producto = new ListaSimpleAvanzada();
        String sql = "SELECT * FROM `producto`";
        try {
            Statement st = (Statement) ConeccionBDD.IniciarConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Producto p = new Producto();
                int i = 0;
                p.setId(Long.parseLong(rs.getString(++i)));
                p.setNombre(rs.getString(++i));
                p.setCantidad(Integer.parseInt(rs.getString(++i)));
                p.setMarca(rs.getString(++i));
                p.setPrecio(Double.parseDouble(rs.getString(++i)));
                p.setIva(Double.parseDouble(rs.getString(++i)));
                p.setExternal_id(rs.getString(++i));
                producto.insertar(p);
            }
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar la consulta en la base de datos - listaProducto() Utiles\n" + ex);
        }
        return producto;
    }


}
