package es.upm.dit.algoritmos.ej201;

//Representa un archivo con un tamaño específico
public class Archivo {
	private String nombre;
	private double pesoMB; // Tamaño en Megabytes

	public Archivo(String nombre, double peso) {
		this.nombre = nombre;
		this.pesoMB = peso;
	}

	
	public String getNombre() {
		return nombre;
	}

	public double getPesoMB() {
		return this.pesoMB;
	}
}
