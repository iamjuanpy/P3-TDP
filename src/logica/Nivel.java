package logica;

import java.io.File;
import java.util.Random;

import javax.swing.ImageIcon;

import entidades.Infectado;
import entidades.InfectadoAlpha;
import entidades.InfectadoBeta;

public abstract class Nivel {
	/*
	 * Clases que especializan Nivel tienen que tener:
	 * -> una referencia al mapa?
	 * -> un ImageIcon como imagen de fondo?
	 * -> instanciar a sus infectados segun parametros internos que varian
	 *     |-> Es decir, un nivel puede definir una cantidad de infectados alfa y/o beta
	 *         y los puede instanciar y agregar al mapa como vea necesario (hacerlo en un thread aparte?)
	 * -> una cantidad de tandas definidas?
	 * -> musica para el thread?  
	 */
	
	protected Juego juego;
	
	// Limite 1 < Limite2
	// limite2 < juego.getWidth()
	protected int limite1;
	protected int limite2;
	
	protected float multiplier; // Para ir subiendo la dificultad cada nivel
	protected int cantidadAlfa;
	protected int cantidadBeta;
	protected int cAlfaTanda;
	protected int cBetaTanda;
	
	protected int cantidadTandas = 2;
	protected int tandaActual = cantidadTandas;
	
	protected File musica;
	protected ImageIcon background;
	
	// Auxiliar para spawnEnemigos
	private int auxAlfa;
	private int auxBeta;
	private int posX;
	private int posY;
	
	public Nivel(Juego j, int cantA, int cantB, float mp) {
		juego = j;
		cantidadAlfa = cantA;
		cantidadBeta = cantB;
		
		cAlfaTanda = cantidadAlfa/cantidadTandas;
		cBetaTanda = cantidadBeta/cantidadTandas;
		
		multiplier = mp;
	}
	
	public void spawnEnemigos() {
		
		if ((!juego.hayInfectadosVivos()) && tandaActual != 0) {
			
			Random rPos = new Random(); // Random para posX
			Random rInf = new Random(); // Random para tipoInfectado
			
			posX = 0;
			
			while (posX < limite1) { // Randomiza X dentro de los limites del mapa
				posX = rPos.nextInt(limite2);
			}
			
			if ((cAlfaTanda + cBetaTanda) % 4 == 0) // Randomiza la altura para que no aparezcan muchos en fila
				posY = posY - 50;
			
			// Randomiza que infectado spawnea
			if (rInf.nextInt(10) >= 4 && auxAlfa != 0) {
				Infectado a = new InfectadoAlpha(juego,posX,posY,0,10);
				juego.agregarEntidad(a);
				juego.spawneoInfectado();
				auxAlfa--;
			}
			else if (auxBeta != 0) {
				Infectado b = new InfectadoBeta(juego,posX,posY,0,10); // Agregar algun parametro para mandar el multiplier
				juego.agregarEntidad(b);
				juego.spawneoInfectado();
				auxBeta--;
			}
			
			// Pasa a la otra tanda
			if (auxAlfa == 0 && auxBeta == 0) {
				tandaActual--;
				auxAlfa = cAlfaTanda;
				auxBeta = cBetaTanda;
			}
			
		}
		
		
	}
	
	public boolean finNivel() {
		return (tandaActual == 0);
	}
	
	public ImageIcon getBackground() {
		return background;
	}
}
