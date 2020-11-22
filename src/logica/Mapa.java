package logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import entidades.Entidad;
import entidades.Humano;
import entidades.Jugador;

import java.util.ArrayList;
import java.util.List;

public class Mapa extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private List<Entidad> entidades;
	private JLabel background;
	private Jugador player;
	
	public Mapa(int FPS, int limiteX, int limiteY) {
		entidades = new ArrayList<Entidad>();
		
		addKeyListener(new InputTeclado());
		setFocusable(true);
		
		// Obtener el background de cada Nivel?
		background = new JLabel();
		background.setBounds(0, 0, limiteX, limiteY);
		background.setIcon(new ImageIcon("img/bg.jpg"));
		add(background);
		
		player = new Jugador(this, limiteX/2, limiteY - 75, 6, 0);
		// entidades.add(player); // Delegu� el agregado al mapa al constructor de la entidad
		
		// Se manipula el orden z para posicionar la imagen de fondo al fondo
		// Un valor mas alto se dibuja despues de uno mas bajo
		setComponentZOrder(background, 1);
		
		ActionListener eventoTimer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actualizarEntidades();
				resolverColisiones();
			}
		};
		
		/*
		 * Si queremos que el juego ande a x FPS, significa que en cada segundo van
		 * a haber x actualizaciones. Entonces por la regla de 3 hay 1/x segundos por frame
		 * y eso se multiplica por 1000 para pasarlo a milisegundos. Este valor final
		 * es cuantas veces actualizamos cada entidad por segundo.
		 * 
		 * 60 fps -- 1 seg
		 *  1 fps -- ? seg <- 1/60
		 * Hay un poco de perdida de precision, pero se tiene que castear a int porque eso requiere Timer.
		 * El error es una cantidad demasiado peque�a para importar.
		 */
		float fpsEnMS = ( 1/ (float) FPS ) * 1000;
		Timer t = new Timer((int)fpsEnMS, eventoTimer);
		t.start();
	}
	
	private void actualizarEntidades() {
		for (Entidad e : entidades) {
			e.actualizar();
		}
	}
	
	private void resolverColisiones() {
		for (Entidad e : entidades) {
			e.buscarColisiones(entidades);
		}
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
	
	public void agregarEntidad(Entidad e) {
		entidades.add(e);
		System.out.println("Cantidad de entidades: "+entidades.size()); // DEBUG
	}

	public Humano getPlayer() {
		return player;
	}
	
}