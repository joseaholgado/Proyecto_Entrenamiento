package interfaces;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class VentanaEmergente extends JDialog {

	public VentanaEmergente(String titulo, String nombre, String descripcion, String imagen, String explicacion) {

		setIconImage(new ImageIcon("./Icono.jpg").getImage());

		setTitle("Detalles del Ejercicio");
		setSize(1000, 400);
		setLocationRelativeTo(null);
		setModal(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel etNombre = new JLabel("");
		etNombre.setText(nombre);
		GridBagConstraints gbc_etNombre = new GridBagConstraints();
		gbc_etNombre.insets = new Insets(0, 0, 5, 5);
		gbc_etNombre.gridx = 8;
		gbc_etNombre.gridy = 1;
		getContentPane().add(etNombre, gbc_etNombre);

		JLabel etTitulo = new JLabel("");
		etTitulo.setText(titulo);
		GridBagConstraints gbc_etTitulo = new GridBagConstraints();
		gbc_etTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_etTitulo.gridx = 8;
		gbc_etTitulo.gridy = 2;
		getContentPane().add(etTitulo, gbc_etTitulo);

		BufferedImage imagen1;

		try {
			imagen1 = ImageIO.read(new File(imagen));
			int ancho = imagen1.getWidth();
			int alto = imagen1.getHeight();
			BufferedImage imgEscalaGris = new BufferedImage(ancho, alto, BufferedImage.TYPE_BYTE_GRAY);
			for (int i = 0; i < alto; i++) {
				for (int j = 0; j < ancho; j++) {
					int rgb = imagen1.getRGB(j, i);
					int promedio = obtenerPromedioGrises(rgb);
					int nuevoRgb = (promedio << 16) | (promedio << 8) | promedio;
					imgEscalaGris.setRGB(j, i, nuevoRgb);
				}
			}
			ImageIO.write(imgEscalaGris, "jpg", new File("imagenGris.jpg"));
			System.out.println("Imagen convertida a escala de grises y guardada correctamente.");
		} catch (IOException e) {
			System.out.println("Error al leer o escribir la imagen");
			e.printStackTrace();
		}

		JLabel etImagen = new JLabel("");
		GridBagConstraints gbc_etImagen = new GridBagConstraints();
		gbc_etImagen.insets = new Insets(0, 0, 5, 5);
		gbc_etImagen.gridx = 2;
		gbc_etImagen.gridy = 5;

		BufferedImage imagen2;
		try {
			imagen2 = ImageIO.read(new File("imagenGris.jpg"));
			Image img = imagen2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			etImagen.setIcon(new ImageIcon(img));
		} catch (IOException e) {

			e.printStackTrace();
		}

		getContentPane().add(etImagen, gbc_etImagen);

		JTextArea textArea = new JTextArea();
		textArea.setText(explicacion);
		textArea.setEditable(false);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 8;
		gbc_textArea.gridy = 5;
		getContentPane().add(textArea, gbc_textArea);

	}

	private int obtenerPromedioGrises(int rgb) {
		int rojo = (rgb >> 16) & 0xFF;
		int verde = (rgb >> 8) & 0xFF;
		int azul = rgb & 0xFF;
		return (rojo + verde + azul) / 3;
	}
}
