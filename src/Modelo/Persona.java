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
import java.io.File;
import java.sql.Blob;

public class Persona{
    String nombre;
    String cedula;
    String correo;
    String telefono;
    Blob imagenObtenida;
    File archivoImagen;
    /**
     * 
     * @param nombre
     * @param cedula
     * @param correo
     * @param telefono
     * @param imagenObtenida 
     */
    public Persona(String cedula, String nombre, String correo, String telefono, Blob imagenObtenida) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.telefono = telefono;
        this.imagenObtenida = imagenObtenida;
    }
    /**
     * 
     * @param nombre
     * @param cedula
     * @param correo
     * @param telefono
     * @param archivoImagen 
     */
    public Persona(String cedula, String nombre, String correo, String telefono, File archivoImagen) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.telefono = telefono;
        this.archivoImagen = archivoImagen;
    }
    /**
     * 
     * @return 
     */
    public Blob getImagenObtenida() {
        return imagenObtenida;
    }
    /**
     * 
     * @param imagenObtenida 
     */
    public void setImagenObtenida(Blob imagenObtenida) {
        this.imagenObtenida = imagenObtenida;
    }
    /**
     * 
     * @return 
     */
    public File getArchivoImagen() {
        return archivoImagen;
    }
    /**
     * 
     * @param archivoImagen 
     */
    public void setArchivoImagen(File archivoImagen) {
        this.archivoImagen = archivoImagen;
    }
    /**
     * 
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * 
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * 
     * @return 
     */
    public String getCedula() {
        return cedula;
    }
    /**
     * 
     * @param cedula 
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    /**
     * 
     * @return 
     */
    public String getCorreo() {
        return correo;
    }
    /**
     * 
     * @param correo 
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    /**
     * 
     * @return 
     */
    public String getTelefono() {
        return telefono;
    }
    /**
     * 
     * @param telefono 
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

   
    
}
