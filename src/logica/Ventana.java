package logica;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Ventana extends JFrame {
	private static final long serialVersionUID = -3673320636191996954L;
	
	private Mapa mapa;
	private Juego juego;
	
	private HUD display;
	private Menu menu;
	private Ayuda ayuda;
	private Pausa pausa;
	private FinJuego fin;

	
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
		setLocationRelativeTo(null);
		
		inicializarComponentes();
	}

	private void inicializarComponentes() {		
		int alturaHUD = 100;
		int limiteX = getWidth();
		int limiteY = getHeight() - alturaHUD;				
		
		menu = new Menu(0,0,limiteX,limiteY, this);
		ayuda = new Ayuda(0,0,limiteX, limiteY,this);
		display = new HUD(0, limiteY, limiteX, limiteY + alturaHUD);
		pausa = new Pausa(this);
		fin = new FinJuego(this);

		add(menu);
		add(ayuda);
		add(display);
	}
	
	public HUD getHud() {
		return display;
	}
	
	public void nuevoJuego() {
		
		int alturaHUD = 100;
		int limiteX = getWidth();
		int limiteY = getHeight() - alturaHUD;	
		
		if (mapa != null) {
			remove(mapa);
			mapa = null;
			juego = null;
			repaint();
		}
		
		juego = new Juego(60 , limiteX, limiteY,this);
		mapa = new Mapa(0, 0, limiteX, limiteY);

		juego.setMapa(mapa);
		juego.crearJugador();
		mapa.setPlayer(juego.getPlayer());	
		
		mapa.setVisible(true);
		
		add(mapa);
		mapa.requestFocusInWindow();
		
	}
	
	public void ganar() {
		fin.ganar();
		fin.setVisible(true);
	}
	
	public void perder() {
		fin.perder();
		fin.setVisible(true);
	}

	public void mostrarAyuda() {
		menu.setVisible(false);
		ayuda.setVisible(true);
	}
	
	public void cerrarAyuda() {
		menu.setVisible(true);
		ayuda.setVisible(false);
	}
	
	public void pausar() {
        pausa.setVisible(true);
        this.setEnabled(false);
    }

    public void reanudar() {
        pausa.setVisible(false);
        
        this.setEnabled(true);
        this.setVisible(true);
        
        juego.reanudar();
    }

	

}