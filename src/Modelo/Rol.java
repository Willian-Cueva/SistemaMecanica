/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.sql.Blob;

/**
 *
 * @author Cris2
 */
public class Rol extends Persona {
    String tipoRol;
    /**
     * 
     * @param cedula
     * @param nombre
     * @param correo
     * @param telefono
     * @param tipoRol
     * @param imagenObtenida 
     */
    public Rol(  String cedula,String nombre, String correo, String telefono,String tipoRol, Blob imagenObtenida) {
        super(nombre, cedula, correo, telefono, imagenObtenida);
        this.tipoRol = tipoRol;
    }
    /**
     * 
     * @param tipoRol
     * @param nombre
     * @param cedula
     * @param correo
     * @param telefono
     * @param archivoImagen 
     */
    public Rol(String tipoRol, String nombre, String cedula, String correo, String telefono, File archivoImagen) {
        super(nombre, cedula, correo, telefono, archivoImagen);
        this.tipoRol = tipoRol;
    }
    
    
    
}
