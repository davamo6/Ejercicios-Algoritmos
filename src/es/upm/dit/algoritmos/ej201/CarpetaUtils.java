package es.upm.dit.algoritmos.ej201;

public class CarpetaUtils {

	public static double calcularPesoTotal(Carpeta inicio) {
	    // Caso base implícito: si la carpeta no tiene archivos ni subcarpetas,
	    // los bucles no se ejecutan y devuelve 0.0.
	    
	    if (inicio == null) return 0.0; // Protección contra null

	    double pesoTotal = 0.0;

	    // Sumar peso de archivos directos
	    if (inicio.getArchivos() != null) {
	        for (Archivo a : inicio.getArchivos()) {
	            pesoTotal += a.getPesoMB();
	        }
	    }

	    // Sumar peso de subcarpetas (Paso recursivo)
	    if (inicio.getSubcarpetas() != null) {
	        for (Carpeta sub : inicio.getSubcarpetas()) {
	            pesoTotal += calcularPesoTotal(sub);
	        }
	    }

	    return pesoTotal;
	}
}
