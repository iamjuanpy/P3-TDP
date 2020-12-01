package entidades;
import visitors.Visitor;
import visitors.VisitorPowerUp;
import estrategias.EstrategiaDeleteGenerica;
import estrategias.EstrategiaMovPowerUps;
import logica.Juego;
import premios.EfectoPowerUp;

public class PowerUp extends Entidad {

	private EfectoPowerUp e;
	
	public PowerUp(EfectoPowerUp e, Juego juego, int x, int y, int vx, int vy) {
		super(juego,x,y,vx,vy);
		this.e = e;
		
		grafico = new Grafico("PowerUp",x,y);
		
		visitante = new VisitorPowerUp();
		movStrat = new EstrategiaMovPowerUps(this);
		delStrat = new EstrategiaDeleteGenerica(juego, this);
	}

	public void activar() {
		e.activar();
		delStrat.delete();
	}
	
	@Override
	public void actualizar() {
		movStrat.mover();
	}

	@Override
	public void accept(Visitor v) {
		v.visitPowerUp(this);		
	}
	
}
