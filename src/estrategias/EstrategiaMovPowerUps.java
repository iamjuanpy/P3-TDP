package estrategias;

import entidades.Entidad;

public class EstrategiaMovPowerUps extends EstrategiaMovimiento{	
	public EstrategiaMovPowerUps(Entidad e) {
		super(e);
	}

	@Override
	public void mover() {
		int y = e.getEntidadGrafica().getY();
		y -= e.getVelocidadY();
		e.getEntidadGrafica().setY(y);
	}
}
