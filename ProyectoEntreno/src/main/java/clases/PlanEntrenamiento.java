package clases;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

import enumeration.Musculo;
import enumeration.NivelUsuario;
import enumeration.TipoEjercicio;

public class PlanEntrenamiento {

	private ArrayList<Entrenamiento> entrenamientos;
	
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
	private byte tipoEntreno ;

	
	//Con esto obtengo los valores del PantallaDatos.
	public PlanEntrenamiento(byte nivel, byte lugar, byte tipoEntreno) {
	this.nivel=nivel;
	this.lugar=lugar;
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
	if(lugar==1) {
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
	}else {
		switch (tipoEntreno) {
		case 0:
			tipoEjercicio=TipoEjercicio.FUERZA;
			repeticiones=15;
			rir=3;
			tiempoDescanso=LocalTime.of(0, 1, 30);
			break;
		case 1:
			tipoEjercicio=TipoEjercicio.RESISTENCIA;
			repeticiones=30;
			rir=0;
			tiempoDescanso=LocalTime.of(0, 5, 0);
			break;
		case 2:
			tipoEjercicio=TipoEjercicio.HIPERTROFIA;
			repeticiones=20;
			rir=2;
			tiempoDescanso=LocalTime.of(0, 3, 0);
			break;
		}
		
	}
	this.calcuEntreno();
	
		
	}
	
	public void calcuEntreno() {

		Random r=new Random();
		
		
		ArrayList<Series> pecho=new ArrayList<Series>();
		Series pch1=new Series("Press banca", "subida y bajada de barra", null, Musculo.PECTORAL, nivelUsuario, tipoEjercicio,(byte) repeticiones,(byte) rir, tiempoDescanso);
		Series pch2=new Series("Press superior", "banco inclinado. Subida y bajada de mancuernas", null, Musculo.PECTORAL, nivelUsuario, tipoEjercicio,(byte) repeticiones,(byte) rir, tiempoDescanso);
		pecho.add(pch1);
		pecho.add(pch2);
		ArrayList<Series> espalda=new ArrayList<Series>();
		Series ds1=new Series("Dominadas", "Subir desde la bajada llegando hasta la garganta", null, Musculo.DORSAL, nivelUsuario, tipoEjercicio,(byte) repeticiones,(byte) rir, tiempoDescanso);
		Series ds2=new Series("Extensión unilateral maquina", "Traccionar máquina hasta el dorsal", null, Musculo.DORSAL, nivelUsuario, tipoEjercicio,(byte) repeticiones,(byte) rir, tiempoDescanso);
		espalda.add(ds1);
		espalda.add(ds2);
		ArrayList<Series> hombro=new ArrayList<Series>();
		Series hb1=new Series("Press militar", "Subida y bajada desde hombro en barra", null, Musculo.DELTOIDES, nivelUsuario, tipoEjercicio,(byte) repeticiones,(byte) rir, tiempoDescanso);
		Series hb2=new Series("Press pájaro", "inclinado hacia abajo brazos caidos y elevar brazos al exterior", null, Musculo.DELTOIDES, nivelUsuario, tipoEjercicio,(byte) repeticiones,(byte) rir, tiempoDescanso);
		hombro.add(hb1);
		hombro.add(hb2);
		ArrayList<Series> brazo=new ArrayList<Series>();
		Series br1=new Series("martillo", "desde brazo hacia abajo subir de manera vertical la mancuerna", null, Musculo.TRICEPS, nivelUsuario, tipoEjercicio,(byte) repeticiones,(byte) rir, tiempoDescanso);
		Series br2=new Series("tras nuca", "de espalda de la maquina con cuerda trccionar desde encima de la nuca hacia el frente", null, Musculo.BICEPS, nivelUsuario, tipoEjercicio,(byte) repeticiones,(byte) rir, tiempoDescanso);
		brazo.add(br1);
		brazo.add(br2);
		ArrayList<Series> pierna=new ArrayList<Series>();
		Series sr=new Series("Sentadilla", "Ejecutar subida y bajada", null, Musculo.CUADRICEPS, nivelUsuario, tipoEjercicio,(byte) repeticiones,(byte) rir, tiempoDescanso);
		Series sr2=new Series("Peso Muerto", "Ejecutar desde bajada a subida", null, Musculo.FEMORAL, nivelUsuario, tipoEjercicio,(byte) repeticiones,(byte) rir, tiempoDescanso);
		Series sr3=new Series("Sentadilla Bulgara", "Ejecutarla a una pierna", null, Musculo.CUADRICEPS, nivelUsuario, tipoEjercicio,(byte) repeticiones,(byte) rir, tiempoDescanso);
		pierna.add(sr);
		pierna.add(sr2);
		pierna.add(sr3);
		
		
	    byte guardado=(byte) r.nextInt(0,pecho.size()-1);
	    byte guardado2=(byte) r.nextInt(0,espalda.size()-1);
	    byte guardado3=(byte) r.nextInt(0,hombro.size()-1);
	    byte guardado4=(byte) r.nextInt(0,brazo.size()-1);
	    byte guardado5=(byte) r.nextInt(0,pierna.size()-1);
	    
		Entrenamiento et=new Entrenamiento("Tren superior",new ArrayList<Series>(), "Pecho");
		et.getEjercicios().add(pecho.get(guardado));
		Entrenamiento et2=new Entrenamiento("Tren superior",new ArrayList<Series>(), "Espalda");
		et2.getEjercicios().add(espalda.get(guardado2));
		Entrenamiento et3=new Entrenamiento("Tren superior",new ArrayList<Series>(), "Espalda");
		et3.getEjercicios().add(hombro.get(guardado3));
		Entrenamiento et4=new Entrenamiento("Tren superior",new ArrayList<Series>(), "Espalda");
		et4.getEjercicios().add(brazo.get(guardado4));
		Entrenamiento et5=new Entrenamiento("Tren inferior",new ArrayList<Series>(), "Pienas");
		et5.getEjercicios().add(pierna.get(guardado5));
		
		ArrayList <Entrenamiento> entrenamiento=new ArrayList<Entrenamiento>();
		entrenamiento.add(et);
		entrenamiento.add(et2);
		entrenamiento.add(et3);
		entrenamiento.add(et4);
		entrenamiento.add(et5);
		
		this.setEntrenamientos(entrenamiento);
	}

	


	public ArrayList<Entrenamiento> getEntrenamientos() {
		return entrenamientos;
	}

	public void setEntrenamientos(ArrayList<Entrenamiento> entrenamientos) {
		this.entrenamientos = entrenamientos;
	}

	public LocalTime getTiempoDescanso() {
		return tiempoDescanso;
	}

	public void setTiempoDescanso(LocalTime tiempoDescanso) {
		this.tiempoDescanso = tiempoDescanso;
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

	public Gimnasio getGym() {
		return gym;
	}

	public void setGym(Gimnasio gym) {
		this.gym = gym;
	}

	public Calistenia getCalistenia() {
		return calistenia;
	}

	public void setCalistenia(Calistenia calistenia) {
		this.calistenia = calistenia;
	}

	public TipoEjercicio getTipoEjercicio() {
		return tipoEjercicio;
	}

	public void setTipoEjercicio(TipoEjercicio tipoEjercicio) {
		this.tipoEjercicio = tipoEjercicio;
	}

	public NivelUsuario getNivelUsuario() {
		return nivelUsuario;
	}

	public void setNivelUsuario(NivelUsuario nivelUsuario) {
		this.nivelUsuario = nivelUsuario;
	}

	public Series getSeries() {
		return series;
	}

	public void setSeries(Series series) {
		this.series = series;
	}

	public byte getNivel() {
		return nivel;
	}

	public void setNivel(byte nivel) {
		this.nivel = nivel;
	}

	public byte getLugar() {
		return lugar;
	}

	public void setLugar(byte lugar) {
		this.lugar = lugar;
	}

	public byte getTipoEntreno() {
		return tipoEntreno;
	}

	public void setTipoEntreno(byte tipoEntreno) {
		this.tipoEntreno = tipoEntreno;
	}

	@Override
	public String toString() {
		return "Calculo [nivel=" + nivel + ", lugar=" + lugar+ ", tipoEntreno=" + tipoEntreno + "]";
	}
	

}
