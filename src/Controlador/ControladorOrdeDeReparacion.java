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
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Willian
 */
public class ControladorOrdeDeReparacion {

    private ListaSimpleAvanzada ordenes = new ListaSimpleAvanzada();
    private OrdenReparacion orden;
    private DetalleReparacion detalle = new DetalleReparacion();
    private String placa="";

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
                        rs.getDouble(6), rs.getString(7), rs.getLong(8),rs.getString(9).equalsIgnoreCase("1"));
                ordenes.insertar(op);
            }
        } catch (SQLException ex) {
//            Logger.getLogger(ControladorOrdenOrdenDeReparacion.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al cargar las ordenes de reparacion de la base de datos");
        }
        
    }

    public void guardarOrden(String fecha, String hora,String descuento,String observacion,String placa){
        Vehiculo v = (Vehiculo) Utiles.busquedaSecuencial(Utiles.listaVehiculos(), placa, "Placa").obtenerObjetopp(0);
        orden = new OrdenReparacion(fecha, hora, Double.parseDouble(descuento), observacion, v.getId(), true);
        String sql = "insert into ordenreparacion (fecha,hora,descuento,observacion,idVehiculo,estado) values(?,?,?,?,?,?);";
        try {
            PreparedStatement ps =(PreparedStatement) ConeccionBDD.IniciarConexion().prepareCall(sql);
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
    
    
    public boolean tieneOrdenActiva(Object vehiculo) {
        boolean chis = false;
        
        if (vehiculo!=null) {
            Vehiculo v = (Vehiculo) vehiculo;
            for (int i = 0; i < ordenes.tamano(); i++) {
                OrdenReparacion or = (OrdenReparacion) ordenes.obtenerObjetopp(i);
                if (Objects.equals(or.getIdVehiculo(), v.getId())) {
                    System.out.println("Si existe una orden activa para dicho vehiculo");
                    chis = true;
                    this.placa=v.getPlaca();
                    this.orden=or;
                    break;
                }
            }
        } else {
            System.err.println("No se encontro el vehiculo");
        }
        return chis;
    }

}
