package logic;

import java.awt.event.KeyEvent;

public class EstrategiaMovJugador extends EstrategiaMovimiento {
	
	protected int velocidad = e.getVelocidadX();

	@Override
	public void mover() {
		
		int x = e.getEntGrafica().getX();
		
		x += direccion;

		//Faltaria ver los de los bordes creo
		
	}
	public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            direccion = -velocidad;
        }

        if (key == KeyEvent.VK_RIGHT) {
            direccion = velocidad;
        }
    }
	
	
	
	

}
