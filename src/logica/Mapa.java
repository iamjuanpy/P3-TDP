package logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import entidades.Entidad;
import entidades.Humano;
import entidades.InfectadoAlpha;
import entidades.InfectadoBeta;
import entidades.Jugador;
import entidades.PowerUp;
import premios.ArmaTemporal;
import premios.Cuarentena;
import premios.Pocion;

import java.util.ArrayList;
import java.util.List;

public class Mapa extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private List<Entidad> entidades;
	private List<Entidad> entidadesAñadir;

	private JLabel background;
	private Jugador player;
	
	public Mapa(int FPS, int limiteX, int limiteY) {
		entidades = new ArrayList<Entidad>();
		entidadesAñadir = new ArrayList<Entidad>();
		
		addKeyListener(new InputTeclado());
		setFocusable(true);
		
		// Obtener el background de cada Nivel?
		background = new JLabel();
		background.setBounds(0, 0, limiteX, limiteY);
		background.setIcon(new ImageIcon("img/bg3.png"));
		add(background);
		
		player = new Jugador(this, limiteX/2, limiteY - 80, 6, 0);
		
		// TEST
		player.setCV(50);

		new InfectadoAlpha(this,limiteX/2 + 70, 0 + 175,0,2); 
		new InfectadoBeta(this,limiteX/2 - 70, 0 + 75,0,2); 
		
		new PowerUp(new Pocion(player),this,limiteX/2,0,1,2);
		new PowerUp(new ArmaTemporal(player),this,limiteX/2 + 90,0,1,2);
		new PowerUp(new Cuarentena(player),this,limiteX/2 - 90,-150,1,2);
		
		//
		
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
				entidades.remove(i);
			}
		}
	        
	}
	
	// Delegar el input del usuario al jugador
	// El jugador se lo pasa a su estrategia de movimiento
	private class InputTeclado extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			player.keyPressed(e);
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			player.keyReleased(e);
		}
	}
	
	public List<Entidad> getEntidades(){
		return entidades;
	}
	
	public void agregarEntidad(Entidad e) {
		entidadesAñadir.add(e);
	}
	
	public Humano getPlayer() {
		return player;
	}

}