package ejercicio2;

import java.time.LocalDate;

public class Empleado extends Persona implements ISalario{

	private String posicion;
	private Double salario;
	private LocalDate fechaIngreso;
	
	public Empleado(String nombre, String apellido, Integer edad, String ciudad, String posicion, Double salario,
			LocalDate fechaIngreso) {
		super(nombre, apellido, edad, ciudad);
		this.posicion = posicion;
		this.salario = salario;
		this.fechaIngreso = fechaIngreso;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public Double calculaSalario() {
		if(!this.salario.equals(null)) {
			return this.salario*0.8;
		}
		return null;
	}

	@Override
	public String toString() {
		return "Empleado [posicion=" + posicion + ", salario=" + salario + "]";
	}


	
	
}
