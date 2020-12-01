package entidades;

import armas.Arma;
import logica.Juego;

public abstract class Humano extends Entidad {

	protected int cargaViral;
	protected Arma arma;
	
	public Humano(Arma a,Juego juego, int x, int y, int vx, int vy) {
		super(juego,x,y,vx,vy);
		
		arma = a;
		a.setOwner(this);
	}
	
	public void actualizar() {
		movStrat.mover();
		arma.tick();
	}
	
	public String getArmaSeleccionada() {
		return arma.getNombre();
	}
	
	public void setArma(Arma a) {
		arma = a;
	}
	
	public void disparar() {
		arma.disparar();
	}
	
	public void setCV(int a) {
		
		cargaViral = a;
		
		if (cargaViral < 0)
			cargaViral = 0;
		if (cargaViral > 100)
			cargaViral = 100;
	}
	
	public int getCV() {
		return cargaViral;
	}
	
}