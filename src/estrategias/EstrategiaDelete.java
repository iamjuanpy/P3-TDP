package estrategias;

import entidades.Entidad;
import logica.Mapa;

/**
 * Si lo hacemos independiente del tipo de la entidad podemos tener un metodo delete(Entidad e)
 * y EstrategiaDelete seria un singleton en vez de crear uno para cada entidad
 */
public abstract class EstrategiaDelete {
	private Entidad e;
	private Mapa m;
	
	public void delete() {
		// Procedimiento de eliminacion:
		// 1) Llamar m.remove(e.getEntidadGrafica());
		// 2) eliminar e de la lista de entidades de m para que no se actualize mas
		
		// m.eliminarEntidad(e);
	}
}
