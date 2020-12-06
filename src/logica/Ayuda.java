package logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Ayuda extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Ventana v;
	private JLabel background;
	private JButton btnVolver;

	
	public Ayuda(int x, int y, int limiteX, int limiteY, Ventana v) {
		
		this.v = v;
	
		setLayout(null);
		setBounds(0, 0, limiteX, limiteY);
		
		background = new JLabel();
		background.setBounds(x, y, limiteX, limiteY);
		background.setIcon(new ImageIcon("img/ayuda.png")); 
		add(background);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(212,699,161,31);
		btnVolver.addActionListener(new OyenteV());

		add(btnVolver);

		setVisible(false);
		
	}
	
	private class OyenteV implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			v.cerrarAyuda();
		}
		
	}
}
