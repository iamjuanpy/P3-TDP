package logic;

public abstract class Proyectil extends Entidad{

	int daño;
	
	public Proyectil(int da,Mapa m, int vx, int vy, Visitor v, EntidadGrafica g, EstrategiaMov s, EstrategiaDelete d) {
		super(m,vx,vy,v,g,s,d);
		daño = da;
	}
	
}
