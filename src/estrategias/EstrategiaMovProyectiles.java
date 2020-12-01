package estrategias;

import entidades.Entidad;


public class EstrategiaMovProyectiles extends EstrategiaMovimiento{
	public EstrategiaMovProyectiles(Entidad e) {
		super(e);
	}

	@Override
	public void mover() {
		int y = e.getEntidadGrafica().getY();
		y = y - e.getVelocidadY();
		e.getEntidadGrafica().setY(y);
		
		if (limiteY == null) {
			limiteY = (int) juego.getMapa().getBounds().getX();
		}
		
		if (limiteY2 == null) {
			limiteY2 = (int) juego.getMapa().getBounds().getHeight();
		}
		
		// Hacer una strat de delete que permita eliminar con animacion(cuando pega a un enemigo) 
		// Y sin animacion cuando se cae del mapa.
		if (y < limiteY || y > limiteY2) {
			e.eliminar();
		}
		
	}
}
