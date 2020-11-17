package logic;

import java.util.List;

public abstract class Entidad {

	protected int velocidadX;
	protected int velocidadY;
	protected Visitor visitante;
	protected EntidadGrafica grafico;
	protected Mapa map;
	protected EstrategiaMovimiento movStrat;
	protected EstrategiaDelete delStrat;
	
	public Entidad(Mapa m, int vx, int vy, Visitor v, EntidadGrafica g, EstrategiaMovimiento s, EstrategiaDelete d) {
		map = m;
		velocidadX = vx;
		velocidadY = vy;
		visitante = v;
		grafico = g;
		movStrat = s;
		delStrat = d;
	}
	
	public abstract void mover();
	public abstract void eliminar();
	public abstract void accept(Visitor v);
	
	public List<Entidad> detectarColisiones(){
		return null;
	}
	
	public EntidadGrafica getEntGrafica() {
		return null;
	}
	
	public int getVelocidadX() {return velocidadX;}
	public int getVelocidadY() {return velocidadY;}
	
}
