package armas;

import entidades.Bala;
import entidades.Humano;
import entidades.ParticulaInfeccion;
import entidades.Proyectil;
import logica.Mapa;

public abstract class Arma {

	protected int cadencia;
	protected int daño;
	protected Mapa mapa;
	protected Humano owner;
	protected int timer;
	
	public Arma(Mapa m,int d, int c) {
		daño = d;
		cadencia = c;
		mapa = m;
		timer = 0;
	}
	
	public void setOwner(Humano h) {
		owner = h;
	}
	
	public void disparar() {
		Proyectil p;
		// Implementar cadencia
		
		// Por alguna razón el segundo y lo siguientes disparos salen mucho despues que el primero
		
		// Esto funciona solo si está manteniendo el boton de disparar
		// Porque si el jugador decide caminar dsps de disparar un poco
		// Cuando retome a disparar este contador no va a estar a 0 y no va a disparar hasta que lo esté
		/**
		if (timer == 0) {
			if (getClass().toString() == "armas.ArmaInfectados")
				p = new ParticulaInfeccion(0, mapa, owner.getEntidadGrafica().getX(), owner.getEntidadGrafica().getX(), 0, 10);
			else {
				p = new Bala(0, mapa, owner.getEntidadGrafica().getX(), owner.getEntidadGrafica().getY(), 0, 10);
				}
			timer++;
		}
		else {
			if (timer == cadencia)
				timer=0;
			else timer++;
		}
		**/
		
		if (getClass().toString() == "armas.ArmaInfectados")
			p = new ParticulaInfeccion(0, mapa, owner.getEntidadGrafica().getX(), owner.getEntidadGrafica().getX(), 0, 10);
		else {
			p = new Bala(0, mapa, owner.getEntidadGrafica().getX(), owner.getEntidadGrafica().getY(), 0, 10);
			}
	}

}
