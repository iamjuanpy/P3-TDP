package entidades;
import estrategias.EstrategiaDeleteGenerica;
import logica.Mapa;
import visitors.Visitor;
import visitors.VisitorBala;

public class Bala extends Proyectil {

	public Bala(int da,Mapa m, int x, int y, int vx, int vy) {
		super(da,m,x,y,vx,vy);
		
		grafico = new Grafico ("Bala",x,y);
		m.add(grafico);
		m.setComponentZOrder(grafico,0);
		
		visitante = new VisitorBala();
		delStrat = new EstrategiaDeleteGenerica(m,this);
	}

	@Override
	public void eliminar() {
		delStrat.delete();
		
	}

	@Override
	public void accept(Visitor v) {
		v.visitBala(this);
		
	}
	
	public String toString() {
		return "Bala";
	}
}
