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
public class Servicio {
   Long  idServicio;
   String descripcion;
   double valor;
   String nombre;
   /**
    * Crea un Servicio
    * @param idServicio Long
    * @param descripcion Stirng
    * @param valor Double
    * @param nombre  String
    */
    public Servicio(Long idServicio, String descripcion, double valor, String nombre) {
        this.idServicio = idServicio;
        this.descripcion = descripcion;
        this.valor = valor;
        this.nombre = nombre;
    }
    /**
     * Crea un Servicio
     */
    public Servicio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Trae un IdServicio
     * @return Long
     */
    public Long getIdServicio() {
        return idServicio;
    }
    /**
     * Enviar un IdServicio
     * @param idServicio Long
     */
    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }
    /**
     * Trae una DescripcionServicio
     * @return String
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Enviar una DescripcionServicio
     * @param descripcion String
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Trae un Valor Servicio
     * @return Double
     */
    public double getValor() {
        return valor;
    }
    /**
     * Enviar un Valor Servicio
     * @param valor  Double 
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
    /**
     * Traer un Nombre Servicio
     * @return  String
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Enviar un nombre Servicio
     * @param nombre String
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
}
