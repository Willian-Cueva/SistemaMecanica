/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.UtilesMecanico.UtilesMecanico;
import Modelo.Persona;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import Lista.ListaSimple;
import java.util.Objects;

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
    
    /**
     * Este metodo permite llenar la tabla clientes de forma general
     * @param modelo 
     */
    public void llenarTabla(DefaultTableModel modelo) {
        ctr.RecuperarData();
        Object obj[] = new Object[3];
        modelo.setRowCount(0);
        Long id=0L;
        for (int j = 0; j < ctr.getLiRol().tamano(); j++) {
            if (ctr.getLiRol().obtenerPorPosicion(j).getNombreRol().equals("Cliente")) {
                id=ctr.getLiRol().obtenerPorPosicion(j).getId();
            }
        }
        for (int i = 0; i < ctr.getLiPersona().tamano(); i++) {
            if (Objects.equals(ctr.getLiPersona().obtenerPorPosicion(i).getIdRol(), id)) {
                obj[0] = ctr.getLiPersona().obtenerPorPosicion(i).getNombre();
                obj[1] = ctr.getLiPersona().obtenerPorPosicion(i).getApellido();
                obj[2] = ctr.getLiPersona().obtenerPorPosicion(i).getCedula();
                modelo.addRow(obj);
            } 
        }

    }
    /**
     * Metodo que permite relizar busqueda de una persona por cedula
     * @param cedula 
     */
    public void Encuentracliente(String cedula) {
        persona = ctr1.BuscarCedula(Long.parseLong(cedula));

    }
    /**
     * Este metodo permite modificar y o actualizar los datos de los clintes almacenados en la base de datos
     * @param Correo
     * @param telefono
     * @param Direccion
     * @param idpersona
     * @param activo
     * @param file 
     */
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
    /**
     * Este metodo permite filtrar personas por apellido debido a las limitaciones solo hace la busqueda por apellido completo
     * @param apellido
     * @return 
     */
    public ListaSimple<Persona> BuscarApellido(String apellido) {
        ListaSimple<Persona> aux=new ListaSimple<>();
        aux=ctr1.BuscarApellido(apellido);
        return aux;
    }
    /**
     * Metodo encargado de rellenar la tabla de personas con los datos filtrados por apellido
     * @param li
     * @param modelo 
     */
    public void llenarTablaFiltrarApellido(ListaSimple<Persona> li,DefaultTableModel modelo) {
        //ctr.RecuperarData();
        Object obj[] = new Object[3];
        modelo.setRowCount(0);
        for (int i = 0; i < li.tamano(); i++) {
            obj[0] = li.obtenerPorPosicion(i).getNombre();
            obj[1] = li.obtenerPorPosicion(i).getApellido();
            obj[2] = li.obtenerPorPosicion(i).getCedula();
            modelo.addRow(obj);
        }

    }
    /**
     * Metodo encargado de rellenar la tabla con un unico dato obtenido mediante busqueda por cedula
     * @param modelo
     * @param persona 
     */
    public void llenarTablaBusqueda(DefaultTableModel modelo, Persona persona) {
        Object obj[] = new Object[3];
        modelo.setRowCount(0);
        obj[0] = persona.getNombre();
        obj[1] = persona.getApellido();
        obj[2] = persona.getCedula();
        modelo.addRow(obj);
    }
}
