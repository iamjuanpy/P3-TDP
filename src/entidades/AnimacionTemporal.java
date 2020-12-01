package entidades;

import estrategias.EstrategiaDeleteGenerica;
import logica.Juego;
import visitors.Visitor;
import visitors.VisitorAnimacionTemporal;

public class AnimacionTemporal extends Entidad{

	private int duracion;

	public AnimacionTemporal(String g,Juego juego, int x, int y, int vx, int vy, int duracion) {
		
		super(juego, x, y, vx, vy);
		this.duracion = duracion;
		
		grafico = new Grafico(g,x,y);
		
		
		visitante = new VisitorAnimacionTemporal();
		delStrat = new EstrategiaDeleteGenerica(juego,this);
	}

	@Override
	public void actualizar() {
		duracion--;
		
		if (duracion<0) {
			grafico.setVisible(false);
			delStrat.delete();
		}
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
