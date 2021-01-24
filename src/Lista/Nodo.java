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
    
    public Nodo() {
        dato = null;
        sig = null;
    }

    public Nodo(T dato, Nodo sig) {
        this.dato = dato;
        this.sig = sig;
    }
    
    
    
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }
    
}
