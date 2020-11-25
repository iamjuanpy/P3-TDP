package premios;

import entidades.Jugador;

public abstract class EfectoTemporal extends EfectoPowerUp{
	
	int duracion;
	int tick;
	
	public EfectoTemporal(Jugador j, int d) {
		super(j);
		duracion = d;
		tick = duracion;
		jugador.setEfectoTemporal(this);
	}

	public void tick() {
		tick--;
		
		if (tick == 0) {
			desactivar();
			jugador.setEfectoTemporal(null);
		}
		
	}
	
	protected abstract void desactivar();
	
}
