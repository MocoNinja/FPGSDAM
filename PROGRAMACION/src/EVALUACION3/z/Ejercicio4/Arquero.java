import java.awt.*;
import java.applet.*;
public class Arquero {
	Image imgArquero;
	int y;
    public Arquero(Image img) {
    	imgArquero = img;
    	y = 200;
    }
    public void dibujar(Graphics ll, Applet a){
    	ll.drawImage(imgArquero, 30, y, a);
    }
    public void actualizar(int y){
    	this.y = y - 40;
    }
}