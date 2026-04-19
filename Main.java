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
        System.out.println("Añadiendo el 60 ");
        miArbol.add(65);

        System.out.println("--- TEST FINALIZADO SIN ERRORES ---");
        miArbol.imprimirEsquema();
    }}
