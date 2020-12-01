package armas;


import entidades.Bala;
import logica.Juego;

public class ArmaRapida extends Arma {

	public ArmaRapida(Juego juego) {
		// Menos da�o pero dispara mas rapido
		super(juego,5,10);
		nombre = "Rapida";
		offsetArmaX = 24;
		offsetArmaY = 0;
	}
	
	public void disparar() {
		int x = owner.getEntidadGrafica().getX();
		int y = owner.getEntidadGrafica().getY();
		Bala b;
		
		if (timer == 0) {
			b = new Bala(da�o, juego, x+offsetArmaX, y, 0, 10);
			juego.agregarEntidad(b);
			b = new Bala(da�o, juego, x+offsetArmaX, y-25, 0, 10);
			juego.agregarEntidad(b);
			b = new Bala(da�o, juego, x+offsetArmaX, y-15, 0, 10);
			juego.agregarEntidad(b);
			timer++;
		}
	}

}
