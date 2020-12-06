package estrategias;

import entidades.Entidad;
import entidades.PowerUpFactory;
import logica.Juego;
import java.util.Random;

public class EstrategiaDeleteInfectado extends EstrategiaDelete {
	private PowerUpFactory fabricaPowerUps;
	private Random rnd;
	
	public EstrategiaDeleteInfectado(Juego juego, Entidad e) {
		super(juego, e);
		rnd = new Random();
		fabricaPowerUps = juego.getPowerUpFactory();
	}

	@Override
	public void delete() {		
		int x = e.getEntidadGrafica().getX();
		int y = e.getEntidadGrafica().getY();
		
		// Con una posibilidad uniforme del 20%
		if (rnd.nextFloat() <= 0.2f) {
			fabricaPowerUps.crearPowerUpRandom(x, y);
		}		
		
		e.setEliminado(true);
	}

}
