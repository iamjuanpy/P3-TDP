package visitors;
import entidades.*;

public class VisitorInfectadoAlpha extends Visitor {

	public VisitorInfectadoAlpha(Entidad e) {
		super(e);
	}

	@Override
	public void visitJugador(Jugador j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitBala(Bala b) {
		b.eliminar();
		
	}

}
