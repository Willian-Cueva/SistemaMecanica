/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cuenta;
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

    Cuenta cuenta;
    /**
     * 
     * @return 
     */
    public Cuenta getCuenta() {
        return cuenta;
    }
    /**
     * 
     * @param cuenta 
     */
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
    Utiles uti = new Utiles();
    /**
     * 
     * @param usuario
     * @param contraseña 
     */
    public void verificarCuenta(String usuario, String contraseña) {
        Blob imagen = null;
        Cuenta aux = null;
        try {
            Statement stmt = uti.IniciarConexion().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cuentas WHERE Usuario ='" + usuario + "' AND Contraseña='" + contraseña + "'");
            if (rs.next()) {
                imagen = (Blob) rs.getBlob(8);
                aux = new Cuenta(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(6), rs.getString(7), imagen);
                System.out.println(rs.getString(1)+" "+ rs.getString(2)+" "+rs.getString(7));
            }
        } catch (SQLException ex) {
            System.out.println("Error Obteniendo datos de la cuenta "+ex.getMessage());
        }
        cuenta=aux;

    }
    /**
     * 
     * @param nuevaContraseña
     * @param Cedula
     * @param Correo 
     */
    public void recuperarCuenta(String nuevaContraseña, String Cedula, String Correo){
        try {
            Statement stmt = (Statement) uti.IniciarConexion().createStatement();
            stmt.executeUpdate("UPDATE cuentas SET Contraseña = '"+nuevaContraseña+"' WHERE cuentas.Cedula = "+Cedula+" AND cuentas.Correo="+Correo);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
