/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.UtilesMecanico;

/**
 *
 * @author Cris2
 */
import Modelo.Cuenta;
import Modelo.Rol;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UtilesMecanico {

    /**
     *
     * @return
     */
    static Connection conexion;
    /**
     * Metodo get estatico que permite establecer conexion con la base de datos
     * @return 
     */
    public Connection getConexion() {
        return conexion;
    }
    public void IniciarConexion() {
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
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error estableciendo conexion con la base de datos: " + NombreDB
                    + "\nDetalles del error: \n" + e.getMessage());
        }
        conexion=con;

    }

    /**
     * Metodo que permite realizar la busqueda de imagenes en el directorio de el computador 
     * @return
     */
    public File BuscarImagen() {
        File file = null;
        JFileChooser archivo = new JFileChooser();
        archivo.setBackground(new Color(255, 204, 51));
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de Archivos JPEG(*.JPG;*.JPEG)", "jpg", "jpeg");
        archivo.addChoosableFileFilter(filtro);
        archivo.setDialogTitle("Abrir Archivo");
        File ruta = new File("C:/Pictures");
        archivo.setCurrentDirectory(ruta);
        int ventana = archivo.showOpenDialog(null);
        if (ventana == JFileChooser.APPROVE_OPTION) {
            file = archivo.getSelectedFile();
        }
        return file;
    }
    /**
     * Metodo que permite convertir imagenes de formato Blod a Icono
     * @param imagen
     * @param d
     * @return 
     */
    public ImageIcon img(Blob imagen, Dimension d){
        
        Image rpta = null;
        try {
            rpta = javax.imageio.ImageIO.read(imagen.getBinaryStream());
            rpta = rpta.getScaledInstance(d.width, d.height, Image.SCALE_DEFAULT);
            //rpta.getGraphics().dra;
            ImageIcon image = new ImageIcon(rpta);
            return image;
        } catch (SQLException ex) {
            System.out.println("Error: "+ ex.getMessage());
            return null;
        } catch (IOException ex) {
            System.out.println("Error: "+ ex.getMessage());
            return null;
        }
    }
    /**
     * Metodo que permite obtener la fecha actual
     * @return 
     */
        public String fechaActual(){
        String fechaHora="";
        Calendar fecha = new GregorianCalendar();                                                   
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);
        System.out.println("Fecha Actual: " + dia + "/" + (mes+1) + "/" + año);
        System.out.printf("Hora Actual: %02d:%02d:%02d %n", hora, minuto, segundo);  
        fechaHora=String.valueOf(año)+"-"+String.valueOf(mes+1)+"-"+String.valueOf(dia)+" "+String.valueOf(hora)+":"+String.valueOf(minuto)+":"+String.valueOf(segundo);
        return fechaHora;
    }

}
