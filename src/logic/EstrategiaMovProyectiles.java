package logic;

public class EstrategiaMovProyectiles extends EstrategiaMovimiento{

	
	
	@Override
	public void mover() {
		
		int Y = e.getEntGrafica().getY();
		Y -= e.getVelocidadY();
	}
	
	
	

}
