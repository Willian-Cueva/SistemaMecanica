/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorFacturas;
import Modelo.DetalleReparacion;

/**
 *
 * @author Willian
 */
public class MainPruebas {
    public static void main(String[] args) {
        ControladorFacturas cf = new ControladorFacturas();
         cf.cargarFacturas("LBA-1234");
        cf.cargarDetalles("4");
    }
}
