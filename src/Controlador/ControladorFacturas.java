/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.Conexion.ConeccionBDD;
import Controlador.Utiles.Utiles;
import Modelo.Factura;
import Modelo.OrdenReparacion;
import Modelo.Vehiculo;
import Vista.Frm_Facturar;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Willian
 */
public class ControladorFacturas {

    private ListaSimpleAvanzada facturas = new ListaSimpleAvanzada();
    private Factura factura;
    private Vehiculo vehiculo;
    /**
     * Retorna un Vehiculo
     * @return Vehiculo
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    /**
     * Recibe un Vehiculo
     * @param v Vehiculo
     */
    public void setVehiculo(Vehiculo v) {
        this.vehiculo = v;
    }
    private ControladorOrdeDeReparacion cntrl = new ControladorOrdeDeReparacion();
    /**
     * Este metodo sirve para cargar la lista de facturas de la base de datos
     * a la lista de facturas de esta clase ControladorFacturas
     * @param placa String placa del vehiculo
     */
    public void cargarFacturas(String placa) {
//        facturas = new ListaSimpleAvanzada();
//        //hacer una consulta para obtener las facturas de dicho vehiculo
        this.vehiculo = (Vehiculo) Utiles.busquedaSecuencial(Utiles.listaVehiculos(), placa, "Placa").obtenerObjetopp(0);
        cntrl.setVehiculo(vehiculo);
//        System.err.println(vehiculo);
//        listaDeOrdenes();
        listaFacturas(placa);
    }
    /**
     * Este metodo permite presentar las facturas emitidas
     * @param nroFactura nro de la factura
     */
    public void cargarDetalles(String nroFactura) {
        
            Factura f = obtenerFactura(nroFactura);
            System.err.println(f);
            cntrl.setOrden(obtenerOrden(f.getIdOrden().toString()));
            System.err.println(obtenerOrden(f.getIdOrden().toString()));
            new Frm_Facturar(cntrl,Frm_Facturar.PROTOTIPOFACTURA).setVisible(true);
        
            //System.err.println("Error al encontrar dicha factura en cargarDetalles"+e.getMessage());
        
    }

    private Factura obtenerFactura(String nroFactura) {
        String sql = "SELECT * FROM baseddmecanica.factura "
                + "where factura.nroFactura = '" + nroFactura + "'";
        try {
            Statement st = ConeccionBDD.IniciarConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                Factura f = new Factura(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getLong(4));
                f.setOrden(obtenerOrden(f.getIdOrden().toString()));
                System.out.println("Se extrajo la factura con exito");
                return f;
            } else {
                System.err.println("Factura null en obtenerFactura() - Controladorfacturas");
                return null;
            }
        } catch (SQLException ex) {
            System.err.println("No se pudo ejecutar el sql obtenerFactura() - Controladorfacturas");
            return null;
        }
    }
    /**
     * Devuelve una ListaSimpleAvanzada
     * @return ListaSimpleAvanzada
     */
    public ListaSimpleAvanzada getFacturas() {
        return facturas;
    }
    /**
     * Recibe una ListaSimpleAvanzada de facturas
     * @param facturas ListaSimpleAvanzada de facturas
     */
    public void setFacturas(ListaSimpleAvanzada facturas) {
        this.facturas = facturas;
    }
    /**
     * retorna la factura de esta clase
     * @return Factura
     */
    public Factura getFactura() {
        return factura;
    }
    /**
     * Recibe una factura
     * @param factura Factura
     */
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    /**
     * devuelve un ControladorOrdeDeReparacion
     * @return ControladorOrdeDeReparacion
     */
    public ControladorOrdeDeReparacion getCntrl() {
        return cntrl;
    }
    /**
     * Recibe un ControladorOrdeDeReparacion
     * @param cntrl ControladorOrdeDeReparacion
     */
    public void setCntrl(ControladorOrdeDeReparacion cntrl) {
        this.cntrl = cntrl;
    }

    private void listaFacturas(String placa) {
        facturas = new ListaSimpleAvanzada();
        String sql = "SELECT * FROM baseddmecanica.factura "
                + "where factura.idOrden = "
                + "(SELECT idordenReparacion from ordenreparacion where idordenReparacion=factura.idOrden and"
                + " idVehiculo=(select vehiculo.idVehiculo from vehiculo where placa like '" + placa + "')"
                + ");";
        try {
            Statement st = ConeccionBDD.IniciarConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Factura f = new Factura(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getLong(4));
                f.setOrden(obtenerOrden(f.getIdOrden().toString()));
                facturas.insertar(f);
            }
            System.out.println("Se extrajo todas las facturas con exito");
        } catch (SQLException ex) {
            System.err.println("No se pudo ejecutar el sql en listafacturas()");
        }
    }

    private OrdenReparacion obtenerOrden(String idOrden) {
        OrdenReparacion or = new OrdenReparacion();
        String sql = "SELECT * FROM ordenreparacion where idordenReparacion='" + idOrden + "'";
        try {
            Statement st = ConeccionBDD.IniciarConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                or = new OrdenReparacion(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5),
                        rs.getDouble(6), rs.getString(7), rs.getLong(8), rs.getString(9).equalsIgnoreCase("1"));
            } else {
                or = null;
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener el orden de raparacion de la factura en obtenerOrden()");
        }
        return or;
    }

}
