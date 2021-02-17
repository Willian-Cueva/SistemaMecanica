/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorDao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

/**
 *
 * @author joe
 */
public class MantenerCesion<T> {

    private Conexion conexion=new Conexion();
    /**
     * Metodo encargado de almacenar los datos de la persona que ingreso al sistema durante el timpo que este ste activo para luego borrarse
     * @param ruta string ruta
     * @return un generico rol
     */
    public T listar(String ruta) {
        conexion.setREPO(ruta);
        T dato=null;
        try {
            dato = (T) conexion.getXtrStream().fromXML(new FileReader(conexion.getREPO() + File.separatorChar + ruta + ".json"));
           //Object obj = xtrStream.fromXML(new FileReader(url+File.separatorChar+"horario.json") );

        } catch (Exception e) {
            System.out.println("No se pudo listar " + e);
            e.printStackTrace();
        }
        return dato;
    }
    /**
     * Metodo encargado de guardar los datos del usuario que se a logueado en el sistema
     * @param o generico
     * @param ruta ruta de imagen
     * @throws Exception en caso no se guarde los datos no me detenga la ejecucion del programa.
     */
    public void guardar(T o,String ruta) throws Exception {
        conexion.setREPO(ruta);
        conexion.getXtrStream().toXML(o, new FileOutputStream(conexion.getREPO() + File.separatorChar + ruta + ".json"));

    }
    /**
     * modificar un objeto T
     * @param o T
     * @return boolean
     */
    public Boolean modificar(T o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}