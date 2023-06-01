package clases;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enumeration.Musculo;
import enumeration.NivelUsuario;
import enumeration.TipoEjercicio;

public class Gimnasio extends Ejercicio{
	
	private ArrayList<Material> material;

	public Gimnasio(String nombre, String explicacion, BufferedImage imagen, Musculo musculo, NivelUsuario nivelUsuario,
			TipoEjercicio tipoEjercicio, ArrayList<Material> material) {
		super(nombre, explicacion, imagen, musculo, nivelUsuario, tipoEjercicio);
		this.material = material;
	}
	public Gimnasio (ArrayList<Material> material) {
		super();
		this.material=material;
	}

	public ArrayList<Material> getMaterial() {
		return material;
	}

	public void setMaterial(ArrayList<Material> material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return super.toString()+"Gimnasio: "
				+ "\nNombre: "+nombre
				+"\nMaterial: " + material;
	}

	

}
