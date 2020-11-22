package entidades;
import logica.Mapa;
import visitors.Visitor;
import visitors.VisitorParticulaI;

public class ParticulaInfeccion extends Proyectil {

	public ParticulaInfeccion(int da,Mapa m, int x, int y,  int vx, int vy/*, Visitor v, EntidadGrafica g, EstrategiaMovimiento s, EstrategiaDelete d*/) {
		super(da,m,x,y,vx,vy);
		
		grafico = new Grafico("Bala",x,y);
		m.add(grafico);
		m.setComponentZOrder(grafico,0);
		
		visitante = new VisitorParticulaI();
	}


	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(Visitor v) {
		v.visitParticulaI(this);
	}
	
	public String toString() {
		return "ParticulaInfeccion";
	}
	
}
