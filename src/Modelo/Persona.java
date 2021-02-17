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
/**
 * Clase Persona
 * @author Willian
 */
public class Persona{
    private Long id;
    private String nombre;
    private String apellido;
    private String cedula;
    private String correo;
    private String telefono;
    private String direccion;
    private Boolean estado;
    private String external_id;
    private Long idRol;
    private Blob imagenObtenida;
    private File archivoImagen;
    
    /**
     * Crear una Persona
     */
    public Persona() {
    }
    /**
    * Crea una Persona
    * @param id 
    */
    public Persona(Long id) {
        this.id = id;
    }
    
    /**
     * Crear una Persona
     * @param id Long
     * @param nombre String
     * @param apellido String 
     * @param cedula String
     * @param correo String
     * @param telefono String
     * @param direccion String 
     * @param estado Boolean
     * @param external_id String
     * @param idRol Long
     * @param imagenObtenida Blob 
     */
    public Persona(Long id, String nombre, String apellido, String cedula, String correo, String telefono, String direccion,Boolean estado , String external_id, Long idRol, Blob imagenObtenida) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado=estado;
        this.external_id = external_id;
        this.idRol = idRol;
        this.imagenObtenida = imagenObtenida;
    }
    /**
     * Crear una Persona
     * @param id Long
     * @param nombre String 
     * @param apellido Stirng 
     * @param cedula String 
     * @param correo String
     * @param telefono String
     * @param direccion String
     * @param estado Boolean
     * @param external_id String
     * @param idRol Long
     * @param archivoImagen File 
     */
    public Persona(Long id, String nombre, String apellido, String cedula, String correo, String telefono, String direccion,Boolean estado, String external_id, Long idRol, File archivoImagen) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado= estado;
        this.external_id = external_id;
        this.idRol = idRol;
        this.archivoImagen = archivoImagen;
    }
    /**
     * Trae un IdRol Persona
     * @return 
     */
    public Long getIdRol() {
        return idRol;
    }
    /**
     * Envia un IdRol Persona
     * @param idRol Long
     */
    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }
    /**
     * Traer el EstadoPersona
     * @return Boolean
     */
    public Boolean getEstado() {
        return estado;
    }
    /**
     * Enviar el EstadoPersona
     * @param estado 
     */
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    /**
     * Traer el IdPersona
     * @return Long
     */
    public Long getId() {
        return id;
    }
    /**
     * Enviar un IdPersona
     * @param id Long
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Traer NombrePersona
     * @return String
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Enviar NombrePersona
     * @param nombre String
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Traer Apellido Persona
     * @return String
     */
    public String getApellido() {
        return apellido;
    }
    
    /**
     * Enviar ApellidoPersona
     * @param apellido String
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    /**
     * Enviar Cedula Persona
     * @return String
     */
    public String getCedula() {
        return cedula;
    }
    /**
     * Enviar CedulaPersona
     * @param cedula Stirng
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    /**
     * Traer CorreoPersona
     * @return String
     */
    public String getCorreo() {
        return correo;
    }
    /**
     * Enviar CorreoPersona
     * @param correo String
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    /**
     * Traer TelefonoPersona
     * @return String
     */
    public String getTelefono() {
        return telefono;
    }
    /**
     * Enviar TelefonoPersona
     * @param telefono String
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    /**
     * Traer DireccionPersona
     * @return String
     */
    public String getDireccion() {
        return direccion;
    }
    /**
     * Enviar DireccionPersona
     * @param direccion String
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
     * Traer External_Id Persona
     * @return String
     */
    public String getExternal_id() {
        return external_id;
    }
    /**
     * Enviar External_Id Persona
     * @param external_id String
     */
    public void setExternal_id(String external_id) {
        this.external_id = external_id;
    }
    /**
     * Traer ImagenObtenida Persona
     * @return Blob
     */
    public Blob getImagenObtenida() {
        return imagenObtenida;
    }
    /**
     * Enviar ImagenObtenida Persona
     * @param imagenObtenida  Blob
     */
    public void setImagenObtenida(Blob imagenObtenida) {
        this.imagenObtenida = imagenObtenida;
    }
    /**
     * Traer ArchivoImagen
     * @return File
     */
    public File getArchivoImagen() {
        return archivoImagen;
    }
    /**
     * Enviar ArchivoImagen Persona
     * @param archivoImagen File
     */
    public void setArchivoImagen(File archivoImagen) {
        this.archivoImagen = archivoImagen;
    } 

    @Override
    public String toString() {
        return "id:"+id+" "+nombre+ " "+ apellido+" "+idRol;
    }
    
    
}
