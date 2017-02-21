package Ejercicio20Clase;

import java.awt.*;


public class Ovalo extends Figura
{
	public Ovalo()
	{
		super(10, 10, 10, 10, Color.RED);
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		
		g.fillOval(this.x, this.y, this.width, this.height);
	}
	
}
