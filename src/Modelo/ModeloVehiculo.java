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

    public ModeloVehiculo(Long idModeloVehiculo, String NombreModelo, Long idMarca) {
        this.id = idModeloVehiculo;
        this.NombreModelo = NombreModelo;
        this.idMarca = idMarca;
    }

    public Long getIdModeloVehiculo() {
        return id;
    }

    public void setIdModeloVehiculo(Long idModeloVehiculo) {
        this.id = idModeloVehiculo;
    }

    public String getNombreModelo() {
        return NombreModelo;
    }

    public void setNombreModelo(String NombreModelo) {
        this.NombreModelo = NombreModelo;
    }

    public Long getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }
    
}
