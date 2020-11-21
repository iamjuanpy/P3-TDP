package entidades;
import armas.Arma;
import logica.Mapa;

public abstract class Infectado extends Humano{
	
	private static int cargaViralInfectado = 100;

	public Infectado(Arma a,Mapa m, int x, int y, int vx, int vy) {
		super(cargaViralInfectado, a, m, x, y, vx, vy);
	}
	
	public abstract void atacarMelee();
	
}
