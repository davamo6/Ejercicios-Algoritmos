package es.upm.dit.algoritmos.ej210;

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

	public static NodoLista fusionarListas(NodoLista l1, NodoLista l2) {
		// Casos base: si una lista es nula, devolvemos la otra
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		// Paso recursivo: comparar cabeceras
		if (l1.dato <= l2.dato) {
			// l1 es menor: será la cabecera actual.
			// Su siguiente será el resultado de fusionar el resto de l1 con l2
			l1.siguiente = fusionarListas(l1.siguiente, l2);
			return l1;
		} else {
			// l2 es menor
			l2.siguiente = fusionarListas(l1, l2.siguiente);
			return l2;
		}
	}
	
	// Método auxiliar de main()
    // Método para imprimir la lista de forma legible: [1 -> 2 -> null]
    private static void imprimirLista(NodoLista nodo) {
        System.out.print("[");
        while (nodo != null) {
            System.out.print(nodo.dato);
            if (nodo.siguiente != null) System.out.print(" -> ");
            nodo = nodo.siguiente;
        }
        System.out.println("]");
    }

    // Método auxiliar de main()
    // Método para crear una lista fácilmente desde un array de enteros
    private static NodoLista crearLista(int... valores) {
        if (valores.length == 0) return null;
        NodoLista cabeza = new NodoLista(valores[0]);
        NodoLista actual = cabeza;
        for (int i = 1; i < valores.length; i++) {
            actual.siguiente = new NodoLista(valores[i]);
            actual = actual.siguiente;
        }
        return cabeza;
    }

    public static void main(String[] args) {
        // Caso 1: Dos listas normales intercaladas
        System.out.println("--- Caso 1: Listas intercaladas ---");
        NodoLista lista1 = crearLista(1, 3, 5, 7); // Impares
        NodoLista lista2 = crearLista(2, 4, 6, 8); // Pares
        
        System.out.print("Lista 1: "); imprimirLista(lista1);
        System.out.print("Lista 2: "); imprimirLista(lista2);
        
        NodoLista fusionada = fusionarListas(lista1, lista2);
        System.out.print("Resultado fusión: "); 
        imprimirLista(fusionada);

        System.out.println("\n--- Caso 2: Listas de diferente longitud y rangos ---");
        // Lista A con números pequeños, Lista B con números grandes
        NodoLista listaA = crearLista(10, 20);
        NodoLista listaB = crearLista(100, 200, 300, 400);
        
        System.out.print("Lista A: "); imprimirLista(listaA);
        System.out.print("Lista B: "); imprimirLista(listaB);
        
        NodoLista fusionada2 = fusionarListas(listaA, listaB);
        System.out.print("Resultado fusión: "); 
        imprimirLista(fusionada2);
        
        System.out.println("\n--- Caso 3: Una lista vacía (null) ---");
        NodoLista listaLlena = crearLista(5, 5, 5);
        NodoLista listaVacia = null;
        
        System.out.print("Lista Llena: "); imprimirLista(listaLlena);
        System.out.print("Lista Vacía: "); imprimirLista(listaVacia);
        
        NodoLista fusionada3 = fusionarListas(listaLlena, listaVacia);
        System.out.print("Resultado fusión: "); 
        imprimirLista(fusionada3);
    }

}