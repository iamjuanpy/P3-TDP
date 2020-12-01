package logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import entidades.Entidad;
import entidades.InfectadoAlpha;
import entidades.InfectadoBeta;
import entidades.Jugador;
import java.util.ArrayList;
import java.util.List;

public class Juego extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private List<Entidad> entidades;
	private List<Entidad> entidadesAñadir;

	private Jugador player;
	private Nivel nivelActual;
	private Mapa mapa;
	private int limiteX, limiteY;
	
	public void setMapa(Mapa m) {
		mapa = m;
	}
	
	public Juego(int FPS, int limiteX, int limiteY) {
		entidades = new ArrayList<Entidad>();
		entidadesAñadir = new ArrayList<Entidad>();
		
		this.limiteX = limiteX;
		this.limiteY = limiteY;
		
		ActionListener eventoTimer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actualizarEntidades();
				resolverColisiones();
				eliminarEntidadesMuertas();
				//System.out.println("Carga Viral: "+player.getCV()); // DEBUG
				//System.out.println("Cantidad de entidades: "+entidades.size()); // DEBUG
			}
		};
		
		/*
		 * Si queremos que el juego ande a x FPS, significa que en cada segundo van
		 * a haber x actualizaciones. Entonces por la regla de 3 hay 1/x segundos por frame
		 * y eso se multiplica por 1000 para pasarlo a milisegundos. Este valor final
		 * es cuantas veces actualizamos cada entidad por segundo.
		 * 
		 * 60 fps -- 1 seg
		 *  1 fps -- ? seg <- 1/60
		 * Hay un poco de perdida de precision, pero se tiene que castear a int porque eso requiere Timer.
		 * El error es una cantidad demasiado pequeña para importar.
		 */
		float fpsEnMS = ( 1/ (float) FPS ) * 1000;
		Timer t = new Timer((int)fpsEnMS, eventoTimer);
		t.start();
	}
	
	public void testEntidades() {
		Entidad ia = new InfectadoAlpha(this,limiteX/2 + 70, 0 + 175,0,2);
		Entidad ib = new InfectadoBeta(this,limiteX/2 - 70, 0 + 75,0,2);
		
		agregarEntidad(ia);
		agregarEntidad(ib);
		
		/* Entidad p1 = new PowerUp(new Pocion(player),this,limiteX/2,0,1,2);
		agregarGrafico(p1.getEntidadGrafica());
		Entidad p2 = new PowerUp(new ArmaTemporal(player),this,limiteX/2 + 90,0,1,2);
		agregarGrafico(p2.getEntidadGrafica());
		Entidad p3 = new PowerUp(new Cuarentena(player),this,limiteX/2 - 90,-150,1,2);
		agregarGrafico(p3.getEntidadGrafica());*/
	}
	
	public void crearJugador() {
		if (player == null) {
			player = new Jugador(this, limiteX/2, limiteY - 80, 6, 0);
			agregarEntidad(player);
		}
	}
	
	private void actualizarEntidades() {
		// Añadido para evitar ConcurrentException al agregar Entidad en actualizar().
		for (Entidad e : entidadesAñadir) {
			entidades.add(e);
		}
		
		entidadesAñadir.clear();
		
		for (Entidad e : entidades) {
			e.actualizar();
		}

	}
	
	private void resolverColisiones() {
		for (Entidad e : entidades) {
			e.buscarColisiones(entidades);
		}
	}
	
	private void eliminarEntidadesMuertas() {
		for(int i = 0; i < entidades.size(); i++) {
			if (entidades.get(i).estaEliminado()){
				mapa.eliminarEntidad(entidades.get(i));
				entidades.remove(i);				
			}
		}
	        
	}
	
	public List<Entidad> getEntidades(){
		return entidades;
	}
	
	public void agregarEntidad(Entidad e) {
		entidadesAñadir.add(e);
		mapa.agregarGrafico(e.getEntidadGrafica());
	}
	
	public Jugador getPlayer() {
		return player;
	}
	
	public Mapa getMapa() {
		return mapa;
	}
}