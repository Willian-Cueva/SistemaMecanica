/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Utiles;

import Modelo.Persona;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Willian
 */
public class UtilesComponentes {

    public static void cargarComboTipoRol(JComboBox cbx) {
//        cbx.removeAllItems();
        for (int i = 0; i < Utiles.roles().length; i++) {
            cbx.addItem(Utiles.roles()[i]);
        }
    }

    public static ImageIcon imageIcon(Object obj, Dimension d) {
        if (obj != null) {
            Persona p = (Persona) obj;
            Blob imagen = p.getImagenObtenida();
            Image rpta = null;
            try {
                rpta = javax.imageio.ImageIO.read(imagen.getBinaryStream());
                rpta = rpta.getScaledInstance(d.width, d.height, Image.SCALE_DEFAULT);
                //rpta.getGraphics().dra;
                ImageIcon image = new ImageIcon(rpta);
                return image;
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
                return null;
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
                return null;
            }
        } else {
            return null;
        }
    }

    public static File BuscarImagen() {
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
}
