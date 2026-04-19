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
        else{
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

}
