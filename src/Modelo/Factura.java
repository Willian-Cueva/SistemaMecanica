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
    private OrdenReparacion orden;

    /**
     * Crear una Factura
     */
    public Factura() {
    }
    /**
     * Crear una Factura
     * @param idFactura Long
     * @param hora Stirng
     * @param fecha String
     * @param idOrden Long
     */
    public Factura(Long idFactura, String hora, String fecha, Long idOrden) {
        this.idFactura = idFactura;
        this.hora = hora;
        this.fecha = fecha;
        this.idOrden = idOrden;
    }
    /**
     * Traer Orden Factura
     * @return OrdenReparacion
     */
    public OrdenReparacion getOrden() {
        return orden;
    }
    /**
     * Enviar una OrdenReparacion.
     * @param orden OrdenReparacion
     */
    public void setOrden(OrdenReparacion orden) {
        this.orden = orden;
    }
    /**
     * Traer IdFactura
     * @return Long
     */
    public Long getIdFactura() {
        return idFactura;
    }
    /**
     * Enviar un IdFactura
     * @param idFactura Long 
     */
    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }
    /**
     * Traer Hera Factura
     * @return String
     */
    public String getHora() {
        return hora;
    }
    /**
     * Enviar hora Factura
     * @param hora  String
     */
    public void setHora(String hora) {
        this.hora = hora;
    }
    /**
     * Traer Fecha
     * @return String
     */
    public String getFecha() {
        return fecha;
    }
    /**
     * Enviar Fecha Factura
     * @param fecha String 
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    /**
    * Traer IdOrden
    * @return Long
    */
    public Long getIdOrden() {
        return idOrden;
    }
    /**
     * Enviar IdOrden 
     * @param idOrden Long
     */
    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }

    @Override
    public String toString() {
        return idFactura+" "+fecha+" "+hora+" "+idOrden;
    }
    
}
