package premios;

import entidades.Jugador;

public abstract class EfectoTemporal extends EfectoPowerUp{
	
	int duracion;
	
	public EfectoTemporal(Jugador j, int d) {
		super(j);
		duracion = d;
	}
	
}
