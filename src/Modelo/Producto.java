/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Cris2
 */
public class Producto {
    Long idProducto;
    String Nombre;
    int cantidad;
    int marca;
    double precio;
    int iva;
    String ExternalIdProducto;

    public Producto(Long idProducto, String Nombre, int cantidad, int marca, double precio, int iva, String ExternalIdProducto) {
        this.idProducto = idProducto;
        this.Nombre = Nombre;
        this.cantidad = cantidad;
        this.marca = marca;
        this.precio = precio;
        this.iva = iva;
        this.ExternalIdProducto = ExternalIdProducto;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public String getExternalIdProducto() {
        return ExternalIdProducto;
    }

    public void setExternalIdProducto(String ExternalIdProducto) {
        this.ExternalIdProducto = ExternalIdProducto;
    }
    
}
