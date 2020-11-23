package estrategias;

import entidades.Entidad;
import logica.Mapa;

/**
 * Si lo hacemos independiente del tipo de la entidad podemos tener un metodo delete(Entidad e)
 * y EstrategiaDelete seria un singleton en vez de crear uno para cada entidad
 */
public abstract class EstrategiaDelete {
	
	protected Entidad e;
	protected Mapa m;
	
	public EstrategiaDelete(Mapa m, Entidad e) {
		this.m = m;
		this.e = e;
	}
	
	public abstract void delete(); 
	
}
