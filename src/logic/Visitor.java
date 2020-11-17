package logic;

public interface Visitor {

	public void visitJugador(Jugador j);
	public void visitInfectadoA(InfectadoAlpha a);
	public void visitInfectadoB(InfectadoBeta b);
	public void visitParticulasI(ParticulasInfeccion p);
	public void visitBalas(Balas b);
	public void visitPowerUps(PowerUps p);
	
	
}
