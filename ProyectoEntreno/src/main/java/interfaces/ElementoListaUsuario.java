package interfaces;

import javax.swing.JPanel;


import clases.Usuario;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Insets;

public class ElementoListaUsuario extends JPanel{
	Ventana ventana;
	Usuario usuarioActual;
	public ElementoListaUsuario(Ventana v, Usuario u) {
		this.ventana=v;
		this.usuarioActual=u;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel etEmail = new JLabel("Pecho");
		etEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_etEmail = new GridBagConstraints();
		gbc_etEmail.insets = new Insets(0, 0, 5, 5);
		gbc_etEmail.gridx = 0;
		gbc_etEmail.gridy = 0;
		add(etEmail, gbc_etEmail);
		
		JLabel etNombre = new JLabel(usuarioActual.getNombre());
		GridBagConstraints gbc_etNombre = new GridBagConstraints();
		gbc_etNombre.insets = new Insets(0, 0, 5, 5);
		gbc_etNombre.gridx = 0;
		gbc_etNombre.gridy = 1;
		add(etNombre, gbc_etNombre);
		
		JButton btnExplicacion = new JButton("+info");
		GridBagConstraints gbc_btnExplicacion = new GridBagConstraints();
		gbc_btnExplicacion.insets = new Insets(0, 0, 5, 0);
		gbc_btnExplicacion.gridx = 6;
		gbc_btnExplicacion.gridy = 1;
		add(btnExplicacion, gbc_btnExplicacion);
		
		JLabel lblEspalda = new JLabel("Espalda");
		lblEspalda.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblEspalda = new GridBagConstraints();
		gbc_lblEspalda.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspalda.gridx = 0;
		gbc_lblEspalda.gridy = 2;
		add(lblEspalda, gbc_lblEspalda);
		
		JButton btnExplicacion_1 = new JButton("+info");
		GridBagConstraints gbc_btnExplicacion_1 = new GridBagConstraints();
		gbc_btnExplicacion_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnExplicacion_1.gridx = 6;
		gbc_btnExplicacion_1.gridy = 3;
		add(btnExplicacion_1, gbc_btnExplicacion_1);
		
		JLabel lblHombros = new JLabel("Hombros");
		lblHombros.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblHombros = new GridBagConstraints();
		gbc_lblHombros.insets = new Insets(0, 0, 5, 5);
		gbc_lblHombros.gridx = 0;
		gbc_lblHombros.gridy = 4;
		add(lblHombros, gbc_lblHombros);
		
		JButton btnExplicacion_2 = new JButton("+info");
		GridBagConstraints gbc_btnExplicacion_2 = new GridBagConstraints();
		gbc_btnExplicacion_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnExplicacion_2.gridx = 6;
		gbc_btnExplicacion_2.gridy = 5;
		add(btnExplicacion_2, gbc_btnExplicacion_2);
		
		JLabel lblBrazos = new JLabel("Brazos");
		lblBrazos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblBrazos = new GridBagConstraints();
		gbc_lblBrazos.insets = new Insets(0, 0, 5, 5);
		gbc_lblBrazos.gridx = 0;
		gbc_lblBrazos.gridy = 6;
		add(lblBrazos, gbc_lblBrazos);
		
		JButton btnExplicacion_3 = new JButton("+info");
		GridBagConstraints gbc_btnExplicacion_3 = new GridBagConstraints();
		gbc_btnExplicacion_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnExplicacion_3.gridx = 6;
		gbc_btnExplicacion_3.gridy = 7;
		add(btnExplicacion_3, gbc_btnExplicacion_3);
		
		JLabel lblPiernas = new JLabel("Piernas");
		lblPiernas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblPiernas = new GridBagConstraints();
		gbc_lblPiernas.insets = new Insets(0, 0, 5, 5);
		gbc_lblPiernas.gridx = 0;
		gbc_lblPiernas.gridy = 8;
		add(lblPiernas, gbc_lblPiernas);
		
		JButton btnExplicacion_4 = new JButton("+info");
		GridBagConstraints gbc_btnExplicacion_4 = new GridBagConstraints();
		gbc_btnExplicacion_4.gridx = 6;
		gbc_btnExplicacion_4.gridy = 9;
		add(btnExplicacion_4, gbc_btnExplicacion_4);
		ventana=v;
		usuarioActual=u;
		
	}

}
