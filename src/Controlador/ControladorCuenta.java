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
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Cris2
 */
public class ControladorCuenta {
    
    UtilesMecanico uti = new UtilesMecanico();
    ListaSimple<Cuenta> liCuenta;
    ListaSimple<Persona> liPersona;
    ListaSimple<Rol> liRol;
    Persona persona;
    Rol rol;
    Cuenta cuenta;
    /**
     * Retorna un Objeto Cuenta de esta clase
     * @return Cuenta
     */
    public Cuenta getCuenta() {
        return cuenta;
    }
    /**
     * Recive una Cuenta para el atributo cuenta de esta clase
     * @param cuenta Cuenta
     */
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    /**
     * Retorna el obbjeto Persona de esta clase
     * @return Persona
     */
    public Persona getPersona() {
        return persona;
    }
    /**
     * recibe una Perosna
     * @param persona Persona
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    /**
     * Retorna un rol
     * @return Rol
     */
    public Rol getRol() {
        return rol;
    }
    /**
     * Settea un Rol
     * @param rol Rol
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    /**
     * Retorna una ListaSimple de tipo contas de esta clase
     * @return ListaSimple de tipo Cuenta
     */
    public ListaSimple<Cuenta> getLiCuenta() {
        return liCuenta;
    }
    /**
     * settea una ListaSimple de tipo cuenta
     * @param liCuenta ListaSimple de tipo cuenta
     */
    public void setLiCuenta(ListaSimple<Cuenta> liCuenta) {
        this.liCuenta = liCuenta;
    }
    /**
     * Retorna una ListaSimple de tipo Persona
     * @return ListaSimple de tipo Persona
     */
    public ListaSimple<Persona> getLiPersona() {
        return liPersona;
    }
    /**
     * Recibe una ListaSimple de tipo Persona
     * @param liPersona ListaSimple de tipo Persona
     */
    public void setLiPersona(ListaSimple<Persona> liPersona) {
        this.liPersona = liPersona;
    }
    /**
     * Retorna una ListaSimple de tipo Rol
     * @return ListaSimple de tipo Rol
     */
    public ListaSimple<Rol> getLiRol() {
        return liRol;
    }
    /**
     * Recibe una ListaSimple de tipo Rol
     * @param liRol ListaSimple de tipo Rol
     */
    public void setLiRol(ListaSimple<Rol> liRol) {
        this.liRol = liRol;
    }
    /**
     * Metodo encargado de caragar las listas de persona cuenta y rol obtenidas de la base de datos dependiendo del rol de esa persona
     */
    public void RecuperarData() {
        liPersona=new ListaSimple<>();
        liCuenta=new ListaSimple<>();
        liRol=new ListaSimple<>();
        int CantCuentas = 0;
        int CantPersonas = 0;
        int CantRoles = 0;
        
        try {
            Statement stmt = (Statement) uti.getConexion().createStatement();
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
    /**
     * Metodo que permite conocer si existe una cuenta
     * @return boolean
     */
    public boolean isExisteCuenta() {
        if (cuenta!=null) {
            return true;
        }
        return false;
    }
    /**
     * Metodo encargado de buscar la cuenta de la persona que ingresa al sitema
     * @param lic ListaSimple de tipo Cuenta
     * @param lip ListaSimple de tipo Persona
     * @param lir ListaSimple de tipo Rol
     * @param Usuario String del Usuario
     * @param Contraseña String contrasenia
     */
    public void buscarCuenta(ListaSimple<Cuenta> lic, ListaSimple<Persona> lip, ListaSimple<Rol> lir, String Usuario, String Contraseña) {     
        
        for (int i = 0; i < lic.tamano(); i++) {
            if (lic.obtenerPorPosicion(i).getUsuario().equals(Usuario) && lic.obtenerPorPosicion(i).getContraseña().equals(Contraseña)) {
                System.out.println("Existe Cuenta"+lic.obtenerPorPosicion(i).getUsuario());
                cuenta = lic.obtenerPorPosicion(i);
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
