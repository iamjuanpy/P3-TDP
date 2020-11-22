package entidades;

import estrategias.EstrategiaMovProyectiles;
import logica.Mapa;

public abstract class Proyectil extends Entidad {

	int daño;
	
	public Proyectil(int da,Mapa m, int x, int y, int vx, int vy) {
		super(m, x, y, vx, vy);
		daño = da;
		movStrat = new EstrategiaMovProyectiles(this);
	}
	
	public void actualizar() {
		movStrat.mover();
	}
	
	public abstract String toString();
	
}
