package estrategias;

import entidades.Entidad;
import logica.Mapa;

public abstract class EstrategiaDelete {
	
	protected Entidad e;
	protected Mapa m;
	
	public EstrategiaDelete(Mapa m, Entidad e) {
		this.m = m;
		this.e = e;
	}
	
	public abstract void delete(); 
	
}
