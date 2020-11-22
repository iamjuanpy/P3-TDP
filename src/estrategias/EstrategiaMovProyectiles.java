package estrategias;

import entidades.Entidad;


public class EstrategiaMovProyectiles extends EstrategiaMovimiento{
	public EstrategiaMovProyectiles(Entidad e) {
		super(e);
	}

	@Override
	public void mover() {
		int y = e.getEntidadGrafica().getY();
		y = y - e.getVelocidadY();
		e.getEntidadGrafica().setY(y);
	}
}
