package estrategias;

import entidades.Entidad;
import entidades.Humano;

public class EstrategiaMovInfectados extends EstrategiaMovimiento {
	
	public EstrategiaMovInfectados(Entidad e) {
		super(e);
	}

	public void mover() {
		int y = e.getEntidadGrafica().getY();
		y += e.getVelocidadY();
		
		if (y > juego.getMapa().getBounds().getHeight() + e.getEntidadGrafica().getAltoImg()) {
			y = (int) (juego.getMapa().getBounds().getX() - e.getEntidadGrafica().getAltoImg());
		}
		
		e.getEntidadGrafica().setY(y);
		
		// Se puede agregar un delay random para que no sean tan ritmicos los disparos
		((Humano) e).disparar();
	}

}
