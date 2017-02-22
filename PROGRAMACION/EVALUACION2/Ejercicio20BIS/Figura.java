package Ejercicio20BIS;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public abstract class Figura extends Rectangle{

	static int posX, posY;
	final static int ancho = 20, alto = 20;
	static int vX = 20, vY = 20;
	Color color;
	Random rand = new Random();

	final static int APPLET_WIDTH = 600, APPLET_HEIGHT = 600;
	final static int TECHO = 0 + ancho, SUELO = APPLET_HEIGHT - ancho;
	final static int PARED_I = 0 + ancho;
	final static int PARED_D = APPLET_WIDTH - ancho;
	
	public Figura()
	{
		x = rand.nextInt(PARED_D);
		y = rand.nextInt(SUELO);
		x = posX;
		y = posY;
		width = ancho;
		height = alto;
	}
	
	public abstract void pintar(Graphics g);
	
	public void mover()
	{
		if (x > PARED_D || x < PARED_I)
		{
			vX *= -1;
		}
		if (y > SUELO || y < TECHO)
		{
			vY *= -1;
		}
		x += vX;
		y += vY;
	}
}
