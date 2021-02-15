/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Modelo;

import Controlador.ControladorFacturas;
import Modelo.Factura;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Willian
 */
public class TablaFacturas extends AbstractTableModel {

    private ControladorFacturas cf = new ControladorFacturas();

    public ControladorFacturas getCf() {
        return cf;
    }

    public void setCf(ControladorFacturas cf) {
        this.cf = cf;
    }
    

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 -> {
                return "Placa";
            }
            case 1 -> {
                return "Nro";
            }
            case 2 -> {
                return "Fecha";
            }
            case 3 -> {
                return "Hora";
            }
            case 4 -> {
                return "Subtotal";
            }
            case 5 -> {
                return "Total";
            }
            default -> {
                return "Error";
            }
        }
    }

    @Override
    public int getRowCount() {
        return cf.getFacturas().tamano();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Factura f = (Factura) cf.getFacturas().obtenerObjetopp(i);
        if (f != null) {
            switch (i1) {
                case 0 -> {
                    return cf.getVehiculo().getPlaca();
                }
                case 1 -> {
                    return f.getIdFactura();
                }
                case 2 -> {
                    return f.getFecha();
                }
                case 3 -> {
                    return f.getHora();                    
                }
                case 4 -> {
                    return f.getOrden().getSubtotal();
                }
                case 5 -> {
                    return f.getOrden().getTotal();                    
                }
                default -> {
                    return "-";
                }
            }
        }
        return "null";
    }

}
