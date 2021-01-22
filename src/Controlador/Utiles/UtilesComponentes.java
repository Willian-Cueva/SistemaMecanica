/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Utiles;

import javax.swing.JComboBox;

/**
 *
 * @author Willian
 */
public class UtilesComponentes {
    public static void cargarComboTipoRol(JComboBox cbx){
        cbx.removeAllItems();
        for (int i = 0; i < Utiles.roles().length; i++) {
            cbx.addItem(Utiles.roles()[i]);
            
        }
    }
}
