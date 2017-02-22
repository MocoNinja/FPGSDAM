package Ejercicio20Clase;

import java.awt.*;


public class Rectangulo extends Figura
{
	public Rectangulo()
	{
		super();
		color = Color.RED;
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
	
}
