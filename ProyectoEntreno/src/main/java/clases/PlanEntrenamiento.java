package clases;

import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Random;

import enumeration.Musculo;
import enumeration.NivelUsuario;
import enumeration.TipoEjercicio;
import utilidades.DAO;

public class PlanEntrenamiento {

	private ArrayList<Entrenamiento> entreno;
	private String nombreDia;
	private int nivel;
	private int lugar;
	private int tipoEntreno;
	private String email;

	// Con esto obtengo los valores del PantallaDatos.
	public PlanEntrenamiento(byte nivel, byte lugar, byte tipoEntreno, String nombreDia, String email)
			throws SQLException {

		HashMap<String, Object> hs = new HashMap<String, Object>();
		hs.put("nombre", nombreDia);
		hs.put("nivel", nivel);
		hs.put("lugar", lugar);
		hs.put("tipoEntreno", tipoEntreno);
		hs.put("email_usuario", email);

		DAO.insertar("entrenamiento", hs);

		this.nivel = nivel;
		this.lugar = lugar;
		this.tipoEntreno = tipoEntreno;
		this.nombreDia = nombreDia;
		this.email = email;
	}

	public PlanEntrenamiento(String email) throws SQLException {
		LinkedHashSet<String> columnas = new LinkedHashSet<String>();
		columnas.add("email_usuario");
		columnas.add("nombre");
		columnas.add("nivel");
		columnas.add("lugar");
		columnas.add("tipoEntreno");
		HashMap<String, Object> restriccion = new HashMap<String, Object>();
		restriccion.put("email_usuario", email);
		ArrayList<Object> ret = DAO.consultar("entrenamiento", columnas, restriccion);
		String resultadoEmail = (String) ret.get(0);
		if (resultadoEmail.equals(email)) {
			this.email = resultadoEmail;
			this.nombreDia = (String) ret.get(1);
			this.nivel = (Integer) ret.get(2);
			this.lugar = (int) ret.get(3);
			this.tipoEntreno = (int) ret.get(4);
		} else {
			System.out.println("NO VA ");
		}

	}

	public PlanEntrenamiento(byte nivel, byte lugar, byte tipoEntreno, String nombreDia, String email,
			ArrayList<Entrenamiento> entreno) {
		this.nivel = nivel;
		this.lugar = lugar;
		this.tipoEntreno = tipoEntreno;
		this.nombreDia = nombreDia;
		this.email = email;
		this.entreno = entreno;
	}

	public PlanEntrenamiento(ArrayList<Entrenamiento> entreno) {

		this.entreno = entreno;
	}

	public String getEntrenamientos() {
		return nombreDia;
	}

	public void setEntrenamientos(String entrenamientos) {
		this.nombreDia = entrenamientos;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getLugar() {
		return lugar;
	}

	public void setLugar(int lugar) {
		this.lugar = lugar;
	}

	public int getTipoEntreno() {
		return tipoEntreno;
	}

	public void setTipoEntreno(int tipoEntreno) {
		this.tipoEntreno = tipoEntreno;
	}

	@Override
	public String toString() {
		return super.toString() + "PlanEntrenamiento: \nentreno: " + entreno + "\nentrenamientos: " + nombreDia
				+ "\nnivel: " + nivel + "\nlugar: " + lugar + "\ntipoEntreno: " + tipoEntreno;
	}

}
