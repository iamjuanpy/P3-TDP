package premios;

import entidades.Jugador;

public abstract class EfectoTemporal extends EfectoPowerUp{
	
	protected String s;
	protected int duracion;
	protected int tick;
	
	public EfectoTemporal(Jugador j, int d) {
		super(j);
		duracion = d;
		tick = duracion;
	}

	public void tick() {
		tick--;
		
		if (tick == 0) {
			desactivar();
			jugador.deleteEfectoTemporal(this);
		}
		
	}
	
	protected abstract void desactivar();
	
	public String toString() {
		return s;
	}
	
}
