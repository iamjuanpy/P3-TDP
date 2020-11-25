package visitors;

import entidades.InfectadoAlpha;
import entidades.InfectadoBeta;
import estrategias.EstrategiaMovInfectados;
import estrategias.EstrategiaMovNulo;

public class VisitorInfectadoCuarentena extends Visitor {

	boolean freeze;
	
	public VisitorInfectadoCuarentena(boolean v) {
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
