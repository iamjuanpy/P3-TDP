package estrategias;

import java.awt.event.KeyEvent;

import entidades.Entidad;
import entidades.Jugador;

public class EstrategiaMovJugador extends EstrategiaMovimiento {
	
	protected int velocidad;
	
	public EstrategiaMovJugador(Entidad ent) {
		super(ent);
		velocidad = ent.getVelocidadX();
	}

	@Override
	public void mover() {
		int x = e.getEntidadGrafica().getX();
		x += direccion;
		
		// if (x == limiteX2 - e.getEntidadGrafica().getAnchoImg() || x == limiteX + e.getEntidadGrafica().getAnchoImg() ) {
		//		direccion = 0;
		// }
		
		e.getEntidadGrafica().setX(x);
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		String aux = ((Jugador) this.e).getArmaSeleccionada();
		
		if (key == KeyEvent.VK_C) {
			((Jugador) this.e).disparar();
			this.e.getEntidadGrafica().setImagen("Jugador"+aux+"Disp");
		}
		
		if (key == KeyEvent.VK_LEFT) {
			direccion = -velocidad;
			this.e.getEntidadGrafica().setImagen("Jugador"+aux+"Izq");
		}
		
		if (key == KeyEvent.VK_RIGHT) {
			direccion = velocidad;
			this.e.getEntidadGrafica().setImagen("Jugador"+aux+"Der");
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		String aux = ((Jugador) this.e).getArmaSeleccionada();
		
		if (key == KeyEvent.VK_C) {
			this.e.getEntidadGrafica().setImagen("Jugador"+aux);
		}
		
		if (key == KeyEvent.VK_LEFT) {
			direccion = 0;
			this.e.getEntidadGrafica().setImagen("Jugador"+aux);
		}
		
		if (key == KeyEvent.VK_RIGHT) {
			direccion = 0;
			this.e.getEntidadGrafica().setImagen("Jugador"+aux);
		}
	}
}
