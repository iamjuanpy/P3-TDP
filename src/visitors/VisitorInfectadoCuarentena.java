package visitors;

import entidades.Entidad;
import entidades.Grafico;
import entidades.InfectadoAlpha;
import entidades.InfectadoBeta;
import estrategias.EstrategiaMovInfectados;
import estrategias.EstrategiaMovNulo;

public class VisitorInfectadoCuarentena extends Visitor {

	boolean freeze;
	
	// No usamos la entidad en este visitor
	public VisitorInfectadoCuarentena(Entidad e, boolean v) {
		super(e);
		freeze = v;
	}

	@Override
	public void visitInfectadoA(InfectadoAlpha a) {
		
		Grafico g = a.getEntidadGrafica();
		String str = g.toString();
		
		if (freeze) {
			a.setEstrategiaMov(new EstrategiaMovNulo(a));
			g.setImagen(str+"S");
		}
		else {
			a.setEstrategiaMov(new EstrategiaMovInfectados(a));
			g.setImagen(str.replace("S",""));
		}
	}

	@Override
	public void visitInfectadoB(InfectadoBeta b) {
		
		Grafico g = b.getEntidadGrafica();
		String str = g.toString();
		
		if (freeze) {
			b.setEstrategiaMov(new EstrategiaMovNulo(b));
			g.setImagen(str+"S");
		}
		else { 
			b.setEstrategiaMov(new EstrategiaMovInfectados(b));
			g.setImagen(str.replace("S",""));
		}
	}
}
