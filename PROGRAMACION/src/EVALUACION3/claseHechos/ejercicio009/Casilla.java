package EVALUACION3.claseHechos.ejercicio009;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;


public class Casilla extends Rectangle
{
	public static final int ANCHO = 98, ALTO = 98;
	private boolean visible = false;
	private boolean estatica = false;
	private Image imagen;
	private Image reverso;
	Applet applet;
	
	public Casilla(int x, int y, Image imagen, Image reverso, Applet applet)
	{
		super(x, y, ANCHO, ALTO);
		this.imagen = imagen;
		this.reverso = reverso;
		this.applet = applet;
	}
	
	public void paint(Graphics g)
	{
		if (visible) g.drawImage(imagen, this.x, this.y, width, height, applet);
		else g.drawImage(reverso, this.x, this.y, width, height, applet);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width - 2, height - 2);
	}
	
	public void girar()
	{
		visible = !visible;
	}
	
	public boolean isVisible()
	{
		return this.visible;
	}
	
	public Image getImage()
	{
		return this.imagen;
	}
	public boolean isEstatica()
	{
		return estatica;
	}
	public void setEstatica()
	{
		estatica = true;
	}

}
