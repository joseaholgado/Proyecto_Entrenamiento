package interfaces;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PantallaEjercicioListado extends JPanel {
	private Ventana ventana;

	public PantallaEjercicioListado(Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));

		JLabel etNombre = new JLabel("Bienbenid@ ");
		add(etNombre, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);

		JButton btnAtras = new JButton("Atrás");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaLogin.class);
			}
		});
		panel.add(btnAtras);

		JScrollPane lista = new JScrollPane();
		add(lista, BorderLayout.CENTER);

		JPanel contenedorElemento = new JPanel();
		lista.setViewportView(contenedorElemento);
		contenedorElemento.setLayout(new BoxLayout(contenedorElemento, BoxLayout.Y_AXIS));

	}
}
