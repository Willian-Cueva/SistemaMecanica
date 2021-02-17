/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;



/**
 *
 * @author joe
 */
public class Nodo<T> {
    private T dato;
    private Nodo sig;
    /**
     * contructor de Nodo
     */
    public Nodo() {
        dato = null;
        sig = null;
    }
    /**
     * Constructor del Nodo con parametros
     * @param dato T
     * @param sig Nodo
     */
    public Nodo(T dato, Nodo sig) {
        this.dato = dato;
        this.sig = sig;
    }
    /**
     * devuelve un objeto
     * @return T
     */
    public T getDato() {
        return dato;
    }
    /**
     * recibe un T
     * @param dato T 
     */
    public void setDato(T dato) {
        this.dato = dato;
    }
    /**
     * Nodo 
     * @return Nodo
     */
    public Nodo getSig() {
        return sig;
    }
    /**
     * recibe un nodo
     * @param sig Nodo
     */
    public void setSig(Nodo sig) {
        this.sig = sig;
    }
    
}
