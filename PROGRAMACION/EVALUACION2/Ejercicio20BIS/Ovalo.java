package Ejercicio20BIS;

import java.awt.Color;
import java.awt.Graphics;

public class Ovalo extends Figura{

	public Ovalo()
	{
		super();
		color = Color.RED;
	}
	
	public void pintar(Graphics g)
	{
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}
}
