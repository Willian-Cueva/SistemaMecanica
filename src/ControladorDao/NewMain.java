/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorDao;

import Modelo.Cuenta;
import Modelo.Rol;

/**
 *
 * @author Cris2
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Cuenta rol=new Cuenta(Long.parseLong("1"),"loca","Admin",true,"rtf",Long.MIN_VALUE);
        MantenerCesion<Cuenta> dos=new MantenerCesion();
        dos.guardar(rol,"Rol");
        System.out.println("Campo: "+dos.listar("Rol").getUsuario());
        // TODO code application logic here
    }
    
}
