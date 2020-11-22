package entidades;
import armas.Arma;
import armas.ArmaRapida;
import logica.Mapa;

public abstract class Humano extends Entidad{

	protected int cargaViral;
	protected Arma arma;
	
	public Humano(int cV, Arma a,Mapa m, int x, int y, int vx, int vy) {
		super(m,x,y,vx,vy);
		cargaViral = cV;
		
		arma = a;
		a.setOwner(this);
	}
	
	public String getArmaSeleccionada() {
		return arma.getClass().toString().replace("class armas.Arma", "");
	}
	
	public void setArma(Arma a) {
		arma = a;
	}
	
	public void disparar() {
		arma.disparar();
	}
	
}
