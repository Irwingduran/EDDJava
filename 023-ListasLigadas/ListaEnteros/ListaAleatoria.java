import java.util.*;
import ListasEnteros.*;
public class ListaAleatoria {

	public static void main(String[] args) {
		Random r;
		int d;
		Lista lista;
		int k;
		
		 r = new Random();
		 lista = new Lista();
		 k = Math.abs(r.nextInt()% 55);
		 
		 for(; k > 0; k--) {
			 d = r.nextInt() % 99;
			 lista.insertarCabezaLista(d);
 		 } 
		 
		 System.out.print("Elementos de la lista generados al azar ");
		 lista.visualizar();
		 
	}

}
