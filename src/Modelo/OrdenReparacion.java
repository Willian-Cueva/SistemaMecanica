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
    Long idOrden;
    String fecha;
    double subtotal;
    double total;
    double descuent;
    String requerimiento;
    Long idVehiculo;

    public OrdenReparacion(Long idOrden, String fecha, double subtotal, double total, double descuent, String requerimiento, Long idVehiculo) {
        this.idOrden = idOrden;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.total = total;
        this.descuent = descuent;
        this.requerimiento = requerimiento;
        this.idVehiculo = idVehiculo;
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

    public String getRequerimiento() {
        return requerimiento;
    }

    public void setRequerimiento(String requerimiento) {
        this.requerimiento = requerimiento;
    }

    public Long getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Long idVehiculo) {
        this.idVehiculo = idVehiculo;
    }
    
    
}
