/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Nodo;

/**
 *
 * @author Willian
 */
public class ListaSimpleAvanzada extends ListaSimple{

    public ListaSimpleAvanzada() {
        super();
    }
    
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
    public Object obtenerObjetopp(int posicion){
        if (estaVacia()) {
            throw new NullPointerException("la lista esta vacia");
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
    
    public Boolean vaciar(){
        Boolean bandera=false;
        cabecera=null;
        if (cabecera.getSig()==null) {
            bandera=true;
        } 
        return bandera;
    }
    
}
