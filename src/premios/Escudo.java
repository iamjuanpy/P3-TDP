package premios;

import entidades.AnimacionTemporal;
import entidades.Entidad;
import entidades.Jugador;

public class Escudo extends Consumible {

	public Escudo(Jugador j) {
		super(j);
	}
	
	@Override
	public void activar() {
		jugador.setEscudo(true);
		
		Entidad texto = new AnimacionTemporal("getEscudo",jugador.getJuego(),300,400,0,0,35);
		jugador.getJuego().agregarEntidad(texto);
	}

}
