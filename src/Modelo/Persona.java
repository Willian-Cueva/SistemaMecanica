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
    private Long id;
    private String nombre;
    private String apellido;
    private String cedula;
    private String correo;
    private String telefono;
    private String direccion;
    private Boolean Estado;
    private String External_id;
    private Long idRol;
    private Blob imagenObtenida;
    private File archivoImagen;

    public Persona(Long id, String nombre, String apellido, String cedula, String correo, String telefono, String direccion,Boolean Estado , String External_id, Long idRol, Blob imagenObtenida) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.Estado=Estado;
        this.External_id = External_id;
        this.idRol = idRol;
        this.imagenObtenida = imagenObtenida;
    }

    public Persona(Long id, String nombre, String apellido, String cedula, String correo, String telefono, String direccion,Boolean Estado, String External_id, Long idRol, File archivoImagen) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.Estado= Estado;
        this.External_id = External_id;
        this.idRol = idRol;
        this.archivoImagen = archivoImagen;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean Estado) {
        this.Estado = Estado;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getExternal_id() {
        return External_id;
    }

    public void setExternal_id(String External_id) {
        this.External_id = External_id;
    }

    public Blob getImagenObtenida() {
        return imagenObtenida;
    }

    public void setImagenObtenida(Blob imagenObtenida) {
        this.imagenObtenida = imagenObtenida;
    }

    public File getArchivoImagen() {
        return archivoImagen;
    }

    public void setArchivoImagen(File archivoImagen) {
        this.archivoImagen = archivoImagen;
    }  
}
