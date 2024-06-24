import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> cola = new LinkedList<>();

        // Agregar elementos a la cola
        cola.offer("X");
        cola.offer("Y");
        cola.offer("Z");

        // Imprimir la cola
        System.out.println("Contenido de la cola: " + cola);

        // Mirar el primer elemento de la cola sin eliminarlo
        String primerElemento = cola.peek();
        System.out.println("Primer elemento de la cola: " + primerElemento);

        // Eliminar el primer elemento de la cola
        String elementoEliminado = cola.poll();
        System.out.println("Elemento eliminado: " + elementoEliminado);

        // Imprimir la cola después de eliminar el primer elemento
        System.out.println("Contenido de la cola después de eliminar el primer elemento: " + cola);

        // Verificar si la cola está vacía
        boolean estaVacia = cola.isEmpty();
        System.out.println("¿La cola está vacía? " + estaVacia);
    }
}
