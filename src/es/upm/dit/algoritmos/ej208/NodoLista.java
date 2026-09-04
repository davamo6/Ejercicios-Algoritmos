package es.upm.dit.algoritmos.ej208;

public class NodoLista {
	int dato;
	NodoLista siguiente;

	public NodoLista(int dato) {
		this.dato = dato;
	}

	public NodoLista getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoLista siguiente) {
		this.siguiente = siguiente;
	}

	public int getDato() {
		return dato;
	}

	public static NodoLista invertirRecursivo(NodoLista actual) {
		// Caso base: lista vacía o último elemento
		if (actual == null || actual.siguiente == null) {
			return actual;
		}

		// Paso recursivo: invertir el resto de la lista
		// nuevaCabecera será el último elemento de la lista original
		NodoLista nuevaCabecera = invertirRecursivo(actual.siguiente);

		// Lógica de inversión:
		// actual.siguiente es el nodo que va después del actual.
		// Hacemos que ese nodo apunte hacia atrás (a 'actual').
		actual.siguiente.siguiente = actual;

		// El actual pasa a ser el último (por ahora), así que apunta a null
		actual.siguiente = null;

		return nuevaCabecera;
	}

}