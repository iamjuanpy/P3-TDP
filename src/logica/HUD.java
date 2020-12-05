package logica;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class HUD extends JPanel {
	private static final long serialVersionUID = 1135814933383498937L;
	
	private JLabel cargaViral;
	private JLabel nivel;
	private JLabel infectadosVivos;
	private JLabel escudo;
	
	public HUD(int x, int y, int limiteX, int altura) {
		setBounds(x, y, limiteX, altura);
		setBackground(Color.WHITE);
		setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
		
		Font fuenteLabel = new Font("Arial", Font.PLAIN, 20);
		
		cargaViral = new JLabel();
		nivel = new JLabel();
		infectadosVivos = new JLabel();
		escudo = new JLabel();
		
		cargaViral.setFont(fuenteLabel);
		nivel.setFont(fuenteLabel);
		infectadosVivos.setFont(fuenteLabel);
		
		ImageIcon imgEscudo = new ImageIcon("img/escudo.png"); 
		escudo.setIcon(imgEscudo);
		
		add(cargaViral);
		add(nivel);
		add(infectadosVivos);
		add(escudo);
		
		actualizarHUD(23, 1, 2, true); // Test para ver como se ve el HUD
	}
	
	public void actualizarHUD(int cargaViral, int nivel, int infectados, boolean tieneEscudo) {
		this.cargaViral.setText("Carga viral: " + Integer.toString(cargaViral));
		this.nivel.setText("Nivel: " + Integer.toString(nivel));
		this.infectadosVivos.setText("Infectados: " + Integer.toString(infectados));
		this.escudo.setVisible(tieneEscudo);
	}
}
