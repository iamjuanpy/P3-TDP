package logic;

import javax.swing.ImageIcon;

public class EntidadGrafica {
	
	protected int x;
	protected int y;
	private ImageIcon entidad;
	
	public EntidadGrafica() {
		
		
		
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public ImageIcon getGrafico() {
		return this.entidad;
	}
	
	public void setGrafico(ImageIcon grafico) {
		this.entidad = grafico;
	}
	
	

}
