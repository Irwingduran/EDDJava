// Definición de la clase Nodo
public class Nodo {

    int valor;
    Nodo izquierdo, derecho;

    public Nodo(int item) {
        valor = item;
        izquierdo = derecho = null;
    }
}

// Definición de la clase Árbol Binario
class ArbolBinario {
    Nodo raiz;

    // Constructor
    public ArbolBinario() {
        raiz = null;
    }

    // Método para recorrer el árbol en postorden
    void recorridoPostorden(Nodo nodo) {
        if (nodo == null) {
            return;
        }

        // Primero se recorre el subárbol izquierdo
        recorridoPostorden(nodo.izquierdo);
        // Luego se recorre el subárbol derecho
        recorridoPostorden(nodo.derecho);
        // Finalmente se imprime el valor del nodo
        System.out.print(nodo.valor + " ");
    }

    // Método auxiliar para iniciar el recorrido desde la raíz
    void recorridoPostorden() {
        recorridoPostorden(raiz);
    }

    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.raiz = new Nodo(1);
        arbol.raiz.izquierdo = new Nodo(2);
        arbol.raiz.derecho = new Nodo(3);
        arbol.raiz.izquierdo.izquierdo = new Nodo(4);
        arbol.raiz.izquierdo.derecho = new Nodo(5);

        System.out.println("Recorrido en postorden del árbol binario:");
        arbol.recorridoPostorden();
    }
}
