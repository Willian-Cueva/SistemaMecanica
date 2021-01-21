package Modelo;

import java.io.File;
import java.sql.Blob;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cris2
 */
public class Cuenta{
    private Long id;
    private String Usuario;
    private String contraseña;
    private String External_id;
    private Long idPersona;

    public Cuenta(Long id, String Usuario, String contraseña, String External_id, Long idPersona) {
        this.id = id;
        this.Usuario = Usuario;
        this.contraseña = contraseña;
        this.External_id = External_id;
        this.idPersona = idPersona;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getExternal_id() {
        return External_id;
    }

    public void setExternal_id(String External_id) {
        this.External_id = External_id;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    
    
    
}
