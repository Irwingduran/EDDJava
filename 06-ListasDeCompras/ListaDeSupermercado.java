import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class NodoProducto{​​
    String nombre;  //inicio
    NodoProducto siguiente; //fin
    
    public NodoProducto(String nombre) {​​
        this.nombre = nombre;
        this.siguiente = null; 
    }​​
}​​

// Clase ListaDeSupermercado para gestionar la lista de productos
class ListaDeSupermercado{​​
    NodoProducto inicio; 
    String archivo = "supermercado.txt"; // Nombre del archivo de texto
    
    public ListaDeSupermercado(){​​
        this.inicio = null;
        cargarListaDesdeArchivo(); // Cargamos la lista desde el archivo al iniciar
    }​​
    // Método para agregar un producto a la lista y guardar en el archivo
    public void agregarProducto(String nombre){​​
        NodoProducto nuevoProducto = new NodoProducto(nombre);
        if (inicio == null) {​​
            inicio = nuevoProducto;
        }​​ else {​​
            NodoProducto actual = inicio;
            while (actual.siguiente != null){​​
                actual = actual.siguiente; 
            }​​
            actual.siguiente = nuevoProducto; 
        }​​
        guardarListaEnArchivo(); // Guardamos la lista actualizada en el archivo
      //System.out.println("Producto '" + nombre + "' agregado a la lista y guardado en el archivo.");
    }​​
    // Método para cargar la lista desde el archivo
    private void cargarListaDesdeArchivo() {​​
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {​​
            String linea;
            while ((linea = br.readLine()) != null) {​​
                agregarProducto(linea); 
            }​​
        }​​ catch (IOException e) {​​
            System.err.println("Error al cargar la lista desde el archivo: " + e.getMessage());
        }​​
    }​​
    // Método para guardar la lista actual en el archivo
    private void guardarListaEnArchivo(){​​
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {​​
            NodoProducto actual = inicio;
            while (actual != null) {​​
                bw.write(actual.nombre); // Escribimos cada producto en una línea
                bw.newLine();
                actual = actual.siguiente;
            }​​
        }​​ catch (IOException e) {​​
            System.err.println("Error al guardar la lista en el archivo: " + e.getMessage());
        }​​
    }​​
    // Método para imprimir la lista de productos en consola 
    public void imprimirLista() {​​
        NodoProducto actual = inicio;
        if (actual == null) {​​
            System.out.println("La lista de supermercado está vacía.");
        }​​ else {​​
            System.out.println("Lista de Supermercado:");
            while (actual != null) {​​
                System.out.println("- " + actual.nombre);
                actual = actual.siguiente;
            }​​
        }​​
    }​​
    
    // Método para eliminar un producto de la lista
    public void eliminarProducto(String nombre) {​​
    
}​​
   
            
      
public class ListaSupermercadoMain {​​
    public static void main(String[] args) {​​
        ListaDeSupermercado lista = new ListaDeSupermercado();
        try (Scanner scanner = new Scanner(System.in)) {​​
            int opcion;
            do {​​
                System.out.println("\n---- Menu de Opciones Para el control de Productos  ----");
                System.out.println("1. Agregar producto");
                System.out.println("2. Ver lista de productos");
                System.out.println("3. Eliminar productos");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opcion: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer después de leer el número
                
                switch (opcion) {​​
                    case 1 -> {​​
                        System.out.print("Ingrese el nombre del producto a agregar: ");
                        String nombreProducto = scanner.nextLine();
                        lista.agregarProducto(nombreProducto);
                    }​​
                    case 2 -> lista.imprimirLista();
                    case 3 -> {​​
                        System.out.print("Ingrese el nombre del producto a eliminar: ");
                        String nombreProducto = scanner.nextLine();
                        lista.eliminarProducto(nombreProducto);
                    }​​
                     case 4 -> System.out.println("Saliendo del programa...");
                    default -> System.out.println("Opcon no valida. Intente de nuevo.");
                }​​
                
            }​​ while (opcion != 4);
        }​​
       }​​
    }​​
