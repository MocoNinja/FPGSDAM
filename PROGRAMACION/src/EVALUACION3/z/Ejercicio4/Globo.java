import java.awt.*;
import java.applet.*;

public class Globo extends Rectangle{
	Image imgGlobo;
    public Globo(Image img, int dimension) {
    	super((int)(Math.random()*150)+500, (int)(Math.random()*500)+500, dimension, dimension);
    	imgGlobo = img;
    }
    public void dibujar(Graphics g, Applet a){
    	g.drawImage(imgGlobo, x, y, width, height, a);
    }
    public void actualizar(){
    	y -= 5;
    	if(y < -100)
    		y = (int)(Math.random()*500)+500;
    }
    
}