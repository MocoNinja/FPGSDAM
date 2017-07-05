package EVALUACION3.claseHechos.ejercicio004;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.List;
import java.util.Random;

public class Globo extends Rectangle
{
	Image sprite;
	static Random rand = new Random();;
	int ySpeed;
	private boolean vivo = true;
	
	public Globo(Image sprite)
	{
		super(800 - rand.nextInt(600) - 25, 900 + rand.nextInt(250), 100 , 100);
		this.sprite = sprite;
		ySpeed = rand.nextInt(4) + 1;
	}
	
	public void pinta(Graphics g, Applet app)
	{
		g.setColor(Color.CYAN);
		g.drawRect(x, y, width, height);
		g.drawImage(sprite, x, y, 100, 100, app);
	}
	
	public void muevePuntos(List<FlechaPunto> flechas)
	{
		this.y -= ySpeed;
		for (int i = 0; i < flechas.size(); i++)
		{
			if (this.contains(flechas.get(i)))
			{
				this.vivo = false;
			}
		}
	}
	
	public void mueveRects(List<FlechaRectangle> flechas)
	{
		this.y -= ySpeed;
		for (int i = 0; i < flechas.size(); i++)
		{
			if (this.contains(flechas.get(i)))
			{
				this.vivo = false;
			}
		}
	}
	
	public boolean isAlive()
	{
	return vivo;
	}
}
