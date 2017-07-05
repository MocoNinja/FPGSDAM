package EVALUACION2.rehechoRepaso.Arkanoid;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bloque extends Rectangle
{
	Color[] colores = {Color.YELLOW, Color.CYAN, Color.MAGENTA};
	private final int ESPACIO = 10;
	Color color;
	
	public Bloque(int posX, int posY, int indice)
	{
		super();
		x = posX * (width + ESPACIO);
		y = posY * (height + 2 * ESPACIO);
		width = (600 - 10 * ESPACIO) / 10;
		height = 20;
		color = colores[indice];
	}
	
	public void pinta(Graphics g)
	{
		g.setColor(Color.RED);
		g.drawRect(x, y, width, height);
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
}
