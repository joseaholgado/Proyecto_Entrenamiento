package interfaces;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import clases.Entrenamiento;
import clases.PlanEntrenamiento;
import clases.Usuario;

public class Ventana extends JFrame {
	protected Usuario usuarioLogado;
	protected PlanEntrenamiento plan;
	protected Entrenamiento entreno;

	public Ventana() {
		this.setSize(680, 445); // Lo hace visible
		this.setTitle("Entreno Z");// Es el título de la ventana
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);// Nos cierra la ejecucion del programa tras cerrar la ventana
		this.setLocationRelativeTo(null);//
		this.setContentPane(new PantallaLogin(this));
		this.setIconImage(new ImageIcon("./Icono.jpg").getImage());
		this.setVisible(true);// Para que sea visible la ventana
	}

	public void cambiarAPantalla(Class<?> clase) {
		this.getContentPane().setVisible(false);

		if (clase.equals(PantallaLogin.class)) {
			this.setContentPane(new PantallaLogin(this));
		} else if (clase.equals(PantallaRegistro.class)) {
			this.setContentPane(new PantallaRegistro(this));
		} else if (clase.equals(PantallaExito.class)) {
			this.setContentPane(new PantallaExito(this));
		} else if (clase.equals(PantallaDatos.class)) {
			this.setContentPane(new PantallaDatos(this));

		} else if (clase.equals(PantallaPanel.class)) {
			this.setContentPane(new PantallaPanel(this));

		} else if (clase.equals(PantallaListado.class)) {
			this.setContentPane(new PantallaListado(this));

		} else if (clase.equals(PantallaEntreno.class)) {
			this.setContentPane(new PantallaEntreno(this));
		}else if (clase.equals(VentanaCronometro.class)) {
				this.setContentPane(new VentanaCronometro(this));
		}else if (clase.equals(PantallaListado2.class)) {
			this.setContentPane(new PantallaListado2(this));

			this.getContentPane().setVisible(true);

		}

	}

}
