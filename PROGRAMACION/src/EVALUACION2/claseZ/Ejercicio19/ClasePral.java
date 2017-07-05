package EVALUACION2.claseZ.Ejercicio19;

import java.awt.*;
public abstract class ClasePral extends Rectangle{
	Color color;
	int velX, velY;
    public ClasePral(Color color) {
    	super((int)(Math.random() * 250), (int)(Math.random() * 250), 10, 10);
    	this.color = color;
    	velX = (int)((Math.random() * 11) - 5);
    	velY = (int)((Math.random() * 11) - 5);
    }
    public void actualizar(){
    	x += velX;
    	y += velY;
    	if((x>=290) || (x<=0))
    		velX = -velX;
    	if((y>=290) || (y<=0))
    		velY = -velY;
    }
    public abstract void dibujar(Graphics g); //Obligamos a implementar el método dibujar en sus subclases.
}