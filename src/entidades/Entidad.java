package entidades;
import java.awt.Rectangle;
import java.util.List;

import estrategias.EstrategiaDelete;
import estrategias.EstrategiaMovimiento;
import logica.Mapa;
import visitors.Visitor;

public abstract class Entidad {
	protected Grafico grafico;
	protected int velocidadX, velocidadY;
	
	protected Visitor visitante;
	protected Mapa map;
	protected EstrategiaMovimiento movStrat;
	protected EstrategiaDelete delStrat;
	
	public Entidad(Mapa m, int x, int y, int vx, int vy) {
		// parametros para inicializar una Entidad:
		// posicion inicial, imagen, velocidad en los dos ejes
		
		// cada clase que especializa Entidad inicializa su visitor y estrategias correctas?
		map = m;
		
		velocidadX = vx;
		velocidadY = vy;
		
		map.agregarEntidad(this);
		
	}
	
	public void buscarColisiones(List<Entidad> l) {
		for (Entidad ent : l) {
			if ((ent != this) && (hayColision(ent))) {
				ent.accept(visitante);
				this.accept(ent.getVisitor());
			}
		}
	}
	
	protected boolean hayColision(Entidad e) {
		Rectangle b1 = grafico.getBounds();
		Rectangle b2 = e.getEntidadGrafica().getBounds();
		return b1.intersects(b2);
	}
	
	public abstract void actualizar();
	public abstract void eliminar();
	public abstract void accept(Visitor v);
	
	public Grafico getEntidadGrafica() {
		return grafico;
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
	
	public Visitor getVisitor() {
		return visitante;
	}
	
}