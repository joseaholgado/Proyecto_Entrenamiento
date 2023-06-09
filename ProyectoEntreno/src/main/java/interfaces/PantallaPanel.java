package interfaces;

import javax.swing.JPanel;

import clases.Entrenamiento;
import clases.PlanEntrenamiento;
import utilidades.Config;

import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;

import auxiliares.interfaces.ReproductorAudio;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

public class PantallaPanel extends JPanel {
	
	private Ventana ventana;
	private PlanEntrenamiento plan;
	private ReproductorAudio reproductor;

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		// ----------------------Musica------------------//

				reproductor = new ReproductorAudio();
				reproductor.reproducir("./Tapion.wav");

				// -----------------------------------------------------
		
		
		try {
			BufferedImage imagen = ImageIO.read(new File("./Meditando.png"));
			g.drawImage(imagen, 0, 0, this);
			g.drawImage(imagen, 0, 0, this.getWidth(), this.getHeight(), new Color(0, 0, 0), null);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	public PantallaPanel(Ventana v) {
		this.ventana = v;

		if(Config.verboseMode) {
		System.out.println(plan);
		}

		setBackground(Color.GREEN);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
				
						JLabel etTítulo = new JLabel("¡Bienvenido!");
						etTítulo.setFont(new Font("Arial", Font.PLAIN, 25));
						GridBagConstraints gbc_etTítulo = new GridBagConstraints();
						gbc_etTítulo.insets = new Insets(0, 0, 5, 5);
						gbc_etTítulo.gridx = 1;
						gbc_etTítulo.gridy = 1;
						add(etTítulo, gbc_etTítulo);
				
						final JButton btnPlan = new JButton("Mostrar Entreno");
						btnPlan.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								reproductor.detener();
								ventana.cambiarAPantalla(PantallaEntreno.class);
							}
							
						});
						GridBagConstraints gbc_btnPlan = new GridBagConstraints();
						gbc_btnPlan.insets = new Insets(0, 0, 5, 5);
						gbc_btnPlan.gridx = 1;
						gbc_btnPlan.gridy = 3;
						add(btnPlan, gbc_btnPlan);
				
						JButton btnListado = new JButton("Lista Ejercicios");
						btnListado.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								reproductor.detener();
								ventana.cambiarAPantalla(PantallaListado.class);
							}
						});
						GridBagConstraints gbc_btnListado = new GridBagConstraints();
						gbc_btnListado.insets = new Insets(0, 0, 5, 5);
						gbc_btnListado.gridx = 1;
						gbc_btnListado.gridy = 4;
						add(btnListado, gbc_btnListado);
						
						JButton btnMaterial = new JButton("Lista Materiales");
						btnMaterial.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								reproductor.detener();
								ventana.cambiarAPantalla(PantallaListado2.class);
							}
						});
						GridBagConstraints gbc_btnMaterial = new GridBagConstraints();
						gbc_btnMaterial.insets = new Insets(0, 0, 5, 5);
						gbc_btnMaterial.gridx = 1;
						gbc_btnMaterial.gridy = 5;
						add(btnMaterial, gbc_btnMaterial);

	}

}
