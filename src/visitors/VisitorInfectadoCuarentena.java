package visitors;

import entidades.Entidad;
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
		if (freeze)
			a.setEstrategiaMov(new EstrategiaMovNulo(a));
		else a.setEstrategiaMov(new EstrategiaMovInfectados(a));
	}

	@Override
	public void visitInfectadoB(InfectadoBeta b) {
		if (freeze)
			b.setEstrategiaMov(new EstrategiaMovNulo(b));
		else b.setEstrategiaMov(new EstrategiaMovInfectados(b));
	}
}
