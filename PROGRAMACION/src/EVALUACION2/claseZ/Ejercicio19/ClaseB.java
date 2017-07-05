package EVALUACION2.claseZ.Ejercicio19;

import java.awt.*;

public class ClaseB extends ClasePral{

    public ClaseB() {
    	super(Color.yellow);
    }
    
    public void dibujar(Graphics g){
    	g.setColor(color);
    	g.fillRect(x, y, width, height);
    }
    
}