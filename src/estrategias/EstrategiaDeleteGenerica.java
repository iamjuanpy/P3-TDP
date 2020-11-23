package estrategias;

import entidades.Entidad;
import logica.Mapa;

public class EstrategiaDeleteGenerica extends EstrategiaDelete{

	public EstrategiaDeleteGenerica(Mapa m, Entidad e) {
		super(m,e);
	}
	
	@Override
	// Procedimiento de eliminacion:
	// 1) Llamar m.remove(e.getEntidadGrafica());
	// 2) eliminar e de la lista de entidades de m para que no se actualize mas
		
	// m.eliminarEntidad(e);
	public void delete() {
		m.eliminarEntidad(e);
		m.remove(e.getEntidadGrafica());
	}

}
