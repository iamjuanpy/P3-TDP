package armas;

import entidades.ParticulaInfeccion;
import logica.Mapa;

public class ArmaInfectados extends Arma{

	public ArmaInfectados(Mapa m, int da�o) {
		super(m, da�o, 50);
		nombre = "ArmaInfectados";
	}
	
	@Override
	public void disparar() {
		int x = owner.getEntidadGrafica().getX();
		int y = owner.getEntidadGrafica().getY();
		
		if (timer == 0) {
			new ParticulaInfeccion(da�o, mapa, x+(owner.getEntidadGrafica().getAnchoImg()/2), y+(owner.getEntidadGrafica().getAltoImg()), 0, 10);
			timer++;			
		}
	}

}
