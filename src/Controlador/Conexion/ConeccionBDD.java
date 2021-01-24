/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Willian
 */
public class ConeccionBDD {
     public static Connection IniciarConexion() {
        Connection con = null;
        String Driver = "com.mysql.cj.jdbc.Driver";
        String Usuario = "root";
        String Contraseña = "root";
        String NombreDB = "baseddmecanica";
        String Puerto = "3306";
        String TimeZone = "?useUnicode=true&use"
                + "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false"
                + "&serverTimezone=UTC";
        try {
            Class.forName(Driver);
            con = DriverManager.getConnection("jdbc:mysql://localhost:" + Puerto + "/" + NombreDB + TimeZone, Usuario, Contraseña);
            System.out.println("Conexion establecida correctamente con la base de datos: " + NombreDB);
        return con;
        } catch (SQLException e) {
            System.out.println("Error estableciendo conexion con la base de datos: " + NombreDB
                    + "\nDetalles del error: \n" + e.getMessage());
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConeccionBDD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
