// Definición de la clase Nodo
class Nodo {
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

    // Método para recorrer el árbol en preorden
    void recorridoPreorden(Nodo nodo) {
        if (nodo == null) {
            return;
        }

        // Primero se imprime el valor del nodo
        System.out.print(nodo.valor + " ");
        // Luego se recorre el subárbol izquierdo
        recorridoPreorden(nodo.izquierdo);
        // Finalmente se recorre el subárbol derecho
        recorridoPreorden(nodo.derecho);
    }

    // Método auxiliar para iniciar el recorrido desde la raíz
    void recorridoPreorden() {
        recorridoPreorden(raiz);
    }

    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.raiz = new Nodo(1);
        arbol.raiz.izquierdo = new Nodo(2);
        arbol.raiz.derecho = new Nodo(3);
        arbol.raiz.izquierdo.izquierdo = new Nodo(4);
        arbol.raiz.izquierdo.derecho = new Nodo(5);


        System.out.println("Recorrido en preorden del árbol binario:");
        arbol.recorridoPreorden();
    }
}