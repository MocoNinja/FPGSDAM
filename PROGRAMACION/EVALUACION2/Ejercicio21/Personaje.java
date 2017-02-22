package Ejercicio21;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Ejercicio18.Columna;


public class Personaje extends Rectangle{

	static int vY = 5;
	Color color = Color.RED;
	boolean muerto = false;
	
	public Personaje()
	{
		x = 10;
		y = 100;
		width = 30;
		height = 30;
	}
	
	public void pinta(Graphics g)
	{
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}
	
	public void mueve(boolean sube, Rectangle columna)
	{
		y += vY;
		
		if (y > 600 || y < 0)
		{
			muerto = true;
		}
		
		if (sube)
		{
			y -= 60;
			FlappyBird.click = false;
		}
		if (this.contains(columna) && columna instanceof Columna)
			muerto = true;
	}
}
