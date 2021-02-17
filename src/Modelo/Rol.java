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
public class Rol{
    Long id;
    String nombreRol;
    /**
     * Crear un Rol
     */
    public Rol() {
    }
    /**
     * Crea un Rol
     * @param id Long
     * @param nombreRol String 
     */
    public Rol(Long id, String nombreRol) {
        this.id = id;
        this.nombreRol = nombreRol;
    }
    /**
     * Trae un IdRol
     * @return  Long
     */
    public Long getId() {
        return id;
    }
    /**
     * Enviar un IdRol
     * @param id Long
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Trae un NombreRol
     * @return String
     */
    public String getNombreRol() {
        return nombreRol;
    }
    /**
     * Enviar un NombreRol
     * @param nombreRol String
     */
    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }   

    @Override
    public String toString() {
        return nombreRol;
    }
    
    
}
