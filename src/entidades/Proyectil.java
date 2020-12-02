package entidades;

import estrategias.EstrategiaMovProyectiles;
import logica.Juego;

public abstract class Proyectil extends Entidad {
	protected int da�o;
	
	public Proyectil(int da,Juego juego, int x, int y, int vx, int vy) {
		super(juego, x, y, vx, vy);
		da�o = da;
		movStrat = new EstrategiaMovProyectiles(this);
	}
	
	public int getDa�o() {
		return da�o;
	}
	
	public void actualizar() {
		movStrat.mover();
	}
	
	public abstract String toString();	
}
