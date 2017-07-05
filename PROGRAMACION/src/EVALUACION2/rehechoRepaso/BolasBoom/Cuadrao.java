package EVALUACION2.rehechoRepaso.BolasBoom;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Cuadrao extends Rectangle
{
	final private int LADO = 15;
	Color[] colores = {Color.MAGENTA, Color.CYAN, Color.YELLOW};
	Random rand = new Random();
	Color color;
	private boolean vivo = true;
	
	private final int TECHO = 0 + 2 * LADO, SUELO = App.HEIGHT - 2 * LADO;
	private final int PARED_I = 0 + 2 * LADO, PARED_D = App.WIDTH - 2 * LADO;
	
	private int xSpeed, ySpeed;
	private int xAcc, yAcc;
	
	public Cuadrao()
	{
		width = LADO;
		height = LADO;
		x = rand.nextInt(App.WIDTH) + LADO;
		y = rand.nextInt(App.HEIGHT) + LADO;
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
		g.fillRect(x, y, LADO, LADO);
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
