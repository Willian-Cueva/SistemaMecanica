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
public class Vehiculo {
    Long id;
    String placa;
    Long idModeloVehiculo;
    String Color;
    String observacion;
    Boolean Estado;
    String ExternalidVehiculo;
    Blob imagen;
    File archivo;
    Long idPersona;
    
    /**
     * Crea un Vehiculo
     */
    public Vehiculo() {
    }
    /**
     * Crea un Vehiculo
     * @param id long
     * @param placa String
     * @param idModeloVehiculo Long
     * @param Color String 
     * @param observacion String 
     * @param Estado Boolean
     * @param ExternalidVehiculo Stirng
     * @param archivo File 
     * @param idPersona Long
     */
    public Vehiculo(Long id, String placa, Long idModeloVehiculo, String Color, String observacion, Boolean Estado, String ExternalidVehiculo, File archivo, Long idPersona) {
        this.id = id;
        this.placa = placa;
        this.idModeloVehiculo = idModeloVehiculo;
        this.Color = Color;
        this.observacion = observacion;
        this.Estado = Estado;
        this.ExternalidVehiculo = ExternalidVehiculo;
        this.archivo = archivo;
        this.idPersona = idPersona;
    }
    /**
     * Crear un Vehiculo
     * @param id Long
     * @param placa String
     * @param idModeloVehiculo Long
     * @param Color String
     * @param observacion String
     * @param Estado Boolean
     * @param ExternalidVehiculo String
     * @param imagen Blob
     * @param idPersona  Long
     */
    public Vehiculo(Long id, String placa, Long idModeloVehiculo, String Color, String observacion, Boolean Estado, String ExternalidVehiculo, Blob imagen, Long idPersona) {
        this.id = id;
        this.placa = placa;
        this.idModeloVehiculo = idModeloVehiculo;
        this.Color = Color;
        this.observacion = observacion;
        this.Estado = Estado;
        this.ExternalidVehiculo = ExternalidVehiculo;
        this.imagen = imagen;
        this.idPersona = idPersona;
    }
    /**
     * Trae idVehiculo
     * @return Long
     */
    public Long getId() {
        return id;
    }
    /**
     * Enviamos el idVehiculo
     * @param id  long
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Trar la placa Vehiculo
     * @return  String
     */
    public String getPlaca() {
        return placa;
    }
    /**
     * Enviamos la Placa Vehiculo
     * @param placa String
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    /**
     * Trer el IdModeloVehiculo.
     * @return  Long
     */
    public Long getIdModeloVehiculo() {
        return idModeloVehiculo;
    }
    /**
     * Enviamos el idModeloVechiculo
     * @param idModeloVehiculo Long
     */
    public void setIdModeloVehiculo(Long idModeloVehiculo) {
        this.idModeloVehiculo = idModeloVehiculo;
    }
    /**
     * Traer color Vehiculo
     * @return  String
     */
    public String getColor() {
        return Color;
    }

    /**
     * Enviamor un color Vehiculo
     * @param Color  String
     */
    public void setColor(String Color) {
        this.Color = Color;
    }
    /**
     * Traer Observacion Vehiculo
     * @return  String
     */
    public String getObservacion() {
        return observacion;
    }
    /**
     * Enviamos obsercacion Vehiculo
     * @param observacion  String
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    /**
     * Taer estado Vehiculo
     * @return  boolean
     */
    public Boolean getEstado() {
        return Estado;
    }
    /**
     * Enviar un estado Vehiculo
     * @param Estado  boolean
     */
    public void setEstado(Boolean Estado) {
        this.Estado = Estado;
    }
    /**
     * Traer un ExternalidVehiculo 
     * @return ExternalidVehiculo
     */
    public String getExternalidVehiculo() {
        return ExternalidVehiculo;
    }
    /**
     * Enviar un ExternalidVehiculo
     * @param ExternalidVehiculo  ExternalidVehiculo
     */
    public void setExternalidVehiculo(String ExternalidVehiculo) {
        this.ExternalidVehiculo = ExternalidVehiculo;
    }
    /**
     * Traer un Imagen Vehiculo
     * @return Blob
     */
    public Blob getImagen() {
        return imagen;
    }
    /**
     * Enviar un Imgen Vehiculo
     * @param imagen  Blob
     */
    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }
    /**
     * Traer un File Vehiculo
     * @return  File
     */
    public File getArchivo() {
        return archivo;
    }
    /**
     * Enviamos un File Vehiculo
     * @param archivo File
     */
    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    /**
     * Trer un IdPersona
     * @return Long
     */
    public Long getIdPersona() {
        return idPersona;
    }
    /**
     * Enviamos un IdPersona
     * @param idPersona  Long
     */
    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public String toString() {
        return id+ "  "+placa;
    }
    
    
}
