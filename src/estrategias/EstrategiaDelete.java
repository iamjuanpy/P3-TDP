package estrategias;

import entidades.Entidad;
import logica.Juego;

public abstract class EstrategiaDelete {
	
	protected Entidad e;
	protected Juego juego;
	
	public EstrategiaDelete(Juego juego, Entidad e) {
		this.juego = juego;
		this.e = e;
	}
	
	public abstract void delete(); 
	
}
