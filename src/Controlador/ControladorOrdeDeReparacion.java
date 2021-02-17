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
import Modelo.Producto;
import Modelo.Vehiculo;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import Controlador.UtilesMecanico.UtilesMecanico;
import Modelo.Persona;
import Modelo.Servicio;

/**
 *
 * @author Willian
 */
public class ControladorOrdeDeReparacion {
    UtilesMecanico uti=new UtilesMecanico();
    private ListaSimpleAvanzada ordenes = new ListaSimpleAvanzada();
    private OrdenReparacion orden;
    private DetalleReparacion detalle = new DetalleReparacion();
//    private String placa = "";
    OrdenReparacion aux=new OrdenReparacion();
    private Vehiculo vehiculo = new Vehiculo();
    /**
     * Retorna Vehiculo
     * @return Vehiculo
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    /**
     * Recibe un vehiculo
     * @param vehiculo Vehiculo
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    /**
     * Constructor que al instanciarlo ejecuta el metodo cargarOrdenes()
     */
    public ControladorOrdeDeReparacion() {
        cargarOrdenes();
    }
    /**
     * Retorna una ListaSimpleAvanzada
     * @return ListaSimpleAvanzada
     */
    public ListaSimpleAvanzada getOrdenes() {
        return ordenes;
    }
    /**
     * Recive ListaSimpleAvanzada
     * @param ordenes ListaSimpleAvanzada
     */
    public void setOrdenes(ListaSimpleAvanzada ordenes) {
        this.ordenes = new ListaSimpleAvanzada();
        this.ordenes = ordenes;
    }
    /**
     * retorna una OrdenReparacion
     * @return OrdenReparacion
     */
    public OrdenReparacion getOrden() {
        return orden;
    }
    /**
     * Recibe una OrdenReparacion
     * @param orden OrdenReparacion 
     */
    public void setOrden(OrdenReparacion orden) {
        this.orden = orden;
    }
    /**
     * Devuelve un DetalleReparacion
     * @return DetalleReparacion
     */
    public DetalleReparacion getDetalle() {
        return detalle;
    }
    /**
     * recibe un Detallereparacion
     * @param detalle Detallereparacion
     */
    public void setDetalle(DetalleReparacion detalle) {
        this.detalle = detalle;
    }
    
    /**
     * Este metodo permite actualizar el subtotal y el total 
     * respecto a la lista de repuestos y la lista de servicios
     * tomando en cuenta el descuento
     */
    public void calcularValores(){
        double subtotal=0.0;
        
        for (int i = 0; i < detalle.getListaProductos().tamano(); i++) {
            Producto p = (Producto) detalle.getListaProductos().obtenerObjetopp(i);
            subtotal += p.getPrecio();
        }
        
        orden.setSubtotal(Math.round(subtotal*100.0)/100.0);
        
        double total = subtotal - subtotal*orden.getDescuent();
        
        orden.setTotal(Math.round(total*100.0)/100.0);
        actualizarOrden();
    }
    //BuscarFactura
    /**
     * Retorna una persona con los atributos de dicho propietario
     * @return Persona
     */
    public Persona propietario(){
        Persona p = (Persona) Utiles.busquedaSecuencial(Utiles.listaPersonas(Utiles.PERSONAS), vehiculo.getIdPersona(), "Id").obtenerObjetopp(0);
        return p;
    }
    
    private void actualizarOrden(){
        System.out.println(orden);
        String sql = "UPDATE `baseddmecanica`.`ordenreparacion` SET `subtotal` = '"+orden.getSubtotal()+"', `total` = '"+orden.getTotal()+
                "', `descuento` = '"+orden.getDescuent()+"', `Observacion` = '"+orden.getObservacion()+"' WHERE (`idordenReparacion` = '"+orden.getIdOrden()+"');";
        try {
            PreparedStatement ps = (PreparedStatement) ConeccionBDD.IniciarConexion().prepareStatement(sql);
            ps.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Se actualizo la orden de reparacion correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la orden de reparacion", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    //BuscarFactura
    /**
     * Este metodo permite actualizar los productos desde la tabla de salidaproducto de la base de datos
     * respectivamente a la lista de productos del detalle de reparacion en tiempo de ejecucion
     */
    public void cargarListaProductos(){
        String sql ="SELECT idProducto,cantidad FROM salidaproducto where idDetalle='"+detalle.getIdDetalle().toString()+"'";
        ListaSimpleAvanzada productos = new ListaSimpleAvanzada();       
        try {
            Statement st = ConeccionBDD.IniciarConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {                
                Producto p = (Producto) Utiles.busquedaSecuencial(Utiles.listaProductos(), rs.getString(1), "Id").obtenerObjetopp(0);
                p.setCantidad(rs.getInt(2));
                double precio = p.getPrecio()*p.getCantidad();
                p.setPrecio(precio);
                productos.insertar(p);
                System.out.println(p);
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar la tabla salida producto");;
        }
        detalle.setListaProductos(productos);
        
    }
    /**
     * Este metodo permite cargar la lista de servicios que se le han relizado al vehiculo desde la base de datos a una lista Simple
     */
    public void cargarListaServicios(){
        System.out.println("detalle: ----------"+detalle.getIdDetalle());
        Lista.ListaSimple<Servicio> lservicio=new Lista.ListaSimple<>();    
        UtilesMecanico ut=new UtilesMecanico();
        
        try {
            
            Statement st = (Statement) uti.getConexion().createStatement();
            ResultSet rs = st.executeQuery(ut.tr(detalle.getIdDetalle()));
            while (rs.next()) { 
                lservicio.insertar(new Servicio(rs.getLong(3),rs.getString(4),rs.getDouble(5), rs.getString(6)));
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar la tabla salida producto\n"+ex.getMessage());
        }
        detalle.setListaServivios(lservicio);
        lservicio.verDatos();
    }
//    public void cargarListaServiciosFactura(){
//        System.out.println("detalle: ----------"+detalle.getIdDetalle());
//        Lista.ListaSimple<Servicio> lservicio=new Lista.ListaSimple<>();    
//        UtilesMecanico ut=new UtilesMecanico();
//        
//        try {
//            
//            Statement st = (Statement) uti.getConexion().createStatement();
//            ResultSet rs = st.executeQuery(ut.tr(detalle.getIdDetalle()));
//            while (rs.next()) { 
//                lservicio.insertar(new Servicio(rs.getLong(3),rs.getString(4),rs.getDouble(5), rs.getString(6)));
//            }
//        } catch (SQLException ex) {
//            System.err.println("Error al consultar la tabla salida producto\n"+ex.getMessage());
//        }
//        detalle.setListaServivios(lservicio);
//        lservicio.verDatos();
//    }
    /**
     * En este metodo se cargan en la lsita de ordenes todas las que se encuentren como activas
     */
    public void cargarOrdenes() {
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
    /**
     * Este metodo permite guardar una orden de reparacion siempre y cuendo esta no exista como activa en la base
     * de datos respectivamente al vehiculo 
     * @param fecha fecha en la que se crea la orden de reparacion
     * @param hora hora en la que se crea la orden de reparacion
     * @param descuento se le agrega un descuento representado en el rango de 0 a 1 porciento de descuento
     * @param observacion observacion de la orden de reparacion
     * @param placa Placa del vehiculo
     */
    public void guardarOrden(String fecha, String hora, String descuento, String observacion, String placa) {
        Vehiculo v = (Vehiculo) Utiles.busquedaSecuencial(Utiles.listaVehiculos(), placa, "Placa").obtenerObjetopp(0);
        orden = new OrdenReparacion(fecha, hora, Double.parseDouble(descuento), observacion, v.getId(), true);
        String sql = "insert into ordenreparacion (fecha,hora,descuento,observacion,idVehiculo,estado) values(?,?,?,?,?,?);";
        try {
            PreparedStatement ps = (PreparedStatement) ConeccionBDD.IniciarConexion().prepareCall(sql);
            ps.setString(1, fecha);
            ps.setString(2, hora);
            ps.setString(3, descuento);
            ps.setString(4, observacion);
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
    //BuscarFactura
    /**
     * Este metodo permite dependiendo el vehiculo cargar el detalle de la orden de reparacoin desde la base de datos,
     * en el caso de no existir esa orden se crea una y vuelve a ejecutarce el metodo ingresando a el detalle de reparacion
     */
    public void cargarDetalle() {
//        DetalleReparacion d = (DetalleReparacion) Utiles.busquedaSecuencial(Utiles.listaDetalles(), orden.getIdOrden().toString(), "IdOrden").obtenerObjetopp(0);
        Vehiculo v = (Vehiculo) Utiles.busquedaSecuencial(Utiles.listaVehiculos(), this.vehiculo.getPlaca(), "Placa").obtenerObjetopp(0);
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
//                    JOptionPane.showMessageDialog(null, d.getIdOrden()==null);

                    if (d.getIdOrden()!=null) {
//                        JOptionPane.showMessageDialog(null, "Si existe un detalle para esta orden");
                        detalle = d;
                    } else {
//                        JOptionPane.showMessageDialog(null, "No existe ningun detalle, se creará un detalle");
                        crearDetalle(orden.getIdOrden());
                    }
                } catch (SQLException ex) {
                    System.err.println("Error al ejecutar la sentencia sql del metodo cargarDetalle()\n"+ex.getMessage());
                }
            } else {
                System.err.println("Error al crear detalle - por que no tiene una orden activa  porque placa esta vacio");
            }
        } else {
            System.err.println("No se encontro el vehiculo en cargardetalle()");
        }

    }
    /**
     * Carga los detalles de la orden de reparacion de dicha factura
     */
    public void cargarDetalleFactura() {
//        DetalleReparacion d = (DetalleReparacion) Utiles.busquedaSecuencial(Utiles.listaDetalles(), orden.getIdOrden().toString(), "IdOrden").obtenerObjetopp(0);
        Vehiculo v = (Vehiculo) Utiles.busquedaSecuencial(Utiles.listaVehiculos(), this.vehiculo.getPlaca(), "Placa").obtenerObjetopp(0);
        System.err.println(v);
        if (v != null) {
            if (true) {
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
//                    JOptionPane.showMessageDialog(null, d.getIdOrden()==null);

                    if (d.getIdOrden()!=null) {
//                        JOptionPane.showMessageDialog(null, "Si existe un detalle para esta orden");
                        detalle = d;
                    } else {
//                        JOptionPane.showMessageDialog(null, "No existe ningun detalle, se creará un detalle - ControladorOrdenReparacion");
                        crearDetalle(orden.getIdOrden());
                    }
                } catch (SQLException ex) {
                    System.err.println("Error al ejecutar la sentencia sql del metodo cargarDetalleFactura() - ControladorOrdenReparacion");
                }
            } else {
                System.err.println("Error al crear detalle - por que no tiene una orden activa  porque placa esta vacio - ControladorOrdenReparacion");
            }
        } else {
            System.err.println("No se encontro el vehiculo en cargardetalle() - ControladorOrdenReparacion");
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
    
    /**
     * Este metodo permite buscar una orden de reparacion activa en base al vehiculo ingresado
     * @param vehiculo Vehiculo para buscar si existe una orden de reparacion activa
     * @return retorna true si existe una orden de reparacion activa para dicho vehiculo, y retorna false en caso de no existir
     */
    public boolean tieneOrdenActiva(Object vehiculo) {
        cargarOrdenes();
        boolean chis = false;
        if (vehiculo != null) {
            Vehiculo v = (Vehiculo) vehiculo;
            for (int i = 0; i < ordenes.tamano(); i++) {
                OrdenReparacion or = (OrdenReparacion) ordenes.obtenerObjetopp(i);
                if (Objects.equals(or.getIdVehiculo(), v.getId())) {
                    System.out.println("Si existe una orden activa para dicho vehiculo");
                    chis = true;
                    this.vehiculo = v;
                    this.orden = or;
                    this.aux=or;
                    break;
                }
            }
        } else {
            System.err.println("No se encontro el vehiculo");
        }
        return chis;
    }
    /**
     * Este metodo permite actualizar los servicios que se le relizan al vehiculo el cual tirne una orden de reparacion activa
     * @param subtotal double subtotal
     */
     public void actualizarOrdenServicio(double subtotal){
         try {
             //cargarOrdenes();
             int i=0;
             System.out.println("Entra al metodo actualizar"+subtotal+ " "+ aux.getIdOrden());
             // String sql = "UPDATE `baseddmecanica`.`ordenreparacion` SET `subtotal` = '"+orden.getSubtotal()+"', `total` = '"+orden.getTotal()+
               // "', `descuento` = '"+orden.getDescuent()+"', `Observacion` = '"+orden.getObservacion()+"' WHERE (`idordenReparacion` = '"+orden.getIdOrden()+"');";
                String insertar ="UPDATE ordenreparacion SET subtotal = ?,total=?,descuento=?,observacion=? WHERE (idordenReparacion = ?)";
                PreparedStatement stmt = (PreparedStatement) uti.getConexion().prepareStatement(insertar);
                stmt.setDouble(1, aux.getSubtotal()+subtotal);
                stmt.setDouble(2, aux.getTotal()+subtotal-orden.getDescuent());
                stmt.setDouble(3,orden.getDescuent());
                stmt.setString(4, orden.getObservacion());
                stmt.setLong(5, aux.getIdOrden());
                i = stmt.executeUpdate();
                System.out.println("i------------ "+i);
            } catch (SQLException ex) {
                System.out.println("Error: "+ex);
            }catch(Exception ex){
                System.out.println("Error: "+ex);
            }
    }

}
