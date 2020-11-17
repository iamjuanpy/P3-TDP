package logic;

public abstract class Infectado extends Humano{

	public Infectado(Arma a,Mapa m, int vx, int vy, Visitor v, EntidadGrafica g, EstrategiaMov s, EstrategiaDelete d) {
		super(100,a,m,vx,vy,v,g,s,d);
	}
	
	public abstract void atacarMelee();
	
}
