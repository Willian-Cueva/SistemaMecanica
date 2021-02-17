package Modelo;


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
    private Boolean Estado;
    private String External_id;
    private Long idPersona;
    /**
     * constructor de Cuenta 
     * @param id Long
     * @param Usuario String
     * @param contraseña String
     * @param Estado Boolean
     * @param External_id String
     * @param idPersona Long
     */
    public Cuenta(Long id, String Usuario, String contraseña,Boolean Estado , String External_id, Long idPersona) {
        this.id = id;
        this.Usuario = Usuario;
        this.contraseña = contraseña;
        this.Estado=Estado;
        this.External_id = External_id;
        this.idPersona = idPersona;
    }
    /**
     * retirna un Boolean
     * @return Boolean
     */
    public Boolean getEstado() {
        return Estado;
    }
    /**
     * resive un Booleano
     * @param Estado Boolean
     */
    public void setEstado(Boolean Estado) {
        this.Estado = Estado;
    }
    /**
     * Retorna un Long
     * @return Long
     */
    public Long getId() {
        return id;
    }
    /**
     * resive un Long id
     * @param id long
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * String
     * @return String
     */
    public String getUsuario() {
        return Usuario;
    }
    /**
     * recibe un String
     * @param Usuario string
     */
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }
    /**
     * Retorna Un String
     * @return String
     */
    public String getContraseña() {
        return contraseña;
    }
    /**
     * Resive un String
     * @param contraseña String
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    /**
     * retorna un String
     * @return String
     */
    public String getExternal_id() {
        return External_id;
    }
    /**
     * recibe un String
     * @param External_id String
     */
    public void setExternal_id(String External_id) {
        this.External_id = External_id;
    }
    /**
     * retorna un Long
     * @return Long
     */
    public Long getIdPersona() {
        return idPersona;
    }
    /**
     * recibe un Long
     * @param idPersona Long
     */
    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    } 
}
