package premios;

import entidades.Jugador;

public class Escudo extends Consumible {

	public Escudo(Jugador j) {
		super(j);
	}
	
	@Override
	public void activar() {
		jugador.setEscudo(true);
	}

}
