package armas;

import logica.Mapa;

public class SuperArma extends Arma {

	public SuperArma(Mapa m) {
		// Mucho daño, alta cadencia
		super(m,30, 15);
		
		nombre = "Super";
	}

}
