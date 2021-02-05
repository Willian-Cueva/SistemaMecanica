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
public class DetalleReparacion {
    Long idDetalle;
    Long idOrden;
    Long idProducto;
    Long idServicios;

    public DetalleReparacion(Long idDetalle, Long idOrden, Long idProducto, Long idServicios) {
        this.idDetalle = idDetalle;
        this.idOrden = idOrden;
        this.idProducto = idProducto;
        this.idServicios = idServicios;
    }

    public Long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Long getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Long getIdServicios() {
        return idServicios;
    }

    public void setIdServicios(Long idServicios) {
        this.idServicios = idServicios;
    }
    
}
