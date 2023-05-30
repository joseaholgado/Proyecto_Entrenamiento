package interfaces;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import clases.Ejercicio;
import clases.Entrenamiento;
import clases.Usuario;
import utilidades.DAO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class PantallaListado extends JPanel {
	private Ventana ventana;

	
	public PantallaListado(Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));

		JLabel etNombre = new JLabel("Bienbenid@ " + ventana.usuarioLogado.getNombre());
		add(etNombre, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);

		JButton btnAtras = new JButton("Atrás");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaPanel.class);
			}
		});
		panel.add(btnAtras);

		////////// Pantalla interior

		JScrollPane lista = new JScrollPane();
		add(lista, BorderLayout.CENTER);

		JPanel contenedorElemento = new JPanel();
		lista.setViewportView(contenedorElemento);
		contenedorElemento.setLayout(new BoxLayout(contenedorElemento, BoxLayout.Y_AXIS));

		ArrayList<Object> listaEjercicio = new ArrayList<Object>();
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		lhs.add("titulo");
		lhs.add("nombre");
		lhs.add("descripcion");
		lhs.add("imagen");
		lhs.add("explicacion");
		HashMap<String, Object> hs = new HashMap();

		try {
			listaEjercicio = DAO.consultar("listaEjercicio", lhs, hs);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// For para que me repita objetos del panel en pantalla
		for (byte i = 0; i < listaEjercicio.size(); i += 5) {
			String titulo = (String) listaEjercicio.get(i);
			String nombre = (String) listaEjercicio.get(i + 1);
			String descripcion = (String) listaEjercicio.get(i + 2);
			String imagen = (String) listaEjercicio.get(i + 3);
			String explicacion = (String) listaEjercicio.get(i + 4);

			Ejercicio ej = new Ejercicio(titulo, nombre, descripcion, imagen, explicacion);
			contenedorElemento.add(new ElementoListaUsuario(ventana, ej));

		}

	}
}
