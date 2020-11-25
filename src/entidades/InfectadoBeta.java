package entidades;
import armas.ArmaInfectados;
import estrategias.EstrategiaMovInfectados;
import logica.Mapa;
import visitors.Visitor;
import visitors.VisitorInfectadoBeta;

public class InfectadoBeta extends Infectado {

	public InfectadoBeta(Mapa m, int x, int y, int vx, int vy) {
		// Son mas dificiles de desinfectar, pero hacen menos daño
		super(new ArmaInfectados(m, 10),m,x,y,vx,vy);
		setCV(cargaViralInicial);
		
		grafico = new Grafico("InfectadoBeta",x,y);
		
		m.add(grafico);
		m.setComponentZOrder(grafico, 0);
		
		visitante = new VisitorInfectadoBeta();
		movStrat = new EstrategiaMovInfectados(this);
	}

	@Override
	public void atacarMelee() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(Visitor v) {
		v.visitInfectadoB(this);		
	}
	
}
