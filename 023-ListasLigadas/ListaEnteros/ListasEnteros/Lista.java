/*
	 * Clase lista  con las operaciones: insertar por la cabeza y visualizar 
	 * (recorre los nodos)para mostrar los datos.Además el atributo primero
	 * , que apunta al primer nodo */

package ListasEnteros;

public class Lista {
	
	protected Nodo primero;
	
	/***********************************************************************/
	public Lista() {
		primero = null;
	}
	
	/******************************************************************************/
	public Lista insertarCabezaLista(int entrada) {
		Nodo nuevo;
		nuevo=new Nodo(entrada);  
		nuevo.enlace = primero; //Enlaza nuevo nodo al frente de la lista 
		primero = nuevo;		//mueve primero y apunta al nuevo nodo 
		return this;			//devuelve referencia del objeto Lista 
	}
	
	/*********************************************************************************/
	
	public void visualizar() {
		Nodo n;
		int k = 0;
		n = primero;
		while(n != null) {
			System.out.print(n.dato + " ");
			n = n.enlace;
			k++;
			System.out.print((k%15 != 0 ? " " : "\n"));
		}
	}
	
	/*************************************************************************************/
	public Lista insertarUltimo(Nodo ultimo, int entrada) {
		ultimo.enlace = new Nodo(entrada);
		ultimo = ultimo.enlace;
		return this;
	}
	/**********************************************************************************/
	//metodo insertar en medio de la lista 
	public Lista insertarLista(Nodo anterior, int entrada) {
		Nodo nuevo = new Nodo(entrada);
		nuevo.enlace = anterior.enlace;
		return this;
	}
	
	/*********************************************************************************/
	//metodo busqueda 
	public Nodo buscarLista(int destino) {
		Nodo indice;
		for(indice = primero; indice != null; indice = indice.enlace) 
			if(destino == indice.dato)  //(destino.equals(indice.dato))
			return indice;
			return null;
	}
	
	/**********************************************************************************/
	//eliminacion de un nodo 
	public void eliminar(int entrada) {
		Nodo actual,anterior;
		boolean encontrado;
		//inicializa los apuntadores 
		actual = primero;
		anterior = null;
		encontrado = false;
		// busqueda del nodo y del anterior
		while ((actual != null) && (!encontrado)) {
			encontrado = (actual.dato == entrada);
			// con objetos: actual.dato.equals(entrada)
			if(!encontrado) {
				anterior=actual;
				actual= actual.enlace;
			}
		}
		//Enlace del nodo anterior con el siguiente 
		if (actual != null) {
			//distingue entre que el nodo sea el cabecera,
			//o del resto de la lista 
			if (actual == primero) {
				primero = actual.enlace;
			}
			else {
				anterior.enlace = actual.enlace;
			}
			actual = null; 
		}
	}
/*************************************************************************************/
	
}
