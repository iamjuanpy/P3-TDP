package premios;

import entidades.AnimacionTemporal;
import entidades.Entidad;
import entidades.Jugador;

public class Pocion extends Consumible {
	
	private static int vidaCurada = 20;

	public Pocion(Jugador j) {
		super(j);
	}
	
	@Override
	public void activar() {
		jugador.setCV(jugador.getCV()-vidaCurada);
		
		// Animacion
		int xEfec = jugador.getEntidadGrafica().getX()+20;
		int yEfec = jugador.getEntidadGrafica().getY()+45;
		Entidad ent = new AnimacionTemporal("DeleteBala",jugador.getJuego(),xEfec,yEfec,0,0,25);
		jugador.getJuego().agregarEntidad(ent);
		
	}

}
