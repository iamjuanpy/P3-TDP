package visitors;
import entidades.*;

public class VisitorInfectadoBeta extends Visitor {

	public VisitorInfectadoBeta(Entidad e) {
		super(e);
	}

	@Override
	public void visitJugador(Jugador j) {
		Infectado aux = (Infectado) e;
		if (!aux.getGolpeo()) {
			if (!j.getEscudo())
				j.setCV(j.getCV() + aux.getDa�o());
			else j.setEscudo(false);
		aux.atacarMelee();
		}
	}
	
	@Override
	public void visitBala(Bala b) {
		b.eliminar();
	}

}
