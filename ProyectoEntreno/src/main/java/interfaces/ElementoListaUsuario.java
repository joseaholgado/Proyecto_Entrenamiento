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
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel etEmail = new JLabel(usuarioActual.getEmail());
		etEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_etEmail = new GridBagConstraints();
		gbc_etEmail.insets = new Insets(0, 0, 5, 5);
		gbc_etEmail.gridx = 0;
		gbc_etEmail.gridy = 0;
		add(etEmail, gbc_etEmail);
		
		JButton btnExplicacion = new JButton("+info");
		GridBagConstraints gbc_btnExplicacion = new GridBagConstraints();
		gbc_btnExplicacion.fill = GridBagConstraints.BOTH;
		gbc_btnExplicacion.gridheight = 3;
		gbc_btnExplicacion.insets = new Insets(0, 0, 5, 0);
		gbc_btnExplicacion.gridx = 6;
		gbc_btnExplicacion.gridy = 0;
		add(btnExplicacion, gbc_btnExplicacion);
		
		JLabel etNombre = new JLabel(usuarioActual.getNombre());
		GridBagConstraints gbc_etNombre = new GridBagConstraints();
		gbc_etNombre.insets = new Insets(0, 0, 5, 5);
		gbc_etNombre.gridx = 0;
		gbc_etNombre.gridy = 1;
		add(etNombre, gbc_etNombre);
		
		JLabel etUsuario = new JLabel(""+usuarioActual.getPlanEntreno());
		GridBagConstraints gbc_etUsuario = new GridBagConstraints();
		gbc_etUsuario.insets = new Insets(0, 0, 0, 5);
		gbc_etUsuario.gridx = 0;
		gbc_etUsuario.gridy = 2;
		add(etUsuario, gbc_etUsuario);
		ventana=v;
		usuarioActual=u;
		
	}

}
