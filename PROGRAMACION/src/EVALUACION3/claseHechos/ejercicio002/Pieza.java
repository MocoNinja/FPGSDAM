package EVALUACION3.claseHechos.ejercicio002;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Pieza extends Rectangle
{
	static final int ANCHO = 50, ALTO = 50;
	Image fotoPieza;
	private  boolean dibujable = true, movible = true;
	
	public Pieza(int x, int y, Image fotoPieza)
	{
		super(x, y, ANCHO, ALTO);
		this.fotoPieza = fotoPieza;
	}
	
	public void dibuja(Graphics g, Applet app)
	{
		if (dibujable)
		{
			g.setColor(Color.BLACK);
			g.drawRect(x - 1, y - 1, width + 1, height + 1);
			g.drawImage(fotoPieza, this.x, this.y, ANCHO, ALTO, app);
		}
	}

	public void mueve(int x, int y)
	{
		if (movible)
		{
			this.x = x;
			this.y = y;
		}
		else
		{
			// No es conveniente eliminarlas porque se alterar�n los �ndices de la lista
			// Se mueven ah� por evitar cualquier tipo de incidencia no contemplada por clickar un objeto que no se ve
			this.x = 1000;
			this.y = 1000;
		}
	}
	
	public void kill()
	{
		dibujable = false;
		movible = false;
	}
}
