/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;
import Controlador.Utiles.Producto.Utiles;
/**
 *
 * @author LENOVO LEGION
 */
public class AlmacenControlador {
    
    private ListaSimpleAvanzada producto = new ListaSimpleAvanzada();
    private Utiles u = new Utiles();

    public ListaSimpleAvanzada getProducto() {
        if(producto == null){
            producto = new ListaSimpleAvanzada();
        }
        return producto;
    }

    public void setProducto(ListaSimpleAvanzada producto) {
        this.producto = new ListaSimpleAvanzada();
        this.producto = producto;
    }
    
    public ListaSimpleAvanzada obtenerLista(){
        return u.listaProductos();
    }
    
}
