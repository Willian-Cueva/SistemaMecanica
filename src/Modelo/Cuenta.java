package Modelo;

import java.io.File;
import java.sql.Blob;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cris2
 */
public class Cuenta extends Rol {
    private String Usuario;
    private String contraseña;
    /**
     * 
     * @param cedula
     * @param nombre
     * @param correo
     * @param contraseña
     * @param telefono
     * @param tipoRol
     * @param imagenObtenida 
     */
    public Cuenta(String cedula, String nombre, String correo, String contraseña, String telefono, String tipoRol, Blob imagenObtenida) {
        super(cedula, nombre, correo, telefono, tipoRol, imagenObtenida);
        this.Usuario = correo;
        this.contraseña = contraseña;
    }
    /**
     * 
     * @param cedula
     * @param nombre
     * @param correo
     * @param contraseña
     * @param telefono
     * @param tipoRol
     * @param archivoImagen 
     */
    public Cuenta(String cedula, String nombre, String correo, String contraseña, String telefono, String tipoRol, File archivoImagen) {
        super(tipoRol, nombre, cedula, correo, telefono, archivoImagen);
        this.Usuario = correo;
        this.contraseña = contraseña;
    }
    /**
     * 
     * @return 
     */
    public String getUsuario() {
        return Usuario;
    }
    /**
     * 
     * @param Usuario 
     */
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }
    /**
     * 
     * @return 
     */
    public String getContraseña() {
        return contraseña;
    }
    /**
     * 
     * @param contraseña 
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    /**
     * 
     * @return 
     */
    public String getTipoRol() {
        return tipoRol;
    }
    /**
     * 
     * @param tipoRol 
     */
    public void setTipoRol(String tipoRol) {
        this.tipoRol = tipoRol;
    }
    /**
     * 
     * @return 
     */
    @Override
    public String getNombre() {
        return nombre;
    }
    /**
     * 
     * @param nombre 
     */
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * 
     * @return 
     */
    @Override
    public String getCedula() {
        return cedula;
    }
    /**
     * 
     * @param cedula 
     */
    @Override
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    /**
     * 
     * @return 
     */
    @Override
    public String getCorreo() {
        return correo;
    }
    /**
     * 
     * @param correo 
     */
    @Override
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    /**
     * 
     * @return 
     */
    @Override
    public String getTelefono() {
        return telefono;
    }
    /**
     * 
     * @param telefono 
     */
    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    /**
     * 
     * @return 
     */
    @Override
    public Blob getImagenObtenida() {
        return imagenObtenida;
    }
    /**
     * 
     * @param imagenObtenida 
     */
    @Override
    public void setImagenObtenida(Blob imagenObtenida) {
        this.imagenObtenida = imagenObtenida;
    }
    /**
     * 
     * @return 
     */
    @Override
    public File getArchivoImagen() {
        return archivoImagen;
    }
    /**
     * 
     * @param archivoImagen 
     */
    @Override
    public void setArchivoImagen(File archivoImagen) {
        this.archivoImagen = archivoImagen;
    }
    
    
    
}
