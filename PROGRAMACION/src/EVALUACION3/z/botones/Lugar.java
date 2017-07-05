import java.awt.*;
import java.util.*;
import java.applet.*;

public class Lugar {
	public static final int DIM = 48;
	Image imagen;
	int valor;
    public Lugar(Image img, int v) {
    	imagen = img;
    	valor = v;
    }
    public void dibujar(Graphics g, Applet a, int x, int y){
    	if(imagen != null)
    		g.drawImage(imagen, x * DIM, y * DIM, a);
    		//g.drawString(""+valor, (x * DIM)+10, (y * DIM)+10);
    }
    
}