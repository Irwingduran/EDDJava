package grafos;

import java.util.ArrayList;

// Clase que representa un vértice en el grafo
class Vertice {
  // 3atributos
    private String nombre;  // Nombre del vértice
    private int index;  // Índice del vértice en el grafo
    private boolean visitado;  // Indica si el vértice ha sido visitado en los recorridos

    // Constructor que inicia el vertice con un nombre y un indice
    public Vertice(String nombre, int index) {
        this.nombre = nombre;
        this.index = index;
    }

    // Constructor que inicia el vertice con un nombre y un indice predeterminado de 1
    public Vertice(String nombre) {
        this(nombre, 1);
    }

    // Getter para obtener el nombre del vertice
    public String getNombre() {
        return nombre;
    }

    // Setter para establecer el nombre del vertice
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para ver si el vertice ha sido visitado
    public boolean isVisitado() {
        return visitado;
    }

    // Setter para marcar el vertice como visitado o no visitado
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    // Setter para establecer el indice del vertice
    public void setIndex(int index) {
        this.index = index;
    }

    // Getter para obtener el indice del vertice
    public int getIndex() {
        return index;
    }
}

// Clase que representa el grafo
public class Grafo {

    private ArrayList<Vertice> vertices;  // Lista de vertices del grafo
    private int[][] A;   // Matriz de adyacencia
    private int orden;  // Numero máximo de vertices 
    private int pos;  // Numero actual de vertices
    private String recorrido1 = "", recorrido2 = "";  // Almacena los recorridos DFS y BFS

    // Constructor que inicializa el grafo con un numero de vertices y si es dirigido o no
    public Grafo(int n, boolean dirigido) {
        vertices = new ArrayList<>();  // Inicializa la lista de vertices
        A = new int[n][n];  // Inicializa la matriz de adyacencia
        orden = n;  // Establece el número máximo de vértices
        pos = 0;  // Inicializa el número de vértices actuales
    }

    // Constructor que inicializa el grafo con un numero de vertices (no dirigido por defecto)
    public Grafo(int n) {
        this(n, false);  // Llama al constructor principal
    }

    // Constructor por defecto que inicializa el grafo con un maximo de 15 vertices
    public Grafo() {
        this(15);  // Llama al constructor con 15 vertices
    }

    // Metodo para agregar un vértice al grafo
    public void agregaVertice(String nom) { //crea vertice al grafo
        if (pos < orden) {  // Ve si no se alcanzo el maximo de vertices
            Vertice v = new Vertice(nom, pos);  // Crea un nuevo vertice
            vertices.add(pos, v);  // Agrega el vertice a la lista
            pos++;  // Incrementa el contador de vertices
        } else {
            System.out.println("Numero de vertices excedido");  // Mensaje de error si se excede el numero máximo de vértices
        }
    }

    // Metodo para agregar una arista predeterminado de 1 entre dos vértices
    public void agregaArista(String vo, String vd) {
        int a = 0, b = 0;  // Inicia los índices de los vértices
        for (Vertice v : vertices) {  // Recorre la lista de vértices
            if (vo.equals(v.getNombre())) {  // Busca el índice del vértice origen
                a = v.getIndex(); //guarda
            }
            if (vd.equals(v.getNombre())) {  // Busca el índice del vértice destino
                b = v.getIndex();
            }
        }
        A[a][b] = 1;  // Establece conexion a la matriz de adyacencia
    }


    // Método para mostrar la matriz de adyacencia
    public void mostrarMatriz() {
        System.out.println("\nMatriz de Adyacencia");
        for (int i = 0; i < pos; i++) {  // recorre sobre las filas de la matriz Comienza en 0 y termina en pos - 1, donde pos es el número de vértices actualmente en el grafo.
            for (int j = 0; j < pos; j++) {  // recorre sobre las columnas de la matriz También comienza en 0 y termina en pos - 1.
                System.out.print(A[i][j] + " ");  // Imprime el valor de la celda
            }
            System.out.println("");  // Nueva línea al final de cada fila
        }
    }

    // Método para mostrar la lista de vértices
    public void mostrarVertices() {
        System.out.println("\nLista de vertices");
        for (Vertice v : vertices) {  // recorre sobre la lista de vértices
            System.out.println("Vertice: " + v.getNombre());  // Imprime el nombre de cada vértice
        }
    }

    // Método para realizar un recorrido en profundidad (DFS)
    void DFS(String vi) {
        int i = 0;  // declara entero, indice del vértice inicial
        for (Vertice v : vertices) {  //recorre la lista de los vertices
            if (vi.equals(v.getNombre())) { // Encuentra el vértice de inicio
                v.setVisitado(true);  // Marca el vértice como visitado
                recorrido1 += v.getNombre() + ", ";  // guarda el nombre del vértice al recorrido
                i = v.getIndex();  // Obtiene el índice del vértice
            }
        }
        for (int j = 0; j < pos; j++) {  // Recorre la matriz de adyacencia
            if (A[i][j] != 0) {  // Si hay una arista
                for (Vertice vk : vertices) {  // Encuentra el vértice adyacente
                    if (j == vk.getIndex() && !vk.isVisitado()) {  //busca un verice adyacente que no este visitado
                        DFS(vk.getNombre());  // Realiza DFS recursivamente
                    }
                }
            }
        }
    }

    // Método para realizar un recorrido en anchura (BFS)
    void BFS(String vi) {
        int i = 0;  // Índice del vértice inicial
        for (Vertice v : vertices) {  // Encuentra el vértice de inicio
            if (vi.equals(v.getNombre())) {
                v.setVisitado(true);  // Marca el vértice como visitado
                recorrido2 += v.getNombre() + ", ";  // Agrega el nombre del vértice al recorrido
                i = v.getIndex();  // Obtiene el índice del vértice
            }
        }
        while (i < pos) {  // Recorre todos los vértices
            for (int j = 0; j < pos; j++) {  // Recorre la matriz de adyacencia
                if (A[i][j] != 0) {  // Si hay una arista
                    for (Vertice vk : vertices) {  // Encuentra el vértice adyacente
                        if (j == vk.getIndex() && !vk.isVisitado()) {  // Si no ha sido visitado
                            vk.setVisitado(true);  // Marca el vértice como visitado
                            recorrido2 += vk.getNombre() + ", ";  // Agrega el nombre del vértice al recorrido
                        }
                    }
                }
            }
            i++;  // Pasa al siguiente vértice
        }
    }

    // Imprime el recorrido DFS
    void MostrarDFS() {
        System.out.println("\nRecorrido DFS: " + recorrido1);  
    }

    // Imprime el recorrido BFS
    void MostrarBFS() {
        System.out.println("\nRecorrido BFS: " + recorrido2); 
    }

    // Método para reiniciar el estado de los vértices a no visitados
    void reinicio() {
        for (Vertice v : vertices) {  // recorre sobre la lista de vértices
            v.setVisitado(false);  // Marca todos los vértices como no visitados
        }
    }
}
