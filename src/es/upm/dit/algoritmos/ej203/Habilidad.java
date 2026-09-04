package es.upm.dit.algoritmos.ej203;

import java.util.ArrayList;
import java.util.List;

public class Habilidad {
	private String id;
	private int costePuntos; // Coste para desbloquear esta habilidad
	private List<Habilidad> desbloqueables; // Habilidades que dependen de esta

	public Habilidad(String id, int costePuntos) {
		this.id = id;
		this.costePuntos = costePuntos;
		this.desbloqueables = new ArrayList<Habilidad>();
	}
	
	public String getId() {
		return id;
	}

	public int getCoste() {
		return this.costePuntos;
	}

	public List<Habilidad> getDesbloqueables() {
		return this.desbloqueables;
	}
	
	public void addDesbloqueables(Habilidad desbloqueable) {
		this.desbloqueables.add(desbloqueable);
	}

	public static int costeRamaCompleta(Habilidad raiz) {
	    if (raiz == null) return 0;

	    // Coste de la habilidad actual
	    int total = raiz.getCoste();

	    // Paso recursivo: sumar costes de las habilidades desbloqueables
	    if (raiz.getDesbloqueables() != null) {
	        for (Habilidad h : raiz.getDesbloqueables()) {
	            total += costeRamaCompleta(h);
	        }
	    }

	    return total;
	}
}