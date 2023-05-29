package clases;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enumeration.Musculo;
import enumeration.NivelUsuario;
import enumeration.TipoEjercicio;

public class Ejercicio extends ElementoConNombre {

	private String descripcion;
	private String explicacion;
	private String imagenLista;
	private String titulo;
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

	public Ejercicio(String nombre, String explicacion, Musculo musculo, NivelUsuario nivelUsuario,
			TipoEjercicio tipoEjercicio) {
		super(nombre);
		this.explicacion = explicacion;
		this.musculo = musculo;
		this.nivelUsuario = nivelUsuario;
		this.tipoEjercicio = tipoEjercicio;

	}

	// Constructor para Ejercicio Listado
	public Ejercicio(String nombre, String titulo, String descripcion, String imagenLista, String explicacion) {
		super(nombre);
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagenLista = imagenLista;
		this.explicacion = explicacion;
	}

	// Para que no proteste la clase Gimnasio
	public Ejercicio() {

	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getExplicacion() {
		return explicacion;
	}

	public void setExplicacion(String explicacion) {
		this.explicacion = explicacion;
	}

	public String getImagenLista() {
		return imagenLista;
	}

	public void setImagenLista(String imagenLista) {
		this.imagenLista = imagenLista;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
		return super.toString() + "Ejercicio: " + "\n Tipo de músculo:" + musculo + "\nNivel: " + nivelUsuario
				+ "\nTipo ejercicio: " + tipoEjercicio + "\nexplicacion: " + explicacion + "\n";
	}

}
