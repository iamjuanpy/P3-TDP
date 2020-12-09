package premios;

import java.util.List;

import entidades.AnimacionTemporal;
import entidades.Entidad;
import entidades.Jugador;
import visitors.Visitor;
import visitors.VisitorInfectadoCuarentena;

public class Cuarentena extends EfectoTemporal {

	private static int duracionCuarentena = 1000;
	
	public Cuarentena(Jugador j) {
		super(j,duracionCuarentena);
		s = "Cuarentena";
	}
	
	
	@Override
	public void activar() {
		jugador.setEfectoTemporal(this);
		
		Entidad texto = new AnimacionTemporal("getCuarentena",jugador.getJuego(),300,400,0,0,35);
		jugador.getJuego().agregarEntidad(texto);
		
		List<Entidad> entidades = jugador.getJuego().getEntidades();
		Visitor v = new VisitorInfectadoCuarentena(null, true);
		
		for (Entidad e : entidades) {
			e.accept(v);
		}
		
	}
	
	protected void desactivar() {
		
		List<Entidad> entidades = jugador.getJuego().getEntidades();
		Visitor v = new VisitorInfectadoCuarentena(null, false);
		
		for (Entidad e : entidades) {
			e.accept(v);
		}
		
	}

}
