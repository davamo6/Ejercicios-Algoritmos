package es.upm.dit.algoritmos.ej204;

import java.util.ArrayList;
import java.util.List;

public class ElementoHTML {
	private String tag; // Ejemplo: "div", "p", "img"
	private List<ElementoHTML> hijos;

	public ElementoHTML(String tag) {
		this.tag = tag;
		this.hijos = new ArrayList<ElementoHTML>();
	}

	public String getTag() {
		return this.tag;
	}

	public List<ElementoHTML> getHijos() {
		return this.hijos;
	}

	public void addHijo(ElementoHTML hijo) {
		this.hijos.add(hijo);
	}

	public static int contarEtiquetas(ElementoHTML elemento, String tagBuscado) {
		if (elemento == null || tagBuscado == null)
			return 0;

		int contador = 0;

		// Comprobar si el elemento actual coincide
		if (elemento.getTag().equals(tagBuscado)) {
			contador = 1;
		}

		// Paso recursivo: buscar en los hijos
		if (elemento.getHijos() != null) {
			for (ElementoHTML hijo : elemento.getHijos()) {
				contador += contarEtiquetas(hijo, tagBuscado);
			}
		}

		return contador;
	}

}