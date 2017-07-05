package EVALUACION2.rehechoRepaso.flappy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pajaro extends Rectangle
{
	Color color;
	int ySpeed = 5;
	private boolean vivo = true;
	
	public Pajaro()
	{
		color = Color.WHITE;
		width = 25;
		height = width;
		x = width + 5;
		y = AppletApp.HEIGHT / 2;
	}
	
	public void mueve()
	{
		this.y += ySpeed;
		if (y >= AppletApp.HEIGHT || y <= 0) vivo = false;
	}
	
	public void pinta(Graphics g)
	{
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
	
	public boolean isAlive()
	{
		return vivo;
	}
	public void kill()
	{
		vivo = false;
	}
}
