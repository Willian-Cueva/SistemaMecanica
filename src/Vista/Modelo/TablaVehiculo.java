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
 * @author LENOVO LEGION
 */
public class TablaVehiculo extends AbstractTableModel {

    private ListaSimpleAvanzada lsv = new ListaSimpleAvanzada();

    public void setLsp(ListaSimpleAvanzada lsv) {
        this.lsv = new ListaSimpleAvanzada();
        this.lsv = lsv;
    }

    @Override
    public int getRowCount() {
        return lsv.tamano();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Vehiculo nv = (Vehiculo) lsv.obtenerObjetopp(i);
        return switch (i1) {
            case 0 ->
                nv.getId();
            case 1 ->
                nv.getPlaca();
            case 2 ->
                nv.getIdModeloVehiculo();
            case 3 ->
                nv.getColor();
            case 4 ->
                nv.getObservacion();
            case 5 ->
                nv.getEstado();
            case 6 ->
                nv.getExternalidVehiculo();
            case 7 ->
                nv.getImagen();
            case 8 ->
                nv.getArchivo();
            case 9 ->
                nv.getIdPersona();
            default ->
                null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 ->
                "ID";
            case 1 ->
                "Placa";
            case 2 ->
                "Modelo";
            case 3 ->
                "Color";
            case 4 ->
                "Observaciones";
            case 5 ->
                "Estado";
            case 6 ->
                "ExternalId";
            case 7 ->
                "Imagen";
            case 8 ->
                "Archivo";
            case 9 ->
                "IdPersona";
            default ->
                null;
        };
    }

}
