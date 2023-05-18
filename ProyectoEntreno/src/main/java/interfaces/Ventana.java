package interfaces;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class Ventana extends JFrame{
	private byte TipoEntrenamiento;
	private byte nivel;
	private byte diasEntrenamiento;
	private byte lugar;
	
	public Ventana() {
		this.setSize(680,445); //Lo hace visible
		this.setTitle("Entreno Z");//Es el título de la ventana
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//Nos cierra la ejecucion del programa tras cerrar la ventana
		this.setLocationRelativeTo(null);//
		this.setContentPane(new PantallaLogin(this));
		this.setVisible(true);//Para que sea visible la ventana
	}
	public void cambiarAPantalla(Class<?> clase) {
		this.getContentPane().setVisible(false);
		if (clase.equals(PantallaLogin.class)) {
			this.setContentPane(new PantallaLogin(this));
		}
		if (clase.equals(PantallaRegistro.class)) {
			this.setContentPane(new PantallaRegistro(this));
		}
		if (clase.equals(PantallaExito.class)) {
			this.setContentPane(new PantallaExito(this));
		}
		if (clase.equals(PantallaDatos.class)) {
			this.setContentPane(new PantallaDatos(this));
		}
		this.getContentPane().setVisible(true);
		
	}

	
}
