package logic;

public abstract class Arma {

	protected Proyectil proyectil;
	protected int cadencia;
	
	public Arma(Proyectil p, int c) {
		proyectil = p;
		cadencia = c;
	}
	
	public void disparar() {
	}

}
