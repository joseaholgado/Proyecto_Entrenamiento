package clases;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enumeration.Musculo;
import enumeration.NivelUsuario;
import enumeration.TipoEjercicio;

public class Ejercicio extends ElementoConNombre{

	private String explicacion;
	private BufferedImage imagen;
	private Musculo musculo;
	private NivelUsuario nivelUsuario; 
	private TipoEjercicio tipoEjercicio;
	
	public Ejercicio(String nombre, String explicacion, BufferedImage imagen, Musculo musculo,
			NivelUsuario nivelUsuario, TipoEjercicio tipoEjercicio) {
		super(nombre);
		this.explicacion = explicacion;
		this.imagen = imagen;
		this.musculo = musculo;
		this.nivelUsuario = nivelUsuario;
		this.tipoEjercicio = tipoEjercicio;
		
		
	}
	public Ejercicio(String nombre, String explicacion, Musculo musculo,
			NivelUsuario nivelUsuario, TipoEjercicio tipoEjercicio) {
		super(nombre);
		this.explicacion = explicacion;
		this.musculo = musculo;
		this.nivelUsuario = nivelUsuario;
		this.tipoEjercicio = tipoEjercicio;
		
		
	}


	public Ejercicio(NivelUsuario nivelUsuario, TipoEjercicio tipoEjercicio) {
		this.setNombre("Press Banca");
		this.explicacion="Levantar barra en banco plano";
		this.musculo=Musculo.PECTORAL;
		this.nivelUsuario=nivelUsuario;
		this.tipoEjercicio=tipoEjercicio;
	}

	public String getExplicacion() {
		return explicacion;
	}

	public void setExplicacion(String explicacion) {
		this.explicacion = explicacion;
	}

	public BufferedImage getImagen() {
		return imagen;
	}

	public void setImagen(BufferedImage imagen) {
		this.imagen = imagen;
	}

	public Musculo getMusculo() {
		return musculo;
	}

	public void setMusculo(Musculo musculo) {
		this.musculo = musculo;
	}

	public NivelUsuario getNivelUsuario() {
		return nivelUsuario;
	}

	public void setNivelUsuario(NivelUsuario nivelUsuario) {
		this.nivelUsuario = nivelUsuario;
	}

	public TipoEjercicio getTipoEjercicio() {
		return tipoEjercicio;
	}

	public void setTipoEjercicio(TipoEjercicio tipoEjercicio) {
		this.tipoEjercicio = tipoEjercicio;
	}

	@Override
	public String toString() {
		return "Ejercicio [explicacion=" + explicacion + ", imagen=" + imagen + ", musculo=" + musculo
				+ ", nivelUsuario=" + nivelUsuario + ", tipoEjercicio=" + tipoEjercicio + "]";
	}
	
	
	
}
