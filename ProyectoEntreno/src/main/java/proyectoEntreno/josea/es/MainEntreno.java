package proyectoEntreno.josea.es;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import clases.PlanEntrenamiento;
import interfaces.Ventana;

public class MainEntreno {


	public static void main(String[] args) {
		
		
		

		BufferedImage imagen =new BufferedImage(800,600,BufferedImage.TYPE_INT_RGB);
		float contadorRojo=0;
		float contadorVerde=0;
		float contadorAzul=0;
		try {
			imagen = ImageIO.read(new File("./Icono.jpeg"));
			ImageIO.write(imagen, "JPG", new File("./Icono.jpg"));
			/*for (short i = 0; i < imagen.getWidth(); i++) {
				for (short j = 0; j < imagen.getHeight(); j++) {
					String colorEscogido = String.format("%02X", (int) contadorRojo);
					colorEscogido += String.format("%02X", (int) contadorVerde);
					colorEscogido += String.format("%02X", (int) contadorAzul);
					imagen.setRGB(i, j, Integer.parseInt(colorEscogido, 16));
				}
			}
			ImageIO.write(imagen,"JPG",new File("./Icono.jpg"));*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Ventana v=new Ventana();
		/*try {
			imagen = ImageIO.read(new File("./Icono.jpeg"));
			ImageIO.write(imagen,"JPG",new File("./fotoclase.jpg"));
			for (short i = 0; i < imagen.getWidth(); i++) {
				for (short j = 0; j < imagen.getHeight(); j++) {
					imagen.setRGB(i, j, imagen.getRGB(i, j)&Integer.parseInt("FF0000",16));
				}
			}

			ImageIO.write(imagen, "jpg", new File("./Icono.jpg"));
			for(short i=0;i<imagen.getWidth();i++) {
				for(short j=0;j<imagen.getHeight();j++) {
					String colorEscogido=String.format("%02X",(int)contadorRojo);
					colorEscogido+=String.format("%02X",(int)contadorVerde);
					colorEscogido+=String.format("%02X",(int)contadorAzul);
					imagen.setRGB(i, j, Integer.parseInt(colorEscogido,16));
					contadorRojo=(contadorRojo+(256f/imagen.getHeight()))%256;
				}
				contadorVerde=(contadorVerde+(256f/imagen.getHeight()))%256;
				contadorAzul=(contadorAzul+(256f/imagen.getHeight()))%256;
			}
			ImageIO.write(imagen,"JPG",new File("./fotoclase.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		
		
	}

}
