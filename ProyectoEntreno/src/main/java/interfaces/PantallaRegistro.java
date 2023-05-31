package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;

import clases.Usuario;
import exception.NombreConNumerosException;
import utilidades.Config;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.swing.JList;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import com.toedter.calendar.JCalendar;

import java.time.LocalTime;
import com.toedter.calendar.JDateChooser;
import java.sql.Date;
import java.time.LocalDate;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PantallaRegistro extends JPanel {

	private Ventana ventana;
	private JTextField campoNombre;
	private JTextField campoCorreo;
	private JPasswordField campoContraseña;

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		try {
			BufferedImage imagen = ImageIO.read(new File("./Registro.png"));
			g.drawImage(imagen, 0, 0, this);
			g.drawImage(imagen, 0, 0, this.getWidth(), this.getHeight(), new Color(0, 0, 0), null);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public PantallaRegistro(Ventana v) {
		this.ventana = v;
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/mm/dd");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 51, 194, 210, 333, 0 };
		gridBagLayout.rowHeights = new int[] { 36, 33, 13, 19, 13, 19, 18, 67, 32, 46, 29, 2, 50, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel etRegistro = new JLabel("¡Regístrate y cambiate!");
		etRegistro.setFont(new Font("Arial", Font.ITALIC, 18));
		GridBagConstraints gbc_etRegistro = new GridBagConstraints();
		gbc_etRegistro.fill = GridBagConstraints.VERTICAL;
		gbc_etRegistro.insets = new Insets(0, 0, 5, 0);
		gbc_etRegistro.gridx = 3;
		gbc_etRegistro.gridy = 0;
		add(etRegistro, gbc_etRegistro);

		JLabel etNombre = new JLabel("Nombre");
		etNombre.setFont(new Font("Arial", Font.ITALIC, 12));
		GridBagConstraints gbc_etNombre = new GridBagConstraints();
		gbc_etNombre.fill = GridBagConstraints.VERTICAL;
		gbc_etNombre.insets = new Insets(0, 0, 5, 0);
		gbc_etNombre.gridx = 3;
		gbc_etNombre.gridy = 1;
		add(etNombre, gbc_etNombre);

		campoNombre = new JTextField();
		campoNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				campoNombre.setText("");
			}
		});
		campoNombre.setText("Introduzca su nombre");
		GridBagConstraints gbc_campoNombre = new GridBagConstraints();
		gbc_campoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNombre.anchor = GridBagConstraints.NORTH;
		gbc_campoNombre.insets = new Insets(0, 0, 5, 0);
		gbc_campoNombre.gridx = 3;
		gbc_campoNombre.gridy = 2;
		add(campoNombre, gbc_campoNombre);
		campoNombre.setColumns(10);

		JLabel etCorreo = new JLabel("Correo electrónico");
		etCorreo.setFont(new Font("Arial", Font.ITALIC, 12));
		GridBagConstraints gbc_etCorreo = new GridBagConstraints();
		gbc_etCorreo.fill = GridBagConstraints.VERTICAL;
		gbc_etCorreo.insets = new Insets(0, 0, 5, 0);
		gbc_etCorreo.gridx = 3;
		gbc_etCorreo.gridy = 3;
		add(etCorreo, gbc_etCorreo);

		campoCorreo = new JTextField();
		campoCorreo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				campoCorreo.setText("");
			}
		});
		campoCorreo.setText("Introduzca su email");
		GridBagConstraints gbc_campoCorreo = new GridBagConstraints();
		gbc_campoCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoCorreo.anchor = GridBagConstraints.NORTH;
		gbc_campoCorreo.insets = new Insets(0, 0, 5, 0);
		gbc_campoCorreo.gridx = 3;
		gbc_campoCorreo.gridy = 4;
		add(campoCorreo, gbc_campoCorreo);
		campoCorreo.setColumns(10);

		JLabel etFecha = new JLabel("Fecha de nacimiento");
		etFecha.setFont(new Font("Arial", Font.ITALIC, 12));
		GridBagConstraints gbc_etFecha = new GridBagConstraints();
		gbc_etFecha.fill = GridBagConstraints.VERTICAL;
		gbc_etFecha.insets = new Insets(0, 0, 5, 0);
		gbc_etFecha.gridx = 3;
		gbc_etFecha.gridy = 5;
		add(etFecha, gbc_etFecha);

		final JCalendar caleFecha = new JCalendar();
		GridBagConstraints gbc_caleFecha = new GridBagConstraints();
		gbc_caleFecha.gridheight = 4;
		gbc_caleFecha.insets = new Insets(0, 0, 5, 0);
		gbc_caleFecha.fill = GridBagConstraints.BOTH;
		gbc_caleFecha.gridx = 3;
		gbc_caleFecha.gridy = 6;
		add(caleFecha, gbc_caleFecha);

		JLabel etContraseña = new JLabel("Contraseña");
		etContraseña.setFont(new Font("Arial", Font.ITALIC, 12));
		GridBagConstraints gbc_etContraseña = new GridBagConstraints();
		gbc_etContraseña.insets = new Insets(0, 0, 5, 0);
		gbc_etContraseña.gridx = 3;
		gbc_etContraseña.gridy = 10;
		add(etContraseña, gbc_etContraseña);

		campoContraseña = new JPasswordField();
		GridBagConstraints gbc_campoContraseña = new GridBagConstraints();
		gbc_campoContraseña.insets = new Insets(0, 0, 5, 0);
		gbc_campoContraseña.fill = GridBagConstraints.BOTH;
		gbc_campoContraseña.gridx = 3;
		gbc_campoContraseña.gridy = 11;
		add(campoContraseña, gbc_campoContraseña);

		JButton btnRegistro = new JButton("Pulsa para registrarte");
		btnRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre = campoNombre.getText();
				String email = campoCorreo.getText();
				String contraseña = new String(campoContraseña.getPassword());
				String contraseñaUsuario = null;

				Date fechaDate = new Date(caleFecha.getDate().getTime());
				SimpleDateFormat formatoFecha = new SimpleDateFormat("d/MM/yyyy");
				String fechaFormateada = formatoFecha.format(fechaDate);
				if(Config.verboseMode) {
				System.out.println(fechaFormateada);
				}
				LocalDate fecha = caleFecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				if(Config.verboseMode) {
				System.out.println(fecha);
				}

				try {
					if (nombre.matches(".*\\d.*")) {
						throw new NombreConNumerosException("El nombre no puede contener números");
					}

					ventana.usuarioLogado = new Usuario(nombre, email, contraseña, fecha);
					JOptionPane.showMessageDialog(ventana,
							"Su registro ha sido exitoso " + ventana.usuarioLogado.getNombre(), "Registro exitoso",
							JOptionPane.INFORMATION_MESSAGE);
					ventana.cambiarAPantalla(PantallaExito.class);
					// Usuario usuarioRegistro=new Usuario(nombre, email, contraseña, fecha);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Registro fallido",
							JOptionPane.INFORMATION_MESSAGE);
					e1.printStackTrace();
				} catch (NombreConNumerosException n) {
					JOptionPane.showMessageDialog(ventana, n.getMessage(), "Nombre inválido",
							JOptionPane.ERROR_MESSAGE);
				} catch (Exception e3) {
					// Captura de cualquier otra excepción no esperada
					JOptionPane.showMessageDialog(ventana, "Error en el registro: " + e3.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
					e3.printStackTrace();
				}
				
			}
		});

		btnRegistro.setFont(new Font("Arial", Font.ITALIC, 15));
		GridBagConstraints gbc_btnRegistro = new GridBagConstraints();
		gbc_btnRegistro.gridx = 3;
		gbc_btnRegistro.gridy = 12;
		add(btnRegistro, gbc_btnRegistro);

	}
}
