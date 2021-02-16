/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 * Lista Simple Avanzada hereda de la ListaSimple
 * @author Willian
 */
public class ListaSimpleAvanzada extends ListaSimple{

    public ListaSimpleAvanzada() {
        super();
    }
    /**
     * Permite eliminar el ultimo nodo de la lista
     */
    public void eliminarUltimo(){
        if (estaVacia()) {
            System.out.println("La lista esta vacia - eliminarUltimo()");
        } else if(tamano()==1){
            cabecera= null;
        }else{
            Nodo it = cabecera;
            for (int i = 2; i < tamano(); i++) {
                it=it.getSig();
            }
            it.setSig(null);
        }
    }
    /**
     * Devuelve un Nodo del dato que se encuentre en dicha posicion
     * @param posicion entero de la posicion de la lista
     * @return Nodo
     */
    public Nodo obtenerNodopp(int posicion){
        if (estaVacia()) {
            throw new NullPointerException("la lista esta vacia");
        } else if(posicion<0 || posicion>tamano()){
            throw new NullPointerException("la posicion ingresada esta fuera del rango");
        }else{
            Nodo it = cabecera;
            for (int i = 0; i < posicion; i++) {
                it=it.getSig();
            }
            return it;
        }
    }
    /**
     * Devuelve un objeto del dato que se encuentre en dicha posicion
     * @param posicion entero de la posicion de la lista
     * @return objeto
     */
    public Object obtenerObjetopp(int posicion){
        if (estaVacia()) {
            return null;
        } else if(posicion<0 || posicion>tamano()){
            throw new NullPointerException("la posicion ingresada esta fuera del rango");
        }else if(posicion==0){
            return cabecera.getDato();
        }else{
            Nodo it = cabecera;
            for (int i = 0; i < posicion; i++) {
                it=it.getSig();
            }
            return it.getDato();
        }
    }
    /**
     * Permite eliminar un elemento de la lista dependiendo la posicion
     * @param posicion entero con la posicion de la lista
     * @return true si se elimino exitosamente, false si no elimino nada o hubo errores
     */
    public Boolean emilinarDpp(int posicion){
        if (estaVacia()) {
            System.out.println("La lista esta vacia");
            return false;
        }else if (posicion<0 || posicion>tamano()) {
            System.out.println("La posicion esta fuera del rango - edpp");
            return false;
        } else if(posicion==0){
            cabecera=cabecera.getSig();
            return true;
        }else{
            Nodo it = cabecera;
            for (int i = 1; i < posicion; i++) {
                it =it.getSig();
            }
            Nodo aux = it.getSig().getSig();
            it.setSig(aux);
            return true;
        }
    }
    /**
     * Este metodo permite insertar un elemento en la lista por posicion
     * @param posicion posicion en la que se quiere insertar el nuevo objeto
     * @param dato Objeto a insertar en la lista
     */
    public void insertarDppE(int posicion, Object dato) {
        if (estaVacia()) {
            System.out.println("La lista esta vacia //idppE");
        } else if(posicion==0){
            Nodo aux = new Nodo(dato, cabecera);
            cabecera=aux;
        }else{
            Nodo it = cabecera;
            for (int i = 1; i < posicion; i++) {
                it = it.getSig();
            }
            Nodo n = new Nodo(dato, it.getSig());
            it.setSig(n);
        }
    }
    /**
     * Retorna un true si existe el objeto especificado, false si no lo encontro
     * @param object objeto a comprobar su existencia
     * @return un valor booleano False o True
     */
    public Boolean existe(Object object){
        Boolean chis = false;
        for (int i = 0; i < tamano(); i++) {
            if (object.equals(obtenerObjetopp(i))) {
                chis=true;
                break;
            }
        }
        return chis;
    }
    
    /**
     * permite eliminar todos los elementos de la lista
     * @return true si elimino el nodo y caso contraro retorna false 
     */
    public Boolean vaciar(){
        Boolean bandera=false;
        cabecera=null;
        if (cabecera.getSig()==null) {
            bandera=true;
        } 
        return bandera;
    }
    
}
