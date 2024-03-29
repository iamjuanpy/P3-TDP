package armas;

import java.util.Random;

import entidades.ParticulaInfeccion;
import logica.Juego;

public class ArmaInfectados extends Arma{
	private static Random rng = new Random();

	public ArmaInfectados(Juego juego, int da�o) {
		super(juego, da�o, 90+rng.nextInt(15));
		nombre = "ArmaInfectados";
	}
	
	@Override
	public void disparar() {
		int x = owner.getEntidadGrafica().getX();
		int y = owner.getEntidadGrafica().getY();
		
		if (timer == 0) {
			ParticulaInfeccion p = new ParticulaInfeccion(da�o, juego, x+(owner.getEntidadGrafica().getAnchoImg()/2), y+(owner.getEntidadGrafica().getAltoImg()), 0, 10);
			juego.agregarEntidad(p);
			timer++;			
		}
	}

}
