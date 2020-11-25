package visitors;
import entidades.*;

public class VisitorJugador implements Visitor {

	@Override
	public void visitJugador(Jugador j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitInfectadoA(InfectadoAlpha a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitInfectadoB(InfectadoBeta b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitParticulaI(ParticulaInfeccion p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitBala(Bala b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitPowerUp(PowerUp p) {
		p.activar();
	}

}
