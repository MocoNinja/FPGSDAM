package EVALUACION2.clase.Ejercicio24;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Escoba extends Rectangle
{
	private Color color;
	public Escoba()
	{
		width = 25;
		height = 25;
		x = 600 - width;
		y = 600 - height;
		color = Color.YELLOW;
	}
	
	public void pinta(Graphics g)
	{
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
}
