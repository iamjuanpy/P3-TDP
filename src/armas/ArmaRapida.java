package armas;

import logica.Mapa;

public class ArmaRapida extends Arma {

	public ArmaRapida(Mapa m) {
		// Menos da�o pero dispara mas rapido
		super(m,5,5);
		nombre = "Rapida";
		offsetArmaX = 24;
		offsetArmaY = 0;
	}

}
