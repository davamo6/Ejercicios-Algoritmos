package es.upm.dit.algoritmos.ej207;

public class Nodo {
	int valor;
	Nodo izq, der;

	public Nodo(int valor) {
		this.valor = valor;
	}

	public Nodo getIzq() {
		return izq;
	}

	public void setIzq(Nodo izq) {
		this.izq = izq;
	}

	public Nodo getDer() {
		return der;
	}

	public void setDer(Nodo der) {
		this.der = der;
	}

	public int getValor() {
		return valor;
	}

	public static boolean esBST(Nodo nodo) {
		// La raíz no tiene antecesores, así que no está acotada por ningún lado
		return esBSTAux(nodo, null, null);
	}

	// Los límites son los nodos antecesores que acotan el valor: min por debajo y
	// max por arriba. Un límite null significa que ese lado no está acotado
	private static boolean esBSTAux(Nodo nodo, Nodo min, Nodo max) {
		// Caso base: llegar a una hoja (null) es válido
		if (nodo == null) {
			return true;
		}

		// Validación del nodo actual
		// Debe ser estrictamente mayor que min y menor que max
		if (min != null && nodo.valor <= min.valor) {
			return false;
		}
		if (max != null && nodo.valor >= max.valor) {
			return false;
		}

		// Paso recursivo:
		// Subárbol izquierdo: debe ser menor que el nodo actual (nuevo max)
		// Subárbol derecho: debe ser mayor que el nodo actual (nuevo min)
		return esBSTAux(nodo.izq, min, nodo) && esBSTAux(nodo.der, nodo, max);
	}

}