package zClase.Ejercicio19;

import java.awt.*;
public class ClaseA extends ClasePral{

    public ClaseA() {
    	super(Color.red);
    }
    
    public void dibujar(Graphics g){
    	g.setColor(color);
    	g.fillOval(x, y, width, height);
    }

}