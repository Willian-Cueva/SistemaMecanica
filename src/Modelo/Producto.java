/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author LENOVO LEGION
 */
public class Producto {
    private Long id;
    private String nombre;
    private int cantidad;
    private String marca;
    private double precio;
    private double iva;
    private String External_id;

    public Producto() {
    }

   
    public Producto(Long id, String nombre, int cantidad, String marca, double precio, double iva, String External_id) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.marca = marca;
        this.precio = precio;
        this.iva = iva;
        this.External_id = External_id;
    }
    
    
 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public String getExternal_id() {
        return External_id;
    }

    public void setExternal_id(String External_id) {
        this.External_id = External_id;
    }
    
    
    
    
}
