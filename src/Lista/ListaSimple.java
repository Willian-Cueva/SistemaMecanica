package Lista;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joe
 */
public class ListaSimple<T> {

    /**
     * Nodo de tipo Object
     */
    public Nodo<T> cabecera;

    /**
     * Controlador
     */
    public ListaSimple() {
        this.cabecera = null;
    }

    /**
     * devuelve el tamaño
     *
     * @return int
     */
    public int tamano() {
        int tamano = 0;
        if (!estaVacio()) {
            Nodo<T> tmp = cabecera;
            while (tmp != null) {
                tamano++;
                tmp = tmp.getSig();
            }
        }
        return tamano;
    }

    /**
     * inserta un objeto
     *
     * @param dato T
     */
    public void insertar(T dato) {
        if (dato == null) {
            new NullPointerException("Se debe agregar un objeto restaurante");
        }
        //se crea el nodo con el dato y que apunte a nulo
        Nodo<T> tmp = new Nodo(dato, null);
        //se apunta el nodo temporal a la cabecera
        tmp.setSig(cabecera);
        //se mueve el nodo tmp a la cabecera
        cabecera = tmp;
    }

    /**
     * devuelve true si está vacio
     *
     * @return boolean
     */
    public boolean estaVacio() {
        return (this.cabecera == null);//(this.cabecera != null) ? false : true;
    }

    /**
     * retorna un T
     *
     * @return T
     */
    public T extraer() {
        T dato = null;

        if (!estaVacio()) {
            dato = (T) cabecera.getDato();
            cabecera = cabecera.getSig();
        }
        return dato;
    }

    /**
     * obtiene un objeto dependiendo de la posicion
     *
     * @param pos int
     * @return T
     */
    public T obtenerPorPosicion(int pos) {
        T r = null;
        if (!estaVacio()) {
            Nodo<T> tmp = cabecera;
            for (int i = 0; i < pos; i++) {
                tmp = tmp.getSig();
                if (tmp == null) {
                    break;
                }
            }
            //System.out.println(tmp.getDato());
            if (tmp != null) {
                r = (T) tmp.getDato();
            }
        }
        return r;
    }

    /**
     * Sirve para ver todos los elementos de una lista
     */
    public void verDatos() {
        if (!estaVacio()) {
            Nodo<T> tmp = cabecera;
            while (tmp != null) {
                System.out.print(tmp.getDato().toString() + "\t");
                tmp = tmp.getSig();
            }

        }
        System.out.println("");
    }

    /**
     * Sirve para insertar un objeto segun la posicion indicada
     *
     * @param dato T
     * @param pos int
     */
    public void insertar(T dato, int pos) {
        if (estaVacio() || pos <= 0) {
            insertar(dato);
        } else {
            Nodo<T> iterador = cabecera;
            for (int i = 0; i < pos; i++) {
                if (iterador.getSig() == null) {
                    break;
                }
                iterador = iterador.getSig();
            }
            Nodo<T> tmp = new Nodo(dato, iterador.getSig());
            iterador.setSig(tmp);
        }
    }

    /**
     * Inserta un Objeto al final de la lista
     *
     * @param dato T
     */
    public void insertarFinal(T dato) {
        insertar(dato, tamano() - 1);
    }

    /**
     * Modifica el dato segun la posicion
     *
     * @param posicion int
     * @param dato T
     */
    public void editar(int posicion, T dato) {
        // Verifica si la posición ingresada se encuentre en el rango
        // >= 0 y < que el numero de elementos del la lista.
        if (posicion >= 0 && posicion < tamano()) {
            // Consulta si el nodo a eliminar es el primero.
            if (posicion == 0) {
                // Alctualiza el valor delprimer nodo.
                cabecera.setDato(dato);
            } else {
                // En caso que el nodo a eliminar este por el medio 
                // o sea el ultimo
                Nodo<T> aux = cabecera;
                // Recorre la lista hasta lleger al nodo anterior al eliminar.
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSig();
                }
                // Alctualiza el valor del nodo.
                aux.setDato(dato);
            }
        }
    }

    /**
     * elimina todos los elementos de la lista
     */
    public void allEliminar() {
        cabecera = null;
    }

    /**
     * Retorna la posicion en la que se encuentra un elemento
     *
     * @param referencia T
     * @return int
     */
    public int buscar(T referencia) {
        System.out.println("REFERENCIA: " + referencia);
        Nodo<T> aux = cabecera;
        int cont = 0;
        int posicion = -1;
        boolean encontrado = false;
        while (aux != null && encontrado != true) {
            if (aux.getDato().equals(referencia)) {
                //System.out.println("Auxiliar prueba: "+aux.getDato());
                encontrado = true;
                posicion = cont;
            } else {
                //System.out.println("auxiliar lista: "+aux.getDato());
                aux = aux.getSig();
            }
            cont++;
        }
        System.out.println("POSICION: " + posicion);
        return posicion;
    }
    /**
     * elimina un elemneto por referencia
     * @param referencia T
     */
    public void removerPorReferencia(T referencia) {
        if (buscar(referencia) != -1) {
            if (cabecera.getDato().equals(referencia)) {
                cabecera = cabecera.getSig();
            } else {
                Nodo<T> aux = cabecera;
                while (!(aux.getSig().getDato().equals(referencia))) {
                    aux = aux.getSig();
                }
                Nodo siguiente = aux.getSig().getSig();
                aux.setSig(siguiente);
            }

        }
    }
    /**
     * Elimina por posicion 
     * @param posicion int
     */
    public void removerPorPosicion(int posicion) {
        if (posicion >= 0 && posicion < tamano()) {
            if (posicion == 0) {
                cabecera = cabecera.getSig();
            } else {
                Nodo aux = cabecera;
                for (int i = 0; i < posicion - 1; i++) {
                    aux = aux.getSig();
                }
                Nodo siguiente = aux.getSig();
                aux.setSig(siguiente.getSig());
            }
        }
    }
}
