package entidades;
import armas.ArmaInfectados;
import visitors.VisitorInfectadoAlpha;
import logica.Mapa;
import visitors.Visitor;

public class InfectadoAlpha extends Infectado {

	public InfectadoAlpha(Mapa m, int x, int y, int vx, int vy) {
		super(new ArmaInfectados(m),m,x,y,0,10);
		grafico = new Grafico("InfectadoAlfa",x,y);
		
		m.add(grafico);
		m.setComponentZOrder(grafico, 1);
		
		visitante = new VisitorInfectadoAlpha();
	}

	@Override
	public void atacarMelee() {
		// TODO Auto-generated method stub
		
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
		v.visitInfectadoA(this);		
	}
	
}
