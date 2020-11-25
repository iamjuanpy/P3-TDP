package visitors;

import entidades.Bala;
import entidades.InfectadoAlpha;
import entidades.InfectadoBeta;
import entidades.Jugador;
import entidades.ParticulaInfeccion;
import entidades.PowerUp;
import estrategias.EstrategiaMovInfectados;
import estrategias.EstrategiaMovNulo;

public class VisitorInfectadoCuarentena implements Visitor{

	boolean freeze;
	
	public VisitorInfectadoCuarentena(boolean v) {
		freeze = v;
	}
	
	@Override
	public void visitJugador(Jugador j) {
	}

	@Override
	public void visitInfectadoA(InfectadoAlpha a) {
		if (freeze)
			a.setEstrategiaMov(new EstrategiaMovNulo(a));
		else a.setEstrategiaMov(new EstrategiaMovInfectados(a));
	}

	@Override
	public void visitInfectadoB(InfectadoBeta b) {
		if (freeze)
			b.setEstrategiaMov(new EstrategiaMovNulo(b));
		else b.setEstrategiaMov(new EstrategiaMovInfectados(b));
	}

	@Override
	public void visitParticulaI(ParticulaInfeccion p) {

	}

	@Override
	public void visitBala(Bala b) {

	}

	@Override
	public void visitPowerUp(PowerUp p) {

	}

}
