package clases;

import java.awt.image.BufferedImage;
import java.time.LocalTime;

import enumeration.Musculo;
import enumeration.NivelUsuario;
import enumeration.TipoEjercicio;

public class Series extends Ejercicio{

	private byte repeticiones;
	private byte rir;
	private LocalTime descansoEntreEjercicios;
	private byte nseries;
	
	
	public Series(String nombre, String explicacion, BufferedImage imagen, Musculo musculo, NivelUsuario nivelUsuario,
			TipoEjercicio tipoEjercicio, byte repeticiones, byte rir, LocalTime descansoEntreEjercicios) {
		super(nombre, explicacion, imagen, musculo, nivelUsuario, tipoEjercicio);
		this.repeticiones = repeticiones;
		this.rir = rir;
		this.descansoEntreEjercicios = descansoEntreEjercicios;
	}
	
	public Series(String nombre, String explicacion,  Musculo musculo, NivelUsuario nivelUsuario,
			TipoEjercicio tipoEjercicio, byte repeticiones, byte rir, LocalTime descansoEntreEjercicios,byte nseries) {
		super(nombre, explicacion, musculo, nivelUsuario, tipoEjercicio);
		this.setNombre(nombre);
		this.setExplicacion(explicacion);
		this.setMusculo(musculo);
		this.setNivelUsuario(nivelUsuario);
		this.setTipoEjercicio(tipoEjercicio);
		this.repeticiones = repeticiones;
		this.rir = rir;
		this.descansoEntreEjercicios = descansoEntreEjercicios;
		this.nseries=nseries;
	}


	public byte getRepeticiones() {
		return repeticiones;
	}


	public void setRepeticiones(byte repeticiones) {
		this.repeticiones = repeticiones;
	}


	public byte getRir() {
		return rir;
	}


	public void setRir(byte rir) {
		this.rir = rir;
	}


	public LocalTime getDescansoEntreEjercicios() {
		return descansoEntreEjercicios;
	}


	public void setDescansoEntreEjercicios(LocalTime descansoEntreEjercicios) {
		this.descansoEntreEjercicios = descansoEntreEjercicios;
	}


	@Override
	public String toString() {
		return super.toString()+"Series: "
				+"\nNúmero de series del ejercicio: "+nseries  
				+"\nRIR (Máx peso a levantar, hasta sensación del fallo): " + rir 
				+"\nDescanso entre ejercicios: "+ descansoEntreEjercicios 
				+"\nRepeticiones por cada serie: " + repeticiones+"\n";
	}
	
	
	
	
	
}
