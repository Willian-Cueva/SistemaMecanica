/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Persona;

/**
 *
 * @author Willian
 */
public class AdministradorControlador {
    private ListaSimpleAvanzada personas = new ListaSimpleAvanzada();
    private ListaSimpleAvanzada vehiculos = new ListaSimpleAvanzada();

    public ListaSimpleAvanzada getVehiculos() {
        if(vehiculos==null)vehiculos = new ListaSimpleAvanzada();
        return vehiculos;
    }

    public void setVehiculos(ListaSimpleAvanzada vehiculos) {
        this.vehiculos = new ListaSimpleAvanzada();
        this.vehiculos = vehiculos;
    }
    
    public String obtenerIdPersona(){
        Persona m = (Persona) personas.obtenerObjetopp(personas.tamano()-1);
        return String.valueOf(m.getId());
    }

//    public ListaSimpleAvanzada busqueda(JRadioButton jb){
//                
//    }
    
    public ListaSimpleAvanzada getPersonas() {
        if(personas==null)personas=new ListaSimpleAvanzada();
        return personas;
    }

    public void setPersonas(ListaSimpleAvanzada personas) {
        this.personas = new ListaSimpleAvanzada();
        this.personas = personas;
    }
   
}