package estrategias;

import entidades.Entidad;

public class EstrategiaMovInfectados extends EstrategiaMovimiento {
	
	public EstrategiaMovInfectados(Entidad e) {
		super(e);
	}

	public void mover() {
		int y = e.getEntidadGrafica().getY();
		y += e.getVelocidadY();
		
		if (y > m.getBounds().getHeight() + e.getEntidadGrafica().getAltoImg()) {
			y = (int) (m.getBounds().getX() - e.getEntidadGrafica().getAltoImg());
		}
		
		e.getEntidadGrafica().setY(y);		
	}

}
