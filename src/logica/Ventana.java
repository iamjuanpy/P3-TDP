package logica;

import java.awt.EventQueue;
import javax.swing.JFrame;
//import java.io.File;

public class Ventana extends JFrame {
	private static final long serialVersionUID = -3673320636191996954L;
	
	private Mapa mapa;
	
	public static void main(String[] args) {
		
		// Iniciar el juego
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana juego = new Ventana();
					juego.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(50, 50, 600, 800);
		setTitle("Proyecto 3");
		setResizable(false);
	
		inicializarComponentes();
	}
	
	private void inicializarComponentes() {
		// PASSPORT es solo un placeholder por ahora.
		// Creo que viene de Windows 95
		
		// File midi = new File("midi/PASSPORT.mid");
		// Thread t = new Thread(new MusicaRunnable(midi, true));
		// t.run();
		
		Juego juego = new Juego(60 /* FPS */, this.getWidth(), this.getHeight());
		mapa = new Mapa(this.getWidth(), this.getHeight());
		setContentPane(mapa);
		juego.setMapa(mapa);
		
		juego.crearJugador();
		mapa.setPlayer(juego.getPlayer());	
		
		juego.testEntidades();
	}

}