package entidades;
import armas.ArmaInfectados;
import logica.Mapa;
import visitors.Visitor;
import visitors.VisitorInfectadoBeta;

public class InfectadoBeta extends Infectado {

	public InfectadoBeta(Mapa m, int x, int y, int vx, int vy) {
		super(new ArmaInfectados(m),m,x,y,vx,vy);	
		
		grafico = new Grafico("InfectadoBeta",x,y);
		
		m.add(grafico);
		m.setComponentZOrder(grafico, 1);
		
		visitante = new VisitorInfectadoBeta();
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
		v.visitInfectadoB(this);		
	}
	
}
