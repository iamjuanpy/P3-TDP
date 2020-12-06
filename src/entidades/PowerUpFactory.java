package entidades;

import java.util.Random;

import logica.Juego;
import premios.*;

public class PowerUpFactory {
	private Juego juego;
	private Jugador jugador;
	private Random rng;

	public PowerUpFactory(Juego j, Jugador jugador) {
		juego = j;
		this.jugador = jugador;
		rng = new Random();
	}
	
	public void crearPowerUpRandom(int x, int y) {
		float f = rng.nextFloat();
		
		// Si no esta esta linea no compila porque p podria no estar inicializado
		PowerUp p = new PowerUp(new Pocion(jugador),juego,x,y,1,2);
		
		// Aun asi, el PowerUp se decide en este bloque
		if (f < .25f) {
			p = new PowerUp(new Pocion(jugador),juego,x,y,1,2);
		} else if (f >= .25f && f < .5f) {
			p = new PowerUp(new ArmaTemporal(jugador),juego,x,y,1,2);
		} else if (f >= .5f && f < .75f) {
			p = new PowerUp(new Cuarentena(jugador),juego,x,y,1,2);
		} else if (f >= .75f) {
			p = new PowerUp(new Escudo(jugador),juego,x,y,1,2);
		}
		
		juego.agregarEntidad(p);
	}
}
