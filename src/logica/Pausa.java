package logica;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Pausa extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JLabel background;
	private JButton Continuar;
	private JButton Salir;
	private Ventana v;

	
	public Pausa(Ventana v) {
		
		
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.v = v;
		
		setLayout(null);
		
		background = new JLabel();
		background.setIcon(new ImageIcon("img/pausa.png")); 
		add(background);
		
		
		Continuar = new JButton("Continuar");
		Continuar.setBounds(209,517,165,35);
		Continuar.addActionListener(new OyenteC());
		
		Salir = new JButton("Salir");
		Salir.setBounds(209,572,165,35);
		Salir.addActionListener(new OyenteS());
		
		
		add(Continuar);
		add(Salir);
		setVisible(false);
	}

	private class OyenteC implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			Continuar.setFocusable(false);
			Salir.setFocusable(false);		
			//v.cerrarPausa();
			
		}
		
	}
	
	private class OyenteS implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			System.exit(1);
			
		}
		
	
	}

}
