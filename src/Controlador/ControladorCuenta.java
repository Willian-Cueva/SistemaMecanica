/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.UtilesMecanico.UtilesMecanico;
import Lista.ListaSimple;
import Modelo.Cuenta;
import Modelo.Persona;
import Modelo.Rol;
import java.io.FileInputStream;
import java.sql.Statement;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cris2
 */
public class ControladorCuenta {
    
    UtilesMecanico uti = new UtilesMecanico();
    ListaSimple<Cuenta> liCuenta = new ListaSimple<>();
    ListaSimple<Persona> liPersona = new ListaSimple<>();
    ListaSimple<Rol> liRol = new ListaSimple<>();
    Persona persona;
    Rol rol;
    Cuenta cuenta;

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
    public Persona getPersona() {
        return persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public Rol getRol() {
        return rol;
    }
    
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    public ListaSimple<Cuenta> getLiCuenta() {
        return liCuenta;
    }
    
    public void setLiCuenta(ListaSimple<Cuenta> liCuenta) {
        this.liCuenta = liCuenta;
    }
    
    public ListaSimple<Persona> getLiPersona() {
        return liPersona;
    }
    
    public void setLiPersona(ListaSimple<Persona> liPersona) {
        this.liPersona = liPersona;
    }
    
    public ListaSimple<Rol> getLiRol() {
        return liRol;
    }
    
    public void setLiRol(ListaSimple<Rol> liRol) {
        this.liRol = liRol;
    }
    
    public void RecuperarData() {
        int CantCuentas = 0;
        int CantPersonas = 0;
        int CantRoles = 0;
        
        try {
            Statement stmt = (Statement) uti.IniciarConexion().createStatement();
            //Cargar la lista de cuentas
            ResultSet rsCuentas = stmt.executeQuery("SELECT * FROM cuentas");
            if (rsCuentas.next()) {
                do {
                    //ListaCuenta
                    liCuenta.insertar(new Cuenta(rsCuentas.getLong(1), rsCuentas.getString(2), rsCuentas.getString(3),rsCuentas.getBoolean(4), rsCuentas.getString(5), rsCuentas.getLong(6)));
                    CantCuentas++;
                } while (rsCuentas.next());
            }
            //Cargar la lista de personas
            ResultSet rsPersonas = stmt.executeQuery("SELECT * FROM personas");
            if (rsPersonas.next()) {
                do {
                    //ListaPersona
                    liPersona.insertar(new Persona(rsPersonas.getLong(1), rsPersonas.getString(2), rsPersonas.getString(3), rsPersonas.getString(4), rsPersonas.getString(5), rsPersonas.getString(6), rsPersonas.getString(7),rsPersonas.getBoolean(8), rsPersonas.getString(9),rsPersonas.getLong(10), rsPersonas.getBlob(11)));
                    CantPersonas++;
                } while (rsPersonas.next());
            }
            //Cargar la lista de roles
            ResultSet rsRol = stmt.executeQuery("SELECT * FROM rol");
            if (rsRol.next()) {
                do {
                    //ListaRol
                    liRol.insertar(new Rol(rsRol.getLong(1), rsRol.getString(2)));
                    CantRoles++;
                } while (rsRol.next());
            }
            
        } catch (SQLException ex) {
            
            System.out.println("Error de conexion: " + ex.getMessage());
        } catch (NullPointerException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        
    }

    public boolean isExisteCuenta() {
        if (cuenta!=null) {
            return true;
        }
        return false;
    }
    
    public void buscarCuenta(ListaSimple<Cuenta> lic, ListaSimple<Persona> lip, ListaSimple<Rol> lir, String Usuario, String Contraseña) {     
        
        for (int i = 0; i < lic.tamano(); i++) {
            if (lic.obtenerPorPosicion(i).getUsuario().equals(Usuario) && lic.obtenerPorPosicion(i).getContraseña().equals(Contraseña)) {
                System.out.println("Existe Cuenta"+lic.obtenerPorPosicion(i).getUsuario());
                cuenta = lic.obtenerPorPosicion(i);
            }else{
            }
        }
        if (cuenta != null) {
            System.out.println("Entrofallo");
            for (int i = 0; i < lip.tamano(); i++) {
                if (lip.obtenerPorPosicion(i).getId().equals(cuenta.getIdPersona())) {
                    System.out.println("Persona correspondiente");
                    persona = lip.obtenerPorPosicion(i);
                } else {
                }
            }
        }
        if (persona != null) {
            for (int i = 0; i < lir.tamano(); i++) {
                if (lir.obtenerPorPosicion(i).getId().equals(persona.getIdRol())) {
                    rol = lir.obtenerPorPosicion(i);
                }
            }
            
        }
    }
    
}
