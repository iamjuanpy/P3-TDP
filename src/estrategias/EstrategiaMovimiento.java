package estrategias;

import entidades.Entidad;

public abstract class EstrategiaMovimiento {
	protected int direccion;
	protected Entidad e;
	
	 public EstrategiaMovimiento(Entidad e) {
		 this.e = e;
	 }
	
	public abstract void mover();
}
