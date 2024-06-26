package PilaLe;

public class Pila {
	
	    private Nodo cima;

	    public Pila() {
	        this.cima = null;
	    }

	    // Método para agregar un elemento a la pila (push)
	    public void apilar(int dato) {
	        Nodo nuevoNodo = new Nodo(dato);
	        nuevoNodo.siguiente = cima;
	        cima = nuevoNodo;
	    }

	    // Método para remover un elemento de la pila (pop)
	    public int desapilar() {
	        if (estaVacia()) {
	            throw new RuntimeException("La pila está vacía");
	        }
	        int dato = cima.dato;
	        cima = cima.siguiente;
	        return dato;
	    }

	    // Método para ver el elemento en la cima de la pila sin removerlo (peek)
	    public int verCima() {
	        if (estaVacia()) {
	            throw new RuntimeException("La pila está vacía");
	        }
	        return cima.dato;
	    }

	    // Método para verificar si la pila está vacía
	    public boolean estaVacia() {
	        return cima == null;
	    }

	    // Método para vaciar la pila
	    public void vaciar() {
	        cima = null;
	    }
}


