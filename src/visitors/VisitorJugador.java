package visitors;
import entidades.*;

public class VisitorJugador extends Visitor {
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
	public void visitPowerUp(PowerUp p) {
		p.activar();
	}

}
