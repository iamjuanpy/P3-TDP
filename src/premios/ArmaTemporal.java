package premios;

import java.util.Random;

import armas.Arma;
import armas.ArmaRapida;
import armas.ArmaSuper;
import entidades.Jugador;

public class ArmaTemporal extends EfectoTemporal {

	private static int duracionArma = 1000;
	private Arma arma;
	
	public ArmaTemporal(Jugador j) {
		super(j,duracionArma);
		
		if (jugador.getArmaSeleccionada() == "Default") {
			if (new Random().nextInt(1) == 1)
				arma = new ArmaSuper(jugador.getMapa());
			else arma = new ArmaRapida(jugador.getMapa());
		}
		else {
			if (jugador.getArmaSeleccionada() == "Super")
				arma = new ArmaRapida(jugador.getMapa());
			else arma = new ArmaSuper(jugador.getMapa());
		}
		
	}
	@Override
	public void activar() {
		
		jugador.setArma(arma);
		
	}

}
