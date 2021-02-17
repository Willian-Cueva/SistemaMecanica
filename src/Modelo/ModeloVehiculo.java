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
public class ModeloVehiculo {
    Long id;
    String NombreModelo;
    Long idMarca;
    /**
     * Crear un ModeloVehiculo
     * @param idModeloVehiculo Long
     * @param NombreModelo String
     * @param idMarca  Long
     */
    public ModeloVehiculo(Long idModeloVehiculo, String NombreModelo, Long idMarca) {
        this.id = idModeloVehiculo;
        this.NombreModelo = NombreModelo;
        this.idMarca = idMarca;
    }
    /**
     * Traer IdModeloVehiculo
     * @return Long
     */
    public Long getIdModeloVehiculo() {
        return id;
    }
    /**
     * Enviar un IdMoedloVehiculo 
     * @param idModeloVehiculo  Long
     */
    public void setIdModeloVehiculo(Long idModeloVehiculo) {
        this.id = idModeloVehiculo;
    }
    /**
     * Traer NombreModelo 
     * @return String
     */
    public String getNombreModelo() {
        return NombreModelo;
    }
    /**
     * Enviar el NOmbreModelo 
     * @param NombreModelo String
     */
    public void setNombreModelo(String NombreModelo) {
        this.NombreModelo = NombreModelo;
    }
    /**
     * Traer el idMarcar Vehiculo
     * @return Long
     */
    public Long getIdMarca() {
        return idMarca;
    }
    /**
     * Enviar el IdMarca Vehiculo
     * @param idMarca Long
     */
    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }
    
}
