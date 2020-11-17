package logic;

public class PowerUps extends Entidad{

	public EfectoPowerUp e;
	
	public PowerUps(EfectoPowerUp e,Mapa m, int vx, int vy, Visitor v, EntidadGrafica g, EstrategiaMovimiento s, EstrategiaDelete d) {
		super(m,vx,vy,v,g,s,d);
		this.e = e;
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}
	
}
