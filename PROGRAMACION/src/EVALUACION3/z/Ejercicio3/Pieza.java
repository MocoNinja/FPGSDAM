import java.awt.*;
import java.applet.*;
public class Pieza extends Rectangle{
	public static final int DIMENSION = 60;
	Image imagen;
	int posicion;
	private boolean colocado;
    public Pieza(Image img, int pos) {
    	super(((int)(Math.random()*240))+400, ((int)(Math.random()*440)), DIMENSION, DIMENSION);
    	imagen = img;
    	posicion = pos;
    	colocado = false;
    }
    public void setColocado(boolean coloca){
    	colocado = coloca;
    }
    public boolean getColocado(){
    	return colocado;
    }
    
    public void dibujar(Graphics ggg, Applet ap){
    	ggg.drawImage(imagen, x, y, ap);
    }
    
    public void mover(int posx, int posy)   {
    	x = posx - (DIMENSION/2);
    	y = posy - (DIMENSION/2);
    }
    public void moverJusto(int posx, int posy)   {
    	x = posx;
    	y = posy;
    }
}