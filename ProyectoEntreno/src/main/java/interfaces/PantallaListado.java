package interfaces;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PantallaListado extends JPanel{
	private Ventana ventana;
	
	public PantallaListado(Ventana v) {
	this.ventana=v;
	setLayout(new BorderLayout(0, 0));
	
	JLabel etNombre = new JLabel("Bienbenid@ "+ventana.usuarioLogado.getNombre());
	add(etNombre, BorderLayout.NORTH);
	
	JPanel panel = new JPanel();
	add(panel, BorderLayout.SOUTH);
	
	JButton btnNewButton = new JButton("New button");
	panel.add(btnNewButton);
	
	JButton btnNewButton_1 = new JButton("New button");
	panel.add(btnNewButton_1);
	
	JButton btnNewButton_2 = new JButton("New button");
	panel.add(btnNewButton_2);
	
	JScrollPane lista = new JScrollPane();
	add(lista, BorderLayout.CENTER);
	
	JPanel contenedorElemento = new JPanel();
	lista.setViewportView(contenedorElemento);
	contenedorElemento.setLayout(new BoxLayout(contenedorElemento, BoxLayout.Y_AXIS));
	
	for(byte i=0;i<100;i++) {
		contenedorElemento.add(new ElementoListaUsuario(ventana,ventana.usuarioLogado));
	}
}
}
