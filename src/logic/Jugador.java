package logic;

public class Jugador extends Humano {
	
	public Jugador(Mapa m, int vx, int vy, Visitor v, EntidadGrafica g, EstrategiaMovimiento s, EstrategiaDelete d) {
		super(0,new ArmaDefault(),m,vx,vy,v,g,s,d);
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
