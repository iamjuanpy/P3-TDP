package entidades;
import visitors.Visitor;
import visitors.VisitorPowerUp;
import estrategias.EstrategiaDeleteGenerica;
import estrategias.EstrategiaMovPowerUps;
import logica.Mapa;
import premios.EfectoPowerUp;

public class PowerUp extends Entidad {

	private EfectoPowerUp e;
	
	public PowerUp(EfectoPowerUp e, Mapa m, int x, int y, int vx, int vy) {
		super(m,x,y,vx,vy);
		this.e = e;
		
		visitante = new VisitorPowerUp();
		movStrat = new EstrategiaMovPowerUps(this);
		delStrat = new EstrategiaDeleteGenerica(m, this);
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
