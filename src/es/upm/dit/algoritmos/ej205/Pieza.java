package es.upm.dit.algoritmos.ej205;

import java.util.ArrayList;
import java.util.List;

public class Pieza {
	private String nombre;
	private boolean esDefectuosa;
	private List<Pieza> componentes; // Piezas necesarias para montar esta

	public Pieza(String nombre, boolean esDefectuosa) {
		this.nombre = nombre;
		this.esDefectuosa = esDefectuosa;
		this.componentes = new ArrayList<Pieza>();
	}

	public String getNombre() {
		return nombre;
	}

	public boolean isDefectuosa() {
		return this.esDefectuosa;
	}

	public List<Pieza> getComponentes() {
		return this.componentes;
	}

	public void addComponente(Pieza componente) {
		this.componentes.add(componente);
	}

	public static boolean contieneDefectos(Pieza piezaPrincipal) {
		if (piezaPrincipal == null)
			return false;

		// Caso base: La pieza actual está defectuosa
		if (piezaPrincipal.isDefectuosa()) {
			return true;
		}

		// Paso recursivo: Verificar componentes
		// Si encontramos uno defectuoso, retornamos true inmediatamente
		if (piezaPrincipal.getComponentes() != null) {
			for (Pieza componente : piezaPrincipal.getComponentes()) {
				if (contieneDefectos(componente)) {
					return true;
				}
			}
		}

		// Ni la pieza ni sus descendientes tienen defectos
		return false;
	}

}