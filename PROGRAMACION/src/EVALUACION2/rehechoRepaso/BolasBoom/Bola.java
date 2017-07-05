package EVALUACION2.rehechoRepaso.BolasBoom;

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
	private boolean vivo = true;
	
	private final int TECHO = 0 + RADIO * 2, SUELO = App.HEIGHT - 2 * RADIO;
	private final int PARED_I = 0 + RADIO * 2, PARED_D = App.WIDTH - 2 * RADIO;
	
	private int xSpeed, ySpeed;
	private int xAcc, yAcc;
	
	public Bola()
	{
		width = RADIO;
		height = RADIO;
		x = rand.nextInt(App.WIDTH) + RADIO;
		y = rand.nextInt(App.HEIGHT) + RADIO;
		color = colores[rand.nextInt(colores.length)];
		xAcc = 1; yAcc = 1;
		xSpeed = rand.nextInt(5) + 5;
		ySpeed = rand.nextInt(5) + 5;
	}
	
	public void mueve()
	{
		x += xSpeed * xAcc;
		y += ySpeed * yAcc;
		
		if (x >= PARED_D || x <= PARED_I) xAcc *= -1;
		if (y >= SUELO || y <= TECHO) yAcc *= -1;
	}
	
	public void pinta(Graphics g)
	{
		g.setColor(color);
		g.fillOval(x, y, RADIO, RADIO);
	}

	public boolean isAlive()
	{
		return vivo;
	}
	
	public void setLife(boolean nuevoEstado)
	{
		vivo = nuevoEstado;
	}
}
