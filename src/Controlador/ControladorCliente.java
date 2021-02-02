/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.UtilesMecanico.UtilesMecanico;
import Modelo.Persona;
import com.mysql.cj.xdevapi.UpdateStatement;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cris2
 */
public class ControladorCliente {

    ControladorCuenta ctr = new ControladorCuenta();
    ControladorVehiculo ctr1 = new ControladorVehiculo();
    UtilesMecanico uti=new UtilesMecanico();
    Persona persona;

    public Persona getPersona() {
        return persona;
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

    public void cliente(String cedula) {
        persona = ctr1.BuscarCedula(Long.parseLong(cedula));

    }
    public void Editar(String Correo,String telefono, String Direccion,String idpersona){
        int i=0;
            try {
                String insertar = "UPDATE personas SET correo = '"+Correo+"',telefono='"+telefono+"',direccion='"+Direccion+"' WHERE (idpersona = '"+Long.parseLong(idpersona)+"')";
                PreparedStatement stmt = (PreparedStatement) uti.IniciarConexion().prepareStatement(insertar);
                i=stmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
