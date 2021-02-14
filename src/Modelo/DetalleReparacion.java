/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.ListaSimpleAvanzada;
import Lista.ListaSimple;

/**
 *
 * @author Cris2
 */
public class DetalleReparacion {
    private Long idDetalle; 
    private Long idOrden;
    private ListaSimple<Servicio> listaServivios= new ListaSimple();
    private ListaSimpleAvanzada listaProductos = new ListaSimpleAvanzada();

    public DetalleReparacion() {
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

    public ListaSimple<Servicio> getListaServivios() {
        return listaServivios;
    }

    public void setListaServivios(ListaSimple<Servicio> listaServivios) {
        this.listaServivios = listaServivios;
    }

    public ListaSimpleAvanzada getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ListaSimpleAvanzada listaProductos) {
        this.listaProductos = listaProductos;
    }

    @Override
    public String toString() {
        return idDetalle+" "+idOrden;
    }
    
}
