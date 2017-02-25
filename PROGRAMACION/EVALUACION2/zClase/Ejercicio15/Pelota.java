package zClase.Ejercicio15;
import java.awt.*;

public class Pelota extends Rectangle{
	Color color;
	int velX, velY;
	boolean visible = true;
    public Pelota(int posX, int posY, int anchura, Color color) {
    	x = posX; 
    	y = posY;
    	width = anchura;
    	height = anchura;
    	this.color = color;
    	velX = -2;
    	velY = 2;
    }
    
    public void dibujar(Graphics g){
    	if(visible){
	    	g.setColor(color);
    		g.fillOval(x, y, width, height);
    	}
    }
    
    public void actualizar(){
    	x += velX;
    	y += velY;
    	if((x>=250) || (x<=0))
    		velX = -velX;
    	if((y>=250) || (y<=0))
    		velY = -velY;
    }
    
}