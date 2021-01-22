/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Utiles;

import Controlador.Conexion.ConexionBDD;
import Controlador.ListaSimpleAvanzada;
import Modelo.Persona;
import Modelo.Rol;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Willian
 */
public class Utiles {

    /**
     * Retorna una lista de macanicos consultada directamente de la base de
     * datos
     *
     * @return litsa de persona
     */
    public static ListaSimpleAvanzada listaPersonas() {
        ListaSimpleAvanzada persona = new ListaSimpleAvanzada();
        String sql = "SELECT * FROM persona";
        try {
            Statement st = (Statement) ConexionBDD.conexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
//            int cont = 1;
            while (rs.next()) {
                Persona m = new Persona();
                int i = 0;
                m.setId(Integer.valueOf(rs.getString(++i)));
                m.setNombre(rs.getString(++i));
                m.setApellido(rs.getString(++i));
                m.setCedula(rs.getString(++i));
                m.setCorreo(rs.getString(++i));
                m.setTelefono(rs.getString(++i));
                m.setDireccion(rs.getString(++i));
                m.setEstado(rs.getString(++i).equalsIgnoreCase("activo"));
                m.setExternal_id_persona(rs.getString(++i));
                m.setIdRol(Integer.parseInt(rs.getString(++i)));
                persona.insertar(m);
            }
        } catch (SQLException ex) {
//            Logger.getLogger(Utiles.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al ejecutar la consulta en la base de datos - listaMecanicos() Utiles\n" + ex);
        }
        return persona;
    }

    /**
     * Este metodo retorna un arreglo de Roles
     * @return 
     */
    public static Rol[] roles() {
        Rol[] arr = new Rol[3];
        int j = 0;
        String sql = "SELECT * FROM rol";
        try {
            Statement st = (Statement) ConexionBDD.conexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next() && j <= 3) {
                int i = 0;
                Rol r = new Rol();
                r.setId(Integer.valueOf(rs.getString(++i)));
                r.setNombre(rs.getString(++i));
                arr[j++] = r;
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
     * @param r JComboBox.getSelectedItem();
     * @return 
     */
    public static int rolSelect(Object r){
        Rol rol = (Rol) r;
        return rol.getId();
    }
}
