package interfaces;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import clases.Ejercicio;
import clases.Entrenamiento;
import clases.Gimnasio;
import clases.Material;
import clases.PlanEntrenamiento;
import clases.Series;
import enumeration.Musculo;
import enumeration.NivelUsuario;
import enumeration.TipoEjercicio;
import utilidades.DAO;

import java.awt.Insets;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class PantallaEntreno extends JPanel {
	private Ventana ventana;

	public PantallaEntreno(Ventana v) {
		this.ventana = v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 630, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel etTitulo = new JLabel("Esta es tu rutina");
		etTitulo.setFont(new Font("Arial", Font.PLAIN, 26));
		GridBagConstraints gbc_etTitulo = new GridBagConstraints();
		gbc_etTitulo.gridwidth = 2;
		gbc_etTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_etTitulo.gridx = 0;
		gbc_etTitulo.gridy = 0;
		add(etTitulo, gbc_etTitulo);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);

		JTextArea textoEntreno = new JTextArea();
		scrollPane.setViewportView(textoEntreno);
		textoEntreno.setText("-------------------------ENTRENAMIENTO---------------------------\n");
		LinkedHashSet<String> lhs = new LinkedHashSet();
		lhs.add("nombre");
		lhs.add("nivel");
		lhs.add("lugar");
		lhs.add("tipoEntreno");
		lhs.add("email_usuario");
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("email_usuario", ventana.usuarioLogado.getEmail());
		ArrayList<Object> consulta = null;
		try {

			consulta = DAO.consultar("entrenamiento", lhs, hm);

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		NivelUsuario nivel = null;
		byte nseries=0;
		switch ((int) consulta.get(1)) {

		case 0:

			nivel = NivelUsuario.PRINCIPIANTE;
			nseries=2;
			break;
		case 1:
			nivel = NivelUsuario.INTERMEDIO;
			nseries=3;
			break;
		case 2:
			nivel = NivelUsuario.AVANZADO;
			nseries=4;
			break;
		}
		
		TipoEjercicio tipoEjercicio = null;
		byte repeticiones =0;
		byte rir=0;
		LocalTime descanso=null;
		switch ((int) consulta.get(3)) {

		case 0:

			tipoEjercicio = TipoEjercicio.FUERZA;
			repeticiones=5;
			rir=1;
			descanso=descanso.of(0, 4, 01);
			break;
		case 1:
			tipoEjercicio = TipoEjercicio.HIPERTROFIA;
			repeticiones=12;
			rir=5;
			descanso=descanso.of(0, 1, 30);
			break;
		case 2:
			tipoEjercicio = TipoEjercicio.RESISTENCIA;
			repeticiones=16;
			rir=3;
			descanso=descanso.of(0, 2, 01);
			break;
		}
		//Cambiar a 0 para GYM
		if((int)consulta.get(2)==1) {
			
		
		}else {
			
			Material material1=new Material("Mancuerna", "barra corta y pesada con un agarre en el centro", null);
			Material material2=new Material("Barra olímpica", "Barra larga y pesada", null);
			Material material3=new Material("Agarre cuerda", "Cuerda en forma de v con enganche en maquina con poleas", null);
			Material material4=new Material("Maquina Jalón", "Consiste en una estructura con asiento, almohadillas para "
					+ "el pecho y una barra o agarre conectado a un sistema de poleas", null);
			Material material5=new Material("Step", "Material de plástico que simula un escalon", null);
			
			ArrayList<Material>listaMaterial=new ArrayList<Material>();
			listaMaterial.add(material1);
			listaMaterial.add(material2);
			listaMaterial.add(material3);
			listaMaterial.add(material4);
			listaMaterial.add(material5);
			Gimnasio gym=new Gimnasio(listaMaterial);
			
			
			//Aqui va todo el Entreno
			Ejercicio ej=new Series("Press Banca", "Levantar barra con el pecho",Musculo.PECTORAL,nivel,tipoEjercicio,
					repeticiones,rir,descanso,nseries);
			Ejercicio ej2=new Series("Press Superior Banca", "Levantar barra con el pecho en banco plano",Musculo.PECTORAL,nivel,tipoEjercicio,
					repeticiones,rir,descanso,nseries);
			
			Ejercicio ej3=new Series("Elevaciones laterales mancuernas", "Levantar macuernas lateralmente hasta altura del hombro",Musculo.DELTOIDES,nivel,tipoEjercicio,
					repeticiones,rir,descanso,nseries);
			Ejercicio ej4=new Series("Press Militar", "Levantar barra desde cuello hasta encima de la cabeza",Musculo.DELTOIDES,nivel,tipoEjercicio,
					repeticiones,rir,descanso,nseries);
			
			Ejercicio ej5=new Series("Sentadilla", "Agacharse y levantarse con barra detras del cuello",Musculo.CUADRICEPS,nivel,tipoEjercicio,
					repeticiones,rir,descanso,nseries);
			Ejercicio ej6=new Series("Peso muerto", "Levantar barra desde el suelo",Musculo.FEMORAL,nivel,tipoEjercicio,
					repeticiones,rir,descanso,nseries);
			
			Ejercicio ej7=new Series("Jalón al pecho", "Traccionar barra de la maquina hasta el pecho",Musculo.DORSAL,nivel,tipoEjercicio,
					repeticiones,rir,descanso,nseries);
			Ejercicio ej8=new Series("Remo mancuerna", "Inclinado 45º apoyado en banco traccionar mancuerna unilateralmente",Musculo.DORSAL,nivel,tipoEjercicio,
					repeticiones,rir,descanso,nseries);
			
			
			Ejercicio ej9=new Series("Curl biceps mancuerna", "Levantar mancuerna horizontal unilateral",Musculo.BICEPS,nivel,tipoEjercicio,
					repeticiones,rir,descanso,nseries);
			Ejercicio ej10=new Series("Curl triceps cuerda", "Levantar mancuerna horizontal unilateral",Musculo.TRICEPS,nivel,tipoEjercicio,
					repeticiones,rir,descanso,nseries);
			
			Ejercicio ej11=new Series("Hip trust", "Desde el suelo y apoyado con un banco la espalda. Levantar barra desde la cadera",Musculo.GLUTEOS,nivel,tipoEjercicio,
					repeticiones,rir,descanso,nseries);
			Ejercicio ej12=new Series("Elevación de gemelos con mancuerna", "Apoyado las puntas en un escalón o step. Dejarse caer el taló y levantarse completamente con mancuerna",Musculo.GEMELOS,nivel,tipoEjercicio,
					repeticiones,rir,descanso,nseries);
			
			ArrayList <Series> listaEj=new ArrayList<Series>();
			listaEj.add((Series) ej);
			listaEj.add((Series) ej2);
		
			ArrayList <Series> listaEj2=new ArrayList<Series>();
			listaEj2.add((Series) ej3);
			listaEj2.add((Series) ej4);
			
			ArrayList <Series> listaEj3=new ArrayList<Series>();
			listaEj3.add((Series) ej5);
			listaEj3.add((Series) ej6);
			
			ArrayList <Series> listaEj4=new ArrayList<Series>();
			listaEj4.add((Series) ej7);
			listaEj4.add((Series) ej8);
			
			ArrayList <Series> listaEj5=new ArrayList<Series>();
			listaEj5.add((Series) ej9);
			listaEj5.add((Series) ej10);
			
			ArrayList <Series> listaEj6=new ArrayList<Series>();
			listaEj6.add((Series) ej11);
			listaEj6.add((Series) ej12);
			
			Entrenamiento entrenamiento=new Entrenamiento("LUNES","Torso",listaEj);
			Entrenamiento entrenamiento2=new Entrenamiento("MARTES","Hombros",listaEj2);
			Entrenamiento entrenamiento3=new Entrenamiento("MIERCOLES","Piernas",listaEj3);
			Entrenamiento entrenamiento4=new Entrenamiento("JUEVES","Espalda",listaEj4);
			Entrenamiento entrenamiento5=new Entrenamiento("VIERNES","Brazos",listaEj5);
			Entrenamiento entrenamiento6=new Entrenamiento("SABADO","Piernas",listaEj6);
			
			ArrayList<Entrenamiento> listaEntrenamiento=new ArrayList<Entrenamiento>();
			listaEntrenamiento.add(entrenamiento);
			listaEntrenamiento.add(entrenamiento2);
			listaEntrenamiento.add(entrenamiento3);
			listaEntrenamiento.add(entrenamiento4);
			listaEntrenamiento.add(entrenamiento5);
			listaEntrenamiento.add(entrenamiento6);
			PlanEntrenamiento planEntreno=new PlanEntrenamiento(listaEntrenamiento);
			
			textoEntreno.setEditable(true);
			textoEntreno.append(planEntreno.toString()+"\n---------------MATERIALES--------------\n"
					+gym.toString());
		   /* textoEntreno.append("---------LUNES--------\n"
			+entrenamiento.toString()+"\n--------------MARTES---------\n"
			+entrenamiento2.toString()+"\n--------------MIERCOLES---------\n"
		    		+entrenamiento3.toString()+"\n--------------JUEVES---------\n"
		    		+entrenamiento4.toString()+"\n--------------VIERNES--------\n"
		    		+entrenamiento5.toString()+"\n--------------SABADO---------\n"
		    		+entrenamiento6.toString());*/
			
		    textoEntreno.setEditable(false);
			
		}
		// ArrayList<Object>lista=DAO.consultar("entrenamiento", null, null)

		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaPanel.class);
			}
		});
		
		GridBagConstraints gbc_btnVolver = new GridBagConstraints();
		gbc_btnVolver.insets = new Insets(0, 0, 0, 5);
		gbc_btnVolver.gridx = 0;
		gbc_btnVolver.gridy = 2;
		add(btnVolver, gbc_btnVolver);
	}
}
