package entidades;
import java.awt.event.KeyEvent;

import armas.ArmaDefault;
import estrategias.EstrategiaMovJugador;
import visitors.Visitor;
import visitors.VisitorJugador;
import logica.Mapa;
import premios.EfectoTemporal;

public class Jugador extends Humano {
	
	protected boolean escudo;
	protected EfectoTemporal ef;
	
	public Jugador(Mapa m, int x, int y, int vx, int vy) {
		super(new ArmaDefault(m), m, x, y, vx ,vy);
		setCV(0);
		
		escudo = false;
		ef = null;
		
		grafico = new Grafico("Jugador"+getArmaSeleccionada(), x, y);
		m.add(grafico);
		m.setComponentZOrder(grafico, 0);
		 
		// this.delStrat = new EstrategiaDeleteJugador();
		visitante = new VisitorJugador();
		this.movStrat = new EstrategiaMovJugador(this);		
	}
	

	@Override
	public void actualizar() {

		super.actualizar();
		if (ef != null) {
			ef.tick();
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
