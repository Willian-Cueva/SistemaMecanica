/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Modelo;

import Controlador.ListaSimpleAvanzada;
import Modelo.Persona;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Willian
 */
public class TablaPersonas extends AbstractTableModel{
    private ListaSimpleAvanzada lsa = new ListaSimpleAvanzada();

    public ListaSimpleAvanzada getLsa() {
        return lsa;
    }

    public void setLsa(ListaSimpleAvanzada lsa) {
        this.lsa=new ListaSimpleAvanzada();
        this.lsa = lsa;
    }
    @Override
    public int getRowCount() {
        return lsa.tamano();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Persona m = (Persona) lsa.obtenerObjetopp(i);
        return switch(i1){
            case 0 -> m.getId();
            case 1 -> m.getNombre();
            case 2 -> m.getApellido();
            case 3 -> m.getCedula();
            case 4 -> m.getCorreo();
            case 5 -> m.getTelefono();
            case 6 -> m.getDireccion();
            case 7 -> m.getEstado();
            case 8 -> m.getExternal_id();
            case 9 -> m.getIdRol();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "ID";
            case 1 -> "Nombre";
            case 2 -> "Apellido";
            case 3 -> "Cedula";
            case 4 -> "Correo";
            case 5 -> "Telefono";
            case 6 -> "Direccion";
            case 7 -> "Estado";
            case 8 -> "ExternalId";
            case 9 -> "IdRol";
            default -> null;
        };
    }
    
    
}
