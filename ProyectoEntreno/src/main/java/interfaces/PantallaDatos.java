package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import clases.Usuario;

import javax.swing.JTable;
import javax.swing.ButtonGroup;

public class PantallaDatos extends JPanel{
	private Ventana ventana;
	private JTextField campoPeso;
	private JTextField campoAltura;
	private final ButtonGroup btnZona = new ButtonGroup();
	private final ButtonGroup btnNivel = new ButtonGroup();
	private final ButtonGroup btnDias = new ButtonGroup();
	private final ButtonGroup btnTipoEntreno = new ButtonGroup();
	
	public PantallaDatos(Ventana v) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hola Guerrero! Antes de nada, necesitamos algunos datos para saber que maestro se ajusta más a tu entrenamiento. Por favor, rellena los campos");
		lblNewLabel.setBounds(10, 10, 667, 65);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		add(lblNewLabel);
		
		JLabel etPeso = new JLabel("¿Cuánto pesas?");
		etPeso.setBounds(39, 85, 124, 13);
		add(etPeso);
		
		campoPeso = new JTextField();
		campoPeso.setBounds(39, 108, 96, 19);
		add(campoPeso);
		campoPeso.setColumns(10);
		
		JLabel etAltura = new JLabel("¿Cuánto mides? (cm)");
		etAltura.setBounds(200, 85, 139, 13);
		add(etAltura);
		
		campoAltura = new JTextField();
		campoAltura.setBounds(200, 108, 96, 19);
		add(campoAltura);
		campoAltura.setColumns(10);
		
		JRadioButton checkPrincipiante = new JRadioButton("Principiante");
		btnNivel.add(checkPrincipiante);
		checkPrincipiante.setBounds(39, 236, 103, 21);
		add(checkPrincipiante);
		
		JRadioButton checkIntermedio = new JRadioButton("Intermedio");
		btnNivel.add(checkIntermedio);
		checkIntermedio.setBounds(153, 236, 103, 21);
		add(checkIntermedio);
		
		JRadioButton checkAvanzado = new JRadioButton("Avanzado");
		btnNivel.add(checkAvanzado);
		checkAvanzado.setBounds(258, 236, 103, 21);
		add(checkAvanzado);
		
		JLabel etNivel = new JLabel("¿Qué nivel tienes?");
		etNivel.setBounds(39, 217, 118, 13);
		add(etNivel);
		
		JLabel etLugar = new JLabel("¿Dónde quieres entrenar?");
		etLugar.setBounds(39, 161, 118, 13);
		add(etLugar);
		
		JRadioButton checkParque = new JRadioButton("Parque Calistenia");
		btnZona.add(checkParque);
		checkParque.setBounds(39, 180, 147, 21);
		add(checkParque);
		
		JRadioButton etGimnasio = new JRadioButton("Gimnasio");
		btnZona.add(etGimnasio);
		etGimnasio.setBounds(258, 180, 103, 21);
		add(etGimnasio);
		
		JLabel etDias = new JLabel("¿Cuántas dias quieres entrenar?");
		etDias.setBounds(39, 278, 153, 13);
		add(etDias);
		
		JRadioButton btn3 = new JRadioButton("3 Días");
		btnDias.add(btn3);
		btn3.setBounds(39, 297, 103, 21);
		add(btn3);
		
		JRadioButton btn4 = new JRadioButton("4 Días");
		btnDias.add(btn4);
		btn4.setBounds(153, 297, 103, 21);
		add(btn4);
		
		JRadioButton btn5 = new JRadioButton("5 Días");
		btnDias.add(btn5);
		btn5.setBounds(258, 297, 103, 21);
		add(btn5);
		
		JLabel etTipoEntreno = new JLabel("¿En qué quieres enfocarte?");
		etTipoEntreno.setBounds(39, 333, 134, 13);
		add(etTipoEntreno);
		
		JRadioButton btnFuerza = new JRadioButton("Fuerza");
		btnTipoEntreno.add(btnFuerza);
		btnFuerza.setBounds(39, 352, 103, 21);
		add(btnFuerza);
		
		JRadioButton btnResistencia = new JRadioButton("Resistencia");
		btnTipoEntreno.add(btnResistencia);
		btnResistencia.setBounds(258, 352, 103, 21);
		add(btnResistencia);
		
		JRadioButton btnHipertrofia = new JRadioButton("Hipertrofia");
		btnTipoEntreno.add(btnHipertrofia);
		btnHipertrofia.setBounds(153, 352, 103, 21);
		add(btnHipertrofia);
		
		
		
	}
	public void obtenerResultado() {
	    // Obtener los valores seleccionados por el usuario
	    float peso = Float.parseFloat(campoPeso.getText());
	    float altura = Float.parseFloat(campoAltura.getText());
	    byte nivel = 0;
	    byte lugar = 0;
	    byte diasEntrenamiento = 0;
	    byte tipoEntreno = 0;

	    // Obtener nivel
	    switch (btnNivel.getSelection().getActionCommand()) {
	        case "Principiante":
	            nivel = 0;
	            break;
	        case "Intermedio":
	            nivel = 1;
	            break;
	        case "Avanzado":
	            nivel = 2;
	            break;
	    }

	    // Obtener lugar
	    switch (btnZona.getSelection().getActionCommand()) {
	        case "Parque Calistenia":
	            lugar = 0;
	            break;
	        case "Gimnasio":
	            lugar = 1;
	            break;
	    }

	    // Obtener días de entrenamiento
	    switch (btnDias.getSelection().getActionCommand()) {
	        case "3 Días":
	            diasEntrenamiento = 0;
	            break;
	        case "4 Días":
	            diasEntrenamiento = 1;
	            break;
	        case "5 Días":
	            diasEntrenamiento = 2;
	            break;
	    }

	    // Obtener tipo de entrenamiento
	    switch (btnTipoEntreno.getSelection().getActionCommand()) {
	        case "Fuerza":
	            tipoEntreno = 0;
	            break;
	        case "Resistencia":
	            tipoEntreno = 1;
	            break;
	        case "Hipertrofia":
	            tipoEntreno = 2;
	            break;
	    }
	    

	}
	
	
	
	
}
