 public static void main(String[] args) {
        ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada();

        // Agregar nodos al final
        lista.agregarAlFinal(1);
        lista.agregarAlFinal(2);
        lista.agregarAlFinal(3);

        // Agregar nodos al inicio
        lista.agregarAlInicio(0);
        lista.agregarAlInicio(-1);

        // Recorrer desde la cabeza
        System.out.println("Recorrido desde la cabeza:");
        lista.recorrerDesdeCabeza();

        // Recorrer desde la cola
        System.out.println("Recorrido desde la cola:");
        lista.recorrerDesdeCola();
    }
}