package armas;

import logica.Juego;

public class SuperArma extends Arma {

	public SuperArma(Juego juego) {
		// Mucho da�o, alta cadencia
		super(juego,30, 15);
		
		nombre = "Super";
	}

}
