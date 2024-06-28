import java.util.HashMap;
import java.util.Map;

class TablaSimbolos {
    private Map<String, Object> tabla;

    public TablaSimbolos() {
        tabla = new HashMap<>();
    }

    public void insertarVariable(String nombre, String tipo, Object valor) {
        tabla.put(nombre, valor);
    }

    public Object obtenerValorVariable(String nombre) {
        return tabla.get(nombre);
    }

    public void actualizarValorVariable(String nombre, Object valor) {
        if (tabla.containsKey(nombre)) {
            tabla.put(nombre, valor);
        }
    }

    public void eliminarVariable(String nombre) {
        tabla.remove(nombre);
    }
}

public class MiPrograma {

    private static TablaSimbolos tablaSimbolos = new TablaSimbolos();

    public static void main(String[] args) {
        int edad = 25;
        String nombre = "Juan Perez"; 

        tablaSimbolos.insertarVariable("edad", "int", edad);
        tablaSimbolos.insertarVariable("nombre", "String", nombre);

        int edadObtenida = (int) tablaSimbolos.obtenerValorVariable("edad");
        String nombreObtenido = (String) tablaSimbolos.obtenerValorVariable("nombre");

        System.out.println("Edad: " + edadObtenida);
        System.out.println("Nombre: " + nombreObtenido);

        tablaSimbolos.actualizarValorVariable("edad", 26);

        System.out.println("Nueva edad: " + tablaSimbolos.obtenerValorVariable("edad"));

        tablaSimbolos.eliminarVariable("nombre");

        if (tablaSimbolos.obtenerValorVariable("nombre") == null) {
            System.out.println("La variable 'nombre' ha sido eliminada.");
        }
    }
}