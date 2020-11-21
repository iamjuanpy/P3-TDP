package entidades;

import logica.Mapa;

public abstract class Proyectil extends Entidad {

	int daño;
	
	public Proyectil(int da,Mapa m, int x, int y, int vx, int vy) {
		super(m, x, y, vx, vy);
		grafico = new Grafico("Bala", x, y);
		daño = da;
	}
	
}
