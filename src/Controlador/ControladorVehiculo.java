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
    ListaSimple<Vehiculo> live ;
    ListaSimple<ModeloVehiculo> limo;
    ListaSimple<Marca> lima;
    UtilesMecanico uti = new UtilesMecanico();
    Vehiculo vehiculo;
    ModeloVehiculo modelo;

    public ListaSimple<Vehiculo> getLive() {
        return live;
    }

    public void setLive(ListaSimple<Vehiculo> live) {
        this.live = live;
    }

    public ListaSimple<Marca> getLima() {
        return lima;
    }

    public void setLima(ListaSimple<Marca> lima) {
        this.lima = lima;
    }
    

    public void RegistrarVehiculo(String placa, Long Modelo, String color, String observacion, File imagen, Long Propietario) {
        vehiculo = new Vehiculo(Long.parseLong("0"), placa, Modelo, color, observacion, true, observacion, imagen, Propietario);
    }
    public void RegistrarModelo(String Nombre,Long Marca){
        modelo=new ModeloVehiculo(Long.parseLong("0"), Nombre, Marca);
    }

    public void GuardarVehiculo() {
        try {
            int i = 0;
            FileInputStream archivofoto;
            archivofoto = new FileInputStream(vehiculo.getArchivo());
            String insertar = "INSERT INTO vehiculo(idvehiculo,placa,idModelovehiculo,color,observacion,estado,external_idVehiculo,idPersona,imagen) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = (PreparedStatement) uti.getConexion().prepareStatement(insertar);
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
    public void GuardarModelo() {
        try {
            int i = 0;
            String insertar = "INSERT INTO modelovehiculo(idModeloVehiculo,NombreModelo,idMarca) VALUES (?,?,?)";
            PreparedStatement stmt = (PreparedStatement) uti.getConexion().prepareStatement(insertar);
            stmt.setLong(1, modelo.getIdModeloVehiculo());
            stmt.setString(2, modelo.getNombreModelo());
            stmt.setLong(3, modelo.getIdMarca());
            i = stmt.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Se guardo correctamente");
            }
        } catch (SQLException ex) {
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
    public void llenarTablaFiltrarApellido(ListaSimple<Persona> li,DefaultTableModel modelo) {
        ctr.RecuperarData();
        Object obj[] = new Object[3];
        modelo.setRowCount(0);
        for (int i = 0; i < li.tamano(); i++) {
            obj[0] = li.obtenerPorPosicion(i).getId();
            obj[1] = li.obtenerPorPosicion(i).getNombre();
            obj[2] = li.obtenerPorPosicion(i).getApellido();
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
//            System.out.println("prueba 1");
            inta = inta / 2;
            band = true;
            while (band) {
//                System.out.println("prueba 2");
                band = false;
                i = 0;
                while ((i + inta) <= arreglo.tamano() - 1) {//2.1.1
//                    System.out.println("prueba 3");
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
        ctr.RecuperarData();
        ListaSimple<Persona> lAux = ctr.getLiPersona();
        Persona aux;
        if (busquedaBinaria(shell(lAux), Cedula) != null) {
            aux = busquedaBinaria(shell(lAux), Cedula);
            return aux;
        } else {
            return null;
        }

    }

    public ListaSimple<Persona> BuscarApellido(String apellido) {
        ListaSimple<Persona> aux=new ListaSimple<>();
        for (int i = 0; i < ctr.getLiPersona().tamano(); i++) {
            if (ctr.getLiPersona().obtenerPorPosicion(i).getApellido().equals(apellido)) {
                aux.insertar(ctr.getLiPersona().obtenerPorPosicion(i));
                return aux;
            }
        }
        return null;

    }
    ModeloVehiculo[] mo;
    Long idMarca;

    public void llenarboxModelos(JComboBox cb) {
        
        recuperarDatosMod();
        mo = new ModeloVehiculo[limo.tamano()];
        for (int i = 0; i < limo.tamano(); i++) {
            cb.addItem(limo.obtenerPorPosicion(i).getNombreModelo());
            mo[i] = limo.obtenerPorPosicion(i);

        }//importante

    }
    Marca[] ma;
    public void llenarboxMarcas(JComboBox cb){
       recuperarDatosMod();
        ma = new Marca[lima.tamano()];
        for (int i = 0; i < lima.tamano(); i++) {
            cb.addItem(lima.obtenerPorPosicion(i).getNombre());
            ma[i] = lima.obtenerPorPosicion(i);

        } 
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
        live=new ListaSimple<>();
        limo=new ListaSimple<>();
        lima=new ListaSimple<>();
        
        try {
            Statement stmt = (Statement) uti.getConexion().createStatement();
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
    public Long buscarMNombre(String Nombre){
        Long id = null;
        for (int i = 0; i < lima.tamano(); i++) {
            if (lima.obtenerPorPosicion(i).getNombre().equals(Nombre)) {
                id=lima.obtenerPorPosicion(i).getId();
            }
        }
        return id;
    }
}
