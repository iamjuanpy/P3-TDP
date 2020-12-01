package estrategias;

import entidades.Entidad;

public class EstrategiaMovPowerUps extends EstrategiaMovimiento{	
	public EstrategiaMovPowerUps(Entidad e) {
		super(e);
	}

	@Override
	public void mover() {
		int y = e.getEntidadGrafica().getY();
		y += e.getVelocidadY();
		e.getEntidadGrafica().setY(y);
		
		if (limiteY2 == null) {
			limiteY2 = (int) juego.getMapa().getBounds().getHeight();
		}
		
		// Agregarle a entidad un metodo getMapa() para conseguir el tamaño del mismo?
		// Esto haría que una vez el powerup desaparece de nuestra pantalla y no lo agarramos, desaparezca.
		if (y > limiteY2 + e.getEntidadGrafica().getAltoImg()) {
			e.eliminar();
		}
	}
}
