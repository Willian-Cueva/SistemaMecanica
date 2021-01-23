/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Willian
 */
public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private String cedula;
    private String correo;
    private String telefono;
    private String direccion;
    private Boolean estado;
    private String external_id_persona;
    private int idRol;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Persona() {
    }

    public Persona(int id, String nombre, String cedula, String correo, String telefono, String external_id_persona,int idRol) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.telefono = telefono;
        this.external_id_persona=external_id_persona;
        this.idRol=idRol;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getExternal_id_persona() {
        return external_id_persona;
    }

    public void setExternal_id_persona(String external_id_persona) {
        this.external_id_persona = external_id_persona;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return id+" "+nombre;
    }
    
}
