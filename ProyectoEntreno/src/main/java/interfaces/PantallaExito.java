package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaExito extends JPanel {

	private Ventana ventana;
	
	public PantallaExito(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JLabel etTitulo = new JLabel("¡Te has registrado exitosamente!");
		etTitulo.setForeground(Color.WHITE);
		etTitulo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 22));
		etTitulo.setBounds(120, 166, 384, 53);
		add(etTitulo);
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaDatos.class);
			}
		});
		btnInicio.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnInicio.setBounds(257, 219, 85, 38);
		add(btnInicio);
		
		JLabel etTitulo2 = new JLabel("¡Comienza tu aventura en la escuela tortuga!");
		etTitulo2.setForeground(Color.WHITE);
		etTitulo2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 22));
		etTitulo2.setBounds(120, 101, 495, 108);
		add(etTitulo2);
		
		JLabel etImagen = new JLabel("");
		etImagen.setIcon(new ImageIcon("C:\\Users\\josea\\Desktop\\Otros Proyecto Entreno\\Registro\\Felicitaciones Mod.png"));
		etImagen.setBounds(0, 0, 676, 476);
		add(etImagen);
		
		
}
}
