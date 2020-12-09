package entidades;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Grafico extends JLabel {
	private static final long serialVersionUID = 1L;
	
	// cada Grafico conoce un unico mapeo de Strings a imagenes preinicializadas
	// Cuando se inicializa el grafico, solo se le indica que tipo de Entidad
	// tiene que representar y a partir de esa indicacion decide que imagen usar
	private static HashMap<String, ImageIcon> mapeoSprites;
	
	private ImageIcon imagen;
	private int x, y;	
	private String toString;
	
	public Grafico(String tipo, int x, int y) {
		if (mapeoSprites == null) {
			mapeoSprites = new HashMap<String, ImageIcon>();
			// Jugador
			mapeoSprites.put("JugadorDefault", new ImageIcon(getClass().getResource("/img/jugador.png")));
			mapeoSprites.put("JugadorDefaultDisp", new ImageIcon(getClass().getResource("/img/jugadorDisp.gif")));
			mapeoSprites.put("JugadorDefaultIzq", new ImageIcon(getClass().getResource("/img/jugadorIzq.gif")));
			mapeoSprites.put("JugadorDefaultDer", new ImageIcon(getClass().getResource("/img/jugadorDer.gif")));
			mapeoSprites.put("JugadorSuper", new ImageIcon(getClass().getResource("/img/jugadorSuper.png")));
			mapeoSprites.put("JugadorSuperDisp", new ImageIcon(getClass().getResource("/img/jugadorSuperDisp.gif")));
			mapeoSprites.put("JugadorSuperIzq", new ImageIcon(getClass().getResource("/img/jugadorSuperIzq.gif")));
			mapeoSprites.put("JugadorSuperDer", new ImageIcon(getClass().getResource("/img/jugadorSuperDer.gif")));
			mapeoSprites.put("JugadorRapida", new ImageIcon(getClass().getResource("/img/jugadorRapida.png")));
			mapeoSprites.put("JugadorRapidaDisp", new ImageIcon(getClass().getResource("/img/jugadorRapidaDisp.gif")));
			mapeoSprites.put("JugadorRapidaIzq", new ImageIcon(getClass().getResource("/img/jugadorRapidaIzq.gif")));
			mapeoSprites.put("JugadorRapidaDer", new ImageIcon(getClass().getResource("/img/jugadorRapidaDer.gif")));
			mapeoSprites.put("Muerte", new ImageIcon(getClass().getResource("/img/muerte.png")));
			// Infectados
			mapeoSprites.put("InfectadoAlfa", new ImageIcon(getClass().getResource("/img/infectadoA.gif")));
			mapeoSprites.put("InfectadoAlfa2", new ImageIcon(getClass().getResource("/img/infectadoA2.gif")));
			mapeoSprites.put("InfectadoBeta", new ImageIcon(getClass().getResource("/img/infectadoB.gif")));
			mapeoSprites.put("InfectadoBeta2", new ImageIcon(getClass().getResource("/img/infectadoB2.gif")));
			mapeoSprites.put("InfectadoAlfaS", new ImageIcon(getClass().getResource("/img/infectadoAStill.png")));
			mapeoSprites.put("InfectadoAlfa2S", new ImageIcon(getClass().getResource("/img/infectadoA2Still.png")));
			mapeoSprites.put("InfectadoBetaS", new ImageIcon(getClass().getResource("/img/infectadoBStill.png")));
			mapeoSprites.put("InfectadoBeta2S", new ImageIcon(getClass().getResource("/img/infectadoB2Still.png")));
			// Misc
			mapeoSprites.put("Bala", new ImageIcon(getClass().getResource("/img/bala.png")));
			mapeoSprites.put("Infeccion", new ImageIcon(getClass().getResource("/img/infeccion.png")));
			mapeoSprites.put("PowerUp", new ImageIcon(getClass().getResource("/img/powerup.gif")));
			mapeoSprites.put("DeleteInfeccion", new ImageIcon(getClass().getResource("/img/hitInfeccion.gif")));
			mapeoSprites.put("DeleteBala", new ImageIcon(getClass().getResource("/img/healing.gif")));
			mapeoSprites.put("Melee", new ImageIcon(getClass().getResource("/img/hit.gif")));
			// Texto
			mapeoSprites.put("Cargando", new ImageIcon(getClass().getResource("/img/cargandolvl.gif")));
			mapeoSprites.put("getPocion", new ImageIcon(getClass().getResource("/img/getPocion.gif")));
			mapeoSprites.put("getCuarentena", new ImageIcon(getClass().getResource("/img/getCuarentena.gif")));
			mapeoSprites.put("getEscudo", new ImageIcon(getClass().getResource("/img/getEscudo.gif")));
			mapeoSprites.put("getArma", new ImageIcon(getClass().getResource("/img/getArma.gif")));
		}
		
		imagen = mapeoSprites.get(tipo);
		toString = tipo;
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
	
	public ImageIcon getImagen() {
		return imagen;
	}
	
	public void setImagen(String tipo) {
		if (tipo != toString) { // Evita que se vea feo al moverse el jugador
			imagen = mapeoSprites.get(tipo);
			toString = tipo;
			setIcon(imagen);
		}
	}
	
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

	public String toString() {
		return toString;
	}
	
}
