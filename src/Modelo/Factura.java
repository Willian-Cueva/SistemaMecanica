/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Willian
 */
public class Factura {
    private Long idFactura;
    private String hora;
    private String fecha;
    private Long idOrden;

    public Factura() {
    }

    public Factura(Long idFactura, String hora, String fecha, Long idOrden) {
        this.idFactura = idFactura;
        this.hora = hora;
        this.fecha = fecha;
        this.idOrden = idOrden;
    }

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Long getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }
    
}
