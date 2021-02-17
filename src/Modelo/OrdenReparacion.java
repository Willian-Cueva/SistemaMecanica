/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *  
 * @author Cris2
 */
public class OrdenReparacion {
    private Long idOrden;
    private String fecha;
    private String hora;
    private double subtotal;
    private double total;
    private double descuent;
    private String observacion;
    private Long idVehiculo;
    private boolean estado;
    /**
     * Crear una OrdenReparacion
     * @param idOrden Long 
     * @param fecha String
     * @param hora String
     * @param subtotal Double
     * @param total Double
     * @param descuent Double
     * @param observacion String
     * @param idVehiculo Long
     * @param estado  Boolean
     */
    public OrdenReparacion(Long idOrden, String fecha, String hora, double subtotal, double total, double descuent, String observacion, Long idVehiculo, boolean estado) {
        this.idOrden = idOrden;
        this.fecha = fecha;
        this.hora = hora;
        this.subtotal = subtotal;
        this.total = total;
        this.descuent = descuent;
        this.observacion = observacion;
        this.idVehiculo = idVehiculo;
        this.estado = estado;
    }
    /**
     * Crear OrdenReparacion
     * @param fecha String 
     * @param hora Stirng
     * @param descuent Double
     * @param observacion Stirng
     * @param idVehiculo Long
     * @param estado  Double
     */
    public OrdenReparacion(String fecha, String hora, double descuent, String observacion, Long idVehiculo, boolean estado) {
        this.fecha = fecha;
        this.hora = hora;
        this.descuent = descuent;
        this.observacion = observacion;
        this.idVehiculo = idVehiculo;
        this.estado = estado;
    }
    /**
     *Crear  OrdenReparacion
     */
    public OrdenReparacion() {
    }  
    
    /**
     * Traer Hora OrdenReparacion
     * @return Stirng
     */
    public String getHora() {
        return hora;
    }
    /**
     * Envia Hora OrdenReparacion
     * @param hora String
     */
    public void setHora(String hora) {
        this.hora = hora;
    }
    /**
     * Traer IdOrden OrdenReparacion
     * @return  Long
     */
    public Long getIdOrden() {
        return idOrden;
    }
    /**
     * Enviar IdOrden OrdenReparacion
     * @param idOrden Long
     */
    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }
    /**
     * Traer Fecha OrdenReparacion
     * @return String
     */
    public String getFecha() {
        return fecha;
    }
    /**
     * Enviar Fecha OrdenReparacion
     * @param fecha String
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    /**
     * Traer SubTotal OrdenReparacion
     * @return Double
     */
    public double getSubtotal() {
        return subtotal;
    }
    /**
     * Enviar SubTotal OrdenReparacion
     * @param subtotal Double
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    /**
     * Traer Total OrdenReparacion
     * @return Double
     */
    public double getTotal() {
        return total;
    }
    /**
     * Enviar Total OrdenReparacion
     * @param total Double
     */
    public void setTotal(double total) {
        this.total = total;
    }
    /**
     * Traer Descuento OrdenReparacion
     * @return Double
     */
    public double getDescuent() {
        return descuent;
    }
    /**
     * Enviar descuento
     * @param descuent Double 
     */
    public void setDescuent(double descuent) {
        this.descuent = descuent;
    }
    /**
     * Traer Observacion OrdenReparacion
     * @return String
     */
    public String getObservacion() {
        return observacion;
    }
    /**
     * Eviar Observacion OrdenReparacion
     * @param observacion Stirng
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    /**
     * Traer el IdVehiculo OrdenReparacion
     * @return Long
     */
    public Long getIdVehiculo() {
        return idVehiculo;
    }
    /**
     * Enviar el IdVehiculo OrdenReparacion
     * @param idVehiculo Long
     */
    public void setIdVehiculo(Long idVehiculo) {
        this.idVehiculo = idVehiculo;
    }
    /**
     * Traer el Estado OrdenReparacion
     * @return Boolean
     */
    public boolean isEstado() {
        return estado;
    }
    /**
     * Enviar Estado OrdenReparacion
     * @param estado Boolean
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return idOrden+" "+fecha+ " "+hora+" "+subtotal+" "+total+" "+descuent
                +" "+observacion+" "+idVehiculo+" "+estado;
    }

    
    
}
