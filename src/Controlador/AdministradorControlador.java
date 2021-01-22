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
    
    public String obtenerIdPersona(){
        Persona m = (Persona) personas.obtenerObjetopp(personas.tamano()-1);
        return String.valueOf(m.getId());
    }

    
    
    public ListaSimpleAvanzada getPersonas() {
        if(personas==null)personas=new ListaSimpleAvanzada();
        return personas;
    }

    public void setPersonas(ListaSimpleAvanzada personas) {
        this.personas = new ListaSimpleAvanzada();
        this.personas = personas;
    }

    
}
