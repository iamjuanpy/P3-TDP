package visitors;
import entidades.*;

public abstract class Visitor {
	protected Entidad e;
	
	public Visitor(Entidad e) {
		this.e = e;
	}
	
	public void visitJugador(Jugador j) {}
	public void visitInfectadoA(InfectadoAlpha a) {}
	public void visitInfectadoB(InfectadoBeta b) {}
	public void visitParticulaI(ParticulaInfeccion p) {}
	public void visitBala(Bala b) {}
	public void visitPowerUp(PowerUp p) {}
	public void visitAnimacionTemporal(AnimacionTemporal a) {}
}
