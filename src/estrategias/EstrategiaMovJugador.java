package estrategias;

import java.awt.event.KeyEvent;

import entidades.Entidad;
import entidades.Jugador;

public class EstrategiaMovJugador extends EstrategiaMovimiento {
	
	protected int velocidad;
	
	public EstrategiaMovJugador(Entidad e) {
		super(e);
		velocidad = e.getVelocidadX();
	}

	@Override
	public void mover() {
		int x = e.getEntidadGrafica().getX();
		x += direccion;
		e.getEntidadGrafica().setX(x);

		//Faltaria ver los de los bordes creo
		
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_C) {
			((Jugador) this.e).disparar();
		}
		
		if (key == KeyEvent.VK_LEFT) {
			direccion = -velocidad;
		}
		
		if (key == KeyEvent.VK_RIGHT) {
			direccion = velocidad;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) {
			direccion = 0;
		}
		
		if (key == KeyEvent.VK_RIGHT) {
			direccion = 0;
		}
	}
}
