/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Utiles;

import Controlador.Conexion.ConeccionBDD;
import Controlador.ListaSimpleAvanzada;
import Modelo.Persona;
import Modelo.Rol;
import Modelo.Vehiculo;
import java.sql.Statement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Willian
 */
public class Utiles {

    public static String[] idPersona(ListaSimpleAvanzada lsa, int dato, String atributoClase) {
        String[] persona = new String[8];
        Persona p = (Persona) busquedaBinaria(lsa, dato, atributoClase);
        if (p != null) {
            persona[0] = String.valueOf(p.getId());
            persona[1] = p.getNombre();
            persona[2] = p.getApellido();
            persona[3] = p.getCedula();
            persona[4] = p.getCorreo();
            persona[5] = p.getTelefono();
            persona[6] = p.getDireccion();
            persona[7] = String.valueOf(p.getIdRol());
        }

        return persona;
    }

    public static Boolean comparar(Object o, Object o1, String atributoClase) {
        String uno = extraccionDato(o, atributoClase);
        String dos = extraccionDato(o1, atributoClase);
        return (uno != null && dos != null) ? uno.equals(dos) : false;
    }

    public static ListaSimpleAvanzada busquedaSecuencial(ListaSimpleAvanzada lsa, Object dato, String atributoClase) {
        ListaSimpleAvanzada encontrados = new ListaSimpleAvanzada();
        for (int i = 0; i < lsa.tamano(); i++) {
            String uno = extraccionDato(lsa.obtenerObjetopp(i), atributoClase);
            if (uno != null) {
                if (uno.replace(" ", "").compareToIgnoreCase(String.valueOf(dato)) == 0) {
                    encontrados.insertar(lsa.obtenerObjetopp(i));
                }
            }
        }
        return encontrados;
    }

    public static Object busquedaBinaria(ListaSimpleAvanzada lsa, Object dato, String atributoClase) {
        int n = lsa.tamano();
        int centro, inf = 0, sup = n - 1;
        while (inf <= sup) {
            centro = (sup + inf) / 2;
            if (comparar(lsa.obtenerObjetopp(centro), dato, atributoClase)) {
                return lsa.obtenerObjetopp(centro);
            } else if (compareTo(dato, lsa.obtenerObjetopp(centro), atributoClase)) {
                sup = centro - 1;
            } else {
                inf = centro + 1;
            }
        }
        return null;
    }

    public static void shell(ListaSimpleAvanzada lsa, String atributo) {
        int salto = lsa.tamano() / 2;
        while (salto > 0) {
            for (int i = salto; i < lsa.tamano(); i++) {
                int j = i - salto;
                while (j >= 0) {
                    int k = j + salto;
                    if (!Utiles.compareTo(lsa.obtenerObjetopp(j), lsa.obtenerObjetopp(k), atributo)) {
                        j--;
                    } else {
                        Object aux = lsa.obtenerObjetopp(j);
                        lsa.insertarDppE(j, lsa.obtenerObjetopp(k));
                        lsa.emilinarDpp(j + 1);
                        lsa.insertarDppE(k, aux);
                        lsa.emilinarDpp(k + 1);
                        j -= salto;
                    }
                }
            }
            salto /= 2;
        }
    }

    /**
     * Retorna una lista de macanicos consultada directamente de la base de
     * datos
     *
     * @return litsa de persona
     */
    public static ListaSimpleAvanzada listaPersonas() {
        ListaSimpleAvanzada persona = new ListaSimpleAvanzada();
        String sql = "SELECT * FROM personas";
        try {
            Statement st = (Statement) ConeccionBDD.IniciarConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
//            int cont = 1;
            while (rs.next()) {
                Persona m = new Persona();
                int i = 0;
                m.setId(Long.parseLong(rs.getString(++i)));
                m.setNombre(rs.getString(++i));
                m.setApellido(rs.getString(++i));
                m.setCedula(rs.getString(++i));
                m.setCorreo(rs.getString(++i));
                m.setTelefono(rs.getString(++i));
                m.setDireccion(rs.getString(++i));
                m.setEstado(rs.getString(++i).equalsIgnoreCase("1"));
                m.setExternal_id(rs.getString(++i));
                m.setIdRol(Long.parseLong(rs.getString(++i)));
                persona.insertar(m);
            }
        } catch (SQLException ex) {
//            Logger.getLogger(Utiles.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al ejecutar la consulta en la base de datos - listaMecanicos() Utiles\n" + ex);
        }
        return persona;
    }

    public static ListaSimpleAvanzada listaVehiculos() {
        ListaSimpleAvanzada vehiculos = new ListaSimpleAvanzada();
        String sql = "SELECT * FROM vehiculo";
        try {
            Statement st = (Statement) ConeccionBDD.IniciarConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
//            int cont = 1;
            while (rs.next()) {
                Vehiculo m = new Vehiculo();
                int i = 0;
                m.setId(Long.parseLong(rs.getString(++i)));
                m.setPlaca(rs.getString(++i));
                m.setIdModeloVehiculo(Long.parseLong(rs.getString(++i)));
                m.setColor(rs.getString(++i));
                m.setObservacion(rs.getString(++i));
                m.setEstado(rs.getString(++i).equalsIgnoreCase("1"));
                m.setExternalidVehiculo(rs.getString(++i));
                m.setIdPersona(Long.parseLong(rs.getString(++i)));
//                m.setImagen((Blob)rs.getString(++i));
                vehiculos.insertar(m);
            }
        } catch (SQLException ex) {
//            Logger.getLogger(Utiles.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al ejecutar la consulta en la base de datos - listaMecanicos() Utiles\n" + ex);
        }
        return vehiculos;
    }

    /**
     * Este metodo retorna un arreglo de Roles
     *
     * @return
     */
    public static Rol[] roles() {
        Rol[] arr = new Rol[3];
        int j = 0;
        String sql = "SELECT * FROM rol";
        try {
            if (ConeccionBDD.IniciarConexion() != null) {
                Statement st = (Statement) ConeccionBDD.IniciarConexion().createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next() && j <= 3) {
                    int i = 0;
                    Rol r = new Rol();
                    r.setId(Long.parseLong(rs.getString(++i)));
                    r.setNombreRol(rs.getString(++i));
                    arr[j++] = r;
                }
            } else {
                System.err.println("Fallo la coneccion a la base de datos");
            }
            return arr;
        } catch (SQLException ex) {
//            Logger.getLogger(Utiles.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("No se pudo obtener el arreglo de roles");
            return null;
        }
    }

    /**
     * Devuelve el valor del rol seleccionado
     *
     * @param r JComboBox.getSelectedItem();
     * @return
     */
    public static long rolSelect(Object r) {
        Rol rol = (Rol) r;
        return rol.getId();
    }

    private static boolean compareTo(Object o, Object o1, String atributoClase) {
        int i = 0;
        String uno = extraccionDato(o, atributoClase);
        String dos = extraccionDato(o1, atributoClase);
        if (uno != null && dos != null) {
            if (uno.toUpperCase().compareTo(dos.toUpperCase()) > 0) {
                i = 1;
            } else {
                i = -1;
            }
        }
        return (i == 1);
    }

    private static String extraccionDato(Object o, String atributoClase) {
        Class clase = o.getClass();
        Field atributo = null;
        Object informacion = null;
        for (Field f : clase.getDeclaredFields()) {
            if (f.getName().toString().equalsIgnoreCase(atributoClase)) {
                atributo = f;
                break;
            }
        }
        if (atributo != null) {
            for (Method metodoAux : clase.getMethods()) {
                if (metodoAux.getName().startsWith("get")) {
                    if (metodoAux.getName().toLowerCase().endsWith(atributo.getName())) {
                        try {
                            informacion = metodoAux.invoke(o);
                            break;
                        } catch (Exception e) {
                            System.out.println("Error de metodo\n" + e);
                        }
                    }
                }
            }
        }
        return (informacion != null) ? informacion.toString() : null;
    }
}
