package entidades;
import armas.Arma;
import logica.Juego;

public abstract class Infectado extends Humano {
	
	protected static int cargaViralInicial = 100;
	
	public Infectado(Arma a,Juego juego, int x, int y, int vx, int vy) {
		super(a, juego, x, y, vx, vy);
	}
	
	public abstract void atacarMelee();
	
}
