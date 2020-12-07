package logica;

import java.io.File;
import java.util.Random;

import javax.swing.ImageIcon;

import entidades.Infectado;
import entidades.InfectadoAlpha;
import entidades.InfectadoBeta;

public class Nivel {	
	protected Juego juego;
	protected File musica;
	protected ImageIcon background;
	
	// Limite 1 < Limite2
	// limite2 < juego.getWidth()
	protected int limite1;
	protected int limite2;
	
	protected float multiplier; // Para ir subiendo la dificultad cada nivel
	protected int cantidadAlfa;
	protected int cantidadBeta;
		
	// La especificacion indica 2 tandas por nivel
	protected int cantidadTandas = 2;
	protected int tandaActual = cantidadTandas;
	
	protected int cAlfaTanda;
	protected int cBetaTanda;	
	
	// Auxiliar para spawnEnemigos
	private int infectadosASpawnear;
	private int infectadosTandaActual;
	
	private Random rng;
	
	public Nivel(Juego j, int cantA, int cantB, float mp) {
		juego = j;
		cantidadAlfa = cantA;
		cantidadBeta = cantB;
		
		limite1 = 60;
		limite2 = 400;
		
		cAlfaTanda = cantidadAlfa/cantidadTandas;
		cBetaTanda = cantidadBeta/cantidadTandas;
		
		infectadosASpawnear = cAlfaTanda + cBetaTanda;
		System.out.println(infectadosASpawnear);
		
		multiplier = mp;
		rng = new Random();
	}
	
	public int randInt(int min, int max) {
	    return rng.nextInt((max - min) + 1) + min;
	}	
	
	public void spawnEnemigos() {
		// Todos los enemigos de una tanda a la vez
		tandaActual--;
		
		int vx = 0;
		int vy = 4;
		
		int h = 50;
		int multiplicador_y;
		int posX;
		int posY = -h;
		Infectado inf;
		
		infectadosTandaActual = infectadosASpawnear;
		
		while (infectadosTandaActual-- > 0) {
			posX = randInt(limite1, limite2);
			
			if (rng.nextFloat() < 0.6f) {
				inf = new InfectadoAlpha(juego, posX, posY, vx, vy, multiplier);
			} else {
				 inf = new InfectadoBeta(juego, posX, posY, vx, vy, multiplier);
			}
			
			juego.agregarEntidad(inf);
			juego.spawneoInfectado();
			
			multiplicador_y = randInt(1, 4);
			posY -= h*multiplicador_y;
		}
	}
	
	public void siguienteTanda() {
		infectadosTandaActual = infectadosASpawnear; 
	}
	
	public boolean hayInfectadosParaSpawnear() {
		return infectadosTandaActual >= 0;
	}
	
	public boolean finNivel() {
		return (tandaActual == 0);
	}
	
	public ImageIcon getBackground() {
		return background;
	}
	
	public File getMusica() {
		return musica;
	}
	
}