package visitors;
import entidades.*;

public class VisitorJugador extends Visitor {
	public VisitorJugador(Entidad e) {
		super(e);
	}

	@Override
	public void visitInfectadoA(InfectadoAlpha a) {
		//a.atacarMelee();
	}

	@Override
	public void visitInfectadoB(InfectadoBeta b) {
		//b.atacarMelee();
	}

	@Override
	public void visitParticulaI(ParticulaInfeccion p) {
		p.eliminar();
	}

	@Override
	public void visitPowerUp(PowerUp p) {
		p.activar();
	}

}
