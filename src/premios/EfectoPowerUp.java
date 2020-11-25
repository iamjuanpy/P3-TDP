package premios;

import entidades.Jugador;

public abstract class EfectoPowerUp {
	
	protected Jugador jugador;
	
	public EfectoPowerUp(Jugador j) {
		jugador = j;
	}

	public abstract void activar();
	
}
