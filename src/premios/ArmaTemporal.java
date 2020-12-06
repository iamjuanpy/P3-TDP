package premios;

import java.util.Random;

import armas.Arma;
import armas.ArmaDefault;
import armas.ArmaRapida;
import armas.ArmaSuper;
import entidades.Jugador;

public class ArmaTemporal extends EfectoTemporal {

	private static int duracionArma = 750;
	private Arma arma;
	
	public ArmaTemporal(Jugador j) {
		super(j,duracionArma);
		s = "ArmaTemporal";
		
		// no es final
		if (jugador.getArmaSeleccionada() == "Default") {
			if (new Random().nextInt(10) < 5)
				arma = new ArmaSuper(jugador.getJuego());
			else arma = new ArmaRapida(jugador.getJuego());
		}
		//
	}
	@Override
	public void activar() {
		jugador.setEfectoTemporal(this);
		
		jugador.setArma(arma);
		arma.setOwner(jugador);
	}

	protected void desactivar() {
		Arma aux = new ArmaDefault(jugador.getJuego());

		jugador.setArma(aux);
		aux.setOwner(jugador);
	}

}
