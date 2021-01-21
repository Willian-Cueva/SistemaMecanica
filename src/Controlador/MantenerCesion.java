/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cuenta;
import Modelo.Persona;
import Modelo.Rol;

/**
 *
 * @author Cris2
 */
public class MantenerCesion {
    public static Cuenta cuenta;
    public static Persona persona;
    public static Rol rol;

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        MantenerCesion.cuenta = cuenta;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        MantenerCesion.persona = persona;
    }

    public  Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        MantenerCesion.rol = rol;
    }
    
    public void mantenerdatos(Cuenta cuenta,Persona persona,Rol rol){
        this.cuenta=cuenta;
        this.persona=persona;
        this.rol=rol;
    }
}
