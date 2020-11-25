package premios;

import entidades.Jugador;

public class Pocion extends Consumible {
	
	private static int vidaCurada = 20;

	public Pocion(Jugador j) {
		super(j);
	}
	
	@Override
	public void activar() {
		jugador.setCV(jugador.getCV()-vidaCurada);
	}

}
