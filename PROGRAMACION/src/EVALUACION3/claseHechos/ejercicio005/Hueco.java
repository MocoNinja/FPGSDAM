package EVALUACION3.claseHechos.ejercicio005;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

public class Hueco
{
	Image[] figuras;
	Image imagen;
	int x, y;
	final int width = 50, height = 50;
	int fila, columna;
	boolean debugMode;
	int indiceImagen;
	Applet app;
	
	public Hueco(int fila, int columna, Image[] figuras, int indiceImagen, boolean debugMode, Applet app)
	{
		x = columna * width;
		y = fila * height;
		this.debugMode = debugMode;
		this.indiceImagen = indiceImagen;
		this.figuras = figuras;
		imagen = figuras[indiceImagen];
		this.app = app;
	}
	
	public void paint(Graphics g, Applet app)
	{
		if (imagen != null && !debugMode)
		{
			g.drawImage(imagen, x, y, width, height, app);
		}
		else
		{
			g.setColor(Color.BLACK);
			g.drawRect(x, y, width, height);
			g.setColor(Color.WHITE);
			g.fillRect(x, y, width, height);
		}
	}

	public int getIndiceImagen()
	{
	return indiceImagen;
	}
	
	public int getFila()
	{
	return fila;
	}

	public int getColumna()
	{
	return columna;
	}
	
	public void setImagen(int nuevoIndice)
	{
		indiceImagen = nuevoIndice;
		imagen = figuras[indiceImagen];
	}
	
	public void setImagen(Image nuevoFoto)
	{
		imagen = nuevoFoto;
	}
	
	public Image getImagen()
	{
	return imagen;
	}
	
	public Point getPoint()
	{
		Point point = new Point(x, y);
	return point;
	}
}