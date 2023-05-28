package interfaces;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import clases.Entrenamiento;
import clases.Usuario;
import utilidades.DAO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class PantallaListado extends JPanel{
	private Ventana ventana;
	
	public PantallaListado(Ventana v) {
	this.ventana=v;
	setLayout(new BorderLayout(0, 0));
	
	JLabel etNombre = new JLabel("Bienbenid@ "+ventana.usuarioLogado.getNombre());
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
	
	
	JScrollPane lista = new JScrollPane();
	add(lista, BorderLayout.CENTER);
	
	JPanel contenedorElemento = new JPanel();
	lista.setViewportView(contenedorElemento);
	contenedorElemento.setLayout(new BoxLayout(contenedorElemento, BoxLayout.Y_AXIS));

	/*try {
		ArrayList<Usuario> usuarios = ventana.usuarioLogado.getTodos();
		for(byte i=0;i<usuarios.size();i++) {
			System.out.println(usuarios.get(i));
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

	contenedorElemento.add(new ElementoListaUsuario(ventana, ventana.usuarioLogado));*/

}
}
