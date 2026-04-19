public class Nodo<T> {
    private Nodo<T> nodoDerecha;
    private Nodo<T> nodoIzquierda;
    private T dato;
    public Nodo (T dato){
        nodoDerecha = null;
        nodoIzquierda = null;
        this.dato = dato;
    }
    public void setDato (T  dato){
        this.dato = dato;
    }
    public T getDato (){
        return dato;
    }
    public void setNodoDerecha(Nodo<T> nodoDerecha){
        this.nodoDerecha = nodoDerecha;
    }
    public void setNodoIzquierda(Nodo<T> nodoIzquierda){
        this.nodoIzquierda = nodoIzquierda;
    }
    public Nodo<T> getNodoDerecha(){
        return nodoDerecha;
    }
    public Nodo<T> getNodoIzquierda(){
        return nodoIzquierda;
    }
}
