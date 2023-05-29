package utilidades;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class ReproductorAudio {
    private Clip clip;
    
    public void reproducir(String nombreArchivo) {
       
            AudioInputStream audioInputStream;
			try {
				audioInputStream = AudioSystem.getAudioInputStream(new File(nombreArchivo));
				clip = AudioSystem.getClip();
	            clip.open(audioInputStream);
	            clip.start();
			} catch (UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
       
        }
    public void detener() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
    }

