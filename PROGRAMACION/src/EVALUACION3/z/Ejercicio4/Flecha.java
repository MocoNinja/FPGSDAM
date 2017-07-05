import java.awt.*;
import java.applet.*;

public class Flecha extends Point{
	public static final int ANCHURA = 100;
	public static final int ALTURA = 30;
	Image imgFlecha;
    public Flecha(Image img, int posy) {
    	super(70, posy);
    	imgFlecha = img;
    }
    public void dibujar(Graphics g, Applet a){
    	g.drawImage(imgFlecha, x, y, ANCHURA, ALTURA, a);
    }
    public void actualizar(){
    	x+=10;
    }
    public Point posiciones(){
    	return new Point(x + (ANCHURA/2), y+(ALTURA/2));
    }
}