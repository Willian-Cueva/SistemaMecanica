/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.UtilesMecanico.UtilesMecanico;
import Lista.ListaSimple;
import Modelo.Marca;
import Modelo.ModeloVehiculo;
import Modelo.Persona;
import Modelo.Vehiculo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cris2
 */
public class ControladorVehiculo {

    ControladorCuenta ctr = new ControladorCuenta();
    ListaSimple<Vehiculo> live = new ListaSimple<>();
    ListaSimple<ModeloVehiculo> limo = new ListaSimple<>();
    ListaSimple<Marca> lima = new ListaSimple<>();
    UtilesMecanico uti = new UtilesMecanico();
    Vehiculo vehiculo;

    public void RegistrarVehiculo(String placa, Long Modelo, String color, String observacion, File imagen, Long Propietario) {
        vehiculo = new Vehiculo(Long.parseLong("0"), placa, Modelo, color, observacion, true, observacion, imagen, Propietario);
    }

    public void GuardarVehiculo() {
        try {
            int i = 0;
            FileInputStream archivofoto;
            archivofoto = new FileInputStream(vehiculo.getArchivo());
            String insertar = "INSERT INTO vehiculo(idvehiculo,placa,idModelovehiculo,color,observacion,estado,external_idVehiculo,idPersona,imagen) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = (PreparedStatement) uti.IniciarConexion().prepareStatement(insertar);
            stmt.setLong(1, vehiculo.getId());
            stmt.setString(2, vehiculo.getPlaca());
            stmt.setLong(3, vehiculo.getIdModeloVehiculo());
            stmt.setString(4, vehiculo.getColor());
            stmt.setString(5, vehiculo.getObservacion());
            stmt.setBoolean(6, vehiculo.getEstado());
            stmt.setString(7, vehiculo.getExternalidVehiculo());
            stmt.setLong(8, vehiculo.getIdPersona());
            stmt.setBinaryStream(9, archivofoto);
            i = stmt.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Se guardo correctamente");
            }
        } catch (FileNotFoundException | SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void llenarTabla(DefaultTableModel modelo) {
        ctr.RecuperarData();
        Object obj[] = new Object[3];
        modelo.setRowCount(0);
        for (int i = 0; i < ctr.getLiPersona().tamano(); i++) {
            obj[0] = ctr.getLiPersona().obtenerPorPosicion(i).getId();
            obj[1] = ctr.getLiPersona().obtenerPorPosicion(i).getNombre();
            obj[2] = ctr.getLiPersona().obtenerPorPosicion(i).getApellido();
            modelo.addRow(obj);
        }

    }

    public void llenarTablaBusqueda(DefaultTableModel modelo, Persona persona) {
        Object obj[] = new Object[3];
        modelo.setRowCount(0);
        obj[0] = persona.getId();
        obj[1] = persona.getNombre();
        obj[2] = persona.getApellido();
        modelo.addRow(obj);
    }

    public Persona busquedaBinaria(Lista.ListaSimple<Persona> lista, Long codigo) {
        int n = lista.tamano();
        int centro, inf = 0, sup = n;
        while (inf <= sup) {
            centro = (sup + inf) / 2;
            if (lista.obtenerPorPosicion(centro).getId().equals(codigo)) {
                return lista.obtenerPorPosicion(centro);
            } else if (codigo < lista.obtenerPorPosicion(centro).getId()) {
                sup = centro - 1;
            } else {
                inf = centro + 1;
            }
        }
        lista.verDatos();
        return null;
    }

    public ListaSimple<Persona> shell(ListaSimple<Persona> arreglo) {
        int inta, i;
        Persona aux;
        boolean band;
        inta = arreglo.tamano();
        while (inta > 0) {
            System.out.println("prueba 1");
            inta = inta / 2;
            band = true;
            while (band) {
                System.out.println("prueba 2");
                band = false;
                i = 0;
                while ((i + inta) <= arreglo.tamano() - 1) {//2.1.1
                    System.out.println("prueba 3");
                    if (arreglo.obtenerPorPosicion(i).getId() > arreglo.obtenerPorPosicion(i + inta).getId()) {
                        aux = arreglo.obtenerPorPosicion(i);
                        arreglo.editar(i, arreglo.obtenerPorPosicion(i + inta));
                        arreglo.editar(i + inta, aux);
                        band = true;
                    }
                    i = i + 1;
                }
            }
        }
        return arreglo;
    }

    public Persona BuscarCedula(Long Cedula) {
        ListaSimple<Persona> lAux = ctr.getLiPersona();
        Persona aux;
        if (busquedaBinaria(shell(lAux), Cedula) != null) {
            aux = busquedaBinaria(shell(lAux), Cedula);
            return aux;
        } else {
            return null;
        }

    }

    public Persona Buscar(String apellido) {
        Persona aux;
        for (int i = 0; i < ctr.getLiPersona().tamano(); i++) {
            if (ctr.getLiPersona().obtenerPorPosicion(i).getApellido().equals(apellido)) {
                aux = ctr.getLiPersona().obtenerPorPosicion(i);
                return aux;
            }
        }
        return null;

    }
    ModeloVehiculo[] mo;
    Long idMarca;

    public void llenarboxRoles(JComboBox cb) {
        recuperarDatosMod();
        mo = new ModeloVehiculo[limo.tamano()];
        for (int i = 0; i < limo.tamano(); i++) {
            cb.addItem(limo.obtenerPorPosicion(i).getNombreModelo());
            mo[i] = limo.obtenerPorPosicion(i);

        }//importante

    }
    //igual muy importante para la vistas
    public Long idModelo(String item) {
        long lg = 0;
        for (int i = 0; i < mo.length; i++) {
            if (mo[i].getNombreModelo().equals(item)) {
                lg = mo[i].getIdModeloVehiculo();
                idMarca = mo[i].getIdMarca();
            }
        }
        return lg;
    }

    public String buscarMarca() {
        String nombreMarca = "";
        for (int i = 0; i < lima.tamano(); i++) {
            if (lima.obtenerPorPosicion(i).getId().equals(idMarca)) {
                nombreMarca = lima.obtenerPorPosicion(i).getNombre();
            }
        }
        return nombreMarca;

    }

    public void recuperarDatosMod() {
        try {
            Statement stmt = (Statement) uti.IniciarConexion().createStatement();
            //Cargar la lista de Modelos
            ResultSet rsModelo = stmt.executeQuery("SELECT * FROM modelovehiculo");
            if (rsModelo.next()) {
                do {
                    //Listavehiculo
                    limo.insertar(new ModeloVehiculo(rsModelo.getLong(1), rsModelo.getString(2), rsModelo.getLong(3)));
                } while (rsModelo.next());
            }
            //Cargar marca
            ResultSet rsMarca = stmt.executeQuery("SELECT * FROM marca");
            if (rsMarca.next()) {
                do {
                    //ListaMarca
                    lima.insertar(new Marca(rsMarca.getLong(1), rsMarca.getString(2)));
                } while (rsMarca.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//cargo la lista con los datos de la BD

}
