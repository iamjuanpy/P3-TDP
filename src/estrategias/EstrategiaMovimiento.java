package estrategias;

import entidades.Entidad;

public abstract class EstrategiaMovimiento {
	
	protected int direccion;
	protected Entidad e;
	// protected int limiteX;
	// protected int limiteX2;
	// protected int limiteY;
	// protected int limiteY2;
	
	 public EstrategiaMovimiento(Entidad e) {
		 this.e = e;
	 }
	
	public abstract void mover();
}
