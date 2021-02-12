/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.Conexion.ConeccionBDD;
import Modelo.OrdenReparacion;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Willian
 */
public class ControladorOrdenDetalleDeReparacion {

    private ListaSimpleAvanzada detallesDeReparacion = new ListaSimpleAvanzada();
    private ControladorOrdenDetalleDeReparacion detalle;

    public ControladorOrdenDetalleDeReparacion() {
        cargarDetalles();
    }

    public ListaSimpleAvanzada getDetallesDeReparacion() {
        return detallesDeReparacion;
    }

    public void setDetallesDeReparacion(ListaSimpleAvanzada detallesDeReparacion) {
        this.detallesDeReparacion = detallesDeReparacion;
    }

    public ControladorOrdenDetalleDeReparacion getDetalle() {
        return detalle;
    }

    public void setDetalle(ControladorOrdenDetalleDeReparacion detalle) {
        this.detalle = detalle;
    }

    private void cargarDetalles() {
        this.detallesDeReparacion = new ListaSimpleAvanzada();
        String sql = "Select * from ordenreparacion where estado = '1';";
        try {
            Statement st = (Statement) ConeccionBDD.IniciarConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                OrdenReparacion op = new OrdenReparacion(rs.getLong(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(3), rs.getString(4), rs.getLong(5), "1".equals(rs.getString(6)));
            }
        } catch (SQLException ex) {
//            Logger.getLogger(ControladorOrdenDetalleDeReparacion.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al cargar las ordenes de reparacion de la base de datos");
        }
    }

}
