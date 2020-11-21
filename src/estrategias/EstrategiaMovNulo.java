package estrategias;

import entidades.Entidad;

public class EstrategiaMovNulo extends EstrategiaMovimiento{

	public EstrategiaMovNulo(Entidad e) {
		super(e);
	}

	public void mover() {
		return;
	}
}
