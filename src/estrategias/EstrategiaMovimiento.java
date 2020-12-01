package estrategias;

import entidades.Entidad;
import logica.Juego;

public abstract class EstrategiaMovimiento {
	protected int direccion;
	protected Entidad e;
	protected Juego juego;
	
	// Tienen que ser Integer porque no se pueden inicializar hasta que la ventana se muestra entera
	protected Integer limiteX;
	protected Integer limiteX2;
	protected Integer limiteY;
	protected Integer limiteY2;
	
	public EstrategiaMovimiento(Entidad e) {
		this.e = e;
		juego = e.getJuego();
	}
	
	public abstract void mover();
}
