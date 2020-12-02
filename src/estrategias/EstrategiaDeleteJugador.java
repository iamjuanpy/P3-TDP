package estrategias;

import entidades.AnimacionTemporal;
import entidades.Entidad;
import logica.Juego;

public class EstrategiaDeleteJugador extends EstrategiaDelete {

	public EstrategiaDeleteJugador(Juego juego, Entidad e) {
		super(juego, e);
	}

	@Override
	public void delete() {
		e.setEliminado(true);
		int xEfec = juego.getPlayer().getEntidadGrafica().getX()+20;
		int yEfec = juego.getPlayer().getEntidadGrafica().getY()+35;
		Entidad ent = new AnimacionTemporal("Muerte",juego,xEfec,yEfec,0,0,999999);
		juego.agregarEntidad(ent);
	}

}
