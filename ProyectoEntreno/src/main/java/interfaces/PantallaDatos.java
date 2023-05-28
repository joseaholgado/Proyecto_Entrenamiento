package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import clases.Ejercicio;
import clases.Entrenamiento;
import clases.PlanEntrenamiento;
import clases.Series;
import clases.Usuario;
import enumeration.Musculo;
import enumeration.NivelUsuario;
import enumeration.TipoEjercicio;

import javax.swing.JTable;
import javax.swing.ButtonGroup;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;

public class PantallaDatos extends JPanel{
	private Ventana ventana;
	private final ButtonGroup btnZona = new ButtonGroup();
	private final ButtonGroup btnNivel = new ButtonGroup();
	private final ButtonGroup btnDias = new ButtonGroup();
	private final ButtonGroup btnTipoEntreno = new ButtonGroup();
	private byte nivel;
	private byte lugar;
	private byte tipoEntreno;
	private PlanEntrenamiento planE;
	public PantallaDatos(Ventana v) {
		this.ventana=v;
		//this.planE=ventana.planEntrenamieto;
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
		
		JLabel etLugar = new JLabel("¿Dónde quieres entrenar?");
		GridBagConstraints gbc_etLugar = new GridBagConstraints();
		gbc_etLugar.anchor = GridBagConstraints.NORTH;
		gbc_etLugar.insets = new Insets(0, 0, 5, 5);
		gbc_etLugar.gridx = 1;
		gbc_etLugar.gridy = 4;
		add(etLugar, gbc_etLugar);
		
		final JRadioButton checkParque = new JRadioButton("Parque Calistenia");
		checkParque.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(checkParque.isSelected()) {
					nivel=0;
				};
			}
		});
		btnZona.add(checkParque);
		GridBagConstraints gbc_checkParque = new GridBagConstraints();
		gbc_checkParque.anchor = GridBagConstraints.NORTH;
		gbc_checkParque.fill = GridBagConstraints.HORIZONTAL;
		gbc_checkParque.insets = new Insets(0, 0, 5, 5);
		gbc_checkParque.gridx = 1;
		gbc_checkParque.gridy = 5;
		add(checkParque, gbc_checkParque);
		
		final JRadioButton checkGimnasio = new JRadioButton("Gimnasio");
		checkGimnasio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(checkGimnasio.isSelected()) {
					lugar=1;
				};
			}
		});
		btnZona.add(checkGimnasio);
		GridBagConstraints gbc_checkGimnasio = new GridBagConstraints();
		gbc_checkGimnasio.anchor = GridBagConstraints.NORTHWEST;
		gbc_checkGimnasio.insets = new Insets(0, 0, 5, 5);
		gbc_checkGimnasio.gridx = 2;
		gbc_checkGimnasio.gridy = 5;
		add(checkGimnasio, gbc_checkGimnasio);
		
		JLabel etNivel = new JLabel("¿Qué nivel tienes?");
		GridBagConstraints gbc_etNivel = new GridBagConstraints();
		gbc_etNivel.anchor = GridBagConstraints.NORTH;
		gbc_etNivel.insets = new Insets(0, 0, 5, 5);
		gbc_etNivel.gridx = 1;
		gbc_etNivel.gridy = 6;
		add(etNivel, gbc_etNivel);
		
		final JRadioButton checkPrincipiante = new JRadioButton("Principiante");
		checkPrincipiante.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(checkPrincipiante.isSelected()) {
					nivel=1;
				};
			}
		});
		btnNivel.add(checkPrincipiante);
		GridBagConstraints gbc_checkPrincipiante = new GridBagConstraints();
		gbc_checkPrincipiante.anchor = GridBagConstraints.NORTHWEST;
		gbc_checkPrincipiante.insets = new Insets(0, 0, 5, 5);
		gbc_checkPrincipiante.gridx = 1;
		gbc_checkPrincipiante.gridy = 7;
		add(checkPrincipiante, gbc_checkPrincipiante);
		
		final JRadioButton checkIntermedio = new JRadioButton("Intermedio");
		checkIntermedio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(checkIntermedio.isSelected()) {
					nivel=1;
				};
			}
		});
		btnNivel.add(checkIntermedio);
		GridBagConstraints gbc_checkIntermedio = new GridBagConstraints();
		gbc_checkIntermedio.anchor = GridBagConstraints.NORTH;
		gbc_checkIntermedio.fill = GridBagConstraints.HORIZONTAL;
		gbc_checkIntermedio.insets = new Insets(0, 0, 5, 5);
		gbc_checkIntermedio.gridx = 2;
		gbc_checkIntermedio.gridy = 7;
		add(checkIntermedio, gbc_checkIntermedio);
		
		final JRadioButton checkAvanzado = new JRadioButton("Avanzado");
		checkAvanzado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(checkAvanzado.isSelected()) {
					nivel=2;
				};
			}
		});
		btnNivel.add(checkAvanzado);
		GridBagConstraints gbc_checkAvanzado = new GridBagConstraints();
		gbc_checkAvanzado.anchor = GridBagConstraints.NORTHWEST;
		gbc_checkAvanzado.insets = new Insets(0, 0, 5, 0);
		gbc_checkAvanzado.gridx = 3;
		gbc_checkAvanzado.gridy = 7;
		add(checkAvanzado, gbc_checkAvanzado);
		
		JLabel etTipoEntreno = new JLabel("¿En qué quieres enfocarte?");
		GridBagConstraints gbc_etTipoEntreno = new GridBagConstraints();
		gbc_etTipoEntreno.anchor = GridBagConstraints.NORTH;
		gbc_etTipoEntreno.insets = new Insets(0, 0, 5, 5);
		gbc_etTipoEntreno.gridx = 1;
		gbc_etTipoEntreno.gridy = 10;
		add(etTipoEntreno, gbc_etTipoEntreno);
		
		final JRadioButton btnFuerza = new JRadioButton("Fuerza");
		btnFuerza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnFuerza.isSelected()) {
					tipoEntreno=0;
				};
			}
		});
		btnTipoEntreno.add(btnFuerza);
		GridBagConstraints gbc_btnFuerza = new GridBagConstraints();
		gbc_btnFuerza.anchor = GridBagConstraints.NORTH;
		gbc_btnFuerza.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFuerza.insets = new Insets(0, 0, 5, 5);
		gbc_btnFuerza.gridx = 1;
		gbc_btnFuerza.gridy = 11;
		add(btnFuerza, gbc_btnFuerza);
		
		final JRadioButton btnHipertrofia = new JRadioButton("Hipertrofia");
		btnHipertrofia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnHipertrofia.isSelected()) {
					tipoEntreno=1;
				};
			}
		});
		btnTipoEntreno.add(btnHipertrofia);
		GridBagConstraints gbc_btnHipertrofia = new GridBagConstraints();
		gbc_btnHipertrofia.anchor = GridBagConstraints.NORTH;
		gbc_btnHipertrofia.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnHipertrofia.insets = new Insets(0, 0, 5, 5);
		gbc_btnHipertrofia.gridx = 2;
		gbc_btnHipertrofia.gridy = 11;
		add(btnHipertrofia, gbc_btnHipertrofia);
		
		final JRadioButton btnResistencia = new JRadioButton("Resistencia");
		btnResistencia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnResistencia.isSelected()) {
					tipoEntreno=2;
				};
			}
		});
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
				
				try {
					planE=new PlanEntrenamiento(nivel,lugar,tipoEntreno,"lunes",ventana.usuarioLogado.getEmail());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(planE);
				ventana.cambiarAPantalla(PantallaLogin.class);
				
				System.out.println();
			}
		});
		btnRecivirDatos.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnRecivirDatos = new GridBagConstraints();
		gbc_btnRecivirDatos.insets = new Insets(0, 0, 0, 5);
		gbc_btnRecivirDatos.gridx = 2;
		gbc_btnRecivirDatos.gridy = 13;
		add(btnRecivirDatos, gbc_btnRecivirDatos);
		
				
	}
	
	
	
	
	
}
