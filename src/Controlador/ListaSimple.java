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
public class ListaSimple {
    public Nodo cabecera;
    
    public Boolean estaVacia(){
        return cabecera==null;
    }
    
    public int tamano(){
        if (estaVacia()) {
            return 0;
        }else{
            Nodo it = cabecera;
            int cont=1;
            while (it.getSig()!=null) {                
                cont++;
                it = it.getSig();
            }
            return cont;
        }
    }
    
    public void insertarPila(Object object){
        if (estaVacia()) {
            Nodo aux = new Nodo(object, null);
            cabecera=aux;
        } else {
            Nodo aux = new Nodo(object, cabecera);
            cabecera=aux;
        }
    }
    
    public void insertar(Object objeto){
        if (estaVacia()) {
            Nodo aux = new Nodo(objeto, null);
            cabecera=aux;
        }else{
            Nodo it = cabecera;
            for (int i = 1; i < tamano(); i++) {
                it=it.getSig();
            }
            Nodo aux = new Nodo(objeto, null);
            it.setSig(aux);
        }
    }
    
    public void present(){
        if (estaVacia()) {
            System.out.println("La lista esta vacia - press");
        } else {
            Nodo it = cabecera;
            for (int i = 0; i < tamano(); i++) {
                System.out.println(it.getDato().toString());
                it=it.getSig();
            }
        }
    }
}
