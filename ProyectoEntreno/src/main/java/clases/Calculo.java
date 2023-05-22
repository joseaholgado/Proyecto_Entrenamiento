package clases;

import java.time.LocalTime;
import java.util.ArrayList;

import enumeration.Musculo;
import enumeration.NivelUsuario;
import enumeration.TipoEjercicio;

public class Calculo {

	private float peso;
	private float altura;
	private LocalTime tiempoDescanso;
	private byte repeticiones;
	private byte rir;
	private Gimnasio gym;
	private Calistenia calistenia;
	private TipoEjercicio tipoEjercicio;
	private NivelUsuario nivelUsuario;
	private Series series;
	private byte nivel ;
	private byte lugar ;
	private byte diasEntrenamiento ;
	private byte tipoEntreno ;

	//Esta funcion hayo el imc del usuario
	public Calculo(float peso, float altura) {
		float numero = altura;
		float cuadrado = (float) Math.pow(altura, 2);
		float imc=(float) (2/cuadrado);
		
	}
	//Con esto obtengo los valores del PantallaDatos.
	public Calculo(byte nivel, byte lugar, byte diasEntrenamiento, byte tipoEntreno) {
	this.nivel=nivel;
	this.lugar=lugar;
	this.diasEntrenamiento=diasEntrenamiento;
	this.tipoEntreno=tipoEntreno;
	
	switch (nivel) {
	case 0:
		nivelUsuario=NivelUsuario.PRINCIPIANTE;
		break;
	case 1:
		nivelUsuario=NivelUsuario.INTERMEDIO;
		break;
	case 2:
		nivelUsuario=NivelUsuario.AVANZADO;
		break;
	}
	switch (tipoEntreno) {
	case 0:
		tipoEjercicio=TipoEjercicio.FUERZA;
		repeticiones=5;
		rir=1;
		tiempoDescanso=LocalTime.of(0, 5, 0);
		break;
	case 1:
		tipoEjercicio=TipoEjercicio.RESISTENCIA;
		repeticiones=16;
		rir=5;
		tiempoDescanso=LocalTime.of(0, 3, 0);
		break;
	case 2:
		tipoEjercicio=TipoEjercicio.HIPERTROFIA;
		repeticiones=12;
		rir=3;
		tiempoDescanso=LocalTime.of(0, 1, 30);
		break;
	}
	
	Series series=new Series("Sentadilla", "bajar y subir", null, Musculo.CUADRICEPS, nivelUsuario, tipoEjercicio, 
			repeticiones, rir, tiempoDescanso);
	}

	@Override
	public String toString() {
		return "Calculo [nivel=" + nivel + ", lugar=" + lugar + ", diasEntrenamiento=" + diasEntrenamiento
				+ ", tipoEntreno=" + tipoEntreno + "]";
	}
	
}
