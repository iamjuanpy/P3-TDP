package armas;

import logica.Mapa;

public class SuperArma extends Arma {

	public SuperArma(Mapa m) {
		// Mucho da�o, alta cadencia
		super(m,30, 15);
		
		nombre = "Super";
	}

}
