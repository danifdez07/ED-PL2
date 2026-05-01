import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- INICIANDO TEST DEL ÁRBOL ---");
        ArbolBinarioDeBusqueda<Integer> miArbol = new ArbolBinarioDeBusqueda<>();

        System.out.println("Añadiendo el 50 ");
        miArbol.add(50);

        System.out.println("Añadiendo el 70 ");
        miArbol.add(70);

        System.out.println("Añadiendo el 30 ");
        miArbol.add(30);

        System.out.println("Añadiendo el 80 ");
        miArbol.add(80);

        System.out.println("Añadiendo el 20 ");
        miArbol.add(20);
        System.out.println("Añadiendo el 65 ");
        miArbol.add(65);
        miArbol.add(67);

        miArbol.imprimirEsquema();
        System.out.println("el grado del valor pedido es " + miArbol.getGrado(65));
        System.out.println("La altura del árbol es: " + miArbol.getAltura());
        ArrayList<Integer> pre = miArbol.getListaPreOrden();
        System.out.println("PreOrden: " + pre);
        ArrayList<Integer> central = miArbol.getListaOrdenCentral();
        System.out.println("Orden Central: " + central);
        ArrayList<Integer> post = miArbol.getListaPostOrden();
        System.out.println("PostOrden: " + post);

        System.out.println("\n--- PRUEBA DE SUBÁRBOLES ---");
        ArbolBinarioDeBusqueda<Integer> ramaIzquierda = miArbol.getSubArbolIzquierda();
        ArbolBinarioDeBusqueda<Integer> ramaDerecha = miArbol.getSubArbolDerecha();
        System.out.println("Orden Central Rama Izquierda: " + ramaIzquierda.getListaOrdenCentral());
        System.out.println("Orden Central Rama Derecha: " + ramaDerecha.getListaOrdenCentral());
    }}
