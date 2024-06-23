package cola_usando_listas;

public class Cola {
	private Nodo frente;
    private Nodo fondo;

    public Cola() {
        this.frente = null;
        this.fondo = null;
    }

    // Método para agregar un elemento a la cola (enqueue)
    public void encolar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (estaVacia()) {
            frente = nuevoNodo;
            fondo = nuevoNodo;
        } else {
            fondo.siguiente = nuevoNodo;
            fondo = nuevoNodo;
        }
    }

    // Método para remover un elemento de la cola (dequeue)
    public int desencolar() {
        if (estaVacia()) {
            throw new RuntimeException("La cola está vacía");
        }
        int dato = frente.dato;
        frente = frente.siguiente;
        if (frente == null) {
            fondo = null;
        }
        return dato;
    }

    // Método para ver el elemento en el frente de la cola sin removerlo (peek)
    public int verFrente() {
        if (estaVacia()) {
            throw new RuntimeException("La cola está vacía");
        }
        return frente.dato;
    }

    // Método para verificar si la cola está vacía
    public boolean estaVacia() {
        return frente == null;
    }

    // Método para vaciar la cola
    public void vaciar() {
        frente = null;
        fondo = null;
}
}