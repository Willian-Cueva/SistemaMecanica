/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Conexion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Willian
 */
public class ConexionBDD {
    public static Connection cn;
    
    public static Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/baseddmecanica","root","root");
            System.out.println("La coneccion se realizo exitosamente con la base de datos");
            return cn;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("No se pudo establecer la coneccion con la base de datos");
            return null;
        }
    }
}
