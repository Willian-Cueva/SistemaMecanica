/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Factura;

/**
 *
 * @author Willian
 */
public class ControladorFacturas {
    private ListaSimpleAvanzada facturas=new ListaSimpleAvanzada();
    private Factura factura;
    private ControladorOrdeDeReparacion cntrl = new ControladorOrdeDeReparacion();

    
    
    
    
    public ListaSimpleAvanzada getFacturas() {
        return facturas;
    }

    public void setFacturas(ListaSimpleAvanzada facturas) {
        this.facturas = facturas;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public ControladorOrdeDeReparacion getCntrl() {
        return cntrl;
    }

    public void setCntrl(ControladorOrdeDeReparacion cntrl) {
        this.cntrl = cntrl;
    }
    
}
