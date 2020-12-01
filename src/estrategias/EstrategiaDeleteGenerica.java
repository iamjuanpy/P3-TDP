package estrategias;

import logica.Juego;
import entidades.Entidad;

public class EstrategiaDeleteGenerica extends EstrategiaDelete{

	public EstrategiaDeleteGenerica(Juego juego, Entidad e) {
		super(juego,e);
	}
	
	@Override
	public void delete() {
		e.setEliminado(true);
	}

}
