package estrategias;

import entidades.AnimacionTemporal;
import entidades.Entidad;
import logica.Juego;

public class EstrategiaDeleteBala extends EstrategiaDelete {

	public EstrategiaDeleteBala(Juego juego, Entidad e) {
		super(juego, e);
		
	}

	@Override
	public void delete() {
		
		// Si no es eliminada por caerse del mapa, se crea una animacion
		int y = e.getEntidadGrafica().getY();
		if (y > limiteY1 && y < limiteY2) {
			Entidad ent = new AnimacionTemporal("DeleteBala",juego,e.getEntidadGrafica().getX(),e.getEntidadGrafica().getY(),0,0,25);
			juego.agregarEntidad(ent);
		}
		
		e.setEliminado(true);
		

	}

}
