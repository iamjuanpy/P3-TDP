package premios;

import java.util.List;

import entidades.Entidad;
import entidades.Jugador;
import visitors.Visitor;
import visitors.VisitorInfectadoCuarentena;

public class Cuarentena extends EfectoTemporal {

	private static int duracionCuarentena = 1000;
	
	public Cuarentena(Jugador j) {
		super(j,duracionCuarentena);
	}
	
	
	@Override
	public void activar() {
		jugador.setEfectoTemporal(this);
		
		List<Entidad> entidades = jugador.getJuego().getEntidades();
		Visitor v = new VisitorInfectadoCuarentena(true);
		
		for (Entidad e : entidades) {
			e.accept(v);
		}
		
	}
	
	protected void desactivar() {
		
		List<Entidad> entidades = jugador.getJuego().getEntidades();
		Visitor v = new VisitorInfectadoCuarentena(false);
		
		for (Entidad e : entidades) {
			e.accept(v);
		}
		
	}

}
