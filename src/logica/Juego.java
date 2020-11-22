package logica;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;

public class Juego extends JFrame {
	private static final long serialVersionUID = -3673320636191996954L;
	
	private Mapa mapa;
	
	public static void main(String[] args) {
		
		// Iniciar el juego
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Juego juego = new Juego();
					juego.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public Juego() {
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
		
		mapa = new Mapa(60 /* FPS */, this.getWidth(), this.getHeight());
		mapa.setBounds(0, 0, this.getWidth(), this.getHeight());
		mapa.setLayout(null);		
		setContentPane(mapa);
	}

}