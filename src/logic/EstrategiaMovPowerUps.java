package Logic;

public class EstrategiaMovPowerUps extends EstrategiaMovimiento{
	
	
	@Override
	public void mover() {
		
		int Y = e.getEntGrafica().getY();
		Y -= e.getVelocidadY();
	}
}
