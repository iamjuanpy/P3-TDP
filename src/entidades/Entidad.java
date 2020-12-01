package entidades;
import java.awt.Rectangle;
import java.util.List;

import estrategias.EstrategiaDelete;
import estrategias.EstrategiaMovimiento;
import logica.Juego;
import visitors.Visitor;

public abstract class Entidad {
	protected Grafico grafico;
	protected int velocidadX, velocidadY;
	
	protected boolean eliminado;
	protected Visitor visitante;
	protected Juego juego;
	protected EstrategiaMovimiento movStrat;
	protected EstrategiaDelete delStrat;
	
	public Entidad(Juego juego, int x, int y, int vx, int vy) {
		// parametros para inicializar una Entidad:
		// posicion inicial, imagen, velocidad en los dos ejes
		
		this.juego = juego;
		eliminado = false;		
		velocidadX = vx;
		velocidadY = vy;
	}
	
	public void buscarColisiones(List<Entidad> l) {
		for (Entidad ent : l) {
			if ((ent != this) && (hayColision(ent))) {
				ent.accept(visitante);
			}
		}
	}
	
	protected boolean hayColision(Entidad e) {
		Rectangle b1 = grafico.getBounds();
		Rectangle b2 = e.getEntidadGrafica().getBounds();
		return b1.intersects(b2);
	}
	
	public void eliminar() {
		delStrat.delete();
	}
	
	public abstract void actualizar();
	public abstract void accept(Visitor v);
	
	public Grafico getEntidadGrafica() {
		return grafico;
	}
	
	public Juego getJuego() {
		return juego;
	}

	public Visitor getVisitor() {
		return visitante;
	}
	
	public int getVelocidadX() {
		return velocidadX;
	}

	public void setVelocidadX(int velocidadX) {
		this.velocidadX = velocidadX;
	}

	public int getVelocidadY() {
		return velocidadY;
	}

	public void setVelocidadY(int velocidadY) {
		this.velocidadY = velocidadY;
	}

	public boolean estaEliminado() {
		return eliminado;
	}
	
	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
	
	public void setEstrategiaMov(EstrategiaMovimiento e) {
		movStrat = e;
	}
	
}