package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import clases.Calculo;
import clases.Usuario;

import javax.swing.JTable;
import javax.swing.ButtonGroup;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaDatos extends JPanel{
	private Ventana ventana;
	private JTextField campoPeso;
	private JTextField campoAltura;
	private final ButtonGroup btnZona = new ButtonGroup();
	private final ButtonGroup btnNivel = new ButtonGroup();
	private final ButtonGroup btnDias = new ButtonGroup();
	private final ButtonGroup btnTipoEntreno = new ButtonGroup();
	
	public PantallaDatos(Ventana v) {
		this.ventana=v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{132, 39, 56, 419, 0};
		gridBagLayout.rowHeights = new int[]{65, 13, 19, 34, 13, 21, 13, 21, 13, 21, 13, 21, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Hola Guerrero! Antes de nada, necesitamos algunos datos para saber que maestro se ajusta más a tu entrenamiento. Por favor, rellena los campos");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel etPeso = new JLabel("¿Cuánto pesas?");
		GridBagConstraints gbc_etPeso = new GridBagConstraints();
		gbc_etPeso.anchor = GridBagConstraints.NORTH;
		gbc_etPeso.insets = new Insets(0, 0, 5, 5);
		gbc_etPeso.gridx = 1;
		gbc_etPeso.gridy = 1;
		add(etPeso, gbc_etPeso);
		
		JLabel etAltura = new JLabel("¿Cuánto mides? (cm)");
		GridBagConstraints gbc_etAltura = new GridBagConstraints();
		gbc_etAltura.anchor = GridBagConstraints.NORTHWEST;
		gbc_etAltura.insets = new Insets(0, 0, 5, 5);
		gbc_etAltura.gridx = 2;
		gbc_etAltura.gridy = 1;
		add(etAltura, gbc_etAltura);
		
		campoPeso = new JTextField();
		GridBagConstraints gbc_campoPeso = new GridBagConstraints();
		gbc_campoPeso.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoPeso.anchor = GridBagConstraints.NORTH;
		gbc_campoPeso.insets = new Insets(0, 0, 5, 5);
		gbc_campoPeso.gridx = 1;
		gbc_campoPeso.gridy = 2;
		add(campoPeso, gbc_campoPeso);
		campoPeso.setColumns(10);
		
		campoAltura = new JTextField();
		GridBagConstraints gbc_campoAltura = new GridBagConstraints();
		gbc_campoAltura.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoAltura.anchor = GridBagConstraints.NORTH;
		gbc_campoAltura.insets = new Insets(0, 0, 5, 5);
		gbc_campoAltura.gridx = 2;
		gbc_campoAltura.gridy = 2;
		add(campoAltura, gbc_campoAltura);
		campoAltura.setColumns(10);
		
		JLabel etLugar = new JLabel("¿Dónde quieres entrenar?");
		GridBagConstraints gbc_etLugar = new GridBagConstraints();
		gbc_etLugar.anchor = GridBagConstraints.NORTH;
		gbc_etLugar.insets = new Insets(0, 0, 5, 5);
		gbc_etLugar.gridx = 1;
		gbc_etLugar.gridy = 4;
		add(etLugar, gbc_etLugar);
		
		JRadioButton checkParque = new JRadioButton("Parque Calistenia");
		btnZona.add(checkParque);
		GridBagConstraints gbc_checkParque = new GridBagConstraints();
		gbc_checkParque.anchor = GridBagConstraints.NORTH;
		gbc_checkParque.fill = GridBagConstraints.HORIZONTAL;
		gbc_checkParque.insets = new Insets(0, 0, 5, 5);
		gbc_checkParque.gridx = 1;
		gbc_checkParque.gridy = 5;
		add(checkParque, gbc_checkParque);
		
		JRadioButton etGimnasio = new JRadioButton("Gimnasio");
		btnZona.add(etGimnasio);
		GridBagConstraints gbc_etGimnasio = new GridBagConstraints();
		gbc_etGimnasio.anchor = GridBagConstraints.NORTHWEST;
		gbc_etGimnasio.insets = new Insets(0, 0, 5, 5);
		gbc_etGimnasio.gridx = 2;
		gbc_etGimnasio.gridy = 5;
		add(etGimnasio, gbc_etGimnasio);
		
		JLabel etNivel = new JLabel("¿Qué nivel tienes?");
		GridBagConstraints gbc_etNivel = new GridBagConstraints();
		gbc_etNivel.anchor = GridBagConstraints.NORTH;
		gbc_etNivel.insets = new Insets(0, 0, 5, 5);
		gbc_etNivel.gridx = 1;
		gbc_etNivel.gridy = 6;
		add(etNivel, gbc_etNivel);
		
		JRadioButton checkPrincipiante = new JRadioButton("Principiante");
		btnNivel.add(checkPrincipiante);
		GridBagConstraints gbc_checkPrincipiante = new GridBagConstraints();
		gbc_checkPrincipiante.anchor = GridBagConstraints.NORTHWEST;
		gbc_checkPrincipiante.insets = new Insets(0, 0, 5, 5);
		gbc_checkPrincipiante.gridx = 1;
		gbc_checkPrincipiante.gridy = 7;
		add(checkPrincipiante, gbc_checkPrincipiante);
		
		JRadioButton checkIntermedio = new JRadioButton("Intermedio");
		btnNivel.add(checkIntermedio);
		GridBagConstraints gbc_checkIntermedio = new GridBagConstraints();
		gbc_checkIntermedio.anchor = GridBagConstraints.NORTH;
		gbc_checkIntermedio.fill = GridBagConstraints.HORIZONTAL;
		gbc_checkIntermedio.insets = new Insets(0, 0, 5, 5);
		gbc_checkIntermedio.gridx = 2;
		gbc_checkIntermedio.gridy = 7;
		add(checkIntermedio, gbc_checkIntermedio);
		
		JRadioButton checkAvanzado = new JRadioButton("Avanzado");
		btnNivel.add(checkAvanzado);
		GridBagConstraints gbc_checkAvanzado = new GridBagConstraints();
		gbc_checkAvanzado.anchor = GridBagConstraints.NORTHWEST;
		gbc_checkAvanzado.insets = new Insets(0, 0, 5, 0);
		gbc_checkAvanzado.gridx = 3;
		gbc_checkAvanzado.gridy = 7;
		add(checkAvanzado, gbc_checkAvanzado);
		
		JLabel etDias = new JLabel("¿Cuántas dias quieres entrenar?");
		GridBagConstraints gbc_etDias = new GridBagConstraints();
		gbc_etDias.anchor = GridBagConstraints.NORTHEAST;
		gbc_etDias.insets = new Insets(0, 0, 5, 5);
		gbc_etDias.gridx = 1;
		gbc_etDias.gridy = 8;
		add(etDias, gbc_etDias);
		
		JRadioButton btn3 = new JRadioButton("3 Días");
		btnDias.add(btn3);
		GridBagConstraints gbc_btn3 = new GridBagConstraints();
		gbc_btn3.anchor = GridBagConstraints.NORTH;
		gbc_btn3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn3.insets = new Insets(0, 0, 5, 5);
		gbc_btn3.gridx = 1;
		gbc_btn3.gridy = 9;
		add(btn3, gbc_btn3);
		
		JRadioButton btn4 = new JRadioButton("4 Días");
		btnDias.add(btn4);
		GridBagConstraints gbc_btn4 = new GridBagConstraints();
		gbc_btn4.anchor = GridBagConstraints.NORTH;
		gbc_btn4.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn4.insets = new Insets(0, 0, 5, 5);
		gbc_btn4.gridx = 2;
		gbc_btn4.gridy = 9;
		add(btn4, gbc_btn4);
		
		JRadioButton btn5 = new JRadioButton("5 Días");
		btnDias.add(btn5);
		GridBagConstraints gbc_btn5 = new GridBagConstraints();
		gbc_btn5.anchor = GridBagConstraints.NORTHWEST;
		gbc_btn5.insets = new Insets(0, 0, 5, 0);
		gbc_btn5.gridx = 3;
		gbc_btn5.gridy = 9;
		add(btn5, gbc_btn5);
		
		JLabel etTipoEntreno = new JLabel("¿En qué quieres enfocarte?");
		GridBagConstraints gbc_etTipoEntreno = new GridBagConstraints();
		gbc_etTipoEntreno.anchor = GridBagConstraints.NORTH;
		gbc_etTipoEntreno.insets = new Insets(0, 0, 5, 5);
		gbc_etTipoEntreno.gridx = 1;
		gbc_etTipoEntreno.gridy = 10;
		add(etTipoEntreno, gbc_etTipoEntreno);
		
		JRadioButton btnFuerza = new JRadioButton("Fuerza");
		btnTipoEntreno.add(btnFuerza);
		GridBagConstraints gbc_btnFuerza = new GridBagConstraints();
		gbc_btnFuerza.anchor = GridBagConstraints.NORTH;
		gbc_btnFuerza.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFuerza.insets = new Insets(0, 0, 5, 5);
		gbc_btnFuerza.gridx = 1;
		gbc_btnFuerza.gridy = 11;
		add(btnFuerza, gbc_btnFuerza);
		
		JRadioButton btnHipertrofia = new JRadioButton("Hipertrofia");
		btnTipoEntreno.add(btnHipertrofia);
		GridBagConstraints gbc_btnHipertrofia = new GridBagConstraints();
		gbc_btnHipertrofia.anchor = GridBagConstraints.NORTH;
		gbc_btnHipertrofia.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnHipertrofia.insets = new Insets(0, 0, 5, 5);
		gbc_btnHipertrofia.gridx = 2;
		gbc_btnHipertrofia.gridy = 11;
		add(btnHipertrofia, gbc_btnHipertrofia);
		
		JRadioButton btnResistencia = new JRadioButton("Resistencia");
		btnTipoEntreno.add(btnResistencia);
		GridBagConstraints gbc_btnResistencia = new GridBagConstraints();
		gbc_btnResistencia.insets = new Insets(0, 0, 5, 0);
		gbc_btnResistencia.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnResistencia.gridx = 3;
		gbc_btnResistencia.gridy = 11;
		add(btnResistencia, gbc_btnResistencia);
		
		JButton btnRecivirDatos = new JButton("Continuar");
		btnRecivirDatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ventana.cambiarAPantalla(PantallaResultado.class);
			}
		});
		btnRecivirDatos.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnRecivirDatos = new GridBagConstraints();
		gbc_btnRecivirDatos.insets = new Insets(0, 0, 0, 5);
		gbc_btnRecivirDatos.gridx = 2;
		gbc_btnRecivirDatos.gridy = 13;
		add(btnRecivirDatos, gbc_btnRecivirDatos);
		
		
		
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
	    

	    ventana.calculo=new Calculo(nivel,lugar,diasEntrenamiento,tipoEntreno);
	    System.out.println(ventana.calculo);
	}
	
	
	
	
}
