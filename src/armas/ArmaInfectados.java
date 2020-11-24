package armas;

import entidades.ParticulaInfeccion;
import logica.Mapa;

public class ArmaInfectados extends Arma{

	public ArmaInfectados(Mapa m) {
		super(m,10,50);
		nombre = "ArmaInfectados";
	}
	
	@Override
	public void disparar() {
		int x = owner.getEntidadGrafica().getX();
		int y = owner.getEntidadGrafica().getY();
		
		if (timer == 0) {
			new ParticulaInfeccion(0, mapa, x+(owner.getEntidadGrafica().getAnchoImg()/2), y+(owner.getEntidadGrafica().getAltoImg()), 0, 10);
			timer++;			
		}
	}

}
