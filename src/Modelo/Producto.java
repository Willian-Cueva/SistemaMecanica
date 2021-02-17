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
     /**
      * Crear Producto
      */
    public Producto() {
    }

    /**
     * Crear Producto
     * @param id Long
     * @param nombre String 
     * @param cantidad int 
     * @param marca String
     * @param precio double
     * @param iva double
     * @param External_id String 
     */
    public Producto(Long id, String nombre, int cantidad, String marca, double precio, double iva, String External_id) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.marca = marca;
        this.precio = precio;
        this.iva = iva;
        this.External_id = External_id;
    }
    /**
     * Traer idProduto
     * @return  Long
     */
    public Long getId() {
        return id;
    }
    /**
     * Enviar un idProducto
     * @param id  Long
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Traer un NombreProducto
     * @return String
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Enviar un NombreProducto
     * @param nombre String
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Traer una CantidadProducto
     * @return  int
     */
    public int getCantidad() {
        return cantidad;
    }
    /**
     * Enviar una CantidadProducto
     * @param cantidad  int
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    /**
     * Traer un Marca Producto
     * @return String
     */
    public String getMarca() {
        return marca;
    }
    /**
     * Enviar una MarcaProducto
     * @param marca  String
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    /**
     * Traer el PrecioProducto
     * @return Double
     */
    public double getPrecio() {
        return precio;
    }
    /**
     * Enviar el Precio Producto
     * @param precio  Double
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    /**
     * Traer el Iva Producto
     * @return Dobule
     */
    public double getIva() {
        return iva;
    }
    /**
     * Enviar el Iva Producto
     * @param iva 
     */
    public void setIva(double iva) {
        this.iva = iva;
    }
    /**
     * Traer el External_id Producto
     * @return  String
     */
    public String getExternal_id() {
        return External_id;
    }
    /**
     * Enviar el External_id Producto
     * @param External_id  String
     */
    public void setExternal_id(String External_id) {
        this.External_id = External_id;
    }

    @Override
    public String toString() {
        return "\n id:  " + id+ "  Nombre: " + nombre + " Cantidad: "
                + cantidad + "  marca: " + marca + "  Precio: " + precio+ "  Iva:" +iva+" ExternalID: " + External_id ;
    }
}
