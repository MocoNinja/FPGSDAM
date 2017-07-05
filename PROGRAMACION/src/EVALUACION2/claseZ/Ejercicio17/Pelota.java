package EVALUACION2.claseZ.Ejercicio17;
import java.awt.*;

public class Pelota extends Rectangle{
	Color colores[] = {Color.red, Color.orange, Color.green, Color.yellow, Color.magenta, Color.blue};
	Color color;
	int velX, velY;
    public Pelota(int posX, int posY, int anchura) {
    	x = posX; 
    	y = posY;
    	width = anchura;
    	height = anchura;
    	this.color = colores[(int)(Math.random() * colores.length)];
    	velX = (int)((Math.random() * 11) - 5);
    	velY = (int)((Math.random() * 11) - 5);
    }
    
    public void dibujar(Graphics g){
	    	g.setColor(color);
    		g.fillOval(x, y, width, height);
    }
    
    public void actualizar(){
    	x += velX;
    	y += velY;
    	if((x>=290) || (x<=0))
    		velX = -velX;
    	if((y>=290) || (y<=0))
    		velY = -velY;
    }
    
}