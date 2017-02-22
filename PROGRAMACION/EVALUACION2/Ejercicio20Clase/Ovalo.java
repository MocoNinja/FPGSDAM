package Ejercicio20Clase;

import java.awt.*;


public class Ovalo extends Figura
{
	public Ovalo()
	{
		super();
		color = Color.PINK;
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillOval(this.x, this.y, this.width, this.height);
	}
	
}
