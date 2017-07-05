package EVALUACION3.claseHechos.ejercicio003;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

	
public class Personaje extends Rectangle
{
	Image dibujar;
	Image[][] sprites;
	int tipo;
	int dibujando = 0;
	final int SIZE = 4;
	int x, y;
	final int ANCHO = 175, ALTO = 200;
	
	public Personaje(int tipo, Image[][] sprites, int x, int y)
	{
		this.sprites = sprites;
		this.tipo = tipo;
		this.x = x;
		this.y = y;
	}
	
	public void mueve()
	{
		x += 15;
	}
	public void pinta(Graphics g, Applet applet)
	{
		g.drawImage(sprites[tipo][dibujando], x, y, ANCHO, ALTO, applet);
		cambiaNumero();
	}
	
	public int getTipo()
	{
		return this.tipo;
	}
	
	public void cambiaNumero()
	{
		dibujando = (dibujando + 1) % SIZE;
	}

	public void setTipo(int nuevo)
	{
		tipo = nuevo;
	}
}
