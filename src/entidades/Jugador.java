package entidades;

import java.awt.event.KeyEvent;

import armas.ArmaDefault;
import estrategias.EstrategiaDeleteJugador;
import estrategias.EstrategiaMovJugador;
import visitors.Visitor;
import visitors.VisitorJugador;
import logica.Juego;
import premios.EfectoTemporal;

public class Jugador extends Humano {
	
	protected boolean escudo;
	protected EfectoTemporal ef;
	
	public Jugador(Juego juego, int x, int y, int vx, int vy) {
		super(new ArmaDefault(juego), juego, x, y, vx ,vy);
		setCV(0);
		
		escudo = false;
		ef = null;
		
		grafico = new Grafico("Jugador"+getArmaSeleccionada(), x, y);
		 
		this.delStrat = new EstrategiaDeleteJugador(juego,this);
		visitante = new VisitorJugador(this);
		this.movStrat = new EstrategiaMovJugador(this);		
	}
	
	public Juego getJuego() {
		return juego;
	}
	

	@Override
	public void actualizar() {

		super.actualizar();
		if (ef != null) {
			ef.tick();
		}
		
		if (getCV() >= 100) {
			eliminar();
		}

	}
	
	public void setEscudo(boolean v) {
		escudo = v;
	}
	
	public boolean getEscudo() {
		return escudo;
	}
	
	@Override
	public void accept(Visitor v) {
		v.visitJugador(this);	
	}
	
	public void keyPressed(KeyEvent e) {
		((EstrategiaMovJugador)movStrat).keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e) {
		((EstrategiaMovJugador)movStrat).keyReleased(e);
	}


	public void setEfectoTemporal(EfectoTemporal ef) {
		this.ef = ef;
	}
	
}