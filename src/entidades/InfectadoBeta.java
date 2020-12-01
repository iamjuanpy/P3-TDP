package entidades;
import armas.ArmaInfectados;
import logica.Juego;
import estrategias.EstrategiaMovInfectados;
import visitors.Visitor;
import visitors.VisitorInfectadoBeta;

public class InfectadoBeta extends Infectado {

	public InfectadoBeta(Juego juego, int x, int y, int vx, int vy) {
		// Son mas dificiles de desinfectar, pero hacen menos daño
		super(new ArmaInfectados(juego, 10),juego,x,y,vx,vy);
		setCV(cargaViralInicial);
		
		grafico = new Grafico("InfectadoBeta",x,y);
		
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
