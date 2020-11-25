package entidades;
import armas.Arma;
import logica.Mapa;

public abstract class Infectado extends Humano {
	
	protected static int cargaViralInicial = 100;
	
	public Infectado(Arma a,Mapa m, int x, int y, int vx, int vy) {
		super(a, m, x, y, vx, vy);
	}
	
	public abstract void atacarMelee();
	
}
