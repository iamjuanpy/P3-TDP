package entidades;
import armas.ArmaInfectados;
import estrategias.EstrategiaMovInfectados;
import visitors.VisitorInfectadoAlpha;
import logica.Juego;
import visitors.Visitor;

public class InfectadoAlpha extends Infectado {

	public InfectadoAlpha(Juego juego, int x, int y, int vx, int vy) {
		// Son faciles de desinfectar, pero hacen mas daño
		super(new ArmaInfectados(juego, 15),juego,x,y,vx, vy);
		grafico = new Grafico("InfectadoAlfa",x,y);
		setCV(cargaViralInicial/2);
		
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
