package estrategias;

import java.awt.event.KeyEvent;

import entidades.Entidad;
import entidades.Jugador;

public class EstrategiaMovJugador extends EstrategiaMovimiento {
	protected int velocidad;
	private int anchoExtra;
	
	public EstrategiaMovJugador(Entidad ent) {
		super(ent);
		velocidad = ent.getVelocidadX();
		anchoExtra = e.getEntidadGrafica().getAnchoImg();
	}

	@Override
	public void mover() {
		int x = e.getEntidadGrafica().getX();
		x += direccion;
		
		if (limiteX2 == null) {
			limiteX2 = (int) juego.getMapa().getBounds().getWidth();
		}
		
		if (limiteX == null) {
			limiteX = (int) juego.getMapa().getBounds().getX();
		}
		
		if (x < limiteX) {
			x = limiteX;
		} else if (x > limiteX2 - anchoExtra) {
			x = limiteX2 - anchoExtra;
		}
		
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
		
		if (key == KeyEvent.VK_ESCAPE) {
            juego.pausa();
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
