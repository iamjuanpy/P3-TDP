package estrategias;

import java.awt.Rectangle;

import entidades.Entidad;
import logica.Juego;

public abstract class EstrategiaDelete {
	
	protected Entidad e;
	protected Juego juego;
	
	protected int limiteX1, limiteX2, limiteY1, limiteY2;
	
	public EstrategiaDelete(Juego juego, Entidad e) {
		this.juego = juego;
		this.e = e;
		
		Rectangle bounds = juego.getMapa().getBounds();
		limiteX1 = (int) bounds.getX();
		limiteX2 = (int) bounds.getWidth();
		limiteY1 = (int) bounds.getY();
		limiteY2 = (int) bounds.getHeight();
	}
	
	public abstract void delete(); 
	
}
