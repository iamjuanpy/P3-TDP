package logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;
import entidades.Entidad;
import entidades.Jugador;
import entidades.PowerUpFactory;
import premios.Cuarentena;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// import premios.*; // import para testEntidades()

public class Juego {
	
	private List<Entidad> entidades;
	private List<Entidad> entidadesAñadir;

	private Jugador player;
	private int infectadosVivos;
	
	private Ventana v;
	private HUD hud;
	private PowerUpFactory fabrica;
	
	private Nivel nivelActual;
	private Stack<Nivel> niveles;
	private int nivelIndex;
	private Mapa mapa;
	private int limiteX, limiteY;
	
	private ActionListener eventoTimer;
	private ActionListener eventoPausa;
	private float fpsEnMS;
	private Timer t;
	
	public Juego(int FPS, int limiteX, int limiteY, Ventana v) {
		entidades = new ArrayList<Entidad>();
		entidadesAñadir = new ArrayList<Entidad>();
		
		this.limiteX = limiteX;
		this.limiteY = limiteY;
		
		this.v = v;
		this.hud = v.getHud();

		crearNiveles();
		
		eventoTimer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actualizarEntidades();
				resolverColisiones();
				eliminarEntidadesMuertas();
				hud.actualizarHUD(player.getCV(), nivelIndex, infectadosVivos,player.getEscudo(),player.getArmaSeleccionada(),player.tieneEfectoTemporal());
				chequearMuerte();
				manejarNiveles();
					
				//System.out.println("Carga Viral: "+player.getCV()); // DEBUG
				//System.out.println("Cantidad de entidades: "+entidades.size()); // DEBUG
			}
		};
		
		eventoPausa = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

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
		fpsEnMS = ( 1/ (float) FPS ) * 1000;
		t = new Timer((int)fpsEnMS, eventoTimer);
		t.start();

	}

	public void testEntidades() {
		/*
		Entidad ia = new InfectadoAlpha(this,limiteX/2 + 70, 0 + 175,0,2, .2f);
		Entidad ib = new InfectadoBeta(this,limiteX/2 - 70, 0 + 75,0,2, .2f);
		spawneoInfectado();
		spawneoInfectado();
		
		agregarEntidad(ia);
		agregarEntidad(ib);
		
		Entidad p1 = new PowerUp(new Pocion(player),this,limiteX/2,0,1,2);
		agregarEntidad(p1);
		Entidad p2 = new PowerUp(new ArmaTemporal(player),this,limiteX/2 + 90,0,1,2);
		agregarEntidad(p2);
		Entidad p3 = new PowerUp(new Cuarentena(player),this,limiteX/2 - 90,-150,1,2);
		agregarEntidad(p3);
		Entidad p4 = new PowerUp(new Escudo(player),this,limiteX/2,-70,1,2);
		agregarEntidad(p4);
		*/
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
	
	private void chequearMuerte() {
		
		// Si está eliminado, pierde
		if (player.estaEliminado()) {
			v.perder();
			t.stop();
		}
		
	}
	
	private void manejarNiveles() {
		
		if (nivelActual == null) {
			nivelActual = niveles.pop();
			mapa.setBackground(nivelActual.getBackground());
			nivelIndex++;
		}
		
		if (!hayInfectadosVivos()) {
			
			player.deleteEfectoTemporal(new Cuarentena(player));
			
			if (nivelActual.finNivel()) {
				
				if (!niveles.isEmpty()) {
					nivelActual = niveles.pop();
					mapa.setBackground(nivelActual.getBackground());
					nivelIndex++;
				}
				else {
					v.ganar();
					t.stop();
				}
				
			} else nivelActual.siguienteTanda();

			if (nivelActual.hayInfectadosParaSpawnear())
				 nivelActual.spawnEnemigos();
			
		}  
			
	}
	
	public void crearJugador() {
		if (player == null) {
			player = new Jugador(this, limiteX/2, limiteY - 50, 6, 0);
			agregarEntidad(player);
		}
	}
	
	private void crearNiveles() {
		
		nivelIndex = 0;
		
		niveles = new Stack<Nivel>();
		niveles.push(new Nivel(this,1,1,2,70,525,new ImageIcon("img/bg5.png")));
		niveles.push(new Nivel(this,1,1,1.7f,25,410,new ImageIcon("img/bg4.png")));
		niveles.push(new Nivel(this,1,1,1.5f,130,450,new ImageIcon("img/bg3.png")));
		niveles.push(new Nivel(this,1,1,1.2f,65,380,new ImageIcon("img/bg2.png")));
		niveles.push(new Nivel(this,1,1,1,65,500,new ImageIcon("img/bg.png")));
		
	}
	
	public PowerUpFactory getPowerUpFactory() {
		
		if (fabrica == null) {
			fabrica = new PowerUpFactory(this, player);
		}
		
		return fabrica;
	}
	
	public void agregarEntidad(Entidad e) {
		entidadesAñadir.add(e);
		mapa.agregarGrafico(e.getEntidadGrafica());
	}
	
	public void spawneoInfectado() {
		infectadosVivos++;
	}
	
	public void murioInfectado() {
		infectadosVivos--;
	}
	
	public List<Entidad> getEntidades(){
		return entidades;
	}
	
	public Jugador getPlayer() {
		return player;
	}
	
	public Mapa getMapa() {
		return mapa;
	}
	
	public void setMapa(Mapa m) {
		mapa = m;
	}
	
	public boolean hayInfectadosVivos() {
		return (infectadosVivos != 0);
	}
	
	public void pausa() {
		t.stop();
		t = new Timer((int)fpsEnMS, eventoPausa);
		t.start();
		
		v.pausar();
	}
	
	public void reanudar() {
		t.stop();
		t = new Timer((int)fpsEnMS, eventoTimer);
		t.start();
	}
	
}