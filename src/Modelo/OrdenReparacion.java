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
    
    public OrdenReparacion(String fecha, String hora, double descuent, String observacion, Long idVehiculo, boolean estado) {
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
    
    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public OrdenReparacion() {
    }  
    
    public Long getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDescuent() {
        return descuent;
    }

    public void setDescuent(double descuent) {
        this.descuent = descuent;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Long getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Long idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return idOrden+" "+fecha+ " "+hora+" "+subtotal+" "+total+" "+descuent
                +" "+observacion+" "+idVehiculo+" "+estado;
    }

    
    
}
