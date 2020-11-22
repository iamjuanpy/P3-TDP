package entidades;
import logica.Mapa;
import visitors.Visitor;
import visitors.VisitorBala;

public class Bala extends Proyectil {

	public Bala(int da,Mapa m, int x, int y, int vx, int vy/*, Visitor v, EntidadGrafica g, EstrategiaMovimiento s, EstrategiaDelete d*/) {
		super(da,m,x,y,vx,vy);
		
		grafico = new Grafico ("Bala",x,y);
		m.add(grafico);
		m.setComponentZOrder(grafico,0);
		
		visitante = new VisitorBala();
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(Visitor v) {
		v.visitBala(this);
		
	}
	
	public String toString() {
		return "Bala";
	}
}
