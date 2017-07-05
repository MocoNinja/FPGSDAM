package EVALUACION3.claseHechos.ejercicio008;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Carta extends Rectangle
{
	public static final int ROJO = 0, NEGRO = 1;
	public static final int PICAS = 0, DIAMANTES = 3, CORAZONES = 1, TREBOLES = 2;
	public static final int ANCHO = 150, ALTO = 217;
	
	Image imagen;
	Image reverso;
	private int valor;
	private int color;
	private int palo;
	Applet applet;
	
	public Carta(int valor, Applet applet, Image imagen, Image reverso, int palo)
	{
		super(-2000, -2000, ANCHO, ALTO);
		this.valor = valor;
		this.palo = palo;
		this.color = setColor();
		this.applet = applet;
		this.reverso = reverso;
		this.imagen = imagen;
	}

	public void setPalo(int nuevoPalo)
	{
		this.palo = nuevoPalo;
	}
	
	public int setColor()
	{
		if (this.palo == PICAS || this.palo == TREBOLES) return NEGRO;
		else return ROJO;
	}
	
	public int getColor()
	{
		return this.color;
	}
	
	public int getPalo()
	{
		return this.palo;
	}
	
	public int getValor()
	{
		return this.valor;
	}

	public void pinta(Graphics g)
	{
		g.drawImage(imagen, x, y, width, height, applet);
	}
}
