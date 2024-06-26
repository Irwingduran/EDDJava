package ListasEnteros;

public class Nodo {
	
	int dato;
	Nodo enlace;
/****************************************************************************/
	public Nodo(int x) {
		dato = x;
		enlace = null;
	}
/***************************************************************************/
	public int getDato() {
		return dato;
	}
	public Nodo getEnlace() {
		return enlace;
	}
/****************************************************************************/
	public void setEnlace(Nodo enlace) {
		this.enlace=enlace;
	}
}
