package entidades;
import java.awt.event.KeyEvent;

import armas.ArmaDefault;
import estrategias.EstrategiaMovJugador;
import visitors.Visitor;
import visitors.VisitorJugador;
import logica.Mapa;

public class Jugador extends Humano {
	
	protected boolean escudo;
	
	public Jugador(Mapa m, int x, int y, int vx, int vy) {
		super(0, new ArmaDefault(m), m, x, y, vx ,vy);
		
		escudo = false;
		
		grafico = new Grafico("Jugador"+getArmaSeleccionada(), x, y);
		m.add(grafico);
		m.setComponentZOrder(grafico, 0);
		 
		// this.delStrat = new EstrategiaDeleteJugador();
		visitante = new VisitorJugador();
		this.movStrat = new EstrategiaMovJugador(this);		
	}
	

	@Override
	public void actualizar() {
		movStrat.mover();
		arma.tick();
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
	
}
