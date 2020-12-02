package visitors;
import entidades.*;

public class VisitorBala extends Visitor {
	public VisitorBala(Entidad e) {
		super(e);
	}

	@Override
	public void visitInfectadoA(InfectadoAlpha a) {
		int da�o = ((Bala) e).getDa�o();
		a.setCV(a.getCV() - da�o);
	}

	@Override
	public void visitInfectadoB(InfectadoBeta b) {
		int da�o = ((Bala) e).getDa�o();
		b.setCV(b.getCV() - da�o);
	}
}
