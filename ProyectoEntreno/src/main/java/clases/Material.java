package clases;

import java.awt.image.BufferedImage;

public class Material extends ElementoConNombre {

	private String descripcion;
    private BufferedImage imagen;
    
	public Material(String nombre, String descripcion, BufferedImage imagen) {
		super(nombre);
		this.descripcion = descripcion;
		this.imagen = imagen;
	}
	public Material(String nombre, String descripcion) {
		super(nombre);
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public BufferedImage getImagen() {
		return imagen;
	}
	public void setImagen(BufferedImage imagen) {
		this.imagen = imagen;
	}
	@Override
	public String toString() {
		return super.toString()+"Material: \nDescripcion: " + descripcion;
	}

	
}
