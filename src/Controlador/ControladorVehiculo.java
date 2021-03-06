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
    Persona persona;
    Vehiculo vaux;
    ModeloVehiculo modelo;
    ModeloVehiculo maux;
    Persona paux;
    /**
     * Obtiene un objeto ModeloVehiculo
     * @return ModeloVehiculo
     */
    public ModeloVehiculo getMaux() {
        return maux;
    }
    /**
     * recibe un ModeloVehiculo
     * @param maux ModeloVehiculo
     */
    public void setMaux(ModeloVehiculo maux) {
        this.maux = maux;
    }
    
    
    /**
     * Retorna un Vehiculo  
     * @return Vehiculo
     */
    public Vehiculo getVaux() {
        return vaux;
    }
    /**
     * recibe un Vehiculo
     * @param vaux Vehiculo
     */
    public void setVaux(Vehiculo vaux) {
        this.vaux = vaux;
    }

    /**
     * Retorna una ListaSimple de tipo Vehiculo
     * @return ListaSimple de tipo Vehiculo
     */
    public ListaSimple<Vehiculo> getLive() {
        return live;
    }
    /**
     * recibe una ListaSimple de tipo Vehiculo
     * @param live ListaSimple de tipo Vehiculo
     */
    public void setLive(ListaSimple<Vehiculo> live) {
        this.live = live;
    }
    /**
     * Devuelve una ListaSimple de tipo Marca
     * @return ListaSimple de tipo Marca
     */
    public ListaSimple<Marca> getLima() {
        return lima;
    }
    /**
     * recive una ListaSimple de tipo Marca
     * @param lima ListaSimple de tipo Marca
     */
    public void setLima(ListaSimple<Marca> lima) {
        this.lima = lima;
    }
    /**
     * retorna una Persona
     * @return Persona
     */
    public Persona getPaux() {
        return paux;
    }
    /**
     * Recibe una Persona
     * @param paux Persona
     */
    public void setPaux(Persona paux) {
        this.paux = paux;
    }
    
    /**
     * Metodo que permite crear un vehiculo
     * @param placa Placa del vehiculo
     * @param Modelo Modelo del vehiculo
     * @param color Color del vehiculo
     * @param observacion Observacion sobre el vehiculo
     * @param imagen Imagen del vehiculo
     * @param Propietario Propietario del vehiculo
     */
    public void RegistrarVehiculo(String placa, Long Modelo, String color, String observacion, File imagen, Long Propietario) {
        vehiculo = new Vehiculo(Long.parseLong("0"), placa, Modelo, color, observacion, true, observacion, imagen, Propietario);
    }
    /**
     * Metodo que permite crear un modelode vehiculo
     * @param Nombre Nombre del modelo a registrar
     * @param Marca  Identificador de la marca
     */
    public void RegistrarModelo(String Nombre,Long Marca){
        modelo=new ModeloVehiculo(Long.parseLong("0"), Nombre, Marca);
    }
    /**
     * Metodo encargado de guardar los vehiculos en la base de datos
     */
    public void GuardarVehiculo() {
        try {
            FileInputStream archivofoto=null;
            int i = 0;
            if (vehiculo.getImagen()!=null) {
                archivofoto = new FileInputStream(vehiculo.getArchivo());
            }
            System.out.println("Persona dueña: "+ vehiculo.getIdPersona());
            String insertar = "INSERT INTO vehiculo(idvehiculo,placa,idModeloVehiculo,color,observacion,estado,external_idVehiculo,idPersona,imagen) VALUES (?,?,?,?,?,?,?,?,?)";
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
    /**
     * Metodo encargado de guardar los modelos de vehiculos en la base de datos
     */
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
    /**
     * Metodo encargado de rellenar la tabla de forma general
     * @param modelo Modelo de tabla
     */
    public void llenarTabla(DefaultTableModel modelo) {
        ctr.RecuperarData();
        Object obj[] = new Object[3];
        modelo.setRowCount(0);
        for (int i = 0; i < ctr.getLiPersona().tamano(); i++) {
            obj[0] = ctr.getLiPersona().obtenerPorPosicion(i).getCedula();
            obj[1] = ctr.getLiPersona().obtenerPorPosicion(i).getNombre();
            obj[2] = ctr.getLiPersona().obtenerPorPosicion(i).getApellido();
            modelo.addRow(obj);
        }

    }
    /**
     * Metodo encargado de rellenar la tabla de vehiculos
     * @param modelo Modelo de tabla
     */
    public void llenarTablaVehiculo(DefaultTableModel modelo) {
        recuperarDatosMod();
        ctr.RecuperarData();
        Persona aux;
        Object obj[] = new Object[4];
        modelo.setRowCount(0);
        String modi="";
        for (int i = 0; i < live.tamano(); i++) {
            obj[0] = live.obtenerPorPosicion(i).getPlaca();
            for (int j = 0; j < limo.tamano(); j++) {
                if (live.obtenerPorPosicion(i).getIdModeloVehiculo().equals(limo.obtenerPorPosicion(j).getIdModeloVehiculo())) {
                    modi=limo.obtenerPorPosicion(j).getNombreModelo();
                }
            }
            obj[1] = modi;
            live.verDatos();
            
            aux=BuscarIDPersona(live.obtenerPorPosicion(i).getIdPersona());
            if (aux==null) {
                System.out.println("Aqui da nulo");
            }
            obj[2] = aux.getNombre()+" "+aux.getApellido();
            obj[3] = aux.getCedula();
            modelo.addRow(obj);
        }
    }
    /**
     * Metodo encargado de rellenar los datos de clientes filtrados por apellido
     * @param li Lista de personas
     * @param modelo Modelo de tabla
     */
    public void llenarTablaFiltrarApellido(ListaSimple<Persona> li,DefaultTableModel modelo) {
        ctr.RecuperarData();
        Object obj[] = new Object[3];
        modelo.setRowCount(0);
        for (int i = 0; i < li.tamano(); i++) {
            obj[0] = li.obtenerPorPosicion(i).getCedula();
            obj[1] = li.obtenerPorPosicion(i).getNombre();
            obj[2] = li.obtenerPorPosicion(i).getApellido();
            modelo.addRow(obj);
        }

    }
    /**
     * Metodo encargado de rellenar la tabla de busqueda por cedula
     * @param modelo Modelo de tabla
     * @param persona Persona a mostrar en la tabla
     */
    public void llenarTablaBusqueda(DefaultTableModel modelo, Persona persona) {
        Object obj[] = new Object[3];
        modelo.setRowCount(0);
        obj[0] = persona.getCedula();
        obj[1] = persona.getNombre();
        obj[2] = persona.getApellido();
        modelo.addRow(obj);
    }
    /**
     * Metodo de busqueda binaria
     * @param lista Lista de personas donde se ejecutara la busqueda
     * @param codigo Identificador de la persona buscada
     * @return Retorna una Persona
     */
    public Persona busquedaBinaria(Lista.ListaSimple<Persona> lista, Long codigo) {
        int n = lista.tamano();
        int centro, inf = 0, sup = n;
        while (inf <= sup) {
            centro = (sup + inf) / 2;
            if (Long.parseLong(lista.obtenerPorPosicion(centro).getCedula())==codigo) {
                return lista.obtenerPorPosicion(centro);
            } else if (codigo < Long.parseLong(lista.obtenerPorPosicion(centro).getCedula())) {
                sup = centro - 1;
            } else {
                inf = centro + 1;
            }
        }
        lista.verDatos();
        return null;
    }
    /**
     * Metodo de ordenacio shell
     * @param arreglo Lista de personas a ordenar
     * @return Retorna una lista de personas ordenada
     */
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
                    if (Long.parseLong(arreglo.obtenerPorPosicion(i).getCedula()) > Long.parseLong(arreglo.obtenerPorPosicion(i + inta).getCedula())) {
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
    /**
     * Busca de con el algoritmmo de busqueda binarria en una lista simple de tipo Persona y retorna una Persona
     * @param lista ListaSimple de tipo Persona
     * @param codigo Long
     * @return Persona
     */
    public Persona busquedaBinariaID(Lista.ListaSimple<Persona> lista, Long codigo) {
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
    /**
     * retorna una ListaSimple de tipo persona ordenada por shell
     * @param arreglo ListaSimple de tipo Persona
     * @return ListaSimple de tipo Persona
     */
    public ListaSimple<Persona> shellID(ListaSimple<Persona> arreglo) {
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
                    if (arreglo.obtenerPorPosicion(i).getId()> arreglo.obtenerPorPosicion(i + inta).getId()) {
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
    /**
     * retorna un Vehiculo de una ListaSimple de tipo vehiculo usando busqueda binaria
     * @param lista ListaSimple de tipo Vehiculo
     * @param codigo Long
     * @return Vehiculo
     */
    public Vehiculo busquedaBinariaV(Lista.ListaSimple<Vehiculo> lista, Long codigo) {
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
    /**
     * devuelve una ListaSimple de tipo Vehiculo ordenado por shell
     * @param arreglo ListaSimple de Vehiculo
     * @return ListaSimple de Vehiculo
     */
    public ListaSimple<Vehiculo> shellV(ListaSimple<Vehiculo> arreglo) {
        int inta, i;
        Vehiculo aux;
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
    /**
     * retorna un ModeloVehiculo usando busqueda binaria en una ListaSimple de tipo modelovehiculo por codigo
     * @param lista ListaSimple de tipo ModeloVehiculo
     * @param codigo Long
     * @return ModeloVehiculo
     */
    public ModeloVehiculo busquedaBinariaMod(Lista.ListaSimple<ModeloVehiculo> lista, Long codigo) {
        int n = lista.tamano();
        int centro, inf = 0, sup = n;
        while (inf <= sup) {
            centro = (sup + inf) / 2;
            if (lista.obtenerPorPosicion(centro).getIdModeloVehiculo().equals(codigo)) {
                return lista.obtenerPorPosicion(centro);
            } else if (codigo < lista.obtenerPorPosicion(centro).getIdModeloVehiculo()) {
                sup = centro - 1;
            } else {
                inf = centro + 1;
            }
        }
        lista.verDatos();
        return null;
    }
    /**
     * retorna una ListaSimpleAvanzada de tipo vehiculos ordenada por shell
     * @param arreglo ListaSimple de tipo ModeloVehiculo
     * @return ListaSimple de tipo ModeloVehiculo
     */
    public ListaSimple<ModeloVehiculo> shellMod(ListaSimple<ModeloVehiculo> arreglo) {
        int inta, i;
        ModeloVehiculo aux;
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
                    if (arreglo.obtenerPorPosicion(i).getIdModeloVehiculo()> arreglo.obtenerPorPosicion(i + inta).getIdModeloVehiculo()) {
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
    /**
     * Metodo de buscar personas por cedula
     * @param Cedula Cedula de la persona buscada
     * @return Retorna Una persona
     */
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
    /**
     * Metodo para buscar personas por su id
     * @param id Identificador de Persona buscada
     * @return Retorna una Persona
     */
    public Persona BuscarIDPersona(Long id) {
        ctr.RecuperarData();
        System.out.println("Por aqui nulo");
        ListaSimple<Persona> lAux = ctr.getLiPersona();
        lAux.verDatos();
        Persona aux;
        if (busquedaBinariaID(shellID(lAux), id) != null) {
            aux = busquedaBinariaID(shellID(lAux), id);
            return aux;
        } else {
            return null;
        }

    }
    /**
     * Metodo de busqueda de vehiculas por id
     * @param idVehiculo Identificador del vehiculo buscado
     * @return Retorna un vehiculo
     */
    public Vehiculo BuscarVehiculo(Long idVehiculo) {
        ctr.RecuperarData();
        ListaSimple<Vehiculo> lAux = live;
        Vehiculo aux;
        if (busquedaBinariaV(shellV(lAux), idVehiculo) != null) {
            aux = busquedaBinariaV(shellV(lAux), idVehiculo);
            return aux;
        } else {
            return null;
        }

    }
    /**
     * Metodo de busqueda de modelos de vehiculos por id
     * @param idModelo Identificador de modelo de vehiculo buscado
     * @return Retorna un modelo de vehiculo
     */
    public ModeloVehiculo BuscarModelo(Long idModelo) {
        ctr.RecuperarData();
        ListaSimple<ModeloVehiculo> lAux = limo;
        ModeloVehiculo aux;
        if (busquedaBinariaMod(shellMod(lAux), idModelo) != null) {
            aux = busquedaBinariaMod(shellMod(lAux), idModelo);
            return aux;
        } else {
            return null;
        }

    }
    /**
     * Metodo de filtrado de personas por apellido
     * @param apellido Apellido de la Persona a buscar
     * @return Retorna una Lista de personas
     */
    public ListaSimple<Persona> BuscarApellido(String apellido) {
        ctr.RecuperarData();
        ListaSimple<Persona> aux=new ListaSimple<>();
        for (int i = 0; i < ctr.getLiPersona().tamano(); i++) {
            if (ctr.getLiPersona().obtenerPorPosicion(i).getApellido().equals(apellido)) {
                aux.insertar(ctr.getLiPersona().obtenerPorPosicion(i));
            }
        }
        return aux;

    }
    /**
     * Metodo que permite buscar la vehiculo por placa
     * @param placa Placa del vehiculo buscado
     * @return Retorna una lista de vehiculos
     */
    public ListaSimple<Vehiculo> BuscarPlaca(String placa) {
        ListaSimple<Vehiculo> aux=new ListaSimple<>();
        for (int i = 0; i < live.tamano(); i++) {
            if (live.obtenerPorPosicion(i).getPlaca().equals(placa)) {
                aux.insertar(live.obtenerPorPosicion(i));
                return aux;
            }
        }
        return null;

    }
    /**
     * Metodo que permite llenar los campos de placa
     * @param placa Placa de vehiculo
     */
    public void llenartxt(String placa){
        for (int i = 0; i < live.tamano(); i++) {
            if (live.obtenerPorPosicion(i).getPlaca().equals(placa)) {
                vaux=live.obtenerPorPosicion(i);
            }
        }
    }
    /**
     * Metodo que permite rellenar la tabla de vehiculos filtrados por placa
     * @param li Lista de vehiculos
     * @param modelo Modelo de Tabla
     */
     public void llenarTablaFiltrarPlaca(ListaSimple<Vehiculo> li,DefaultTableModel modelo) {
        ctr.RecuperarData();
        Object obj[] = new Object[4];
        modelo.setRowCount(0);
        String mod="";
        String pr="";
        String ce="";
        for (int i = 0; i < li.tamano(); i++) {
            for (int j = 0; j < limo.tamano(); j++) {
                if (li.obtenerPorPosicion(i).getIdModeloVehiculo().equals(limo.obtenerPorPosicion(j).getIdModeloVehiculo())) {
                    mod=limo.obtenerPorPosicion(j).getNombreModelo();
                }
            }
            obj[0] = li.obtenerPorPosicion(i).getPlaca();
            obj[1] = mod;
            for (int j = 0; j < ctr.getLiPersona().tamano(); j++) {
                if (ctr.getLiPersona().obtenerPorPosicion(j).getId().equals(li.obtenerPorPosicion(i).getIdPersona())) {
                    pr=ctr.getLiPersona().obtenerPorPosicion(j).getNombre()+" "+ctr.getLiPersona().obtenerPorPosicion(j).getApellido();
                    ce=ctr.getLiPersona().obtenerPorPosicion(j).getCedula();
                }
            }
            obj[2] = pr;
            obj[3] =ce;
            modelo.addRow(obj);
        }

    }
    ModeloVehiculo[] mo;
    Long idMarca;
    /**
     * Metodo que permite llenar los modelos de vehiculos en el jcombo box correspondiente
     * @param cb JComboBox
     */
    public void llenarboxModelos(JComboBox cb) {
        
        recuperarDatosMod();
        mo = new ModeloVehiculo[limo.tamano()];
        for (int i = 0; i < limo.tamano(); i++) {
            cb.addItem(limo.obtenerPorPosicion(i).getNombreModelo());
            mo[i] = limo.obtenerPorPosicion(i);

        }//importante

    }
    Marca[] ma;
    /**
     * Metodo que permite llenar las marcas de vehiculos en el jCombo box correspondiente
     * @param cb  JComboBox
     */
    public void llenarboxMarcas(JComboBox cb){
       recuperarDatosMod();
        ma = new Marca[lima.tamano()];
        for (int i = 0; i < lima.tamano(); i++) {
            cb.addItem(lima.obtenerPorPosicion(i).getNombre());
            ma[i] = lima.obtenerPorPosicion(i);

        } 
    }
    //igual muy importante para la vistas
    /**
     * Metodo que permite buscar el id de un modelo de vehiculo por nombre
     * @param item Nombre del modelo a buscar
     * @return Retorna el identificador del modelo buscado
     */
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
    /**
     * Metodo que permite buscar una marca de un vehiculo
     * @return  Retorna el nombre de la marca buscada
     */
    public String buscarMarca() {
        String nombreMarca = "";
        for (int i = 0; i < lima.tamano(); i++) {
            if (lima.obtenerPorPosicion(i).getId().equals(idMarca)) {
                nombreMarca = lima.obtenerPorPosicion(i).getNombre();
            }
        }
        return nombreMarca;

    }
    /**
     * Metodo encargado de llenar las listas de vehiculos, modelos, marcas con los datos obtenidos de la base de datos
     */
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
            ResultSet rsVehiculo = stmt.executeQuery("SELECT * FROM vehiculo");
            if (rsVehiculo.next()) {
                do {
                    //ListaMarca
                    live.insertar(new Vehiculo(
                            rsVehiculo.getLong(1),
                            rsVehiculo.getString(2),
                            rsVehiculo.getLong(3),
                            rsVehiculo.getString(4),
                            rsVehiculo.getString(5), 
                            rsVehiculo.getBoolean(6),
                            rsVehiculo.getString(7), 
                            rsVehiculo.getBlob(9), 
                            rsVehiculo.getLong(8)));
                } while (rsVehiculo.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//cargo la lista con los datos de la BD
    /**
     * Metodo que permite buscar marcas por su nombre i obtener su id
     * @param Nombre Nombre de la marca buscada
     * @return Retorna el identificador de la marca buscada
     */
    public Long buscarMNombre(String Nombre){
        Long id = null;
        for (int i = 0; i < lima.tamano(); i++) {
            if (lima.obtenerPorPosicion(i).getNombre().equals(Nombre)) {
                id=lima.obtenerPorPosicion(i).getId();
            }
        }
        return id;
    }
    /**
     * Metodo que permite modificar y o actualizar los datos de un vehiculo
     * @param color Color del vehiculo
     * @param observacion Observacion(Comentario) del vehiculo
     * @param activo Estado del vehiculo en la base de datos
     * @param file Archivo de imagen del vehiculo
     * @param idVehiculo identificador del vehiculo
     */
    public void Editar(String color,String observacion,String activo,File file,String idVehiculo){
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
                String insertar = "UPDATE vehiculo SET color = ?,observacion=?,estado=?,imagen=? WHERE (idvehiculo = ?)";
                PreparedStatement stmt = (PreparedStatement) uti.getConexion().prepareStatement(insertar);
                stmt.setString(1, color);
                stmt.setString(2, observacion);
                stmt.setBoolean(3, isActivo);
                stmt.setBinaryStream(4, archivofoto);
                stmt.setString(5, idVehiculo);
                i = stmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("idVehiculo: "+idVehiculo);
            try {
                String insertar ="UPDATE vehiculo SET color = ?,observacion=?,estado=? WHERE (idvehiculo = ?)";
                PreparedStatement stmt = (PreparedStatement) uti.getConexion().prepareStatement(insertar);
                stmt.setString(1, color);
                stmt.setString(2, observacion);
                stmt.setBoolean(3, isActivo);
                stmt.setString(4, idVehiculo);
                i = stmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Error: "+ex);
            }catch(Exception ex){
                System.out.println("Error: "+ex);
            }

        }
    }
    /**
     * Metodo que permite llenar la tabla de vehiculos dependiendo de la persona que sea propietaria
     * @param modelo modelo de tabla
     * @param pe Objeto de tipo persona
     */
    public void llenarTablaBusquedaVehiculo(DefaultTableModel modelo,Persona pe){
        Object obj[] = new Object[4];
        modelo.setRowCount(0);
        String md="";
        String no="";
        String ce="";
        ctr.RecuperarData();
        Vehiculo aux=null;
        for (int i = 0; i < live.tamano(); i++) {
            if (live.obtenerPorPosicion(i).getIdPersona().equals(pe.getId())) {
                aux=live.obtenerPorPosicion(i);
            }
        }
        for (int i = 0; i < limo.tamano(); i++) {
            if (limo.obtenerPorPosicion(i).getIdModeloVehiculo().equals(aux.getIdModeloVehiculo())) {
                md=limo.obtenerPorPosicion(i).getNombreModelo();
            }
        }
        obj[0] = md;
        obj[1] = aux.getPlaca();
        obj[2] = pe.getNombre()+" "+pe.getApellido();
        obj[3] = pe.getCedula();
        modelo.addRow(obj);
    }
    /**
     * Metodo para buiscar vehiculo
     * @param id Identitificador de el vehiculo buscado
     */
    public void buscarVehiculo(String id){
        Long lg=Long.parseLong(id);
        vaux=BuscarVehiculo(lg);
    }
    /**
     * Metodo para buscar modelo de vehiculo
     * @param id  Identificador de el modelo de vehiculo buscado
     */
    public void buscarModeloVehiculo(String id){
        Long lg=Long.parseLong(id);
        maux=BuscarModelo(lg);
    }
    /**
     * Metodo para buscar personas
     * @param id Identificador de la persona buscada
     */
    public void buscarPersona(String id){
        Long lg=Long.parseLong(id);
        paux=BuscarCedula(lg);
    }
    
}
