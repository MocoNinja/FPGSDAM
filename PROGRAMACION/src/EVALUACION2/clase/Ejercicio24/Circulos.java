package EVALUACION2.clase.Ejercicio24;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Circulos extends Rectangle{
	
	private Color color;
	Random rand = new Random();
	
	public Circulos()
	{
		width = 5;
		height = 5;
		x = 10 + rand.nextInt(600 - 20);
		y = 10 + rand.nextInt(600 - 20);
		color = Color.CYAN;
	}
	
	public void pinta(Graphics g)
	{
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}
}
