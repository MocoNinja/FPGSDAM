package EVALUACION3.claseHechos.ejercicio004;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;


public class FlechaPunto extends Point
{
	private final Image sprite;
	private final int xSpeed = 1;
	private final int xInicio = 25 + 120;
	private final int xAngulo = (1500 - xInicio) / 180; 
	private final static int WIDTH = 80;
	private final static int HEIGHT = 80;
	
	public FlechaPunto(int x, int y, Image sprite)
	{
		super(x + WIDTH, y + HEIGHT / 3);
		this.sprite = sprite;
	}
	
	public void pinta(Graphics g, Applet app)
	{
//		g.drawImage(sprite, x - WIDTH + 30, y - HEIGHT / 2 + 2, WIDTH, HEIGHT, app);
		g.setColor(Color.YELLOW);
		g.fillOval(this.x, this.y, 5, 5);
	}
	
	public void mueveLinea()
	{
		this.x += xSpeed;
	}
	
	public void mueveArco()
	{
		x += 150; // 150 va fino
		y += (int) (Math.sin(Math.toRadians(x * xAngulo)) * 100); //PARKINSON
	}
}
