package estrategias;

import entidades.AnimacionTemporal;
import entidades.Entidad;
import logica.Juego;

public class EstrategiaDeleteInfeccion extends EstrategiaDelete {
	public EstrategiaDeleteInfeccion(Juego juego, Entidad e) {
		super(juego, e);
	}

	@Override
	public void delete() {
		// Si no es eliminada por caerse del mapa, se crea una animacion
		int y = e.getEntidadGrafica().getY(); 
		if (y > limiteX1 && y < limiteY2) {
			int xEfec = juego.getPlayer().getEntidadGrafica().getX()+20;
			int yEfec = juego.getPlayer().getEntidadGrafica().getY()+25;
			Entidad ent = new AnimacionTemporal("DeleteInfeccion",juego,xEfec,yEfec,0,0,25);
			juego.agregarEntidad(ent);
		}
		
		e.setEliminado(true);
	}

}
