package clases;

import java.util.ArrayList;

public class Entrenamiento extends ElementoConNombre {

	private ArrayList<Series> ejercicios;
	private String descripcion;

	public Entrenamiento(String nombre, String descripcion, ArrayList<Series> ejercicios) {
		super(nombre);
		this.ejercicios = ejercicios;
		this.descripcion = descripcion;
	}

	public ArrayList<Series> getEjercicios() {
		return ejercicios;
	}

	public void setEjercicios(ArrayList<Series> ejercicios) {
		this.ejercicios = ejercicios;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return super.toString() + "Entrenamiento: "
				+ "\nEjercicio a hacer: " + ejercicios 
				+ "\nParte del cuerpo: " + descripcion 
				+ "\n";
	}

}
