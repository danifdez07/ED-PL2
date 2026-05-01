import java.util.ArrayList;

public class ArbolBinarioDeBusqueda<T extends Comparable<T>>{
    private Nodo<T> raiz;
    public ArbolBinarioDeBusqueda(){
        raiz = null;
    }
    public void add(T elemento){
        if( raiz==null ){
            raiz = new Nodo<>(elemento);}
        else {
            addRecursivo(raiz,elemento);
        }
    }
    private void addRecursivo(Nodo<T> nodoActual, T elemento) {
        if (0<elemento.compareTo(nodoActual.getDato())){
            if (nodoActual.getNodoDerecha() == null) {
                Nodo<T> nodoDerecha = new Nodo<>(elemento);
                nodoActual.setNodoDerecha(nodoDerecha);}
            else{addRecursivo(nodoActual.getNodoDerecha(), elemento);}


        }
        else if (0>elemento.compareTo(nodoActual.getDato())){
            if(nodoActual.getNodoIzquierda()==null){
                Nodo<T> nodoIzquierda = new Nodo<>(elemento);
                nodoActual.setNodoIzquierda(nodoIzquierda);
            }
            else{addRecursivo(nodoActual.getNodoIzquierda(),elemento);}
        }

    }
    public void imprimirEsquema() {
        System.out.println("\n--- ESQUEMA DEL ÁRBOL ---");
        imprimirEsquemaRecursivo(raiz, ""); // Le pasa la raíz y un texto vacío
        System.out.println("-------------------------\n");
    }
    private void imprimirEsquemaRecursivo(Nodo<T> nodoActual, String espacio){
        if (nodoActual == null) {
            return;
        }
        imprimirEsquemaRecursivo(nodoActual.getNodoDerecha(), espacio + "   ");
        System.out.println(espacio + "|--- " + nodoActual.getDato());
        imprimirEsquemaRecursivo(nodoActual.getNodoIzquierda(), espacio + "   ");
    }
    private Nodo<T> buscarNodo(Nodo<T> nodoActual, T elemento) {
        if (nodoActual == null) {
            return null;
        }

        int comparacion = elemento.compareTo(nodoActual.getDato());

        if (comparacion == 0) {
            return nodoActual;
        }
        else if (comparacion < 0) {
            return buscarNodo(nodoActual.getNodoIzquierda(), elemento);
        }
        else {
            return buscarNodo(nodoActual.getNodoDerecha(), elemento);
        }
    }

    public int getGrado(T elemento) {
        int grado = 0;

        Nodo<T> nodoEncontrado = buscarNodo(this.raiz, elemento);

        if (nodoEncontrado != null) {
            if (nodoEncontrado.getNodoIzquierda() != null) {
                grado++;
            }
            if (nodoEncontrado.getNodoDerecha() != null) {
                grado++;
            }
        } else {
            System.out.println("El nodo no existe");
            return grado;
        }

        return grado;
    }
    private int getAlturaRecursivo(Nodo<T> nodoActual) {
        int nulo = 0;
        if (nodoActual == null) {
            nulo = -1;
            return nulo;
        }

        int alturaIzquierda = getAlturaRecursivo(nodoActual.getNodoIzquierda());
        int alturaDerecha = getAlturaRecursivo(nodoActual.getNodoDerecha());
        int altura = 1 + Math.max(alturaIzquierda, alturaDerecha) + nulo;
        return altura;
    }

    public int getAltura() {
        return getAlturaRecursivo(this.raiz);
    }
    private void preOrdenRecursivo(Nodo<T> nodoActual, ArrayList<T> mochila) {
        if (nodoActual != null) {
            mochila.add(nodoActual.getDato());
            preOrdenRecursivo(nodoActual.getNodoIzquierda(), mochila);
            preOrdenRecursivo(nodoActual.getNodoDerecha(), mochila);
        }
    }

    public ArrayList<T> getListaPreOrden() {
        ArrayList<T> mochila = new ArrayList<>();
        preOrdenRecursivo(this.raiz, mochila);
        return mochila;
    }
    private void ordenCentralRecursivo(Nodo<T> nodoActual, ArrayList<T> mochila) {
        if (nodoActual != null) {
            ordenCentralRecursivo(nodoActual.getNodoIzquierda(), mochila);
            mochila.add(nodoActual.getDato());
            ordenCentralRecursivo(nodoActual.getNodoDerecha(), mochila);
        }
    }

    public ArrayList<T> getListaOrdenCentral() {
        ArrayList<T> mochila = new ArrayList<>();
        ordenCentralRecursivo(this.raiz, mochila);
        return mochila;
    }
    private void postOrdenRecursivo(Nodo<T> nodoActual, ArrayList<T> mochila) {
        if (nodoActual != null) {
            postOrdenRecursivo(nodoActual.getNodoIzquierda(), mochila);
            postOrdenRecursivo(nodoActual.getNodoDerecha(), mochila);
            mochila.add(nodoActual.getDato());
        }
    }

    public ArrayList<T> getListaPostOrden() {
        ArrayList<T> mochila = new ArrayList<>();
        postOrdenRecursivo(this.raiz, mochila);
        return mochila;
    }
    public ArbolBinarioDeBusqueda<T> getSubArbolIzquierda() {
        ArbolBinarioDeBusqueda<T> subArbol = new ArbolBinarioDeBusqueda<>();
        if (this.raiz != null) {
            subArbol.raiz = this.raiz.getNodoIzquierda();
        }
        return subArbol;
    }

    public ArbolBinarioDeBusqueda<T> getSubArbolDerecha() {
        ArbolBinarioDeBusqueda<T> subArbol = new ArbolBinarioDeBusqueda<>();
        if (this.raiz != null) {
            subArbol.raiz = this.raiz.getNodoDerecha();
        }
        return subArbol;
    }


}
