package entidades;
import estrategias.EstrategiaDeleteGenerica;
import logica.Mapa;
import visitors.Visitor;
import visitors.VisitorParticulaI;

public class ParticulaInfeccion extends Proyectil {
	public ParticulaInfeccion(int da,Mapa m, int x, int y,  int vx, int vy) {
		super(da,m,x,y,vx,-vy);
		
		grafico = new Grafico("Infeccion",x,y);
		m.add(grafico);
		m.setComponentZOrder(grafico,0);
		
		visitante = new VisitorParticulaI();
		delStrat = new EstrategiaDeleteGenerica(m,this);
	}

	@Override
	public void accept(Visitor v) {
		v.visitParticulaI(this);
	}
	
	public String toString() {
		return "ParticulaInfeccion";
	}
	
}