package entidades;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

// cada Grafico conoce un unico mapeo de Strings a imagenes preinicializadas
// Cuando inicializas el grafico, solo le indicas que tipo de Entidad queres que sea
// y a partir de esa indicacion decide que imagen usar

public class Grafico extends JLabel {
	private static final long serialVersionUID = 1L;
	
	private static HashMap<String, ImageIcon> mapeoSprites;
	private ImageIcon imagen;
	private int x, y;	
	
	public Grafico(String tipo, int x, int y) {
		if (mapeoSprites == null) {
			mapeoSprites = new HashMap<String, ImageIcon>();
			mapeoSprites.put("Jugador", new ImageIcon("img/jugador.PNG"));
			mapeoSprites.put("InfectadoAlfa", new ImageIcon("img/infectadoA.png"));
			mapeoSprites.put("InfectadoBeta", new ImageIcon("img/infectadoB.png"));
			mapeoSprites.put("Bala", new ImageIcon("img/bala.png"));
		}
		
		imagen = mapeoSprites.get(tipo);
		setIcon(imagen);
		
		// Compensar por las dimensiones de la imagen
		// Relativo a la imagen, la coordenada (0,0) es la esquina
		// superior izquierda, y esto lo centra en la imagen.
		this.x = x - imagen.getIconWidth()/2;
		this.y = y - imagen.getIconHeight()/2;
		reposicionar();
	}
	
	private void reposicionar() {
		setBounds(this.x, this.y, imagen.getIconWidth(), imagen.getIconHeight());
	}
	
	// Ver si es necesaria este metodo y un setter correspondiente
	// Puede ser que sea util para un visitor o un powerup que cambie la apariencia de una Entidad
	/*public ImageIcon getImagen() {
		return imagen;
	}*/
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		reposicionar();
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
		reposicionar();
	}
	
	public int getAnchoImg() {
		return imagen.getIconWidth();
	}
	
	public int getAltoImg() {
		return imagen.getIconWidth();
	}

}
