/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.UtilesMecanico.UtilesMecanico;
import Modelo.Persona;
import com.mysql.cj.jdbc.Blob;
import com.mysql.cj.xdevapi.UpdateStatement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import Lista.ListaSimple;

/**
 *
 * @author Cris2
 */
public class ControladorCliente {

    ControladorCuenta ctr = new ControladorCuenta();
    ControladorVehiculo ctr1 = new ControladorVehiculo();
    UtilesMecanico uti = new UtilesMecanico();
    Persona persona;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    

    public void llenarTabla(DefaultTableModel modelo) {
        ctr.RecuperarData();
        Object obj[] = new Object[3];
        modelo.setRowCount(0);
        for (int i = 0; i < ctr.getLiPersona().tamano(); i++) {
            if (ctr.getLiPersona().obtenerPorPosicion(i).getIdRol() == 3) {
                obj[0] = ctr.getLiPersona().obtenerPorPosicion(i).getNombre();
                obj[1] = ctr.getLiPersona().obtenerPorPosicion(i).getApellido();
                obj[2] = ctr.getLiPersona().obtenerPorPosicion(i).getCedula();
                modelo.addRow(obj);
            }
        }

    }

    public void Encuentracliente(String cedula) {
        persona = ctr1.BuscarCedula(Long.parseLong(cedula));

    }

    public void Editar(String Correo, String telefono, String Direccion, String idpersona, String activo, File file) {

        boolean isActivo;
        if (activo.equals("Activo")) {
            isActivo = true;
        } else {
            isActivo = false;
        }
        int i = 0;
        if (file != null) {
            try {
                FileInputStream archivofoto;
                archivofoto = new FileInputStream(file);
                String insertar = "UPDATE personas SET correo = ?,telefono=?,direccion=?,estado=?,imagen=? WHERE (idpersona = ?)";
                PreparedStatement stmt = (PreparedStatement) uti.getConexion().prepareStatement(insertar);
                stmt.setString(1, Correo);
                stmt.setString(2, telefono);
                stmt.setString(3, Direccion);
                stmt.setBoolean(4, isActivo);
                stmt.setBinaryStream(5, archivofoto);
                stmt.setString(6, idpersona);
                i = stmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                String insertar = "UPDATE personas SET correo = ?,telefono=?,direccion=?,estado=? WHERE (idpersona = ?)";
                PreparedStatement stmt = (PreparedStatement) uti.getConexion().prepareStatement(insertar);
                stmt.setString(1, Correo);
                stmt.setString(2, telefono);
                stmt.setString(3, Direccion);
                stmt.setBoolean(4, isActivo);
                stmt.setString(5, idpersona);
                i = stmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    public ListaSimple<Persona> BuscarApellido(String apellido) {
        ListaSimple<Persona> aux=new ListaSimple<>();
        aux=ctr1.BuscarApellido(apellido);
        return aux;
    }
    public void llenarTablaFiltrarApellido(ListaSimple<Persona> li,DefaultTableModel modelo) {
        ctr.RecuperarData();
        Object obj[] = new Object[3];
        modelo.setRowCount(0);
        for (int i = 0; i < li.tamano(); i++) {
            obj[0] = li.obtenerPorPosicion(i).getNombre();
            obj[1] = li.obtenerPorPosicion(i).getApellido();
            obj[2] = li.obtenerPorPosicion(i).getCedula();
            modelo.addRow(obj);
        }

    }
    public void llenarTablaBusqueda(DefaultTableModel modelo, Persona persona) {
        Object obj[] = new Object[3];
        modelo.setRowCount(0);
        obj[0] = persona.getNombre();
        obj[1] = persona.getApellido();
        obj[2] = persona.getId();
        modelo.addRow(obj);
    }
}
