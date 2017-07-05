package EVALUACION3.claseHechos.ejercicio004;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Arquero
{
	private final int WIDTH = 120, HEIGHT = 100;
	private int x, y, height, width;
	Image sprite;
	
	public Arquero(int x, int y, Image sprite)
	{
		this.x = x;
		this.y = y;
		this.height = HEIGHT;
		this.width = WIDTH;
		this.sprite = sprite;
	}
	
	
	public int getHeight()
	{
	return this.height;
	}
	
	public int getWidth()
	{
	return this.WIDTH;
	}
	
	public int getX()
	{
	return this.x;
	}
	
	public int getY()
	{
	return this.y;
	}
	
	public void pinta(Graphics g, Applet app)
	{
		g.setColor(Color.MAGENTA);
		g.drawRect(x, y, width, height);
		g.drawImage(sprite, x, y, WIDTH, HEIGHT, app);
	}
	
	public void mueve(int y)
	{
		this.y = y;
	}
}
