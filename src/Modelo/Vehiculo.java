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

    public Vehiculo() {
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Long getIdModeloVehiculo() {
        return idModeloVehiculo;
    }

    public void setIdModeloVehiculo(Long idModeloVehiculo) {
        this.idModeloVehiculo = idModeloVehiculo;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean Estado) {
        this.Estado = Estado;
    }

    public String getExternalidVehiculo() {
        return ExternalidVehiculo;
    }

    public void setExternalidVehiculo(String ExternalidVehiculo) {
        this.ExternalidVehiculo = ExternalidVehiculo;
    }

    public Blob getImagen() {
        return imagen;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public String toString() {
        return id+ "  "+placa;
    }
    
    
}
