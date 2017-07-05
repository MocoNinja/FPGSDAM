package EVALUACION3.claseHechos.ejercicio006BIS;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Ficha extends Rectangle
{
	public static final int WIDTH = 35, HEIGHT = 35;
	int[] valores = {1,2,5,10,20,25,50,100,250,500,1000,2000,5000};
	
	private int valor;
	private int indice;
	Image sprite;
	Image[] fichas;
	Image ficha;
	
	public Ficha(Image[] fichas, int indice, int x, int y)
	{
		super(x, y + indice * (25 + HEIGHT), WIDTH, HEIGHT);
		this.fichas = fichas;
		this.indice = indice;
		this.ficha = this.fichas[indice];
		this.valor = valores[indice];
	}
	
	public void restarDinero()
	{
		App.subDinero(this.valor);
	}
	public void paint(Graphics g, Applet app)
	{
		g.drawImage(ficha, this.x, this.y, this.width, this.height, app);
	}
	
	public int getIndex()
	{
	return indice;
	}
	
	public int getValor()
	{
	return valor;
	}
}
