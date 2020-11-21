package estrategias;

import entidades.Entidad;

public class EstrategiaMovInfectados extends EstrategiaMovimiento {
	public EstrategiaMovInfectados(Entidad e) {
		super(e);
	}

	public void mover() {
		int y = e.getEntidadGrafica().getY();
		y -= 1;
		e.getEntidadGrafica().setY(y);
	}

}
