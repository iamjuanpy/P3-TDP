package logica;

import java.awt.EventQueue;
import javax.swing.JFrame;
//import java.io.File;

public class Ventana extends JFrame {
	private static final long serialVersionUID = -3673320636191996954L;
	
	private HUD display;
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
		setBounds(50, 50, 600, 900);
		setTitle("Proyecto 3");
		setResizable(false);
		setLayout(null);
		
		inicializarComponentes();
	}
	
	private void inicializarComponentes() {
		// PASSPORT es solo un placeholder por ahora.
		// Creo que viene de Windows 95
		
		// File midi = new File("midi/PASSPORT.mid");
		// Thread t = new Thread(new MusicaRunnable(midi, true));
		// t.run();
		
		int alturaHUD = 100;
		int limiteX = getWidth();
		int limiteY = getHeight() - alturaHUD;				
		
		Juego juego = new Juego(60 /* FPS */, limiteX, limiteY);
		mapa = new Mapa(0, 0, limiteX, limiteY);		
		
		display = new HUD(0, limiteY, limiteX, limiteY + alturaHUD);		
		
		add(mapa);
		add(display);
		
		juego.setMapa(mapa);
		juego.crearJugador();
		mapa.setPlayer(juego.getPlayer());	
		
		juego.testEntidades();
	}

}