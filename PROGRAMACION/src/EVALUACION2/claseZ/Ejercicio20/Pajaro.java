package EVALUACION2.claseZ.Ejercicio20;
import java.awt.*;

public class Pajaro extends Rectangle{
	int velY;
	Color color;
    public Pajaro() {
		super(50, 20, 15, 15);
		velY = +2;
		color = Color.white;
    }
    
    public void dibujar(Graphics g){
	    	g.setColor(color);
    		g.fillOval(x, y, width, height);
    }
    public void actualizar(){
    	y += velY;

    }
}