package visitors;
import entidades.*;

public abstract class Visitor {
	public void visitJugador(Jugador j) {}
	public void visitInfectadoA(InfectadoAlpha a) {}
	public void visitInfectadoB(InfectadoBeta b) {}
	public void visitParticulaI(ParticulaInfeccion p) {}
	public void visitBala(Bala b) {}
	public void visitPowerUp(PowerUp p) {}
}
