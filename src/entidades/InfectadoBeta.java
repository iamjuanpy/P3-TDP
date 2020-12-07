package entidades;

import armas.ArmaInfectados;
import logica.Juego;
import estrategias.EstrategiaMovInfectados;
import visitors.Visitor;
import visitors.VisitorInfectadoBeta;

public class InfectadoBeta extends Infectado {

	public InfectadoBeta(Juego juego, int x, int y, int vx, int vy, float multiplicadorDaño) {
		// Son mas dificiles de desinfectar, pero hacen menos daño
		super(new ArmaInfectados(juego, (int) (10 * multiplicadorDaño) ),juego,x,y,vx,vy);
		setCV(cargaViralInicial);
		
		grafico = new Grafico("InfectadoBeta",x,y);
		
		visitante = new VisitorInfectadoBeta(this);
		movStrat = new EstrategiaMovInfectados(this);
	}

	@Override
	public void atacarMelee() {
		
		if (!golpeo) {
			int xEfec = juego.getPlayer().getEntidadGrafica().getX()+20;
			int yEfec = juego.getPlayer().getEntidadGrafica().getY()+25;
			Entidad ent = new AnimacionTemporal("Melee",juego,xEfec,yEfec,0,0,5);
			juego.agregarEntidad(ent);
			golpeo = true;
		}
		
	}

	@Override
	public void accept(Visitor v) {
		v.visitInfectadoB(this);		
	}
	
}
