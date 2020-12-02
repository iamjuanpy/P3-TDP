package visitors;
import entidades.*;

public class VisitorBala extends Visitor {
	public VisitorBala(Entidad e) {
		super(e);
	}

	@Override
	public void visitInfectadoA(InfectadoAlpha a) {
		int daño = ((Bala) e).getDaño();
		a.setCV(a.getCV() - daño);
	}

	@Override
	public void visitInfectadoB(InfectadoBeta b) {
		int daño = ((Bala) e).getDaño();
		b.setCV(b.getCV() - daño);
	}
}
