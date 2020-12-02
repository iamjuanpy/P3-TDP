package entidades;

import estrategias.EstrategiaMovProyectiles;
import logica.Juego;

public abstract class Proyectil extends Entidad {
	protected int daño;
	
	public Proyectil(int da,Juego juego, int x, int y, int vx, int vy) {
		super(juego, x, y, vx, vy);
		daño = da;
		movStrat = new EstrategiaMovProyectiles(this);
	}
	
	public int getDaño() {
		return daño;
	}
	
	public void actualizar() {
		movStrat.mover();
	}
	
	public abstract String toString();	
}
