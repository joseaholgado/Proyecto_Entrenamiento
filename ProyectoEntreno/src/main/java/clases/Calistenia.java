package clases;

import java.awt.image.BufferedImage;

import enumeration.Musculo;
import enumeration.NivelUsuario;
import enumeration.TipoEjercicio;

public class Calistenia extends Ejercicio{

	public Calistenia(String nombre, String explicacion, BufferedImage imagen, Musculo musculo,
			NivelUsuario nivelUsuario, TipoEjercicio tipoEjercicio) {
		super(nombre, explicacion, imagen, musculo, nivelUsuario, tipoEjercicio);
		
	}

	

}
