package entidades;
import java.awt.event.KeyEvent;

import armas.ArmaDefault;
import estrategias.EstrategiaMovJugador;
import visitors.Visitor;
import visitors.VisitorJugador;
import logica.Mapa;

public class Jugador extends Humano {
	
	public Jugador(Mapa m, int x, int y, int vx, int vy) {
		super(0, new ArmaDefault(), m, x, y, vx ,vy);
		
		// En vez de hacer inyeccion de dependencias, cada Entidad inicializa
		// sus propias dependencias
		grafico = new Grafico("Jugador", x, y);
		m.add(grafico);
		 
		// this.delStrat = new EstrategiaDeleteJugador();
		visitante = new VisitorJugador();
		this.movStrat = new EstrategiaMovJugador(this);		
	}

	@Override
	public void actualizar() {
		movStrat.mover();		
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
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
