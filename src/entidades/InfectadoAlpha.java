package entidades;
import armas.ArmaInfectados;
import estrategias.EstrategiaMovInfectados;
import visitors.VisitorInfectadoAlpha;
import logica.Mapa;
import visitors.Visitor;

public class InfectadoAlpha extends Infectado {

	public InfectadoAlpha(Mapa m, int x, int y, int vx, int vy) {
		// Son faciles de desinfectar, pero hacen mas daño
		super(new ArmaInfectados(m, 15),m,x,y,vx, vy);
		grafico = new Grafico("InfectadoAlfa",x,y);
		setCV(cargaViralInicial/2);
		
		m.add(grafico);
		m.setComponentZOrder(grafico, 0);
		
		visitante = new VisitorInfectadoAlpha();
		movStrat = new EstrategiaMovInfectados(this);
	}

	@Override
	public void atacarMelee() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(Visitor v) {
		v.visitInfectadoA(this);		
	}
	
}
