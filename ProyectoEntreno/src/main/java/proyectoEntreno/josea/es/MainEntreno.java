package proyectoEntreno.josea.es;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import clases.PlanEntrenamiento;
import interfaces.Ventana;

public class MainEntreno {

	public static void main(String[] args) {

		BufferedImage imagen = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
		float contadorRojo = 0;
		float contadorVerde = 0;
		float contadorAzul = 0;
		try {
			imagen = ImageIO.read(new File("./Icono.jpeg"));
			ImageIO.write(imagen, "JPG", new File("./Icono.jpg"));

		} catch (IOException e) {

			e.printStackTrace();
		}
		Ventana v = new Ventana();

	}

}
