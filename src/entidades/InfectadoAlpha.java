package entidades;
import java.util.Random;

import armas.ArmaInfectados;
import estrategias.EstrategiaMovInfectados;
import visitors.VisitorInfectadoAlpha;
import logica.Juego;
import visitors.Visitor;

public class InfectadoAlpha extends Infectado {

	private boolean acelero;
	
	public InfectadoAlpha(Juego juego, int x, int y, int vx, int vy, float multiplicadorDaño) {
		// Son faciles de desinfectar, pero hacen mas daño
		super(new ArmaInfectados(juego, (int) (15 * multiplicadorDaño) ),juego,x,y,vx,vy);
		setCV(cargaViralInicial/2);
		acelero = false;
		
		Random r = new Random();
		
		if (r.nextFloat()< 0.5f)
			grafico = new Grafico("InfectadoAlfa",x,y);
		else grafico = new Grafico("InfectadoAlfa2",x,y);
		
		visitante = new VisitorInfectadoAlpha(this);
		movStrat = new EstrategiaMovInfectados(this);
	}
	
	@Override
	public void actualizar() {
		super.actualizar();
		
		if (!acelero && getCV() <= (cargaViralInicial/2)*0.2) {
			velocidadY = velocidadY+2;
			acelero = true;
		}
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
		v.visitInfectadoA(this);		
	}
	
}
