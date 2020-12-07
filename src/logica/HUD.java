package logica;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class HUD extends JPanel {
	private static final long serialVersionUID = 1135814933383498937L;
	
	private JLabel[] cargaViral;
	private JLabel nivel;
	private JLabel infectadosVivos;
	private JLabel escudo;
	private JLabel arma;
	private JLabel cuarentena;
	private FlowLayout layout;

	
	public HUD(int x, int y, int limiteX, int altura) {
		layout = new FlowLayout(FlowLayout.CENTER, 10, 22);
		
		setBounds(x, y, limiteX, altura);
		setBackground(new Color(102, 153, 0));
		setLayout(layout);

		// Para ver fuentes disponibles
		// for (String s : GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()) {
		//	 System.out.println(s);
		// }
		
		Font fuenteLabel = new Font("Lucida Console", Font.BOLD, 14);
		
		cargaViral = new JLabel[6]; // 5 corazones + Numero
		nivel = new JLabel();
		infectadosVivos = new JLabel();
		escudo = new JLabel();
		arma = new JLabel();
		cuarentena = new JLabel();
		for (int i=0; i<= 5; i++) {
			cargaViral[i] = new JLabel();
			add(cargaViral[i]);
		}
		
		cargaViral[5].setFont(fuenteLabel);
		nivel.setFont(fuenteLabel);
		infectadosVivos.setFont(fuenteLabel);
		
		cargaViral[5].setForeground(Color.WHITE);
		nivel.setForeground(Color.WHITE);
		infectadosVivos.setForeground(Color.WHITE);

		add(nivel);
		add(infectadosVivos);
		add(arma);
		add(escudo);
		add(cuarentena);
		
		actualizarHUD(75, 5, 6, true, "Default",false); // Hud inicial
	}
	
	public void actualizarHUD(int cargaViral, int nivel, int infectados, boolean tieneEscudo, String armaSeleccionada, boolean cuarentena) {
		actualizarCargaViral(cargaViral);
		actualizarEscudo(tieneEscudo);
		this.nivel.setText("Nivel: " + Integer.toString(nivel));
		this.infectadosVivos.setText("Infectados: " + Integer.toString(infectados));
		actualizarArma(armaSeleccionada);
		actualizarCuarentena(cuarentena);
	}

	private void actualizarCargaViral(int cv) {
		
		ImageIcon imgFull = new ImageIcon("img/full.png"); 
		ImageIcon imgMedio = new ImageIcon("img/medio.png"); 
		ImageIcon imgCero = new ImageIcon("img/cero.png"); 
		
		int aux = 0;
		int auxcv = 100 - cv;
		
		for (int i = 0; i<= 4; i++) {
			
			cargaViral[i].setIcon(imgCero);
			
			aux = aux + 1;
			if (aux <= auxcv)
				cargaViral[i].setIcon(imgMedio);
			
			aux = aux + 19;
			if (aux <= auxcv)
				cargaViral[i].setIcon(imgFull);
			

		}
		
		cargaViral[5].setText("CV: " + Integer.toString(cv));
	}
	
	private void actualizarEscudo(boolean e) {
		ImageIcon imgEscudo = new ImageIcon("img/conEsc.png");
		ImageIcon imgSinEscudo = new ImageIcon("img/sinEsc.png");
		
		if (e)
			escudo.setIcon(imgEscudo);
		else escudo.setIcon(imgSinEscudo);
	}
	
	private void actualizarArma(String armaS) {
		
		ImageIcon imgDefault = new ImageIcon("img/hudDefault.png");
		ImageIcon imgRapida = new ImageIcon("img/hudRapida.png");
		ImageIcon imgSuper = new ImageIcon("img/hudSuper.png");
		
		if (armaS == "Default")
			arma.setIcon(imgDefault);
		
		if (armaS == "Rapida")
			arma.setIcon(imgRapida);
		
		if (armaS == "Super")
			arma.setIcon(imgSuper);
	}
	
	private void actualizarCuarentena(boolean cuarentena2) {
		ImageIcon imgCuaren = new ImageIcon("img/cuarentena.png");
		ImageIcon imgNormal = new ImageIcon("img/normal.png");
		
		if (cuarentena2)
			cuarentena.setIcon(imgCuaren);
		else cuarentena.setIcon(imgNormal);
	}
}
