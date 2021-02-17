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
    /**
     * Crear un DettalleReparacion
     */
    public DetalleReparacion() {
    }
    /**
     * Trae IdDetalle DetalleReparacion
     * @return Long
     */
    public Long getIdDetalle() {
        return idDetalle;
    }
    /**
     * Enviar IdDetalle DetalleReparacion
     * @param idDetalle  Long
     */
    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }
    /**
     * Trae IdOrden 
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
    /**
     * Traer Lista de servicios
     * @return  ListaSimple de Servicio
     */
    public ListaSimple<Servicio> getListaServivios() {
        return listaServivios;
    }
    /**
    *Enviar listaServivios  
    * @param listaServivios  ListaSimple de Servicio
    */
    public void setListaServivios(ListaSimple<Servicio> listaServivios) {
        this.listaServivios = listaServivios;
    }
    /**
     * Traer Lista Productos
     * @return ListaSimpleAvanzada
     */
    public ListaSimpleAvanzada getListaProductos() {
        return listaProductos;
    }
    /**
     * Enviar Lista de productos
     * @param listaProductos ListaSimpleAvanzada
     */
    public void setListaProductos(ListaSimpleAvanzada listaProductos) {
        this.listaProductos = new ListaSimpleAvanzada();
        this.listaProductos = listaProductos;
    }

    @Override
    public String toString() {
        return idDetalle+" "+idOrden;
    }
    
}
