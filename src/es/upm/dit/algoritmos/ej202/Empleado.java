package es.upm.dit.algoritmos.ej202;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
	private String nombre;
	private double salario;
	private List<Empleado> subordinados; // Lista de empleados a su cargo

	public Empleado(String nombre, double salario) {
		this.nombre = nombre;
		this.salario = salario;
		this.subordinados = new ArrayList<Empleado>();
	}

	
	public String getNombre() {
		return nombre;
	}

	public double getSalario() {
		return this.salario;
	}

	public List<Empleado> getSubordinados() {
		return this.subordinados;
	}

	public void addSubordinado(Empleado subordinado) {
		this.subordinados.add(subordinado);
	}

	public static double presupuestoEquipo(Empleado jefe) {
		if (jefe == null)
			return 0.0;

		// El coste incluye el salario del propio jefe
		double total = jefe.getSalario();

		// Paso recursivo: sumar los presupuestos de los subordinados
		if (jefe.getSubordinados() != null) {
			for (Empleado sub : jefe.getSubordinados()) {
				total += presupuestoEquipo(sub);
			}
		}

		return total;
	}
}
