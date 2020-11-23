package estrategias;

import entidades.Entidad;

public class EstrategiaMovInfectados extends EstrategiaMovimiento {
	public EstrategiaMovInfectados(Entidad e) {
		super(e);
	}

	public void mover() {
		int y = e.getEntidadGrafica().getY();
		y -= 1;
		e.getEntidadGrafica().setY(y);
		
		// Agregarle a entidad un metodo getMapa() para conseguir el tamaño del mismo?
		// Esto haría que una vez el infectado termina de desaparecer abajo vuelve arriba
		if (y == 800 + e.getEntidadGrafica().getAltoImg())
			y = 0 - e.getEntidadGrafica().getAltoImg();
		
		//	if (y == limiteY2 +  e.getEntidadGrafica().getAltoImg())
		//		y = limiteY - e.getEntidadGrafica().getAltoImg();
		
	}

}
