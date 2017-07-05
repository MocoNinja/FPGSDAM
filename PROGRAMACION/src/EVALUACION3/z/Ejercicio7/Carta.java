import java.awt.*;
import java.applet.*;

public class Carta{
	Image imagen;
	int valor;
	private int posx, posy;
    public Carta(Image img, int v) {
    	imagen = img;
		valor = (v > 10)?10:v;
    }

    public void dibujar(Graphics g, Applet a){
		g.drawImage(imagen, posx, posy, 100, 200, a);
    }
    
    public void setPosx(int px){
    	posx = px;
    }
    
    public void setPosy(int py){
    	posy = py;
    }
}