package visitors;
import entidades.*;

public class VisitorParticulaI extends Visitor {

	public VisitorParticulaI(Entidad e) {
		super(e);
	}

	@Override
	public void visitJugador(Jugador j) {
		int daño = ((ParticulaInfeccion) e).getDaño();
		j.setCV(j.getCV() + daño);
	}

}
