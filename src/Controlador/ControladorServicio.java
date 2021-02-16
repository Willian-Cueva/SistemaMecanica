/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.UtilesMecanico.UtilesMecanico;
import Modelo.Servicio;
import Lista.ListaSimple;
import Modelo.Cuenta;
import Modelo.DetalleReparacion;
import Modelo.Persona;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cris2
 */
public class ControladorServicio {

    public static UtilesMecanico uti = new UtilesMecanico();

    Servicio servicio = null;

    public Servicio getServicio() {
        return servicio;
    }
    /**
     * Metodo encargado de crear servicios
     * @param Titulo
     * @param Valor
     * @param Descripcion 
     */
    public void CrearServicio(String Titulo, Double Valor, String Descripcion) {
        servicio = new Servicio(0L, Descripcion, Valor, Titulo);
    }
    /**
     * Metodo encargado de rellenar la tabla de Servicios
     * @param li
     * @param modelo 
     */
    public void llenarTablaServicio(ListaSimple<Servicio> li,ListaSimple<Servicio>li2, DefaultTableModel modelo) {
        Object obj[] = new Object[3];
        modelo.setRowCount(0);
        for (int i = 0; i < li.tamano(); i++) {
            obj[0] = li.obtenerPorPosicion(i).getNombre();
            obj[1] = li.obtenerPorPosicion(i).getValor();
            obj[2] = li.obtenerPorPosicion(i).getDescripcion();
            modelo.addRow(obj);
        }
        for (int i = 0; i < li2.tamano(); i++) {
            obj[0] = li2.obtenerPorPosicion(i).getNombre();
            obj[1] = li2.obtenerPorPosicion(i).getValor();
            obj[2] = li2.obtenerPorPosicion(i).getDescripcion();
            modelo.addRow(obj);
        }
    }
    /**
     * Metodo que permite guardar los datos de servicios en la base de datos
     * @param Servicio
     * @param Detalle 
     */
    public void GuardarServicio(Servicio Servicio, Long Detalle) {
        System.out.println("Dato importante: " + Detalle);
        Long idSalida=0L;
        try {
            int i = 0;
            String insertar = "INSERT INTO salidaservicio(idsalidaServicio,idDetalle) VALUES (?,?)";
            PreparedStatement stmt = (PreparedStatement) uti.getConexion().prepareStatement(insertar);
            stmt.setLong(1, 0L);
            stmt.setLong(2, Detalle);
            i = stmt.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Se guardo correctamente");
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        try {
            Statement stmt = (Statement) uti.getConexion().createStatement();
            //Cargar la lista de cuentas
            ResultSet rs = stmt.executeQuery("SELECT idSalidaServicio FROM salidaservicio where idDetalle="+Detalle);
            if (rs.next()) {
                do {
                    idSalida=rs.getLong(1);
                } while (rs.next());
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        try {
            int i = 0;
            String insertar = "INSERT INTO servicio(idservicio,descripcion,valor,nombre,idSalidaServicio) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = (PreparedStatement) uti.getConexion().prepareStatement(insertar);
            stmt.setLong(1, Servicio.getIdServicio());
            stmt.setString(2, Servicio.getNombre());
            stmt.setDouble(3, Servicio.getValor());
            stmt.setString(4, Servicio.getDescripcion());
            stmt.setLong(5, idSalida);
            i = stmt.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Se guardo correctamente");
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
       

    }

}
