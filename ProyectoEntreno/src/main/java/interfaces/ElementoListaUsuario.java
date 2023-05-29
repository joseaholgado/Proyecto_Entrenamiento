package interfaces;

import javax.swing.JPanel;

import clases.Ejercicio;
import clases.Usuario;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class ElementoListaUsuario extends JPanel {
	Ventana ventana;
	Ejercicio ejLista;

	public ElementoListaUsuario(Ventana v, final Ejercicio ejLista) {
		this.ventana = v;
		this.ejLista = ejLista;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel labelMusculo = new JLabel();
		labelMusculo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		GridBagConstraints gbc_labelEmail = new GridBagConstraints();
		gbc_labelEmail.anchor = GridBagConstraints.WEST;
		gbc_labelEmail.gridwidth = 4;
		gbc_labelEmail.insets = new Insets(0, 0, 5, 5);
		gbc_labelEmail.gridx = 0;
		gbc_labelEmail.gridy = 0;
		add(labelMusculo, gbc_labelEmail);

		JLabel labelEjercicio = new JLabel();
		GridBagConstraints gbc_labelNombre = new GridBagConstraints();
		gbc_labelNombre.anchor = GridBagConstraints.EAST;
		gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombre.gridx = 4;
		gbc_labelNombre.gridy = 0;
		add(labelEjercicio, gbc_labelNombre);

		JButton btnInfo = new JButton("+ Info");
		btnInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaEmergente ventana = new VentanaEmergente(ejLista.getTitulo(), ejLista.getNombre(),
						ejLista.getDescripcion(), ejLista.getImagenLista(), ejLista.getExplicacion());
				ventana.setVisible(true);

			}
		});

		JLabel etTitulo = new JLabel(ejLista.getTitulo());
		etTitulo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_etTitulo = new GridBagConstraints();
		gbc_etTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_etTitulo.gridx = 1;
		gbc_etTitulo.gridy = 1;
		add(etTitulo, gbc_etTitulo);

		JLabel etNombre = new JLabel(ejLista.getNombre());
		etNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_etNombre = new GridBagConstraints();
		gbc_etNombre.insets = new Insets(0, 0, 5, 5);
		gbc_etNombre.gridx = 1;
		gbc_etNombre.gridy = 2;
		add(etNombre, gbc_etNombre);

		JTextPane textPanelDescripcion = new JTextPane();
		textPanelDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_textPanelDescripcion = new GridBagConstraints();
		gbc_textPanelDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_textPanelDescripcion.fill = GridBagConstraints.BOTH;
		gbc_textPanelDescripcion.gridx = 1;
		gbc_textPanelDescripcion.gridy = 3;
		textPanelDescripcion.setText(ejLista.getDescripcion());
		add(textPanelDescripcion, gbc_textPanelDescripcion);

		JLabel etImagen = new JLabel("");
		GridBagConstraints gbc_etImagen = new GridBagConstraints();
		gbc_etImagen.insets = new Insets(0, 0, 5, 5);
		gbc_etImagen.gridx = 8;
		gbc_etImagen.gridy = 3;
		add(etImagen, gbc_etImagen);
		GridBagConstraints gbc_btnInfo = new GridBagConstraints();
		gbc_btnInfo.insets = new Insets(0, 0, 5, 0);
		gbc_btnInfo.gridx = 13;
		gbc_btnInfo.gridy = 3;

		BufferedImage imagen;
		try {
			imagen = ImageIO.read(new File(ejLista.getImagenLista()));
			Image img = imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			etImagen.setIcon(new ImageIcon(img));
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}

		add(btnInfo, gbc_btnInfo);

		ventana = v;

	}

}
