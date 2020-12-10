package estrategias;

import java.util.Random;

import entidades.Entidad;
import entidades.Humano;
import entidades.Infectado;

public class EstrategiaMovInfectados extends EstrategiaMovimiento {
	private Random rng;
	
	public EstrategiaMovInfectados(Entidad e) {
		super(e);
		rng = new Random();
	}

	public void mover() {
		int y = e.getEntidadGrafica().getY();
		y += e.getVelocidadY();
		
		if (y > juego.getMapa().getBounds().getHeight() + e.getEntidadGrafica().getAltoImg()) {
			y = (int) (juego.getMapa().getBounds().getX() - e.getEntidadGrafica().getAltoImg());
			((Infectado) e).setGolpeo(false);
		}
		
		e.getEntidadGrafica().setY(y);
		
		// Como esto se ejecuta cada 16 milisegundos, hay que jugar
		// con el umbral para que no sea injusto/injugable 
		if (rng.nextFloat() > 0.95f) {
			((Humano) e).disparar();			
		}
	}

}
