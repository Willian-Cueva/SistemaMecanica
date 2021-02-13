/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.Conexion.ConeccionBDD;
import Controlador.Utiles.Utiles;
import Modelo.DetalleReparacion;
import Modelo.OrdenReparacion;
import Modelo.Vehiculo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Willian
 */
public class ControladorOrdeDeReparacion {

    private ListaSimpleAvanzada ordenes = new ListaSimpleAvanzada();
    private OrdenReparacion orden;
    private DetalleReparacion detalle = new DetalleReparacion();
    private String placa = "";

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public ControladorOrdeDeReparacion() {
        cargarOrdenes();
    }

    public ListaSimpleAvanzada getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(ListaSimpleAvanzada ordenes) {
        this.ordenes = ordenes;
    }

    public OrdenReparacion getOrden() {
        return orden;
    }

    public void setOrden(OrdenReparacion orden) {
        this.orden = orden;
    }

    public DetalleReparacion getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleReparacion detalle) {
        this.detalle = detalle;
    }

    private void cargarOrdenes() {
        this.ordenes = new ListaSimpleAvanzada();
        String sql = "Select * from ordenreparacion where estado = '1';";
        try {
            Statement st = (Statement) ConeccionBDD.IniciarConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                OrdenReparacion op = new OrdenReparacion(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5),
                        rs.getDouble(6), rs.getString(7), rs.getLong(8), rs.getString(9).equalsIgnoreCase("1"));
                ordenes.insertar(op);
            }
        } catch (SQLException ex) {
//            Logger.getLogger(ControladorOrdenOrdenDeReparacion.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al cargar las ordenes de reparacion de la base de datos");
        }

    }

    public void guardarOrden(String fecha, String hora, String descuento, String observacion, String placa) {
        Vehiculo v = (Vehiculo) Utiles.busquedaSecuencial(Utiles.listaVehiculos(), placa, "Placa").obtenerObjetopp(0);
        orden = new OrdenReparacion(fecha, hora, Double.parseDouble(descuento), observacion, v.getId(), true);
        String sql = "insert into ordenreparacion (fecha,hora,descuento,observacion,idVehiculo,estado) values(?,?,?,?,?,?);";
        try {
            PreparedStatement ps = (PreparedStatement) ConeccionBDD.IniciarConexion().prepareCall(sql);
            ps.setString(1, fecha);
            ps.setString(2, hora);
            ps.setString(3, descuento);
            ps.setDouble(4, Double.parseDouble(descuento));
            ps.setString(5, v.getId().toString());
            ps.setString(6, "1");
            ps.executeUpdate();
            System.out.println("Se creo la orden de reparacion con exito");
            cargarOrdenes();
            JOptionPane.showMessageDialog(null, "Se creo la orden de reparacion con exito");
        } catch (SQLException ex) {
//            Logger.getLogger(ControladorOrdeDeReparacion.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al guardar la orden de reparacion en la base de datos");
        }
    }

    public void cargarDetalle() {
//        DetalleReparacion d = (DetalleReparacion) Utiles.busquedaSecuencial(Utiles.listaDetalles(), orden.getIdOrden().toString(), "IdOrden").obtenerObjetopp(0);
        Vehiculo v = (Vehiculo) Utiles.busquedaSecuencial(Utiles.listaVehiculos(), this.placa, "Placa").obtenerObjetopp(0);
        if (v != null) {
            if (tieneOrdenActiva(v)) {
                String sql = "select * from detallereparacion where idOrden='" + orden.getIdOrden().toString() + "';";
                DetalleReparacion d = new DetalleReparacion();
                try {
                    Statement st = ConeccionBDD.IniciarConexion().createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    if (rs.next()) {
                        d.setIdDetalle(rs.getLong(1));
                        d.setIdOrden(rs.getLong(2));
                    } 
                    System.out.println("==================\nd->" + d);
                    JOptionPane.showMessageDialog(null, d.getIdOrden()==null);
                    if (d.getIdOrden()!=null) {
                        JOptionPane.showMessageDialog(null, "Si existe un detalle para esta orden");
                        detalle = d;
                    } else {
                        JOptionPane.showMessageDialog(null, "No existe ningun detalle, se creará un detalle");
                        crearDetalle(orden.getIdOrden());
                    }
                } catch (SQLException ex) {
                    System.err.println("Error al ejecutar la sentencia sql del metodo cargarDetalle()");
                }
            } else {
                System.err.println("Error al crear detalle - por que no tiene una orden activa  porque placa esta vacio");
            }
        } else {
            System.err.println("No se encontro el vehiculo en cargardetalle()");
        }

    }

    private void crearDetalle(long idOrden) {
        String sql = "insert into detallereparacion(idOrden) values(?)";
        try {
            PreparedStatement ps = (PreparedStatement) ConeccionBDD.IniciarConexion().prepareCall(sql);
            ps.setString(1, String.valueOf(idOrden));
            ps.executeUpdate();
            System.out.println("Se creo el detalle con exito");
            cargarDetalle();
        } catch (java.sql.SQLException ex) {
            System.err.println("Error al insertar datos de mecanico en la tabla mecanicos - guardarMecanicos() - Frm_Administrador");
            JOptionPane.showMessageDialog(null, "No se pudo  insertar");
        }
    }

    public boolean tieneOrdenActiva(Object vehiculo) {
        boolean chis = false;
        if (vehiculo != null) {
            Vehiculo v = (Vehiculo) vehiculo;
            for (int i = 0; i < ordenes.tamano(); i++) {
                OrdenReparacion or = (OrdenReparacion) ordenes.obtenerObjetopp(i);
                if (Objects.equals(or.getIdVehiculo(), v.getId())) {
                    System.out.println("Si existe una orden activa para dicho vehiculo");
                    chis = true;
                    this.placa = v.getPlaca();
                    this.orden = or;
                    break;
                }
            }
        } else {
            System.err.println("No se encontro el vehiculo");
        }
        return chis;
    }

}
