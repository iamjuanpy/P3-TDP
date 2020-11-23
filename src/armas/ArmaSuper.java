package armas;

import entidades.Humano;
import logica.Mapa;

public class ArmaSuper extends Arma {

	public ArmaSuper(Mapa m) {
		super(m,0,10);
		nombre = "Super";
		offsetArmaX = 24;
		offsetArmaY = 0;
	}

}
