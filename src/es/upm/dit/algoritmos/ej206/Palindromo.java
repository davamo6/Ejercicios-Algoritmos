package es.upm.dit.algoritmos.ej206;

public class Palindromo {

	public static boolean esPalindromo(String texto) {
		// Casos base: longitud 0 o 1 siempre es palíndromo
		if (texto == null || texto.length() <= 1) {
			return true;
		}

		// Comprobar extremos
		char primero = texto.charAt(0);
		char ultimo = texto.charAt(texto.length() - 1);

		if (primero != ultimo) {
			return false;
		}

		// Paso recursivo: llamar con la subcadena interior
		return esPalindromo(texto.substring(1, texto.length() - 1));
	}

}
