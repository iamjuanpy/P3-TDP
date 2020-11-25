package premios;

import entidades.Jugador;

public class Cuarentena extends EfectoTemporal {

	private static int duracionCuarentena = 1000;
	
	public Cuarentena(Jugador j) {
		super(j,duracionCuarentena);
	}
	
	
	@Override
	public void activar() {
		// TODO Auto-generated method stub
		
	}

}
