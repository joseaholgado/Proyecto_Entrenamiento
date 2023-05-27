package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import clases.Usuario;
import exception.UsuarioNoExisteException;
import exception.ContraseñaInvalidaExcepcion;
import exception.UsuarioNoExisteException;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PantallaLogin extends JPanel{
	private Ventana ventana;
	private JTextField campoCorreo;
	private JPasswordField campoContraseña;
	
	public PantallaLogin(Ventana v) {		
		this.ventana=v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{216, 239, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{40, 28, 30, 19, 52, 19, 30, 27, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		JLabel etTitulo = new JLabel("Iniciar Sesión");
		etTitulo.setFont(new Font("Tahoma", Font.ITALIC, 23));
		GridBagConstraints gbc_etTitulo = new GridBagConstraints();
		gbc_etTitulo.anchor = GridBagConstraints.SOUTH;
		gbc_etTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_etTitulo.gridx = 1;
		gbc_etTitulo.gridy = 1;
		add(etTitulo, gbc_etTitulo);
		
		JLabel etCorreo = new JLabel("Email");
		etCorreo.setFont(new Font("Arial", Font.ITALIC, 12));
		GridBagConstraints gbc_etCorreo = new GridBagConstraints();
		gbc_etCorreo.fill = GridBagConstraints.VERTICAL;
		gbc_etCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_etCorreo.gridx = 1;
		gbc_etCorreo.gridy = 2;
		add(etCorreo, gbc_etCorreo);
		
		campoCorreo = new JTextField();
		campoCorreo.setText("Introduzca su email");
		campoCorreo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				campoCorreo.setText("");
			}
		});
		
		JLabel etContraseña = new JLabel("Contraseña");
		etContraseña.setFont(new Font("Arial", Font.ITALIC, 12));
		GridBagConstraints gbc_etContraseña = new GridBagConstraints();
		gbc_etContraseña.fill = GridBagConstraints.VERTICAL;
		gbc_etContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_etContraseña.gridx = 1;
		gbc_etContraseña.gridy = 4;
		add(etContraseña, gbc_etContraseña);
		GridBagConstraints gbc_campoCorreo = new GridBagConstraints();
		gbc_campoCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoCorreo.anchor = GridBagConstraints.SOUTH;
		gbc_campoCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_campoCorreo.gridx = 1;
		gbc_campoCorreo.gridy = 3;
		add(campoCorreo, gbc_campoCorreo);
		campoCorreo.setColumns(10);
		
		campoContraseña = new JPasswordField();
		GridBagConstraints gbc_campoContraseña = new GridBagConstraints();
		gbc_campoContraseña.fill = GridBagConstraints.BOTH;
		gbc_campoContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_campoContraseña.gridx = 1;
		gbc_campoContraseña.gridy = 5;
		add(campoContraseña, gbc_campoContraseña);
		
		final JButton btnSesion = new JButton("Iniciar Sesión");
		btnSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Usuario usuarioLogin;
				String correo = campoCorreo.getText();
				String contraseña = new String(campoContraseña.getPassword());

				boolean comprobar=false;
			
				try {
					usuarioLogin = new Usuario(correo, contraseña);
					comprobar=true;
					if(comprobar) {
						ventana.cambiarAPantalla(PantallaPanel.class);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UsuarioNoExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ContraseñaInvalidaExcepcion e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSesion.setBackground(Color.ORANGE);
				btnSesion.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSesion.setBackground(null);
				btnSesion.setForeground(null);
			}
		});
		
		btnSesion.setBackground(UIManager.getColor("Button.light"));
		btnSesion.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnSesion = new GridBagConstraints();
		gbc_btnSesion.fill = GridBagConstraints.VERTICAL;
		gbc_btnSesion.insets = new Insets(0, 0, 5, 5);
		gbc_btnSesion.gridx = 1;
		gbc_btnSesion.gridy = 6;
		add(btnSesion, gbc_btnSesion);
		
		final JButton btnRegistro = new JButton("Registro");
		btnRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ventana.cambiarAPantalla(PantallaRegistro.class);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistro.setBackground(Color.ORANGE);
				btnRegistro.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegistro.setBackground(null);
				btnRegistro.setForeground(null);
			}
		});
		btnRegistro.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnRegistro = new GridBagConstraints();
		gbc_btnRegistro.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegistro.anchor = GridBagConstraints.NORTH;
		gbc_btnRegistro.gridx = 1;
		gbc_btnRegistro.gridy = 7;
		add(btnRegistro, gbc_btnRegistro);
		
		File archivoImagen=new File("./Login.png");
		try {
			BufferedImage imagen=ImageIO.read(archivoImagen);
			BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	

	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}

