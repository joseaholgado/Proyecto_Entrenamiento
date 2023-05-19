package clases;

import java.util.ArrayList;

import enumeration.Musculo;
import enumeration.NivelUsuario;
import enumeration.TipoEjercicio;

public class Calculo {

	private byte nivel ;
	private byte lugar ;
	private byte diasEntrenamiento ;
	private byte tipoEntreno ;

	public Calculo(byte nivel, byte lugar, byte diasEntrenamiento, byte tipoEntreno) {
	this.nivel=nivel;
	this.lugar=lugar;
	this.diasEntrenamiento=diasEntrenamiento;
	this.tipoEntreno=tipoEntreno;
	}

	@Override
	public String toString() {
		return "Calculo [nivel=" + nivel + ", lugar=" + lugar + ", diasEntrenamiento=" + diasEntrenamiento
				+ ", tipoEntreno=" + tipoEntreno + "]";
	}
	
}
