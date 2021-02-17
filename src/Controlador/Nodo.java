/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author Willian
 */
public class Nodo {
    private Object dato;
    private Nodo sig;
    /**
     * Constructor de Nodo con valores de entrada
     * @param dato Object
     * @param sig Nodo
     */
    public Nodo(Object dato, Nodo sig) {
        this.dato = dato;
        this.sig = sig;
    }
    /**
     * retorna un Object
     * @return Object
     */
    public Object getDato() {
        return dato;
    }
    /**
     * recibe un Object
     * @param dato Object 
     */
    public void setDato(Object dato) {
        this.dato = dato;
    }
    /**
     * retorna un Nodo 
     * @return Nodo
     */
    public Nodo getSig() {
        return sig;
    }
    /**
     * resive un Nodo siguiente
     * @param sig Nodo
     */
    public void setSig(Nodo sig) {
        this.sig = sig;
    }
    
}
