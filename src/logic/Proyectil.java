package logic;

public abstract class Proyectil extends Entidad{

	int da�o;
	
	public Proyectil(int da,Mapa m, int vx, int vy, Visitor v, EntidadGrafica g, EstrategiaMovimiento s, EstrategiaDelete d) {
		super(m,vx,vy,v,g,s,d);
		da�o = da;
	}
	
}
