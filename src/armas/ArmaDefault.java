package armas;

import logica.Juego;

public class ArmaDefault extends Arma {
	
	public ArmaDefault(Juego juego) {
		super(juego, 10, 10);
		nombre = "Default";
		offsetArmaX = 26;
		offsetArmaY = 0;
	}

}
