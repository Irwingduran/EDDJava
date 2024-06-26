package PilaLe;

public class Main {

	public static void main(String[] args) {
		   Pila pila = new Pila();

	        pila.apilar(10);
	        pila.apilar(20);
	        pila.apilar(30);

	        System.out.println("Elemento en la cima: " + pila.verCima()); // Debería imprimir 30

	        System.out.println("Desapilando elemento: " + pila.desapilar()); // Debería imprimir 30
	        System.out.println("Elemento en la cima: " + pila.verCima()); // Debería imprimir 20

	        pila.vaciar();
	        System.out.println("La pila está vacía: " + pila.estaVacia()); // Debería imprimir true
	    }
	}


