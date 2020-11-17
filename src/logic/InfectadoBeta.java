package logic;

public class InfectadoBeta extends Infectado {

	public InfectadoBeta(Mapa m, int vx, int vy, Visitor v, EntidadGrafica g, EstrategiaMov s, EstrategiaDelete d) {
		super(new ArmaInfectados(),m,vx,vy,v,g,s,d);
	}

	@Override
	public void atacarMelee() {
		// TODO Auto-generated method stub
		
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
