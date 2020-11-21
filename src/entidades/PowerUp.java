package entidades;
import visitors.Visitor;
import visitors.VisitorPowerUp;
import logica.Mapa;
import premios.EfectoPowerUp;

public class PowerUp extends Entidad {

	private EfectoPowerUp e;
	
	public PowerUp(EfectoPowerUp e,Mapa m, int x, int y, int vx, int vy) {
		super(m,x,y,vx,vy);
		this.e = e;
		
		visitante = new VisitorPowerUp();
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(Visitor v) {
		v.visitPowerUp(this);		
	}
	
}
