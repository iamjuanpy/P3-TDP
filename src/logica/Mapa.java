package logica;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import entidades.Entidad;
import entidades.Grafico;
import entidades.Jugador;

public class Mapa extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Jugador player;
	private JLabel background;
	
	public Mapa(int limiteX, int limiteY) {
		addKeyListener(new InputTeclado());
		setFocusable(true);
		setLayout(null);
		
		setBounds(0, 0, limiteX, limiteY);
		
		// Obtener el background de cada Nivel?
		background = new JLabel();
		background.setBounds(0, 0, limiteX, limiteY);
		background.setIcon(new ImageIcon("img/bg2.png"));
		add(background);
	}
	
	// Delegar el input del usuario al jugador
	// El jugador se lo pasa a su estrategia de movimiento
	private class InputTeclado extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			player.keyPressed(e);
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			player.keyReleased(e);
		}
	}
	
	public void setPlayer(Jugador p) {
		player = p;
	}
	
	public void eliminarEntidad(Entidad e) {
		remove(e.getEntidadGrafica());
	}
	
	public void agregarGrafico(Grafico g) {
		add(g);
		setComponentZOrder(g, 0);
	}

}