package visitors;
import entidades.*;

public class VisitorInfectadoAlpha extends Visitor {

	@Override
	public void visitJugador(Jugador j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitBala(Bala b) {
		b.eliminar();
		
	}

}
