package logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class FinJuego extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JLabel background;
	private JButton Continuar;
	private JButton Salir;
	private Ventana v;

	
	public FinJuego(Ventana v) {
		
		setUndecorated(true);
		setBounds(0, 0, 500, 300);
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);
		
		this.v = v;
		
		background = new JLabel();
		background.setIcon(new ImageIcon(getClass().getResource("/img/victoria.png"))); 
		background.setBounds(0,0,500,300);
		add(background);
		
		Continuar = new JButton("Volver a Jugar");
		Continuar.setBounds(130,193,116,29);
		Continuar.addActionListener(new OyenteC());
		
		Salir = new JButton("Salir");
		Salir.setBounds(256,193,116,29);
		Salir.addActionListener(new OyenteS());
		
		add(Continuar);
		add(Salir);
		
		setVisible(false);
	}

	public void ganar() {
		Continuar.setBounds(128,193,116,29);
		background.setIcon(new ImageIcon(getClass().getResource("/img/victoria.png"))); 
	}
	
	public void perder() {
		Continuar.setBounds(130,193,116,29);
		background.setIcon(new ImageIcon(getClass().getResource("/img/derrota.png"))); 
	}
	
	private class OyenteC implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Continuar.setFocusable(false);
			Salir.setFocusable(false);	
			setVisible(false);
			v.nuevoJuego();	
		}
		
	}
	
	private class OyenteS implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			v.dispose();
			System.exit(1);
		}
		
	}

}
