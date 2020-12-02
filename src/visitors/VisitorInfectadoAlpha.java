package visitors;
import entidades.*;

public class VisitorInfectadoAlpha extends Visitor {

	public VisitorInfectadoAlpha(Entidad e) {
		super(e);
	}

	@Override
	public void visitJugador(Jugador j) {
		Infectado aux = (Infectado) e;
		if (!aux.getGolpeo()) {
			j.setCV(j.getCV() + aux.getDa�o());
			aux.atacarMelee();
		}
	}

	@Override
	public void visitBala(Bala b) {
		b.eliminar();
		
	}

}
