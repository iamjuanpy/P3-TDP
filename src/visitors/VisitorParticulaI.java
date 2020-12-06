package visitors;
import entidades.*;

public class VisitorParticulaI extends Visitor {

	public VisitorParticulaI(Entidad e) {
		super(e);
	}

	@Override
	public void visitJugador(Jugador j) {
		int da�o = ((ParticulaInfeccion) e).getDa�o();
		if (!j.getEscudo())
			j.setCV(j.getCV() + da�o);
		else j.setEscudo(false);
	}

}
