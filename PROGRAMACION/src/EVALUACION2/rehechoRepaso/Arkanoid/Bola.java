package EVALUACION2.rehechoRepaso.Arkanoid;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Bola extends Rectangle
{
	final private int RADIO = 15;
	Color[] colores = {Color.MAGENTA, Color.CYAN, Color.YELLOW};
	Random rand = new Random();
	Color color;
	
	private final int TECHO = 0 + RADIO * 2, SUELO = App.HEIGHT - 2 * RADIO;
	private final int PARED_I = 0 + RADIO * 2, PARED_D = App.WIDTH - 2 * RADIO;
	
	private int xSpeed, ySpeed;
	private int xAcc, yAcc;
	
	public Bola()
	{
		width = RADIO;
		height = RADIO;
		x = 20;
		y = 20;
		color = colores[rand.nextInt(colores.length)];
		xAcc = 1; yAcc = 1;
		xSpeed = rand.nextInt(5) + 5;
		ySpeed = rand.nextInt(5) + 5;
	}
	
	public void mueve(Bloque c)
	{
		x += xSpeed * xAcc;
		y += ySpeed * yAcc;
		
		if (x >= PARED_D || x <= PARED_I) xAcc *= -1;
		if (y >= SUELO || y <= TECHO) yAcc *= -1;
		
		if (this.intersects(c))
		{
			xAcc *= -1;
			yAcc *= -1;
		}
	}
	
	public void pinta(Graphics g)
	{
		g.setColor(color);
		g.fillOval(x, y, RADIO, RADIO);
	}
}
