/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.UtilesMecanico.UtilesMecanico;
import Modelo.OrdenReparacion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Cris2
 */
public class ControladorOrdenReparacion {
    OrdenReparacion odn;

    public OrdenReparacion getOdn() {
        return odn;
    }

    public void setOdn(OrdenReparacion odn) {
        this.odn = odn;
    }
    
    UtilesMecanico uti=new UtilesMecanico();
    public void Registrar(String requerimiento,Long idVehiculo){
        odn=new OrdenReparacion(Long.parseLong("0"), uti.fechaActual(), 0, 0, 0, requerimiento, idVehiculo);
    }
    public void GuardarOrden() {
        try {
            int i = 0;
            String insertar = "INSERT INTO ordenreparacion(idordenReparacion,fecha,subtotal,total,descuento,requerimiento,idVehiculo) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement stmt = (PreparedStatement) uti.getConexion().prepareStatement(insertar);
            stmt.setLong(1, odn.getIdOrden());
            stmt.setString(2, odn.getFecha());
            stmt.setDouble(3, odn.getSubtotal());
            stmt.setDouble(4, odn.getTotal());
            stmt.setDouble(5, odn.getDescuent());
            stmt.setString(6, odn.getRequerimiento());
            stmt.setLong(7, odn.getIdVehiculo());
            
            i = stmt.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Se guardo correctamente");
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
