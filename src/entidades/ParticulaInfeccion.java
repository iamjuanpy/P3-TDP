package entidades;

import estrategias.EstrategiaDeleteInfeccion;
import visitors.Visitor;
import visitors.VisitorParticulaI;

import logica.Juego;
public class ParticulaInfeccion extends Proyectil {
	public ParticulaInfeccion(int da,Juego juego, int x, int y,  int vx, int vy) {
		super(da,juego,x,y,vx,-vy);
		
		grafico = new Grafico("Infeccion",x,y);
		visitante = new VisitorParticulaI(this);
		delStrat = new EstrategiaDeleteInfeccion(juego,this);
	}

	@Override
	public void accept(Visitor v) {
		v.visitParticulaI(this);
	}
	
	public String toString() {
		return "ParticulaInfeccion";
	}
	
}