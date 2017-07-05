package EVALUACION3.claseHechos.ejercicio007;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class Carta
{
	Applet app;
	private Image carta;
	private int valor;
	private int posX, posY;
	private int ancho, alto;
	public boolean esAce;
	
	public Carta(int valor, Applet app, Image carta, boolean esAce)
	{
		this.posY = -2000;
		this.posX = -2000;
		this.app = app;
		this.carta = carta;
		this.ancho = app.getWidth() / 4;
		this.alto = app.getHeight() / 2;
		this.valor = valor;
		this.esAce = esAce;
	}
	
	public void paint(Graphics g)
	{
		g.drawImage(carta, posX, posY, ancho, alto, app);
	}
	
	public void mueve(int x, int y)
	{
		this.posX = x;
		this.posY = y;
	}

	
	public int getValor()
	{
	return this.valor;
	}
}
