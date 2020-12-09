package logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel {
	private static final long serialVersionUID = -4569548655143314581L;

	private Ventana v;
	
	private JLabel background;
	private JButton btnJugar;
	private JButton btnSalir;
	private JButton btnAyuda;

	
	public Menu(int x, int y, int limiteX, int limiteY, Ventana v) {
		
		this.v = v;
		
		setVisible(false);
		setLayout(null);
		setBounds(0, 0, limiteX, limiteY);
		
		background = new JLabel();
		background.setBounds(x, y, limiteX, limiteY);
		background.setIcon(new ImageIcon(getClass().getResource("/img/menu.png"))); 
		add(background);
		
		btnJugar = new JButton("Jugar");
		btnJugar.setBounds(209,517,165,35);
		btnJugar.addActionListener(new OyenteJ());
		
		btnAyuda = new JButton("Ayuda");
		btnAyuda.setBounds(209,572,165,35);
		btnAyuda.addActionListener(new OyenteA());
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(209,627,165,35);
		btnSalir.addActionListener(new OyenteS());
		
		add(btnJugar);
		add(btnAyuda);
		add(btnSalir);
		
		setVisible(true);

	}
	
	
	private class OyenteJ implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			btnJugar.setFocusable(false);
			btnAyuda.setFocusable(false);
			btnSalir.setFocusable(false);
			v.nuevoJuego();
		}
	}
	
	private class OyenteA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			v.mostrarAyuda();
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
