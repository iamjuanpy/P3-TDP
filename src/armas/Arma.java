package armas;

import entidades.Bala;
import entidades.Humano;
import logica.Juego;

public abstract class Arma {

	protected int cadencia;
	protected int da�o;
	protected Juego juego;
	protected Humano owner;
	protected int timer;
	protected String nombre;
	protected int offsetArmaX;
	protected int offsetArmaY;
	
	public Arma(Juego juego,int d,int c) {
		da�o = d;
		cadencia = c;
		this.juego = juego;
		timer = 0;
	}
	
	public void setOwner(Humano h) {
		owner = h;
	}
	
	/**
	 * El due�o del arma le envia un tick() cada actualizaci�n para hacer
	 * que el timer sea independiente de las veces que el usuario presiona la tecla de disparo
	 */
	public void tick() {
		// System.out.println("timer: " + timer); // DEBUG
		// Por alguna raz�n el segundo y lo siguientes disparos salen mucho despues que el primero
		// Esto funciona solo si est� manteniendo el boton de disparar
		// Porque si el jugador decide caminar dsps de disparar un poco
		// Cuando retome a disparar este contador no va a estar a 0 y no va a disparar hasta que lo est�
		
		if (timer != 0) {
			timer++;
		}	
		
		if (timer > cadencia) {
			timer = 0;
		}
	}
	
	public void disparar() {
		int x = owner.getEntidadGrafica().getX();
		int y = owner.getEntidadGrafica().getY();
		
		if (timer == 0) {
			Bala b = new Bala(da�o, juego, x+offsetArmaX, y, 0, 10);
			juego.agregarEntidad(b);
			timer++;
		}
	}
	
	public String getNombre() {
		return nombre;
	}

}
