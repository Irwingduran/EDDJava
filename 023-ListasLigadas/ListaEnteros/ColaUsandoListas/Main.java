package ColaUsandoListas;

public class Main {

	public static void main(String[] args) {
		  Cola cola = new Cola();

	        cola.encolar(10);
	        cola.encolar(20);
	        cola.encolar(30);

	        System.out.println("Elemento en el frente: " + cola.verFrente()); // Debería imprimir 10

	        System.out.println("Desencolando elemento: " + cola.desencolar()); // Debería imprimir 10
	        System.out.println("Elemento en el frente: " + cola.verFrente()); // Debería imprimir 20

	        cola.vaciar();
	        System.out.println("La cola está vacía: " + cola.estaVacia()); // Debería imprimir true
	    }
	}


