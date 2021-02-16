/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Modelo;

import Controlador.ListaSimpleAvanzada;
import Modelo.Servicio;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Willian
 */
public class TablaServicios extends AbstractTableModel{
    private ListaSimpleAvanzada lsa = new ListaSimpleAvanzada();

    public ListaSimpleAvanzada getLsa() {
        return lsa;
    }

    public void setLsa(ListaSimpleAvanzada lsa) {
        this.lsa = lsa;
    }
    
    @Override
    public int getRowCount() {
        return lsa.tamano();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Nombre";
            case 1: return "Valor";
            case 2: return "Descripcion";
            default: return "-";
        }
    }
    
    @Override
    public Object getValueAt(int i, int i1) {
        Servicio s = (Servicio) lsa.obtenerObjetopp(i);
        if (s!=null) {
            switch(i1){
                case 0 ->{
                    return s.getNombre();
                }
                case 1 ->{
                    return s.getValor();
                }
                case 2 ->{
                    return s.getDescripcion();
                }
                default -> {
                    return "-";
                }
            }
        } else {
            return "null";
        }
    }
    
}
