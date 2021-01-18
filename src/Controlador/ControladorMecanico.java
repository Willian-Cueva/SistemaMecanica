/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Persona;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Cris2
 */
public class ControladorMecanico {

    Persona persona;
    Utiles uti = new Utiles();

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public void RegistrarCliente(String cedula,String nombre,String correo,String telefono,File file) {
            persona=new Persona(cedula, nombre, correo, telefono, file);
    }
    public void GuardarCliente(Persona persona){
        try {
            int i = 0;
            FileInputStream archivofoto;
            archivofoto = new FileInputStream(persona.getArchivoImagen());
            String insertar = "INSERT INTO clientes(cedula,nombre,correo,telefono,imagen) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = (PreparedStatement) uti.IniciarConexion().prepareStatement(insertar);
            stmt.setString(1, persona.getCedula());
            stmt.setString(2, persona.getNombre());
            stmt.setString(3, persona.getCorreo());
            stmt.setString(4, persona.getTelefono());
            stmt.setBinaryStream(5,archivofoto);
            i = stmt.executeUpdate();
            if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Se guardo correctamente");
                }
        } catch (FileNotFoundException | SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
    }
    
}
