package entidades;
import estrategias.EstrategiaDeleteBala;
import logica.Juego;

import visitors.Visitor;
import visitors.VisitorBala;

public class Bala extends Proyectil {

	public Bala(int da,Juego juego, int x, int y, int vx, int vy) {
		super(da,juego,x,y,vx,vy);
		
		grafico = new Grafico ("Bala",x,y);
		
		visitante = new VisitorBala();
		delStrat = new EstrategiaDeleteBala(juego,this);
	}

	@Override
	public void accept(Visitor v) {
		v.visitBala(this);
		
	}
	
	public String toString() {
		return "Bala";
	}
}
