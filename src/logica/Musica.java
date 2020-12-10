package logica;

import java.net.URL;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Musica extends Thread {
	private Clip clip;
	private String path;
	
	private boolean estaDetenido;
	
	public Musica(String musica, boolean loop) {
		path = musica;
		estaDetenido = true;
	}
	
	public void cambiarMusica(String musica) {
		estaDetenido = true;
		URL archivo = getClass().getResource(musica);
		
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivo);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-20.0f); // Bajar el volumen de la musica
			
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (UnsupportedAudioFileException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (LineUnavailableException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		cambiarMusica(path);
	}

	public void detenerMusica() {
		estaDetenido = true;

		clip.stop();
		// clip.flush();
		clip.close();
	}
	
	public boolean detenido() {
		return estaDetenido;
	}
}