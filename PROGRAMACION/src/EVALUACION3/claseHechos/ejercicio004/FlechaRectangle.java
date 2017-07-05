package EVALUACION3.claseHechos.ejercicio004;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.List;

public class FlechaRectangle extends Rectangle
{
	private final int WIDTH = 80, HEIGHT = 80;
	private final Image sprite;
	private final int xSpeed = 175;
	private final int xInicio = 25 + 120;
	private final int xAngulo = (1500 - xInicio) / 180; 
	public FlechaRectangle(int x, int y, Image sprite)
	{
		super(x, y, 80, 80);
		this.sprite = sprite;
	}
	
	public void pinta(Graphics g, Applet app)
	{
		g.drawImage(sprite, x, y, WIDTH, HEIGHT, app);
	}
	
	public void mueveLinea(List<Globo> globos)
	{
		this.x += xSpeed;
		for (int i = 0; i < globos.size(); i++)
			if (this.intersects(globos.get(i))) globos.remove(i);
	}
	
	public void mueveArco(List<Globo> globos)
	{
		x += 150; // 150 va fino
		y -= (int) (Math.sin(Math.toRadians(x * xAngulo)) * 100); //PARKINSON
		for (int i = 0; i < globos.size(); i++)
			if (this.intersects(globos.get(i))) globos.remove(i);
	}
}
