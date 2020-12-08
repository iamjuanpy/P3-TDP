package armas;

import entidades.ParticulaInfeccion;
import logica.Juego;

public class ArmaInfectados extends Arma{

	public ArmaInfectados(Juego juego, int daño) {
		super(juego, daño, 80);
		nombre = "ArmaInfectados";
	}
	
	@Override
	public void disparar() {
		int x = owner.getEntidadGrafica().getX();
		int y = owner.getEntidadGrafica().getY();
		
		if (timer == 0) {
			ParticulaInfeccion p = new ParticulaInfeccion(daño, juego, x+(owner.getEntidadGrafica().getAnchoImg()/2), y+(owner.getEntidadGrafica().getAltoImg()), 0, 10);
			juego.agregarEntidad(p);
			timer++;			
		}
	}

}
