package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;

import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;

import clases.Usuario;
import exception.FechaConLetras;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
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
public class PantallaRegistro extends JPanel{

	private Ventana ventana;
	private JTextField campoNombre;
	private JTextField campoCorreo;
	private JPasswordField campoContraseña;
	
	public PantallaRegistro(Ventana v) {
		this.ventana = v;
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/mm/dd");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{51, 194, 210, 333, 0};
		gridBagLayout.rowHeights = new int[]{36, 33, 13, 19, 13, 19, 13, 19, 32, 46, 51, 2, 50, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		campoCorreo = new JTextField();
		campoCorreo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				campoCorreo.setText("");
			}
		});
		
		campoNombre = new JTextField();
		campoNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				campoNombre.setText("");
			}
		});
		
		JLabel etRegistro = new JLabel("¡Regístrate y cambiate!");
		etRegistro.setFont(new Font("Arial", Font.ITALIC, 18));
		GridBagConstraints gbc_etRegistro = new GridBagConstraints();
		gbc_etRegistro.fill = GridBagConstraints.VERTICAL;
		gbc_etRegistro.insets = new Insets(0, 0, 5, 5);
		gbc_etRegistro.gridx = 2;
		gbc_etRegistro.gridy = 1;
		add(etRegistro, gbc_etRegistro);
		
		JLabel etNombre = new JLabel("Nombre");
		etNombre.setFont(new Font("Arial", Font.ITALIC, 12));
		GridBagConstraints gbc_etNombre = new GridBagConstraints();
		gbc_etNombre.fill = GridBagConstraints.VERTICAL;
		gbc_etNombre.insets = new Insets(0, 0, 5, 5);
		gbc_etNombre.gridx = 2;
		gbc_etNombre.gridy = 2;
		add(etNombre, gbc_etNombre);
		campoNombre.setText("Introduzca su nombre");
		GridBagConstraints gbc_campoNombre = new GridBagConstraints();
		gbc_campoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNombre.anchor = GridBagConstraints.NORTH;
		gbc_campoNombre.insets = new Insets(0, 0, 5, 5);
		gbc_campoNombre.gridx = 2;
		gbc_campoNombre.gridy = 3;
		add(campoNombre, gbc_campoNombre);
		campoNombre.setColumns(10);
		
		JLabel etCorreo = new JLabel("Correo electrónico");
		etCorreo.setFont(new Font("Arial", Font.ITALIC, 12));
		GridBagConstraints gbc_etCorreo = new GridBagConstraints();
		gbc_etCorreo.fill = GridBagConstraints.VERTICAL;
		gbc_etCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_etCorreo.gridx = 2;
		gbc_etCorreo.gridy = 4;
		add(etCorreo, gbc_etCorreo);
		campoCorreo.setText("Introduzca su email");
		GridBagConstraints gbc_campoCorreo = new GridBagConstraints();
		gbc_campoCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoCorreo.anchor = GridBagConstraints.NORTH;
		gbc_campoCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_campoCorreo.gridx = 2;
		gbc_campoCorreo.gridy = 5;
		add(campoCorreo, gbc_campoCorreo);
		campoCorreo.setColumns(10);
		
		JLabel etFecha = new JLabel("Fecha de nacimiento");
		etFecha.setFont(new Font("Arial", Font.ITALIC, 12));
		GridBagConstraints gbc_etFecha = new GridBagConstraints();
		gbc_etFecha.fill = GridBagConstraints.VERTICAL;
		gbc_etFecha.insets = new Insets(0, 0, 5, 5);
		gbc_etFecha.gridx = 2;
		gbc_etFecha.gridy = 6;
		add(etFecha, gbc_etFecha);
		
		final JDateChooser caleFecha = new JDateChooser();
		GridBagConstraints gbc_caleFecha = new GridBagConstraints();
		caleFecha.setForeground(new Color(0, 0, 0));
		caleFecha.setDateFormatString("dd/mm/yyyy");
		gbc_caleFecha.insets = new Insets(0, 0, 5, 5);
		gbc_caleFecha.fill = GridBagConstraints.BOTH;
		gbc_caleFecha.gridx = 2;
		gbc_caleFecha.gridy = 7;
		add(caleFecha, gbc_caleFecha);
		
		JLabel etContraseña = new JLabel("Contraseña");
		etContraseña.setFont(new Font("Arial", Font.ITALIC, 12));
		GridBagConstraints gbc_etContraseña = new GridBagConstraints();
		gbc_etContraseña.fill = GridBagConstraints.VERTICAL;
		gbc_etContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_etContraseña.gridx = 2;
		gbc_etContraseña.gridy = 9;
		add(etContraseña, gbc_etContraseña);
		
		campoContraseña = new JPasswordField();
		GridBagConstraints gbc_campoContraseña = new GridBagConstraints();
		gbc_campoContraseña.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_campoContraseña.gridx = 2;
		gbc_campoContraseña.gridy = 10;
		add(campoContraseña, gbc_campoContraseña);
		
		JButton btnRegistro = new JButton("Pulsa para registrarte");
		btnRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre=campoNombre.getText();
				String email=campoCorreo.getText();
				String contraseña=new String (campoContraseña.getPassword());
				String contraseñaUsuario=null;
				
				Date fechaDate=new Date (caleFecha.getDate().getTime());	
				LocalDate fecha = fechaDate.toLocalDate();
				System.out.println(fechaDate);
				
				try {
					ventana.usuarioLogado=new Usuario(nombre, email, contraseña, fecha);
					JOptionPane.showMessageDialog(ventana, "Su registro ha sido exitoso "+ventana.usuarioLogado.getNombre(), "Registro exitoso",
							JOptionPane.INFORMATION_MESSAGE);
					Usuario usuarioRegistro=new Usuario(nombre, email, contraseña, fecha);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Registro fallido",
							JOptionPane.INFORMATION_MESSAGE);
					e1.printStackTrace();
				}catch ( FechaConLetras e1) {
					JOptionPane.showMessageDialog(ventana, "Has introducido letras en la fecha ", "Registro fallido",
							JOptionPane.INFORMATION_MESSAGE);
					e1.printStackTrace();
				}
				ventana.cambiarAPantalla(PantallaExito.class);
				
			}
		});
		
		
		btnRegistro.setFont(new Font("Arial", Font.ITALIC, 15));
		GridBagConstraints gbc_btnRegistro = new GridBagConstraints();
		gbc_btnRegistro.fill = GridBagConstraints.BOTH;
		gbc_btnRegistro.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegistro.gridx = 2;
		gbc_btnRegistro.gridy = 12;
		add(btnRegistro, gbc_btnRegistro);
		
		
		
		
		
		
		
		
	
}
}
