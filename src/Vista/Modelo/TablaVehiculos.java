/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Modelo;

import Controlador.ListaSimpleAvanzada;
import Modelo.Vehiculo;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Willian
 */
public class TablaVehiculos extends AbstractTableModel{
    private ListaSimpleAvanzada lsa = new ListaSimpleAvanzada();
    /**
     * Trae una ListaSimpleAvanzada
     * @return ListaSimpleAvanzada
     */
    public ListaSimpleAvanzada getLsa() {
        return lsa;
    }
    /**
     * Enviamos una ListaSimpleAvanzada
     * @param lsa ListaSimpleAvanzada
     */
    public void setLsa(ListaSimpleAvanzada lsa) {
        this.lsa = new ListaSimpleAvanzada();
        this.lsa = lsa;
    }
    
    @Override
    public int getRowCount() {
        return lsa.tamano();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Vehiculo m = (Vehiculo) lsa.obtenerObjetopp(i);
        return switch(i1){
            case 0 -> m.getId();
            case 1 -> m.getPlaca();
            case 2 -> m.getIdModeloVehiculo();
            case 3 -> m.getColor();
            case 4 -> m.getObservacion();
            case 5 -> m.getEstado();
            case 6 -> m.getExternalidVehiculo();
            case 7 -> m.getIdPersona();
            default -> null;
        };
    }
    
    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "ID";
            case 1 -> "Placa";
            case 2 -> "IdModelo";
            case 3 -> "Color";
            case 4 -> "Observacion";
            case 5 -> "Estado";
            case 6 -> "External";
            case 7 -> "IdPersona";
            default -> null;
        };
    }
    
}
