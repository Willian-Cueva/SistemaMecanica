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
public class Marca {
   Long id;
   String Nombre;
   /**
    * Crear una Marca
    * @param id Long
    * @param Nombre  String
    */
    public Marca(Long id, String Nombre) {
        this.id = id;
        this.Nombre = Nombre;
    }
    /**
     * Traer Id Marca
     * @return Long
     */
    public Long getId() {
        return id;
    }
    /**
     * ENviar Id Marcar
     * @param id  Long
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Traer Nombre Marca
     * @return String
     */
    public String getNombre() {
        return Nombre;
    }
    /**
     * Envia un Nombre Marca
     * @param Nombre String
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
   
}
