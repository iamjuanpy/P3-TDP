package armas;

import logica.Juego;

public class ArmaSuper extends Arma {

	public ArmaSuper(Juego juego) {
		super(juego,0,30);
		nombre = "Super";
		offsetArmaX = 24;
		offsetArmaY = 0;
	}

}
