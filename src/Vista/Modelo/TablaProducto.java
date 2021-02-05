/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Modelo;
import javax.swing.table.AbstractTableModel;
import Controlador.ListaSimpleAvanzada;
import Modelo.Producto;

/**
 *
 * @author LENOVO LEGION
 */
public class TablaProducto extends AbstractTableModel{
    private ListaSimpleAvanzada lsp = new ListaSimpleAvanzada();

    public ListaSimpleAvanzada getLsp() {
        return lsp;
    }

    public void setLsp(ListaSimpleAvanzada lsp) {
        this.lsp =new ListaSimpleAvanzada();
        this.lsp = lsp;
    }

    @Override
    public int getRowCount() {
        return lsp.tamano();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int i, int i1) {
       Producto prd= (Producto) lsp.obtenerObjetopp(i);
       return switch(i1){
            case 0 -> prd.getId();
            case 1 -> prd.getNombre();
            case 2 -> prd.getCantidad();
            case 3 -> prd.getMarca();
            case 4 -> prd.getPrecio();
            case 5 -> prd.getIva();
            case 6 -> prd.getExternal_id();
            default -> null;
        };
    }
    
    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "ID";
            case 1 -> "Nombre";
            case 2 -> "Stock";
            case 3 -> "Marca";
            case 4 -> "Precio";
            case 5 -> "IVA";
            case 6 -> "ExternalId";
            default -> null;
        };
    }
    
}
