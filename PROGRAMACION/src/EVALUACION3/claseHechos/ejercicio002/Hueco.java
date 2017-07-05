package EVALUACION3.claseHechos.ejercicio002;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

public class Hueco extends Rectangle
{
	static final int ANCHO = 60, ALTO = 60;
	Image fotoHueco;
	private  boolean dibujable = false;
	
	public Hueco(int x, int y, Image fotoHueco)
	{
		super(x, y, ANCHO, ALTO);
		this.fotoHueco = fotoHueco;
	}
	
	public void dibuja(Graphics g, Applet app)
	{
//		g.setColor(Color.RED);
//		g.drawRect(x - 1, y - 1, width + 1, height + 1);
		if (dibujable) g.drawImage(fotoHueco, this.x, this.y, ANCHO, ALTO, app);
	}
	
	public boolean contienePieza(Pieza pieza)
	{
		if (this.intersects(pieza)) return true;
	return false;
	}
	
	public void dibujable()
	{
		dibujable = true;
	}
}
