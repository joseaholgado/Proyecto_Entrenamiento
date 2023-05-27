package interfaces;

import javax.swing.JPanel;

import clases.PlanEntrenamiento;

import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class PantallaPanel extends JPanel{
	
	private Ventana ventana;
	
	public PantallaPanel(final Ventana v ){
		this.ventana=v;
		
		//v.planEntrenamiento.calcuEntreno();
		
		setBackground(Color.GREEN);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel etTítulo = new JLabel("¡Bienvenido!");
		etTítulo.setFont(new Font("Arial", Font.PLAIN, 25));
		GridBagConstraints gbc_etTítulo = new GridBagConstraints();
		gbc_etTítulo.insets = new Insets(0, 0, 5, 5);
		gbc_etTítulo.gridx = 2;
		gbc_etTítulo.gridy = 2;
		add(etTítulo, gbc_etTítulo);
		
		JButton btnListado = new JButton("Lista Ejercicios");
		btnListado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaListado.class);
			}
		});
		
		JButton btnPlan = new JButton("Mostrar Entreno");
		btnPlan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaEntreno.class);
			}
		});
		GridBagConstraints gbc_btnPlan = new GridBagConstraints();
		gbc_btnPlan.insets = new Insets(0, 0, 5, 5);
		gbc_btnPlan.gridx = 1;
		gbc_btnPlan.gridy = 7;
		add(btnPlan, gbc_btnPlan);
		GridBagConstraints gbc_btnListado = new GridBagConstraints();
		gbc_btnListado.insets = new Insets(0, 0, 5, 0);
		gbc_btnListado.gridx = 3;
		gbc_btnListado.gridy = 7;
		add(btnListado, gbc_btnListado);
		
		
	}

	
	
	
}
