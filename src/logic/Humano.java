package logic;

public abstract class Humano extends Entidad{

	protected int cargaViral;
	protected Arma arma;
	
	public Humano(int cV, Arma a,Mapa m, int vx, int vy, Visitor v, EntidadGrafica g, EstrategiaMovimiento s, EstrategiaDelete d) {
		super(m,vx,vy,v,g,s,d);
		arma = a;
		cargaViral = cV;
	}
	
	public void disparar() {
		arma.disparar();
	}
	
}
