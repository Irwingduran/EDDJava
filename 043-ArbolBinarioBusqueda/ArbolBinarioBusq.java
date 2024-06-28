import java.util.Scanner;
 
// Clase NodoBinario, la definición debe estar separada
class NodoBinario {
    NodoBinario left, right;
}
 
// Clase NodoBinarioBusq, extiende NodoBinario
class NodoBinarioBusq extends NodoBinario {
    int clave;
    Object dato;
 
    public NodoBinarioBusq(Object dato, int clave) {
        this.dato = dato;
        this.clave = clave;
    }
}
 
// Clase principal ArbolBinarioBusq
class ArbolBinarioBusq {
    protected NodoBinarioBusq raiz;
 
    // Método para buscar un nodo con una clave específica
    public Object buscar(int claveBuscar) {
        return buscar(claveBuscar, raiz);
    }
 
    // Método privado y recursivo para buscar un nodo con una clave específica
    private static Object buscar(int claveBuscar, NodoBinario n) {
        NodoBinarioBusq nodo = (NodoBinarioBusq) n;
        if (nodo == null) return null;
        
        if (nodo.clave > claveBuscar)
            return buscar(claveBuscar, nodo.left);
        else if (nodo.clave < claveBuscar)
            return buscar(claveBuscar, nodo.right);
        else // nodo.clave == claveBuscar
            return nodo.dato;
    }
 
    // Método para encontrar el valor mínimo almacenado en el árbol
    public Object buscarMin() { 
        return buscarMin(raiz);
    }
 
    // Método privado y recursivo para encontrar el valor mínimo en el subárbol
    private static Object buscarMin(NodoBinario nodo) {
        if (nodo == null) return null;
        if (nodo.left == null) return ((NodoBinarioBusq) nodo).dato;
        else
            return buscarMin(nodo.left);
    }
 
    // Método para encontrar el valor máximo almacenado en el árbol (enfoque iterativo)
    public Object buscarMax() {
        NodoBinario nodo = raiz;
        if (nodo != null) {
            while (nodo.right != null)
                nodo = nodo.right;
            return ((NodoBinarioBusq) nodo).dato;
        } else {
            return null;
        }
    }
 
    // Método para insertar un nuevo nodo en el árbol
    public void insertar(Object dato, int clave) {
        raiz = insertar(dato, clave, raiz);
    }
 
    // Método privado y recursivo para insertar un nuevo nodo
    private static NodoBinarioBusq insertar(Object dato, int clave, NodoBinarioBusq nodo) {
        if (nodo == null)
            nodo = new NodoBinarioBusq(dato, clave);
        else if (clave < nodo.clave)
            nodo.left = insertar(dato, clave, (NodoBinarioBusq) nodo.left);
        else if (clave > nodo.clave)
            nodo.right = insertar(dato, clave, (NodoBinarioBusq) nodo.right);
        else
            System.out.println("Duplicado. Error al insertar!");
 
        return nodo;
    }
 
    // Método para borrar un nodo con una clave específica
    public void borrar(int claveBorrar) {
        raiz = (NodoBinarioBusq) borrar(claveBorrar, raiz);
    }
 
    // Método privado y recursivo para borrar un nodo
    private static NodoBinario borrar(int claveBorrar, NodoBinario nodo) {
        if (nodo == null) {
            System.out.println("Arbol vacio. Error al borrar");
            return null;
        } else if (claveBorrar < ((NodoBinarioBusq) nodo).clave)
            nodo.left = borrar(claveBorrar, nodo.left);
        else if (claveBorrar > ((NodoBinarioBusq) nodo).clave)
            nodo.right = borrar(claveBorrar, nodo.right);
        else if (nodo.left != null && nodo.right != null) {
            ((NodoBinarioBusq) nodo).clave = claveMin(nodo.right);
            ((NodoBinarioBusq) nodo).dato = buscarMin(nodo.right);
            nodo.right = borrarMin(nodo.right);
        } else
            nodo = (nodo.left != null) ? nodo.left : nodo.right;
 
        return nodo;
    }
 
    // Método para encontrar la clave mínima en un subárbol
    private static int claveMin(NodoBinario nodo) {
        if (nodo == null) throw new IllegalArgumentException("Nodo no puede ser null");
        while (nodo.left != null) nodo = nodo.left;
        return ((NodoBinarioBusq) nodo).clave;
    }
 
    // Método para borrar el nodo mínimo en un subárbol
    private static NodoBinario borrarMin(NodoBinario nodo) {
        if (nodo == null) throw new IllegalArgumentException("Nodo no puede ser null");
        if (nodo.left == null) return nodo.right;
        nodo.left = borrarMin(nodo.left);
        return nodo;
    }
}
 
public class Main {
    public static void main(String[] args) {
        ArbolBinarioBusq arbol = new ArbolBinarioBusq();
        Scanner scanner = new Scanner(System.in);
        int opcion;
 
        do {
            System.out.println("Elija una opción:");
            System.out.println("1. Insertar");
            System.out.println("2. Buscar");
            System.out.println("3. Buscar mínimo");
            System.out.println("4. Buscar máximo");
            System.out.println("5. Borrar");
            System.out.println("6. Salir");
            opcion = scanner.nextInt();
 
            switch (opcion) {
                case 1: // Insertar
                    System.out.println("Ingrese clave:");
                    int claveInsertar = scanner.nextInt();
                    System.out.println("Ingrese dato:");
                    String datoInsertar = scanner.next();
                    arbol.insertar(datoInsertar, claveInsertar);
                    System.out.println("Insertado (" + claveInsertar + ", " + datoInsertar + ")");
                    break;
 
                case 2: // Buscar
                    System.out.println("Ingrese clave a buscar:");
                    int claveBuscar = scanner.nextInt();
                    Object resultadoBuscar = arbol.buscar(claveBuscar);
                    if (resultadoBuscar != null) {
                        System.out.println("Encontrado: " + resultadoBuscar);
                    } else {
                        System.out.println("Clave no encontrada.");
                    }
                    break;
 
                case 3: // Buscar mínimo
                    Object minimo = arbol.buscarMin();
                    if (minimo != null) {
                        System.out.println("Valor mínimo: " + minimo);
                    } else {
                        System.out.println("El árbol está vacío.");
                    }
                    break;
 
                case 4: // Buscar máximo
                    Object maximo = arbol.buscarMax();
                    if (maximo != null) {
                        System.out.println("Valor máximo: " + maximo);
                    } else {
                        System.out.println("El árbol está vacío.");
                    }
                    break;
 
                case 5: // Borrar
                    System.out.println("Ingrese clave a borrar:");
                    int claveBorrar = scanner.nextInt();
                    arbol.borrar(claveBorrar);
                    System.out.println("Clave " + claveBorrar + " borrada (si existía).");
                    break;
 
                case 6: // Salir
                    System.out.println("Saliendo...");
                    break;
 
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 6);
 
        scanner.close();
    }
}