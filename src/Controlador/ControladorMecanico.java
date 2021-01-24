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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Cris2
 */
public class ControladorMecanico {
    
    Persona persona;
    Cuenta cuenta;
    UtilesMecanico uti = new UtilesMecanico();
    ControladorCuenta ctr = new ControladorCuenta();
    Rol[] arr;

    public Persona getPersona() {
        return persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public Cuenta getCuenta() {
        return cuenta;
    }
    
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
    public void RegistrarCliente(String cedula, String nombre, String apellido, String correo, String telefono, String direccion, File file, Long idRol, String contraseña) {
        persona = new Persona(Long.parseLong(cedula), nombre, apellido, cedula, correo, telefono, direccion,false, "f57c756c6fj6", idRol, file);
        if (contraseña!=null) {
          cuenta = new Cuenta(Long.parseLong("0"), correo, contraseña,true, "fg56dh7d8", persona.getId());  
        }
        
    }

    public void GuardarPersona(Persona persona) {
        try {
            int i = 0;
            FileInputStream archivofoto;
            archivofoto = new FileInputStream(persona.getArchivoImagen());
            String insertar = "INSERT INTO personas(idPersona,nombre,apellido,cedula,correo,telefono,direccion,estado,external_idPersona,imagen,idRol) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = (PreparedStatement) uti.IniciarConexion().prepareStatement(insertar);
            stmt.setString(1, persona.getId().toString());
            stmt.setString(2, persona.getNombre());
            stmt.setString(3, persona.getApellido());
            stmt.setString(4, persona.getCedula());
            stmt.setString(5, persona.getCorreo());
            stmt.setString(6, persona.getTelefono());
            stmt.setString(7, persona.getDireccion());
            stmt.setBoolean(8, persona.getEstado());
            stmt.setString(9, persona.getExternal_id());
            stmt.setBinaryStream(10, archivofoto);
            stmt.setString(11, persona.getIdRol().toString());
            i = stmt.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Se guardo correctamente");
            }
        } catch (FileNotFoundException | SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    public void GuardarCuenta(){
        try {
            int i = 0;
            String insertar = "INSERT INTO cuentas(idCuenta,usuario,clave,estado,external_idCuenta,idPersona) VALUES (?,?,?,?,?,?)";
            PreparedStatement stmt = (PreparedStatement) uti.IniciarConexion().prepareStatement(insertar);
            stmt.setString(1, cuenta.getId().toString());
            stmt.setString(2, cuenta.getUsuario());
            stmt.setString(3, cuenta.getContraseña());
            stmt.setBoolean(4,cuenta.getEstado());
            stmt.setString(5, cuenta.getExternal_id());
            stmt.setString(6, cuenta.getIdPersona().toString());
            i = stmt.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Se guardo correctamente");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMecanico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenarboxRoles(JComboBox cb) {
        ctr.RecuperarData();
        arr = new Rol[ctr.getLiRol().tamano()];
        for (int i = 0; i < ctr.getLiRol().tamano(); i++) {
            cb.addItem(ctr.getLiRol().obtenerPorPosicion(i).getNombreRol());
            arr[i] = ctr.getLiRol().obtenerPorPosicion(i);
            
        }
        
    }

    public Long idRol(String item) {
        long lg = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getNombreRol().equals(item)) {
                lg = arr[i].getId();
            }
        }
        return lg;
    }
}
