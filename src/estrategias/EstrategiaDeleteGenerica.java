package estrategias;

import entidades.Entidad;
import logica.Mapa;

public class EstrategiaDeleteGenerica extends EstrategiaDelete{

	public EstrategiaDeleteGenerica(Mapa m, Entidad e) {
		super(m,e);
	}
	
	@Override
	public void delete() {
		e.setEliminado(true);
		m.remove(e.getEntidadGrafica());
	}

}
