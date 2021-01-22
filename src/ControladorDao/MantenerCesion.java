/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorDao;

import Lista.ListaSimple;
import Modelo.Rol;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.List;

/**
 *
 * @author joe
 */
public class MantenerCesion<T> {

    private Conexion conexion=new Conexion();

    public T listar(String ruta) {
        conexion.setREPO(ruta);
        T rol=null;
        try {
            rol = (T) conexion.getXtrStream().fromXML(new FileReader(conexion.getREPO() + File.separatorChar + ruta + ".json"));
           //Object obj = xtrStream.fromXML(new FileReader(url+File.separatorChar+"horario.json") );

        } catch (Exception e) {
            System.out.println("No se pudo listar " + e);
            e.printStackTrace();
        }
        return rol;
    }

    public void guardar(T o,String ruta) throws Exception {
        conexion.setREPO(ruta);
        conexion.getXtrStream().toXML(o, new FileOutputStream(conexion.getREPO() + File.separatorChar + ruta + ".json"));

    }

    public Boolean modificar(T o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
