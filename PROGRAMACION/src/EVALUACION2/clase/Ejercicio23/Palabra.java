package EVALUACION2.clase.Ejercicio23;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Palabra extends Rectangle{

	String palabra;
	private final int ESPACIO = 25;
	private final int ANCHO_LETRA = 12;
	Random rand = new Random();
	Color[] colores = {Color.RED, Color.YELLOW, Color.GREEN, Color.CYAN, Color.MAGENTA, Color.WHITE, Color.PINK, Color.ORANGE};
	private Color color;
	private boolean clickado = false;
	private boolean inRange = true;
	private final int xSpeed = 10;
	
	public Palabra(String palabra)
	{
		this.palabra = palabra;
		x = App.WIDTH - ESPACIO;
		y = rand.nextInt(App.HEIGHT - ESPACIO);
		width = palabra.length() * ANCHO_LETRA;
		height = 25;
		color = colores[rand.nextInt(colores.length)];
	}

	public boolean isInRange()
	{
		return inRange;
	}
	
	public void click()
	{
		clickado = true;
	}
	
	public void pinta (Graphics g)
	{
		g.setColor(color);
		g.fillRect(x, y, width, height);
		if (clickado)
		{
			g.setColor(Color.BLACK);
			g.drawString(palabra, x + ANCHO_LETRA * 3, y + ANCHO_LETRA * 2);
		}
	}

	public void mueve()
	{
		x -= xSpeed;
		if (x < 0) inRange = false;
	}
}
