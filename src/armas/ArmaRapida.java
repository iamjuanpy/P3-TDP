package armas;

import entidades.Bala;
import logica.Mapa;

public class ArmaRapida extends Arma {

	public ArmaRapida(Mapa m) {
		// Menos daño pero dispara mas rapido
		super(m,5,10);
		nombre = "Rapida";
		offsetArmaX = 24;
		offsetArmaY = 0;
	}
	
	public void disparar() {
		int x = owner.getEntidadGrafica().getX();
		int y = owner.getEntidadGrafica().getY();
		
		if (timer == 0) {
			new Bala(daño, mapa, x+offsetArmaX, y, 0, 10);
			new Bala(daño, mapa, x+offsetArmaX, y-25, 0, 10);
			new Bala(daño, mapa, x+offsetArmaX, y-15, 0, 10);
			timer++;
		}
	}

}
